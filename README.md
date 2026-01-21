# 🎬 ScreenMatch (Java POO & Integração com API)

## 🌟 Status do Projeto

[![Linguagem Principal](https://img.shields.io/badge/Java-17%2B-red.svg?style=for-the-badge&logo=java)](https://www.java.com/pt-br/)
[![Build Tool](https://img.shields.io/badge/Compila%C3%A7%C3%A3o-Manual%20(javac)-blue.svg?style=for-the-badge)](https://docs.oracle.com/javase/tutorial/getStarted/cup.html)
[![Integração](https://img.shields.io/badge/API-OMDB-yellow.svg?style=for-the-badge&logo=omdb)](https://www.omdbapi.com/)
[![JSON Parser](https://img.shields.io/badge/Library-Gson-green.svg?style=for-the-badge&logo=google)](https://github.com/google/gson)
[![Licença](https://img.shields.io/badge/License-MIT-green.svg?style=for-the-badge)](LICENSE)

## 🎯 Visão Geral do Projeto

O **ScreenMatch** é um projeto de estudo avançado em **Programação Orientada a Objetos (POO)** em Java, desenvolvido a partir do curso da Alura. O objetivo principal é modelar e gerenciar títulos audiovisuais (Filmes, Séries e Episódios), aplicando conceitos fundamentais de POO como **Herança**, **Polimorfismo**, **Interfaces** e **Composição**.

A versão mais avançada do projeto demonstra a integração com a **API OMDB** para buscar dados de títulos em tempo real e utiliza a biblioteca **Gson** para o tratamento de dados JSON, além de incluir funcionalidades de persistência de dados em arquivo.

## 🏛 Arquitetura e Design de Software

O projeto é estruturado em pacotes que refletem a separação de responsabilidades e a organização lógica do código, focando em um design limpo e modular.

### Estrutura de Pacotes

A arquitetura do projeto é dividida em quatro pacotes principais, além do pacote de exceções:

| Pacote | Responsabilidade | Classes Chave | Conceitos de POO |
| :--- | :--- | :--- | :--- |
| `modelos` | **Modelos de Domínio** | `Titulo`, `Filme`, `Serie`, `Episodio`, `TituloOmdb` | Herança, Encapsulamento |
| `calculos` | **Regras de Negócio** | `CalculadoraDeTempo`, `FiltroRecomendacao`, `Classificavel` | Polimorfismo, Interfaces |
| `principal` | **Ponto de Entrada/Execução** | `Principal`, `PrincipalComBuscas`, `PrincipalComListas` | Inicialização, Fluxo de Aplicação |
| `excecao` | **Tratamento de Erros** | `ErroDeConversaoDeAnoException` | Tratamento de Exceções |

### Diagrama de Classes (Representação Textual)

```mermaid
classDiagram
    Titulo <|-- Filme
    Titulo <|-- Serie
    Serie "1" *-- "*" Episodio
    Classificavel <|.. Filme
    Classificavel <|.. Episodio
    
    class Titulo {
        +String nome
        +int anoDeLancamento
        +int duracaoMinutos
        +void avalia(double nota)
        +double mediaAvaliacao()
    }
    
    class Filme {
        +String diretor
        +int getClassificacao()
    }
    
    class Serie {
        +int temporadas
        +int episodiosPorTemporada
        +int minutosPorEpisodio
        +int getDuracaoMinutos()
    }
    
    class Episodio {
        +int numero
        +int totalVisualizacoes
        +int getClassificacao()
    }
    
    interface Classificavel {
        +int getClassificacao()
    }
    
    class CalculadoraDeTempo {
        +void inclui(Titulo t)
    }
    
    class FiltroRecomendacao {
        +void filtra(Classificavel c)
    }
```

## ✨ Funcionalidades Principais

O projeto demonstra as seguintes capacidades:

1.  **Modelagem de POO:** Implementação de herança (`Filme` e `Serie` herdam de `Titulo`), polimorfismo (diferentes implementações de `getDuracaoMinutos` e `getClassificacao`) e interfaces (`Classificavel`).
2.  **Cálculos de Maratona:** A `CalculadoraDeTempo` soma a duração de filmes e séries, considerando a estrutura de temporadas e episódios.
3.  **Sistema de Recomendação:** O `FiltroRecomendacao` utiliza a interface `Classificavel` para fornecer recomendações baseadas na classificação dos títulos.
4.  **Integração com API Externa:** A classe `PrincipalComBuscas` realiza requisições HTTP para a **API OMDB** para buscar dados de filmes e séries.
5.  **Tratamento de JSON:** Utilização da biblioteca **Gson** para desserializar as respostas JSON da API em objetos Java (`TituloOmdb` e `Titulo`).
6.  **Persistência:** O resultado das buscas é salvo em um arquivo JSON (`filmes.json`).

## 🛠 Dependências

O projeto utiliza a biblioteca **Gson** para manipulação de JSON.

```xml
<!-- Não é um projeto Maven, mas a dependência é: -->
<dependency>
    <groupId>com.google.code.gson</groupId>
    <artifactId>gson</artifactId>
    <version>2.10.1</version>
</dependency>
```

## ⚙ Pré-requisitos

*   **Java Development Kit (JDK)**: Versão 17 ou superior.
*   **Biblioteca Gson**: O JAR da biblioteca deve ser incluído no *classpath* para a execução da classe `PrincipalComBuscas`.
*   **Chave de API OMDB**: Necessária para a `PrincipalComBuscas`.

## 🚀 Instalação e Execução

O projeto é compilado e executado manualmente via `javac` e `java`, sem o uso de *build tools* como Maven ou Gradle.

### 1. Compilação

A partir do diretório raiz do projeto (`screenmatch/`):

```bash
# 1. Crie o diretório de saída
mkdir -p out

# 2. Compile todos os arquivos .java
# Nota: Certifique-se de que o JAR do Gson esteja no classpath se for executar PrincipalComBuscas
javac -d out screenmatch/src/br/com/alura/screenmatch/**/*.java screenmatch/src/br/com/alura/screenmatch/principal/*.java
```

### 2. Execução (Exemplo Básico)

Para executar a versão básica do projeto (sem API):

```bash
java -cp out br.com.alura.screenmatch.principal.Principal
```

### 3. Execução (Com Busca na API e JSON)

Para executar a versão com busca na API (requer Gson no *classpath* e a chave da API OMDB):

1.  **Obtenha o JAR do Gson** (versão 2.10.1 ou superior) e salve-o em um local acessível (ex: `lib/gson-2.10.1.jar`).
2.  **Insira sua chave da API OMDB** na variável `API_KEY` dentro de `PrincipalComBuscas.java`.
3.  **Execute** a classe principal, incluindo o JAR do Gson no *classpath*:

```bash
java -cp out:lib/gson-2.10.1.jar br.com.alura.screenmatch.principal.PrincipalComBuscas
```
*(A sintaxe do classpath pode variar dependendo do sistema operacional.)*

## 🕹 Exemplo de Interação (PrincipalComBuscas)

A execução da `PrincipalComBuscas` solicita o nome do filme ou série para buscar na API OMDB:

```
Digite o nome do filme ou série para buscar: The Matrix
Título: The Matrix
Ano: 1999
Duração: 136 min
Avaliação: 8.7
...
Digite o nome do filme ou série para buscar: sair
```

O resultado da busca é salvo no arquivo `filmes.json`.

## 📄 Licença

Este projeto está sob a **Licença MIT**.

## 🧑‍💻 Autor

Este projeto foi desenvolvido por [Gilvan Pedro](https://github.com/GilvanPedro).
