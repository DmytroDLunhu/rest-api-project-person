CREATE TABLE people (
  id         BIGINT AUTO_INCREMENT PRIMARY KEY,
  first_name VARCHAR(50)   NOT NULL,
  last_name  VARCHAR(50)  NOT NULL,
  email      VARCHAR(50) NOT NULL,
  age        INT           NOT NULL
);

insert into people values (1, 'John', 'Smith', 'aaa@gmail.com', 33);
insert into people values (2, 'Bob', 'Dodge', 'bbb@gmail.com', 44);
insert into people values (3, 'Harry', 'Merc', 'ccc@gmail.com', 55);
insert into people values (4, 'Mike', 'Lexus', 'ddd@gmail.com', 66);
insert into people values (5, 'Leo', 'Van', 'eee@gmail.com', 77);