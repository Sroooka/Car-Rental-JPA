-- insert Employee Positions
INSERT INTO position (name, created, updated) VALUES ('dealer', now(), now());
INSERT INTO position (name, created, updated) VALUES ('manager', now(), now());
INSERT INTO position (name, created, updated) VALUES ('accountant', now(), now());

-- insert Car Types
INSERT INTO car_type (name, created, updated) VALUES ('sedan', now(), now());
INSERT INTO car_type (name, created, updated) VALUES ('wagon', now(), now());
INSERT INTO car_type (name, created, updated) VALUES ('suv', now(), now());
INSERT INTO car_type (name, created, updated) VALUES ('hatchback', now(), now());
INSERT INTO car_type (name, created, updated) VALUES ('cabriolet', now(), now());
INSERT INTO car_type (name, created, updated) VALUES ('coupe', now(), now());
INSERT INTO car_type (name, created, updated) VALUES ('pickup', now(), now());
INSERT INTO car_type (name, created, updated) VALUES ('4wd', now(), now());

-- insert Location
INSERT 	INTO location (address, city, postal_code, phone, email, created, updated) VALUES ('Bukowska 150', 'Poznan', '60123', '+(48)61-255-25-25', 'office.poznan@carrentalsroka.com', now(), now());
INSERT 	INTO location (address, city, postal_code, phone, email, created, updated) VALUES ('Niedzialkowskiego 1', 'Warszawa', '04112', '+(48)22-525-25-25', 'office.warszawa@carrentalsroka.com', now(), now());
INSERT 	INTO location (address, city, postal_code, phone, email, created, updated) VALUES ('Naramowiska 500', 'Gdansk', '12542', '+(48)14-143-25-25', 'office.gdansk@carrentalsroka.com', now(), now());
INSERT 	INTO location (address, city, postal_code, phone, email, created, updated) VALUES ('Przemyslowa 9', 'Krakow', '60123', '+(48)76-655-25-25', 'office.krakow@carrentalsroka.com', now(), now());
INSERT 	INTO location (address, city, postal_code, phone, email, created, updated) VALUES ('Dabrowskiego 13/9', 'Lodz', '87665', '+(48)17-654-25-25', 'office.lodz@carrentalsroka.com', now(), now());
		
