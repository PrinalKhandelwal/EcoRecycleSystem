-- Table: ITEM
CREATE TABLE ITEM ( 
    id     INTEGER        PRIMARY KEY AUTOINCREMENT
                          NOT NULL
                          UNIQUE,
    name   VARCHAR( 25 ),
    price  VARCHAR( 45 ),
    weight VARCHAR( 45 ),
    type   VARCHAR( 25 ) 
);

INSERT INTO [ITEM] ([id], [name], [price], [weight], [type]) VALUES (1, 'coke bottle', 1.99, 7.88, 'plastic');
INSERT INTO [ITEM] ([id], [name], [price], [weight], [type]) VALUES (2, 'newspaper', 0.99, 1, 'paper');
INSERT INTO [ITEM] ([id], [name], [price], [weight], [type]) VALUES (4, 'coke tin', 1.85, 6.55, 'aluminium');

-- Table: LOGIN
CREATE TABLE LOGIN ( 
    id       INTEGER        PRIMARY KEY AUTOINCREMENT,
    username VARCHAR( 12 ),
    password VARCHAR( 12 )  NOT NULL 
);

INSERT INTO [LOGIN] ([id], [username], [password]) VALUES (1, 'admin', 'pass');

-- Table: RCM_GROUP
CREATE TABLE RCM_GROUP ( 
    machine_id          INTEGER        PRIMARY KEY AUTOINCREMENT
                                       NOT NULL,
    group_id            INTEGER        NOT NULL,
    op_status           CHAR( 1 ),
    location            VARCHAR( 12 ),
    time_last_activated DATETIME,
    max_capacity        VARCHAR( 30 ),
    cash_default_amount VARCHAR( 30 ) 
);

INSERT INTO [RCM_GROUP] ([machine_id], [group_id], [op_status], [location], [time_last_activated], [max_capacity], [cash_default_amount]) VALUES (1, 1, 'X', 'benson', null, 5000, 1000);
INSERT INTO [RCM_GROUP] ([machine_id], [group_id], [op_status], [location], [time_last_activated], [max_capacity], [cash_default_amount]) VALUES (2, 1, 'X', 'artG', null, 5000, 500);
INSERT INTO [RCM_GROUP] ([machine_id], [group_id], [op_status], [location], [time_last_activated], [max_capacity], [cash_default_amount]) VALUES (3, 1, 'X', 'oconnor', null, 2500, 1000);

-- Table: USER_TRANSACTION
CREATE TABLE USER_TRANSACTION ( 
    transaction_id     INTEGER        PRIMARY KEY AUTOINCREMENT
                                      UNIQUE,
    machine_id         INTEGER        REFERENCES RCM_GROUP ( machine_id ),
    num_items_inserted INTEGER,
    total_weight       VARCHAR( 20 ),
    cash_val_issued    VARCHAR( 25 ),
    coupon_val_issued  VARCHAR( 25 ),
    time_updated       DATETIME 
);


-- Table: RCM_CONSOLIDATION
CREATE TABLE RCM_CONSOLIDATION ( 
    event_id          INTEGER  PRIMARY KEY AUTOINCREMENT,
    machine_id                 REFERENCES RCM_GROUP ( machine_id ),
    time_last_emptied DATETIME,
    items_returned    INTEGER,
    total_val_issued  VARCHAR 
);


-- Table: RCM_ITEMS
CREATE TABLE RCM_ITEMS ( 
    machine_id INTEGER         REFERENCES RCM_GROUP ( machine_id ),
    item_list  VARCHAR( 100 ) 
);

INSERT INTO [RCM_ITEMS] ([machine_id], [item_list]) VALUES (1, '1,4');
INSERT INTO [RCM_ITEMS] ([machine_id], [item_list]) VALUES (2, '2');
INSERT INTO [RCM_ITEMS] ([machine_id], [item_list]) VALUES (3, '2,4');