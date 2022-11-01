DROP TABLE IF EXISTS person;
CREATE TABLE supplierOrder (
    id INT NOT NULL AUTO_INCREMENT,
    dateOfOrder DATE,
    status VARCHAR(20),
    supplierId INT,
    PRIMARY KEY (id),
    FOREIGN KEY (supplierId) REFERENCES supplier(id) ON DELETE SET NULL
);