-- insert Employee
INSERT INTO employee (name, surname, position_id, birth, location_id, created, updated)	VALUES('Antoni', 'kFowadis', 2, '1999-12-30', 1, now(), now());
INSERT INTO employee (name, surname, position_id, birth, location_id, created, updated)	VALUES('Jakub', 'Kowalski', 3, '1998-11-29', 1, now(), now());
INSERT INTO employee (name, surname, position_id, birth, location_id, created, updated)	VALUES('Jan', 'Wisniewski', 1, '1997-10-28', 1, now(), now());
INSERT INTO employee (name, surname, position_id, birth, location_id, created, updated)	VALUES('Szymon', 'Wojcik', 1, '1996-09-27', 1, now(), now());
INSERT INTO employee (name, surname, position_id, birth, location_id, created, updated)	VALUES('Franciszek', 'Kowalczyk', 1, '1995-08-26', 1, now(), now());
INSERT INTO employee (name, surname, position_id, birth, location_id, created, updated)	VALUES('Filip', 'Kaminski', 2, '1994-07-25', 2, now(), now());
INSERT INTO employee (name, surname, position_id, birth, location_id, created, updated)	VALUES('Aleksander', 'Lewandowski', 3, '1993-12-24', 2, now(), now());
INSERT INTO employee (name, surname, position_id, birth, location_id, created, updated)	VALUES('Wojciech', 'Zielinski', 1, '1992-12-23', 2, now(), now());
INSERT INTO employee (name, surname, position_id, birth, location_id, created, updated)	VALUES('Kacper', 'Szymanski', 1, '1991-06-22', 2, now(), now());
INSERT INTO employee (name, surname, position_id, birth, location_id, created, updated)	VALUES('Mikolaj', 'Wozniak', 1, '1990-08-21', 2, now(), now());
INSERT INTO employee (name, surname, position_id, birth, location_id, created, updated)	VALUES('Adam', 'Dabrowski', 2, '1989-07-20', 3, now(), now());
INSERT INTO employee (name, surname, position_id, birth, location_id, created, updated)	VALUES('Michau', 'Kozlowski', 3, '1988-03-19', 3, now(), now());
INSERT INTO employee (name, surname, position_id, birth, location_id, created, updated)	VALUES('Marcel', 'Jankowski', 1, '1987-08-18', 3, now(), now());
INSERT INTO employee (name, surname, position_id, birth, location_id, created, updated)	VALUES('Wiktor', 'Mazur', 1, '1986-12-17', 3, now(), now());
INSERT INTO employee (name, surname, position_id, birth, location_id, created, updated)	VALUES('Piotr', 'Wojciechowski', 1, '1985-02-16', 3, now(), now());
INSERT INTO employee (name, surname, position_id, birth, location_id, created, updated)	VALUES('Stanislaw', 'Kwiatkowski', 2, '1984-01-15', 4, now(), now());
INSERT INTO employee (name, surname, position_id, birth, location_id, created, updated)	VALUES('Igor', 'Krawczyk', 3, '1983-10-14', 4, now(), now());
INSERT INTO employee (name, surname, position_id, birth, location_id, created, updated)	VALUES('Mateusz', 'Kaczmarek', 1, '1982-10-13', 4, now(), now());
INSERT INTO employee (name, surname, position_id, birth, location_id, created, updated)	VALUES('Bartosz', 'Piotrowski', 1, '1981-11-12', 4, now(), now());
INSERT INTO employee (name, surname, position_id, birth, location_id, created, updated)	VALUES('Nikodem', 'Grabowski', 1, '1980-11-11', 4, now(), now());
INSERT INTO employee (name, surname, position_id, birth, location_id, created, updated)	VALUES('Leon', 'Zajac', 2, '1979-07-10', 5, now(), now());
INSERT INTO employee (name, surname, position_id, birth, location_id, created, updated)	VALUES('Milosz', 'Pawlowski', 3, '1978-06-09', 5, now(), now());
INSERT INTO employee (name, surname, position_id, birth, location_id, created, updated)	VALUES('Maksymilian', 'Michalski', 1, '1977-07-08', 5, now(), now());
INSERT INTO employee (name, surname, position_id, birth, location_id, created, updated)	VALUES('Tymon', 'Krol', 1, '1976-06-07', 5, now(), now());
INSERT INTO employee (name, surname, position_id, birth, location_id, created, updated)	VALUES('Alan', 'Wieczorek', 1, '1975-05-06', 5, now(), now());

