-- liquibase formatted sql

-- changeset afalexey:4
CREATE TABLE student_index (
    student_id INTEGER PRIMARY KEY,
    name VARCHAR(255)
);

-- changeset afalexey:5
CREATE INDEX students_name_index ON student_index (name);
