-- users --

INSERT INTO users (email, nickname, password) VALUES('admin@mail.com', 'adminlexi', '{noop}pass');
INSERT INTO users (email, nickname, password) VALUES('user@mail.com', 'userlexi', '{noop}pass');

-- role --

INSERT INTO roles (name) VALUES('admin');
INSERT INTO roles (name) VALUES('user');

-- role_user --

INSERT INTO users_roles (user_id, roles_id) VALUES(1, 1);
INSERT INTO users_roles (user_id, roles_id) VALUES(1, 2);
INSERT INTO users_roles (user_id, roles_id) VALUES(2, 2);

-- photos --

INSERT INTO photos (description, image, title, visible, user_id) VALUES('description 1', 'url 1', 'image 1', 1, 1);
INSERT INTO photos (description, image, title, visible, user_id) VALUES('description 2', 'url 2', 'image 2', 0, 2);

-- categories --

INSERT INTO categories (description, name) VALUES('description 1', 'category 1');
INSERT INTO categories (description, name) VALUES('description 2', 'category 2');
INSERT INTO categories (description, name) VALUES('description 3', 'category 3');

-- category_photo --

INSERT INTO photos_categories (photos_id, categories_id) VALUES(1, 1);
INSERT INTO photos_categories (photos_id, categories_id) VALUES(1, 2);
INSERT INTO photos_categories (photos_id, categories_id) VALUES(2, 3);
INSERT INTO photos_categories (photos_id, categories_id) VALUES(2, 1);