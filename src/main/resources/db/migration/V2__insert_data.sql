
INSERT INTO courses (name, description) VALUES
                                            ('Computer Science', 'CS fundamentals and programming'),
                                            ('Information Systems', 'Business and IT'),
                                            ('Software Engineering', 'Software design and development');

INSERT INTO subjects (name) VALUES
                                ('Java'),
                                ('Databases'),
                                ('Algorithms'),
                                ('Spring Boot'),
                                ('Operating Systems');


INSERT INTO students (first_name, last_name, email, age, course_id) VALUES
                                                                        ('Aruzhan', 'Kadyrova', 'aruzhan@mail.com', 20, 1),
                                                                        ('Dias', 'Nurpeisov', 'dias@mail.com', 21, 1),
                                                                        ('Aibek', 'Tulegenov', 'aibek@mail.com', 22, 2);

INSERT INTO student_subjects (student_id, subject_id) VALUES
                                                          (1, 1),
                                                          (1, 2),
                                                          (2, 1),
                                                          (2, 3),
                                                          (3, 2),
                                                          (3, 4)
ON CONFLICT (student_id, subject_id) DO NOTHING;

insert into t_permission (name) values ('ROLE_USER')
ON CONFLICT (name) DO NOTHING;
insert into t_permission (name) values ('ROLE_ADMIN')
ON CONFLICT (name) DO NOTHING;
