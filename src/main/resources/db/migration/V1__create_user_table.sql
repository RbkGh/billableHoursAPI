-- -----------------------------------------------------
-- Table `user`
-- -----------------------------------------------------
CREATE TABLE `user`
(
  `id`             BIGINT(11) UNSIGNED                                       NOT NULL AUTO_INCREMENT,
  `email`          varchar(60) COLLATE utf8mb4_general_ci                    NOT NULL,
  `date_created`   datetime                                                  NOT NULL DEFAULT CURRENT_TIMESTAMP,
  `password`       binary(60)                                                NOT NULL,
  `first_name`     varchar(45) COLLATE utf8mb4_general_ci                    NOT NULL,
  `sur_name`       varchar(45) COLLATE utf8mb4_general_ci                    NOT NULL,
  `date_of_birth`  date                                                      NOT NULL,
  `sex`            enum ('MALE','FEMALE','OTHER') COLLATE utf8mb4_general_ci NOT NULL,
  `account_active` tinyint(1)                                                NOT NULL DEFAULT '0',
  PRIMARY KEY (`id`),
  UNIQUE KEY `email_UNIQUE` (`email`)
)
  ENGINE = InnoDB
  DEFAULT CHARSET = utf8mb4
  COLLATE = utf8mb4_general_ci;


CREATE TABLE `role`
(
  `id`        bigint(11) UNSIGNED                       NOT NULL AUTO_INCREMENT,
  `role_name` enum ('ROLE_LAWYER','ROLE_FINANCE_ADMIN') not null,
  PRIMARY KEY (`id`),
  UNIQUE KEY `role_name_unique` (`role_name`)
) ENGINE = InnoDB
  DEFAULT CHARSET = utf8mb4
  COLLATE = utf8mb4_general_ci;


CREATE TABLE `privilege`
(
  `id`   bigint(11) UNSIGNED NOT NULL AUTO_INCREMENT,
  `name` varchar(255) COLLATE utf8mb4_general_ci DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE = InnoDB
  DEFAULT CHARSET = utf8mb4
  COLLATE = utf8mb4_general_ci;



CREATE TABLE `roles_privileges`
(
  `role_id`      bigint(11) UNSIGNED NOT NULL,
  `privilege_id` bigint(11) UNSIGNED NOT NULL,
  KEY `rp_key1` (`privilege_id`),
  KEY `rp_key2` (`role_id`),
  CONSTRAINT `rp_key2` FOREIGN KEY (`role_id`) REFERENCES `role` (`id`),
  CONSTRAINT `rp_key1` FOREIGN KEY (`privilege_id`) REFERENCES `privilege` (`id`)
) ENGINE = InnoDB
  DEFAULT CHARSET = utf8mb4
  COLLATE = utf8mb4_general_ci;


CREATE TABLE `users_roles`
(
  `user_id` bigint(11) UNSIGNED NOT NULL,
  `role_id` bigint(11) UNSIGNED NOT NULL,
  KEY `ur_key1` (`role_id`),
  KEY `ur_key2` (`user_id`),
  CONSTRAINT `ur_key1`
    FOREIGN KEY (`role_id`) REFERENCES `role` (`id`),
  CONSTRAINT `ur_key2`
    FOREIGN KEY (`user_id`) REFERENCES `user` (`id`) on delete cascade
) ENGINE = InnoDB
  DEFAULT CHARSET = utf8mb4
  COLLATE = utf8mb4_general_ci;
