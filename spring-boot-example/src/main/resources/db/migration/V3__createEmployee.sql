CREATE TABLE employee (
    id INT NOT NULL AUTO_INCREMENT,
    firstName VARCHAR(25) NOT NULL,
    middleName VARCHAR(50),
    lastName VARCHAR(25),
    contactNumber VARCHAR(20) NOT NULL,
    designation VARCHAR(30) NOT NULL,
    salary INT NOT NULL,
    dateOfBirth Date NOT NULL,
    emailId VARCHAR(255) NOT NULL,
    city VARCHAR(50) NOT NULl,
    state VARCHAR(50) NOT NULL,
    postalCode VARCHAR(10) NOT NULL,
    country VARCHAR(50) NOT NULL,
    street VARCHAR(50) NOT NULL,
    PRIMARY KEY (id)
);