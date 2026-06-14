CREATE TABLE users (
                       id BIGSERIAL PRIMARY KEY,
                       first_name VARCHAR(100),
                       last_name VARCHAR(100),
                       email VARCHAR(150) UNIQUE,
                       password VARCHAR(255),
                       role VARCHAR(50),
                       created_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP
);

CREATE TABLE patients (
                          id BIGSERIAL PRIMARY KEY,
                          patient_number VARCHAR(50) UNIQUE,
                          first_name VARCHAR(100),
                          last_name VARCHAR(100),
                          gender VARCHAR(10),
                          date_of_birth DATE,
                          phone VARCHAR(20),
                          address TEXT,
                          emergency_contact VARCHAR(100),
                          created_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP
);

CREATE TABLE medical_records (
                                 id BIGSERIAL PRIMARY KEY,
                                 patient_id BIGINT,
                                 doctor_id BIGINT,
                                 diagnosis TEXT,
                                 treatment TEXT,
                                 notes TEXT,
                                 visit_date TIMESTAMP,
                                 FOREIGN KEY(patient_id) REFERENCES patients(id),
                                 FOREIGN KEY(doctor_id) REFERENCES users(id)
);

CREATE TABLE prescriptions (
                               id BIGSERIAL PRIMARY KEY,
                               medical_record_id BIGINT,
                               medication_name VARCHAR(255),
                               dosage VARCHAR(100),
                               frequency VARCHAR(100),
                               duration VARCHAR(100),
                               FOREIGN KEY(medical_record_id)
                                   REFERENCES medical_records(id)
);