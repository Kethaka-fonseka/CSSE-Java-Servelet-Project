CREATE TABLE users (
	u_id varchar(50) primary key,
	u_role varchar(100),
    u_name  varchar(100),
    u_mail  varchar(100),
    u_pass  varchar(100)
    
);

INSERT INTO users (u_id,u_role, u_name, u_mail, u_pass) VALUES ("E3001", "admin", "admin", "admin@gmail.com", "1234");


CREATE TABLE suppliers(
				s_id int primary key AUTO_INCREMENT,
				s_company_name varchar(50),
                s_mob_num int,
				u_id varchar(50) NOT NULL,
			
                CONSTRAINT supplier_user_fk FOREIGN KEY(u_id) REFERENCES users(u_id)
); 

  
  CREATE TABLE items(
				i_id int primary key AUTO_INCREMENT,
				i_name varchar(50),
				i_quantity int,
                i_unit_price int,
				s_id int NOT NULL,
                CONSTRAINT supplier_item_fk FOREIGN KEY(s_id) REFERENCES suppliers(s_id)
);	


CREATE TABLE pro_staff(
				p_id  int primary key AUTO_INCREMENT,
                p_mob_num int,
                p_role varchar(50),
				u_id varchar(50) NOT NULL,
			
                CONSTRAINT staff_user_fk FOREIGN KEY(u_id) REFERENCES users(u_id)
);


 CREATE TABLE sites(
		    site_id int primary key AUTO_INCREMENT,
                site_name varchar(50) UNIQUE,
                site_location varchar(50),
                site_budget int,
                minimum_budget int
); 

CREATE TABLE site_managers(

		        m_id int primary key AUTO_INCREMENT,
                m_mob_num int,
		        site_name varchar(50) NOT NULL,
                u_id varchar(50) NOT NULL,
                CONSTRAINT site_manager_fk FOREIGN KEY(site_name) REFERENCES sites(site_name),
                CONSTRAINT site_manager_user_fk FOREIGN KEY(u_id) REFERENCES users(u_id)
); 
CREATE TABLE requisition(

		        r_id int primary key AUTO_INCREMENT,
                requisitionType varchar(20) NOT NULL,
                requestedBy varchar (20) NOT NULL,
                siteLocation varchar (20) NOT  NULL,
                itemName varchar(20) NOT NULL,
                itemQty int NOT NULL,
                requestedPrice float NOT NULL,
                status varchar(10) NOT NULL,
                totalPrice float  NOT NULL

);


