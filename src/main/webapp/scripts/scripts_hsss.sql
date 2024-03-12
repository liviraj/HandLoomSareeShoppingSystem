create database hsss;

use hsss;

CREATE TABLE `hsss`.`login` (
  `loginId` INT NOT NULL AUTO_INCREMENT,
  `userName` VARCHAR(45) NULL,
  `password` VARCHAR(45) NULL,
  `role` VARCHAR(45) NULL,
  PRIMARY KEY (`loginId`));

INSERT INTO `hsss`.`login` (`userName`, `password`, `role`) VALUES ('admin', 'admin', 'ADMIN');

CREATE TABLE `hsss`.`carddetails` (
  `cardId` INT NOT NULL AUTO_INCREMENT,
  `loginId` INT NULL,
  `productId` INT NULL,
  PRIMARY KEY (`cardId`));

CREATE TABLE `hsss`.`productdetails` (
  `productId` INT NOT NULL AUTO_INCREMENT,
  `productName` VARCHAR(45) NULL,
  `price` INT NULL,
  `rating` INT NULL,
  `availability` VARCHAR(45) NULL,
  PRIMARY KEY (`productId`));
  
INSERT INTO `hsss`.`productdetails` (`productName`, `price`, `rating`, `availability`) VALUES ('Kanjivaram Saree', '5000', '4', 'Available');
INSERT INTO `hsss`.`productdetails` (`productName`, `price`, `rating`, `availability`) VALUES ('Kanchipuram Silk Saree', '18000', '3', 'Available');
INSERT INTO `hsss`.`productdetails` (`productName`, `price`, `rating`, `availability`) VALUES ('Arani Silk Saree', '25000', '5', 'Available');
INSERT INTO `hsss`.`productdetails` (`productName`, `price`, `rating`, `availability`) VALUES ('Madurai Sungudi Saree', '4000', '4', 'Available');
INSERT INTO `hsss`.`productdetails` (`productName`, `price`, `rating`, `availability`) VALUES ('Coimbatore Cotton Saree', '2500', '3', 'Available');
INSERT INTO `hsss`.`productdetails` (`productName`, `price`, `rating`, `availability`) VALUES ('Dharmavaram Silk Saree', '2500', '4', 'Available');
INSERT INTO `hsss`.`productdetails` (`productName`, `price`, `rating`, `availability`) VALUES ('Chettinad Cotton Saree', '1800', '5', 'Available');
INSERT INTO `hsss`.`productdetails` (`productName`, `price`, `rating`, `availability`) VALUES ('Gadwal Silk Saree', '4000', '4', 'Available');
  




