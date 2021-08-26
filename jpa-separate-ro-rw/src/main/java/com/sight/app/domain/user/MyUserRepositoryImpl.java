package com.sight.app.domain.user;

import com.sight.config.db.BaseDataSourceConfig;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.support.QuerydslRepositorySupport;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

public class MyUserRepositoryImpl extends QuerydslRepositorySupport implements MyUserRepositoryCustom {

    public MyUserRepositoryImpl() {
        super(MyUser.class);
    }

    @Override
    @PersistenceContext(unitName = BaseDataSourceConfig.USER)
    public void setEntityManager(EntityManager entityManager) {
        super.setEntityManager(entityManager);
    }

    @Modifying(clearAutomatically = true)
    public void clearCache(MyUser myUser) {
        getEntityManager().refresh(myUser);
        getEntityManager().flush();
        getEntityManager().clear();
    }
}
