
====================================================================================================
Create Tables SQL.
====================================================================================================
CREATE TABLE `skill` (
  `skillId` int(11) NOT NULL AUTO_INCREMENT,
  `skillName` varchar(100) NOT NULL,
  PRIMARY KEY (`skillId`),
  UNIQUE KEY `skillName` (`skillName`)
) ENGINE=InnoDB AUTO_INCREMENT=7 DEFAULT CHARSET=utf8;


CREATE TABLE `employee` (
  `employeeId` int(11) NOT NULL AUTO_INCREMENT,
  `employeeFirstName` varchar(50) NOT NULL,
  `employeeLastName` varchar(50) NOT NULL,
  `employeeEmail` varchar(50) NOT NULL,
  `employeeMobNo` varchar(60) NOT NULL,
  `employeeAddress` varchar(60) DEFAULT NULL,
  `employeeGender` varchar(10) NOT NULL,
  `employeeDOB` text NOT NULL,
  `employeeDOJ` text NOT NULL,
  `employeeStatus` varchar(20) NOT NULL,
  `role` varchar(20) NOT NULL,
  PRIMARY KEY (`employeeId`)
) ENGINE=InnoDB AUTO_INCREMENT=38 DEFAULT CHARSET=utf8;

CREATE TABLE `credentials` (
  `username` text NOT NULL,
  `password` text NOT NULL,
  `enabled` tinyint(4) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

CREATE TABLE `employeemanager` (
  `eid` int(11) DEFAULT NULL,
  `managerId` int(11) DEFAULT NULL,
  KEY `eid_idx` (`eid`),
  KEY `managerId_idx` (`managerId`),
  CONSTRAINT `eid` FOREIGN KEY (`eid`) REFERENCES `employee` (`employeeId`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `managerId` FOREIGN KEY (`managerId`) REFERENCES `employee` (`employeeId`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=utf8;


CREATE TABLE `employeeskills` (
  `empId` int(11) DEFAULT NULL,
  `managerId` int(11) DEFAULT NULL,
  `skillId` int(11) DEFAULT NULL,
  `status` varchar(45) DEFAULT NULL,
  `comments` varchar(45) DEFAULT NULL,
  `skillName` varchar(45) DEFAULT NULL,
  `EmployeeRating` int(11) DEFAULT NULL,
  `managerComments` varchar(45) DEFAULT NULL,
  `approvalId` int(11) NOT NULL AUTO_INCREMENT,
  PRIMARY KEY (`approvalId`),
  KEY `empId_idx` (`empId`),
  KEY `mangerId_idx` (`managerId`),
  CONSTRAINT `empId` FOREIGN KEY (`empId`) REFERENCES `employee` (`employeeId`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `mangerId` FOREIGN KEY (`managerId`) REFERENCES `employee` (`employeeId`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8;



====================================================================================================
Get Start SQL.
====================================================================================================
1. sample data for admin
insert into employee values(1,'Sachin','Tendulkar','sachin@india.com',9850607089,'Mumbai','Male','05/25/1982','12/11/2005','Active','ROLE_ADMIN');
insert into credentials values ('sachin@india.com','pass',1);
insert into employeemanager values (1,1);

2. sample data for first manager
insert into employee values(2,'MS','Dhoni','dhoni@india.com',8055897657,'Pune','Male','05/25/1989','12/11/2009','Active','MANAGER');
insert into credentials values ('dhoni@india.com','pass',1);
insert into employeemanager values (2,1);

