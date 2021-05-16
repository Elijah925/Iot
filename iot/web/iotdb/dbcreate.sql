
ALTER TABLE ACCESSLOG_T DROP CONSTRAINT ACCESSLOG_FK;
DROP TABLE ACCESSLOG_T;
DROP TABLE USER_T;


CREATE TABLE USER_T (
    UserID INTEGER NOT NULL GENERATED ALWAYS AS IDENTITY(START WITH 1,  INCREMENT BY 1),
    UserEmail VARCHAR(100) NOT NULL,
    UserName VARCHAR(50) NOT NULL,
    Password VARCHAR(100) NOT NULL,
    PhoneNumber VARCHAR(15),
    IsStaff BOOLEAN,
    CONSTRAINT USER_PK PRIMARY KEY (UserID)
);

CREATE TABLE ACCESSLOG_T (
    AccessLogID INTEGER NOT NULL GENERATED ALWAYS AS IDENTITY(START WITH 1,  INCREMENT BY 1),
    UserID INTEGER NOT NULL,
    LogEventTime TIMESTAMP NOT NULL,
    LogEvent VARCHAR(20) NOT NULL,
    CONSTRAINT ACCESSLOG_PK PRIMARY KEY (AccessLogID),
    CONSTRAINT ACCESSLOG_FK FOREIGN KEY (UserID) REFERENCES USER_T(UserID) ON DELETE CASCADE
);

INSERT INTO USER_T(UserEmail, UserName, Password, PhoneNumber, IsStaff) VALUES
('admin@admin.com', 'admin', 'admin', '0451000000', TRUE),
('staff1@staff.com', 'staff1', 'staff1', '0451000001', TRUE);

INSERT INTO ACCESSLOG_T(UserID, LogEventTime, LogEvent) VALUES 
(1, '2020-05-12 10:52:12', 'User Logged In'),
(1, '2020-05-12 10:54:32', 'User Logged In'),
(2, '2020-05-12 11:42:39', 'User Logged In');