-- insert Car
INSERT INTO car (manufacturer, model, production_year, type_id, color, engine_size, power, mileage, created, updated)	VALUES("Mercedes", "W204", 2012, 6, "white", 1796, 170, 120000, now(), now());
INSERT INTO car (manufacturer, model, production_year, type_id, color, engine_size, power, mileage, created, updated)	VALUES("Mercedes", "W205", 2017, 6, "white", 1796, 170, 150000, now(), now());
INSERT INTO car (manufacturer, model, production_year, type_id, color, engine_size, power, mileage, created, updated)	VALUES("Mercedes", "W204", 2014, 6, "red", 2200, 224, 200000, now(), now());
INSERT INTO car (manufacturer, model, production_year, type_id, color, engine_size, power, mileage, created, updated)	VALUES("Mercedes", "W205", 2017, 6, "black", 2200, 224, 199999, now(), now());
INSERT INTO car (manufacturer, model, production_year, type_id, color, engine_size, power, mileage, created, updated)	VALUES("Mercedes", "W204", 2012, 6, "black", 2200, 224, 300000, now(), now());
INSERT INTO car (manufacturer, model, production_year, type_id, color, engine_size, power, mileage, created, updated)	VALUES("Mercedes", "W204", 2012, 6, "silver", 2200, 224, 300001, now(), now());
INSERT INTO car (manufacturer, model, production_year, type_id, color, engine_size, power, mileage, created, updated)	VALUES("Mercedes", "W212", 2010, 1, "gray", 3196, 278, 299999, now(), now());
INSERT INTO car (manufacturer, model, production_year, type_id, color, engine_size, power, mileage, created, updated)	VALUES("Mercedes", "W212", 2012, 1, "yellow", 3196, 278, 80000, now(), now());
INSERT INTO car (manufacturer, model, production_year, type_id, color, engine_size, power, mileage, created, updated)	VALUES("Mercedes", "W212", 2011, 2, "red", 3196, 278, 123100, now(), now());
INSERT INTO car (manufacturer, model, production_year, type_id, color, engine_size, power, mileage, created, updated)	VALUES("Mercedes", "W212", 2010, 2, "black", 3196, 278, 145900, now(), now());
INSERT INTO car (manufacturer, model, production_year, type_id, color, engine_size, power, mileage, created, updated)	VALUES("Fiat", "Seicento", 1995, 4, "blue", 900, 80, 390000, now(), now());
INSERT INTO car (manufacturer, model, production_year, type_id, color, engine_size, power, mileage, created, updated)	VALUES("Fiat", "Tico", 1996, 4, "blue", 800, 63, 480000, now(), now());
INSERT INTO car (manufacturer, model, production_year, type_id, color, engine_size, power, mileage, created, updated)	VALUES("Fiat", "Tipo", 2005, 1, "orange", 1198, 98, 150220, now(), now());
INSERT INTO car (manufacturer, model, production_year, type_id, color, engine_size, power, mileage, created, updated)	VALUES("BMW", "E46", 2004, 2, "black", 2500, 178, 300000, now(), now());
INSERT INTO car (manufacturer, model, production_year, type_id, color, engine_size, power, mileage, created, updated)	VALUES("BMW", "E46", 2005, 2, "black", 2500, 178, 250000, now(), now());

