## Board de Tarefas com Spring Boot 🚀
Este projeto tem como objetivo criar um board customizável de gerenciamento de tarefas, utilizando Spring Boot, MySQL e Maven, com foco em boas práticas de desenvolvimento e estruturação de código.

## Requisitos do Projeto:
- O aplicativo deve iniciar com um menu de opções: Criar novo board, Selecionar board, Excluir boards, Sair.
- O sistema deve salvar os boards e suas informações no banco de dados MySQL.
- Cada board deve ser composto por, no mínimo, três colunas (Inicial, Final, Cancelamento), podendo ter mais colunas do tipo "Pendente" (quantas forem necessárias).
- Cards podem ser adicionados, movidos entre as colunas e bloqueados/desbloqueados com motivo.

## Tecnologias Utilizadas:
<p align="center">
  <a href="https://skillicons.dev">
    <img src="https://skillicons.dev/icons?i=spring,mysql,maven" />
  </a>
</p>

## Funcionalidades:
- **Criação e manipulação de boards**: Criar novos boards, selecionar boards existentes, excluir boards.
- **Gerenciamento de colunas**: Colunas de cada board podem ser alteradas com nomes, tipo e ordem.
- **Gestão de cards**: Criar cards, mover entre as colunas, bloquear/desbloquear e cancelar cards.
- **Armazenamento no banco de dados**: As informações do board e seus cards são salvos em um banco de dados MySQL, garantindo persistência de dados.

## Estrutura das Colunas:
- **Inicial**: Primeira coluna do board, onde os cards começam.
- **Final**: Penúltima coluna, onde os cards são considerados concluídos.
- **Cancelamento**: Última coluna, para cards cancelados.
- **Pendente**: Colunas de status intermédio (quantas forem necessárias).

Regras:
- Apenas uma coluna pode ser do tipo "Inicial", "Final" ou "Cancelamento". As colunas "Pendente" podem ser quantas forem necessárias.
- Cards podem ser movidos entre as colunas, mas não podem pular etapas, exceto quando um card é movido diretamente para a coluna "Cancelamento".
- Cards bloqueados não podem ser movidos até que sejam desbloqueados.

## Menu de Manipulação de Board:
- Mover card para a próxima coluna.
- Cancelar um card.
- Criar um novo card.
- Bloquear e desbloquear card com motivo.
- Fechar o board selecionado.

## Configuração do Banco de Dados MySQL:
Para que o projeto funcione corretamente, é necessário configurar um banco de dados MySQL.

1. Crie o banco de dados no MySQL com o seguinte comando:

    ```sql
    CREATE DATABASE db_boards;
    ```

2. Após criar o banco de dados, configure a conexão no arquivo `src/main/resources/application.properties`:

    ```properties
    spring.datasource.url=jdbc:mysql://localhost:3306/db_boards
    spring.datasource.username=root
    spring.datasource.password=suasenha
    spring.datasource.driver-class-name=com.mysql.cj.jdbc.Driver
    ```

## Como Executar:
1. Clone o repositório:
    ```bash
    git clone https://github.com/JuliaaSilv/Board-Tarefas-Java.git
    ```
2. Navegue até o diretório do projeto:
    ```bash
    cd SeuRepositorio
    ```
3. Compile e execute o projeto com Maven:
    ```bash
    mvn spring-boot:run
    ```



