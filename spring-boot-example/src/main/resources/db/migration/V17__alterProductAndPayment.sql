ALTER TABLE orderedProductType
DROP CONSTRAINT orderedProductType_ibfk_1;
ALTER TABLE product
DROP CONSTRAINT product_ibfk_2;
ALTER TABLE productSpecification
DROP CONSTRAINT productSpecification_ibfk_1;
TRUNCATE table productType;

ALTER TABLE orderedProductType
ADD CONSTRAINT orderedProductType_ibfk_1 FOREIGN KEY (productTypeId) REFERENCES productType(id);

ALTER TABLE product
ADD CONSTRAINT product_ibfk_2 FOREIGN KEY (productTypeId) REFERENCES productType(id) ON DELETE CASCADE;

ALTER TABLE productSpecification
ADD CONSTRAINT productS foreign key (productTypeId) references productType(id);

ALTER TABLE productType
DROP COLUMN productImage;

ALTER TABLE productType
ADD COLUMN price INT NOT NULL;
