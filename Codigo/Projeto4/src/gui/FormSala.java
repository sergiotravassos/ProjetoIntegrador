package gui;

import controle.ControleSala;
import dados.OcupanteBD;
import dados.ResponsavelBD;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import dados.SalaBD;
import dados.Sala_ocupanteBD;
import objetos.Ocupante;
import objetos.Responsavel;
import objetos.Sala;
import objetos.Sala_ocupante;

public class FormSala extends javax.swing.JFrame {

    DefaultTableModel modelo = new DefaultTableModel();
    DefaultTableModel modelo2 = new DefaultTableModel();
    ArrayList<Sala> retorno = new ArrayList<Sala>();
    SalaBD banco = new SalaBD();
    ArrayList<Responsavel> arrayResp = new ArrayList<>();
    ResponsavelBD bancoResp = new ResponsavelBD();

    public void carregartabela(DefaultTableModel modelo) throws Exception {
        try {
            modelo.setRowCount(0);
            retorno = banco.listarTodasSalas();
            String codigo, nome, responsavel, capacidade;

            for (int i = 0; i < retorno.size(); i++) {
                codigo = retorno.get(i).getCodigo();
                nome = retorno.get(i).getNome();
                responsavel = "desocupada!";
                //~~~~
                String resp = retorno.get(i).getResponsavel().getCodigo();
                arrayResp = bancoResp.listarTodosResponsaveis();
                for (int j = 0; j < arrayResp.size(); j++) {
                    if (arrayResp.get(j).getCodigo().equals(resp)) {
                        responsavel = arrayResp.get(j).getNome();
                    }

                }
                //~~~~
                capacidade = String.valueOf(retorno.get(i).getCapacidade());
                modelo.addRow(new String[]{codigo, nome, responsavel, capacidade});
            }
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(null, ex.getMessage());
        }
    }

