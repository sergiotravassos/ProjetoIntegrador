package controle;

import dados.SalaBD;
import dados.Sala_ocupanteBD;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import objetos.Sala;
import objetos.Sala_ocupante;

public class ControleSala {

    SalaBD banco = new SalaBD();
    Sala_ocupanteBD banco2 = new Sala_ocupanteBD();
    ArrayList<Sala> arraySala = new ArrayList<Sala>();
    ArrayList<Sala_ocupante> arraySala_ocupante = new ArrayList<Sala_ocupante>();

    public void inserirSala(Sala s) throws Exception {
        String ERRO = "";
        arraySala = banco.listarTodasSalas();

        if ("".equals(s.getCodigo())) {
            ERRO = ERRO + "Informe o codigo da sala\r";
        }
        if ("".equals(s.getNome())) {
            ERRO = ERRO + "Informe o nome da sala\r";
        }
        if (s.getCapacidade() == Integer.valueOf("")) {
            ERRO = ERRO + "Informe a capacidade da sala";
        }

        if (s.getCodigo().trim().length() > 6) {
            ERRO = ERRO + "O codigo deve ter no maximo 6 caracteres";
        }
        if (s.getNome().length() > 100) {
            ERRO = ERRO + "O nome deve ter no maximo 100 caracteres";
        }

        for (int i = 0; i < arraySala.size(); i++) {
            if (arraySala.get(i).getCodigo().equals(s.getCodigo())) {
                ERRO = ERRO + "Este codigo ja pertence a outra sala";
            }
            if (arraySala.get(i).getNome().equals(s.getNome())) {
                ERRO = ERRO + "Este nome ja pertence a outra sala";
            }
        }
        if ("".equals(ERRO)) {
        }
        if (!"".equals(ERRO)) {
            throw new Exception(ERRO);
        }
    }

    public void atualizarSala(Sala nova, Sala velha) throws Exception {
        String ERRO = "";
        arraySala = banco.listarTodasSalas();

        if ("".equals(nova.getCodigo())) {
            ERRO = ERRO + "Informe o codigo da sala";
        }
        if ("".equals(nova.getNome())) {
            ERRO = ERRO + "Informe o nome da sala";
        }
        if (nova.getCapacidade() == Integer.valueOf("")) {
            ERRO = ERRO + "Informe a capacidade da sala";
        }

        if (nova.getCodigo().trim().length() > 6) {
            ERRO = ERRO + "O codigo deve ter no maximo 6 caracteres";
        }
        if (nova.getNome().length() > 100) {
            ERRO = ERRO + "O nome deve ter no maximo 100 caracteres";
        }

        for (int i = 0; i < arraySala.size(); i++) {
            if (arraySala.get(i).getCodigo().equals(nova.getCodigo()) && !nova.getCodigo().equals(velha.getCodigo())) {
                ERRO = ERRO + "Este codigo ja pertence a outra sala";
            }
            if (arraySala.get(i).getNome().equals(nova.getNome()) && !nova.getCodigo().equals(velha.getCodigo())) {
                ERRO = ERRO + "Este nome ja pertence a outra sala";
            }
        }
        if ("".equals(ERRO)) {
        }
        if (!"".equals(ERRO)) {
            throw new Exception(ERRO);
        }
    }

    public void removerSala(Sala s) throws Exception {
        
        JOptionPane.showMessageDialog(null, "VAlida");
        String ERRO = "";
        if(s.getCodigo().equals("")){
            ERRO = ERRO + "Nenhuma sala foi selecionada!";
        }
                
        if ("".equals(s.getResponsavel().getCodigo())){
            ERRO = ERRO + "Existe um responasvel nessa sala";
        }
        arraySala_ocupante = banco2.listarSala_ocupante();
        for (int i = 0; i < arraySala_ocupante.size(); i++) {
            if (arraySala_ocupante.get(i).getSala().getCodigo() == s.getCodigo()){
                ERRO = ERRO + "e ocupantes também";
                i = arraySala_ocupante.size();
            }
        }
        if ("".equals(ERRO)) {
        }
        if (!"".equals(ERRO)) {
            throw new Exception(ERRO);
        }
    }
}