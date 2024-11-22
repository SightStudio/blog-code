package com.sight.archunitstart;

import com.sight.archunitstart.config.ArchitectureTest;
import com.tngtech.archunit.lang.ArchRule;
import com.tngtech.archunit.lang.syntax.ArchRuleDefinition;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class ProjectArchitectureTest extends ArchitectureTest {

    private static final String 모델_패키지 = "..domain..*..model..";
    private static final String 인프라_스트럭처_파사드_postfix = "InfraManager";

    @Test
    @DisplayName("""
           인프라스트럭처 파사드를 제외하면 서비스가 모델패키지를 직접적으로 참조 할 수 없다.
           - JpaRepository, DAO 등등 인프라와 관련된 클래스는 인프라스트럭처 파사드를 통해서만 접근해야한다.
           """)
    void 인프라스트럭처_구조_검증() {
        ArchRule rule = ArchRuleDefinition.noClasses()
                .that().resideInAPackage("..service..")
                .should().dependOnClassesThat().resideInAPackage(모델_패키지)
                .andShould().dependOnClassesThat().haveSimpleNameNotEndingWith(인프라_스트럭처_파사드_postfix)
                .because("인프라스트럭처 파사드를 제외하면 서비스가 모델패키지를 직접적으로 참조 할 수 없습니다.");

        rule.check(classes);
    }
}
