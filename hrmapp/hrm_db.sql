/*
SQLyog Ultimate v12.5.0 (64 bit)
MySQL - 5.7.18-log : Database - hrm_db
*********************************************************************
*/

/*!40101 SET NAMES utf8 */;

/*!40101 SET SQL_MODE=''*/;

/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;
CREATE DATABASE /*!32312 IF NOT EXISTS*/`hrm_db` /*!40100 DEFAULT CHARACTER SET utf8 */;

USE `hrm_db`;

/*Table structure for table `dept_inf` */

DROP TABLE IF EXISTS `dept_inf`;

CREATE TABLE `dept_inf` (
  `ID` int(11) NOT NULL AUTO_INCREMENT,
  `NAME` varchar(50) NOT NULL,
  `REMARK` varchar(300) DEFAULT NULL,
  PRIMARY KEY (`ID`)
) ENGINE=InnoDB AUTO_INCREMENT=13 DEFAULT CHARSET=utf8;

/*Data for the table `dept_inf` */

insert  into `dept_inf`(`ID`,`NAME`,`REMARK`) values 
(1,'技术部1','技术部1'),
(2,'运营部','运营部'),
(3,'财务部','财务部'),
(5,'总公办','总公办'),
(6,'市场部','市场部'),
(7,'教学部','教学部'),
(10,'测试部','测试部'),
(11,'技术部一部','技术部一部'),
(12,'1234','123');

/*Table structure for table `document_inf` */

DROP TABLE IF EXISTS `document_inf`;

