package dados;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import objetos.Ocupante;
import objetos.Sala;
import objetos.Sala_ocupante;

public class Sala_ocupanteBD {
    
    ConexaoBD conn = new ConexaoBD(); 
    
    
    public boolean inserirSala_ocupante(Sala_ocupante sala_ocupante) throws Exception {
        try {
            Statement conex = conn.conectar();
            String sql = "INSERT INTO sala_ocupante (ocupante_codigo, sala_codigo)";
            sql += "VALUES ('" + sala_ocupante.getOcupante().getCodigo() + "','" + sala_ocupante.getSala().getCodigo() + "');";
            conex.execute(sql);
            JOptionPane.showMessageDialog(null, "BEM VINDO!");
            return true;
        } catch (SQLException e) {
            throw new Exception("Erro ao executar inserção: " + e.getMessage());
        } finally {
            conn.desconectar();
        }
    }
    public boolean removerSala_ocupante(Ocupante ocupante) throws Exception {
        try {
            JOptionPane.showMessageDialog(null, "Sala BD");
            Statement conex = conn.conectar();
            String sql = "DELETE FROM sala_ocupante WHERE ocupante_codigo = '" + ocupante.getCodigo() + "';";
            conex.execute(sql);
            JOptionPane.showMessageDialog(null, "Volte Sempre");
            return true;
        } catch (SQLException e) {
            throw new Exception("Erro ao executar remoção: " + e.getMessage());
        } finally {
            conn.desconectar();
        }
    }
    
    public ArrayList<Sala_ocupante> listarSala_ocupante() throws Exception {


        Statement conex = conn.conectar();
        ArrayList<Sala_ocupante> retorno = new ArrayList<Sala_ocupante>();
        String sql = "SELECT * FROM sala_ocupante ";
        try {
            ResultSet rs = conex.executeQuery(sql);
            ResponsavelBD respBD = new ResponsavelBD();
            while (rs.next()) {
                Sala_ocupante sala_ocupante = new Sala_ocupante();
                Ocupante ocupante = new Ocupante();
                ocupante.setCodigo(rs.getString("ocupante_codigo"));
                sala_ocupante.setOcupante(ocupante);
                Sala sala = new Sala();
                sala.setCodigo(rs.getString("sala_codigo"));
                sala_ocupante.setSala(sala);
                retorno.add(sala_ocupante);
            }
        } catch (SQLException e) {
            throw new Exception("Erro ao executar consulta: " + e.getMessage());
        }
        conn.desconectar();
        return retorno;
    }
    
}