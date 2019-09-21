package com.example.demo.entity.jooq;

import org.jooq.impl.TableImpl;

import javax.persistence.*;
import java.util.List;
import java.util.UUID;

public class Organisation {

    public static final Organisation ORGANISATION = new Organisation();
    private UUID id;
    private String name;
}
