CREATE TYPE role_enum AS ENUM ('ROLE_USER', 'ROLE_ADMIN');

CREATE TABLE "user" (
                          user_id SERIAL PRIMARY KEY,
                          "name" VARCHAR(100) NOT NULL,
                          email VARCHAR(100) UNIQUE NOT NULL,
                          password VARCHAR(255) NOT NULL,
                          created_at TIMESTAMP DEFAULT NOW(),
                          role role_enum NOT NULL DEFAULT 'ROLE_USER'
);