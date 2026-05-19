CREATE TABLE IF NOT EXISTS patient (
    id              UUID            PRIMARY KEY,
    name            VARCHAR(255)    NOT NULL,
    email           VARCHAR(255)    UNIQUE NOT NULL,
    address          VARCHAR(255)    NOT NULL,
    date_of_birth   DATE            NOT NULL,
    registered_date      DATE            NOT NULL
);

INSERT INTO patient (id, name, email, address, date_of_birth, registered_date) VALUES
    ('550e8400-e29b-41d4-a716-446655440000', 'John Doe', 'john.doe@example.com', '123 Main St', '1985-06-15', '2023-01-01'),
    ('550e8400-e29b-41d4-a716-446655440001', 'Jane Smith', 'jane.smith@example.com', '456 Elm St', '1990-03-22', '2023-01-02'),
    ('550e8400-e29b-41d4-a716-446655440002', 'Alice Johnson', 'alice.johnson@example.com', '789 Oak St', '1982-11-05', '2023-01-03'),
    ('550e8400-e29b-41d4-a716-446655440003', 'Bob Brown', 'bob.brown@example.com', '321 Pine St', '1978-07-19', '2023-01-04'),
    ('550e8400-e29b-41d4-a716-446655440004', 'Charlie Davis', 'charlie.davis@example.com', '654 Maple St', '1995-02-14', '2023-01-05'),
    ('550e8400-e29b-41d4-a716-446655440005', 'Diana Wilson', 'diana.wilson@example.com', '987 Birch St', '1988-09-30', '2023-01-06'),
    ('550e8400-e29b-41d4-a716-446655440006', 'Ethan Moore', 'ethan.moore@example.com', '159 Cedar St', '1992-12-25', '2023-01-07'),
    ('550e8400-e29b-41d4-a716-446655440007', 'Fiona Taylor', 'fiona.taylor@example.com', '753 Walnut St', '1980-04-10', '2023-01-08'),
    ('550e8400-e29b-41d4-a716-446655440008', 'George Harris', 'george.harris@example.com', '852 Spruce St', '1975-08-18', '2023-01-09'),
    ('550e8400-e29b-41d4-a716-446655440009', 'Hannah Clark', 'hannah.clark@example.com', '951 Aspen St', '1998-01-12', '2023-01-10'),
    ('550e8400-e29b-41d4-a716-446655440010', 'Ian Lewis', 'ian.lewis@example.com', '147 Redwood St', '1987-05-23', '2023-01-11'),
    ('550e8400-e29b-41d4-a716-446655440011', 'Julia Walker', 'julia.walker@example.com', '369 Cypress St', '1993-10-07', '2023-01-12'),
    ('550e8400-e29b-41d4-a716-446655440012', 'Kevin Hall', 'kevin.hall@example.com', '258 Chestnut St', '1984-03-29', '2023-01-13'),
    ('550e8400-e29b-41d4-a716-446655440013', 'Laura Allen', 'laura.allen@example.com', '147 Willow St', '1991-07-04', '2023-01-14'),
    ('550e8400-e29b-41d4-a716-446655440014', 'Michael Young', 'michael.young@example.com', '369 Poplar St', '1979-11-11', '2023-01-15');