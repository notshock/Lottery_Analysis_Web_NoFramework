----------------------------------------------------------------------------------------------------------------------------
alter session set deferred_segment_creation=false;
DROP table memBigLottoRecord;
DROP TABLE bigLottoRecord;
DROP TABLE memberPlayingList;
DROP TABLE gamelist;
DROP TABLE memberlist;

DROP SEQUENCE memberlist_seq;
DROP SEQUENCE gamelist_seq;
drop Sequence memBigLottoRecord_seq;

-------------------------------------
-----------------1--------------------
CREATE TABLE memberlist (
    memNo varchar2(50), --M0001
    memAccount VARCHAR2(20) UNIQUE not null,
    memPassword VARCHAR2(20) not null,
    memPasswordHint varchar2(50),
    CONSTRAINT memberlist_PRIMARY_KEY PRIMARY KEY (memNo)
);
 
CREATE SEQUENCE memberlist_seq
INCREMENT BY 1
START WITH 1
MAXVALUE 9999
NOCYCLE
NOCACHE;

INSERT INTO memberlist VALUES ('M'||LPAD(TO_CHAR(memberlist_seq.NEXTVAL),4,'0'),'Samuel','123456','123456');
-------------------------------------
----------------2---------------------
CREATE TABLE  gamelist(
    gameNo varchar2(50), --G0001
    gameName VARCHAR2(4000) not null,
    lotteryTableName varchar2(4000) not null,
    memLotteryTableName varchar2(4000) not null,
    memLotteryTableNameSequence varchar2(4000) not null,
    CONSTRAINT gamelist_PK PRIMARY KEY (gameNo)
);
 
CREATE SEQUENCE gamelist_seq
INCREMENT BY 1
START WITH 1
MAXVALUE 9999
NOCYCLE
NOCACHE;

Insert into gamelist values('G'||LPAD(TO_CHAR(gamelist_seq.Nextval),4,'0'),'大樂透',
    'BigLottoRecord','MemBigLottoRecord','memBigLottoRecord_seq');
-------------------------------------
---------------3----------------------
Create table memberplayinglist(
    memNo varchar2(50), --M0001
    gameNo varchar2(50), --G0001
    CONSTRAINT memberPlayingList_PK PRIMARY KEY (memNo,gameNo),
    CONSTRAINT memberPlayingList_FK1 FOREIGN KEY (memNo) REFERENCES memberlist(memNo),
    CONSTRAINT memberPlayingList_FK2 FOREIGN KEY (gameNo) REFERENCES gamelist(gameNo)
);
-------------------------------------
---------------4----------------------
Create table biglottorecord(
    gameRecordNo VARCHAR2(9), --108000022
    gameNo varchar2(50), ---G0001
    gameLotteryDate date not null, --108/02/19
    number1 number(2) not null,
    number2 number(2) not null,
    number3 number(2) not null,
    number4 number(2) not null,
    number5 number(2) not null,
    number6 number(2) not null,
    specialNumber number(2) not null,
    CONSTRAINT bigLottoRecord_PK PRIMARY KEY (gameRecordNo),
    CONSTRAINT bigLottoRecord_FK1 FOREIGN KEY (gameNo) REFERENCES gamelist(gameNo)
);
-------------------------------------
---------------5----------------------
Create table memBigLottoRecord(
    recordNo Number,
    memNo varchar2(50) not null, --M0001
    gameNo varchar2(50) not null, --G0001
    number1 number(2) not null,
    number2 number(2) not null,
    number3 number(2) not null,
    number4 number(2) not null,
    number5 number(2) not null,
    number6 number(2) not null,
    writeDate timestamp not null, -- 
    bingoState varchar(400), -- 
    CONSTRAINT memBigLottoRecord_PK PRIMARY KEY (recordNo),
    CONSTRAINT memBigLottoRecord_FK1 FOREIGN KEY (memNo) REFERENCES memberlist(memNo),
    CONSTRAINT memBigLottoRecord_FK2 FOREIGN KEY (gameNo) REFERENCES gamelist(gameNo)
);
CREATE SEQUENCE memBigLottoRecord_seq
INCREMENT BY 1
START WITH 1
NOMAXVALUE
NOCYCLE
NOCACHE;

commit;
----------------------------------------------------------------------------------------------------------------------------