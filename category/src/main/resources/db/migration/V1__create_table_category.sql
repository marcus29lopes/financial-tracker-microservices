CREATE TABLE category (
                          category_id SERIAL PRIMARY KEY,
                          name VARCHAR(100) NOT NULL,
                          created_at TIMESTAMP DEFAULT NOW()
);