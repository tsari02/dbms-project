CREATE TABLE customerOrder (
    customerOrderId INT NOT NULL AUTO_INCREMENT,
    deliveryAgentAssigned VARCHAR(25) NOT NULL,
    verificationStatus BOOLEAN NOT NULL,
    deliveryDate DATE NOT NULL,
    orderedDate DATE NOT NULL,
    customerId INT NOT NULL,
    employeeId INT NOT NULL,
    PRIMARY KEY(customerOrderId)
    FOREIGN KEY (customerId) REFERENCES customer(id) ON DELETE SET NULL,
    FOREIGN KEY (employeeId) REFERENCES employee(id) ON DELETE SET NULL
);

CREATE TABLE productType (
    id INT NOT NULL AUTO_INCREMENT,
    type VARCHAR(25) NOT NULL,
    productImage VARCHAR(255) NOT NULL,
    warrantyPeriod INT NOT NULL,
    quantity INT NOT NULL,
    PRIMARY KEY(id)
);