/*
SQLyog Ultimate v12.5.0 (64 bit)
MySQL - 5.7.18-log : Database - electonic
*********************************************************************
*/

/*!40101 SET NAMES utf8 */;

/*!40101 SET SQL_MODE=''*/;

/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;
CREATE DATABASE /*!32312 IF NOT EXISTS*/`electonic` /*!40100 DEFAULT CHARACTER SET utf8 */;

USE `electonic`;

/*Table structure for table `electonic_main` */

DROP TABLE IF EXISTS `electonic_main`;

CREATE TABLE `electonic_main` (
  `id` int(50) NOT NULL AUTO_INCREMENT,
  `name` varchar(100) DEFAULT NULL,
  `password` varchar(100) DEFAULT NULL,
  `phone` varchar(100) DEFAULT NULL,
  `mailbox` varbinary(1000) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=21 DEFAULT CHARSET=utf8;

/*Data for the table `electonic_main` */

insert  into `electonic_main`(`id`,`name`,`password`,`phone`,`mailbox`) values 
(15,'111','111','13774102083','13774102083@qq.com'),
(16,'112','112','13774102083','2694884331@qq.com'),
(17,'Hejx','Hejx','13872850604','13872850604@qq.com'),
(18,'115','115','13711111111','1111111111@aa.com'),
(19,'145','145','13774102083','2694884331@qq.com'),
(20,'113','113','13774192983','13774192983@aa.com');

/*Table structure for table `electonic_name` */

DROP TABLE IF EXISTS `electonic_name`;

CREATE TABLE `electonic_name` (
  `id` int(50) NOT NULL AUTO_INCREMENT,
  `electonicname` varchar(500) DEFAULT NULL,
  `path` varchar(500) DEFAULT NULL,
  `name` varchar(100) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=228 DEFAULT CHARSET=utf8;

/*Data for the table `electonic_name` */

insert  into `electonic_name`(`id`,`electonicname`,`path`,`name`) values 
(221,'8ab8fc1409037691e906a5d469a4e58b (1).jpg','C:\\Users\\123\\Pictures\\Saved Pictures\\8ab8fc1409037691e906a5d469a4e58b (1).jpg','111'),
(222,'635d8e2176cf2fa6d0d42fe554ac2507.jpeg','C:\\Users\\123\\Pictures\\Saved Pictures\\635d8e2176cf2fa6d0d42fe554ac2507.jpeg','111'),
(223,'797ff6cf4ff02afeeb6561203e14a5eb.jpg','C:\\Users\\123\\Pictures\\Saved Pictures\\797ff6cf4ff02afeeb6561203e14a5eb.jpg','111'),
(224,'e35881b8620909eb0d7ee2341e873a34.jpg','C:\\Users\\123\\Pictures\\Saved Pictures\\e35881b8620909eb0d7ee2341e873a34.jpg','111'),
(225,'ff6dcebd6b510cb4737732aa2fd7c924.jpg','C:\\Users\\123\\Pictures\\Saved Pictures\\ff6dcebd6b510cb4737732aa2fd7c924.jpg','111'),
(226,'797ff6cf4ff02afeeb6561203e14a5eb.jpg','C:\\Users\\123\\Pictures\\Saved Pictures\\797ff6cf4ff02afeeb6561203e14a5eb.jpg','111'),
(227,'e35881b8620909eb0d7ee2341e873a34.jpg','C:\\Users\\123\\Pictures\\Saved Pictures\\e35881b8620909eb0d7ee2341e873a34.jpg','111');

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;
