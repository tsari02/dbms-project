ALTER TABLE customerOrder
MODIFY deliveryDate DATE;

ALTER TABLE customerOrder
ADD deliveryAgentAssignedBoolean BOOLEAN DEFAULT FALSE;

ALTER TABLE customerOrder
DROP COLUMN deliveryAgentAssigned;

ALTER TABLE customerOrder
RENAME COLUMN deliveryAgentAssignedBoolean TO deliveryAgentAssigned;