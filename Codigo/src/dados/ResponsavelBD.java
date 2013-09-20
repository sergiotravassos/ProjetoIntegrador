package dados;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import objetos.Responsavel;

public class ResponsavelBD {
    
    ConexaoBD conn = new ConexaoBD();
    
    public boolean removerResponsavel(Responsavel responsavel) throws Exception {
        try {            
            Statement conex = conn.conectar();            
            String sql = "DELETE FROM responsavel WHERE codigo = '" + responsavel.getCodigo() + "'";
            conex.execute(sql);
            JOptionPane.showMessageDialog(null, "Responsavel removido(a) com sucesso");
            return true;
        } catch (SQLException e) {            
            throw new Exception("Erro ao executar remoção: " + e.getMessage());
        } 
        finally {
            conn.desconectar();
        }
    }
    
    public boolean inserirResponsavel(Responsavel responsavel) throws Exception {
        try {
            Statement conex = conn.conectar();
            String sql = "INSERT INTO responsavel (codigo, nome, cpf)";
            sql += "VALUES ('" + responsavel.getCodigo() + "','" + responsavel.getNome() + "','" + responsavel.getCpf() +"');";
            conex.execute(sql);
            JOptionPane.showMessageDialog(null, "Responsavel inserido com sucesso");
            return true;
        } catch (SQLException e) {
            throw new Exception("Erro ao executar inserção: " + e.getMessage());
        } finally {
            conn.desconectar();
        }
    }
    
    public boolean atualizarResponsavel(Responsavel responsavel, Responsavel responsavelVelho) throws Exception {
        try {
            Statement conex = conn.conectar();
            String sql = "UPDATE responsavel SET ";
            sql += " nome = '" + responsavel.getNome() + "'";
            sql += ", cpf = '" + responsavel.getCpf()+ "'";
            sql += " WHERE codigo = '" + responsavelVelho.getCodigo()+"'";
            conex.execute(sql);
            JOptionPane.showMessageDialog(null, "Responsável atualizado com sucesso");
            return true;
        } catch (SQLException e) {
            throw new Exception("Erro ao executar atualização " + e.getMessage());
        } 
        finally {
            conn.desconectar();
        }
    }
    
    public ArrayList<Responsavel> listarTodosResponsaveis() throws Exception {
        Statement conex = conn.conectar();
        ArrayList<Responsavel> retorno = new ArrayList<Responsavel>();
        String sql = "SELECT * FROM responsavel ";
        try {
            ResultSet rs = conex.executeQuery(sql);
            while (rs.next()) {
                Responsavel responsavel = new Responsavel();
                responsavel.setCodigo(rs.getString("Codigo"));
                responsavel.setNome(rs.getString("Nome"));
                responsavel.setCpf(rs.getString("CPF"));
                retorno.add(responsavel);
            }
        } catch (SQLException e) {
            throw new Exception("Erro ao executar consulta: " + e.getMessage());
        }
        conn.desconectar();
        return retorno;
    }
}