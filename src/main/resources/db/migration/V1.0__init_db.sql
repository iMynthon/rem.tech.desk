CREATE SEQUENCE tech_desk_schema.account_connection_id_seq START 10000;

CREATE TABLE tech_desk_schema.account(
    id UUID PRIMARY KEY DEFAULT gen_random_uuid(),
    email VARCHAR(100) UNIQUE NOT NULL,
    username VARCHAR(100) UNIQUE NOT NULL,
    password VARCHAR(255) UNIQUE NOT NULL,
    connection_id BIGINT DEFAULT nextval('tech_desk_schema.account_connection_id_seq') UNIQUE,
    is_online BOOLEAN default false,
    picture VARCHAR(255),
    created_at TIMESTAMP default current_timestamp,
    last_login TIMESTAMP
);


