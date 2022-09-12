package com.sight.application.app.domain.board.user;

import com.sight.application.config.jooq.BaseJooqRepository;
import com.sight.entity.AppUser;
import com.sight.application.dto.UserRegisterRequest;
import jooq.jooq_dsl.tables.JAppUser;
import lombok.RequiredArgsConstructor;
import org.jooq.DSLContext;
import org.jooq.impl.DSL;
import org.springframework.stereotype.Repository;
import org.springframework.util.CollectionUtils;

import java.util.List;
import java.util.stream.Collectors;

@Repository
@RequiredArgsConstructor
public class UserRepository implements BaseJooqRepository {

    private final DSLContext dsl;

    public int bulkRegisterUser(List<UserRegisterRequest> userList) {
        final JAppUser user = JAppUser.APP_USER;

        if(CollectionUtils.isEmpty(userList)) {
            return 0;
        }

        var insertRows = userList.stream()
                .map(request -> DSL.row(
                        request.getUserId(),
                        request.getUserName()
                ))
                .collect(Collectors.toList());

        return dsl.insertInto(
                    user,
                    user.USER_ID,
                    user.USER_NAME
                ).valuesOfRows(insertRows)
                .execute();
    }

    public List<AppUser> findAll() {
        final JAppUser user = JAppUser.APP_USER;

        return dsl.select(
                    user.USER_SEQ,
                    user.USER_ID,
                    user.USER_NAME
                ).from(user)
                .fetchInto(AppUser.class);
    }
}
