DROP TABLE IF EXISTS user_organisation, user, organisation;
 
CREATE TABLE USER (
  id             INT          NOT NULL PRIMARY KEY,
  first_name     VARCHAR(50),
  last_name      VARCHAR(50)  NOT NULL
);
 
CREATE TABLE ORGANISATION (
  id             INT          NOT NULL PRIMARY KEY,
  name          VARCHAR(100) NOT NULL
);
 
CREATE TABLE user_organisation (
  user_id      INT          NOT NULL,
  organisation_id        INT          NOT NULL,
   
  PRIMARY KEY (user_id, organisation_id),
  CONSTRAINT fk_ab_user FOREIGN KEY (user_id)  REFERENCES user (id)
    ON UPDATE CASCADE ON DELETE CASCADE,
  CONSTRAINT fk_ab_organisation FOREIGN KEY (organisation_id)    REFERENCES organisation (id)
);
 
INSERT INTO user VALUES
  (1, 'Kathy', 'Sierra'), 
  (2, 'Bert', 'Bates'), 
  (3, 'Bryan', 'Basham');
 
INSERT INTO organisation VALUES
  (1, 'first Organisation test name'),
  (2, 'second Organisation test name'),
  (3, 'third Organisation test name');

INSERT INTO user_organisation VALUES (1, 1), (1, 3), (2, 1);