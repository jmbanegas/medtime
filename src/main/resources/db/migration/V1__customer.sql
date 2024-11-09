-- Tabla de Clientes (Customer)
CREATE TABLE IF NOT EXISTS customer (
                                        id SERIAL PRIMARY KEY,
                                        name VARCHAR(100) NOT NULL,
    email VARCHAR(100) NOT NULL UNIQUE,
    phone VARCHAR(15),
    address VARCHAR(255),
    date_of_birth DATE
    );

-- Tabla de Horarios de Medicamentos (Medication_Schedule)
CREATE TABLE IF NOT EXISTS medication_schedule (
                                                   id SERIAL PRIMARY KEY,
                                                   customer_id INT REFERENCES customer(id) ON DELETE CASCADE,
    medication_name VARCHAR(100) NOT NULL,
    dosage VARCHAR(50) NOT NULL,
    frequency VARCHAR(50) NOT NULL,
    next_dose_time TIME NOT NULL,
    start_date DATE NOT NULL,
    end_date DATE,
    notifications BOOLEAN DEFAULT TRUE
    );
