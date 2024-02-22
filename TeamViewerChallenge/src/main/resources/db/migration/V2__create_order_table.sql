CREATE TABLE orders (
    id SERIAL PRIMARY KEY,
    customer_name VARCHAR(255) NOT NULL,
    order_date TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    total_amount DECIMAL(10,2) NOT NULL,
    shipping_address VARCHAR(255),
    status VARCHAR(50) NOT NULL,
    -- Add other fields as needed for orders
);
