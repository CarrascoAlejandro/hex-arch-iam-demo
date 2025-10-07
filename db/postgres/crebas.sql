CREATE TABLE IF NOT EXISTS "user" (
    id BIGSERIAL PRIMARY KEY,
    username VARCHAR(255) NOT NULL UNIQUE,
    email VARCHAR(255) NOT NULL UNIQUE,
    password VARCHAR(255) NOT NULL
);

CREATE TABLE IF NOT EXISTS privilege (
    id BIGSERIAL PRIMARY KEY,
    name VARCHAR(255) NOT NULL UNIQUE,
    resource_key VARCHAR(255) NOT NULL UNIQUE
);

CREATE TABLE IF NOT EXISTS assigned_privilege (
    id BIGSERIAL PRIMARY KEY,
    assigned_since TIMESTAMP NOT NULL,
    user_id BIGINT NOT NULL,
    privilege_id BIGINT NOT NULL,
    FOREIGN KEY (user_id) REFERENCES "user"(id),
    FOREIGN KEY (privilege_id) REFERENCES privilege(id)
);

