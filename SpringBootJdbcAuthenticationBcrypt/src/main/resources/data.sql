/*
 data.sql
 ---------------------------------------------------------------------------------------------------------
 Jdbc REST API Demo App - MySQL - Adding initial data (records) to tables  
 
 ---------------------------------------------------------------------------------------------------------

 
 ---------------------------------------------------------------------------------------------------------

*/


-- ----------------------------
-- Data for Table users
-- ----------------------------
BEGIN;
INSERT INTO `users` (`username`, `password`, `email`, `enabled`) VALUES ('admin', '$2a$10$zoWkCXDeBI5lxhvKoYvRd.RFWOGjjgqBJQn.LqvI/OgWGgah6V1lO', 'admin@gmail.com', 1);
INSERT INTO `users` (`username`, `password`, `email`, `enabled`) VALUES ('navin', '$2a$10$qKRgI/CTqzHV2kIvUIZ8E.8q.PQXFJQX62ttLfQdssgp91W0zxrWa', 'navin@gmail.com', 1);
INSERT INTO `users` (`username`, `password`, `email`, `enabled`) VALUES ('user', '$2a$10$ISt1DLbT3OmNLmuQ82ov7.MyhJSrWwTxspcfGI82JF8nJGzaAWKlC', 'user@gmail.com',  1);
COMMIT;

-- ----------------------------
-- Data for Table authorities
-- ----------------------------
BEGIN;
INSERT INTO authorities (username, authority, role) values ('user', 'ROLE_USER', 'USER');
INSERT INTO authorities (username, authority, role) values ('admin', 'ROLE_USER', 'USER');
INSERT INTO authorities (username, authority, role)values ('admin', 'ROLE_ADMIN', 'ADMIN');
INSERT INTO authorities (username, authority, role)values ('navin', 'ROLE_USER', 'USER');
COMMIT;



-- ----------------------------
-- Data for Table items
-- ----------------------------

BEGIN;
INSERT INTO `items` (`itemName`,`itemModelYear`,`itemListPrice`) VALUES ('Wooden Pencil',1998, 5);
INSERT INTO `items` (`itemName`,`itemModelYear`,`itemListPrice`) VALUES ('Basic Notebook',2005, 150);
INSERT INTO `items` (`itemName`,`itemModelYear`,`itemListPrice`) VALUES ('Silica Eraser',2007, 25);
INSERT INTO `items` (`itemName`,`itemModelYear`,`itemListPrice`) VALUES ('Soft Polymer Eraser',2020, 35);
INSERT INTO `items` (`itemName`,`itemModelYear`,`itemListPrice`) VALUES ('Soft Ballpoint Pen',2019, 125);
INSERT INTO `items` (`itemName`,`itemModelYear`,`itemListPrice`) VALUES ('Paper Dossier',2019, 250);
COMMIT;

