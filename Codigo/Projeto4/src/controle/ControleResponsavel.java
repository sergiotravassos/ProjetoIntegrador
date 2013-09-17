package controle;

import dados.ResponsavelBD;
import java.util.ArrayList;
import objetos.Responsavel;

public class ControleResponsavel {

    ResponsavelBD banco = new ResponsavelBD();
    ArrayList<Responsavel> arrayResponsavel = new ArrayList<Responsavel>();

    public void inserirResponsavel(Responsavel r) throws Exception {
        String ERRO = "";
        arrayResponsavel = banco.listarTodosResponsaveis();

        if ("".equals(r.getCodigo())) {
            ERRO = ERRO + "Informe o codigo do responsavel";
        }
        if ("".equals(r.getNome())) {
            ERRO = ERRO + "Informe o nome do responsavel";
        }
        if ("".equals(r.getCpf())) {
            ERRO = ERRO + "Informe 0 CPF do responsavel";
        }

        if (r.getCodigo().trim().length() > 6) {
            ERRO = ERRO + "O codigo deve ter no maximo 6 caracteres";
        }
        if (r.getNome().length() > 100) {
            ERRO = ERRO + "O nome deve ter no maximo 100 caracteres";
        }
        if (r.getCpf().trim().length() != 15) {
            ERRO = ERRO + "O CPF deve ter 11 digitos";
        }

        for (int i = 0; i < arrayResponsavel.size(); i++) {
            if (arrayResponsavel.get(i).getCodigo().equals(r.getCodigo())) {
                ERRO = ERRO + "Este codigo ja pertence a outro responsavel";
            }
            if (arrayResponsavel.get(i).getNome().equals(r.getNome())) {
                ERRO = ERRO + "Este nome ja pertence a outro responsavel";
            }
            if (arrayResponsavel.get(i).getCpf().equals(r.getCpf())){
                ERRO = ERRO + "Este CPF ja pertence a outro responsavel";
            }
        }
        if ("".equals(ERRO))
        {
            
        }
        if (!"".equals(ERRO)){
            throw new Exception(ERRO);
        }
    }

    public void atualizarResponsavel(Responsavel novo, Responsavel velho) throws Exception {
        String ERRO = "";
        arrayResponsavel = banco.listarTodosResponsaveis();

        if ("".equals(novo.getNome())) {
            ERRO = ERRO + "Informe o nome do responsavel";
        }
        if ("".equals(novo.getCpf())) {
            ERRO = ERRO + "Informe 0 CPF do responsavel";
        }

        if (novo.getNome().length() > 100) {
            ERRO = ERRO + "O nome deve ter no maximo 100 caracteres";
        }
        if (novo.getCpf().trim().length() != 15) {
            ERRO = ERRO + "O CPF deve ter 11 digitos";
        }

        for (int i = 0; i < arrayResponsavel.size(); i++) {
            if (arrayResponsavel.get(i).getNome().equals(novo.getNome()) && !velho.getNome().equals(novo.getNome())) {
                ERRO = ERRO + "Este nome ja pertence a outro responsavel";
            }
            if (arrayResponsavel.get(i).getCpf().equals(novo.getCpf()) && !velho.getCpf().equals(novo.getCpf())) {
                ERRO = ERRO + "Este CPF ja pertence a outro responsavel";
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