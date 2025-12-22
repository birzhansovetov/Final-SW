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
create table t_permission (
                              id bigserial primary key,
                              name varchar(50) not null unique
);
create table t_user (
                        id bigserial primary key,
                        username varchar(100),
                        email varchar(150) not null unique,
                        password varchar(255) not null
);
CREATE TABLE t_user_permission (
                                   user_id BIGINT REFERENCES t_user(id),
                                   permission_id BIGINT REFERENCES t_permission(id),
                                   PRIMARY KEY (user_id, permission_id)
);
create table t_permission (
                              id bigserial primary key,
                              name varchar(50) not null unique
);
create table t_user (
                        id bigserial primary key,
                        username varchar(100),
                        email varchar(150) not null unique,
                        password varchar(255) not null
);
CREATE TABLE t_user_permissions (
                                    user_id BIGINT REFERENCES t_user(id),
                                    permission_id BIGINT REFERENCES t_permission(id),
                                    PRIMARY KEY (user_id, permission_id)
);

