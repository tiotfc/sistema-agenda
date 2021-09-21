insert into usuario(nome,cpf,data_nascimento,email,senha) values('Alberto Augusto','12365478978','1984-05-15','aaugusto@hotmail.com','$2a$12$pdlJY7IGuULz44gDcwzOKeW0YhIGRwPG3aHUw5TxMxgUV60KEwp6y'); 
insert into usuario(nome,cpf,data_nascimento,email,senha) values('Alberto Roberto','87455447747','1988-04-20','aroberto@hotmail.com','$2a$12$pdlJY7IGuULz44gDcwzOKeW0YhIGRwPG3aHUw5TxMxgUV60KEwp6y'); 
insert into usuario(nome,cpf,data_nascimento,email,senha) values('Luiz Felipe','87455447747','1988-04-20','lfelipe@hotmail.com','$2a$12$pdlJY7IGuULz44gDcwzOKeW0YhIGRwPG3aHUw5TxMxgUV60KEwp6y');

INSERT INTO perfil VALUES(null,'ROLE_USUARIO');
INSERT INTO perfil VALUES(null,'ROLE_ADM');

INSERT INTO usuario_perfis VALUES (1,1);
INSERT INTO usuario_perfis VALUES (2,2);
INSERT INTO usuario_perfis VALUES (3,1);


