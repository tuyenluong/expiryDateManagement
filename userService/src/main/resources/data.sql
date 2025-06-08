INSERT INTO authority (id, name) VALUES (1, 'APPROVE_LEAVE');
INSERT INTO role (id, name) VALUES (1, 'ROLE_HR_MANAGER');
INSERT INTO role_authorities (role_id, authorities_id) VALUES (1, 1);
INSERT INTO user (id, username, password) VALUES (1, 'john', 'encoded-password');
INSERT INTO user_roles (user_id, roles_id) VALUES (1, 1);