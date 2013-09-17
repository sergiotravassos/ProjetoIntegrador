package objetos;

import java.util.ArrayList;

public class Sala {
    private String nome;
    private String codigo;
    private Responsavel responsavel = new Responsavel();
    private int capacidade;
    private ArrayList<Sala_ocupante> ocupante = new ArrayList<Sala_ocupante>();

    /**
     * @return the nome
     */
    public String getNome() {
        return nome;
    }

    /**
     * @param nome the nome to set
     */
    public void setNome(String nome) {
        this.nome = nome;
    }

    /**
     * @return the codigo
     */
    public String getCodigo() {
        return codigo;
    }

    /**
     * @param codigo the codigo to set
     */
    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    /**
     * @return the responsavel
     */
    public Responsavel getResponsavel() {
        return responsavel;
    }

    /**
     * @param responsavel the responsavel to set
     */
    public void setResponsavel(Responsavel responsavel) {
        this.responsavel = responsavel;
    }

    /**
     * @return the ocupante
     */
    public ArrayList<Sala_ocupante> getOcupante() {
        return ocupante;
    }

    /**
     * @param ocupante the ocupante to set
     */
    public void setOcupante(ArrayList<Sala_ocupante> ocupante) {
        this.ocupante = ocupante;
    }

    /**
     * @return the capacidade
     */
    public int getCapacidade() {
        return capacidade;
    }

    /**
     * @param capacidade the capacidade to set
     */
    public void setCapacidade(int capacidade) {
        this.capacidade = capacidade;
    }
}