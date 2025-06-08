ALTER TABLE student
    ADD CONSTRAINT age_constraint CHECK ( age > 16 ),
    ALTER COLUMN name SET NOT NULL,
    ADD CONSTRAINT name_unique UNIQUE (name),
    ALTER COLUMN age SET DEFAULT 20;
ALTER table hw_faculty ADD CONSTRAINT name_color_unique UNIQUE (faculty_color, faculty_name);