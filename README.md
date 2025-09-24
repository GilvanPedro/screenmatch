# ScreenMatch (Java POO)

Projeto de estudos em Programação Orientada a Objetos (POO) em Java, inspirado no curso da Alura. O objetivo é modelar títulos audiovisuais (filmes, séries e episódios), praticar encapsulamento, herança, polimorfismo, interfaces e composição, além de aplicar cálculos simples como tempo total de maratona e um filtro de recomendação.

## Sumário

- [Tecnologias](#tecnologias)
- [Estrutura do projeto](#estrutura-do-projeto)
- [Como executar](#como-executar)
  - [Executar via IntelliJ IDEA](#executar-via-intellij-idea)
  - [Executar via terminal](#executar-via-terminal)
- [Funcionalidades principais](#funcionalidades-principais)
- [Saída de exemplo](#saída-de-exemplo)
- [Autor](#autor)

## Tecnologias

- Java (JDK 17+ recomendado)
- IntelliJ IDEA (opcional) — o projeto contém `screenmatch.iml`

> Observação: O projeto não utiliza Maven/Gradle neste momento; a compilação pode ser feita diretamente com `javac`.

## Estrutura do projeto

```
screenmatch/
├─ src/
│  ├─ Principal.java
│  └─ br/com/alura/screenmatch/
│     ├─ calculos/
│     │  ├─ CalculadoraDeTempo.java
│     │  ├─ Classificavel.java
│     │  └─ FiltroRecomendacao.java
│     └─ modelos/
│        ├─ Episodio.java
│        ├─ Filme.java
│        ├─ Serie.java
│        └─ Titulo.java
├─ out/               (gerado após compilação)
├─ .gitignore
├─ screenmatch.iml
└─ README.md
```

- `Principal.java` é o ponto de entrada da aplicação (`public static void main`).
- Pacote `br.com.alura.screenmatch.modelos` contém os modelos de domínio: `Titulo`, `Filme`, `Serie` e `Episodio`.
- Pacote `br.com.alura.screenmatch.calculos` contém utilitários e contratos: `CalculadoraDeTempo`, `FiltroRecomendacao` e a interface `Classificavel`.

## Como executar

### Executar via IntelliJ IDEA

1. Abra o diretório do projeto no IntelliJ (`File > Open...`).
2. Garanta que o SDK do projeto esteja configurado para JDK 17 ou superior (Project Structure > Project SDK).
3. Abra o arquivo `src/Principal.java` e clique no ícone de "play" ao lado do método `main` para executar.

### Executar via terminal

No Windows (PowerShell), a partir da raiz do projeto (`screenmatch/`):

```powershell
# 1) Criar pasta de saída (se necessário)
mkdir -Force out

# 2) Compilar todos os .java para a pasta out
javac -d out src\**\*.java

# 3) Executar a classe principal (no pacote padrão)
java -cp out Principal
```

Observações:
- O projeto utiliza a classe `Principal` no pacote padrão (sem declaração `package`), que importa classes dos pacotes `br.com.alura.screenmatch.*`.
- O parâmetro `-d out` instrui o `javac` a gerar os `.class` respeitando a estrutura de pacotes dentro da pasta `out`.

## Funcionalidades principais

- Criação e manipulação de títulos (`Titulo`) com atributos como nome, ano de lançamento, duração e avaliações.
- Especializações de título:
  - `Filme` (implementa `Classificavel` e fornece `getClassificacao()` com base na média de avaliações).
  - `Serie` (sobrescreve `getDuracaoMinutos()` para calcular a duração total de maratona com temporadas, episódios e minutos por episódio).
- `Episodio` também implementa `Classificavel`, classificando de acordo com o número de visualizações.
- `CalculadoraDeTempo` soma a duração total para maratonar filmes e séries selecionados.
- `FiltroRecomendacao` avalia objetos `Classificavel` e imprime mensagens de recomendação.

Arquivos de destaque:
- `src/Principal.java` — demonstra o uso das classes, criando filmes, série, avaliando, somando tempo e filtrando recomendações.
- `src/br/com/alura/screenmatch/modelos/Titulo.java` — base para herança (encapsula atributos e comportamentos comuns), com `avalia()` e `mediaAvaliacao()`.
- `src/br/com/alura/screenmatch/calculos/Classificavel.java` — interface que define o contrato `getClassificacao()`.

## Saída de exemplo

A execução típica imprime informações semelhantes a:

```
Duração do Filme: 180
Nome: O Poderoso Chefão
Ano de Lancamento: 1970
Total de Avaliações: 3
Nome: Lost
Ano de Lancamento: 2000
Duração para maratonar Lost: 5000
Tempo de minutos para maratonar os escolhidos: 5380
Muito bem avaliado no momento
Muito bem avaliado no momento
```

Obs.: Os valores e mensagens podem variar conforme as entradas no `Principal`.

## Autor

- Nome: Gilvan
- GitHub: [@GilvanPedro](https://github.com/GilvanPedro)

Se quiser, abra uma issue ou um pull request com sugestões de melhoria!
