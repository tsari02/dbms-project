CREATE TABLE contactForm (
    id INT NOT NULL AUTO_INCREMENT,
    emailId VARCHAR(25),
    name VARCHAR(25),
    contactNumber VARCHAR(25),
    reply TEXT,
    query TEXT,
    customerId INT NOT NULL,
    PRIMARY KEY (id),
    FOREIGN KEY (customerId) REFERENCES customer(id) ON DELETE CASCADE
);
ALTER TABLE Transaction RENAME transaction;
CREATE TABLE payment (
    id INT NOT NULL AUTO_INCREMENT,
    customerOrderId INT NOT NULL,
    transactionId INT NOT NULL,
    billId INT NOT NULL,
    PRIMARY KEY (id),
    FOREIGN KEY (customerOrderId) REFERENCES customerOrder(id) ON DELETE CASCADE,
    FOREIGN KEY (transactionId) REFERENCES transaction(id) ON DELETE CASCADE,
    FOREIGN KEY (billId) REFERENCES bill(id) ON DELETE CASCADE
);

