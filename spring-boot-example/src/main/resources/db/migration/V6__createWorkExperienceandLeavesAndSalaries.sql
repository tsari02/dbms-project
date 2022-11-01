CREATE TABLE leavesAndSalaries (
    id INT NOT NULL AUTO_INCREMENT,
    leavesTaken INT NOT NULL, 
    leavesAllowed INT NOT NULL,
    year INT NOT NULL,
    month INT NOT NULL,
    overtime INT NOT NULL,
    bonus INT NOT NULL,
    penalty INT NOT NULL,
    employeeId INT NOT NULL,
    PRIMARY KEY(id),
    FOREIGN KEY(employeeId) REFERENCES employee(id) ON DELETE CASCADE
);

CREATE TABLE workExperience (
    id INT NOT NULL AUTO_INCREMENT,
    employeeId int NOT NULL,
    designation VARCHAR(20) NOT NULL,
    joiningDate DATE NOT NULL,
    leavingDate DATE NOT NULL,
    PRIMARY KEY(id),
    FOREIGN KEY(employeeId) REFERENCES employee(id) ON DELETE CASCADE
);