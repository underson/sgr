 /*
 * TelaFuncionario.java
 *
 * Created on 21/04/2012, 11:40:46
 */
package br.com.sca.frames;

import br.com.sca.controller.FornecedorController;
import br.com.sca.controller.TelefoneController;
import br.com.sca.datamodel.ModelTabelaTelefone;
import br.com.sca.entidades.Fornecedor;
import br.com.sca.entidades.Telefone;
import br.com.sca.persistencia.Dao;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import javax.swing.JOptionPane;


/**
 *
 * @author
 * @since 
 * @version 1.0
 */
public class TelaFornecedorTelefone extends javax.swing.JFrame {

    private FornecedorController controller;
    private Fornecedor fornecedor;
    private Dao dao;
    private Telefone telefone;
    private TelefoneController controllerTelefone;

    public TelaFornecedorTelefone() {
        initComponents();
        dao = new Dao();
        inicializar();
    }
    /*
     * método para instanciar entidade e controller e preencher a tabela
     */

    private void inicializar() {
        controller = new FornecedorController();
        tabelaFornecedor.setModel(controller.retornaModelTabelaCompleta(dao));
        fornecedor = new Fornecedor();
        esquemaConsulta();
        limparFormulario();
    }
    /*
     * método para limpar os campos de cadastro
     */

    private void limparFormulario() {
        tfCodigo.setText("");        
        tfRazaoSocial.setText("");
        tfEndereco.setText("");
        tfEmail.setText("");
        tfContato.setText("");
        tfTelefone.setText("");
        tfCpfCnpj.setText("");
        tfDataCad.setText("");
    }
    /*
     * método para deixar os botões de ação na configuração da aba de consulta
     */

    private void esquemaConsulta() {
        btCadastrar.setEnabled(true);
        btAlterar.setEnabled(false);
        btExcluir.setEnabled(false);
        btVoltar.setVisible(false);
        btSalvar.setVisible(false);
        btnConsultarTelefone.setEnabled(false);
    }
    /*
     * método para deixar os botões de ação na configuração da aba de consulta, com um
     * objeto selecionado na tabela
     */

    private void esquemaConsultaSelecao() {
        btCadastrar.setEnabled(true);
        btAlterar.setEnabled(true);
        btExcluir.setEnabled(true);
        btVoltar.setVisible(false);
        btSalvar.setVisible(false);
        btnConsultarTelefone.setEnabled(true);
    }
    /*
     * método para deixar os botões de ação na configuração da aba de cadastro
     */

    private void esquemaCadastro() {
        tabelaFornecedor.clearSelection();
        btCadastrar.setEnabled(false);
        btAlterar.setEnabled(false);
        btExcluir.setEnabled(false);
        btVoltar.setVisible(true);
        btSalvar.setVisible(true);
        btnConsultarTelefone.setEnabled(false);
    }

