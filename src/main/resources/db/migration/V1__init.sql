CREATE TABLE courses (
                         id BIGSERIAL PRIMARY KEY,
                         name VARCHAR(255),
                         description VARCHAR(255)
);

CREATE TABLE subjects (
                          id BIGSERIAL PRIMARY KEY,
                          name VARCHAR(255)
);

CREATE TABLE students (
                          id BIGSERIAL PRIMARY KEY,
                          first_name VARCHAR(255),
                          last_name VARCHAR(255),
                          email VARCHAR(255),
                          age INTEGER,
                          course_id BIGINT,
                          CONSTRAINT fk_student_course
                              FOREIGN KEY (course_id)
                                  REFERENCES courses(id)
);

CREATE TABLE student_subjects (
                                  student_id BIGINT NOT NULL,
                                  subject_id BIGINT NOT NULL,
                                  CONSTRAINT fk_student_subject
                                      FOREIGN KEY (student_id) REFERENCES students(id),
                                  CONSTRAINT fk_subject_student
                                      FOREIGN KEY (subject_id) REFERENCES subjects(id)
);
