/*
	DROP USER projectspr;
	CREATE USER projectspr IDENTIFIED BY oracle
	DEFAULT TABLESPACE users
	TEMPORARY TABLESPACE temp;
	
	GRANT CONNECT, RESOURCE TO projectspr;
	
	CONN projectspr/oracle;
*/

DROP TABLE IF EXISTS tbl_user;

DROP TABLE IF EXISTS tbl_manager;

DROP TABLE IF EXISTS tbl_prod;

DROP TABLE IF EXISTS tbl_review;

DROP TABLE IF EXISTS tbl_order;

DROP TABLE IF EXISTS tbl_order_prod;

commit;

