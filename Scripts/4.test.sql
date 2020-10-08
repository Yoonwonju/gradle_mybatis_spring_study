SELECT * FROM USER_TABLES;
SELECT ADDR_ID,STREET,CITY,STATE,ZIP,COUNTRY FROM ADDRESSES;
SELECT COURSE_ID,NAME,DESCRIPTION,START_DATE,END_DATE,TUTOR_ID FROM COURSES;
SELECT COURSE_ID,STUD_ID FROM COURSE_ENROLLMENT;
SELECT STUD_ID,NAME,EMAIL,PHONE,DOB,BIO,PIC,ADDR_ID FROM STUDENTS;
SELECT TUTOR_ID,NAME,EMAIL,PHONE,DOB,BIO,PIC,ADDR_ID FROM TUTORS;

SELECT STUD_ID AS studId,NAME,EMAIL,PHONE,DOB FROM STUDENTS WHERE STUD_ID = 1;

SELECT STUD_ID, NAME, EMAIL, DOB,
		SUBSTR(PHONE, 1, 3) AS F,
		SUBSTR(PHONE, 5, 3) AS M,
		SUBSTR(PHONE, 9, 4) AS L
  FROM STUDENTS
 WHERE STUD_ID=1;

-----------------------------------------------
SELECT DEPTNO,DEPTNAME,FLOOR FROM DEPARTMENT;
SELECT EMPNO,EMPNAME,TITLE,MANAGER,SALARY,DNO FROM EMPLOYEE;

DELETE FROM DEPARTMENT WHERE DEPTNO = 6;
DELETE FROM EMPLOYEE WHERE EMPNO = 1005;


----------------------------------------------
SELECT USER FROM DUAL;

CREATE USER spring_mybatis IDENTIFIED BY rootroot;

GRANT CONNECT, RESOURCE, CREATE SYNONYM, CREATE VIEW
TO spring_mybatis;
create table department (
deptno number not null,
deptname varchar2(50) not null,
floor number null,
primary key (deptno)
);

DROP TABLE EMPLOYEE;

create table employee (
empno number not null primary key,
empname varchar2(50) not null,
title varchar2(50) null,
manager number null,
salary number null,
dno number null,
foreign key(manager) references employee(empno),
foreign key(dno) references department(deptno)
);

