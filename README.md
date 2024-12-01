# Caixa-Branca-AF-UX

# Erros apresentados no código

## 1. Problema no carregamento do driver JDBC

Class.forName("com.mysql.Driver.Manager").newInstance();
Este código está tentando carregar a classe do driver JDBC para MySQL, mas o nome da classe está incorreto. O nome correto da classe do driver é com.mysql.cj.jdbc.Driver. Além disso, o método newInstance() é desnecessário em versões mais recentes do Java.

Correção:

Class.forName("com.mysql.cj.jdbc.Driver");

## 2. Construção de string SQL com erros de sintaxe

sql += "select nome from usuarios";
sql += "where login = " + "'" + login + "'";
sql += "where login = " + "'" + senha + "'";
Aqui, o SQL está mal formado. A cláusula WHERE está sendo repetida duas vezes. A instrução SQL correta deve usar AND para unir as condições de login e senha em um único WHERE.

Correção:

sql = "SELECT nome FROM usuarios WHERE login = '" + login + "' AND senha = '" + senha + "'";
Além disso, considere usar uma abordagem mais segura, como PreparedStatement, para evitar vulnerabilidades de SQL Injection.

## 3. Problema na variável result
A variável result foi declarada como um campo da classe, mas não é necessário que ela seja uma variável de instância. Pode ser movida para dentro do método verificarUsuario como uma variável local.

Correção:

public boolean verificarUsuario(String login, String senha) {
    boolean result = false; // Tornar result uma variável local
    String sql = "SELECT nome FROM usuarios WHERE login = ? AND senha = ?";
    try (Connection conn = conectarBD();
         PreparedStatement st = conn.prepareStatement(sql)) {

        st.setString(1, login);
        st.setString(2, senha);
        
        try (ResultSet rs = st.executeQuery()) {
            if (rs.next()) {
                result = true;
                nome = rs.getString("nome");
            }
        }
    } catch (Exception e) {
        e.printStackTrace(); // Logar a exceção para ajudar no diagnóstico
    }
    return result;
}

## 4. Conexão não fechada

A conexão com o banco de dados é aberta mas nunca fechada. Este erro provoca a abertura de conexões desnecessárias levando ao uso excessivo de memória e processamento, e o número de conexões abertas exceder o suportado pelo banco de dados, o acesso ao banco de dados será impossibilitado.
