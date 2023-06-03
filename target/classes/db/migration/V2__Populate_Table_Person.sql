CREATE TABLE IF NOT EXISTS person (
  id bigserial NOT NULL,
  first_name varchar(80) NOT NULL,
  last_name varchar(80) NOT NULL,
  address varchar(100) NOT NULL,
  gender varchar(6) NOT NULL,
  PRIMARY KEY (id)
);



INSERT INTO person (id, address, first_name, gender, last_name) VALUES
	(1, 'São Paulo', 'Ayrton', 'Male', 'Senna'),
	(2, 'Anchiano - Italy', 'Leonardo', 'Male', 'da Vinci'),
	(4, 'Porbandar - India', 'Indira', 'Female', 'Gandhi'),
	(5, 'Porbandar - India', 'Mahatma', 'Male', 'Gandhi'),
	(7, 'Kentucky - US', 'Muhammad', 'Male', 'Ali'),
	(9, 'Mvezo – South Africa', 'Nelson', 'Male', 'Mvezo'),
	(10, 'Smiljan - Croatia', 'Nikola', 'Male', 'Tesla');
