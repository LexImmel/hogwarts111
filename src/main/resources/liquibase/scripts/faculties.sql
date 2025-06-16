-- liquibase formatted sql

-- changeset afalexey:1
CREATE TABLE faculty_index (
    faculty_id INTEGER PRIMARY KEY,
    faculty_color VARCHAR(255),
    faculty_name VARCHAR(255)

);

-- changeset afalexey:2
CREATE INDEX faculty_name_index ON faculty_index (faculty_name);

-- changeset afalexey:3
CREATE INDEX faculty_color_index ON faculty_index (faculty_color);
