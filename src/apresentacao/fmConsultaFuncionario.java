/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package apresentacao;

import java.awt.Dimension;
import java.awt.HeadlessException;
import java.awt.event.KeyEvent;
import java.text.DateFormat;
import java.text.ParseException;
///import net.proteanit.sql.DbUtils;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.Set;
import java.util.TreeSet;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import negocio.Estoque;
import negocio.Funcionario;
import persistencia.FuncionarioDAO;
import persistencia.IFuncionario;
import javax.swing.DefaultCellEditor;
import javax.swing.JComboBox;

/**
 *
 * @author Vinicius
 */
public class fmConsultaFuncionario extends javax.swing.JInternalFrame {

    /**
     * Creates new form fmConsultaFuncionario
     */
    IFuncionario dao = new FuncionarioDAO();
    Funcionario funcionario = new Funcionario();

    List<Funcionario> lista = new ArrayList<>();

    public void mostrarLista() {
        //  ((DefaultTableModel) jTable1.getModel()).setRowCount(0);
        List<Funcionario> lista2 = dao.listarTodos();
        /////////////////////////////////////////////////////////////////////////////////
        DefaultTableModel modelo2 = (DefaultTableModel) jTable1.getModel();
        modelo2.setNumRows(0);
        SimpleDateFormat DateFor = new SimpleDateFormat("dd/MM/yyyy");
        for (Funcionario pro : lista2) {
            String nascimento = DateFor.format(pro.getData_nascimento().getTime());
            String cadastro = DateFor.format(pro.getData_cadastro().getTime());

            modelo2.addRow(new Object[]{pro.getIdFuncionario().toString(), pro.getNome(),
                pro.getCpf(), nascimento, pro.getSexo(),
                pro.getEndereco(), pro.getTelefone(), pro.getCargo(), cadastro, pro.getLogin(), pro.getSenha()});
            System.out.println(pro.getNome());
        }

    }

    public boolean datas(String datas, String min) {
        try {
            SimpleDateFormat DateFor = new SimpleDateFormat("dd/MM/yyyy");
            DateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
            Date date = new Date();

            Date data = DateFor.parse(datas);

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
            if (data.before(DateFor.parse(min)) || data.after(dateFormat.parse(atual))) {
                JOptionPane.showConfirmDialog(null, "Campo Data invalida");
                return true;
            }

        } catch (ParseException ex) {
            Logger.getLogger(fmCadastroFuncionario.class.getName()).log(Level.SEVERE, null, ex);
        }
        return false;
    }

    /**
     *
     * @param nome
     * @param CPF
     * @param endereco
     * @param telefone
     * @param data_cadastro
     * @param data_nascimento
     * @param Login
     * @param senha
     * @return
     */
    public boolean verificar(String nome, String CPF, String endereco, String telefone, String data_cadastro, String data_nascimento, String Login, String senha, String id) {
        ////////////////////////////////////////////////////////////////////////////////////////Campos vazios
        if (nome.isEmpty()) {
            JOptionPane.showConfirmDialog(null, "Campo nome em branco na linha " + id);
            return false;
        }
        if (CPF.isEmpty()) {
            JOptionPane.showConfirmDialog(null, "Campo cpf em branco na linha " + id);
            return false;
        }
        if (data_cadastro.isEmpty()) {
            JOptionPane.showConfirmDialog(null, "Campo data de cadastro em branco na linha " + id);
            return false;
        }
        if (data_nascimento.isEmpty()) {
            JOptionPane.showConfirmDialog(null, "Campo Data de nascimento em branco na linha " + id);
            return false;
        }
        if (endereco.isEmpty()) {
            JOptionPane.showConfirmDialog(null, "Campo Endereço em branco na linha " + id);
            return false;
        }
        if (telefone.isEmpty()) {
            JOptionPane.showConfirmDialog(null, "Campo telefone em branco na linha " + id);
            return false;
        }
        if (Login.isEmpty()) {
            JOptionPane.showConfirmDialog(null, "Campo Login em branco na linha " + id);
            return false;
        }
        if (senha.isEmpty()) {
            JOptionPane.showConfirmDialog(null, "Campo senha em branco na linha " + id);
            return false;
        }
        ////////////////////////////////////////////////////////////////////////////////////////Data Validador
        if (datas(data_nascimento, "01/01/1960")) {
            //JOptionPane.showConfirmDialog(null,"Campo data de cadastro invalida");
            return false;
        }
        if (datas(data_cadastro, "01/01/2010")) {
            // JOptionPane.showConfirmDialog(null,"Campo Data de nascimento invalida");
            return false;
        }
        if ((CPF.substring(0, 3).contains(".") && CPF.substring(4, 7).contains(".") && CPF.substring(8, 11).contains("-") && CPF.length() == 14)) {
            JOptionPane.showConfirmDialog(null, "Campo CPF invalido formato valido ###.###.###-## na linha " + id);
            return false;
        }
        if ((CPF.substring(0, 3).contains(".") && CPF.substring(4, 7).contains(".") && CPF.substring(8, 11).contains("-") && CPF.length() == 14)) {
            JOptionPane.showConfirmDialog(null, "Campo CPF invalido formato valido ###.###.###-## na linha " + id);
            return false;
        }
        if ((telefone.substring(0, 1).contains("(") && telefone.substring(2, 3).contains(")") && telefone.substring(0, 1).contains("(") && telefone.substring(8).contains("(")) && telefone.length() == 13) {
            return false;
        }
        ///////////////////////////////////////////////////////////////////////////////////////Cpf e Login
        // os dois nao podem se repetido no banco
        return true;
    }

