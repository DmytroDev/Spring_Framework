SET @SoftwareDesc='Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua. Ut enim ad minim veniam, quis nostrud exercitation ullamco laboris nisi ut aliquip ex ea commodo consequat. Duis aute irure dolor in reprehenderit in voluptate velit esse cillum dolore eu fugiat nulla pariatur. Excepteur sint occaecat cupidatat non proident, sunt in culpa qui officia deserunt mollit anim id est laborum.';
INSERT INTO CATEGORY (CATEGORY_NAME, DESCRIPTION)
VALUES ('Games', 'Games description'),
  ('Multimedia', 'Multimedia  description'),
  ('Productivity', 'Productivity  description'),
  ('Tools', NULL),
  ('Health', 'Health  description'),
  ('Lifestyle', 'Lifestyle  description');
INSERT INTO SOFTWARE (PACKAGE, CATEGORY_NAME, DESCRIPTION, APP_NAME, PICTURE_128, PICTURE_512, DOWNLOADS_NUM, TIME_UPLOADED)
VALUES ('com', 'Games', @SoftwareDesc, 'Alladin', NULL, NULL, 1, 130),
  ('com', 'Games', @SoftwareDesc, 'Zeus', NULL, NULL, 2, 200),
  ('net', 'Multimedia', @SoftwareDesc, 'Amazon', NULL, NULL, 3, 400),
  ('net', 'Productivity', @SoftwareDesc, 'JDebugger', NULL, NULL, 4, 1000),
  ('io', 'Tools', @SoftwareDesc, 'Ebay', NULL, NULL, 5, 320),
  ('io', 'Tools', @SoftwareDesc, 'Intellij IDEA', NULL, NULL, 15, 500),
  ('io', 'Health', @SoftwareDesc, 'Facebook', NULL, NULL, 5, 220),
  ('com', 'Lifestyle', @SoftwareDesc, 'Casual', NULL, NULL, 25, 550),
  ('net', 'Multimedia', @SoftwareDesc, 'Google', NULL, NULL, 25, 990),
  ('io', 'Health', @SoftwareDesc, 'LinkedIn', NULL, NULL, 2, 330),
  ('com', 'Tools', @SoftwareDesc, 'Odnoklassniki', NULL, NULL, 20, 100),
  ('io', 'Health', @SoftwareDesc, 'RSS', NULL, NULL, 15, 380),
  ('net', 'Lifestyle', @SoftwareDesc, 'Skype', NULL, NULL, 8, 1500),
  ('io', 'Lifestyle', @SoftwareDesc, '3D glasses', NULL, NULL, 10, 700),
  ('com', 'Tools', @SoftwareDesc, 'Twitter', NULL, NULL, 15, 400),
  ('net', 'Tools', @SoftwareDesc, 'WithoutImage', NULL, NULL, 1, 300);
INSERT INTO USERS (LOGIN, PASSWORD, ROLE, DESCRIPTION)
VALUES ('admin', '8c6976e5b5410415bde908bd4dee15dfb167a9c873fc4bb8a81f6f2ab448a918', 'ROLE_ADMIN', 'admin desc'),
 ('user', '04f8996da763b7a969b1028ee3007569eaf3a635486ddab211d512c85b9df8fb', 'ROLE_USER', 'user desc'),
 ('1', '6b86b273ff34fce19d6b804eff5a3f5747ada4eaa22f1d49c01e52ddb7875b4b', 'ROLE_ANONYMOUS', 'anonymous desc'),
 ('anonymous', '2f183a4e64493af3f377f745eda502363cd3e7ef6e4d266d444758de0a85fcc8', 'ROLE_ANONYMOUS', 'anonymous desc');
COMMIT;
