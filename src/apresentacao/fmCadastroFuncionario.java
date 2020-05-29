/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package apresentacao;

import java.io.File;
import java.io.IOException;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.DefaultComboBoxModel;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;
import negocio.Funcionario;
import persistencia.FuncionarioDAO;
import persistencia.IFuncionario;

/**
 *
 * @author Vinicius
 */
public class fmCadastroFuncionario extends javax.swing.JInternalFrame {

    /**
     * Creates new form fmCadastroFuncionario
     */
    public fmCadastroFuncionario() {
        initComponents();
    }

    public boolean verificar() {
        ////////////////////////////////////////////////////////////////////////////////////////Campos vazios
        if (this.txtNome.getText().isEmpty()) {
            JOptionPane.showConfirmDialog(null, "Campo nome em branco");
            return false;
        }
        if (this.txtCPF.getText().isEmpty()) {
            JOptionPane.showConfirmDialog(null, "Campo cpf em branco");
            return false;
        }
        if (this.txtData.getText().isEmpty()) {
            JOptionPane.showConfirmDialog(null, "Campo Data em branco");
            return false;
        }
        if (this.txtEndereco.getText().isEmpty()) {
            JOptionPane.showConfirmDialog(null, "Campo Endereço em branco");
            return false;
        }
        if (this.txtTelefone.getText().isEmpty()) {
            JOptionPane.showConfirmDialog(null, "Campo telefone em branco");
            return false;
        }
        if (this.txtLogin.getText().isEmpty()) {
            JOptionPane.showConfirmDialog(null, "Campo Login em branco");
            return false;
        }
        if (Arrays.toString(this.txtSenha.getPassword()).isEmpty()) {
            JOptionPane.showConfirmDialog(null, "Campo senha em branco");
            return false;
        }
        ////////////////////////////////////////////////////////////////////////////////////////Data Validador
        try {
            SimpleDateFormat DateFor = new SimpleDateFormat("dd/MM/yyyy");
            DateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
            Date date = new Date();

            Date data = DateFor.parse(txtData.getText());

            String val[] = dateFormat.format(data).split("/");
            if ((val[1].contains("1") || val[1].contains("3") || val[1].contains("5") || val[1].contains("7")
                    || val[1].contains("8") || val[1].contains("10") || val[1].contains("12")) && (Integer.parseInt(val[0]) < 1 || Integer.parseInt(val[0]) > 31)) {
                JOptionPane.showConfirmDialog(null, "Campo Data dia maior que 31 ou menor que 1");
                return true;
            }
            if ((val[1].contains("4") || val[1].contains("6") || val[1].contains("9") || val[1].contains("11")) && (Integer.parseInt(val[0]) < 1 || Integer.parseInt(val[0]) > 30)) {
                JOptionPane.showConfirmDialog(null, "Campo Data dia maior que 30 ou menor que 1");
                return true;
            }
            if (val[1].contains("2") && (Integer.parseInt(val[1]) % 2 == 0) && (Integer.parseInt(val[0]) < 1 || Integer.parseInt(val[0]) > 29)) {
                JOptionPane.showConfirmDialog(null, "ano bisexto maior 29 ou menor que 1");
                return true;
            }
            if (val[1].contains("2") && (Integer.parseInt(val[0]) < 1 || Integer.parseInt(val[0]) > 28)) {
                JOptionPane.showConfirmDialog(null, "Campo Data dia maior 28 ou menor que 1");
                return true;
            }
            String atual = dateFormat.format(date);
            if (data.before(DateFor.parse("01/01/1940")) || data.after(dateFormat.parse(atual))) {
                JOptionPane.showConfirmDialog(null, "Campo Data invalido");
                return false;
            }

        } catch (ParseException ex) {
            Logger.getLogger(fmCadastroFuncionario.class.getName()).log(Level.SEVERE, null, ex);
        }
        ///////////////////////////////////////////////////////////////////////////////////////Cpf e Login
        // os dois nao podem se repetido no banco
        FuncionarioDAO dao = new FuncionarioDAO();
        List<Funcionario> lista = dao.listarTodos();

        for (Funcionario fun : lista) {
            if (fun.getCpf().equals(txtCPF.getText())) {
                JOptionPane.showConfirmDialog(null, "Cpf ja existe");
                return false;
            }
            if (fun.getLogin().equals(txtLogin.getText())) {
                JOptionPane.showConfirmDialog(null, "Login ja existe");
                return false;
            }
        }
        return true;
    }

