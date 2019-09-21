package com.example.demo.entity.jooq;

import org.jooq.Name;
import org.jooq.impl.TableImpl;

public class UserToOrganisation {

    public static final UserToOrganisation USER_TO_ORGANISATION = new UserToOrganisation();

    private Long userId;
    private Long organisationId;
}
