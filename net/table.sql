CREATE TABLE tblRegister(
 id VARCHAR(20) PRIMARY KEY,
 pwd CHAR(20) NOT NULL,
 name CHAR(20) NOT NULL,
 regdate DATETIME  DEFAULT NOW()
)

insert into tblRegister
values('aaa', '1234', 'È«±æµ¿', NOW());

insert into tblRegister
values('bbb', '1234', '°­µµÃ¢', NOW());

insert into tblRegister
values('ccc', '1234', '¿ÀÁöÇõ', NOW());


CREATE TABLE tblMessage(
 no INT AUTO_INCREMENT PRIMARY KEY,
 fid VARCHAR(20) NOT  NULL,
 tid VARCHAR(20) NOT  NULL,
 msg VARCHAR(50) NOT  NULL,
 mdate timestamp DEFAULT NOW()
);
