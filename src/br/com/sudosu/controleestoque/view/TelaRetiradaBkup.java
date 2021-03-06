/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.sudosu.controleestoque.view;

import br.com.sudosu.controleestoque.domain.Retirada;
import br.com.sudosu.controleestoque.servicos.BancoServicos;
import br.com.sudosu.controleestoque.servicos.ServicosFactory;
import java.sql.SQLException;
import java.text.DateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

/**
 *
 * @author Vinicius.Vianna
 */
public class TelaRetiradaBkup extends javax.swing.JInternalFrame {

    /**
     * Creates new form TelaRetiradaBkup
     */
    public TelaRetiradaBkup() {
        initComponents();
    }

    public void cadastrar() {
        Retirada retirada = new Retirada();

        try {
            retirada.setConteudo(taConteudo.getText());
            retirada.setLocal(group.getSelection().getActionCommand());
            retirada.setEnviado(tfEnviado.getText());
            retirada.setRecebido(tfRecebido.getText());

            BancoServicos bs = ServicosFactory.getBancoServicos();
            bs.cadastrarRetirada(retirada);

        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);
        }//fecha catch
    }//fecha metodo

    public ArrayList<Retirada> filtrarRetirada() throws SQLException {

        try {
            String busca = JOptionPane.showInputDialog("Digite o codigo da retirada!");
            HashMap filtro = new HashMap();
            filtro.put("", Integer.parseInt(busca));

            BancoServicos bs = ServicosFactory.getBancoServicos();
            String query;
            query = "where id_retirada =" + busca;

            ArrayList<Retirada> retirada = new ArrayList<>();
            retirada = bs.filtrarRetirada(query);

            for (int i = 0; i < retirada.size(); i++) {
                lblRetirada.setText(busca);
                taConteudo.setText(retirada.get(i).getConteudo());
                tfEnviado.setText(retirada.get(i).getEnviado());
                tfRecebido.setText(retirada.get(i).getRecebido());

                String rbtTipo = retirada.get(i).getLocal();
                if (rbtTipo.equals("container")) {
                    rbContainer.setSelected(true);
                } else {
                    rbMatriz.setSelected(true);
                }//fecha else
            }//fehca for
            return retirada;
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, "Erro ao buscar! " + e.getMessage());
        }//fecha catch
        return null;
    }//fecha metodo

    private void alterar() {
        Retirada retirada = new Retirada();

        try {
            retirada.setIdRetirada(Integer.parseInt(lblRetirada.getText()));
            retirada.setConteudo(taConteudo.getText());
            retirada.setLocal(group.getSelection().getActionCommand());
            retirada.setEnviado(tfEnviado.getText());
            retirada.setRecebido(tfRecebido.getText());

            BancoServicos bs = ServicosFactory.getBancoServicos();
            bs.alterarRetirada(retirada);

            JOptionPane.showMessageDialog(null, "Retirada alterada com sucesso!");
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Erro ao alterar Equipamento !" + e.getMessage());
        }//fecha catch
    }//fecha metodo

    private void limpar() {
        taConteudo.setText(null);
        tfEnviado.setText(null);
        tfRecebido.setText(null);
        lblRetirada.setText(null);
    }//fecha metodo

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        group = new javax.swing.ButtonGroup();
        jLabel1 = new javax.swing.JLabel();
        lblRetirada = new javax.swing.JLabel();
        lblData = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        taConteudo = new javax.swing.JTextArea();
        rbContainer = new javax.swing.JRadioButton();
        rbMatriz = new javax.swing.JRadioButton();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        tfEnviado = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        tfRecebido = new javax.swing.JTextField();
        btnAdicionar = new javax.swing.JButton();
        btnBuscar = new javax.swing.JButton();
        btnAlterar = new javax.swing.JButton();
        btnImprimir = new javax.swing.JButton();

        setClosable(true);
        setIconifiable(true);
        setMaximizable(true);
        setTitle("Retirada de Bkup");
        setEnabled(false);
        setFrameIcon(null);
        addInternalFrameListener(new javax.swing.event.InternalFrameListener() {
            public void internalFrameActivated(javax.swing.event.InternalFrameEvent evt) {
                formInternalFrameActivated(evt);
            }
            public void internalFrameClosed(javax.swing.event.InternalFrameEvent evt) {
            }
            public void internalFrameClosing(javax.swing.event.InternalFrameEvent evt) {
            }
            public void internalFrameDeactivated(javax.swing.event.InternalFrameEvent evt) {
            }
            public void internalFrameDeiconified(javax.swing.event.InternalFrameEvent evt) {
            }
            public void internalFrameIconified(javax.swing.event.InternalFrameEvent evt) {
            }
            public void internalFrameOpened(javax.swing.event.InternalFrameEvent evt) {
            }
        });

        jLabel1.setText("Numero da Retirada");

        lblRetirada.setText("num");

        lblData.setText("data");

        jLabel2.setText("Conteudo");

        taConteudo.setColumns(20);
        taConteudo.setRows(5);
        jScrollPane1.setViewportView(taConteudo);

        group.add(rbContainer);
        rbContainer.setText("Container");
        rbContainer.setActionCommand("container");

        group.add(rbMatriz);
        rbMatriz.setText("Matriz");
        rbMatriz.setActionCommand("matriz");

        jLabel3.setText("Local");

        jLabel4.setText("Enviado por");

        jLabel5.setText("Recebido por");

        btnAdicionar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/br/com/sudosu/controleestoque/imagens/icon_add.png"))); // NOI18N
        btnAdicionar.setToolTipText("Adicionar");
        btnAdicionar.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnAdicionar.setPreferredSize(new java.awt.Dimension(64, 64));
        btnAdicionar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAdicionarActionPerformed(evt);
            }
        });

        btnBuscar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/br/com/sudosu/controleestoque/imagens/icon_serch.png"))); // NOI18N
        btnBuscar.setToolTipText("Buscar");
        btnBuscar.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnBuscar.setPreferredSize(new java.awt.Dimension(64, 64));
        btnBuscar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBuscarActionPerformed(evt);
            }
        });

        btnAlterar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/br/com/sudosu/controleestoque/imagens/icon_edit.png"))); // NOI18N
        btnAlterar.setToolTipText("Alterar");
        btnAlterar.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnAlterar.setPreferredSize(new java.awt.Dimension(64, 64));
        btnAlterar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAlterarActionPerformed(evt);
            }
        });

        btnImprimir.setIcon(new javax.swing.ImageIcon(getClass().getResource("/br/com/sudosu/controleestoque/imagens/icon_print.png"))); // NOI18N
        btnImprimir.setToolTipText("Imprimir Etiqueta");
        btnImprimir.setPreferredSize(new java.awt.Dimension(64, 64));
        btnImprimir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnImprimirActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(59, 59, 59)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                        .addComponent(jLabel5)
                        .addComponent(jLabel4)
                        .addComponent(jLabel2)
                        .addComponent(jLabel1)
                        .addComponent(jLabel3))
                    .addComponent(btnAdicionar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(lblRetirada)
                                .addGap(149, 149, 149)
                                .addComponent(lblData))
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 252, Short.MAX_VALUE)
                            .addComponent(tfEnviado)
                            .addComponent(tfRecebido)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(rbContainer)
                                .addGap(18, 18, 18)
                                .addComponent(rbMatriz)))
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(btnBuscar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(52, 52, 52)
                        .addComponent(btnAlterar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 68, Short.MAX_VALUE)
                        .addComponent(btnImprimir, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(48, 48, 48))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(27, 27, 27)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(lblRetirada)
                    .addComponent(lblData))
                .addGap(57, 57, 57)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel2)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 109, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(11, 11, 11)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(rbContainer)
                    .addComponent(rbMatriz))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(tfEnviado, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5)
                    .addComponent(tfRecebido, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 64, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btnBuscar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnAlterar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnImprimir, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnAdicionar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(61, 61, 61))
        );

        setBounds(0, 0, 552, 543);
    }// </editor-fold>//GEN-END:initComponents

    private void btnAdicionarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAdicionarActionPerformed
        cadastrar();
        limpar();
    }//GEN-LAST:event_btnAdicionarActionPerformed

    private void formInternalFrameActivated(javax.swing.event.InternalFrameEvent evt) {//GEN-FIRST:event_formInternalFrameActivated
        Date data = new Date();
        DateFormat formatador = DateFormat.getDateInstance(DateFormat.SHORT);
        lblData.setText(formatador.format(data));
    }//GEN-LAST:event_formInternalFrameActivated

    private void btnBuscarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBuscarActionPerformed
        try {
            filtrarRetirada();
        } catch (SQLException ex) {
            Logger.getLogger(TelaRetiradaBkup.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_btnBuscarActionPerformed

    private void btnImprimirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnImprimirActionPerformed
        BancoServicos bs = ServicosFactory.getBancoServicos();
        try {
            bs.imprimirRelatorioRetirada();
        } catch (SQLException ex) {
            Logger.getLogger(TelaRetiradaBkup.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_btnImprimirActionPerformed

    private void btnAlterarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAlterarActionPerformed
        alterar();
        limpar();
    }//GEN-LAST:event_btnAlterarActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAdicionar;
    private javax.swing.JButton btnAlterar;
    private javax.swing.JButton btnBuscar;
    private javax.swing.JButton btnImprimir;
    private javax.swing.ButtonGroup group;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel lblData;
    private javax.swing.JLabel lblRetirada;
    private javax.swing.JRadioButton rbContainer;
    private javax.swing.JRadioButton rbMatriz;
    private javax.swing.JTextArea taConteudo;
    private javax.swing.JTextField tfEnviado;
    private javax.swing.JTextField tfRecebido;
    // End of variables declaration//GEN-END:variables
}
