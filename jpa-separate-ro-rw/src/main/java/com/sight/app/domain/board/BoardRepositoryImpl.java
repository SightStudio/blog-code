package com.sight.app.domain.board;

import com.sight.config.db.BaseDataSourceConfig;
import org.springframework.data.jpa.repository.support.QuerydslRepositorySupport;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

public class BoardRepositoryImpl extends QuerydslRepositorySupport implements BoardRepositoryCustom {

    public BoardRepositoryImpl() {
        super(Board.class);
    }

    @Override
    @PersistenceContext(unitName = BaseDataSourceConfig.BOARD)
    public void setEntityManager(EntityManager entityManager) {
        super.setEntityManager(entityManager);
    }
}