    public void limpar() {
        txtNome.setText("");
        txtCPF.setText("");
        txtEndereco.setText("");
        txtData.setText("");
        txtLogin.setText("");
        txtSenha.setText("");

        txtTelefone.setText("");
    }

    public void habilitar(boolean hab) {
        //btNovo
        painelImagemLogin1.setVisible(hab);
        btNovo.setEnabled(!hab);
        btSalvar.setEnabled(hab);
        //btSair.setEnabled(hab);

    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        buttonGroup1 = new javax.swing.ButtonGroup();
        painelImagemLogin1 = new images.PainelImagemLogin();
        jLabel1 = new javax.swing.JLabel();
        lbNome = new javax.swing.JLabel();
        lbCPF = new javax.swing.JLabel();
        lbData = new javax.swing.JLabel();
        lbSexo = new javax.swing.JLabel();
        lbEndereco = new javax.swing.JLabel();
        lbCargo = new javax.swing.JLabel();
        lbTelefone = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        txtNome = new javax.swing.JTextField();
        txtCPF = new javax.swing.JFormattedTextField();
        txtData = new javax.swing.JFormattedTextField();
        rbMasculino = new javax.swing.JRadioButton();
        rbFeminino = new javax.swing.JRadioButton();
        txtEndereco = new javax.swing.JTextField();
        cbCargo = new javax.swing.JComboBox<>();
        txtTelefone = new javax.swing.JFormattedTextField();
        txtLogin = new javax.swing.JTextField();
        txtSenha = new javax.swing.JPasswordField();
        jDesktopPane1 = new javax.swing.JDesktopPane();
        btNovo = new javax.swing.JButton();
        btSalvar = new javax.swing.JButton();
        btSair = new javax.swing.JButton();

        setTitle("Cadastro de Funcionários");
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
        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/recursos/pessoa (1).png"))); // NOI18N
        jLabel1.setText("Cadastro de Funcionarios");

        lbNome.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        lbNome.setForeground(new java.awt.Color(0, 0, 255));
        lbNome.setText("Nome:");

        lbCPF.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        lbCPF.setForeground(new java.awt.Color(0, 0, 255));
        lbCPF.setText("CPF:");

        lbData.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        lbData.setForeground(new java.awt.Color(0, 0, 255));
        lbData.setText("Data de Nascimento:");

        lbSexo.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        lbSexo.setForeground(new java.awt.Color(0, 0, 255));
        lbSexo.setText("Sexo:");

        lbEndereco.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        lbEndereco.setForeground(new java.awt.Color(0, 0, 255));
        lbEndereco.setText("Endereço:");

        lbCargo.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        lbCargo.setForeground(new java.awt.Color(0, 0, 255));
        lbCargo.setText("Cargo:");

        lbTelefone.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        lbTelefone.setForeground(new java.awt.Color(0, 0, 255));
        lbTelefone.setText("Telefone:");

        jLabel2.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(0, 0, 255));
        jLabel2.setText("Login:");

