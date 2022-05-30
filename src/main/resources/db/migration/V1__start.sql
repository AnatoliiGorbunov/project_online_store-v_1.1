create table if not exists product (id bigserial, title varchar(255), cost int, example int, primary key(id));

INSERT INTO product (title, cost, example)
VALUES ('bread', 40, 123),
       ('Milk', 60, 123),
       ('Tea', 53, 2341),
       ('coffee', 140, 213),
       ('carrot', 400, 123),
       ('potato', 44,12333),
       ('orange', 90,12333),
       ('banana', 87,12333),
       ('kiwi', 137,12333),
       ('chocolate', 73,12333),
       ('juice', 100,12333),
       ('apple',82,12333 ),
       ('mango', 170,12333),
       ('beer', 60,12333);