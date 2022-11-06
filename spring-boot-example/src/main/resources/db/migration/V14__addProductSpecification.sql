create table productSpecification(
	id int not null auto_increment,
    specificationName Varchar(20),
    specificationText Varchar(100),
    productTypeId int,
    primary key (id),
    foreign key (productTypeId) references productType(id)
);