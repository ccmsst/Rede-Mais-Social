/* Lógico_1: */

CREATE TABLE PessoaJuridica ( id_pessoaJuridica Interger PRIMARY KEY, id_representanteJuridica Interger, CNPJ String, registroEmpresa String, nomeLegal String, nomeOrganizanal String, paisRegistro String );

CREATE TABLE PessoaFisica ( id_pessoaFisica Interger PRIMARY KEY, CPF String, sexo String, dataNascimento Date, nacionalidade String, profissao String, endereco String );

CREATE TABLE RepresentanteRMS ( id_representanteRMS Interger PRIMARY KEY );

CREATE TABLE CertidaoNegativa ( id_certidao Interger PRIMARY KEY, id_pessoa Interger, nome String, status String );

CREATE TABLE Recomendacao ( id_recomendacao Interger PRIMARY KEY, id_Campanha Interger, id_ONG Interger, id_pessoa Interger, id_aprovacao Interger, conteudo String, dataRecomendacao Date );

CREATE TABLE Campanha ( id_Campanha Interger PRIMARY KEY, id_ONG Interger, titulo String, tipoAtividade String, publicoAlvo String, local String, duracao String );

CREATE TABLE ONG ( id_ONG Interger PRIMARY KEY, nome_ONG String, CNPJ String, areaAtuacao String );

CREATE TABLE Vaga ( id_Vaga Interger PRIMARY KEY, id_Campanha Interger, id_perfilVaga Interger, descricao String, quantidade Interger, status String );

CREATE TABLE Mensagem ( id_mensagem Interger PRIMARY KEY, id_voluntario Interger, conteudo String, dataEnvio Date );

CREATE TABLE Notificacao ( id_notificacao Interger PRIMARY KEY, id_voluntario Interger, conteudo String, status String, dataEnvio Date );

CREATE TABLE Interesse ( id_interesse Interger PRIMARY KEY, data Date, status String );

CREATE TABLE Habilidade ( id_habilidade Interger PRIMARY KEY, data Date, status String );

CREATE TABLE Aprovacao ( id_aprovacao Interger PRIMARY KEY, id_afiliacao Interger, id_voluntario Interger, dataAprovacao Date, observacao String, motivoRejeicao String );

CREATE TABLE Termo ( id_termo Interger PRIMARY KEY, id_aceite Interger, dataCriacao Date );

CREATE TABLE Aceite ( id_aceite Interger PRIMARY KEY, id_termo Interger, id_afiliacao Interger, data Date, status String );

CREATE TABLE ItemTermo ( id_itemTermo Interger PRIMARY KEY, id_itemAceite Interger, id_termo Interger );

CREATE TABLE inclui ( id_perfil Interger, id_interesse Interger, PRIMARY KEY (id_perfil, id_interesse) );

CREATE TABLE inclui ( id_perfil Interger, id_habilidade Interger, PRIMARY KEY (id_perfil, id_habilidade) );

CREATE TABLE relacionada_com_a ( id_perfilVaga Interger, id_habilidade Interger, PRIMARY KEY (id_perfilVaga, id_habilidade) );

CREATE TABLE requer ( id_perfilVaga Interger, id_interesse Interger, PRIMARY KEY (id_interesse, id_perfilVaga) );

CREATE TABLE ItemAceite ( id_itemAceite Interger PRIMARY KEY, id_aceite Interger, id_itemTermo Interger, aceite String );

CREATE TABLE Validacao ( id_validacao Interger PRIMARY KEY, id_afiliacao Interger, envio Boolean, link String, status String );

CREATE TABLE Afiliacao ( id_afiliacao Interger PRIMARY KEY, id_Candidato Interger, id_validacao Interger, id_aprovacao Interger, id_aceite Interger, data Date, status String );

CREATE TABLE Pessoa ( id_pessoa Interger PRIMARY KEY, id_Candidato Interger, nome_pessoa String );

CREATE TABLE Candidato ( id_Candidato Interger PRIMARY KEY, id_pessoa Interger, id_afiliacao Interger, id_perfil Interger, nome String, email String );

CREATE TABLE Perfil ( id_perfil Interger PRIMARY KEY, id_Candidato Interger, data Date );

CREATE TABLE Voluntario ( id_voluntario Interger PRIMARY KEY, id_Candidato Interger, id_aprovacao Interger, status String, dataInicio Date, nome_pessoa Interger );

CREATE TABLE PerfilVaga ( id_perfilVaga Interger PRIMARY KEY, id_Vaga Interger, descricao String );

