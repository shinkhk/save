create table tblMember(
	 id number primary key,
	 name varchar2(20) not null,
	 phone varchar2(20) not null,
	 address varchar2(70) not null,
	 team varchar2(20) not null
);

create SEQUENCE mem_seq;

create table tblZipcode(
	 zipcode varchar2(5) not null,
	 area1 varchar2(20),
	 area2 varchar2(20),
	 area3 varchar2(40)
);