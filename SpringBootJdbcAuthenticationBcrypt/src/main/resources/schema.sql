/*
 schema.sql
 ----------------------------------------------------------------------------
 Jdbc REST API Demo App - MariaDB/MySQL Tables and Data Objectsc for Jdbc default 
 Requires MariaDB version 10.2.1 or MySQL version 8.0.13 and aftrward. 
 (C)opyright Panos Zafeiropoulos - 2024


 ----------------------------------------------------------------------------
 Last update: 240116 - PZ
 -----------------------------------------------------------------------------
*/


-- --------------------------------------------------------
-- GRANT ALL PRIVILEGES 
-- FOR THE `items1` SCHEMA 
-- TO A USER WITH USERNAME: `user1`
-- --------------------------------------------------------

-- GRANT ALL PRIVILEGES ON items1.* TO 'user1'@'%' IDENTIFIED BY 'upassw1';





USE `springsecurity`;
@
--DELIMITER @


SET FOREIGN_KEY_CHECKS=0;
@
-- --------------------------------
-- Table structure for authorities
-- --------------------------------
BEGIN;
@
DROP TABLE IF EXISTS `authorities`;
@
CREATE TABLE `authorities` (
  `username` varchar(40) NOT NULL,
  `authority` varchar(50) NOT NULL,
  `role` varchar(50) NOT NULL,
  KEY `fk_authorities_users` (`username`),
  CONSTRAINT `fk_authorities_users` FOREIGN KEY (`username`) REFERENCES `users` (`username`) 
);
@
COMMIT;
@





-- ----------------------------
-- Table structure for Users
-- ----------------------------


DROP TABLE IF EXISTS `users`;
@
BEGIN;
@
CREATE TABLE `users` (
  `id` int(10) unsigned NOT NULL AUTO_INCREMENT,
  `username` varchar(40) NOT NULL UNIQUE,
  `password` varchar(80) NOT NULL,
  `email` varchar(40) NOT NULL UNIQUE,
  `confirmed` tinyint(1) DEFAULT 1,
  `enabled` tinyint(1) DEFAULT 1,
  `regdate` TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP,  
  PRIMARY KEY (`id`)
 
);
@
COMMIT;
@


SET FOREIGN_KEY_CHECKS=1;
@

-- ----------------------------
-- Table structure for items
-- ----------------------------
BEGIN;
@
DROP TABLE IF EXISTS `items`;
@
CREATE TABLE `items` (
  `itemId` int(10) unsigned NOT NULL AUTO_INCREMENT,
  `itemName` varchar(100) NOT NULL,
  `itemVendorId` int(3) unsigned DEFAULT 1,
  `itemModelYear` int(4) unsigned DEFAULT 2024,
  `itemListPrice` decimal(8,2) DEFAULT 0,           
  PRIMARY KEY (`itemId`)
); 
@
COMMIT;
@
