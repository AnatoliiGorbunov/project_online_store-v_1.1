create table if not exists product (id bigserial, title varchar(255), cost int, primary key(id));

INSERT INTO product (title, cost)
VALUES ('bread', 40),
       ('Milk', 60),
       ('Tea', 53),
       ('coffee', 140),
       ('carrot', 400),
       ('potato', 44),
       ('orange', 90),
       ('banana', 87),
       ('kiwi', 137),
       ('chocolate', 73),
       ('juice', 100),
       ('apple',82 ),
       ('mango', 170),
       ('beer', 60);