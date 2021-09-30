insert into usuario(nome,cpf,data_nascimento,email,senha) values('Alberto Augusto','12365478978','1984-05-15','aaugusto@hotmail.com','$2a$12$pdlJY7IGuULz44gDcwzOKeW0YhIGRwPG3aHUw5TxMxgUV60KEwp6y'); 
insert into usuario(nome,cpf,data_nascimento,email,senha) values('Alberto Roberto','87455447747','1988-04-20','aroberto@hotmail.com','$2a$12$pdlJY7IGuULz44gDcwzOKeW0YhIGRwPG3aHUw5TxMxgUV60KEwp6y'); 
insert into usuario(nome,cpf,data_nascimento,email,senha) values('Luiz Felipe','87455447747','1988-04-20','lfelipe@hotmail.com','$2a$12$pdlJY7IGuULz44gDcwzOKeW0YhIGRwPG3aHUw5TxMxgUV60KEwp6y');

INSERT INTO perfil VALUES(null,'ROLE_USUARIO');
INSERT INTO perfil VALUES(null,'ROLE_ADM');

INSERT INTO usuario_perfis VALUES (1,1);
INSERT INTO usuario_perfis VALUES (2,2);
INSERT INTO usuario_perfis VALUES (3,1);


insert into contato values (null, '1Apelido usuario 1', '1984-05-15', '1nome 1', '1sobrenome 1', 1);
insert into contato values (null, '1Apelido usuario 1', '1984-05-15', '1nome 2', '1sobrenome 2', 1);
insert into contato values (null, '1Apelido usuario 1', '1984-05-15', '1nome 3', '1sobrenome 3', 1);

insert into endereco values (null, 'bairro 1', '1234567', '19', 123, 'BR', '1rua do contato 1 ', '1', 1);
insert into endereco values (null, 'bairro 2', '1234567', '19', 123, 'BR', '1rua do contato 2 ', '1', 2);
insert into endereco values (null, 'bairro 2', '1234567', '19', 123, 'BR', '1rua do contato 3 ', '1', 3);

insert into telefone values (null, '11', '55','12312313','1', 1);
insert into telefone values (null, '11', '55','12312313','1', 2);
insert into telefone values (null, '11', '55','12312313','1', 3);

insert into email values (null, '1contato@contato.com', '1', 1);
insert into email values (null, '1contato@contato.com', '1', 2);
insert into email values (null, '1contato@contato.com', '1', 3);




insert into contato values (null, 'Apelido usuario 3', '1984-05-15', 'contato usuario 3 nome 1', 'sobrenome 1', 3);
insert into contato values (null, 'Apelido usuario 3', '1984-05-15', 'contato usuario 3 nome 2', 'sobrenome 2', 3);
insert into contato values (null, 'Apelido usuario 3', '1984-05-15', 'contato usuario 3 nome 2', 'sobrenome 3', 3);

insert into endereco values (null, '3bairro 1', '1234567', '19', 123, 'BR', '3rua do contato 1 ', '1', 4);
insert into endereco values (null, '3bairro 2', '1234567', '19', 123, 'BR', '3rua do contato 2 ', '1', 5);
insert into endereco values (null, '3bairro 2', '1234567', '19', 123, 'BR', '3rua do contato 3 ', '1', 6);

insert into telefone values (null, '11', '55','12312313','1', 4);
insert into telefone values (null, '11', '55','12312313','1', 5);
insert into telefone values (null, '11', '55','12312313','1', 6);

insert into email values (null, '3contato@contato.com', '1', 4);
insert into email values (null, '3contato@contato.com', '1', 5);
insert into email values (null, '3contato@contato.com', '1', 6);