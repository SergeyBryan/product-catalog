truncate product cascade;
truncate model cascade;
truncate category cascade;

insert into category (category_id, category_name, active, created_date, updated_date)
values ('1', 'test', true, now(), now());

insert into model(model_code, model_name, model_description, category_id, created_date, updated_date)
values ('1', 'test', 'test', '1', now(), now());

insert into product(product_id, name, description, model_code, created_date, updated_date)
values (default, 'test', 'test', '1', now(), now());