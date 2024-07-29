CREATE TABLE `course` (
                          `id` int NOT NULL AUTO_INCREMENT,
                          `name` varchar(100) NOT NULL,
                          `description` text NOT NULL,
                          `start_date` date NOT NULL,
                          `end_date` date NOT NULL,
                          `mode` varchar(20) NOT NULL,
                          PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=1 DEFAULT CHARSET=latin1;


CREATE TABLE `enrollment` (
                              `id` int NOT NULL AUTO_INCREMENT,
                              `user_id` int NOT NULL,
                              `course_id` int NOT NULL,
                              `enrollment_date` date NOT NULL,
                              PRIMARY KEY (`id`),
                              UNIQUE KEY `unique_enrollment` (`user_id`, `course_id`),
                              FOREIGN KEY (`user_id`) REFERENCES `user` (`id`),
                              FOREIGN KEY (`course_id`) REFERENCES `course` (`id`)
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

