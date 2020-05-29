/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package apresentacao;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.DefaultComboBoxModel;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;
import negocio.Estoque;
import negocio.Funcionario;
import negocio.Venda;
import persistencia.EstoqueDAO;
import persistencia.FuncionarioDAO;
import persistencia.IEstoque;
import persistencia.IVenda;
import persistencia.VendaDAO;

/**
 *
 * @author Vinicius
 */
public class fmCadastroVenda extends javax.swing.JInternalFrame {

    /**
     * Creates new form fmCadastroVenda
     */
    public fmCadastroVenda() {
        initComponents();

    }

    String erro = null;

    public void limpar() {
        txtQuantidade.setText("");
        txtValor.setText("");
        txtData.setText("");
        //txtLogin.setText("");

        //paFoto.setText("");
    }

    public void habilitar(boolean hab) {
        //btNovo
        painelImagemLogin1.setVisible(hab);
        btNovo.setEnabled(!hab);
        btSalvar.setEnabled(hab);
       // btSair.setEnabled(hab);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        painelImagemLogin1 = new images.PainelImagemLogin();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        cbFuncionario = new javax.swing.JComboBox<>();
        jLabel3 = new javax.swing.JLabel();
        txtData = new javax.swing.JFormattedTextField();
        jLabel4 = new javax.swing.JLabel();
        cbProduto = new javax.swing.JComboBox<>();
        jLabel5 = new javax.swing.JLabel();
        txtQuantidade = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        txtValor = new javax.swing.JTextField();
        jDesktopPane1 = new javax.swing.JDesktopPane();
        btNovo = new javax.swing.JButton();
        btSalvar = new javax.swing.JButton();
        btSair = new javax.swing.JButton();

        setTitle("Cadastro de Venda");
        addInternalFrameListener(new javax.swing.event.InternalFrameListener() {
            public void internalFrameActivated(javax.swing.event.InternalFrameEvent evt) {
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
                formInternalFrameOpened(evt);
            }
        });

        painelImagemLogin1.setImg(new ImageIcon("src/images/imagem_Login.jpg"));

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(0, 0, 255));
        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/recursos/Shopping-icon_30277 (1).png"))); // NOI18N
        jLabel1.setText("Cadastro de Venda");

