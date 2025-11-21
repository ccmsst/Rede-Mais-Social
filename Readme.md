REDE MAIS SOCIAL
🏗️ Sistema de Aprovação de Afiliação - Rede Mais Social
📋 Índice
Visão Geral

Arquitetura do Sistema

Diagramas UML

Casos de Uso Implementados

Estrutura do Projeto

Tecnologias e Ferramentas

Como Executar

Fluxos do Sistema

Modelo de Dados

Contribuições Individuais

Vídeo Explicativo

🎯 Visão Geral
O Rede Mais Social é uma plataforma digital que conecta voluntários, ONGs e pessoas que precisam de ajuda. O sistema facilita o processo de afiliação, recomendação e engajamento em ações sociais.

Missão: "Ajudando o outro a crescer, você cresce também"

🎯 Objetivos Principais
Conectar voluntários com oportunidades de ajuda

Facilitar a afiliação de voluntários e ONGs

Recomendar matches entre perfis e necessidades

Gerenciar campanhas e vagas de voluntariado

🏗️ Arquitetura do Sistema
📐 Padrão Arquitetural MVC
text
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
🎯 Camadas Implementadas
Boundary (Interface): AprovacaoBoundary

Controller (Lógica): AprovacaoController

Entity (Domínio): Candidato, Afiliação, Aprovacao, Voluntario

DAO (Persistência): CandidatoDAO, AprovacaoDAO, VoluntarioDAO

📊 Diagramas UML
1. Diagrama de Classes de Domínio - Aprova Afiliação
text
Candidato ────── transforma-se em ──────▶ Voluntario
    │                                      │
    ├─ associa ────── Afiliacao ────── realiza ──▶ Aprovacao
    │         (data, status)         (data, status, motivo)
    └─ possui ──────▶ Perfil ──────▶ Habilidade/Interesse
2. Diagrama de Sequência - Aprova Afiliação
text
RepresentanteRMS → AprovacaoBoundary → AprovacaoController → DAOs
     │                  │                    │               │
     │─ buscaCandidatos() │                    │               │
     │◄─────────────────│                    │               │
     │─ selecionaCandidato()│                    │               │
     │◄─────────────────│                    │               │
     │─ aprovarAfiliacao() │                    │               │
     │◄─────────────────│                    │               │
3. Diagrama de Classes Completo do Projeto
Gestão de Pessoas: PessoaFisica, PessoaJuridica, Candidato, Voluntario

Gestão de ONGs: ONG, Campanha, Vaga

Sistema de Recomendações: Recomendacao, Perfil, Habilidade, Interesse

Comunicação: Mensagem, Notificacao

Legal/Termos: Termo, Aceite, ItemTermo

🔄 Casos de Uso Implementados
✅ UC003 - Aprova Afiliação (PRINCIPAL)
Ator: Representante da Rede Mais Social

Fluxo Principal:

Busca candidatos pendentes de aprovação

Seleciona candidato específico

Analisa informações detalhadas

Aprova/Rejeita afiliação

Define perfil do voluntário (se aprovado)

Gera recomendações de ONGs

Cria credenciais de acesso

Envia emails de confirmação

Fluxos Alternativos:

Não há candidatos pendentes

Candidato rejeitado com motivo

Não existem ONGs para recomendar

📁 Estrutura do Projeto
text
src/
├── boundary/
│   └── AprovacaoBoundary.java          # Interface com usuário
├── controller/
│   └── AprovacaoController.java        # Lógica de negócio
├── entity/                             # Classes de domínio
│   ├── Candidato.java
│   ├── Afiliacao.java
│   ├── Aprovacao.java
│   ├── Voluntario.java
│   ├── PessoaFisica.java
│   ├── Perfil.java
│   ├── Habilidade.java
│   └── Interesse.java
├── repository/                         # Camada de persistência
│   ├── CandidatoDAO.java
│   ├── AprovacaoDAO.java
│   ├── VoluntarioDAO.java
│   ├── ONGDAO.java
│   └── RecomendacaoDAO.java
└── database/
    └── DatabaseConfig.java             # Configuração do banco

