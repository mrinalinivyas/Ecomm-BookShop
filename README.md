# Ecomm-BookShop

An e-commerce website with MVC design pattern and RESTFul web services
The project is connected to MySQL to store the database for Book, User, Address, purchaseOrder and poitem tables
Hibernate is the ORM tool used to connect the DB with the web application

Tables in DB:

CREATE TABLE BOOK (
 bookid      VARCHAR(20) NOT NULL,
 title     VARCHAR(100) NOT NULL,
 price     INT UNSIGNED NOT NULL,
 author     VARCHAR(100) NOT NULL,
 category  ENUM('Biography and Memoir','Business and Finance','Computers', 'Entertainment', 'History', 'Fiction', 'Science Fiction', 'Self-Help', 'Health', 'Science and Nature', 'Poetry') NOT NULL,
 PRIMARY KEY(bookid)
) ;

CREATE TABLE User (
 customerid       INT UNSIGNED NOT NULL,
 fname     VARCHAR(20) NOT NULL,
 lname    VARCHAR(20) NOT NULL,
 pwd    VARCHAR(20) NOT NULL,
 email   VARCHAR(30) NOT NULL,
 PRIMARY KEY(customerid)
) ;

CREATE TABLE Address (
 id 	     INT UNSIGNED NOT NULL AUTO_INCREMENT,
 street    VARCHAR(100) NOT NULL,
 province  VARCHAR(20)  NOT NULL,
 country   VARCHAR(20)  NOT NULL,
 zip       VARCHAR(20)  NOT NULL,
 phone     VARCHAR(20),
 customerid  INT UNSIGNED NOT NULL,
 PRIMARY KEY(id)
 FOREIGN KEY (customerid) REFERENCES User (customerid) ON DELETE CASCADE
) ;

CREATE TABLE PurchaseOrder (
 id        INT UNSIGNED NOT NULL AUTO_INCREMENT,
 lname     VARCHAR(20) NOT NULL,
 fname     VARCHAR(20) NOT NULL,
 status    ENUM('ORDERED','PROCESSED','DENIED') NOT NULL,
 address   INT UNSIGNED NOT NULL,
 PRIMARY KEY(id),
 INDEX (address),
 FOREIGN KEY (address) REFERENCES Address (id) ON DELETE CASCADE
) ;

CREATE TABLE POItem (
 id       INT UNSIGNED NOT NULL,
 bookid     VARCHAR(20) NOT NULL,
 price    INT UNSIGNED NOT NULL,
 PRIMARY KEY(id,bookid),
 INDEX (id),
 FOREIGN KEY(id) REFERENCES PO(id) ON DELETE CASCADE,
 INDEX (bookid),
 FOREIGN KEY(bookid) REFERENCES BOOK(bookid) ON DELETE CASCADE
) ;
