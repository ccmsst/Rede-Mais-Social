## Rede Mais Social

🏗️ Sistema de Aprovação de Afiliação - Rede Mais Social

### Índice

· Visão Geral

· Arquitetura do Sistema

· Diagramas UML

· Casos de Uso Implementados

· Estrutura do Projeto

· Tecnologias e Ferramentas

· Como Executar

· Fluxos do Sistema

· Modelo de Dados

· Vídeo Explicativo

### 🎯 Visão Geral

O Rede Mais Social é uma plataforma digital que conecta voluntários, ONGs e pessoas que precisam de ajuda. O sistema facilita o processo de afiliação, recomendação e engajamento em ações sociais.

Missão: "Ajudando o outro a crescer, você cresce também"

🎯 Objetivos Principais

· Conectar voluntários com oportunidades de ajuda

· Facilitar a afiliação de voluntários e ONGs

· Recomendar matches entre perfis e necessidades

· Gerenciar campanhas e vagas de voluntariado

### 🏗️ Arquitetura do Sistema

📐 Padrão Arquitetural MVC

```
┌─────────────────┐    ┌──────────────────┐    ┌─────────────────┐
│    BOUNDARY     │    │    CONTROLLER    │    │     ENTITY      │
│   (Interface)   │◄---│   (Lógica)       │---►│   (Domínio)     │
└─────────────────┘    └──────────────────┘    └─────────────────┘
                              │
                              ▼
                       ┌─────────────────┐
                       │      DAO        │
                       │  (Persistência) │
                       └─────────────────┘
```

🎯 Camadas Implementadas

Camada Componentes
Boundary (Interface) AprovacaoBoundary


Controller (Lógica) AprovacaoController


Entity (Domínio) Candidato, Afiliação, Aprovacao, Voluntario, etc


DAO (Persistência) CandidatoDAO, AprovacaoDAO, VoluntarioDAO, etc

### 📊 Diagramas UML

1. Diagrama de Classes de Domínio Completo - Aprova Afiliação e Solicita Afiliação

