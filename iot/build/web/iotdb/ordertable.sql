CREATE TABLE "ORDERS"(
    ORDERID INTEGER NOT NULL GENERATED ALWAYS AS IDENTITY(START WITH 1, INCREMENT BY 1),
    DEVICEID INTEGER NOT NULL,
    USERID INTEGER NOT NULL,
    PAYMENTID INTEGER NOT NULL,
    "DATE" VARCHAR(255) NOT NULL,
    DELIVERYDATE VARCHAR(255) NOT NULL,
    DELIVERYWAY VARCHAR(255) NOT NULL,
    PRIMARY KEY(ORDERID)
);