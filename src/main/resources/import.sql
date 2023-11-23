-- photos --

INSERT INTO photos (description, image, title, visible) VALUES('description 1', 'url 1', 'image 1', 1);
INSERT INTO photos (description, image, title, visible) VALUES('description 2', 'url 2', 'image 2', 0);

-- categories --

INSERT INTO categories (description, name) VALUES('description 1', 'category 1');
INSERT INTO categories (description, name) VALUES('description 2', 'category 2');
INSERT INTO categories (description, name) VALUES('description 3', 'category 3');

-- category_photo --

INSERT INTO photos_categories (photos_id, categories_id) VALUES(1, 1);
INSERT INTO photos_categories (photos_id, categories_id) VALUES(1, 2);
INSERT INTO photos_categories (photos_id, categories_id) VALUES(2, 3);
INSERT INTO photos_categories (photos_id, categories_id) VALUES(2, 1);