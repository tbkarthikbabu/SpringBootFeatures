delete from addresses;
delete from users;

insert into users(id, name) values(1,'Ramesh');
insert into users(id, name) values(2,'john');
insert into users(id, name) values(3,'Salman');

insert into addresses(id,city,user_id) values(1, 'City1',1);
insert into addresses(id,city,user_id) values(2, 'City2',1);
insert into addresses(id,city,user_id) values(3, 'City3',2);
