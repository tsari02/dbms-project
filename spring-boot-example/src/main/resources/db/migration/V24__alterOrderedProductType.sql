ALTER TABLE orderedProductType
DROP CONSTRAINT orderedProductType_ibfk_2;

ALTER TABLE orderedProductType
ADD CONSTRAINT orderedProductType_ibfk_2 FOREIGN KEY (supplierOrderId) REFERENCES supplierOrder(id) ON DELETE CASCADE;

