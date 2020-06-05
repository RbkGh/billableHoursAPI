INSERT ignore INTO `user`
(`id`, `email`, `password`, `first_name`, `sur_name`, `date_of_birth`, `sex`, account_active)
VALUES ('1', 'lawyer1@gmail.com', '$2a$12$nMLHAGaJRd/DBhVF5RvlyelxbhxmeHrfQL25eNojwHam26LVMzqoK', 'rodney',
        'boachie', current_date(), 'MALE', 1),
       ('2', 'finance1@gmail.com', '$2y$12$nMLHAGaJRd/DBhVF5RvlyelxbhxmeHrfQL25eNojwHam26LVMzqoK', 'Shum',
        'Owiredu', current_date(), 'MALE', 1);

-- password for both accounts = pass1234

-- associate each user to their roles respectively
insert ignore into users_roles(user_id, role_id)
values (1, 1),
       (2, 2);

-- $2y$12$nMLHAGaJRd/DBhVF5RvlyelxbhxmeHrfQL25eNojwHam26LVMzqoK