CREATE TABLE `document_inf` (
  `ID` int(11) NOT NULL AUTO_INCREMENT,
  `TITLE` varchar(50) NOT NULL,
  `filename` varchar(300) NOT NULL,
  `REMARK` varchar(300) DEFAULT NULL,
  `CREATE_DATE` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP,
  `USER_ID` int(11) DEFAULT NULL,
  PRIMARY KEY (`ID`),
  KEY `FK_DOCUMENT_USER` (`USER_ID`),
  CONSTRAINT `FK_DOCUMENT_USER` FOREIGN KEY (`USER_ID`) REFERENCES `user_inf` (`ID`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8;

/*Data for the table `document_inf` */

insert  into `document_inf`(`ID`,`TITLE`,`filename`,`REMARK`,`CREATE_DATE`,`USER_ID`) values 
(1,'1115','顺序图.mdl',NULL,'2019-06-04 12:18:01',1),
(2,'112','《测试环境搭建》课程设计报告.doc',NULL,'2019-06-12 11:49:30',1);

/*Table structure for table `employee_inf` */

DROP TABLE IF EXISTS `employee_inf`;

CREATE TABLE `employee_inf` (
  `ID` int(11) NOT NULL AUTO_INCREMENT,
  `DEPT_ID` int(11) NOT NULL,
  `JOB_ID` int(11) NOT NULL,
  `NAME` varchar(20) NOT NULL,
  `CARD_ID` varchar(18) NOT NULL,
  `ADDRESS` varchar(50) NOT NULL,
  `POST_CODE` varchar(50) DEFAULT NULL,
  `TEL` varchar(16) DEFAULT NULL,
  `PHONE` varchar(11) NOT NULL,
  `QQ_NUM` varchar(10) DEFAULT NULL,
  `EMAIL` varchar(50) NOT NULL,
  `SEX` int(11) NOT NULL DEFAULT '1',
  `PARTY` varchar(10) DEFAULT NULL,
  `BIRTHDAY` datetime DEFAULT NULL,
  `RACE` varchar(100) DEFAULT NULL,
  `EDUCATION` varchar(10) DEFAULT NULL,
  `SPECIALITY` varchar(20) DEFAULT NULL,
  `HOBBY` varchar(100) DEFAULT NULL,
  `REMARK` varchar(500) DEFAULT NULL,
  `CREATE_DATE` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP,
  PRIMARY KEY (`ID`),
  KEY `FK_EMP_DEPT` (`DEPT_ID`),
  KEY `FK_EMP_JOB` (`JOB_ID`),
  CONSTRAINT `FK_EMP_DEPT` FOREIGN KEY (`DEPT_ID`) REFERENCES `dept_inf` (`ID`),
  CONSTRAINT `FK_EMP_JOB` FOREIGN KEY (`JOB_ID`) REFERENCES `job_inf` (`ID`)
) ENGINE=InnoDB AUTO_INCREMENT=44 DEFAULT CHARSET=utf8;

/*Data for the table `employee_inf` */

insert  into `employee_inf`(`ID`,`DEPT_ID`,`JOB_ID`,`NAME`,`CARD_ID`,`ADDRESS`,`POST_CODE`,`TEL`,`PHONE`,`QQ_NUM`,`EMAIL`,`SEX`,`PARTY`,`BIRTHDAY`,`RACE`,`EDUCATION`,`SPECIALITY`,`HOBBY`,`REMARK`,`CREATE_DATE`) values 
(2,2,1,'杰克','421381199804182417','43234','123456','13999999911','13999999911','251425887','251425887@qq.com',2,'党员','2019-06-01 00:00:00','123','硕士','123','123','软件测试师','2016-03-14 11:35:18'),
(25,1,1,'何嘉星1','421381199804182415','123','123','13999999911','13999999911','123','hjx@test.com',1,'党员','2019-06-01 00:00:00','123','硕士','123','123','123','2019-05-29 20:45:06'),
(27,10,1,'何嘉星','421381199804182415','123','123','13999999911','13999999911','123','hjx@test.com',1,'123','2019-06-01 00:00:00','123','硕士','123','123','123','2019-05-29 20:49:46'),
(34,10,1,'软件分析师1','421381199804182417','123','123456','13999999911','13999999911','2694884331','2694884331@qq.com',0,'党员','2019-06-01 00:00:00','123','硕士','123','123','软件测试师','2019-05-31 08:41:42'),
(36,10,1,'软件测试师2','421381199804182415','123','123456','13999999911','13999999911','2694884331','2694884331@qq.com',1,'党员','2019-06-01 00:00:00','123','硕士','123','123','软件测试师','2019-05-31 08:43:39'),
(38,1,1,'技术部2','421381199804182415','123','123456','13999999911','13999999911','2694884331','2694884331@qq.com',1,'党员','2019-06-01 00:00:00','123','硕士','123','123','123','2019-05-31 08:53:05'),
(40,1,1,'何嘉星7','421381199804182417','123','123456','13999999911','13999999911','2694884331','2694884331@qq.com',0,'党员','2019-06-01 00:00:00','123','硕士','123','123','123','2019-05-31 08:57:56'),
(43,10,1,'何嘉星1','421381199804182417','123','123456','13999999911','13999999911','2694884331','2694884331@qq.com',1,'党员','2019-06-01 00:00:00','123','硕士','123','123','123','2019-05-31 09:15:22');

/*Table structure for table `job_inf` */

DROP TABLE IF EXISTS `job_inf`;

CREATE TABLE `job_inf` (
  `ID` int(11) NOT NULL AUTO_INCREMENT,
  `NAME` varchar(50) NOT NULL,
  `REMARK` varchar(300) DEFAULT NULL,
  PRIMARY KEY (`ID`)
) ENGINE=InnoDB AUTO_INCREMENT=14 DEFAULT CHARSET=utf8;

/*Data for the table `job_inf` */

insert  into `job_inf`(`ID`,`NAME`,`REMARK`) values 
(1,'职员','职员'),
(2,'Java开发工程师','Java开发工程师'),
(8,'经理','经理'),
(9,'总经理','总经理'),
(13,'1234','1234');

/*Table structure for table `notice_inf` */

DROP TABLE IF EXISTS `notice_inf`;

CREATE TABLE `notice_inf` (
  `ID` int(11) NOT NULL AUTO_INCREMENT,
  `TITLE` varchar(50) NOT NULL,
  `CONTENT` text NOT NULL,
  `CREATE_DATE` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP,
  `USER_ID` int(11) DEFAULT NULL,
  PRIMARY KEY (`ID`),
  KEY `FK_NOTICE_USER` (`USER_ID`),
  CONSTRAINT `FK_NOTICE_USER` FOREIGN KEY (`USER_ID`) REFERENCES `user_inf` (`ID`)
) ENGINE=InnoDB AUTO_INCREMENT=26 DEFAULT CHARSET=utf8;

/*Data for the table `notice_inf` */

insert  into `notice_inf`(`ID`,`TITLE`,`CONTENT`,`CREATE_DATE`,`USER_ID`) values 
(24,'123','1234','2019-05-31 17:15:39',1),
(25,'1234','1234','2019-05-31 17:15:46',1);

/*Table structure for table `user_inf` */

DROP TABLE IF EXISTS `user_inf`;

CREATE TABLE `user_inf` (
  `ID` int(11) NOT NULL AUTO_INCREMENT,
  `loginname` varchar(20) NOT NULL,
  `PASSWORD` varchar(16) NOT NULL,
  `USERSTATUS` int(11) NOT NULL DEFAULT '1',
  `createdate` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP,
  `username` varchar(20) DEFAULT NULL,
  PRIMARY KEY (`ID`)
) ENGINE=InnoDB AUTO_INCREMENT=8 DEFAULT CHARSET=utf8;

/*Data for the table `user_inf` */

insert  into `user_inf`(`ID`,`loginname`,`PASSWORD`,`USERSTATUS`,`createdate`,`username`) values 
(1,'admin','admin',2,'2016-03-12 09:34:28','超级管理员'),
(5,'jsb','123456',1,'2019-05-29 20:27:23','技术部'),
(7,'js','1234',2,'2019-05-31 17:14:19','1234');

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;
