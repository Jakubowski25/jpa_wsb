
INSERT INTO address (id, address_line1, address_line2, city, postal_code)
VALUES (1, 'xx', 'yy', 'city', '89-400');

ALTER TABLE doctor ADD COLUMN DELETED BOOLEAN DEFAULT FALSE NOT NULL;
INSERT INTO doctor (first_name, last_name, telephone_number, email, doctor_number, specialization, DELETED)
VALUES ('Maria', 'Jadwisin', '111-222-333', 'marjad@mail.com', '34214', 'Dermatolog', FALSE),
       ('Artur', 'Błażejewski', '555-666-777', 'ablazejewski@mail.com', '23451', 'Laryngolog', FALSE);


INSERT INTO patient (first_name, last_name, date_of_birth, telephone_number, email, patient_number, address_id)
VALUES ('Iga', 'Świątek', '1989-08-01', '426-556-135', 'iswiatek@mail.com', 'NR001', 1),
       ('Ryszard', 'Chodak', '2006-10-05', '523-551-651', 'rchodak@mail.com', 'NR002', 1);


INSERT INTO visit (description, time, doctor_id, patient_id)
VALUES ('Kontrola Pacjenta', '2024-01-01 08:00:00', 1, 1),
       ('Operacja', '2024-02-01 08:00:00', 1, 1),
       ('Kontrola Pacjenta', '2024-06-24 08:00:00', 1, 1),
       ('Kontrola Pacjenta', '2024-09-01 08:00:00', 2, 2);


INSERT INTO medical_treatment (description, type, visit_id)
VALUES ('USG', 'Szczepienie', 1),
       ('Zastrzyk', 'Wymaz', 2);


SELECT * FROM patient WHERE last_name = 'Świątek';

SELECT * FROM visit WHERE patient_id = 1;

SELECT p.*
FROM patient p
WHERE (SELECT COUNT(*) FROM visit v WHERE v.patient_id = p.id) > 2;

SELECT * FROM patient WHERE date_of_birth > '1990-06-06';
