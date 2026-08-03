-- V1: The initial release of our application. 
-- We only needed to store the employee's name.

CREATE TABLE employee (
    id BIGINT AUTO_INCREMENT PRIMARY KEY,
    name VARCHAR(255) NOT NULL
);

-- Let's insert some initial data as part of our migration!
INSERT INTO employee (name) VALUES ('John Doe');
INSERT INTO employee (name) VALUES ('Jane Smith');