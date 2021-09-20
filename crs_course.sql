/*
MySQL Data Transfer
Source Host: localhost
Source Database: crs_db
Target Host: localhost
Target Database: crs_db
Date: 9/20/2021 10:13:35 AM
*/

SET FOREIGN_KEY_CHECKS=0;
-- ----------------------------
-- Table structure for crs_course
-- ----------------------------
DROP TABLE IF EXISTS `crs_course`;
CREATE TABLE `crs_course` (
  `s_no` int(10) NOT NULL auto_increment,
  `courseCode` varchar(30) default NULL,
  `courseName` varchar(30) default NULL,
  `courseDesc` varchar(50) default NULL,
  `professorId` varchar(30) default NULL,
  `courseFee` double(10,0) default NULL,
  `isOffered` binary(10) default NULL,
  PRIMARY KEY  (`s_no`),
  KEY `professorIdFk` (`professorId`),
  KEY `courseCode` (`courseCode`),
  CONSTRAINT `professorIdFk` FOREIGN KEY (`professorId`) REFERENCES `crs_professor` (`userId`)
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=latin1;

-- ----------------------------
-- Table structure for crs_notification
-- ----------------------------
DROP TABLE IF EXISTS `crs_notification`;
CREATE TABLE `crs_notification` (
  `s_no` int(10) NOT NULL auto_increment,
  `studentId` int(10) default NULL,
  `type` varchar(20) default NULL,
  `referenceId` varchar(100) default NULL,
  PRIMARY KEY  (`s_no`)
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=latin1;

-- ----------------------------
-- Table structure for crs_payment
-- ----------------------------
DROP TABLE IF EXISTS `crs_payment`;
CREATE TABLE `crs_payment` (
  `s_no` int(10) NOT NULL auto_increment,
  `studentId` int(10) default NULL,
  `paymentMethod` varchar(20) default NULL,
  `modeOfPayment` varchar(20) default NULL,
  `referenceId` varchar(100) default NULL,
  `amount` double(20,0) default NULL,
  PRIMARY KEY  (`s_no`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=latin1;

-- ----------------------------
-- Table structure for crs_professor
-- ----------------------------
DROP TABLE IF EXISTS `crs_professor`;
CREATE TABLE `crs_professor` (
  `s_no` int(10) NOT NULL auto_increment,
  `userId` varchar(30) default NULL,
  `department` varchar(30) default NULL,
  `designation` varchar(30) default NULL,
  PRIMARY KEY  (`s_no`),
  KEY `userId` (`userId`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=latin1;

-- ----------------------------
-- Table structure for crs_registeredcourses
-- ----------------------------
DROP TABLE IF EXISTS `crs_registeredcourses`;
CREATE TABLE `crs_registeredcourses` (
  `s_no` int(10) NOT NULL auto_increment,
  `courseCode` varchar(30) default NULL,
  `studentId` varchar(30) default NULL,
  `grade` double(10,0) default NULL,
  PRIMARY KEY  (`s_no`),
  KEY `fk1` (`courseCode`),
  KEY `fk2` (`studentId`),
  CONSTRAINT `fk1` FOREIGN KEY (`courseCode`) REFERENCES `crs_course` (`courseCode`)
) ENGINE=InnoDB AUTO_INCREMENT=12 DEFAULT CHARSET=latin1;

-- ----------------------------
-- Table structure for crs_student
-- ----------------------------
DROP TABLE IF EXISTS `crs_student`;
CREATE TABLE `crs_student` (
  `studentId` int(10) NOT NULL auto_increment,
  `userId` varchar(40) default NULL,
  `branchName` varchar(30) default NULL,
  `isApproved` varchar(10) default NULL,
  `isRegistered` binary(10) default 'FALSE\0\0\0\0\0',
  PRIMARY KEY  (`studentId`),
  KEY `userId` (`userId`),
  CONSTRAINT `crs_student_ibfk_3` FOREIGN KEY (`userId`) REFERENCES `crs_user` (`userId`) ON DELETE SET NULL ON UPDATE SET NULL
) ENGINE=InnoDB AUTO_INCREMENT=1011 DEFAULT CHARSET=latin1;

-- ----------------------------
-- Table structure for crs_user
-- ----------------------------
DROP TABLE IF EXISTS `crs_user`;
CREATE TABLE `crs_user` (
  `s_no` int(10) NOT NULL auto_increment,
  `userId` varchar(40) default NULL,
  `name` varchar(40) default NULL,
  `password` varchar(40) default NULL,
  `role` varchar(30) default NULL,
  `gender` varchar(30) default NULL,
  `address` varchar(40) default NULL,
  PRIMARY KEY  (`s_no`),
  KEY `userId` (`userId`)
) ENGINE=InnoDB AUTO_INCREMENT=19 DEFAULT CHARSET=latin1;

-- ----------------------------
-- Records 
-- ----------------------------
INSERT INTO `crs_course` VALUES ('1', 'CS01', 'C', 'C Programming', 'sri.com', '2000', '1');
INSERT INTO `crs_course` VALUES ('2', 'CS02', 'C++', 'C++ Programming', 'sri.com', '3000', '1');
INSERT INTO `crs_course` VALUES ('3', 'CS03', 'Java', 'Java Programming', 'sri.com', '4000', '1');
INSERT INTO `crs_course` VALUES ('5', 'CS04', 'PHP', 'PHP', 'sri.com', '1000', '1');
INSERT INTO `crs_notification` VALUES ('1', '1010', 'PAYMENT', 'c0f1d3dc-72db-4248-93c8-3dd4a7200f33');
INSERT INTO `crs_notification` VALUES ('2', '1010', 'PAYMENT', '8fec89e9-c9a2-47c6-80b1-f71443cf22fa');
INSERT INTO `crs_notification` VALUES ('3', '1010', 'PAYMENT', '7e7494c4-73e5-42b1-9376-cfec3a081504');
INSERT INTO `crs_notification` VALUES ('4', '1010', 'PAYMENT', 'd8a00b7d-35aa-4329-aaa0-cb60acaa487e');
INSERT INTO `crs_notification` VALUES ('5', '1010', 'PAYMENT', 'b5c6f59a-3cc0-4511-a11e-27d6020c8345');
INSERT INTO `crs_payment` VALUES ('1', '1010', 'ONLINE', 'DEBIT_CARD', 'd8a00b7d-35aa-4329-aaa0-cb60acaa487e', '10000');
INSERT INTO `crs_payment` VALUES ('2', '1010', 'ONLINE', 'DEBIT_CARD', 'b5c6f59a-3cc0-4511-a11e-27d6020c8345', '10000');
INSERT INTO `crs_professor` VALUES ('1', 'sri.com', 'CSE', 'Associate Professor');
INSERT INTO `crs_professor` VALUES ('2', 'Santhosh', 'S', 'S');
INSERT INTO `crs_professor` VALUES ('3', 'd', 'd', 'd');
INSERT INTO `crs_registeredcourses` VALUES ('7', 'CS01', '1010', null);
INSERT INTO `crs_registeredcourses` VALUES ('9', 'CS02', '1010', null);
INSERT INTO `crs_registeredcourses` VALUES ('10', 'CS03', '1010', null);
INSERT INTO `crs_registeredcourses` VALUES ('11', 'CS04', '1010', null);
INSERT INTO `crs_student` VALUES ('1001', null, 'CSE', 'N', '1');
INSERT INTO `crs_student` VALUES ('1010', 'email', 'CS', 'Y', '1');
INSERT INTO `crs_user` VALUES ('1', 'sandy.com', 'Sandy', 'pass', 'STUDENT', 'Male', 'Chennai');
INSERT INTO `crs_user` VALUES ('2', 'tanu.com', 'Tanu', 'pass', 'STUDENT', 'Female', 'MP');
INSERT INTO `crs_user` VALUES ('3', 'sri.com', 'Srinivas', 'pass', 'PROFESSOR', 'Male', 'AP');
INSERT INTO `crs_user` VALUES ('4', 'rehan.com', 'Rehan', 'pass', 'PROFESSOR', 'Male', 'Pune');
INSERT INTO `crs_user` VALUES ('5', 'danu.com', 'Danamma', 'pass', 'PROFESSOR', 'Female', 'AP');
INSERT INTO `crs_user` VALUES ('13', 'sandy', 'Santhosh', 'admin', 'ADMIN', 'MALE', 'Madurai');
INSERT INTO `crs_user` VALUES ('16', 'email', 'CS', 'pass', 'STUDENT', 'MALE', 'Chennai');
INSERT INTO `crs_user` VALUES ('17', 'Santhosh', 'S', 'prof', 'PROFESSOR', 'MALE', 'Chennai');
INSERT INTO `crs_user` VALUES ('18', 'd', 'd', 'd', 'PROFESSOR', 'MALE', 'd');
