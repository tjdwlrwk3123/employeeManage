
/* Drop Tables */

DROP TABLE imgTable CASCADE CONSTRAINTS;
DROP TABLE emplList CASCADE CONSTRAINTS;
DROP TABLE position CASCADE CONSTRAINTS;
DROP TABLE department CASCADE CONSTRAINTS;
DROP TABLE region CASCADE CONSTRAINTS;
DROP TABLE userInfo CASCADE CONSTRAINTS;




/* Create Tables */

CREATE TABLE department
(
	deptNum number NOT NULL,
	deptName varchar2(30) NOT NULL,
	PRIMARY KEY (deptNum)
);


CREATE TABLE emplList
(
	empNum number NOT NULL,
	userId varchar2(50) NOT NULL,
	empName varchar2(40) NOT NULL,
	ppNum number NOT NULL,
	deptNum number NOT NULL,
	empBirth date NOT NULL,
	solarlunar number,
	regionNum number NOT NULL,
	contactAdress number NOT NULL,
	bonus number,
	PRIMARY KEY (empNum)
);


CREATE TABLE imgTable
(
	imgNum number NOT NULL,
	empNum number NOT NULL,
	img varchar2(50),
	PRIMARY KEY (imgNum)
);


CREATE TABLE position
(
	ppNum number NOT NULL,
	deptNum number NOT NULL,
	ppName varchar2(20) NOT NULL,
	basepay number,
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
	PRIMARY KEY (userId)
);



/* Create Foreign Keys */

ALTER TABLE emplList
	ADD FOREIGN KEY (deptNum)
	REFERENCES department (deptNum)
;


ALTER TABLE position
	ADD FOREIGN KEY (deptNum)
	REFERENCES department (deptNum)
;


ALTER TABLE imgTable
	ADD FOREIGN KEY (empNum)
	REFERENCES emplList (empNum)
;


ALTER TABLE emplList
	ADD FOREIGN KEY (ppNum)
	REFERENCES position (ppNum)
;


ALTER TABLE emplList
	ADD FOREIGN KEY (regionNum)
	REFERENCES region (regionNum)
;


ALTER TABLE emplList
	ADD FOREIGN KEY (userId)
	REFERENCES userInfo (userId)
;