docs/
├── banco.sql                          # Modelo completo do banco
├── diagramas/                         # Diagramas UML
└── prototipos/                        # Telas do sistema
🛠 Tecnologias e Ferramentas
💻 Linguagens e Frameworks
Java 8+: Linguagem principal

UML: Modelagem dos diagramas

SQL: Modelo de dados

🗃️ Persistência de Dados
Abordagem: DAOs simulados (preparados para SGBD real)

Modelo: 25 tabelas documentadas em banco.sql

Pronto para: MySQL, Oracle, PostgreSQL

🔧 Ferramentas de Desenvolvimento
IDE: VS Code, Eclipse ou IntelliJ

Controle de versão: GitHub

Documentação: Wiki do GitHub

🚀 Como Executar
📥 Pré-requisitos
bash
# Java Development Kit 8 ou superior
java -version

# Git para clone do repositório
git --version
⚡ Execução Rápida
bash
# 1. Clone o repositório
git clone https://github.com/seu-usuario/rede-mais-social.git

# 2. Navegue até o diretório
cd rede-mais-social/src

# 3. Compile o projeto
javac -d bin boundary/*.java controller/*.java entity/*.java repository/*.java

# 4. Execute o sistema
java -cp bin boundary.AprovacaoBoundary
🎮 Como Usar
O sistema inicia automaticamente

Digite 1 para buscar candidatos pendentes

Selecione um candidato pelo ID

Escolha A para aprovar ou R para rejeitar

Siga as instruções na tela

🔄 Fluxos do Sistema
✅ Fluxo Principal - Aprovação Bem-sucedida
text
[INÍCIO] → Busca Candidatos → Seleciona Candidato → Analisa Dados → 
[Aprova] → Cria Sessão → Registra Aprovação → Cria Voluntário → 
[Recomenda] ONGs → Gera Credenciais → Envia Email → [FIM]
❌ Fluxo Alternativo - Rejeição
text
[INÍCIO] → Busca Candidatos → Seleciona Candidato → Analisa Dados → 
[Rejeita] → Informa Motivo → Registra Rejeição → Envia Email → [FIM]
⚠️ Fluxo Alternativo - Sem Candidatos
text
[INÍCIO] → Busca Candidatos → [Lista Vazia] → Mensagem Informativa → [FIM]
🗃️ Modelo de Dados
📊 Principais Tabelas (banco.sql)
sql
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
🔗 Relações Principais
Candidato 1:1 Afiliacao

Afiliação 1:1 Aprovacao

Aprovacao 1:1 Voluntario

Voluntario N:N ONG (via Recomendacao)

👥 Contribuições Individuais
📋 Divisão de Tarefas
Membro	Contribuições
Membro 1	Diagramas UML, Implementação Boundary, Documentação
Membro 2	Implementação Controller, Entidades, Testes
Membro 3	DAOs, Modelo de Dados, Persistência
Membro 4	Casos de Uso, Regras de Negócio, Validações
📖 Documentação na Wiki
Cada membro publicou individualmente na Wiki:

Diagramas UML desenvolvidos

Código fonte implementado

Explicação das contribuições

Protótipos e modelos

🎥 Vídeo Explicativo
📹 Conteúdo do Vídeo
Demonstração da correspondência UML ↔ Código

Execução do fluxo principal de aprovação

Explicação dos fluxos alternativos

Mostra dos diagramas implementados

Participação de todos os membros do grupo

🎯 Pontos Chave do Vídeo
Arquitetura MVC: Como as camadas se comunicam

Padrão DAO: Abstração da persistência

Correspondência UML: Diagramas → Código

Tratamento de Fluxos: Principal e alternativos

Preparação para SGBD: Modelo de dados completo
