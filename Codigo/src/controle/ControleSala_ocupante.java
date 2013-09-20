/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package controle;

import dados.Sala_ocupanteBD;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import objetos.Sala_ocupante;

/**
 *
 * @author aluno
 */
public class ControleSala_ocupante {

    Sala_ocupante sala_ocupante = new Sala_ocupante();
    Sala_ocupanteBD banco = new Sala_ocupanteBD();
    ArrayList<Sala_ocupante> arraySala_ocupante = new ArrayList<Sala_ocupante>();

    public void inserirSala_ocupante(Sala_ocupante so) {
        String ERRO = "";
        try {
            arraySala_ocupante = banco.listarSala_ocupante();
            for (int i = 0; i < arraySala_ocupante.size(); i++) {
                if (arraySala_ocupante.get(i).getOcupante().getCodigo().equals(so.getOcupante().getCodigo())) {
                    ERRO = ERRO + "O Ocupante ja está em uma sala!";
                }
            }
            if ("".equals(ERRO)) {
            }
            if (!"".equals(ERRO)) {
                throw new Exception(ERRO);
            }
        } catch (Exception ex) {
            Logger.getLogger(ControleSala_ocupante.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
