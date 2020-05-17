use fwm;

insert into simple_entity(id,entity_name) values (1,'Test1') ON DUPLICATE KEY UPDATE entity_name="Test";
insert into simple_entity(id,entity_name) values (2,'Test2') ON DUPLICATE KEY UPDATE entity_name="Test";
insert into simple_entity(id,entity_name) values (5,'Test5') ON DUPLICATE KEY UPDATE entity_name="Test";

-- source data/s1.sql