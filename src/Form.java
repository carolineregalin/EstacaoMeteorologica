/* 
 *
 * - Alan Felipe Jantz 
 * - Caroline Belli Regalin
 * - Matheus Mahnke
 *
 */

import java.awt.*;
import java.io.*;
import java.nio.file.*;
import java.util.*;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.*;

public class Form extends javax.swing.JFrame {

    // Todos os meses do arquivo
    ArrayList<Path> meses;
    // Mês atual que se está trabalhando
    ArrayList<ClimaDoDia> mes;

    public Form() {
        initComponents();
        setDefault();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        txtCaminhoArquivo = new javax.swing.JTextField();
        btnSelecionar = new javax.swing.JButton();
        lblArquivo = new javax.swing.JLabel();
        lblMes = new javax.swing.JLabel();
        cmbMes = new javax.swing.JComboBox<>();
        separador = new javax.swing.JSeparator();
        jScrollPane1 = new javax.swing.JScrollPane();
        txtRelatorio = new javax.swing.JTextArea();
        btnExportar = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Estação Meteorológica");
        setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        setLocation(new java.awt.Point(0, 0));
        setMinimumSize(new java.awt.Dimension(500, 500));
        setName(""); // NOI18N

        txtCaminhoArquivo.setEnabled(false);

        btnSelecionar.setText("Selecionar");
        btnSelecionar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSelecionarActionPerformed(evt);
            }
        });

        lblArquivo.setText("Arquivo:");

        lblMes.setText("Mês:");
        lblMes.setEnabled(false);
        lblMes.setFocusCycleRoot(true);

        cmbMes.setEnabled(false);
        cmbMes.setFocusCycleRoot(true);
        cmbMes.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cmbMesActionPerformed(evt);
            }
        });

        txtRelatorio.setColumns(20);
        txtRelatorio.setRows(5);
        txtRelatorio.setEnabled(false);
        txtRelatorio.setFocusCycleRoot(true);
        jScrollPane1.setViewportView(txtRelatorio);

        btnExportar.setText("Exportar");
        btnExportar.setEnabled(false);
        btnExportar.setFocusCycleRoot(true);
        btnExportar.setMaximumSize(new java.awt.Dimension(105, 23));
        btnExportar.setMinimumSize(new java.awt.Dimension(105, 23));
        btnExportar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnExportarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(lblMes)
                            .addComponent(lblArquivo))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txtCaminhoArquivo)
                            .addComponent(cmbMes, 0, 224, Short.MAX_VALUE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(btnSelecionar, javax.swing.GroupLayout.PREFERRED_SIZE, 105, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btnExportar, javax.swing.GroupLayout.PREFERRED_SIZE, 101, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addComponent(separador))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtCaminhoArquivo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnSelecionar)
                    .addComponent(lblArquivo))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(separador, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblMes)
                    .addComponent(cmbMes, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnExportar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 387, Short.MAX_VALUE)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnExportarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnExportarActionPerformed
        try {
            // Pega o caminho da pasta selecionada pelo usuário
            Path caminho = new FilePathManipulator().SelecionarDiretorio();
            if (caminho != null) {
                // Cria um novo arquivo de texto no diretório informado pelo usuário
                FileWriter arqRelatorio = new FileWriter(caminho.toString() + "\\Relatorio-" + mes.get(0).getMesFormatado() + mes.get(0).getAno() + ".txt");
                // Pega o texto da área de texto do relatório e escreve no arquivo de texto
                arqRelatorio.write(txtRelatorio.getText());
                // Fecha o arquivo
                arqRelatorio.close();
            }
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(null, "Ocorreu um problema ao exportar relatório: \r\n" + ex.getMessage());
        }
    }//GEN-LAST:event_btnExportarActionPerformed

    private void btnSelecionarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSelecionarActionPerformed
        // Desabilita os botões e campos do formulário
        setFields(false);
        try {
            // Pega o caminho do arquivo selecionado pelo usuário
            Path caminho = new FilePathManipulator().SelecionarArquivo();
            if (caminho != null) {
                // Mostra o caminho no campo de texto
                txtCaminhoArquivo.setText(caminho.toString());
                // Habilita os botões e campos do formulário
                setFields(true);
                // Converte para um ArrayList os itens do binário, sem separar por mês
                ArrayList<ClimaDoDia> dias = new Leitor().Converte(caminho);
                // Do array, faz as verificações
                meses = new Organizer().separarMeses(dias);

                if (!meses.isEmpty()) {
                    // Retorna array com paths dos arquivo e gera a combo
                    for (Object obj : meses) {
                        cmbMes.addItem(obj.toString());
                    }
                    // Pega o primeiro mes como padrão para setar na cambobox
                    mes = new MesInfo().carregarMes(meses.get(0));

                    String relatorio = new MesInfo().gerarRelatorioMes(mes);

                    // Seta o texto no campo de relatório
                    txtRelatorio.setText(relatorio);
                }
            }
        } catch (Exception ex) {
            setFields(false);
            JOptionPane.showMessageDialog(null, "Ocorreu um problema: \r\n" + ex.getMessage());
        }
    }//GEN-LAST:event_btnSelecionarActionPerformed

    private void cmbMesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cmbMesActionPerformed
            if (!meses.isEmpty()) {
                try {
                    // Pega o mês selecionado na combobox e converte pra array de clima do dia
                    mes = new MesInfo().carregarMes(meses.get(cmbMes.getSelectedIndex()));
                } catch (Exception ex) {
                }
                if (!mes.isEmpty()) {
                    String relatorio = new MesInfo().gerarRelatorioMes(mes);
                    // Seta o texto no campo de relatório
                    txtRelatorio.setText(relatorio);
                }
            }
    }//GEN-LAST:event_cmbMesActionPerformed

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
            java.util.logging.Logger.getLogger(Form.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Form.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Form.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Form.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Form().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnExportar;
    private javax.swing.JButton btnSelecionar;
    private javax.swing.JComboBox<String> cmbMes;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel lblArquivo;
    private javax.swing.JLabel lblMes;
    private javax.swing.JSeparator separador;
    private javax.swing.JTextField txtCaminhoArquivo;
    private javax.swing.JTextArea txtRelatorio;
    // End of variables declaration//GEN-END:variables

    // Define a definição padrão do formulário
    private void setDefault() {
        Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();
        this.setLocation(dim.width / 2 - this.getSize().width / 2, dim.height / 2 - this.getSize().height / 2);
        this.setIconImage(new ImageIcon(getClass().getResource("\\PresentationLayer\\icone.png")).getImage());
    }
    
    // Define o comportamento dos campos do formulário
    private void setFields(boolean value) {
        if (!value) {
            txtRelatorio.setText("");
            txtCaminhoArquivo.setText("");
        }
        else {
            cmbMes.removeAllItems();
        }
        lblMes.setEnabled(value);
        cmbMes.setEnabled(value);
        btnExportar.setEnabled(value);
    }
}
