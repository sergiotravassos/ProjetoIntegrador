package dados;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class ConexaoBD {

    private Connection con;
    private Statement stm;

    public Statement conectar() throws Exception {
       
        try {
            String nomeConexao = "Projeto4";
            Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");
            con = DriverManager.getConnection("jdbc:odbc:" + nomeConexao);
        } catch (ClassNotFoundException e) {
            throw new Exception("Erro conectar ao banco de dados: " + e.getMessage());
        } catch (SQLException sqle) {
            throw new Exception("Erro conectar ao banco de dados: " + sqle.getMessage());
        }
        return con.createStatement();
    }

    public void desconectar() {
        try {
            con.close();
        } catch (SQLException sqle) {
        }
    }
}
