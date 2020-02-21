CREATE TABLE `b_users` (
	`num` INT NOT NULL AUTO_INCREMENT,
	`name` VARCHAR(50) NOT NULL,
	`email` VARCHAR(50) NOT NULL,
	`password` VARCHAR(100) NOT NULL,
	`phone` VARCHAR(11) NULL DEFAULT NULL,
	`img` VARCHAR(200) NULL DEFAULT '/res/img/man.png',
	`enabled` TINYINT NOT NULL DEFAULT 1,
	`regDate` DATETIME NOT NULL DEFAULT current_timestamp(),
	PRIMARY KEY (`num`)
);
   
CREATE TABLE b_authorities (
  num int NOT NULL,
  authority VARCHAR(50) NOT NULL DEFAULT 'ROLE_USER',
  FOREIGN KEY (num) REFERENCES b_users(num)
);
 
CREATE UNIQUE INDEX ix_auth_email on b_authorities (num,authority);
  
CREATE TABLE b_message (
  num INT NOT NULL AUTO_INCREMENT,
  target_num INT NOT NULL,
  reg_num INT NOT NULL,
  message VARCHAR(255) NULL,
  regDate DATETIME NOT NULL DEFAULT NOW(),
  PRIMARY KEY (num)
);
 
CREATE TABLE b_interests (
  num INT NOT NULL,
  target_num INT NOT NULL,
  state INT NOT NULL DEFAULT 0,
  regDate DATETIME NOT NULL DEFAULT NOW(),
  PRIMARY KEY (num, target_num)
);

CREATE VIEW v_interests AS 
SELECT 1  AS num,  'C' 				AS interest_name
UNION ALL 
SELECT 2  AS num,  'C++' 			AS interest_name
UNION ALL 
SELECT 3  AS num,  'C#' 			AS interest_name
UNION ALL 
SELECT 4  AS num,  'JAVA' 			AS interest_name
UNION ALL 
SELECT 5  AS num,  'WEBSERVICE' 	AS interest_name
UNION ALL 
SELECT 6  AS num,  'DATABASE' 	AS interest_name
UNION ALL 
SELECT 7  AS num,  'SQL' 			AS interest_name
UNION ALL 
SELECT 8  AS num,  'HTML' 			AS interest_name
UNION ALL 
SELECT 9  AS num,  'CSS' 			AS interest_name
UNION ALL 
SELECT 10 AS num,  'JAVASCRIPT' 	AS interest_name
UNION ALL 
SELECT 11 AS num,  'PYTHON' 		AS interest_name
UNION ALL 
SELECT 12 AS num,  'RUBE' 			AS interest_name
UNION ALL 
SELECT 13 AS num,  'GO' 			AS interest_name
UNION ALL 
SELECT 14 AS num,  'PHP' 			AS interest_name
UNION ALL 
SELECT 15 AS num,  'ASP' 			AS interest_name
UNION ALL 
SELECT 16 AS num,  'JSP' 			AS interest_name
;