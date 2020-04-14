DROP TABLE IF EXISTS USER_TO_ORGANISATION, USER_DATA, ORGANISATION CASCADE;

CREATE EXTENSION IF NOT EXISTS "uuid-ossp";

CREATE TABLE USER_DATA
(
    id         uuid PRIMARY KEY DEFAULT uuid_generate_v4(),
    first_name VARCHAR(50) NOT NULL,
    last_name  VARCHAR(50) NOT NULL
);

CREATE TABLE ORGANISATION
(
    id   uuid PRIMARY KEY DEFAULT uuid_generate_v4(),
    name VARCHAR(100) NOT NULL
);

CREATE TABLE USER_TO_ORGANISATION
(
    user_id         uuid NOT NULL,
    organisation_id uuid NOT NULL,

    PRIMARY KEY (user_id, organisation_id),
    CONSTRAINT fk_ab_user FOREIGN KEY (user_id) REFERENCES USER_DATA (id) ON UPDATE CASCADE ON DELETE CASCADE,
    CONSTRAINT fk_ab_organisation FOREIGN KEY (organisation_id) REFERENCES organisation (id) ON UPDATE CASCADE ON DELETE CASCADE
);

INSERT INTO USER_DATA
VALUES ('d84a13e7-68ab-463b-ab44-2b6e92489ede', 'Kathy', 'Sierra'),
       ('ac555394-c1c1-4c95-8dca-665943f44f1b', 'Bert', 'Bates'),
       ('277f994b-3fa2-4f35-ada3-4759708ec825', 'Bryan', 'Basham');

INSERT INTO ORGANISATION
VALUES ('8f7d929b-928b-491c-8ad0-de34ec9bc93f', 'first Organisation test name'),
       ('06b685e3-7ac1-4c2f-b041-e5f321b95372', 'second Organisation test name'),
       ('056efea8-afb9-443f-9946-4c2176dd2036', 'third Organisation test name');

INSERT INTO USER_TO_ORGANISATION
VALUES ('d84a13e7-68ab-463b-ab44-2b6e92489ede', '8f7d929b-928b-491c-8ad0-de34ec9bc93f'),
       ('d84a13e7-68ab-463b-ab44-2b6e92489ede', '056efea8-afb9-443f-9946-4c2176dd2036'),
       ('ac555394-c1c1-4c95-8dca-665943f44f1b', '8f7d929b-928b-491c-8ad0-de34ec9bc93f');