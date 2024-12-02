# Projeto - Autenticação de Login com Java

O projeto é desenvolvido para gerenciar operações relacionadas à autenticação de usuários em um sistema, utilizando um banco de dados MySQL. Ele oferece funcionalidades básicas para estabelecer uma conexão com o banco de dados e verificar se um usuário existe, validando o login e a senha fornecidos.

## Funcionalidades

1. Estabelecer Conexão com o Banco de Dados:

O método conectarBD() é responsável por estabelecer uma conexão com o banco de dados MySQL.
Ele utiliza o driver com.mysql.cj.jdbc.Driver para conectar-se ao banco de dados especificado no URL, com um usuário e senha fornecidos.
Em caso de falha na conexão, uma mensagem de erro será exibida no console, e o método retornará null.

2. Verificar Usuário no Banco de Dados:

O método verificarUsuario(String login, String senha) valida se o usuário forneceu um login e senha corretos.
Ele executa uma consulta SQL no banco de dados para procurar um usuário com os dados fornecidos.
Utiliza PreparedStatement para proteger contra ataques de SQL Injection.
Se o usuário for encontrado, o método:
Define o atributo result como true.
Armazena o nome do usuário no atributo nome.
Caso contrário, retorna false.

3. Acesso ao Nome do Usuário:

O método getNome() retorna o nome do usuário autenticado após uma validação bem-sucedida.
Se a autenticação não for bem-sucedida, ele retornará uma string vazia.

4. Resultado da Autenticação:

O método isResult() retorna o estado da autenticação.
true se a autenticação foi bem-sucedida; false caso contrário.

# Ferramentas

Java 19
Biblioteca JDBC
MySQL Server
GitHub

# Neste repositório remoto foram criadas 3 branches:

1. Main:

Contém o código fonte e um arquivo README.md com as principais falhas encontrados no código.

2. Etapa 3:

O arquivo README.md foi alterado para incluir:
Grafo de Fluxo.
Complexidade Ciclomática.
Caminhos Básicos.

3. Etapa 4:

Adicionado um Javadoc contendo a documentação completa do projeto.