        jLabel3.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(0, 0, 255));
        jLabel3.setText("Senha:");

        try {
            txtCPF.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.MaskFormatter("###.###.###-##")));
        } catch (java.text.ParseException ex) {
            ex.printStackTrace();
        }

        try {
            txtData.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.MaskFormatter("##/##/####")));
        } catch (java.text.ParseException ex) {
            ex.printStackTrace();
        }

        buttonGroup1.add(rbMasculino);
        rbMasculino.setForeground(new java.awt.Color(0, 0, 255));
        rbMasculino.setSelected(true);
        rbMasculino.setText("Masculino");

        buttonGroup1.add(rbFeminino);
        rbFeminino.setForeground(new java.awt.Color(0, 0, 255));
        rbFeminino.setText("Feminino");

        cbCargo.setBackground(new java.awt.Color(240, 240, 240));
        cbCargo.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Gerente", "Atendente", "Padeiro", "Estoquista" }));

        try {
            txtTelefone.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.MaskFormatter("(##)####-####")));
        } catch (java.text.ParseException ex) {
            ex.printStackTrace();
        }

        javax.swing.GroupLayout painelImagemLogin1Layout = new javax.swing.GroupLayout(painelImagemLogin1);
        painelImagemLogin1.setLayout(painelImagemLogin1Layout);
        painelImagemLogin1Layout.setHorizontalGroup(
            painelImagemLogin1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(painelImagemLogin1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(painelImagemLogin1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(painelImagemLogin1Layout.createSequentialGroup()
                        .addGap(81, 81, 81)
                        .addComponent(jLabel1))
                    .addGroup(painelImagemLogin1Layout.createSequentialGroup()
                        .addGroup(painelImagemLogin1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(lbCPF)
                            .addComponent(lbData)
                            .addComponent(lbNome)
                            .addComponent(lbSexo)
                            .addComponent(lbEndereco)
                            .addComponent(lbTelefone)
                            .addComponent(lbCargo))
                        .addGap(18, 18, 18)
                        .addGroup(painelImagemLogin1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(txtNome)
                            .addGroup(painelImagemLogin1Layout.createSequentialGroup()
                                .addComponent(rbMasculino)
                                .addGap(18, 18, 18)
                                .addComponent(rbFeminino))
                            .addComponent(txtEndereco, javax.swing.GroupLayout.DEFAULT_SIZE, 287, Short.MAX_VALUE)
                            .addComponent(cbCargo, javax.swing.GroupLayout.PREFERRED_SIZE, 97, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtCPF, javax.swing.GroupLayout.DEFAULT_SIZE, 287, Short.MAX_VALUE)
                            .addComponent(txtData)
                            .addComponent(txtTelefone, javax.swing.GroupLayout.DEFAULT_SIZE, 287, Short.MAX_VALUE)))
                    .addGroup(painelImagemLogin1Layout.createSequentialGroup()
                        .addGap(82, 82, 82)
                        .addGroup(painelImagemLogin1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel2)
                            .addComponent(jLabel3))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(painelImagemLogin1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txtLogin)
                            .addComponent(txtSenha))))
                .addContainerGap(33, Short.MAX_VALUE))
        );
        painelImagemLogin1Layout.setVerticalGroup(
            painelImagemLogin1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(painelImagemLogin1Layout.createSequentialGroup()
                .addContainerGap(12, Short.MAX_VALUE)
                .addComponent(jLabel1)
                .addGap(18, 18, 18)
                .addGroup(painelImagemLogin1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(painelImagemLogin1Layout.createSequentialGroup()
                        .addGroup(painelImagemLogin1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(lbNome)
                            .addComponent(txtNome, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(painelImagemLogin1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(lbCPF)
                            .addComponent(txtCPF, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addComponent(lbData))
                    .addComponent(txtData, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(painelImagemLogin1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lbSexo)
                    .addComponent(rbMasculino)
                    .addComponent(rbFeminino))
                .addGap(18, 18, 18)
                .addGroup(painelImagemLogin1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lbEndereco)
                    .addComponent(txtEndereco, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(painelImagemLogin1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lbCargo)
                    .addComponent(cbCargo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(painelImagemLogin1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lbTelefone)
                    .addComponent(txtTelefone, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(painelImagemLogin1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(txtLogin, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(painelImagemLogin1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(txtSenha, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(47, 47, 47))
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
                .addGap(25, 25, 25)
                .addComponent(btNovo)
                .addGap(60, 60, 60)
                .addComponent(btSalvar)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 63, Short.MAX_VALUE)
                .addComponent(btSair)
                .addGap(23, 23, 23))
        );
        jDesktopPane1Layout.setVerticalGroup(
            jDesktopPane1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jDesktopPane1Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jDesktopPane1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btNovo)
                    .addComponent(btSalvar)
                    .addComponent(btSair))
                .addContainerGap())
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(painelImagemLogin1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jDesktopPane1, javax.swing.GroupLayout.Alignment.TRAILING)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(painelImagemLogin1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 21, Short.MAX_VALUE)
                .addComponent(jDesktopPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btSairActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btSairActionPerformed
        // TODO add your handling code here:
        this.dispose();
    }//GEN-LAST:event_btSairActionPerformed

    private void btNovoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btNovoActionPerformed
        // TODO add your handling code here:
        habilitar(true);
        limpar();
    }//GEN-LAST:event_btNovoActionPerformed

    private void formInternalFrameOpened(javax.swing.event.InternalFrameEvent evt) {//GEN-FIRST:event_formInternalFrameOpened
        // TODO add your handling code here:

        //funcionario.setSize(464, 63);
        habilitar(false);
        limpar();
    }//GEN-LAST:event_formInternalFrameOpened

    private void btSalvarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btSalvarActionPerformed
        // TODO add your handling code here:
        int valor = JOptionPane.showConfirmDialog(null, "Tem certeze que deseja salvar?", "Funcionario novo", 1);
        if (valor == 0 && verificar()) {
            Funcionario funcionario = new Funcionario();
            funcionario.setNome(txtNome.getText());///
            funcionario.setCpf(txtCPF.getText());//2
            try {
                SimpleDateFormat data = new SimpleDateFormat("dd/MM/yyyy");
                Calendar cal = Calendar.getInstance();
                cal.setTime(data.parse(txtData.getText()));
                funcionario.setData_nascimento(cal);//4
            } catch (ParseException e) {
                System.out.println(e);
            }
            if (rbMasculino.isSelected()) {
                funcionario.setSexo("M");
            } else if (rbFeminino.isSelected()) {
                funcionario.setSexo("F");//
            }

            funcionario.setEndereco(txtEndereco.getText());//6
            funcionario.setTelefone(txtTelefone.getText());//
            funcionario.setCargo(this.cbCargo.getSelectedItem().toString());//8

            funcionario.setLogin(txtLogin.getText());
            String senha = new String(txtSenha.getPassword());
            funcionario.setSenha(senha);

            IFuncionario dao = new FuncionarioDAO();
            dao.adiciona(funcionario);
            JOptionPane.showConfirmDialog(null, "Os dados foram gravados");
            habilitar(false);
            limpar();
        }
    }//GEN-LAST:event_btSalvarActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btNovo;
    private javax.swing.JButton btSair;
    private javax.swing.JButton btSalvar;
    private javax.swing.ButtonGroup buttonGroup1;
    private javax.swing.JComboBox<String> cbCargo;
    private javax.swing.JDesktopPane jDesktopPane1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel lbCPF;
    private javax.swing.JLabel lbCargo;
    private javax.swing.JLabel lbData;
    private javax.swing.JLabel lbEndereco;
    private javax.swing.JLabel lbNome;
    private javax.swing.JLabel lbSexo;
    private javax.swing.JLabel lbTelefone;
    private images.PainelImagemLogin painelImagemLogin1;
    private javax.swing.JRadioButton rbFeminino;
    private javax.swing.JRadioButton rbMasculino;
    private javax.swing.JFormattedTextField txtCPF;
    private javax.swing.JFormattedTextField txtData;
    private javax.swing.JTextField txtEndereco;
    private javax.swing.JTextField txtLogin;
    private javax.swing.JTextField txtNome;
    private javax.swing.JPasswordField txtSenha;
    private javax.swing.JFormattedTextField txtTelefone;
    // End of variables declaration//GEN-END:variables

}
