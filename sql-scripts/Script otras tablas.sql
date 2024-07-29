use `church_database`;

SET foreign_key_checks = 0;
DROP TABLE IF EXISTS `student`;
DROP TABLE IF EXISTS `teacher`;
DROP TABLE IF EXISTS `course`;
DROP TABLE IF EXISTS `enrollment`;
DROP TABLE IF EXISTS `attendance`;
DROP TABLE IF EXISTS `resource`;
SET foreign_key_checks = 1;



-- Table structure for table `student`
CREATE TABLE `student` (
                           `id` int NOT NULL AUTO_INCREMENT,
                           `user_id` int NOT NULL,
                           PRIMARY KEY (`id`),
                           KEY `FK_USER_STUDENT` (`user_id`),
                           CONSTRAINT `FK_USER_STUDENT` FOREIGN KEY (`user_id`) REFERENCES `user` (`id`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB AUTO_INCREMENT=1 DEFAULT CHARSET=latin1;

-- Table structure for table `teacher`
CREATE TABLE `teacher` (
                           `id` int NOT NULL AUTO_INCREMENT,
                           `user_id` int NOT NULL,
                           PRIMARY KEY (`id`),
                           KEY `FK_USER_TEACHER` (`user_id`),
                           CONSTRAINT `FK_USER_TEACHER` FOREIGN KEY (`user_id`) REFERENCES `user` (`id`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB AUTO_INCREMENT=1 DEFAULT CHARSET=latin1;

-- Table structure for table `course`
CREATE TABLE `course` (
                          `id` int NOT NULL AUTO_INCREMENT,
                          `name` varchar(255) NOT NULL,
                          `description` text NOT NULL,
                          PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=1 DEFAULT CHARSET=latin1;

-- Table structure for table `enrollment`
CREATE TABLE `enrollment` (
                              `id` int NOT NULL AUTO_INCREMENT,
                              `student_id` int NOT NULL,
                              `course_id` int NOT NULL,
                              PRIMARY KEY (`id`),
                              KEY `FK_STUDENT_ENROLLMENT` (`student_id`),
                              KEY `FK_COURSE_ENROLLMENT` (`course_id`),
                              CONSTRAINT `FK_STUDENT_ENROLLMENT` FOREIGN KEY (`student_id`) REFERENCES `student` (`id`) ON DELETE CASCADE ON UPDATE CASCADE,
                              CONSTRAINT `FK_COURSE_ENROLLMENT` FOREIGN KEY (`course_id`) REFERENCES `course` (`id`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB AUTO_INCREMENT=1 DEFAULT CHARSET=latin1;

CREATE TABLE `attendance` (
                              `id` int NOT NULL AUTO_INCREMENT,
                              `user_id` int NOT NULL,
                              `course_id` int NOT NULL,
                              `attendance_date` date NOT NULL,
                              PRIMARY KEY (`id`),
                              FOREIGN KEY (`user_id`) REFERENCES `user` (`id`),
                              FOREIGN KEY (`course_id`) REFERENCES `course` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=1 DEFAULT CHARSET=latin1;

CREATE TABLE `resource` (
                            `id` int NOT NULL AUTO_INCREMENT,
                            `course_id` int NOT NULL,
                            `title` varchar(100) NOT NULL,
                            `url` varchar(255) NOT NULL,
                            PRIMARY KEY (`id`),
                            FOREIGN KEY (`course_id`) REFERENCES `course` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=1 DEFAULT CHARSET=latin1;

SET foreign_key_checks = 0;