CREATE TABLE RepresentanteJuridica ( id_representanteJuridica Interger PRIMARY KEY );

ALTER TABLE PessoaJuridica ADD CONSTRAINT FK_PessoaJuridica_2 FOREIGN KEY (id_pessoaJuridica) REFERENCES Pessoa (id_pessoa);

ALTER TABLE PessoaJuridica ADD CONSTRAINT FK_PessoaJuridica_3 FOREIGN KEY (id_representanteJuridica) REFERENCES RepresentanteJuridica (id_representanteJuridica);

ALTER TABLE PessoaFisica ADD CONSTRAINT FK_PessoaFisica_2 FOREIGN KEY (id_pessoaFisica) REFERENCES Pessoa (id_pessoa);

ALTER TABLE RepresentanteRMS ADD CONSTRAINT FK_RepresentanteRMS_2 FOREIGN KEY (id_representanteRMS) REFERENCES PessoaFisica (id_pessoaFisica);

ALTER TABLE CertidaoNegativa ADD CONSTRAINT FK_CertidaoNegativa_2 FOREIGN KEY (id_pessoa) REFERENCES PessoaJuridica (id_pessoaJuridica) ON DELETE CASCADE;

ALTER TABLE Recomendacao ADD CONSTRAINT FK_Recomendacao_2 FOREIGN KEY (id_Campanha) REFERENCES Campanha (id_Campanha) ON DELETE SET NULL;

ALTER TABLE Recomendacao ADD CONSTRAINT FK_Recomendacao_3 FOREIGN KEY (id_ONG) REFERENCES ONG (id_ONG) ON DELETE SET NULL;

ALTER TABLE Recomendacao ADD CONSTRAINT FK_Recomendacao_4 FOREIGN KEY (id_representanteRMS) REFERENCES RepresentanteRMS (id_representanteRMS) ON DELETE CASCADE;

ALTER TABLE Recomendacao ADD CONSTRAINT FK_Recomendacao_5 FOREIGN KEY (id_aprovacao) REFERENCES Aprovacao (id_aprovacao);

ALTER TABLE Campanha ADD CONSTRAINT FK_Campanha_2 FOREIGN KEY (id_ONG) REFERENCES ONG (id_ONG) ON DELETE CASCADE;

ALTER TABLE Vaga ADD CONSTRAINT FK_Vaga_2 FOREIGN KEY (id_Campanha) REFERENCES Campanha (id_Campanha) ON DELETE CASCADE;

ALTER TABLE Vaga ADD CONSTRAINT FK_Vaga_3 FOREIGN KEY (id_perfilVaga) REFERENCES PerfilVaga (id_perfilVaga);

ALTER TABLE Mensagem ADD CONSTRAINT FK_Mensagem_2 FOREIGN KEY (id_voluntario) REFERENCES Voluntario (id_voluntario);

ALTER TABLE Notificacao ADD CONSTRAINT FK_Notificacao_2 FOREIGN KEY (id_voluntario) REFERENCES Voluntario (id_voluntario);

ALTER TABLE Aprovacao ADD CONSTRAINT FK_Aprovacao_2 FOREIGN KEY (id_afiliacao) REFERENCES Afiliacao (id_afiliacao);

ALTER TABLE Aprovacao ADD CONSTRAINT FK_Aprovacao_3 FOREIGN KEY (id_voluntario) REFERENCES Voluntario (id_voluntario);

ALTER TABLE Termo ADD CONSTRAINT FK_Termo_2 FOREIGN KEY (id_aceite) REFERENCES Aceite (id_aceite);

ALTER TABLE Aceite ADD CONSTRAINT FK_Aceite_2 FOREIGN KEY (id_termo) REFERENCES Termo (id_termo) ON DELETE RESTRICT;

ALTER TABLE Aceite ADD CONSTRAINT FK_Aceite_3 FOREIGN KEY (id_afiliacao) REFERENCES Afiliacao (id_afiliacao) ON DELETE CASCADE;

ALTER TABLE ItemTermo ADD CONSTRAINT FK_ItemTermo_2 FOREIGN KEY (id_itemAceite) REFERENCES ItemAceite (id_itemAceite) ON DELETE RESTRICT;

ALTER TABLE ItemTermo ADD CONSTRAINT FK_ItemTermo_3 FOREIGN KEY (id_termo) REFERENCES Termo (id_termo);

ALTER TABLE inclui ADD CONSTRAINT FK_inclui_1 FOREIGN KEY (id_perfil) REFERENCES Perfil (id_perfil);

