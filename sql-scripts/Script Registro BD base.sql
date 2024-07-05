USE `church_database`;

SET foreign_key_checks = 0;
DROP TABLE IF EXISTS `users_roles`;
DROP TABLE IF EXISTS `user`;
DROP TABLE IF EXISTS `role`;
SET foreign_key_checks = 1;

--
-- Table structure for table `user`
--

CREATE TABLE `user` (
                        `id` int NOT NULL AUTO_INCREMENT,
                        `username` varchar(50) NOT NULL,
                        `password` char(80) NOT NULL,
                        `enabled` tinyint NOT NULL,
                        `first_name` varchar(64) NOT NULL,
                        `last_name` varchar(64) NOT NULL,
                        `cellphone` varchar(20) NOT NULL,
                        `email` varchar(64) NOT NULL,
                        `birth_date` date NOT NULL,
                        `gender` varchar(2) NOT NULL,
                        `document_type` varchar(2) NOT NULL,
                        `document_number` varchar(20) NOT NULL,
                        `registry_date` datetime NOT NULL,
                        PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=1 DEFAULT CHARSET=latin1;


--
-- Dumping data for table `user`
--
-- NOTE: The passwords are encrypted using BCrypt
--
-- A generation tool is avail at: http://www.luv2code.com/generate-bcrypt-password
--
-- Default passwords here are: fun123
--

INSERT INTO `user` (`username`, `password`, `enabled`, `first_name`, `last_name`, `cellphone`, `email`, `birth_date`, `gender`, `document_type`, `document_number`, `registry_date`)
VALUES
    ('john','$2a$04$eFytJDGtjbThXa80FyOOBuFdK2IwjyWefYkMpiBEFlpBwDH.5PM0K',1,'John', 'Doe', '3213213211', 'john@correo.com', '1990-01-01', 'M', 'CC', '1234567890', '2024-07-01'),
    ('mary','$2a$04$eFytJDGtjbThXa80FyOOBuFdK2IwjyWefYkMpiBEFlpBwDH.5PM0K',1,'Mary', 'Smith', '3123126454', 'mary@correo.com', '1992-02-02', 'F', 'CC', '9876543210', '2024-07-01'),
    ('susan','$2a$04$eFytJDGtjbThXa80FyOOBuFdK2IwjyWefYkMpiBEFlpBwDH.5PM0K',1,'Susan', 'Public', '3254678465', 'susan@correo.com', '1985-03-03', 'F', 'CC', '1122334455', '2024-07-01');

--
-- Table structure for table `role`
--

CREATE TABLE `role` (
                        `id` int NOT NULL AUTO_INCREMENT,
                        `name` varchar(50) DEFAULT NULL,
                        PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=1 DEFAULT CHARSET=latin1;

--
-- Dumping data for table `role`
--

INSERT INTO `role` (name)
VALUES
    ('ROLE_USER'),('ROLE_TEACHER'),('ROLE_ADMINISTRATOR');

SET FOREIGN_KEY_CHECKS = 0;

--
-- Table structure for table `users_roles`
--

CREATE TABLE `users_roles` (
                               `user_id` int NOT NULL,
                               `role_id` int NOT NULL,

                               PRIMARY KEY (`user_id`,`role_id`),

                               KEY `FK_ROLE_idx` (`role_id`),

                               CONSTRAINT `FK_USER_05` FOREIGN KEY (`user_id`)
                                   REFERENCES `user` (`id`)
                                   ON DELETE NO ACTION ON UPDATE NO ACTION,

                               CONSTRAINT `FK_ROLE` FOREIGN KEY (`role_id`)
                                   REFERENCES `role` (`id`)
                                   ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

SET FOREIGN_KEY_CHECKS = 1;

--
-- Dumping data for table `users_roles`
--

INSERT INTO `users_roles` (user_id, role_id)
VALUES
    (1, 1),
    (2, 1),
    (2, 2),
    (3, 1),
    (3, 2),
    (3, 3);


