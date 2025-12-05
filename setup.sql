-- Create database
CREATE DATABASE IF NOT EXISTS hostel_db;

-- Use the database
USE hostel_db;

-- Create rooms table
CREATE TABLE IF NOT EXISTS rooms (
    room_id INT AUTO_INCREMENT PRIMARY KEY,
    room_number INT UNIQUE NOT NULL,
    room_type VARCHAR(50) NOT NULL,
    price DECIMAL(10, 2) NOT NULL,
    availability VARCHAR(20) NOT NULL
);
