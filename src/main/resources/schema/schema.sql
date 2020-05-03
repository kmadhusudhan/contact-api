create database contact_api;
use  contact_api;
create table contacts(id int(11) NOT NULL auto_increment PRIMARY KEY,email varchar(60)  NOT NULL,name varchar(60)  NOT NULL,phoneNumber varchar(15),createdAT timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP,updateAT timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,isDeleted boolean DEFAULT false);

CREATE UNIQUE INDEX contacts_email_index on contacts(email);