![17636888077074404020218177030191](https://github.com/user-attachments/assets/da00df40-6fd8-4c64-8b13-9888490cd561)


2. Diagrama de Sequência - Aprova Afiliação 

![17636886928223355549959298297799](https://github.com/user-attachments/assets/8234d2aa-064c-4702-8bd0-7d903efd345f)

3. Diagrama de Classes - Aprova Afiliação 

![1763688787164785801783618771041](https://github.com/user-attachments/assets/13b6be02-993c-4939-9705-6a895b3ded11)


### 🔄 Caso de Uso Implementado

Caso de Uso


<img width="473" height="218" alt="17636888613676842724933226598229" src="https://github.com/user-attachments/assets/ad04b095-e3d1-4351-a9ae-5c4f5a49311e" />

Fluxo Principal


<img width="481" height="352" alt="17636888750405845678816227640522" src="https://github.com/user-attachments/assets/6bdc7008-09a9-499e-81a8-60d481ccc4fa" />


<img width="480" height="247" alt="17636888911096803981605847785211" src="https://github.com/user-attachments/assets/06aa92a3-e367-4633-9b77-3d11817eedb7" />


Fluxos Alternativos


<img width="487" height="487" alt="17636889059772667788401297884556" src="https://github.com/user-attachments/assets/5acc06ee-5d73-4e03-82ba-b4d06cebbb11" />


<img width="492" height="285" alt="17636889177598400047712604508191" src="https://github.com/user-attachments/assets/81495950-46c1-4f49-90ac-c819411e6cc2" />


Regra de Negócio Caso de Uso - Aprovação de Afiliação


<img width="472" height="82" alt="17636889281492052511529567959587" src="https://github.com/user-attachments/assets/8543eb7b-a8b7-40f5-affb-b200c9b56a6f" />


### 📁 Estrutura do Projeto

```
src/
├── Afiliacao.java
├── AfiliacaoDAO.java
├── Aprovacao.java
├── AprovacaoBoundary.java
├── AprovacaoController.java
├── AprovacaoDAO.java
├── Campanha.java
├── Candidato.java
├── CandidatoDAO.java
├── CandidatoPendentes.java
├── Habilidade.java
├── Interesse.java
├── ONG.java
├── ONGDAO.java
├── Perfil.java
├── PessoaFisica.java
├── Recomendacao.java
├── RecomendacaoDAO.java
├── RepresentanteRMS.java
├── RepresentanteRMSDAO.java
├── Sessao.java
├── Voluntario.java
└── VoluntarioDAO.java

docs/
├── banco.sql                            # Modelo completo do banco
├── diagramas.md                         # Diagramas UML
└── prototipos.md                        # Telas do sistema
```

### 🛠 Tecnologias e Ferramentas

💻 Linguagens e Frameworks

· Java 8+: Linguagem principal
· UML: Modelagem dos diagramas
· SQL: Modelo de dados

🗃️ Persistência de Dados

· Abordagem: DAOs simulados (preparados para SGBD real)
· Modelo: 25 tabelas documentadas em banco.sql
· Pronto para: MySQL, Oracle, PostgreSQL

🔧 Ferramentas de Desenvolvimento

· IDE: VS Code, Eclipse ou IntelliJ
· Controle de versão: GitHub
· Documentação: Wiki do GitHub

### 🚀 Como Executar

📥 Pré-requisitos

```bash
# Java Development Kit 8 ou superior
java -version

# Git para clone do repositório
git --version
```

⚡ Execução Rápida

```bash
# 1. Clone o repositório
https://github.com/ccmsst/Rede-Mais-Social.wiki.git

# 2. Navegue até o diretório
cd rede-mais-social/src

# 3. Compile o projeto
javac AprovacaoBoundary.java

# 4. Execute o sistema
java AprovacaoBoundary
```

🎮 Como Usar

1. O sistema inicia automaticamente
2. Digite 1 para buscar candidatos pendentes
3. Selecione um candidato pelo ID
4. Escolha A para aprovar ou R para rejeitar
5. Siga as instruções na tela

### 🔄 Fluxos do Sistema

✅ Fluxo Principal - Aprovação Bem-sucedida

```
[INÍCIO] → Busca Candidatos → Seleciona Candidato → Analisa Dados → 
[Aprova] → Cria Sessão → Registra Aprovação → Cria Voluntário → 
[Recomenda] ONGs → Gera Credenciais → Envia Email → [FIM]
```

❌ Fluxo Alternativo - Rejeição

```
[INÍCIO] → Busca Candidatos → Seleciona Candidato → Analisa Dados → 
[Rejeita] → Informa Motivo → Registra Rejeição → Envia Email → [FIM]
```

⚠️ Fluxo Alternativo - Sem Candidatos

```
[INÍCIO] → Busca Candidatos → [Lista Vazia] → Mensagem Informativa → [FIM]
```

### 🗃️ Modelo de Dados

📊 Principais Tabelas (banco.sql)

```sql
-- Candidatos e Afiliações
CREATE TABLE Candidato (id_Candidato INTEGER PRIMARY KEY, ...);
CREATE TABLE Afiliacao (id_afiliacao INTEGER PRIMARY KEY, ...);

-- Aprovações e Voluntários  
CREATE TABLE Aprovacao (id_aprovacao INTEGER PRIMARY KEY, ...);
CREATE TABLE Voluntario (id_voluntario INTEGER PRIMARY KEY, ...);

-- ONGs e Campanhas
CREATE TABLE ONG (id_ONG INTEGER PRIMARY KEY, ...);
CREATE TABLE Campanha (id_Campanha INTEGER PRIMARY KEY, ...);

-- Perfis e Recomendações
CREATE TABLE Perfil (id_perfil INTEGER PRIMARY KEY, ...);
CREATE TABLE Recomendacao (id_recomendacao INTEGER PRIMARY KEY, ...);
```

🔗 Relações Principais

· Candidato 1:1 Afiliacao
· Afiliação 1:1 Aprovacao
· Aprovacao 1:1 Voluntario
· Voluntario N:N ONG (via Recomendacao)

📖 Documentação na Wiki

Cada membro publicou individualmente na Wiki:

· Diagramas UML desenvolvidos
· Código fonte implementado
· Explicação das contribuições
· Protótipos e modelos

### 🎥 Vídeo Explicativo
link do vídeo explicativo:  

📹 Conteúdo do Vídeo

· Demonstração da correspondência UML ↔ Código
· Execução do fluxo principal de aprovação
· Explicação dos fluxos alternativos
· Mostra dos diagramas implementados
· Participação de todos os membros do grupo

🎯 Pontos Chave do Vídeo

· Arquitetura MVC: Como as camadas se comunicam
· Padrão DAO: Abstração da persistência
· Correspondência UML: Diagramas → Código
· Tratamento de Fluxos: Principal e alternativos
· Preparação para SGBD: Modelo de dados completo

---

Repositório: GitHub - Rede Mais Social
Wiki: Documentação Completa
