package com.sight.app.domain.board;

import com.sight.config.db.BaseDataSourceConfig;
import com.sight.config.db.board.BoardDataSourceConfig;
import com.sight.config.db.board.BoardDatabaseConfig;
import com.sight.config.db.board.BoardRouteDataSource;
import org.springframework.data.jpa.repository.support.QuerydslRepositorySupport;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

public class BoardRepositoryImpl extends QuerydslRepositorySupport implements BoardRepositoryCustom {

    public BoardRepositoryImpl() {
        super(Board.class);
    }

    @Override
    @PersistenceContext(unitName = BoardDatabaseConfig.SCHEMA_NAME)
    public void setEntityManager(EntityManager entityManager) {
        super.setEntityManager(entityManager);
    }
}