ALTER TABLE inclui ADD CONSTRAINT FK_inclui_2 FOREIGN KEY (id_interesse) REFERENCES Interesse (id_interesse) ON DELETE RESTRICT;

ALTER TABLE inclui ADD CONSTRAINT FK_inclui_1 FOREIGN KEY (id_perfil) REFERENCES Perfil (id_perfil);

ALTER TABLE inclui ADD CONSTRAINT FK_inclui_2 FOREIGN KEY (id_habilidade) REFERENCES Habilidade (id_habilidade) ON DELETE RESTRICT;

ALTER TABLE relacionada_com_a ADD CONSTRAINT FK_relacionada_com_a_1 FOREIGN KEY (id_perfilVaga) REFERENCES PerfilVaga (id_perfilVaga) ON DELETE RESTRICT;

ALTER TABLE relacionada_com_a ADD CONSTRAINT FK_relacionada_com_a_2 FOREIGN KEY (id_habilidade) REFERENCES Habilidade (id_habilidade) ON DELETE RESTRICT;

ALTER TABLE requer ADD CONSTRAINT FK_requer_1 FOREIGN KEY (id_perfilVaga) REFERENCES PerfilVaga (id_perfilVaga) ON DELETE RESTRICT;

ALTER TABLE requer ADD CONSTRAINT FK_requer_2 FOREIGN KEY (id_interesse) REFERENCES Interesse (id_interesse) ON DELETE RESTRICT;

ALTER TABLE ItemAceite ADD CONSTRAINT FK_ItemAceite_2 FOREIGN KEY (id_aceite) REFERENCES Aceite (id_aceite) ON DELETE RESTRICT;

ALTER TABLE ItemAceite ADD CONSTRAINT FK_ItemAceite_3 FOREIGN KEY (id_itemTermo) REFERENCES ItemTermo (id_itemTermo);

ALTER TABLE Validacao ADD CONSTRAINT FK_Validacao_2 FOREIGN KEY (id_afiliacao) REFERENCES Afiliacao (id_afiliacao);

ALTER TABLE Afiliacao ADD CONSTRAINT FK_Afiliacao_2 FOREIGN KEY (id_Candidato) REFERENCES Candidato (id_Candidato);

ALTER TABLE Afiliacao ADD CONSTRAINT FK_Afiliacao_3 FOREIGN KEY (id_validacao) REFERENCES Validacao (id_validacao);

ALTER TABLE Afiliacao ADD CONSTRAINT FK_Afiliacao_4 FOREIGN KEY (id_aprovacao) REFERENCES Aprovacao (id_aprovacao);

ALTER TABLE Afiliacao ADD CONSTRAINT FK_Afiliacao_5 FOREIGN KEY (id_aceite) REFERENCES Aceite (id_aceite);

ALTER TABLE Pessoa ADD CONSTRAINT FK_Pessoa_2 FOREIGN KEY (id_Candidato) REFERENCES Candidato (id_Candidato);

ALTER TABLE Candidato ADD CONSTRAINT FK_Candidato_2 FOREIGN KEY (id_pessoa) REFERENCES Pessoa (id_pessoa);

ALTER TABLE Candidato ADD CONSTRAINT FK_Candidato_3 FOREIGN KEY (id_afiliacao) REFERENCES Afiliacao (id_afiliacao);

ALTER TABLE Candidato ADD CONSTRAINT FK_Candidato_4 FOREIGN KEY (id_perfil) REFERENCES Perfil (id_perfil);

ALTER TABLE Perfil ADD CONSTRAINT FK_Perfil_2 FOREIGN KEY (id_Candidato) REFERENCES Candidato (id_Candidato);

ALTER TABLE Voluntario ADD CONSTRAINT FK_Voluntario_2 FOREIGN KEY (id_Candidato) REFERENCES Candidato (id_Candidato);

ALTER TABLE Voluntario ADD CONSTRAINT FK_Voluntario_3 FOREIGN KEY (nome_pessoa, id_aprovacao) REFERENCES Aprovacao (id_aprovacao, id_aprovacao);

ALTER TABLE PerfilVaga ADD CONSTRAINT FK_PerfilVaga_2 FOREIGN KEY (id_Vaga) REFERENCES Vaga (id_Vaga) ON DELETE CASCADE;

ALTER TABLE RepresentanteJuridica ADD CONSTRAINT FK_RepresentanteJuridica_2 FOREIGN KEY (id_representanteJuridica) REFERENCES PessoaFisica (id_pessoaFisica);