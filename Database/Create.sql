CREATE SEQUENCE TRAVEL_NOTE_ID_GENERATOR;
CREATE SEQUENCE TRANSFER_ID_GENERATOR;
CREATE SEQUENCE BOOK_ID_GENERATOR;
CREATE SEQUENCE MOVE_ID_GENERATOR;
CREATE SEQUENCE TRAVEL_ID_GENERATOR;
CREATE SEQUENCE MOVE_NOTE_ID_GENERATOR;

CREATE TABLE TRAVELS(
    ID VARCHAR(64) DEFAULT TRAVEL_ID_GENERATOR.NEXTVAL PRIMARY KEY,
    NAME VARCHAR(128)
);

CREATE TABLE TRAVEL_NOTES(
ID VARCHAR(64) DEFAULT TRAVEL_NOTE_ID_GENERATOR.NEXTVAL PRIMARY KEY,
TRAVEL_ID VARCHAR(64) NOT NULL,
TITLE VARCHAR(128),
TEXT VARCHAR(2048),
FOREIGN KEY (TRAVEL_ID) REFERENCES TRAVELS (ID) ON DELETE CASCADE,
);

CREATE TABLE TRANSFERS(
    ID INTEGER DEFAULT TRANSFER_ID_GENERATOR.NEXTVAL PRIMARY KEY,
    NAME VARCHAR(128)
);

CREATE TABLE MOVES (
ID VARCHAR(64) DEFAULT MOVE_ID_GENERATOR.NEXTVAL PRIMARY KEY,
TRAVEL_ID VARCHAR(64) NOT NULL,
TRANSFER_ID INTEGER NOT NULL,
FROM_PLACE  VARCHAR(512),
TO_PLACE VARCHAR(512),
FROM_DATE DATE,
TO_DATE DATE,
DISTANCE DOUBLE PRECISION,
MONEY DECIMAL,
FOREIGN KEY (TRAVEL_ID) REFERENCES TRAVELS (ID) ON DELETE CASCADE,
FOREIGN KEY (TRANSFER_ID) REFERENCES TRANSFERS (ID) ON DELETE CASCADE
);

CREATE TABLE MOVE_NOTES (
    ID VARCHAR(64) DEFAULT MOVE_NOTE_ID_GENERATOR.NEXTVAL PRIMARY KEY,
    MOVE_ID VARCHAR(64) NOT NULL,
    TITLE VARCHAR(128),
    TEXT VARCHAR(2048),
    FOREIGN KEY (MOVE_ID) REFERENCES MOVES (ID) ON DELETE CASCADE,
);

INSERT INTO TRANSFERS (NAME) VALUES ('Автомобиль');
INSERT INTO TRANSFERS (NAME) VALUES ('Общественный транспорт');
INSERT INTO TRANSFERS (NAME) VALUES ('Самолёт');
INSERT INTO TRANSFERS (NAME) VALUES ('Поезд');
INSERT INTO TRANSFERS (NAME) VALUES ('Пешком');
INSERT INTO TRANSFERS (NAME) VALUES ('Другое');