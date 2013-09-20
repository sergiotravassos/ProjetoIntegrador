package dados;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import objetos.Ocupante;

public class OcupanteBD {
    
    ConexaoBD conn = new ConexaoBD();
    
    public boolean removerOcupante(Ocupante ocupante) throws Exception {
        try {            
            Statement conex = conn.conectar();            
            String sql = "DELETE FROM ocupante WHERE codigo = '" + ocupante.getCodigo() + "'";
            conex.execute(sql);
            JOptionPane.showMessageDialog(null, "Ocupante removido(a) com sucesso");
            return true;
        } catch (SQLException e) {            
            throw new Exception("Erro ao executar remoção: " + e.getMessage());
        } 
        finally {
            conn.desconectar();
        }
    }
    
    public boolean inserirOcupante(Ocupante ocupante) throws Exception {
        try {
            Statement conex = conn.conectar();
            String sql = "INSERT INTO ocupante (codigo, nome)";
            sql += "VALUES ('" + ocupante.getCodigo() + "','" + ocupante.getNome() +"');";
            conex.execute(sql);
            JOptionPane.showMessageDialog(null, "Ocupante inserido(a) com sucesso");
            return true;
        } catch (SQLException e) {
            throw new Exception("Erro ao executar inserção: " + e.getMessage());
        } finally {
            conn.desconectar();
        }
    }
    
    public boolean atualizarOcupante(Ocupante responsavel, Ocupante responsavelVelho) throws Exception {
        try {
            Statement conex = conn.conectar();
            String sql = "UPDATE ocupante SET ";
            sql += " nome = '" + responsavel.getNome() + "'";
            sql += " WHERE codigo = '" + responsavelVelho.getCodigo()+"'";
            conex.execute(sql);
            JOptionPane.showMessageDialog(null, "Ocupante atualizado(a) com sucesso");
            return true;
        } catch (SQLException e) {
            throw new Exception("Erro ao executar atualização " + e.getMessage());
        } 
        finally {
            conn.desconectar();
        }
    }
    
    public ArrayList<Ocupante> listarTodosOcupantes() throws Exception {
        Statement conex = conn.conectar();
        ArrayList<Ocupante> retorno = new ArrayList<Ocupante>();
        String sql = "SELECT * FROM ocupante ";
        try {
            ResultSet rs = conex.executeQuery(sql);
            while (rs.next()) {
                Ocupante responsavel = new Ocupante();
                responsavel.setCodigo(rs.getString("codigo"));
                responsavel.setNome(rs.getString("nome"));
                retorno.add(responsavel);
            }
        } catch (SQLException e) {
            throw new Exception("Erro ao executar consulta: " + e.getMessage());
        }
        conn.desconectar();
        return retorno;
    }
}