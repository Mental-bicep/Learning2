-- V2: A new business requirement came in! 
-- We now need to store the employee's email address.

ALTER TABLE employee 
ADD COLUMN email VARCHAR(255);

-- We can even update existing records so they aren't completely blank
UPDATE employee SET email = 'pending@company.com' WHERE email IS NULL;