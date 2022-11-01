CREATE TABLE product (
    id INT NOT NULL AUTO_INCREMENT,
    name VARCHAR(100) NOT NULL,
    supplierOrderId INT NOT NULL,
    productTypeId INT NOT NULL,
    customerOrderId INT,
    PRIMARY KEY (id),
    FOREIGN KEY (supplierOrderId) REFERENCES supplierOrder(id) ON DELETE CASCADE,
    FOREIGN KEY (productTypeId) REFERENCES productType(id) ON DELETE CASCADE,
    FOREIGN KEY (customerOrderId) REFERENCES customerOrder(id) ON DELETE SET NULL
);

CREATE TABLE warranty (
    id INT NOT NULL AUTO_INCREMENT,
    coverage TEXT,
    productId INT NOT NULL,
    customerId INT,
    endDate DATE,
    PRIMARY KEY (id),
    FOREIGN KEY (productId) REFERENCES product(id) ON DELETE CASCADE,
    FOREIGN KEY (customerId) REFERENCES customer(id) ON DELETE SET NULL
);

CREATE TABLE orderedProductType (
    id INT NOT NULL AUTO_INCREMENT,
    supplierOrderId INT NOT NULL,
    quantity INT NOT NULL,
    productTypeId INT NOT NULL,
    numberDelivered INT NOT NULL,
    PRIMARY KEY (id),
    FOREIGN KEY (productTypeId) REFERENCES productType(id),
    FOREIGN KEY (supplierOrderId) REFERENCES supplierOrder(id)
);
ALTER TABLE bill RENAME COLUMN GSTNumber TO gstNumber;
ALTER TABLE bill RENAME COLUMN Amount TO amount;
ALTER TABLE bill RENAME COLUMN Discount TO discount;
ALTER TABLE transaction RENAME COLUMN BankBranch TO bankBranch;
ALTER TABLE transaction RENAME COLUMN ProductType TO productType;
ALTER TABLE transaction RENAME COLUMN AccountNumber TO accountNumber;
ALTER TABLE transaction RENAME COLUMN VerificationStatus TO verificationStatus;
ALTER TABLE transaction RENAME COLUMN DateOfTransaction TO dateOfTransaction;
ALTER TABLE transaction RENAME COLUMN BankName TO bankName;