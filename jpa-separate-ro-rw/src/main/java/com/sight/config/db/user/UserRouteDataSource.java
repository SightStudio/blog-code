package com.sight.config.db.user;

import com.sight.config.db.DataSourceRole;
import org.springframework.jdbc.datasource.lookup.AbstractRoutingDataSource;
import org.springframework.transaction.support.TransactionSynchronizationManager;

public class UserRouteDataSource extends AbstractRoutingDataSource {

    @Override
    protected Object determineCurrentLookupKey() {
        boolean currentTransactionReadOnly = TransactionSynchronizationManager.isCurrentTransactionReadOnly();
        return currentTransactionReadOnly ? DataSourceRole.READ_ONLY : DataSourceRole.READ_WRITE;
    }
}
