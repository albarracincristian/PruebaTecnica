CREATE TABLE Employee (
    employee_id INT NOT NULL,
    first_name VARCHAR(45) NOT NULL,
    last_name VARCHAR(45) NOT NULL,
    gender VARCHAR(45) NOT NULL,
    CONSTRAINT employee_pk PRIMARY KEY (employee_id)
);

CREATE TABLE Registration (
    registration_id INT NOT NULL AUTO_INCREMENT,
    employee_id INT NOT NULL,
    date DATE NOT NULL,
    register_type VARCHAR(7) NOT NULL,
    business_location VARCHAR(9) NOT NULL,
    CONSTRAINT registration_pk PRIMARY KEY (registration_id),
    CONSTRAINT employee_fk FOREIGN KEY (employee_id) REFERENCES Employee (employee_id)
);

INSERT INTO Employee VALUES (1,'Romina','Alaniz','Femenino');
INSERT INTO Employee VALUES (2,'Carlos','Lucero','Masculino');
INSERT INTO Employee VALUES (3,'Tomas','Baigorria','Masculino');
INSERT INTO Employee VALUES (4,'Victoria','Demarchi','Femenino');
INSERT INTO Employee VALUES (5,'Eugenia','Perez','Femenino');
INSERT INTO Employee VALUES (6,'Alberto','Miranda','Masculino');
INSERT INTO Employee VALUES (7,'Gonzalo','Correa','Masculino');
INSERT INTO Employee VALUES (8,'Julio','Baez','Masculino');
INSERT INTO Employee VALUES (9,'Analia','Lopez','femenino');
INSERT INTO Employee VALUES (10,'Brenda','Zavala','femenino');

INSERT INTO Registration VALUES (1,1,'2023-4-15','ingreso','Argentina');
INSERT INTO Registration VALUES (2,1,'2023-4-16','egreso','Argentina');
INSERT INTO Registration VALUES (3,2,'2023-4-15','ingreso','Argentina');
INSERT INTO Registration VALUES (4,2,'2023-4-15','egreso','Argentina');
INSERT INTO Registration VALUES (5,2,'2023-5-15','ingreso','Argentina');
INSERT INTO Registration VALUES (6,2,'2023-5-15','egreso','Argentina');
INSERT INTO Registration VALUES (7,3,'2023-5-15','ingreso','Brasil');
INSERT INTO Registration VALUES (8,3,'2023-5-15','egreso','Brasil');
INSERT INTO Registration VALUES (9,4,'2023-5-16','ingreso','Brasil');
INSERT INTO Registration VALUES (10,4,'2023-5-17','egreso','Brasil');
INSERT INTO Registration VALUES (11,4,'2023-6-15','ingreso','Brasil');
INSERT INTO Registration VALUES (12,4,'2023-6-15','egreso','Brasil');
INSERT INTO Registration VALUES (13,5,'2023-5-15','ingreso','España');
INSERT INTO Registration VALUES (14,5,'2023-5-15','egreso','España');
INSERT INTO Registration VALUES (15,5,'2023-5-16','ingreso','España');
INSERT INTO Registration VALUES (16,5,'2023-5-17','egreso','España');
INSERT INTO Registration VALUES (17,6,'2023-6-16','ingreso','España');
INSERT INTO Registration VALUES (18,6,'2023-6-15','egreso','España');
INSERT INTO Registration VALUES (19,6,'2023-7-15','ingreso','España');
INSERT INTO Registration VALUES (20,6,'2023-7-15','egreso','España');
INSERT INTO Registration VALUES (21,7,'2023-6-15','ingreso','Argentina');
INSERT INTO Registration VALUES (22,7,'2023-6-15','egreso','Argentina');
INSERT INTO Registration VALUES (23,8,'2023-5-15','ingreso','Brasil');
INSERT INTO Registration VALUES (24,8,'2023-5-15','egreso','Brasil');
INSERT INTO Registration VALUES (25,9,'2023-5-16','ingreso','España');
INSERT INTO Registration VALUES (27,9,'2023-5-17','egreso','España');
INSERT INTO Registration VALUES (28,10,'2023-5-17','ingreso','España');
INSERT INTO Registration VALUES (29,10,'2023-5-17','egreso','España');
INSERT INTO Registration VALUES (30,10,'202-5-18','ingreso','España');






























