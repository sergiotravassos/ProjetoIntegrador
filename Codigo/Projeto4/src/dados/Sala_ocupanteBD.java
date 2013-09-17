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
    
    public boolean removerOcupanteDaSala(Ocupante ocupante) throws Exception {
        try {            
            Statement conex = conn.conectar();            
            String sql = "DELETE FROM sala_ocupante WHERE ocupante_codigo = '" + ocupante.getCodigo() + "'";
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
    
    public boolean inserirSala(Sala_ocupante sala_ocupante) throws Exception {
        try {
            Statement conex = conn.conectar();
            String sql = "INSERT INTO sala_ocupante (ocupante_codigo, sala_codigo)";
            sql += "VALUES ('" + sala_ocupante.getOcupante().getCodigo()+ "','" + sala_ocupante.getSala().getCodigo() + "');";
            conex.execute(sql);
            JOptionPane.showMessageDialog(null, "Sala inserida com sucesso");
            return true;
        } catch (SQLException e) {
            throw new Exception("Erro ao executar inserção: " + e.getMessage());
        } finally {
            conn.desconectar();
        }
    }
    
    public ArrayList<Sala_ocupante> listarTodasSalasOcupantes() throws Exception {
        Statement conex = conn.conectar();
        ArrayList<Sala_ocupante> retorno = new ArrayList<Sala_ocupante>();
        String sql = "SELECT * FROM sala_ocupante ";
        try {
            ResultSet rs = conex.executeQuery(sql);
            while (rs.next()) {
                Sala_ocupante sala_ocupante = new Sala_ocupante();
                Sala sala = new Sala();
                sala.setCodigo(rs.getString("sala_codigo"));
                Ocupante ocupante = new Ocupante();
                ocupante.setCodigo(rs.getString("ocupante_codigo"));
                sala_ocupante.setSala(sala);
                sala_ocupante.setOcupante(ocupante);
                /*
                ArrayList<Sala> arraySala = new ArrayList<Sala>();
                SalaBD salaBD = new SalaBD();
                arraySala = salaBD.listarTodasSalas();
                for (int i = 0; i <= arraySala.size(); i++)                {
                    if(arraySala.get(i).getCodigo() == rs.getString("sala_codigo")){
                        Sala sala = new Sala();
                        sala.setCapacidade(arraySala.get(i).getCapacidade());
                        sala.setNome(arraySala.get(i).getNome());
                        sala.setCodigo(arraySala.get(i).getCodigo());
                        sala_ocupante.setSala(sala);
                    }
                }                
                ArrayList<Ocupante> arrayOcupante = new ArrayList<Ocupante>();
                OcupanteBD ocupanteBD = new OcupanteBD();
                arrayOcupante = ocupanteBD.listarTodosOcupantes();
                for (int i = 0; i <= arrayOcupante.size(); i++)                {
                    if(arrayOcupante.get(i).getCodigo() == rs.getString("ocupante_codigo")){
                        Ocupante ocupante = new Ocupante();
                        ocupante.setCodigo(arrayOcupante.get(i).getCodigo());
                        ocupante.setNome(arrayOcupante.get(i).getNome());
                        sala_ocupante.setOcupante(ocupante);
                    }
                }
                */
                retorno.add(sala_ocupante);
            }
        } catch (SQLException e) {
            throw new Exception("Erro ao executar consulta: " + e.getMessage());
        }
        conn.desconectar();
        return retorno;
    }
    
}