SELECT * FROM USER_TABLES;
SELECT ADDR_ID,STREET,CITY,STATE,ZIP,COUNTRY FROM ADDRESSES;
SELECT COURSE_ID,NAME,DESCRIPTION,START_DATE,END_DATE,TUTOR_ID FROM COURSES;
SELECT COURSE_ID,STUD_ID FROM COURSE_ENROLLMENT;
SELECT STUD_ID,NAME,EMAIL,PHONE,DOB,BIO,PIC,ADDR_ID FROM STUDENTS;
SELECT TUTOR_ID,NAME,EMAIL,PHONE,DOB,BIO,PIC,ADDR_ID FROM TUTORS;


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

