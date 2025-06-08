SELECT name, age, faculty
FROM student;

SELECT avatar.student_id, student.name
FROM student, avatar
JOIN student AS student_id ON avatar.id = student_id.id
WHERE avatar.data NOTNULL;