    public fmConsultaFuncionario() {
        initComponents();
        //this.jTable1.setPreferredSize(new Dimension(800, 0));
        jTable1.setAutoResizeMode(jTable1.AUTO_RESIZE_OFF);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        painelImagemLogin21 = new images.PainelImagemLogin2();
        jLabel1 = new javax.swing.JLabel();
        txtFuncionario = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        btLimpar = new javax.swing.JButton();
        btSalvar = new javax.swing.JButton();
        btExcluir = new javax.swing.JButton();
        btSair = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();

        setTitle("Consultar Funcionários");
        setPreferredSize(new java.awt.Dimension(998, 500));
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

        painelImagemLogin21.setImg(new ImageIcon("src/images/imagem_Login.jpg"));
        painelImagemLogin21.setPreferredSize(new java.awt.Dimension(1300, 449));
        painelImagemLogin21.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseExited(java.awt.event.MouseEvent evt) {
                painelImagemLogin21MouseExited(evt);
            }
        });

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(0, 0, 255));
        jLabel1.setText("Funcionário:");

        txtFuncionario.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txtFuncionarioKeyPressed(evt);
            }
        });

        jLabel2.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(0, 0, 255));
        jLabel2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/recursos/search_find_user_16727_1.png"))); // NOI18N
        jLabel2.setText("Consulta de Funcionários");

        btLimpar.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        btLimpar.setForeground(new java.awt.Color(0, 0, 255));
        btLimpar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/recursos/file_new_22051.png"))); // NOI18N
        btLimpar.setText("Limpar");
        btLimpar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btLimparActionPerformed(evt);
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

        btExcluir.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        btExcluir.setForeground(new java.awt.Color(0, 0, 255));
        btExcluir.setIcon(new javax.swing.ImageIcon(getClass().getResource("/recursos/Button-Red-Cancel-icon.png"))); // NOI18N
        btExcluir.setText("Excluir");
        btExcluir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btExcluirActionPerformed(evt);
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

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "ID", "Nome", "CPF", "Data de nascimento", "Sexo", "Endereço", "Telefone", "Cargo", "Data de cadastro", "Login", "Senha"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class
            };
            boolean[] canEdit = new boolean [] {
                false, true, true, true, true, true, true, true, true, true, true
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jTable1.getTableHeader().setReorderingAllowed(false);
        jScrollPane1.setViewportView(jTable1);
        if (jTable1.getColumnModel().getColumnCount() > 0) {
            jTable1.getColumnModel().getColumn(0).setPreferredWidth(30);
            jTable1.getColumnModel().getColumn(0).setMaxWidth(40);
            jTable1.getColumnModel().getColumn(1).setPreferredWidth(200);
            jTable1.getColumnModel().getColumn(1).setMaxWidth(250);
            jTable1.getColumnModel().getColumn(2).setPreferredWidth(100);
            jTable1.getColumnModel().getColumn(2).setMaxWidth(150);
            jTable1.getColumnModel().getColumn(3).setPreferredWidth(140);
            jTable1.getColumnModel().getColumn(3).setMaxWidth(150);
            jTable1.getColumnModel().getColumn(4).setPreferredWidth(50);
            jTable1.getColumnModel().getColumn(4).setMaxWidth(60);
            jTable1.getColumnModel().getColumn(4).setCellEditor(new DefaultCellEditor(new JComboBox(new String[]{"M","F"})));
            jTable1.getColumnModel().getColumn(5).setPreferredWidth(250);
            jTable1.getColumnModel().getColumn(5).setMaxWidth(300);
            jTable1.getColumnModel().getColumn(6).setPreferredWidth(100);
            jTable1.getColumnModel().getColumn(6).setMaxWidth(100);
            jTable1.getColumnModel().getColumn(7).setPreferredWidth(100);
            jTable1.getColumnModel().getColumn(7).setMaxWidth(100);
            jTable1.getColumnModel().getColumn(7).setCellEditor(new DefaultCellEditor(new JComboBox(new String[]{"Gerente","Atendente","Padeiro","Estoquista"})));
            jTable1.getColumnModel().getColumn(8).setPreferredWidth(130);
            jTable1.getColumnModel().getColumn(8).setMaxWidth(150);
        }

        javax.swing.GroupLayout painelImagemLogin21Layout = new javax.swing.GroupLayout(painelImagemLogin21);
        painelImagemLogin21.setLayout(painelImagemLogin21Layout);
        painelImagemLogin21Layout.setHorizontalGroup(
            painelImagemLogin21Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(painelImagemLogin21Layout.createSequentialGroup()
                .addGroup(painelImagemLogin21Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(painelImagemLogin21Layout.createSequentialGroup()
                        .addGroup(painelImagemLogin21Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(painelImagemLogin21Layout.createSequentialGroup()
                                .addGap(385, 385, 385)
                                .addComponent(jLabel2))
                            .addGroup(painelImagemLogin21Layout.createSequentialGroup()
                                .addContainerGap()
                                .addComponent(btLimpar)
                                .addGap(53, 53, 53)
                                .addComponent(btSalvar)
                                .addGap(51, 51, 51)
                                .addComponent(btExcluir)
                                .addGap(49, 49, 49)
                                .addComponent(btSair)))
                        .addGap(0, 664, Short.MAX_VALUE))
                    .addGroup(painelImagemLogin21Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jLabel1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(txtFuncionario))
                    .addComponent(jScrollPane1))
                .addContainerGap())
        );
        painelImagemLogin21Layout.setVerticalGroup(
            painelImagemLogin21Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(painelImagemLogin21Layout.createSequentialGroup()
                .addGap(29, 29, 29)
                .addComponent(jLabel2)
                .addGap(18, 36, Short.MAX_VALUE)
                .addGroup(painelImagemLogin21Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(txtFuncionario, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 219, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(11, 11, 11)
                .addGroup(painelImagemLogin21Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btLimpar)
                    .addComponent(btSalvar)
                    .addComponent(btExcluir)
                    .addComponent(btSair))
                .addContainerGap())
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(painelImagemLogin21, javax.swing.GroupLayout.DEFAULT_SIZE, 982, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(painelImagemLogin21, javax.swing.GroupLayout.DEFAULT_SIZE, 471, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btSairActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btSairActionPerformed
        // TODO add your handling code here:
        this.dispose();
    }//GEN-LAST:event_btSairActionPerformed

    private void btSalvarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btSalvarActionPerformed

        try {
            int valor = JOptionPane.showConfirmDialog(null, "Tem certeze que deseja salvar?", "Salvar edição", 1);
            if (valor == 0) {
                int tam = jTable1.getRowCount();
                for (int d = 0; d < tam; d++) {
                    String id = jTable1.getValueAt(d, 0).toString();
                    String nome = jTable1.getValueAt(d, 1).toString();
                    String CPF = jTable1.getValueAt(d, 2).toString();
                    String data_nascimento = jTable1.getValueAt(d, 3).toString();
                    String sexo = jTable1.getValueAt(d, 4).toString();
                    String endereco = jTable1.getValueAt(d, 5).toString();
                    String telefone = jTable1.getValueAt(d, 6).toString();
                    String cargo = jTable1.getValueAt(d, 7).toString();
                    String data_cadastro = jTable1.getValueAt(d, 8).toString();
                    String login = jTable1.getValueAt(d, 9).toString();
                    String senha = jTable1.getValueAt(d, 10).toString();

                    if (verificar(nome, CPF, endereco, telefone, data_cadastro, data_nascimento, login, senha, id)) {
                        funcionario.setIdFuncionario(Integer.parseInt(id));
                        funcionario.setNome(nome);///
                        funcionario.setCpf(CPF);//2
                        try {
                            SimpleDateFormat data = new SimpleDateFormat("dd/MM/yyyy");
                            Calendar cal = Calendar.getInstance();
                            cal.setTime(data.parse(data_nascimento));
                            funcionario.setData_nascimento(cal);//4
                            cal.setTime(data.parse(data_cadastro));
                            funcionario.setData_cadastro(cal);
                        } catch (ParseException ee) {
                            System.out.println(ee);
                        }
                        funcionario.setSexo(sexo);

                        funcionario.setEndereco(endereco);//6
                        funcionario.setTelefone(telefone);//
                        funcionario.setCargo(cargo);//8

                        funcionario.setLogin(login);
                        funcionario.setSenha(senha);
                        //lista.add(funcionario);
                        dao.altera(funcionario);
                    } else {
                        JOptionPane.showMessageDialog(null, "Erro em gravar linha " + id);
                        break;
                    }
                }
                JOptionPane.showMessageDialog(null, "Dados ja foram salvos");
                DefaultTableModel dtm = (DefaultTableModel) jTable1.getModel();
            }
        } catch (HeadlessException r) {
            System.out.println("erro");
        }
        ((DefaultTableModel) jTable1.getModel()).setRowCount(0);
        mostrarLista();
    }//GEN-LAST:event_btSalvarActionPerformed

    private void btExcluirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btExcluirActionPerformed
        int selRow = jTable1.getSelectedRow();
        String valor = (String) jTable1.getValueAt(jTable1.getSelectedRow(), 0);

        DefaultTableModel dtm = (DefaultTableModel) jTable1.getModel();
        if (jTable1.getSelectedRow() >= 0) {
            dtm.removeRow(jTable1.getSelectedRow());
            jTable1.setModel(dtm);
            //int valor=
            dao.remove(Integer.parseInt(valor));
        } else {
            JOptionPane.showMessageDialog(null, "Favor selecionar uma linha");
        }
    }//GEN-LAST:event_btExcluirActionPerformed

    private void formInternalFrameOpened(javax.swing.event.InternalFrameEvent evt) {//GEN-FIRST:event_formInternalFrameOpened
        // TODO add your handling code here:
        mostrarLista();
    }//GEN-LAST:event_formInternalFrameOpened

    private void btLimparActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btLimparActionPerformed
        // TODO add your handling code here:
        ((DefaultTableModel) jTable1.getModel()).setRowCount(0);
        mostrarLista();
    }//GEN-LAST:event_btLimparActionPerformed

    private void painelImagemLogin21MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_painelImagemLogin21MouseExited
        // TODO add your handling code here:

    }//GEN-LAST:event_painelImagemLogin21MouseExited

    private void txtFuncionarioKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtFuncionarioKeyPressed
        // TODO add your handling code here:
        if (evt.getKeyCode() == KeyEvent.VK_ENTER) {
            List<Funcionario> pes = dao.pesquisar(txtFuncionario.getText());
            DefaultTableModel modelo2 = (DefaultTableModel) jTable1.getModel();
            modelo2.setNumRows(0);
            SimpleDateFormat DateFor2 = new SimpleDateFormat("dd/MM/yyyy");
            SimpleDateFormat DateFor = new SimpleDateFormat("dd/MM/yyyy");
            for (Funcionario pro : pes) {
                String nascimento = DateFor.format(pro.getData_nascimento().getTime());
                String cadastro = DateFor.format(pro.getData_cadastro().getTime());

                modelo2.addRow(new Object[]{pro.getIdFuncionario().toString(), pro.getNome(),
                    pro.getCpf(), nascimento, pro.getSexo(),
                    pro.getEndereco(), pro.getTelefone(), pro.getCargo(), cadastro, pro.getLogin(), pro.getSenha()});
            }
        }
    }//GEN-LAST:event_txtFuncionarioKeyPressed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btExcluir;
    private javax.swing.JButton btLimpar;
    private javax.swing.JButton btSair;
    private javax.swing.JButton btSalvar;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTable1;
    private images.PainelImagemLogin2 painelImagemLogin21;
    private javax.swing.JTextField txtFuncionario;
    // End of variables declaration//GEN-END:variables
}