        jLabel2.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(0, 0, 255));
        jLabel2.setText("Funcionário:");

        cbFuncionario.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        jLabel3.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(0, 0, 255));
        jLabel3.setText("Data:");

        try {
            txtData.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.MaskFormatter("##/##/####")));
        } catch (java.text.ParseException ex) {
            ex.printStackTrace();
        }

        jLabel4.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(0, 0, 255));
        jLabel4.setText("Produto:");

        cbProduto.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        jLabel5.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(0, 0, 255));
        jLabel5.setText("Quantidade:");

        txtQuantidade.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtQuantidadeKeyTyped(evt);
            }
        });

        jLabel6.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(0, 0, 255));
        jLabel6.setText("Valor:");

        txtValor.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtValorActionPerformed(evt);
            }
        });
        txtValor.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtValorKeyTyped(evt);
            }
        });

        javax.swing.GroupLayout painelImagemLogin1Layout = new javax.swing.GroupLayout(painelImagemLogin1);
        painelImagemLogin1.setLayout(painelImagemLogin1Layout);
        painelImagemLogin1Layout.setHorizontalGroup(
            painelImagemLogin1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(painelImagemLogin1Layout.createSequentialGroup()
                .addGroup(painelImagemLogin1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(painelImagemLogin1Layout.createSequentialGroup()
                        .addGap(30, 30, 30)
                        .addGroup(painelImagemLogin1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(painelImagemLogin1Layout.createSequentialGroup()
                                .addComponent(jLabel1)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                            .addGroup(painelImagemLogin1Layout.createSequentialGroup()
                                .addComponent(jLabel4)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(cbProduto, javax.swing.GroupLayout.PREFERRED_SIZE, 210, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(jLabel5)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(txtQuantidade, javax.swing.GroupLayout.PREFERRED_SIZE, 61, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(26, 26, 26)
                                .addComponent(jLabel6)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)))
                        .addComponent(txtValor, javax.swing.GroupLayout.PREFERRED_SIZE, 118, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(painelImagemLogin1Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jLabel2)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(cbFuncionario, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGap(18, 18, 18)
                        .addComponent(jLabel3)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(txtData)))
                .addContainerGap())
        );
        painelImagemLogin1Layout.setVerticalGroup(
            painelImagemLogin1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(painelImagemLogin1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addGap(26, 26, 26)
                .addGroup(painelImagemLogin1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(cbFuncionario, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel3)
                    .addComponent(txtData, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(38, 38, 38)
                .addGroup(painelImagemLogin1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(cbProduto, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel5)
                    .addComponent(txtQuantidade, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel6)
                    .addComponent(txtValor, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(43, Short.MAX_VALUE))
        );

        btNovo.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        btNovo.setForeground(new java.awt.Color(0, 0, 255));
        btNovo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/recursos/file_new_22051.png"))); // NOI18N
        btNovo.setText("Novo");
        btNovo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btNovoActionPerformed(evt);
            }
        });

        btSalvar.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        btSalvar.setForeground(new java.awt.Color(0, 0, 255));
        btSalvar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/recursos/save_21411.png"))); // NOI18N
        btSalvar.setText("Salvar");
        btSalvar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btSalvarActionPerformed(evt);
            }
        });

        btSair.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        btSair.setForeground(new java.awt.Color(0, 0, 255));
        btSair.setIcon(new javax.swing.ImageIcon(getClass().getResource("/recursos/SignOut_icon-icons.com_74704.png"))); // NOI18N
        btSair.setText("Sair");
        btSair.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btSairActionPerformed(evt);
            }
        });

        jDesktopPane1.setLayer(btNovo, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jDesktopPane1.setLayer(btSalvar, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jDesktopPane1.setLayer(btSair, javax.swing.JLayeredPane.DEFAULT_LAYER);

        javax.swing.GroupLayout jDesktopPane1Layout = new javax.swing.GroupLayout(jDesktopPane1);
        jDesktopPane1.setLayout(jDesktopPane1Layout);
        jDesktopPane1Layout.setHorizontalGroup(
            jDesktopPane1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jDesktopPane1Layout.createSequentialGroup()
                .addGap(27, 27, 27)
                .addComponent(btNovo)
                .addGap(94, 94, 94)
                .addComponent(btSalvar)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(btSair)
                .addGap(41, 41, 41))
        );
        jDesktopPane1Layout.setVerticalGroup(
            jDesktopPane1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jDesktopPane1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jDesktopPane1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btNovo)
                    .addComponent(btSalvar)
                    .addComponent(btSair))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(painelImagemLogin1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jDesktopPane1)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(painelImagemLogin1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jDesktopPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btSairActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btSairActionPerformed
        // TODO add your handling code here:
        this.dispose();
    }//GEN-LAST:event_btSairActionPerformed
    private Venda verifica(Venda venda) throws ParseException {
        Date atual2 = new Date();

        SimpleDateFormat formatador = new SimpleDateFormat("dd/MM/yyyy");

        SimpleDateFormat data2 = new SimpleDateFormat("dd/MM/yyyy");
        Calendar cal = Calendar.getInstance();

        if (txtValor.getText().isEmpty()) {
            JOptionPane.showConfirmDialog(null, erro);
            erro = "Valor nao pode ser nulo";

        }
        if (txtQuantidade.getText().isEmpty()) {
            erro = "Quantidade nao pode ser nula ou ter ponto";
            JOptionPane.showConfirmDialog(null, erro);
            return null;

        }
        if (txtData.getText().isEmpty()) {
            erro = "Data nao pode ser vazia";
            JOptionPane.showConfirmDialog(null, erro);
            return null;

        }

///////////////////////////////////////////////////////////////valor
        if (txtValor.getText().contains(".") && txtValor.getText().length() > 3) {
            venda.setValor(Double.parseDouble(txtValor.getText()));
        } else {

        }
///////////////////////////////////////////////////////////////Quantidade
        IEstoque dao2 = new EstoqueDAO();
        Estoque estoque = new Estoque();
        estoque=dao2.getByID(Integer.parseInt(this.cbProduto.getSelectedItem().toString().split(" : ")[0]));
        if(Integer.parseInt(txtQuantidade.getText())>estoque.getQuantidade()){
             erro = "Nao pode vender mais do que tem no estoque";
            return null;
        }
        venda.setQuantidade(Integer.parseInt(txtQuantidade.getText()));
//////////////////////////////////////////////////////////////Data verificações

        if (data2.parse(txtData.getText()).equals(data2.parse(formatador.format(atual2)))) {
            cal.setTime(data2.parse(txtData.getText()));
            venda.setData(cal);
        } else {
            erro = "Data incorreta a venda so pode ser cadastrada no dia que foi feita";
            JOptionPane.showConfirmDialog(null, erro);
            return null;
        }
        return venda;
    }
    private void btNovoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btNovoActionPerformed
        // TODO add your handling code here:

        habilitar(true);
        limpar();
    }//GEN-LAST:event_btNovoActionPerformed

    private void formInternalFrameOpened(javax.swing.event.InternalFrameEvent evt) {//GEN-FIRST:event_formInternalFrameOpened
        // TODO add your handling code here:
        try {
            FuncionarioDAO dao = new FuncionarioDAO();
            List<Funcionario> lista = dao.listarTodos();

            DefaultComboBoxModel modelo = new DefaultComboBoxModel();
            for (Funcionario fun : lista) {
                modelo.addElement(fun.getIdFuncionario() + " : " + fun.getNome());

                // System.out.println(paciente.getNome());
            }

            this.cbFuncionario.setModel(modelo);

            //////////////////////////////////////////////////
            EstoqueDAO dao2 = new EstoqueDAO();
            List<Estoque> lista2 = dao2.listarTodos();

            DefaultComboBoxModel modelo2 = new DefaultComboBoxModel();
            for (Estoque pro : lista2) {
                modelo2.addElement(pro.getIdEstoque() + " : " + pro.getNomeProduto());
            }
            this.cbProduto.setModel(modelo2);

        } catch (Exception e) {
            System.out.println(e.toString());
            JOptionPane.showMessageDialog(null, "Houve um erro ao carregar os dado...");
        }
        habilitar(false);
        limpar();
    }//GEN-LAST:event_formInternalFrameOpened

    private void btSalvarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btSalvarActionPerformed
        // TODO add your handling code here:
        int valor = JOptionPane.showConfirmDialog(null, "Tem certeze que deseja salvar?", "Essa venda", 1);
        if (valor == 0) {
            Venda venda = new Venda();
            //     venda.setQuantidade(Integer.parseInt(this.txtQuantidade.getText()));
            venda.setIdFuncionario(Integer.parseInt(this.cbFuncionario.getSelectedItem().toString().split(" : ")[0]));//8
            venda.setIdEstoque(Integer.parseInt(this.cbProduto.getSelectedItem().toString().split(" : ")[0]));//8
            try {
                if (verifica(venda) != null) {

                    IVenda dao = new VendaDAO();
                    dao.adiciona(venda);
                    JOptionPane.showConfirmDialog(null, "Os dados foram gravados");
                    habilitar(false);
                    limpar();
                } else {
                    JOptionPane.showConfirmDialog(null, erro);

                }
            } catch (ParseException ex) {
                Logger.getLogger(fmCadastroVenda.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }//GEN-LAST:event_btSalvarActionPerformed

    private void txtQuantidadeKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtQuantidadeKeyTyped
        // TODO add your handling code here:
        String caracteres = "0987654321";
        if (!caracteres.contains(evt.getKeyChar() + "")) {
            evt.consume();
        }

    }//GEN-LAST:event_txtQuantidadeKeyTyped

    private void txtValorKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtValorKeyTyped
        // TODO add your handling code here:
        String caracteres = "0987654321.";
        if (!caracteres.contains(evt.getKeyChar() + "")) {
            evt.consume();
        }
    }//GEN-LAST:event_txtValorKeyTyped

    private void txtValorActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtValorActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtValorActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btNovo;
    private javax.swing.JButton btSair;
    private javax.swing.JButton btSalvar;
    private javax.swing.JComboBox<String> cbFuncionario;
    private javax.swing.JComboBox<String> cbProduto;
    private javax.swing.JDesktopPane jDesktopPane1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private images.PainelImagemLogin painelImagemLogin1;
    private javax.swing.JFormattedTextField txtData;
    private javax.swing.JTextField txtQuantidade;
    private javax.swing.JTextField txtValor;
    // End of variables declaration//GEN-END:variables
}
