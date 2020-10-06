create table if not exists  role(id int8 primary key ,name varchar);
create table if not exists ui_user(id int8 primary key, user_name varchar, password varchar, role_id int8 references ui_user(id));