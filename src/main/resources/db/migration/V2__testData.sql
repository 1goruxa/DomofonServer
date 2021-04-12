insert into users(id, name, password, group_id, balance, is_admin) values ('1', 'admin', '123456', '1', '999', '1');
insert into users(id, name, password, group_id, balance, is_admin) values ('2', 'vasya', '123456', '2', '0', '0');

insert into devices(id, name, mac, user_id) values ('1', 'Iphone', '11:11:11:11', '1');
insert into devices(id, name, mac, user_id) values ('2', 'Iwatch', '11:11:11:11', '1');
insert into devices(id, name, mac, user_id) values ('3', 'Nokia3310', '11:11:11:11', '2');

insert into epd(id, name, description) values ('1', 'router1_1', 'Lenina, d.1, p.1');

insert into epd2devices(id, epd_id, device_id) values ('1', '1', '1');
insert into epd2devices(id, epd_id, device_id) values ('2', '1', '2');

insert into family(id, name) values ('1', 'admins');
insert into family(id, name) values ('2', 'others');

