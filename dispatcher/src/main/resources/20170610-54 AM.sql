# ************************************************************
# Sequel Pro SQL dump
# Version 4541
#
# http://www.sequelpro.com/
# https://github.com/sequelpro/sequelpro
#
# Host: 192.168.33.229 (MySQL 5.7.17-log)
# Database: new_task
# Generation Time: 2017-06-12 02:54:43 +0000
# ************************************************************


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;


# Dump of table scheduled_task_skeleton
# ------------------------------------------------------------

DROP TABLE IF EXISTS `scheduled_task_skeleton`;

CREATE TABLE `scheduled_task_skeleton` (
  `task_id` int(11) unsigned NOT NULL AUTO_INCREMENT,
  `taskName` varchar(256) NOT NULL DEFAULT '',
  `quartz_expression` varchar(24) NOT NULL DEFAULT '',
  `task_content` varchar(512) NOT NULL DEFAULT '',
  `param` text,
  `task_type` tinyint(11) NOT NULL,
  `refer_task_id` int(11) unsigned DEFAULT NULL,
  `retry_time_threshold` int(11) unsigned NOT NULL,
  `last_execute_time` datetime DEFAULT NULL,
  `create_time` datetime DEFAULT NULL,
  `update_time` datetime DEFAULT NULL,
  `create_user` varchar(32) DEFAULT NULL,
  `update_user` varchar(32) DEFAULT NULL,
  PRIMARY KEY (`task_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;



# Dump of table task_instance
# ------------------------------------------------------------

DROP TABLE IF EXISTS `task_instance`;

CREATE TABLE `task_instance` (
  `task_instance_id` varchar(12) NOT NULL DEFAULT '',
  `task_id` int(11) unsigned DEFAULT NULL,
  `task_name` varchar(256) NOT NULL DEFAULT '',
  `task_content` varchar(512) NOT NULL DEFAULT '',
  `param` text,
  `task_type` tinyint(2) unsigned NOT NULL,
  `refer_task_instance_id` varchar(12) DEFAULT NULL,
  `retry_time_threshold` int(11) unsigned NOT NULL,
  `status` tinyint(2) unsigned DEFAULT NULL,
  `retry_times` int(11) unsigned DEFAULT NULL,
  `execute_time` datetime DEFAULT NULL,
  `create_time` datetime DEFAULT NULL,
  `update_time` datetime DEFAULT NULL,
  PRIMARY KEY (`task_instance_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;



# Dump of table task_lock
# ------------------------------------------------------------

DROP TABLE IF EXISTS `task_lock`;

CREATE TABLE `task_lock` (
  `lock_name` varchar(32) NOT NULL DEFAULT '',
  PRIMARY KEY (`lock_name`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;




/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;
/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
