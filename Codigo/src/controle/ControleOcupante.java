package controle;

import dados.OcupanteBD;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import objetos.Ocupante;

public class ControleOcupante {

    Ocupante ocupante = new Ocupante();
    OcupanteBD banco = new OcupanteBD();
    ArrayList<Ocupante> arrayOcupante = new ArrayList<Ocupante>();

    public void inserirOcupante(Ocupante o) throws Exception {
        String ERRO = "";
        arrayOcupante = banco.listarTodosOcupantes();
        if ("".equals(o.getCodigo())) {
            ERRO = ERRO + "Informe o codigo do ocupante \r ";
        }
        if ("".equals(o.getNome())) {
            ERRO = ERRO + "Informe o nome do ocupante \r ";
        }

        if (o.getCodigo().trim().length() > 6) {
            ERRO = ERRO + "O codigo deve ter no maximo 6 caracteres ";
        }
        if (o.getNome().length() > 100) {
            ERRO = ERRO + "O nome deve ter no maximo 100 caracteres ";
        }

        for (int i = 0; i < arrayOcupante.size(); i++) {
            if (arrayOcupante.get(i).getCodigo().equals(o.getCodigo())) {
                ERRO = ERRO + "Este codigo ja pertence a outro ocupante ";
            }
            if (arrayOcupante.get(i).getNome().equals(o.getNome())) {
                ERRO = ERRO + "Este nome ja pertence a outro ocupante ";
            }
        }
        if ("".equals(ERRO))
        {
            
        }
        if (!"".equals(ERRO)){
            throw new Exception(ERRO);
        }
    }

    public void atualizarOcupantes(Ocupante novo, Ocupante velho) throws Exception {
        String ERRO = "";
        arrayOcupante = banco.listarTodosOcupantes();

        if ("".equals(novo.getNome())) {
            ERRO = ERRO + "Informe o nome do ocupante ";
        }

        if (novo.getNome().length() > 100) {
            ERRO = ERRO + "O nome deve ter no maximo 100 caracteres ";
        }

        for (int i = 0; i < arrayOcupante.size(); i++) {
            if (arrayOcupante.get(i).getNome().equals(novo.getNome()) && !velho.getNome().equals(novo.getNome())) {
                ERRO = ERRO + "Este nome ja pertence a outro ocupante ";
            }
        }
        if ("".equals(ERRO))
        {
            
        }
        if (!"".equals(ERRO)){
            throw new Exception(ERRO);
        }
    }
}