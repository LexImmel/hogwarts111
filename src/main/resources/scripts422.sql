CREATE TABLE IF NOT EXISTS Cars (
    car_id INT PRIMARY KEY,
    brand TEXT NOT NULL,
    model TEXT NOT NULL,
    cost INT NOT NULL
);


CREATE TABLE IF NOT EXISTS Humans (
    person_id INT PRIMARY KEY,
    name TEXT UNIQUE NOT NULL,
    age INT NOT NULL,
    license BOOLEAN
);

CREATE TABLE IF NOT EXISTS Ownership(
    person_id INT,
    car_id INT,
    PRIMARY KEY (person_id, car_id),
    FOREIGN KEY (person_id) REFERENCES Humans(person_id),
    FOREIGN KEY (car_id) REFERENCES Cars(car_id)

)