CREATE TABLE `t_users` (
	`num` INT NOT NULL AUTO_INCREMENT,
	`id` VARCHAR(30) NOT NULL,
	`password` VARCHAR(100) NOT NULL,
	`name` VARCHAR(50) NOT NULL,
	`email` VARCHAR(50) NOT NULL,	
	`phone` VARCHAR(11) NULL DEFAULT NULL,
	`img` VARCHAR(200) NULL DEFAULT '/res/img/man.png',
	`enabled` TINYINT NOT NULL DEFAULT 1,
	`regDate` DATETIME NOT NULL DEFAULT current_timestamp(),
	PRIMARY KEY (`num`)
);

CREATE TABLE t_authorities (
  num int NOT NULL,
  authority VARCHAR(50) NOT NULL DEFAULT 'ROLE_USER',
  FOREIGN KEY (num) REFERENCES t_users(num)
);

CREATE UNIQUE INDEX ix_auth_email on t_authorities (num,authority);


INSERT INTO t_users (`id`, `password`, `name`, `email`, `phone`) 
             VALUES ('admin','1234','관리자','admin@goodee.co.kr','');
             
SELECT * FROM t_users;

INSERT INTO t_authorities (num) VALUES (1);

SELECT * FROM t_authorities;


SELECT max(num) AS num FROM t_users;


CREATE TABLE t_message (
	`num` 	 	INT NOT NULL AUTO_INCREMENT,
	`regUser` 	INT NOT NULL,
	`targetUser` INT NOT NULL,
	`comment`	VARCHAR(255) NULL,
	`delYn`		VARCHAR(1) NOT NULL DEFAULT 'N',
	`regDate`	datetime NOT NULL DEFAULT NOW(),
	PRIMARY KEY (`num`)
);

INSERT INTO t_message (`regUser`, `targetUser`, `comment`) VALUES (#{regUser},#{targetUser},#{comment});


CREATE TABLE t_interests (
	u_num INT,
	v_num INT
);

SELECT num, interest_name as name FROM v_interests;

INSERT INTO t_interests VALUES (#{u_num}, #{v_num});

DELETE FROM t_interests WHERE u_num = #{u_num};

SELECT v.*, 
		 case when t.u_num IS NOT NULL then true
		      ELSE false
		 END AS state
  FROM v_interests AS v
  LEFT OUTER JOIN t_interests AS t
  ON (v.num = t.v_num AND t.u_num = 1)
ORDER BY v.num;
  
SELECT * FROM t_users;  
  
UPDATE t_users SET 
`name`     = #{name},
`email`    = #{email},
`phone`    = #{phone},
`password` = #{pwd}
WHERE num = #{num};



