-- insert Customer
INSERT INTO customer (name, surname, address, city, postal_code, birth_date, phone, email, credit_card_number, created, updated) VALUES("Julia", "Jablonska", "Nowakowskiego 5", "Poznan", "61-782", "1999-12-02", "+(48)985-659-651", "jjablonska@gmail.com", "9586589745848575485", now(), now());
INSERT INTO customer (name, surname, address, city, postal_code, birth_date, phone, email, credit_card_number, created, updated) VALUES("Zuzanna", "Wrobel", "Maleckiego 6", "Poznan", "61-732", "1998-02-12", "+(48)754-586-225", "zwrobel@gmail.com", "5485485623565895415", now(), now());
INSERT INTO customer (name, surname, address, city, postal_code, birth_date, phone, email, credit_card_number, created, updated) VALUES("Zofia", "Nowakowska", "Krakowska 50", "Poznan", "61-775", "1997-05-02", "+(48)741-585-317", "znowakowska@gmail.com", "8585854854859658426", now(), now());
INSERT INTO customer (name, surname, address, city, postal_code, birth_date, phone, email, credit_card_number, created, updated) VALUES("Lena", "Majewska", "Poznanska 90", "Poznan", "61-741", "1996-02-05", "+(48)555-856-621", "lmajewska@gmail.com", "9856565895215452154", now(), now());
INSERT INTO customer (name, surname, address, city, postal_code, birth_date, phone, email, credit_card_number, created, updated) VALUES("Maja", "Olszewska", "Bukowska 1", "Warszawa", "22-885", "1995-07-02", "+(48)745-658-558", "molszewska@gmail.com", "8585858582145698523", now(), now());
INSERT INTO customer (name, surname, address, city, postal_code, birth_date, phone, email, credit_card_number, created, updated) VALUES("Hanna", "Stepien", "Dabrowskiego 1/1", "Warszawa", "22-757", "1994-02-07", "+(48)854-545-852", "hstepien@gmail.com", "7854125635362569157", now(), now());
INSERT INTO customer (name, surname, address, city, postal_code, birth_date, phone, email, credit_card_number, created, updated) VALUES("Amelia", "Malinowska", "Kossakowskiego 1/12", "Warszawa", "22-457", "1993-11-02", "+(48)888-985-001", "amalinowska@gmail.com", "1425659586523564984", now(), now());
INSERT INTO customer (name, surname, address, city, postal_code, birth_date, phone, email, credit_card_number, created, updated) VALUES("Alicja", "Jaworska", "Unruga 9", "Warszawa", "22-664", "1992-02-11", "+(48)848-665-555", "ajaworska@gmail.com", "1478547585235698514", now(), now());
INSERT INTO customer (name, surname, address, city, postal_code, birth_date, phone, email, credit_card_number, created, updated) VALUES("Maria", "Adamczyk", "Wojska Polskiego 10", "Gdansk", "43-963", "1991-07-02", "+(48)885-654-259", "madamczyk@gmail.com", "5012548520145842195", now(), now());
INSERT INTO customer (name, surname, address, city, postal_code, birth_date, phone, email, credit_card_number, created, updated) VALUES("Aleksandra", "Dudek", "Westerplatte 9/14", "Gdansk", "43-475", "1990-02-07", "+(48)665-852-319", "adudek@gmail.com", "0124515487545485695", now(), now());
INSERT INTO customer (name, surname, address, city, postal_code, birth_date, phone, email, credit_card_number, created, updated) VALUES("Oliwia", "Nowicka", "Zwirki i Wigury 81", "Gdansk", "43-454", "1989-02-27", "+(48)858-852-010", "onowinska@gmail.com", "2525369851547895365", now(), now());
INSERT INTO customer (name, surname, address, city, postal_code, birth_date, phone, email, credit_card_number, created, updated) VALUES("Natalia", "Pawlak", "Przemyslowa 2", "Gdansk", "43-001", "1988-02-27", "+(48)805-100-102", "npawlak@gmail.com", "7458485748521023201", now(), now());
INSERT INTO customer (name, surname, address, city, postal_code, birth_date, phone, email, credit_card_number, created, updated) VALUES("Wiktoria", "Gorska", "Kosmonautow 10", "Krakow", "67-004", "1987-02-25", "+(48)884-859-000", "wgorska@o2.pl", "1024012502451052105", now(), now());
INSERT INTO customer (name, surname, address, city, postal_code, birth_date, phone, email, credit_card_number, created, updated) VALUES("Emilia", "Witkowska", "Jana III Sobieskiego 9", "Krakow", "67-754", "1986-05-08", "+(48)787-541-025", "ewitkowska@o2.pl", "1021023012506406708", now(), now());
INSERT INTO customer (name, surname, address, city, postal_code, birth_date, phone, email, credit_card_number, created, updated) VALUES("Antonina", "Walczak", "Piotrowo 90/45", "Krakow", "67-258", "1985-07-18", "+(48)852-525-191", "awalczak@o2.pl", "1254125845854823659", now(), now());
INSERT INTO customer (name, surname, address, city, postal_code, birth_date, phone, email, credit_card_number, created, updated) VALUES("Laura", "Sikora", "Berdychowo 1", "Krakow", "67-565", "1984-07-30", "+(48)159-263-487", "lsikora@o2.pl", "2524578451236598594", now(), now());
INSERT INTO customer (name, surname, address, city, postal_code, birth_date, phone, email, credit_card_number, created, updated) VALUES("Pola", "Baran", "Lotnicza 5", "Lodz", "38-757", "1983-09-24", "+(48)752-254-659", "pbaran@mail.com", "2541524251524251527", now(), now());
INSERT INTO customer (name, surname, address, city, postal_code, birth_date, phone, email, credit_card_number, created, updated) VALUES("Iga", "Rutkowska", "Mostowa 9", "Lodz", "38-785", "1982-04-05", "+(48)747-001-240", "irutkowska@mail.com", "9582105485034697410", now(), now());
INSERT INTO customer (name, surname, address, city, postal_code, birth_date, phone, email, credit_card_number, created, updated) VALUES("Anna", "Michalak", "Wrzesinska 9", "Lodz", "38-754", "1981-10-11", "+(48)777-855-000", "amichalak@mail.com", "9501245784215695210", now(), now());
INSERT INTO customer (name, surname, address, city, postal_code, birth_date, phone, email, credit_card_number, created, updated) VALUES("Lilianna", "Szewczyk", "Plantaza 10/10", "Lodz", "38-754", "1980-10-26", "+(48)779-659-745", "lszewczyk@mail.com", "9546854858021312568", now(), now());
