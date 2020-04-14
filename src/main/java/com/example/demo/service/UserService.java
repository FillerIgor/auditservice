package com.example.demo.service;

import com.example.demo.dto.UserDto;
import jooq.tables.UserData;
import jooq.tables.records.UserDataRecord;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.jooq.DSLContext;
import org.jooq.InsertResultStep;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Slf4j
@Service
@RequiredArgsConstructor
public class UserService {

    private static final UserData USER_DATA = UserData.USER_DATA;
    private final DSLContext dsl;

    public List<UserData> getUsers() {
        return dsl.select().from(USER_DATA).fetch().into(UserData.class);
    }

    public UserData getUserById(UUID id) {
        return dsl.select()
                .from(USER_DATA)
                .where(USER_DATA.ID.eq(id))
                .fetchOne()
                .into(UserData.class);
    }

    public UUID createUser(UserDto user) {
        final InsertResultStep<UserDataRecord> result = dsl.insertInto(USER_DATA)
                .set(USER_DATA.FIRST_NAME, user.getFirstName())
                .set(USER_DATA.LAST_NAME, user.getLastName())
                .returning();
        result
                .execute();
        final UserDataRecord savedUser = result.fetchOne();
        log.debug("Created user with ID: {}", savedUser.getId());
        return savedUser.getId();
    }

    public UUID updateUser(UserDto user) {
        final UUID id = UUID.fromString(user.getId());
        final int numberOfUpdatedUsers = dsl.update(USER_DATA)
                .set(USER_DATA.FIRST_NAME, user.getFirstName())
                .set(USER_DATA.LAST_NAME, user.getFirstName())
                .where(USER_DATA.ID.eq(id))
                .execute();
        log.debug("{} Users have been updated", numberOfUpdatedUsers);
        return id;
    }

    public UUID deleteUserById(String uuid) {
        final UUID id = UUID.fromString(uuid);
        final int numberOfDeletedUsers = dsl.deleteFrom(USER_DATA)
                .where(USER_DATA.ID.eq(id))
                .execute();
        log.debug("{} Users have been deleted", numberOfDeletedUsers);
        return id;
    }
}
