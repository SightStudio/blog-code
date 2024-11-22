package com.sight.archunitstart;

import com.sight.archunitstart.config.ArchitectureTest;
import com.tngtech.archunit.lang.ArchRule;
import com.tngtech.archunit.lang.syntax.ArchRuleDefinition;
import jakarta.persistence.Embeddable;
import jakarta.persistence.Entity;
import jakarta.persistence.MappedSuperclass;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

@DisplayName("프로젝트 폴더구조 확인")
class DddDirectoryTest extends ArchitectureTest {

    private static final String 모델_패키지 = "..domain..*..model..";

    @Test
    @DisplayName("도메인과 연관된 엔티티들은 model 패키지에만 존재해야 한다.")
    void 모델_패키지_구조_확인() {
        ArchRule rule = ArchRuleDefinition.classes().that()
                .areAnnotatedWith(Entity.class).or()
                .areAnnotatedWith(Embeddable.class).or()
                .areAnnotatedWith(MappedSuperclass.class)
                .should()
                .resideInAPackage(모델_패키지);

        rule.check(classes);
    }

    @Test
    @DisplayName("도메인과 연관된 엔티티들의 repository들 또한 model 패키지에만 존재해야 한다.")
    void jpaRepositoriesShouldOnlyExistInModelPackage() {
        // areAssignableTo => 특정 클래스 또는 인터페이스를 상속하거나 구현하는 클래스들을 식별
        ArchRule rule = ArchRuleDefinition.classes().that()
                .areAssignableTo(org.springframework.data.repository.Repository.class)
                .should()
                .resideInAPackage(모델_패키지);

        rule.check(classes);
    }
}
