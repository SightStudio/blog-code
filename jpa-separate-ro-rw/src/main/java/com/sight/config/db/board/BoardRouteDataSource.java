package com.sight.config.db.board;

import com.sight.config.db.DataSourceRole;
import org.springframework.jdbc.datasource.lookup.AbstractRoutingDataSource;
import org.springframework.transaction.support.TransactionSynchronizationManager;

public class BoardRouteDataSource extends AbstractRoutingDataSource {

    @Override
    protected Object determineCurrentLookupKey() {
        return TransactionSynchronizationManager.isCurrentTransactionReadOnly()
                ? DataSourceRole.READ_ONLY : DataSourceRole.READ_WRITE;
    }
}