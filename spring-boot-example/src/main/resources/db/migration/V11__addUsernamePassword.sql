ALTER TABLE employee
ADD username VARCHAR(255);
ALTER TABLE employee
ADD password VARCHAR(255) NOT NULL DEFAULT '$2a$10$c9p5GncgKrRBVOQ/CfN8m.kQZeimFYyQHa7L8Jjs8Y/F4/qKbku12';

UPDATE employee
SET username = UUID();

ALTER TABLE employee
MODIFY username VARCHAR(255) UNIQUE NOT NULL;

ALTER TABLE employee
MODIFY designation ENUM('Employee', 'Manager', 'Admin') NOT NULL DEFAULT ('Employee');