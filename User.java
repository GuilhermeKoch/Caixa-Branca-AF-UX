

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

/**
 * Classe User
 * Responsável por gerenciar a conexão ao banco de dados e verificar usuários.
 */
public class User {

    /** Nome do usuário autenticado. */
    private String nome = "";

    /** Indica o resultado da autenticação. */
    private boolean result = false;

    /**
     * Método conectarBD
     * Estabelece uma conexão com o banco de dados MySQL.
     *
     * @return Connection Objeto de conexão ao banco de dados, ou null em caso de falha.
     */
    public Connection conectarBD() {
        Connection conn = null;
        try {
            // Carrega o driver JDBC correto
            Class.forName("com.mysql.cj.jdbc.Driver");
            String url = "jdbc:mysql://127.0.0.1/test";
            String user = "lopes";
            String password = "123";
            conn = DriverManager.getConnection(url, user, password);
        } catch (Exception e) {
            e.printStackTrace(); // Log de erro para depuração
        }
        return conn;
    }

    /**
     * Método verificarUsuario
     * Verifica se um usuário existe no banco de dados com o login e senha fornecidos.
     *
     * @param login Login do usuário a ser verificado.
     * @param senha Senha do usuário a ser verificada.
     * @return boolean Retorna true se o usuário for encontrado; caso contrário, false.
     */
    public boolean verificarUsuario(String login, String senha) {
        String sql = "SELECT nome FROM usuarios WHERE login = ? AND senha = ?";
        try (Connection conn = conectarBD();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {
            
            // Configura os parâmetros da consulta
            pstmt.setString(1, login);
            pstmt.setString(2, senha);

            // Executa a consulta
            try (ResultSet rs = pstmt.executeQuery()) {
                if (rs.next()) {
                    result = true;
                    nome = rs.getString("nome");
                }
            }
        } catch (Exception e) {
            e.printStackTrace(); // Log de erro para depuração
        }
        return result;
    }

    /**
     * Método getNome
     * Retorna o nome do usuário autenticado.
     *
     * @return String Nome do usuário autenticado.
     */
    public String getNome() {
        return nome;
    }

    /**
     * Método isResult
     * Retorna o resultado da autenticação.
     *
     * @return boolean True se o usuário foi autenticado, caso contrário False.
     */
    public boolean isResult() {
        return result;
    }
}
