ALTER TABLE product
DROP COLUMN name;

ALTER TABLE productType
RENAME COLUMN type TO name;