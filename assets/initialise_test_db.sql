DROP TABLE  IF EXISTS `t_person`;

CREATE TABLE `t_person` (  
	`person_id` int NOT NULL AUTO_INCREMENT,  
	`firstname` varchar(45) NOT NULL,  
	`lastname` varchar(45) NOT NULL,  
	`birth_date` date NOT NULL,  
	PRIMARY KEY (`person_id`)
) ENGINE=InnoDB AUTO_INCREMENT=17 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

INSERT INTO `t_person` (`person_id`,`firstname`,`lastname`,`birth_date`) VALUES (1,'Edmund','Barton','1849-01-18');
INSERT INTO `t_person` (`person_id`,`firstname`,`lastname`,`birth_date`) VALUES (2,'Alfred','Deakin','1856-08-03');
INSERT INTO `t_person` (`person_id`,`firstname`,`lastname`,`birth_date`) VALUES (3,'Chris','Watson','1867-04-09');
INSERT INTO `t_person` (`person_id`,`firstname`,`lastname`,`birth_date`) VALUES (4,'George','Reid','1845-02-25');
INSERT INTO `t_person` (`person_id`,`firstname`,`lastname`,`birth_date`) VALUES (5,'test-first-name','test-last-name','2020-12-01');
INSERT INTO `t_person` (`person_id`,`firstname`,`lastname`,`birth_date`) VALUES (16,'Mike','Tyson','1965-03-23');