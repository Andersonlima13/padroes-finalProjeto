# 🏠 MyHome — Plataforma de Classificados Imobiliários

> Projeto acadêmico desenvolvido para a disciplina **Padrões de Projeto**, com foco na aplicação prática dos principais padrões GoF em um sistema orientado a objetos.

---


📘 Disciplina: Padrões de Projeto
🎓 Aluno: Anderson Sousa de Lima
👨‍🏫 Professor: Alex
📅 Período: 5º



## 📑 Sumário
- [Informações Acadêmicas](#-informações-acadêmicas)
- [Visão Geral](#-visão-geral)
- [Objetivos do Sistema](#-objetivos-do-sistema)
- [Escopo do Projeto](#-escopo-do-projeto)
- [Arquitetura e Organização](#-arquitetura-e-organização)
- [Perfis de Usuário](#-perfis-de-usuário)
- [Tipos de Imóveis](#-tipos-de-imóveis)
- [Padrões de Projeto Utilizados](#-padrões-de-projeto-utilizados)
- [Requisitos Funcionais](#-requisitos-funcionais)
- [Como Executar o Projeto](#-como-executar-o-projeto)
- [Tecnologias Utilizadas](#-tecnologias-utilizadas)
- [Considerações Finais](#-considerações-finais)

---

## 🎓 Informações Acadêmicas

- **Disciplina:** Padrões de Projeto  
- **Curso / Período:** 5º Período  
- **Professor:** Alex  
- **Aluno:** Anderson Sousa de Lima  

---

## 📌 Visão Geral

O **MyHome** é uma plataforma digital de classificados imobiliários que conecta **proprietários**, **corretores/imobiliárias** e **potenciais compradores ou locatários**.

O sistema permite que **Anunciantes** publiquem anúncios de imóveis para **venda ou aluguel**, enquanto **Usuários Comuns** podem pesquisar, filtrar e visualizar apenas anúncios ativos, respeitando regras de negócio e o ciclo de vida de cada anúncio.

O projeto foi desenvolvido com foco em **flexibilidade**, **extensibilidade** e **boas práticas de engenharia de software**, utilizando múltiplos **padrões de projeto** de forma integrada.

---

## 🎯 Objetivos do Sistema

- Permitir a criação e gerenciamento de anúncios imobiliários
- Controlar o ciclo de vida completo dos anúncios
- Notificar anunciantes automaticamente sobre alterações de estado
- Permitir buscas avançadas com filtros combináveis
- Facilitar manutenção e expansão futura do sistema

---

## 📦 Escopo do Projeto

O sistema contempla:

- Diferentes tipos de imóveis (casas, apartamentos, terrenos)
- Diferentes tipos de negociação (venda e aluguel)
- Múltiplos perfis de usuários
- Processos de publicação com validações
- Sistema de busca baseado apenas em anúncios ativos

O projeto **não utiliza banco de dados**, sendo toda a simulação realizada em memória, com foco exclusivo na **arquitetura e padrões de projeto**.

---

## 🏗️ Arquitetura e Organização

Estrutura principal do projeto:

org.example
├── Anuncio
│ ├── State
│ ├── FiltroDeBusca
│ ├── Notificacao
│ └── VerificadorAnuncios
├── Imovel
│ └── Factory
├── Usuario
├── Pagamento
├── Config
└── Main


Cada pacote representa uma responsabilidade clara dentro do sistema, seguindo princípios de **baixo acoplamento** e **alta coesão**.

---

## 👥 Perfis de Usuário

### 🔹 Anunciantes
- Proprietário
- Corretor / Imobiliária

**Permissões:**
- Criar anúncios
- Publicar anúncios
- Suspender anúncios
- Marcar anúncios como vendidos

---

### 🔹 Usuários Comuns
- Comprador
- Inquilino
- Visitante

**Permissões:**
- Buscar anúncios
- Aplicar filtros
- Visualizar apenas anúncios ativos

---

## 🏠 Tipos de Imóveis

Os imóveis são criados por meio do padrão **Factory Method**, permitindo fácil expansão:

- Casa
- Apartamento
- Terreno

Exemplo:
```java
Imovel casa = new CasaFactory().criarImovel();
🧩 Padrões de Projeto Utilizados
🔹 Singleton
Classe: ConfiguracaoSistema
Garante uma única instância de configurações globais do sistema.

🔹 Factory Method
Pacote: Imovel.Factory
Responsável pela criação desacoplada dos tipos de imóveis.

🔹 State
Pacote: Anuncio.State
Gerencia o ciclo de vida do anúncio, evitando transições inválidas:

Rascunho

Em Moderação

Ativo

Suspenso

Vendido

🔹 Chain of Responsibility
Pacote: Anuncio.VerificadorAnuncios
Valida anúncios antes da publicação (fotos, palavras proibidas).

🔹 Observer
Pacote: Anuncio.Notificacao
Notifica automaticamente os anunciantes sempre que o estado do anúncio muda.

🔹 Adapter
Pacote: Pagamento
Permite múltiplas formas de pagamento (PIX e Cartão) sem alterar a lógica principal.

🔹 Decorator
Pacote: Anuncio.FiltroDeBusca
Implementa buscas flexíveis e combináveis:

Busca base (somente anúncios ativos)

Filtro por tipo de imóvel

Filtro por tipo de negociação

Filtro por preço mínimo e máximo

📋 Requisitos Funcionais
Requisito	Descrição	Solução
RF01	Cadastro de anunciantes	Herança e polimorfismo
RF02	Criação de imóveis	Factory Method
RF03	Publicação de anúncios	Chain of Responsibility
RF04	Ciclo de vida	State
RF05	Notificações	Observer
RF06	Busca avançada	Decorator
RF07	Configurações globais	Singleton
RF08	Pagamentos	Adapter
▶️ Como Executar o Projeto
Pré-requisitos
Java JDK 17 ou superior (recomendado JDK 21)

IDE Java (IntelliJ IDEA ou Eclipse)

Execução
Clone o repositório

Abra o projeto na IDE

Execute a classe principal:

org.example.Main
Toda a simulação do sistema será exibida no console.

🛠️ Tecnologias Utilizadas
Java

Programação Orientada a Objetos (POO)

Padrões de Projeto GoF

Streams API

📌 Considerações Finais
O projeto MyHome demonstra a aplicação prática e integrada de múltiplos padrões de projeto, simulando um sistema real de mercado imobiliário.

A solução é modular, extensível e alinhada às boas práticas de engenharia de software, atendendo plenamente aos objetivos da disciplina de Padrões de Projeto.
