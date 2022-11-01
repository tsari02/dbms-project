CREATE TABLE Transaction (
    TransactionId INT NOT NULL AUTO_INCREMENT,
    BankBranch VARCHAR(25) NOT NULL,
    ProductType INT NOT NULL,
    AccountNumber INT NOT NULL,
    amount INT NOT NULL,
    mode VARCHAR(25) NOT NULL,
    VerificationStatus VARCHAR(25) NOT NULL,
    DateofTrans DATE NOT NULL,
    BankName VARCHAR(25) NOT NULL,
    PRIMARY KEY(id)
)