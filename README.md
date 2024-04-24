
# HelpDesk - Sistema de Chamados Técnicos em Informática

Este projeto é um sistema de gerenciamento de chamados técnicos para um departamento de informática. O sistema permite que usuários solicitem atendimentos técnicos e que técnicos gerenciem esses chamados.


## Funcionalidades

### Tela Inicial
- **Acesso de Usuários e Técnicos**: A tela inicial oferece dois links:
    - **Usuário**: Para usuários que precisam solicitar suporte técnico.
    - **Técnico**: Para técnicos que atendem os chamados.
- **Autenticação**: Ambos os links redirecionam para páginas de login onde as credenciais são inseridas.

### Tela do Usuário
- **Visualização de Chamados**: Usuários podem visualizar os chamados que criaram anteriormente.
- **Criação de Novos Chamados**: Usuários podem criar novos chamados preenchendo os campos necessários. Estes chamados incluem informações como:
    - Usuário
    - Setor
    - Descrição
    - Prioridade
    - Data de início

### Tela do Técnico
- **Chamados Disponíveis**: Técnicos podem visualizar chamados que estão disponíveis para atendimento.
- **Chamados Atribuídos**: Técnicos também podem ver chamados que já foram atribuídos a eles.
- **Gestão de Chamados**: Técnicos podem modificar o status do chamado para:
    - Aguardando técnico
    - Em atendimento
    - Escalado para outro setor
    - Finalizado
## Pré-requisitos
- **Java JDK**: Instale o Java JDK versão 11 ou superior, que pode ser baixado [aqui](https://www.oracle.com/java/technologies/javase-jdk11-downloads.html).
- **Maven**: Certifique-se de que o Maven está instalado para gerenciar as dependências do projeto. A instalação pode ser verificada executando `mvn -v` no terminal. Se necessário, instale o Maven seguindo as instruções disponíveis [aqui](https://maven.apache.org/install.html).
- **Spring Boot**: O projeto é baseado no Spring Boot. Não é necessário uma instalação separada do Spring Boot, pois o Maven gerenciará as dependências automaticamente.
## Configuração

- Instalar Dependências
```bash
mvn clean install
```
- Configurar Banco de Dados
```bash
spring.datasource.url=jdbc:mysql://localhost:3306/nome_do_banco
spring.datasource.username=seu_usuario
spring.datasource.password=sua_senha
```
- Executar a aplicação
```bash
mvn spring-boot:run
```
** Este comando irá iniciar o servidor de aplicação, e o sistema estará acessível via http://localhost:8080.
## Autores

- [Bianca Leal](https://www.linkedin.com/in/bianca-leall/)

- [Stephanie Lima](https://www.linkedin.com/in/stephanie-lima-rocha-07389291/)

- [Daniela Botelho](https://www.linkedin.com/in/dani-botelho/)

- [Gabriele Stephanie](https://www.linkedin.com/in/gabrielle-mestrinho-b162661b9/)

- [Karen Nogueira](https://www.linkedin.com/in/karennogueira/)

- [Aline](https://www.linkedin.com/in/alinealvesdacosta/)

- [Alyce](https://www.linkedin.com/in/alycequegi/)

- [Daniela Sousa](https://www.linkedin.com/in/daniela-sousa-lima/)

- [Cecilia](https://www.linkedin.com/in/cec%C3%ADlia-galv%C3%A3o/)

## Licença

[MIT](https://choosealicense.com/licenses/mit/)

