INSERT INTO user (username, email, password) VALUES
('john_doe', 'john.doe@example.com', 'password123'),
('jane_smith', 'jane.smith@example.com', 'securepass');

INSERT INTO privilege (name, resource_key) VALUES
('READ_PRIVILEGE', 'read_key'),
('WRITE_PRIVILEGE', 'write_key');

INSERT INTO assigned_privilege (assigned_since, user_id, privilege_id) VALUES
('2025-10-07', 1, 1),
('2025-10-07', 2, 2);