package com.sight.archunitstart;

import com.sight.archunitstart.config.ArchitectureTest;
import com.tngtech.archunit.core.domain.JavaAnnotation;
import com.tngtech.archunit.core.domain.JavaClass;
import com.tngtech.archunit.core.domain.JavaMethod;
import com.tngtech.archunit.lang.ArchCondition;
import com.tngtech.archunit.lang.ArchRule;
import com.tngtech.archunit.lang.ConditionEvents;
import com.tngtech.archunit.lang.SimpleConditionEvent;
import com.tngtech.archunit.lang.syntax.ArchRuleDefinition;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Arrays;
import java.util.List;
import java.util.Set;

class ControllerArchUnitTest extends ArchitectureTest {

    @Test
    @DisplayName("""
            Controller에서 상속된 DTO를 리턴하는것을 금지한다.
            - 필드 재사용을 위한 DTO 상속은 LSP 원칙에 위배됩니다. 상속을 제거해주세요.
            """)
    void 컨트롤러_상속된_DTO_리턴_금지() {
        ArchRule rule = ArchRuleDefinition.methods().that()
                .areDeclaredInClassesThat()
                .areAnnotatedWith(RestController.class).or()
                .areAnnotatedWith(Controller.class)
                .should(상속된_DTO_리턴_금지());
        rule.check(classes);
    }

    private ArchCondition<JavaMethod> 상속된_DTO_리턴_금지() {
        return new ArchCondition<>("Controller에서 상속된 DTO를 리턴하면 안됩니다.") {
            @Override
            public void check(JavaMethod method, ConditionEvents conditionEvents) {
                JavaClass returnType = method.getRawReturnType();
                returnType.getSuperclass()
                        .filter(superClass -> !superClass.getName().equals(Object.class.getName()))
                        .ifPresent(superclasses -> {
                                    String message = """
                                            %s#%s에서 상속된 클래스를 리턴하고 있습니다. 다음 클래스를 상속받고 있음 [%s]
                                            """.formatted(
                                            method.getOwner().getFullName(),
                                            method.getName(),
                                            String.join(", ", superclasses.getName())
                                    );
                                    conditionEvents.add(SimpleConditionEvent.violated(method, message));
                                }
                        );
            }
        };
    }

    @Test
    @DisplayName("""
            Controller에서 URL에서는 케밥케이스만 사용한다.
            - 스네이크와 카멜케이스 모두 사용하지 않는다.
            """)
    void 컨트롤러의_URL에서_카멜케이스_사용금지() {
        ArchRule rule = ArchRuleDefinition.methods()
                .that().areMetaAnnotatedWith(RequestMapping.class)
                .and()
                    .areDeclaredInClassesThat()
                    .areAnnotatedWith(RestController.class).or()
                    .areAnnotatedWith(Controller.class)
                .should(URL에_카멜케이스_스네이크케이스_사용금지());
        rule.check(classes);
    }

    private ArchCondition<JavaMethod> URL에_카멜케이스_스네이크케이스_사용금지() {
        return new ArchCondition<>("Controller에서 URL에 카멜케이스를 사용하지 않는다.") {
            @Override
            public void check(JavaMethod method, ConditionEvents conditionEvents) {
                Set<JavaAnnotation<JavaMethod>> annotations = method.getAnnotations();
                RequestMapping requestMapping = method.getAnnotationOfType(RequestMapping.class);
                List<String> mappedUrlList = Arrays.asList(requestMapping.value());

                boolean hasInvalidCase = mappedUrlList.stream()
                        .anyMatch(url -> isCamelCase(url) || isSnakeCase(url));

                if (hasInvalidCase) {
                    String message = """
                            [%s 클래스] 내에 있는 [%s 메서드] 는 케밥케이스를 사용하고 있지 않습니다. URL: %s
                            """.formatted(
                            method.getName(),
                            method.getOwner().getFullName(),
                            mappedUrlList
                    );
                    conditionEvents.add(SimpleConditionEvent.violated(method, message));
                }
            }
        };
    }

    private boolean isCamelCase(String value) {
        return value.matches("^[a-z]+([A-Z][a-z]*)*$");
    }

    public boolean isSnakeCase(String str) {
        return str.matches("^[a-z]+(_[a-z]+)*$");
    }
}
