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
                          course_id BIGINT REFERENCES courses(id)
);


CREATE TABLE student_subjects (
                                  student_id BIGINT REFERENCES students(id),
                                  subject_id BIGINT REFERENCES subjects(id),
                                  PRIMARY KEY (student_id, subject_id)
);
CREATE TABLE t_user_permission (
                                   user_id BIGINT REFERENCES t_users(id),
                                   permission_id BIGINT REFERENCES t_permission(id),
                                   PRIMARY KEY (user_id, permission_id)
);
CREATE TABLE t_users (
                         id       BIGSERIAL PRIMARY KEY,
                         email    VARCHAR(255) NOT NULL UNIQUE,
                         password VARCHAR(255) NOT NULL
);
CREATE TABLE t_permission (
                              id   BIGSERIAL PRIMARY KEY,
                              name VARCHAR(255) NOT NULL UNIQUE
);
