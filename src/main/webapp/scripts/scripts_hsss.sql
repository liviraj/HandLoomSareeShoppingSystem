create database hsss;

use hsss;

CREATE TABLE `hsss`.`login` (
  `loginId` INT NOT NULL AUTO_INCREMENT,
  `userName` VARCHAR(45) NULL,
  `password` VARCHAR(45) NULL,
  `role` VARCHAR(45) NULL,
  PRIMARY KEY (`loginId`));

INSERT INTO `hsss`.`login` (`userName`, `password`, `role`) VALUES ('admin', 'admin', 'ADMIN');
  




