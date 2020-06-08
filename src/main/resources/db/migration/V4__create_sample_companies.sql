create table `company`
(
  `id`           BIGINT(11) UNSIGNED                    NOT NULL AUTO_INCREMENT,
  `company_name` varchar(45) COLLATE utf8mb4_general_ci NOT NULL,
  primary key (`id`),
  unique key `company_name_unique` (`company_name`)
)
  ENGINE = InnoDB
  DEFAULT CHARSET = utf8mb4
  COLLATE = utf8mb4_general_ci;


CREATE TABLE `employee_work_log`
(
  `id`            BIGINT(11) UNSIGNED NOT NULL AUTO_INCREMENT,
  `billable_rate` decimal(19, 2) DEFAULT NULL,
  `date_of_day`   datetime(6)         NOT NULL,
  `duration_cost` decimal(19, 2) DEFAULT NULL,
  `end_time`      datetime(6)    DEFAULT NULL,
  `no_of_hours`   int(11)        DEFAULT NULL,
  `start_time`    datetime(6)    DEFAULT NULL,

  `user_id`       BIGINT(11) UNSIGNED NOT NULL,
  `company_id`    BIGINT(11) UNSIGNED NOT NULL,
  PRIMARY KEY (`id`),
  KEY `company_id_fk` (`company_id`),
  KEY `user_id_fk` (`user_id`),
  CONSTRAINT `user_id_fk` FOREIGN KEY (`user_id`) REFERENCES `user` (`id`),
  CONSTRAINT `company_id_fk` FOREIGN KEY (`company_id`) REFERENCES `company` (`id`)
)
  ENGINE = InnoDB
  DEFAULT CHARSET = utf8mb4
  COLLATE = utf8mb4_general_ci;


insert ignore into company(id, company_name)
values (1, 'MTN'),
       (2, 'GBC')

