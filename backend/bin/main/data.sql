DELETE FROM tb_aluno_curso;
DELETE FROM tb_aluno;
DELETE FROM tb_curso;
DELETE FROM tb_usuario;
ALTER SEQUENCE sq_usuario RESTART WITH 1;
ALTER SEQUENCE sq_curso RESTART WITH 1;
ALTER SEQUENCE sq_aluno RESTART WITH 1;
INSERT INTO tb_usuario(id_usuario, nome, senha, criado_por, data_criacao, modificado_por, data_alteracao) VALUES (sq_usuario.nextval,'cams7', '12345', null, NOW(), null, NOW());
INSERT INTO tb_usuario(id_usuario, nome, senha, criado_por, data_criacao, modificado_por, data_alteracao) VALUES (sq_usuario.nextval,'maria', '12345', 1, NOW(), 1, NOW());
INSERT INTO tb_usuario(id_usuario, nome, senha, criado_por, data_criacao, modificado_por, data_alteracao) VALUES (sq_usuario.nextval,'sergio', '12345', 1, NOW(), 2, NOW());
INSERT INTO tb_usuario(id_usuario, nome, senha, criado_por, data_criacao, modificado_por, data_alteracao) VALUES (sq_usuario.nextval,'yuri', '12345', 2, NOW(), 1, NOW());
INSERT INTO tb_usuario(id_usuario, nome, senha, criado_por, data_criacao, modificado_por, data_alteracao) VALUES (sq_usuario.nextval,'isaac', '12345', 3, NOW(), 3, NOW());
INSERT INTO tb_curso(id_curso, nome, tem_alunos_matriculados, criado_por, data_criacao, modificado_por, data_alteracao) VALUES (sq_curso.nextval,'Curso de Springboot 2 e Angular 8', 1, 1, NOW(), null, NOW());
INSERT INTO tb_curso(id_curso, nome, tem_alunos_matriculados, criado_por, data_criacao, modificado_por, data_alteracao) VALUES (sq_curso.nextval,'Curso de Docker', 1, 2, NOW(), 1, NOW());
INSERT INTO tb_curso(id_curso, nome, tem_alunos_matriculados, criado_por, data_criacao, modificado_por, data_alteracao) VALUES (sq_curso.nextval,'Curso de Kubernete', 1, 2, NOW(), null, NOW());
INSERT INTO tb_curso(id_curso, nome, tem_alunos_matriculados, criado_por, data_criacao, modificado_por, data_alteracao) VALUES (sq_curso.nextval,'Curso de Excel Avançado', 1, 1, NOW(), 2, NOW());
INSERT INTO tb_curso(id_curso, nome, tem_alunos_matriculados, criado_por, data_criacao, modificado_por, data_alteracao) VALUES (sq_curso.nextval,'Curso de Pacote Office Básico', 1, 3, NOW(), 2, NOW());
INSERT INTO tb_curso(id_curso, nome, tem_alunos_matriculados, criado_por, data_criacao, modificado_por, data_alteracao) VALUES (sq_curso.nextval,'Curso de Power Point', 1, 4, NOW(), 2, NOW());
INSERT INTO tb_curso(id_curso, nome, tem_alunos_matriculados, criado_por, data_criacao, modificado_por, data_alteracao) VALUES (sq_curso.nextval,'Curso de .Net', 1, 5, NOW(), null, NOW());
INSERT INTO tb_curso(id_curso, nome, tem_alunos_matriculados, criado_por, data_criacao, modificado_por, data_alteracao) VALUES (sq_curso.nextval,'Curso de Java Básico', 1, 5, NOW(), 4, NOW());
INSERT INTO tb_curso(id_curso, nome, tem_alunos_matriculados, criado_por, data_criacao, modificado_por, data_alteracao) VALUES (sq_curso.nextval,'Curso de PHP Avançado', 1, 5, NOW(), 5, NOW());
INSERT INTO tb_curso(id_curso, nome, tem_alunos_matriculados, criado_por, data_criacao, modificado_por, data_alteracao) VALUES (sq_curso.nextval,'Curso de Python Avançado', 0, 5, NOW(), 5, NOW());
INSERT INTO tb_curso(id_curso, nome, tem_alunos_matriculados, criado_por, data_criacao, modificado_por, data_alteracao) VALUES (sq_curso.nextval,'Curso de Java Script', 0, 5, NOW(), 5, NOW());
INSERT INTO tb_curso(id_curso, nome, tem_alunos_matriculados, criado_por, data_criacao, modificado_por, data_alteracao) VALUES (sq_curso.nextval,'Curso de Web Designer', 0, 5, NOW(), 5, NOW());
INSERT INTO tb_aluno(id_aluno, nome, email, criado_por, data_criacao, modificado_por, data_alteracao) VALUES (sq_aluno.nextval,'Kaué Guilherme Vieira', 'kaue@test.com', 5, NOW(), null, NOW());
INSERT INTO tb_aluno(id_aluno, nome, email, criado_por, data_criacao, modificado_por, data_alteracao) VALUES (sq_aluno.nextval,'Tatiane Rita Gonçalves', 'tatiane@test.com', 1, NOW(), 2, NOW());
INSERT INTO tb_aluno(id_aluno, nome, email, criado_por, data_criacao, modificado_por, data_alteracao) VALUES (sq_aluno.nextval,'Sophie Hadassa Lúcia Almeida', 'sophie@test.com', 2, NOW(), 2, NOW());
INSERT INTO tb_aluno(id_aluno, nome, email, criado_por, data_criacao, modificado_por, data_alteracao) VALUES (sq_aluno.nextval,'Fábio Joaquim da Mata', 'fabio@test.com', 3, NOW(), 5, NOW());
INSERT INTO tb_aluno(id_aluno, nome, email, criado_por, data_criacao, modificado_por, data_alteracao) VALUES (sq_aluno.nextval,'Márcio Calebe Campos', 'marcio@test.com', 4, NOW(), 4, NOW());
INSERT INTO tb_aluno(id_aluno, nome, email, criado_por, data_criacao, modificado_por, data_alteracao) VALUES (sq_aluno.nextval,'Alessandra Elaine Marlene Brito', 'alessandra@test.com', 5, NOW(), 3, NOW());
INSERT INTO tb_aluno(id_aluno, nome, email, criado_por, data_criacao, modificado_por, data_alteracao) VALUES (sq_aluno.nextval,'Hugo Pedro André Castro', 'hugo@test.com', 5, NOW(), 2, NOW());
INSERT INTO tb_aluno(id_aluno, nome, email, criado_por, data_criacao, modificado_por, data_alteracao) VALUES (sq_aluno.nextval,'Francisco Fernando Hugo Vieira', 'francisco@test.com', 2, NOW(), 1, NOW());
INSERT INTO tb_aluno_curso(id_aluno, id_curso) values (1, 1);
INSERT INTO tb_aluno_curso(id_aluno, id_curso) values (1, 2);
INSERT INTO tb_aluno_curso(id_aluno, id_curso) values (1, 3);
INSERT INTO tb_aluno_curso(id_aluno, id_curso) values (1, 4);
INSERT INTO tb_aluno_curso(id_aluno, id_curso) values (1, 5);
INSERT INTO tb_aluno_curso(id_aluno, id_curso) values (1, 6);
INSERT INTO tb_aluno_curso(id_aluno, id_curso) values (1, 7);
INSERT INTO tb_aluno_curso(id_aluno, id_curso) values (1, 8);
INSERT INTO tb_aluno_curso(id_aluno, id_curso) values (1, 9);
INSERT INTO tb_aluno_curso(id_aluno, id_curso) values (2, 2);
INSERT INTO tb_aluno_curso(id_aluno, id_curso) values (2, 4);
INSERT INTO tb_aluno_curso(id_aluno, id_curso) values (2, 5);
INSERT INTO tb_aluno_curso(id_aluno, id_curso) values (2, 7);
INSERT INTO tb_aluno_curso(id_aluno, id_curso) values (2, 8);
INSERT INTO tb_aluno_curso(id_aluno, id_curso) values (3, 1);
INSERT INTO tb_aluno_curso(id_aluno, id_curso) values (3, 3);
INSERT INTO tb_aluno_curso(id_aluno, id_curso) values (3, 6);
INSERT INTO tb_aluno_curso(id_aluno, id_curso) values (4, 1);
INSERT INTO tb_aluno_curso(id_aluno, id_curso) values (4, 2);
INSERT INTO tb_aluno_curso(id_aluno, id_curso) values (4, 3);
INSERT INTO tb_aluno_curso(id_aluno, id_curso) values (5, 9);
INSERT INTO tb_aluno_curso(id_aluno, id_curso) values (5, 8);
INSERT INTO tb_aluno_curso(id_aluno, id_curso) values (5, 5);
INSERT INTO tb_aluno_curso(id_aluno, id_curso) values (6, 8);
INSERT INTO tb_aluno_curso(id_aluno, id_curso) values (6, 7);
INSERT INTO tb_aluno_curso(id_aluno, id_curso) values (7, 6);
INSERT INTO tb_aluno_curso(id_aluno, id_curso) values (7, 4);
INSERT INTO tb_aluno_curso(id_aluno, id_curso) values (8, 1);
INSERT INTO tb_aluno_curso(id_aluno, id_curso) values (8, 3);
INSERT INTO tb_aluno_curso(id_aluno, id_curso) values (8, 5);