    public FormSala() {

        try {
            initComponents();
            this.setLocationRelativeTo(null);
            modelo.setColumnIdentifiers(new String[]{"Codigo", "Nome", "Responsavel", "Capacidade"});
            jTable1.setModel(modelo);
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(null, ex.getMessage());
        }
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane2 = new javax.swing.JScrollPane();
        jTable2 = new javax.swing.JTable();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        jBtAdicionar = new javax.swing.JButton();
        jBtDeletar = new javax.swing.JButton();
        jBtAlterar = new javax.swing.JButton();
        jScrollPane3 = new javax.swing.JScrollPane();
        jTable3 = new javax.swing.JTable();
        jBtOcup = new javax.swing.JButton();

        jTable2.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        jScrollPane2.setViewportView(jTable2);

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowOpened(java.awt.event.WindowEvent evt) {
                formWindowOpened(evt);
            }
            public void windowActivated(java.awt.event.WindowEvent evt) {
                formWindowActivated(evt);
            }
        });

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Codigo", "Nome", "Responsavel", "Capacidade"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }
        });
        jTable1.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                jTable1FocusGained(evt);
            }
        });
        jScrollPane1.setViewportView(jTable1);

        jBtAdicionar.setText("Adicionar");
        jBtAdicionar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBtAdicionarActionPerformed(evt);
            }
        });

        jBtDeletar.setText("Deletar");
        jBtDeletar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBtDeletarActionPerformed(evt);
            }
        });

        jBtAlterar.setText("Alterar");
        jBtAlterar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBtAlterarActionPerformed(evt);
            }
        });

        jTable3.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Ocupantes"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }
        });
        jScrollPane3.setViewportView(jTable3);

        jBtOcup.setText("Carregar ocupantes");
        jBtOcup.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBtOcupActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 375, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jBtAdicionar)
                        .addGap(18, 18, 18)
                        .addComponent(jBtDeletar)
                        .addGap(18, 18, 18)
                        .addComponent(jBtAlterar)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                    .addComponent(jBtOcup, javax.swing.GroupLayout.PREFERRED_SIZE, 120, Short.MAX_VALUE))
                .addGap(25, 25, 25))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 275, Short.MAX_VALUE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jBtAdicionar)
                        .addComponent(jBtDeletar)
                        .addComponent(jBtAlterar))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(jBtOcup)
                        .addContainerGap())))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void formWindowActivated(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowActivated
    }//GEN-LAST:event_formWindowActivated

    private void formWindowOpened(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowOpened
        try {
            carregartabela(modelo);
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(null, ex.getMessage());
        }
    }//GEN-LAST:event_formWindowOpened

    private void jBtAdicionarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBtAdicionarActionPerformed
        InserirSala abrir = new InserirSala();
        abrir.show();
    }//GEN-LAST:event_jBtAdicionarActionPerformed

    private void jBtDeletarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBtDeletarActionPerformed
        if (JOptionPane.showConfirmDialog(null, "tem certeza que deseja excluir?") == 0) {
            Sala sala = new Sala();
            int selec = jTable1.getSelectedRow();
            sala.setCodigo(modelo.getValueAt(selec, 0).toString());
            sala.setNome(modelo.getValueAt(selec, 1).toString());
            String resp = modelo.getValueAt(selec, 2).toString();
            Responsavel responsavel = new Responsavel();
            responsavel.setCodigo(resp);
            sala.setResponsavel(responsavel);
            ControleSala valida = new ControleSala();
            try {
                valida.removerSala(sala);
                banco.removerSala(sala);
            } catch (Exception ex) {
                JOptionPane.showMessageDialog(null, ex.getMessage());
            }
            return;
        }
        JOptionPane.showMessageDialog(null, "Operação Cancelada");

    }//GEN-LAST:event_jBtDeletarActionPerformed

    private void jBtAlterarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBtAlterarActionPerformed

        try {
            AlterarSala abrir;
            abrir = new AlterarSala();
            abrir.show();
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(null, ex.getMessage());
        }

    }//GEN-LAST:event_jBtAlterarActionPerformed

    private void jTable1FocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_jTable1FocusGained
    }//GEN-LAST:event_jTable1FocusGained

    private void jBtOcupActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBtOcupActionPerformed
        Sala sala = new Sala();
        int selec = jTable1.getSelectedRow();
        sala.setCodigo(modelo.getValueAt(selec, 0).toString());

        try {
            modelo2.setRowCount(0);
            ArrayList<Sala_ocupante> arrayOcupantes = new ArrayList<Sala_ocupante>();
            Sala_ocupanteBD banco3 = new Sala_ocupanteBD();
            Ocupante ocupante = new Ocupante();
            ArrayList<Ocupante> arrayOcupante = new ArrayList<Ocupante>();
            OcupanteBD banco4 = new OcupanteBD();
            arrayOcupante = banco4.listarTodosOcupantes();
            String ocu = "";
            arrayOcupantes = banco3.listarTodasSalasOcupantes();
            for (int i = 0; i < arrayOcupantes.size(); i++) {
                if (arrayOcupantes.get(i).getSala().getCodigo().equals(sala.getCodigo())) {
                    ocu = arrayOcupantes.get(i).getOcupante().getCodigo();
                    for (int j = 0; j < arrayOcupante.size(); j++) {
                        if (arrayOcupante.get(j).getCodigo().equals(ocu)) {
                            modelo2.addRow(new String[]{arrayOcupante.get(j).getNome()});
                        }
                    }
                }
            }
            modelo2.setColumnIdentifiers(new String[]{"Ocupantes"});
            jTable3.setModel(modelo2);
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(null, ex.getMessage());
        }
    }//GEN-LAST:event_jBtOcupActionPerformed
    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;






                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(FormSala.class
                    .getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(FormSala.class
                    .getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(FormSala.class
                    .getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(FormSala.class
                    .getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new FormSala().setVisible(true);
            }
        });
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jBtAdicionar;
    private javax.swing.JButton jBtAlterar;
    private javax.swing.JButton jBtDeletar;
    private javax.swing.JButton jBtOcup;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JTable jTable1;
    private javax.swing.JTable jTable2;
    private javax.swing.JTable jTable3;
    // End of variables declaration//GEN-END:variables
}
