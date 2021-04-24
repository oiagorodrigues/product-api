create table products.product (
    id bigserial primary key,
    product_identifier varchar not null,
    name varchar(100) not null,
    description text not null,
    price float not null,
    category_id bigint references products.category(id)
);
