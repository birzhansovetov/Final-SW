
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
                                                          (1, 1), -- Aruzhan → Java
                                                          (1, 2), -- Aruzhan → Databases
                                                          (2, 1), -- Dias → Java
                                                          (2, 3), -- Dias → Algorithms
                                                          (3, 2), -- Aibek → Databases
                                                          (3, 4); -- Aibek → Spring Boot
