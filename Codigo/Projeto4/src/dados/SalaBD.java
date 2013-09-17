package dados;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import objetos.Responsavel;
import objetos.Sala;

public class SalaBD {

    ConexaoBD conn = new ConexaoBD();

    public boolean removerSala(Sala sala) throws Exception {
        try {
            JOptionPane.showMessageDialog(null, "Sala BD");
            Statement conex = conn.conectar();
            String sql = "DELETE FROM sala WHERE codigo = '" + sala.getCodigo() + "';";
            conex.execute(sql);
            JOptionPane.showMessageDialog(null, "Sala removida com sucesso");
            return true;
        } catch (SQLException e) {
            throw new Exception("Erro ao executar remoção: " + e.getMessage());
        } finally {
            conn.desconectar();
        }
    }

    public boolean inserirSala(Sala sala) throws Exception {
        try {
            Statement conex = conn.conectar();
            String sql = "INSERT INTO sala (codigo, nome, responsavel_codigo, capacidade)";
            sql += "VALUES ('" + sala.getCodigo() + "','" + sala.getNome() + "','" + sala.getResponsavel().getCodigo() + "'," + sala.getCapacidade() + ");";
            conex.execute(sql);
            JOptionPane.showMessageDialog(null, "Sala inserida com sucesso");
            return true;
        } catch (SQLException e) {
            throw new Exception("Erro ao executar inserção: " + e.getMessage());
        } finally {
            conn.desconectar();
        }
    }

    public boolean atualizarSala(Sala nova, Sala velha) throws Exception {
        try {
            Statement conex = conn.conectar();
            String sql = "UPDATE sala SET ";
            sql += " nome = '" + nova.getNome() + "'";
            sql += ", responsavel_codigo = '" + nova.getResponsavel().getCodigo() + "'";
            sql += ", capacidade = " + nova.getCapacidade() + "";
            sql += " WHERE codigo = '" + velha.getCodigo() + "'";
            conex.execute(sql);
            JOptionPane.showMessageDialog(null, "Sala atualizada com sucesso");
            return true;
        } catch (SQLException e) {
            throw new Exception("Erro ao executar atualização " + e.getMessage());
        } finally {
            conn.desconectar();
        }
    }

    public ArrayList<Sala> listarTodasSalas() throws Exception {


        Statement conex = conn.conectar();
        ArrayList<Sala> retorno = new ArrayList<Sala>();
        String sql = "SELECT * FROM sala ";
        try {
            ResultSet rs = conex.executeQuery(sql);
            ArrayList<Responsavel> arrayrespo = new ArrayList<Responsavel>();
            ResponsavelBD respBD = new ResponsavelBD();
            while (rs.next()) {
                Sala sala = new Sala();
                sala.setCodigo(rs.getString("codigo"));
                sala.setNome(rs.getString("nome"));
                sala.setCapacidade(rs.getInt("capacidade"));
                String resp = rs.getString("responsavel_codigo");
                Responsavel responsavel = new Responsavel();
                responsavel.setCodigo(resp);
                /*arrayrespo = respBD.listarTodosResponsaveis();
                for (int i = 0; i <= arrayrespo.size(); i++) {
                    if (arrayrespo.get(i).getCodigo().equals(resp)) {
                        responsavel.setCpf(arrayrespo.get(i).getCpf());
                        responsavel.setNome(arrayrespo.get(i).getNome());
                        JOptionPane.showMessageDialog(null, "Sala BD resp :" + resp + "resposanvel.getCodigo: " + responsavel.getCodigo());
                    }
                }*/
                sala.setResponsavel(responsavel);
                retorno.add(sala);

            }
        } catch (SQLException e) {
            throw new Exception("Erro ao executar consulta: " + e.getMessage());
        }
        conn.desconectar();
        return retorno;
    }
}