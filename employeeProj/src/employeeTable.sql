
/* Drop Tables */

DROP TABLE authorities CASCADE CONSTRAINTS;
DROP TABLE imgTable CASCADE CONSTRAINTS;
DROP TABLE empList CASCADE CONSTRAINTS;
DROP TABLE payfor CASCADE CONSTRAINTS;
DROP TABLE department CASCADE CONSTRAINTS;
DROP TABLE position CASCADE CONSTRAINTS;
DROP TABLE region CASCADE CONSTRAINTS;
DROP TABLE userInfo CASCADE CONSTRAINTS;




/* Create Tables */

CREATE TABLE authorities
(
	authNum number NOT NULL,
	userId varchar2(50) NOT NULL,
	authority varchar2(20) NOT NULL,
	PRIMARY KEY (authNum)
);


CREATE TABLE department
(
	deptNum number NOT NULL,
	deptName varchar2(30) NOT NULL,
	PRIMARY KEY (deptNum)
);


CREATE TABLE empList
(
	empNum number NOT NULL,
	userId varchar2(50) NOT NULL,
	empName varchar2(40) NOT NULL,
	ppNum number NOT NULL,
	deptNum number NOT NULL,
	empBirth date NOT NULL,
	solarlunar number,
	regionNum number NOT NULL,
	contactAdress varchar2(20) NOT NULL,
	basepay number NOT NULL,
	bonus number,
	joindate number NOT NULL,
	PRIMARY KEY (empNum)
);


CREATE TABLE imgTable
(
	imgNum number NOT NULL,
	empNum number NOT NULL,
	img varchar2(50),
	PRIMARY KEY (imgNum)
);


CREATE TABLE payfor
(
	payNum number NOT NULL,
	deptNum number NOT NULL,
	ppNum number NOT NULL,
	basepay number NOT NULL,
	PRIMARY KEY (payNum)
);


CREATE TABLE position
(
	ppNum number NOT NULL,
	ppName varchar2(20) NOT NULL,
	PRIMARY KEY (ppNum)
);


CREATE TABLE region
(
	regionNum number NOT NULL,
	regionName varchar2(30) NOT NULL,
	PRIMARY KEY (regionNum)
);


CREATE TABLE userInfo
(
	userId varchar2(50) NOT NULL,
	userPassword varchar2(50) NOT NULL,
	enabled number,
	PRIMARY KEY (userId)
);



/* Create Foreign Keys */

ALTER TABLE empList
	ADD FOREIGN KEY (deptNum)
	REFERENCES department (deptNum)
;


ALTER TABLE payfor
	ADD FOREIGN KEY (deptNum)
	REFERENCES department (deptNum)
;


ALTER TABLE imgTable
	ADD FOREIGN KEY (empNum)
	REFERENCES empList (empNum)
;


ALTER TABLE empList
	ADD FOREIGN KEY (ppNum)
	REFERENCES position (ppNum)
;


ALTER TABLE payfor
	ADD FOREIGN KEY (ppNum)
	REFERENCES position (ppNum)
;


ALTER TABLE empList
	ADD FOREIGN KEY (regionNum)
	REFERENCES region (regionNum)
;


ALTER TABLE authorities
	ADD FOREIGN KEY (userId)
	REFERENCES userInfo (userId)
;


ALTER TABLE empList
	ADD FOREIGN KEY (userId)
	REFERENCES userInfo (userId)
;



