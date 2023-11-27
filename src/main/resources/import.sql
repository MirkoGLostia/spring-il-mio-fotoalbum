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

INSERT INTO photos (description, image, title, visible, user_photo_id) VALUES('description 1', 'https://www.artmajeur.com/medias/standard/f/r/fractal-art-by-nitisara/artwork/16038106_spiral-2-red.jpg', 'image 1', 1, 1);
INSERT INTO photos (description, image, title, visible, user_photo_id) VALUES('description 2', 'https://images.squarespace-cdn.com/content/v1/613a361fc8d81a69ab6624cc/1680826445989-H4BU0091HTBLDA6DDFXO/fractal_image.jpeg?format=500w', 'image 2', 0, 2);

-- categories --

INSERT INTO categories (description, name) VALUES('description 1', 'category 1');
INSERT INTO categories (description, name) VALUES('description 2', 'category 2');
INSERT INTO categories (description, name) VALUES('description 3', 'category 3');

-- category_photo --

INSERT INTO photos_categories (photos_id, categories_id) VALUES(1, 1);
INSERT INTO photos_categories (photos_id, categories_id) VALUES(1, 2);
INSERT INTO photos_categories (photos_id, categories_id) VALUES(2, 3);
INSERT INTO photos_categories (photos_id, categories_id) VALUES(2, 1);

-- messages --

INSERT INTO messages (email, message, read_mex, user_message_id) VALUES('admirer1@mail.com', 'love it', 0, 1);