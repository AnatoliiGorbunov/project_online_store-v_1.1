DROP TABLE customer IF EXISTS;
DROP TABLE products IF EXISTS;
DROP TABLE cart IF EXISTS;



create table customer (id bigserial, name varchar(255), primary key(id));
create table products (id bigserial, title varchar(255), cost bigint, primary key(id));
create table cart (product_id bigint, customer_id bigint, foreign key(product_id) references products(id),foreign key (customer_id) references customer(id));


INSERT INTO customer (name) VALUES ('Bob'), ('Jack'), ('John');
INSERT INTO products (title, cost) VALUES ('bread', 40), ('Milk', 60), ('Tea', 80);