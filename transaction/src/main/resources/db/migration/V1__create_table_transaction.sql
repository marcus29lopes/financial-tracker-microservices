CREATE TABLE transactions (
    transaction_id SERIAL PRIMARY KEY,
    user_id VARCHAR,
    user_email VARCHAR,
    category_id VARCHAR NOT NULL ,
    category_name VARCHAR,
    type_id VARCHAR,
    type_name VARCHAR,
    value NUMERIC(15,2) NOT NULL,
    receipt_url TEXT,
    created_at TIMESTAMP DEFAULT NOW(),
    description TEXT

);