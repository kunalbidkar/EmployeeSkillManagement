create database employees;
use employees;
create table user_credentials(email_id varchar(60) primary key not null, password varchar(50) not null);


create table role(role_id int primary key auto_increment not null, role_name varchar(50));

CREATE TABLE `employees`.`employee_role` (
  `employee_id` INT NULL,
  `role_id` INT NULL,
  INDEX `employee_id_idx` (`employee_id` ASC),
  INDEX `role_id_idx` (`role_id` ASC),
  CONSTRAINT `employee_id`
    FOREIGN KEY (`employee_id`)
    REFERENCES `employees`.`employee` (`employeeId`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `role_id`
    FOREIGN KEY (`role_id`)
    REFERENCES `employees`.`role` (`role_id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION);
	alter table role add column role_desc varchar(50);

	
	
	CREATE TABLE `employees`.`employee_skills` (
  `e_id` INT NULL,
  `s_id` INT NULL,
  `employee_rating` VARCHAR(45) NULL,
  `manager_Action` VARCHAR(45) NULL,
  `comments` VARCHAR(45) NULL,
  `emp_date_of_submission` DATE NULL,
  `approval_date` DATE NULL,
  INDEX `e_id_idx` (`e_id` ASC),
  INDEX `s_id_idx` (`s_id` ASC),
  CONSTRAINT `e_id`
    FOREIGN KEY (`e_id`)
    REFERENCES `employees`.`employee` (`employeeId`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `s_id`
    FOREIGN KEY (`s_id`)
    REFERENCES `employees`.`skill` (`skill_id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION);
    
    
    
    
    #Bimal =================================================================
 CREATE TABLE `credentials` (
  `username` text NOT NULL,
  `password` text NOT NULL,
  `enabled` tinyint(4) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;


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
) ENGINE=InnoDB AUTO_INCREMENT=18 DEFAULT CHARSET=utf8;



CREATE TABLE `employeemanager` (
  `eid` int(11) DEFAULT NULL,
  `managerId` int(11) DEFAULT NULL,
  KEY `eid_idx` (`eid`),
  KEY `managerId_idx` (`managerId`),
  CONSTRAINT `eid` FOREIGN KEY (`eid`) REFERENCES `employee` (`employeeId`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `managerId` FOREIGN KEY (`managerId`) REFERENCES `employee` (`employeeId`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=utf8;


**************************  Madhav ***********************************


CREATE TABLE `skill` (
  `skillId` int(11) NOT NULL AUTO_INCREMENT,
  `skillName` varchar(100) NOT NULL,
  PRIMARY KEY (`skillId`),
  UNIQUE KEY `skillName` (`skillName`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8;

