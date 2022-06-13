create table if not exists product (id bigserial, title varchar(255), cost int, primary key(id));
create table if not exists cart(id bigserial, product_id bigint, title varchar (255));

INSERT INTO product (title, cost)
VALUES ('bread', 40),
       ('Milk', 60),
       ('Tea', 53),
       ('coffee', 140),
       ('carrot', 40),
       ('potato', 44),
       ('orange', 90),
       ('banana', 87),
       ('kiwi', 133),
       ('chocolate', 73),
       ('juice', 100),
       ('apple', 82),
       ('mango', 170),
       ('beer', 60);

create table users
(
    id       bigserial,
    username varchar(30) not null unique,
    password varchar(80) not null,
    email    varchar(50) unique,
    primary key (id)
);

create table roles
(
    id   serial,
    name varchar(50) not null,
    primary key (id)
);

CREATE TABLE users_roles
(
    user_id bigint not null,
    role_id int    not null,
    primary key (user_id, role_id),
    foreign key (user_id) references users (id),
    foreign key (role_id) references roles (id)
);

insert into roles (name)
values ('ROLE_USER'),
       ('ROLE_ADMIN');

insert into users (username, password, email)
values ('user', '$2a$04$Fx/SX9.BAvtPlMyIIqqFx.hLY2Xp8nnhpzvEEVINvVpwIPbA3v/.i', 'user@gmail.com');

insert into users_roles (user_id, role_id)
values (1, 1);


-- INSERT INTO users (name, fhone, email)
-- VALUES ('Jack', '89222456789','321@mail.ru'),
--        ('Mike', '89222346789','361@mail.ru'),
--        ('Mike', '89222556789','371@mail.ru'),
--        ('Mike', '89225676789','331@mail.ru'),
--        ('Mike', '89223426789','391@mail.ru'),
--        ('Mike', '89256736789','311@mail.ru'),
--        ('Mike', '89222346789','301@mail.ru');
