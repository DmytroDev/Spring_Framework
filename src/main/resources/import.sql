INSERT INTO CATEGORY (CATEGORY, DESCRIPTION)
VALUES ('Games', 'Games description'),
  ('Multimedia', 'Multimedia  description'),
  ('Productivity', 'Productivity  description'),
  ('Tools', NULL),
  ('Health', 'Health  description'),
  ('Lifestyle', 'Lifestyle  description');
INSERT INTO SOFTWARE (PACKAGE, CATEGORY, DESCRIPTION, APP_NAME, PICTURE_128, PICTURE_512, DOWNLOADS_NUM)
VALUES ('com', 'Games', 'First Game', 'Alladin', NULL, NULL, 1),
  ('com', 'Games', 'Second Game', 'Zeus', NULL, NULL, 2),
  ('net', 'Multimedia', 'First Show', 'Ukraine got talent', NULL, NULL, 3),
  ('net', 'Productivity', 'First Debugger', 'JDebugger', NULL, NULL, 4),
  ('io', 'Tools', 'SQL IDE', 'SQL DEVELOPER', NULL, NULL, 5),
  ('io', 'Tools', 'Java IDE', 'Intellij IDEA', NULL, NULL, 15),
  ('io', 'Health', 'Health practice', 'Yoga', NULL, NULL, 5),
  ('com', 'Lifestyle', 'Style', 'Casual', NULL, NULL, 25),
  ('net', 'Multimedia', 'Virtual reality', '3D Glasses', NULL, NULL, 25),
  ('io', 'Health', 'Sport', 'Swimming teacher', NULL, NULL, 2),
  ('com', 'Tools', 'Service', 'Google search', NULL, NULL, 20),
  ('io', 'Health', 'Sport', 'Swimming teacher', NULL, NULL, 15),
  ('net', 'Lifestyle', 'Social Network', 'Odnoklassniki', NULL, NULL, 8),
  ('io', 'Lifestyle', 'Social Network', 'Twitter', NULL, NULL, 10),
  ('com', 'Tools', 'Messager', 'Skype', NULL, NULL, 15),
  ('net', 'Tools', 'WithoutImage', 'WithoutImage', NULL, NULL, 1);
INSERT INTO USERS (LOGIN, PASSWORD, ROLE, DESCRIPTION)
VALUES ('admin', '8c6976e5b5410415bde908bd4dee15dfb167a9c873fc4bb8a81f6f2ab448a918', 'ROLE_ADMIN', 'admin desc'),
 ('user', '04f8996da763b7a969b1028ee3007569eaf3a635486ddab211d512c85b9df8fb', 'ROLE_USER', 'user desc'),
 ('1', '6b86b273ff34fce19d6b804eff5a3f5747ada4eaa22f1d49c01e52ddb7875b4b', 'ROLE_ANONYMOUS', 'anonymous desc'),
 ('anonymous', '2f183a4e64493af3f377f745eda502363cd3e7ef6e4d266d444758de0a85fcc8', 'ROLE_ANONYMOUS', 'anonymous desc');
COMMIT;
