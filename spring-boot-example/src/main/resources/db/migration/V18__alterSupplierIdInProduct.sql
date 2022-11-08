ALTER TABLE product
DROP CONSTRAINT product_ibfk_1;

ALTER TABLE product
MODIFY supplierOrderId INT;

ALTER TABLE product
ADD CONSTRAINT product_ibfk_1 FOREIGN KEY (supplierOrderId) REFERENCES supplierOrder(id) ON DELETE SET NULL;