    private void limparPesquisa() {
        tfPesquisaNome.setText("");
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        btnGroupTipoTelefone = new javax.swing.ButtonGroup();
        dlgTelefones = new javax.swing.JDialog();
        jScrollPane3 = new javax.swing.JScrollPane();
        tabelaConsultaTelefone = new javax.swing.JTable();
        tfAlterarTelefone = new javax.swing.JFormattedTextField();
        rbtAlterarFixo = new javax.swing.JRadioButton();
        rbtAlterarCelular = new javax.swing.JRadioButton();
        rbtAlterarFax = new javax.swing.JRadioButton();
        btnAlterarOk = new javax.swing.JButton();
        btnAlterarTelefone = new javax.swing.JButton();
        btnSalvarTelefone = new javax.swing.JButton();
        painelAbas = new javax.swing.JTabbedPane();
        painelConsulta = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tabelaFornecedor = new javax.swing.JTable();
        lbPesquisaNome = new javax.swing.JLabel();
        tfPesquisaNome = new javax.swing.JTextField();
        painelCadastro = new javax.swing.JPanel();
        painelComponentesCadastro = new javax.swing.JPanel();
        lbCodigo = new javax.swing.JLabel();
        lbRazaoSocial = new javax.swing.JLabel();
        lbDataCad = new javax.swing.JLabel();
        tfCodigo = new javax.swing.JTextField();
        tfRazaoSocial = new javax.swing.JTextField();
        tfDataCad = new javax.swing.JTextField();
        lblEmail = new javax.swing.JLabel();
        tfEmail = new javax.swing.JTextField();
        tfCpfCnpj = new javax.swing.JTextField();
        lblCpfCnpj = new javax.swing.JLabel();
        tfContato = new javax.swing.JTextField();
        lblContato = new javax.swing.JLabel();
        lbTelefone = new javax.swing.JLabel();
        lbEndereco = new javax.swing.JLabel();
        tfEndereco = new javax.swing.JTextField();
        jScrollPane2 = new javax.swing.JScrollPane();
        tabelaTelefone = new javax.swing.JTable();
        btnAdicionarTelefoneTabela = new javax.swing.JButton();
        btnExcluirTelefoneTabela = new javax.swing.JButton();
        tfTelefone = new javax.swing.JFormattedTextField();
        rbtFax = new javax.swing.JRadioButton();
        rbtCelular = new javax.swing.JRadioButton();
        rbtFixo = new javax.swing.JRadioButton();
        lbTitulo = new javax.swing.JLabel();
        btCadastrar = new javax.swing.JButton();
        btAlterar = new javax.swing.JButton();
        btVoltar = new javax.swing.JButton();
        btExcluir = new javax.swing.JButton();
        btSalvar = new javax.swing.JButton();
        btnConsultarTelefone = new javax.swing.JButton();

        dlgTelefones.setMinimumSize(new java.awt.Dimension(430, 270));

        tabelaConsultaTelefone.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {},
                {},
                {},
                {}
            },
            new String [] {

            }
        ));
        tabelaConsultaTelefone.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tabelaConsultaTelefoneMouseClicked(evt);
            }
        });
        jScrollPane3.setViewportView(tabelaConsultaTelefone);

        try {
            tfAlterarTelefone.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.MaskFormatter("(##)####-####")));
        } catch (java.text.ParseException ex) {
            ex.printStackTrace();
        }
        tfAlterarTelefone.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tfAlterarTelefoneActionPerformed(evt);
            }
        });

        btnGroupTipoTelefone.add(rbtAlterarFixo);
        rbtAlterarFixo.setText("Fixo");

        btnGroupTipoTelefone.add(rbtAlterarCelular);
        rbtAlterarCelular.setText("Celular");

        btnGroupTipoTelefone.add(rbtAlterarFax);
        rbtAlterarFax.setText("Fax");

        btnAlterarOk.setIcon(new javax.swing.ImageIcon(getClass().getResource("/br/com/sca/imagem/voltar_32x32.png"))); // NOI18N
        btnAlterarOk.setToolTipText("Voltar");
        btnAlterarOk.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAlterarOkActionPerformed(evt);
            }
        });

        btnAlterarTelefone.setIcon(new javax.swing.ImageIcon(getClass().getResource("/br/com/sca/imagem/editar_32x32.png"))); // NOI18N
        btnAlterarTelefone.setToolTipText("Editar Telefone");
        btnAlterarTelefone.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAlterarTelefoneActionPerformed(evt);
            }
        });

        btnSalvarTelefone.setIcon(new javax.swing.ImageIcon(getClass().getResource("/br/com/sca/imagem/apply32x32.png"))); // NOI18N
        btnSalvarTelefone.setToolTipText("Salvar Alterações");
        btnSalvarTelefone.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSalvarTelefoneActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout dlgTelefonesLayout = new javax.swing.GroupLayout(dlgTelefones.getContentPane());
        dlgTelefones.getContentPane().setLayout(dlgTelefonesLayout);
        dlgTelefonesLayout.setHorizontalGroup(
            dlgTelefonesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(dlgTelefonesLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(dlgTelefonesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(dlgTelefonesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                        .addComponent(jScrollPane3, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 375, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGroup(dlgTelefonesLayout.createSequentialGroup()
                            .addComponent(tfAlterarTelefone, javax.swing.GroupLayout.PREFERRED_SIZE, 99, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 130, Short.MAX_VALUE)
                            .addComponent(rbtAlterarFixo)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addComponent(rbtAlterarCelular)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addComponent(rbtAlterarFax)))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, dlgTelefonesLayout.createSequentialGroup()
                        .addComponent(btnAlterarOk)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 163, Short.MAX_VALUE)
                        .addComponent(btnSalvarTelefone)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(btnAlterarTelefone, javax.swing.GroupLayout.PREFERRED_SIZE, 73, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );
        dlgTelefonesLayout.setVerticalGroup(
            dlgTelefonesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(dlgTelefonesLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 123, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(dlgTelefonesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(tfAlterarTelefone, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(rbtAlterarFixo)
                    .addComponent(rbtAlterarCelular)
                    .addComponent(rbtAlterarFax))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(dlgTelefonesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btnAlterarTelefone)
                    .addComponent(btnAlterarOk)
                    .addComponent(btnSalvarTelefone))
                .addContainerGap())
        );

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Funcionário");
        setName("funcionario"); // NOI18N

        painelAbas.setEnabled(false);

        tabelaFornecedor.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tabelaFornecedorMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tabelaFornecedor);

        lbPesquisaNome.setText("Pesquisa por razão social:");

        tfPesquisaNome.setText("Digite a razão social do fornecedor");
        tfPesquisaNome.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                tfPesquisaNomeKeyPressed(evt);
            }
            public void keyReleased(java.awt.event.KeyEvent evt) {
                tfPesquisaNomeKeyReleased(evt);
            }
        });

        javax.swing.GroupLayout painelConsultaLayout = new javax.swing.GroupLayout(painelConsulta);
        painelConsulta.setLayout(painelConsultaLayout);
        painelConsultaLayout.setHorizontalGroup(
            painelConsultaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(painelConsultaLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(painelConsultaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 979, Short.MAX_VALUE)
                    .addGroup(painelConsultaLayout.createSequentialGroup()
                        .addComponent(lbPesquisaNome, javax.swing.GroupLayout.PREFERRED_SIZE, 158, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(tfPesquisaNome, javax.swing.GroupLayout.PREFERRED_SIZE, 273, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap(538, Short.MAX_VALUE))))
        );
        painelConsultaLayout.setVerticalGroup(
            painelConsultaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(painelConsultaLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(painelConsultaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lbPesquisaNome)
                    .addComponent(tfPesquisaNome, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 271, Short.MAX_VALUE))
        );

        painelAbas.addTab("Pesquisa", painelConsulta);

        lbCodigo.setText("Código:");

        lbRazaoSocial.setText("Razão Social:");

        lbDataCad.setText("Data de Cadastro:");

        tfCodigo.setEditable(false);

        tfRazaoSocial.setNextFocusableComponent(tfCpfCnpj);

        tfDataCad.setEditable(false);

        lblEmail.setText("Email:");

        tfEmail.setNextFocusableComponent(tfContato);

        tfCpfCnpj.setNextFocusableComponent(tfEndereco);

        lblCpfCnpj.setText("CPF/CNPJ:");

        tfContato.setNextFocusableComponent(tfTelefone);

        lblContato.setText("Contato:");

        lbTelefone.setText("Telefone:");

        lbEndereco.setText("Endereço:");

        tfEndereco.setNextFocusableComponent(tfEmail);

        tabelaTelefone.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {},
                {},
                {},
                {}
            },
            new String [] {

            }
        ));
        tabelaTelefone.setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
        jScrollPane2.setViewportView(tabelaTelefone);

        btnAdicionarTelefoneTabela.setIcon(new javax.swing.ImageIcon(getClass().getResource("/br/com/sca/imagem/incluir_32x32.png"))); // NOI18N
        btnAdicionarTelefoneTabela.setToolTipText("Incluir Telefone");
        btnAdicionarTelefoneTabela.setBorderPainted(false);
        btnAdicionarTelefoneTabela.setContentAreaFilled(false);
        btnAdicionarTelefoneTabela.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAdicionarTelefoneTabelaActionPerformed(evt);
            }
        });

        btnExcluirTelefoneTabela.setIcon(new javax.swing.ImageIcon(getClass().getResource("/br/com/sca/imagem/retirar_32x32.png"))); // NOI18N
        btnExcluirTelefoneTabela.setToolTipText("Retirar");
        btnExcluirTelefoneTabela.setBorderPainted(false);
        btnExcluirTelefoneTabela.setContentAreaFilled(false);
        btnExcluirTelefoneTabela.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnExcluirTelefoneTabelaActionPerformed(evt);
            }
        });

        try {
            tfTelefone.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.MaskFormatter("(##)####-####")));
        } catch (java.text.ParseException ex) {
            ex.printStackTrace();
        }
        tfTelefone.setNextFocusableComponent(rbtFixo);

        btnGroupTipoTelefone.add(rbtFax);
        rbtFax.setText("Fax");

        btnGroupTipoTelefone.add(rbtCelular);
        rbtCelular.setText("Celular");

        btnGroupTipoTelefone.add(rbtFixo);
        rbtFixo.setText("Fixo");

        javax.swing.GroupLayout painelComponentesCadastroLayout = new javax.swing.GroupLayout(painelComponentesCadastro);
        painelComponentesCadastro.setLayout(painelComponentesCadastroLayout);
        painelComponentesCadastroLayout.setHorizontalGroup(
            painelComponentesCadastroLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(painelComponentesCadastroLayout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addGroup(painelComponentesCadastroLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(lbCodigo)
                    .addComponent(lbRazaoSocial)
                    .addComponent(lbEndereco)
                    .addComponent(lblContato)
                    .addComponent(lblEmail)
                    .addComponent(lbTelefone)
                    .addComponent(lbDataCad))
                .addGap(18, 18, 18)
                .addGroup(painelComponentesCadastroLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(painelComponentesCadastroLayout.createSequentialGroup()
                        .addComponent(tfRazaoSocial, javax.swing.GroupLayout.PREFERRED_SIZE, 261, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(174, 174, 174)
                        .addComponent(lblCpfCnpj)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(tfCpfCnpj, javax.swing.GroupLayout.PREFERRED_SIZE, 215, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(tfCodigo, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(painelComponentesCadastroLayout.createSequentialGroup()
                        .addGroup(painelComponentesCadastroLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(tfContato, javax.swing.GroupLayout.PREFERRED_SIZE, 171, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(painelComponentesCadastroLayout.createSequentialGroup()
                                .addComponent(tfTelefone, javax.swing.GroupLayout.PREFERRED_SIZE, 107, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(rbtFixo)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(rbtCelular)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(rbtFax))
                            .addComponent(tfDataCad, javax.swing.GroupLayout.PREFERRED_SIZE, 152, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(105, 105, 105)
                        .addGroup(painelComponentesCadastroLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addComponent(btnExcluirTelefoneTabela, 0, 0, Short.MAX_VALUE)
                            .addComponent(btnAdicionarTelefoneTabela, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 406, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(tfEndereco, javax.swing.GroupLayout.PREFERRED_SIZE, 356, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(tfEmail, javax.swing.GroupLayout.PREFERRED_SIZE, 171, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(32, Short.MAX_VALUE))
        );
        painelComponentesCadastroLayout.setVerticalGroup(
            painelComponentesCadastroLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(painelComponentesCadastroLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(painelComponentesCadastroLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lbCodigo)
                    .addComponent(tfCodigo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(painelComponentesCadastroLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lbRazaoSocial)
                    .addComponent(tfRazaoSocial, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(tfCpfCnpj, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblCpfCnpj))
                .addGap(18, 18, 18)
                .addGroup(painelComponentesCadastroLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lbEndereco)
                    .addComponent(tfEndereco, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGroup(painelComponentesCadastroLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(painelComponentesCadastroLayout.createSequentialGroup()
                        .addGap(12, 12, 12)
                        .addComponent(tfEmail, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(painelComponentesCadastroLayout.createSequentialGroup()
                        .addGap(18, 18, 18)
                        .addComponent(lblEmail)))
                .addGap(17, 17, 17)
                .addGroup(painelComponentesCadastroLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(painelComponentesCadastroLayout.createSequentialGroup()
                        .addGroup(painelComponentesCadastroLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(tfContato, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(lblContato))
                        .addGap(36, 36, 36)
                        .addGroup(painelComponentesCadastroLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(lbTelefone)
                            .addGroup(painelComponentesCadastroLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(tfTelefone, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(rbtFixo)
                                .addComponent(rbtCelular)
                                .addComponent(rbtFax)))
                        .addGap(18, 18, 18)
                        .addGroup(painelComponentesCadastroLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(tfDataCad, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(lbDataCad)))
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 123, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(30, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, painelComponentesCadastroLayout.createSequentialGroup()
                .addContainerGap(164, Short.MAX_VALUE)
                .addComponent(btnAdicionarTelefoneTabela)
                .addGap(18, 18, 18)
                .addComponent(btnExcluirTelefoneTabela)
                .addGap(45, 45, 45))
        );

        javax.swing.GroupLayout painelCadastroLayout = new javax.swing.GroupLayout(painelCadastro);
        painelCadastro.setLayout(painelCadastroLayout);
        painelCadastroLayout.setHorizontalGroup(
            painelCadastroLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(painelCadastroLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(painelComponentesCadastro, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        painelCadastroLayout.setVerticalGroup(
            painelCadastroLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(painelCadastroLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(painelComponentesCadastro, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        painelAbas.addTab("Cadastro", painelCadastro);

        lbTitulo.setFont(new java.awt.Font("Times New Roman", 0, 24));
        lbTitulo.setText("FORNECEDOR");

        btCadastrar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/br/com/sca/imagem/novo_32x32.png"))); // NOI18N
        btCadastrar.setToolTipText("Cadastrar Fornecedor");
        btCadastrar.setBorderPainted(false);
        btCadastrar.setContentAreaFilled(false);
        btCadastrar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btCadastrarActionPerformed(evt);
            }
        });

        btAlterar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/br/com/sca/imagem/editar_32x32.png"))); // NOI18N
        btAlterar.setToolTipText("Alterar Fornecedor");
        btAlterar.setBorderPainted(false);
        btAlterar.setContentAreaFilled(false);
        btAlterar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btAlterarActionPerformed(evt);
            }
        });

        btVoltar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/br/com/sca/imagem/voltar_32x32.png"))); // NOI18N
        btVoltar.setToolTipText("Voltar");
        btVoltar.setBorderPainted(false);
        btVoltar.setContentAreaFilled(false);
        btVoltar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btVoltarActionPerformed(evt);
            }
        });

        btExcluir.setIcon(new javax.swing.ImageIcon(getClass().getResource("/br/com/sca/imagem/delete_32x32.png"))); // NOI18N
        btExcluir.setToolTipText("Excluir Fornecedor");
        btExcluir.setBorderPainted(false);
        btExcluir.setContentAreaFilled(false);
        btExcluir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btExcluirActionPerformed(evt);
            }
        });

        btSalvar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/br/com/sca/imagem/salvar_32x32.png"))); // NOI18N
        btSalvar.setToolTipText("Salvar");
        btSalvar.setBorderPainted(false);
        btSalvar.setContentAreaFilled(false);
        btSalvar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btSalvarActionPerformed(evt);
            }
        });

        btnConsultarTelefone.setIcon(new javax.swing.ImageIcon(getClass().getResource("/br/com/sca/imagem/lupa_32x32.png"))); // NOI18N
        btnConsultarTelefone.setText("Consultar Telefone");
        btnConsultarTelefone.setToolTipText("Consultar Telefone");
        btnConsultarTelefone.setContentAreaFilled(false);
        btnConsultarTelefone.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnConsultarTelefoneActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(400, 400, 400)
                        .addComponent(lbTitulo))
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(btCadastrar)
                        .addGap(18, 18, 18)
                        .addComponent(btAlterar)
                        .addGap(18, 18, 18)
                        .addComponent(btExcluir)
                        .addGap(18, 18, 18)
                        .addComponent(btVoltar)
                        .addGap(72, 72, 72)
                        .addComponent(btSalvar)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 384, Short.MAX_VALUE)
                        .addComponent(btnConsultarTelefone))
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(painelAbas, javax.swing.GroupLayout.DEFAULT_SIZE, 994, Short.MAX_VALUE)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(lbTitulo)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(painelAbas, javax.swing.GroupLayout.DEFAULT_SIZE, 348, Short.MAX_VALUE)
                .addGap(15, 15, 15)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addComponent(btSalvar, 0, 0, Short.MAX_VALUE)
                    .addComponent(btVoltar, 0, 0, Short.MAX_VALUE)
                    .addComponent(btExcluir, 0, 0, Short.MAX_VALUE)
                    .addComponent(btAlterar, 0, 0, Short.MAX_VALUE)
                    .addComponent(btCadastrar, javax.swing.GroupLayout.PREFERRED_SIZE, 32, Short.MAX_VALUE)
                    .addComponent(btnConsultarTelefone))
                .addGap(20, 20, 20))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btCadastrarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btCadastrarActionPerformed
        fornecedor = new Fornecedor();
        tabelaTelefone.setModel(new ModelTabelaTelefone(new ArrayList<Telefone>()));
        limparFormulario();
        esquemaCadastro();
        // chama a aba de cadatro no painel
        painelAbas.setSelectedIndex(1);
    }//GEN-LAST:event_btCadastrarActionPerformed

    private void btAlterarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btAlterarActionPerformed
        //preenche os campos de cadastro com os dados do funcionário selecionado na tabela
        fornecedor = controller.retornarFornecedorIndex(tabelaFornecedor.getSelectedRow());
        tfCodigo.setText(fornecedor.getIdFornec().toString());
        tfRazaoSocial.setText(fornecedor.getRzSocFornec());
        tfCpfCnpj.setText(fornecedor.getCpfCnpjFornec());
        tfEndereco.setText(fornecedor.getEndFornec());
        tfEmail.setText(fornecedor.getEmailFornec());
        tfContato.setText(fornecedor.getContatoFornec());
        tabelaTelefone.setModel(new ModelTabelaTelefone(fornecedor.getTelefoneList()));        
        tfDataCad.setText(new SimpleDateFormat("E dd/MM/yyyy HH:mm:ss").format(fornecedor.getDtCadFornec()));
        esquemaCadastro();
        // chama a aba de cadatro no painel
        painelAbas.setSelectedIndex(1);
    }//GEN-LAST:event_btAlterarActionPerformed

    private void btExcluirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btExcluirActionPerformed
        //pede a confirmação da exclusão
        int confirmacao = JOptionPane.showConfirmDialog(rootPane, "Este fornecedor será excluído permanentemente. Confirma a ação?");
        if (confirmacao == 0) {
            fornecedor = controller.retornarFornecedorIndex(tabelaFornecedor.getSelectedRow());
            int resultado = controller.excluir(dao, fornecedor);
            // se a exclusão foi realizada com sucesso, exibe mensagem
            if (resultado == Dao.SUCESSO) {
                JOptionPane.showMessageDialog(rootPane, "Exclusão realizada com sucesso!");
                inicializar();
                limparPesquisa();
                // se o método excluir retorna o ERRO_1451, é porque o MySql lançou esse erro, o que significa que
                // um registro associado não permite a exclusão desse objeto. No caso do funcionário, quando esse erro
                // é lançado é porque há um almoxarife que é o funcionário que o usuário tentou excluir, e o banco não permitiu.
            } else if (resultado == Dao.ERRO_1451) {
                JOptionPane.showMessageDialog(rootPane, "Esse fornecedor não pode ser excluído pois ele contém requisições ou compras cadastradas!");
            } else {
                JOptionPane.showMessageDialog(rootPane, "Falha durante a exclusão");
            }
        } else if (confirmacao == 1) {
            inicializar();
            limparPesquisa();
        }
    }//GEN-LAST:event_btExcluirActionPerformed

    private void btVoltarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btVoltarActionPerformed
        esquemaConsulta();
        //exibe aba consulta
        painelAbas.setSelectedIndex(0);
    }//GEN-LAST:event_btVoltarActionPerformed

    private void tfPesquisaNomeKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_tfPesquisaNomeKeyPressed
        //limpa o campo de pesquisa quando o usuario tecla dentro do campo
        if (tfPesquisaNome.getText().equals("Digite a razão social do fornecedor")) {
            tfPesquisaNome.setText("");
        }
    }//GEN-LAST:event_tfPesquisaNomeKeyPressed
    /*
     * método que refaz a tabela sempre que o usuário tecla no campo de pesquisa
     */
    private void tfPesquisaNomeKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_tfPesquisaNomeKeyReleased
        tabelaFornecedor.setModel(controller.preencherTabelaParametroNome(dao, tfPesquisaNome.getText()));
        esquemaConsulta();
    }//GEN-LAST:event_tfPesquisaNomeKeyReleased
    /*
     * método que faz o objeto funcionário receber o funcionário selecionado na tabela, sempre
     * que o usuário clica com o mouse na tabela
     */
    private void tabelaFornecedorMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tabelaFornecedorMouseClicked
        esquemaConsultaSelecao();
    }//GEN-LAST:event_tabelaFornecedorMouseClicked

    private void btSalvarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btSalvarActionPerformed
        // verifica se todos os campos obrigatórios estão preenchidos
        if (tfRazaoSocial.getText().equals("")) {
            JOptionPane.showMessageDialog(null, "A razão social do fornecedor é obrigatório!");
        } else if (tfCpfCnpj.getText().equals("")) {
            JOptionPane.showMessageDialog(null, "O CPF/CNPJ do fornecedor é obrigatório!");
        } else if (tfEndereco.getText().equals("")) {
            JOptionPane.showMessageDialog(null, "O Endereço do fornecedor é obrigatório!");             
        } else if (tfEmail.getText().equals("")) {
            JOptionPane.showMessageDialog(null, "O Email do fornecedor é obrigatório!");
        } else if (tfContato.getText().equals("")) {
            JOptionPane.showMessageDialog(null, "O Contato do fornecedor é obrigatório!");
        } else if (tabelaTelefone.getModel().getRowCount() == 0) {
            JOptionPane.showMessageDialog(null, "O Telefone do fornecedor é obrigatório!");
        }

        else {
            fornecedor.setRzSocFornec(tfRazaoSocial.getText());
            fornecedor.setCpfCnpjFornec(tfCpfCnpj.getText());
            fornecedor.setEndFornec(tfEndereco.getText());
            fornecedor.setEmailFornec(tfEmail.getText());
            fornecedor.setContatoFornec(tfContato.getText());            
            // se a chave primária do objeto é nula, é um novo registro. Nesse caso, pega a data do sistema
            // e seta no funcionário.
            if (fornecedor.getIdFornec() == null) {
                Date data = new Date(System.currentTimeMillis());
                fornecedor.setDtCadFornec(data);
            }
            if (controller.gravar(dao, fornecedor) == Dao.SUCESSO) {
                JOptionPane.showMessageDialog(null, "Fornecedor gravado com sucesso!");
            } else {
                JOptionPane.showMessageDialog(null, "Erro durante a operação!");
            }
            inicializar();
            // exibe aba de cadastro
            painelAbas.setSelectedIndex(0);
            limparPesquisa();
        }
    }//GEN-LAST:event_btSalvarActionPerformed

    private void btnAdicionarTelefoneTabelaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAdicionarTelefoneTabelaActionPerformed
        Telefone telefone = new Telefone();
        if(tfTelefone.getText().equals("(  )    -    ")){
            JOptionPane.showMessageDialog(null, "Digite o Numero do Telefone");
        } else if(!(rbtCelular.isSelected() || rbtFax.isSelected() || rbtFixo.isSelected())){
            JOptionPane.showMessageDialog(null, "Selecione um tipo de telefone");
        } else{
            if(rbtCelular.isSelected()){
               telefone.setTipoTelefone("Celular");
            } else if(rbtFixo.isSelected()){
               telefone.setTipoTelefone("Fixo");
            } else if(rbtFax.isSelected()){
                telefone.setTipoTelefone("Fax");
            }

            telefone.setNumeroTelefone(tfTelefone.getText());
            telefone.setFornecedor(fornecedor);
            if(fornecedor.getTelefoneList() == null){
                fornecedor.setTelefoneList(new ArrayList<Telefone>());
            }
            fornecedor.getTelefoneList().add(telefone);
            tabelaTelefone.setModel(new ModelTabelaTelefone(fornecedor.getTelefoneList()));
            tfTelefone.setText("");
        }
    }//GEN-LAST:event_btnAdicionarTelefoneTabelaActionPerformed

    private void btnExcluirTelefoneTabelaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnExcluirTelefoneTabelaActionPerformed
        if(tabelaTelefone.getSelectedRow() == -1){
            JOptionPane.showMessageDialog(null, "Selecione um telefone a ser excluido");
        } else{
            //ModelTabelaTelefone modeloTabelaTelefone = (ModelTabelaTelefone) tabelaTelefone.getModel();
            fornecedor.getTelefoneList().remove(tabelaTelefone.getSelectedRow());
            tabelaTelefone.setModel( new ModelTabelaTelefone(fornecedor.getTelefoneList()));
            tfTelefone.setText("");
        }        
    }//GEN-LAST:event_btnExcluirTelefoneTabelaActionPerformed

    private void btnConsultarTelefoneActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnConsultarTelefoneActionPerformed
        btnAlterarTelefone.setEnabled(false);
        fornecedor = controller.retornarFornecedorIndex(tabelaFornecedor.getSelectedRow());
        tabelaConsultaTelefone.setModel(new ModelTabelaTelefone(fornecedor.getTelefoneList()));
        dlgTelefones.setVisible(true);
        tfAlterarTelefone.setText("");
        rbtAlterarCelular.setSelected(false);
        rbtAlterarFax.setSelected(false);
        rbtAlterarFixo.setSelected(false);
    }//GEN-LAST:event_btnConsultarTelefoneActionPerformed

    private void btnAlterarTelefoneActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAlterarTelefoneActionPerformed
        controllerTelefone = new TelefoneController();
        telefone = controllerTelefone.retornarTelefoneIndex(tabelaConsultaTelefone.getSelectedRow(), (ModelTabelaTelefone) tabelaConsultaTelefone.getModel());
        tfAlterarTelefone.setText(telefone.getNumeroTelefone());
        if(telefone.getTipoTelefone().equals("Celular")){
            rbtAlterarCelular.setSelected(true);
        } else if(telefone.getTipoTelefone().equals("Fixo")){
            rbtAlterarFixo.setSelected(true);
        }else if(telefone.getTipoTelefone().equals("Fax")){
            rbtAlterarFax.setSelected(true);
        }
    }//GEN-LAST:event_btnAlterarTelefoneActionPerformed

    private void tfAlterarTelefoneActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tfAlterarTelefoneActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_tfAlterarTelefoneActionPerformed

    private void btnAlterarOkActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAlterarOkActionPerformed
        dlgTelefones.dispose();
    }//GEN-LAST:event_btnAlterarOkActionPerformed

    private void tabelaConsultaTelefoneMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tabelaConsultaTelefoneMouseClicked
        btnAlterarTelefone.setEnabled(true);
    }//GEN-LAST:event_tabelaConsultaTelefoneMouseClicked

    private void btnSalvarTelefoneActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSalvarTelefoneActionPerformed
        if(!(tfAlterarTelefone.getText().equals("(  )    -    "))){
            telefone.setNumeroTelefone(tfAlterarTelefone.getText());
        }else{
            JOptionPane.showMessageDialog(null, "O numero do telefone é obrigatório");
        }

        if(!(rbtAlterarCelular.isSelected() || rbtAlterarFax.isSelected() || rbtAlterarFixo.isSelected())){
            JOptionPane.showMessageDialog(null, "Selecione um tipo de telefone");
        } else{
            if(rbtAlterarCelular.isSelected()){
               telefone.setTipoTelefone("Celular");
            } else if(rbtAlterarFixo.isSelected()){
               telefone.setTipoTelefone("Fixo");
            } else if(rbtAlterarFax.isSelected()){
                telefone.setTipoTelefone("Fax");
            }
        }
        dao.gravar(telefone);
        dlgTelefones.dispose();
    }//GEN-LAST:event_btnSalvarTelefoneActionPerformed
    
    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        java.awt.EventQueue.invokeLater(new Runnable() {

            public void run() {
                new TelaFornecedorTelefone().setVisible(true);
            }
        });
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btAlterar;
    private javax.swing.JButton btCadastrar;
    private javax.swing.JButton btExcluir;
    private javax.swing.JButton btSalvar;
    private javax.swing.JButton btVoltar;
    private javax.swing.JButton btnAdicionarTelefoneTabela;
    private javax.swing.JButton btnAlterarOk;
    private javax.swing.JButton btnAlterarTelefone;
    private javax.swing.JButton btnConsultarTelefone;
    private javax.swing.JButton btnExcluirTelefoneTabela;
    private javax.swing.ButtonGroup btnGroupTipoTelefone;
    private javax.swing.JButton btnSalvarTelefone;
    private javax.swing.JDialog dlgTelefones;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JLabel lbCodigo;
    private javax.swing.JLabel lbDataCad;
    private javax.swing.JLabel lbEndereco;
    private javax.swing.JLabel lbPesquisaNome;
    private javax.swing.JLabel lbRazaoSocial;
    private javax.swing.JLabel lbTelefone;
    private javax.swing.JLabel lbTitulo;
    private javax.swing.JLabel lblContato;
    private javax.swing.JLabel lblCpfCnpj;
    private javax.swing.JLabel lblEmail;
    private javax.swing.JTabbedPane painelAbas;
    private javax.swing.JPanel painelCadastro;
    private javax.swing.JPanel painelComponentesCadastro;
    private javax.swing.JPanel painelConsulta;
    private javax.swing.JRadioButton rbtAlterarCelular;
    private javax.swing.JRadioButton rbtAlterarFax;
    private javax.swing.JRadioButton rbtAlterarFixo;
    private javax.swing.JRadioButton rbtCelular;
    private javax.swing.JRadioButton rbtFax;
    private javax.swing.JRadioButton rbtFixo;
    private javax.swing.JTable tabelaConsultaTelefone;
    private javax.swing.JTable tabelaFornecedor;
    private javax.swing.JTable tabelaTelefone;
    private javax.swing.JFormattedTextField tfAlterarTelefone;
    private javax.swing.JTextField tfCodigo;
    private javax.swing.JTextField tfContato;
    private javax.swing.JTextField tfCpfCnpj;
    private javax.swing.JTextField tfDataCad;
    private javax.swing.JTextField tfEmail;
    private javax.swing.JTextField tfEndereco;
    private javax.swing.JTextField tfPesquisaNome;
    private javax.swing.JTextField tfRazaoSocial;
    private javax.swing.JFormattedTextField tfTelefone;
    // End of variables declaration//GEN-END:variables
}
