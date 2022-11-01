CREATE TABLE bill (
	id INT NOT NULL AUTO_INCREMENT,
    GSTNumber VARCHAR(12) NOT NULL,
    Amount INT NOT NULL,
    Discount INT NOT NULL,
    netAmount INT NOT NULL,
    PRIMARY KEY (id)
);

CREATE TABLE feedback (
    id INT NOT NULL AUTO_INCREMENT PRIMARY KEY,
    reviews TEXT,
    complaints TEXT,
    suggestions TEXT,
    rating INT NOT NULL,
    customerOrderId INT,
    PRIMARY KEY (id),
    FOREIGN KEY (id) REFERENCES customerOder(id)
);