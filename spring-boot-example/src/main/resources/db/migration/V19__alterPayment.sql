ALTER TABLE payment
DROP CONSTRAINT payment_ibfk_2;

ALTER TABLE payment
MODIFY transactionId INT;

ALTER TABLE payment
ADD CONSTRAINT payment_ibfk_2 FOREIGN KEY (transactionId) REFERENCES transaction(id) ON DELETE SET NULL;