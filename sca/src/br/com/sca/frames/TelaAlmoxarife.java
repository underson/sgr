 /*
 * TelaFuncionario.java
 *
 * Created on 21/04/2012, 11:40:46
 */
package br.com.sca.frames;

import br.com.sca.controller.AlmoxarifeController;
import br.com.sca.controller.FuncionarioController;
import br.com.sca.entidades.Almoxarife;
import br.com.sca.entidades.Funcionario;
import br.com.sca.persistencia.Dao;
import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Date;
import javax.swing.JOptionPane;

/**
 *
 * @author
 * @since 
 * @version 1.0
 */
public class TelaAlmoxarife extends javax.swing.JFrame {

    private AlmoxarifeController controller;
    private Almoxarife almoxarife;
    private Dao dao;
    private FuncionarioController controller2;
    private Funcionario funcionario;
    public boolean salvar = true;
    private Almoxarife alm;

    public TelaAlmoxarife() {
        initComponents();
        dao = new Dao();
        inicializar();
    }
    
    public TelaAlmoxarife(Almoxarife alm) {
        this.alm = new Almoxarife();
        this.alm = alm;
        initComponents();
        dao = new Dao();
        inicializar();
    }
    /*
     * método para instanciar entidade e controller e preencher a tabela
     */

    private void inicializar() {
        painelFuncionario.setVisible(false);
        controller = new AlmoxarifeController();
        tabelaAlmoxarife.setModel(controller.retornaModelTabelaCompleta(dao));
        almoxarife = new Almoxarife();
        esquemaConsulta();
        limparFormulario();
        controller2 = new FuncionarioController();
        tabelaFuncionario.setModel(controller2.retornaModelTabelaCompletaSemAlmoxarife(dao));
        funcionario = new Funcionario();
    }
    /*
     * método para limpar os campos de cadastro
     */

    private void limparFormulario() {
        tfCodigo.setText("");
        tfCpf.setText("");
        tfNome.setText("");
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
    }
    /*
     * método para deixar os botões de ação na configuração da aba de cadastro
     */

    private void esquemaCadastro() {
        tabelaAlmoxarife.clearSelection();
        btCadastrar.setEnabled(false);
        btAlterar.setEnabled(false);
        btExcluir.setEnabled(false);
        btVoltar.setVisible(true);
        btSalvar.setVisible(true);
    }

    private void limparPesquisa() {
        tfPesquisaNome.setText("");
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        btGroupTipoAlmoxarife = new javax.swing.ButtonGroup();
        btGroupAtivo = new javax.swing.ButtonGroup();
        painelAbas = new javax.swing.JTabbedPane();
        painelConsulta = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tabelaAlmoxarife = new javax.swing.JTable();
        lbPesquisaNome = new javax.swing.JLabel();
        tfPesquisaNome = new javax.swing.JTextField();
        painelCadastro = new javax.swing.JPanel();
        painelComponentesCadastro = new javax.swing.JPanel();
        lbCodigo = new javax.swing.JLabel();
        lbCpf = new javax.swing.JLabel();
        lbNome = new javax.swing.JLabel();
        lbDataCad = new javax.swing.JLabel();
        tfCodigo = new javax.swing.JTextField();
        tfNome = new javax.swing.JTextField();
        tfDataCad = new javax.swing.JTextField();
        tfLogin = new javax.swing.JTextField();
        lbLogin = new javax.swing.JLabel();
        lbSenha = new javax.swing.JLabel();
        lbTipo = new javax.swing.JLabel();
        rbAlmoxarife = new javax.swing.JRadioButton();
        rbSupervisor = new javax.swing.JRadioButton();
        btLocalizar = new javax.swing.JButton();
        tfSenha_confirm = new javax.swing.JPasswordField();
        painelFuncionario = new javax.swing.JPanel();
        tfPesquisaNome1 = new javax.swing.JTextField();
        lbPesquisaNome1 = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        tabelaFuncionario = new javax.swing.JTable();
        btSelecionar = new javax.swing.JButton();
        lbTipo1 = new javax.swing.JLabel();
        rbAtivo = new javax.swing.JRadioButton();
        rbInativo = new javax.swing.JRadioButton();
        tfSenha = new javax.swing.JPasswordField();
        lbSenha1 = new javax.swing.JLabel();
        tfCpf = new javax.swing.JFormattedTextField();
        lbTitulo = new javax.swing.JLabel();
        btCadastrar = new javax.swing.JButton();
        btAlterar = new javax.swing.JButton();
        btVoltar = new javax.swing.JButton();
        btExcluir = new javax.swing.JButton();
        btSalvar = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Funcionário");
        setName("funcionario"); // NOI18N

        painelAbas.setEnabled(false);

        tabelaAlmoxarife.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tabelaAlmoxarifeMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tabelaAlmoxarife);

        lbPesquisaNome.setText("Pesquisa por nome:");

        tfPesquisaNome.setText("Digite o nome do almoxarife");
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
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 976, Short.MAX_VALUE)
                    .addGroup(painelConsultaLayout.createSequentialGroup()
                        .addComponent(lbPesquisaNome, javax.swing.GroupLayout.PREFERRED_SIZE, 126, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(tfPesquisaNome, javax.swing.GroupLayout.PREFERRED_SIZE, 273, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );
        painelConsultaLayout.setVerticalGroup(
            painelConsultaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(painelConsultaLayout.createSequentialGroup()
                .addGap(32, 32, 32)
                .addGroup(painelConsultaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lbPesquisaNome)
                    .addComponent(tfPesquisaNome, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 308, Short.MAX_VALUE)
                .addContainerGap())
        );

        painelAbas.addTab("Pesquisa", painelConsulta);

        lbCodigo.setText("Código do Funcionário:");

        lbCpf.setText("Cpf do Funcionário:");

        lbNome.setText("Nome do Funcionário:");

        lbDataCad.setText("Data de Cadastro do Funcionário:");

        tfCodigo.setEditable(false);

        tfNome.setEditable(false);

        tfDataCad.setEditable(false);

        tfLogin.setEnabled(false);
        tfLogin.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tfLoginActionPerformed(evt);
            }
        });

        lbLogin.setText("Login do Almoxarife:");

        lbSenha.setText("Senha do Almoxarife:");

        lbTipo.setText("Tipo de Almoxarife:");

        btGroupTipoAlmoxarife.add(rbAlmoxarife);
        rbAlmoxarife.setText("Almoxarife");
        rbAlmoxarife.setEnabled(false);

        btGroupTipoAlmoxarife.add(rbSupervisor);
        rbSupervisor.setText("Almoxarife Supervisor");
        rbSupervisor.setEnabled(false);

        btLocalizar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/br/com/sca/imagem/lupa_16x16.png"))); // NOI18N
        btLocalizar.setText("Localizar Funcionário");
        btLocalizar.setToolTipText("Localizar");
        btLocalizar.setContentAreaFilled(false);
        btLocalizar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btLocalizarActionPerformed(evt);
            }
        });

        tfSenha_confirm.setEnabled(false);

        tfPesquisaNome1.setText("Digite o nome do funcionário");
        tfPesquisaNome1.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                tfPesquisaNome1KeyPressed(evt);
            }
            public void keyReleased(java.awt.event.KeyEvent evt) {
                tfPesquisaNome1KeyReleased(evt);
            }
        });

        lbPesquisaNome1.setText("Pesquisa por nome:");

        tabelaFuncionario.setToolTipText("");
        tabelaFuncionario.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tabelaFuncionarioMouseClicked(evt);
            }
        });
        jScrollPane2.setViewportView(tabelaFuncionario);

        btSelecionar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/br/com/sca/imagem/apply32x32.png"))); // NOI18N
        btSelecionar.setToolTipText("Selecionar");
        btSelecionar.setBorderPainted(false);
        btSelecionar.setContentAreaFilled(false);
        btSelecionar.setEnabled(false);
        btSelecionar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btSelecionarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout painelFuncionarioLayout = new javax.swing.GroupLayout(painelFuncionario);
        painelFuncionario.setLayout(painelFuncionarioLayout);
        painelFuncionarioLayout.setHorizontalGroup(
            painelFuncionarioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(painelFuncionarioLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(painelFuncionarioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 486, Short.MAX_VALUE)
                    .addGroup(painelFuncionarioLayout.createSequentialGroup()
                        .addComponent(lbPesquisaNome1, javax.swing.GroupLayout.PREFERRED_SIZE, 126, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(tfPesquisaNome1, javax.swing.GroupLayout.PREFERRED_SIZE, 273, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(btSelecionar, javax.swing.GroupLayout.PREFERRED_SIZE, 47, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );
        painelFuncionarioLayout.setVerticalGroup(
            painelFuncionarioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(painelFuncionarioLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(painelFuncionarioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lbPesquisaNome1)
                    .addComponent(tfPesquisaNome1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 285, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btSelecionar)
                .addContainerGap(24, Short.MAX_VALUE))
        );

        lbTipo1.setText("Situação:");

        btGroupAtivo.add(rbAtivo);
        rbAtivo.setSelected(true);
        rbAtivo.setText("Ativo");
        rbAtivo.setEnabled(false);

        btGroupAtivo.add(rbInativo);
        rbInativo.setText("Inativo");
        rbInativo.setEnabled(false);

        tfSenha.setEnabled(false);

        lbSenha1.setText("Senha do Almoxarife (confirmação):");

        try {
            tfCpf.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.MaskFormatter("###.###.###-##")));
        } catch (java.text.ParseException ex) {
            ex.printStackTrace();
        }
        tfCpf.setEnabled(false);

        javax.swing.GroupLayout painelComponentesCadastroLayout = new javax.swing.GroupLayout(painelComponentesCadastro);
        painelComponentesCadastro.setLayout(painelComponentesCadastroLayout);
        painelComponentesCadastroLayout.setHorizontalGroup(
            painelComponentesCadastroLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, painelComponentesCadastroLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(painelComponentesCadastroLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(lbNome)
                    .addComponent(lbCodigo)
                    .addComponent(lbCpf)
                    .addComponent(lbDataCad)
                    .addComponent(lbLogin)
                    .addComponent(lbSenha)
                    .addComponent(lbSenha1)
                    .addComponent(lbTipo)
                    .addComponent(lbTipo1))
                .addGap(18, 18, 18)
                .addGroup(painelComponentesCadastroLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(painelComponentesCadastroLayout.createSequentialGroup()
                        .addComponent(tfCodigo, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(btLocalizar))
                    .addComponent(tfNome, javax.swing.GroupLayout.PREFERRED_SIZE, 261, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(painelComponentesCadastroLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                        .addComponent(tfLogin, javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(tfSenha, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 279, Short.MAX_VALUE)
                        .addGroup(javax.swing.GroupLayout.Alignment.LEADING, painelComponentesCadastroLayout.createSequentialGroup()
                            .addGroup(painelComponentesCadastroLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(rbAlmoxarife)
                                .addComponent(rbAtivo))
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                            .addGroup(painelComponentesCadastroLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(rbInativo)
                                .addComponent(rbSupervisor)))
                        .addComponent(tfSenha_confirm, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 279, Short.MAX_VALUE))
                    .addGroup(painelComponentesCadastroLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                        .addComponent(tfDataCad, javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(tfCpf, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 155, Short.MAX_VALUE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(painelFuncionario, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        painelComponentesCadastroLayout.setVerticalGroup(
            painelComponentesCadastroLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(painelComponentesCadastroLayout.createSequentialGroup()
                .addGroup(painelComponentesCadastroLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(painelFuncionario, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(painelComponentesCadastroLayout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(painelComponentesCadastroLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(lbCodigo)
                            .addComponent(tfCodigo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btLocalizar, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(painelComponentesCadastroLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(lbNome)
                            .addComponent(tfNome, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(painelComponentesCadastroLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(lbCpf)
                            .addComponent(tfCpf, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(painelComponentesCadastroLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(tfDataCad, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(lbDataCad))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(painelComponentesCadastroLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(tfLogin, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(lbLogin))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(painelComponentesCadastroLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(tfSenha, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(lbSenha))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(painelComponentesCadastroLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(tfSenha_confirm, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(lbSenha1))
                        .addGap(10, 10, 10)
                        .addGroup(painelComponentesCadastroLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(rbAlmoxarife)
                            .addComponent(rbSupervisor)
                            .addComponent(lbTipo))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(painelComponentesCadastroLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(rbInativo)
                            .addComponent(lbTipo1)
                            .addComponent(rbAtivo))))
                .addContainerGap())
        );

        javax.swing.GroupLayout painelCadastroLayout = new javax.swing.GroupLayout(painelCadastro);
        painelCadastro.setLayout(painelCadastroLayout);
        painelCadastroLayout.setHorizontalGroup(
            painelCadastroLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(painelCadastroLayout.createSequentialGroup()
                .addComponent(painelComponentesCadastro, javax.swing.GroupLayout.DEFAULT_SIZE, 986, Short.MAX_VALUE)
                .addContainerGap())
        );
        painelCadastroLayout.setVerticalGroup(
            painelCadastroLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(painelCadastroLayout.createSequentialGroup()
                .addComponent(painelComponentesCadastro, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        painelAbas.addTab("Cadastro", painelCadastro);

        lbTitulo.setFont(new java.awt.Font("Arial", 0, 24));
        lbTitulo.setText("ALMOXARIFE");

        btCadastrar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/br/com/sca/imagem/novo_32x32.png"))); // NOI18N
        btCadastrar.setToolTipText("Cadastrar Almoxarife");
        btCadastrar.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));
        btCadastrar.setBorderPainted(false);
        btCadastrar.setContentAreaFilled(false);
        btCadastrar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btCadastrarActionPerformed(evt);
            }
        });

        btAlterar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/br/com/sca/imagem/editar_32x32.png"))); // NOI18N
        btAlterar.setToolTipText("Editar Almoxarife");
        btAlterar.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));
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
        btExcluir.setToolTipText("Deletar Almoxarife");
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

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(btCadastrar, javax.swing.GroupLayout.PREFERRED_SIZE, 48, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(btAlterar, javax.swing.GroupLayout.PREFERRED_SIZE, 52, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(btExcluir)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(btVoltar, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(76, 76, 76)
                        .addComponent(btSalvar))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(400, 400, 400)
                        .addComponent(lbTitulo))
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(painelAbas, javax.swing.GroupLayout.DEFAULT_SIZE, 1001, Short.MAX_VALUE)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(lbTitulo)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(painelAbas, javax.swing.GroupLayout.PREFERRED_SIZE, 405, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 12, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addComponent(btSalvar, 0, 0, Short.MAX_VALUE)
                    .addComponent(btVoltar, javax.swing.GroupLayout.Alignment.LEADING, 0, 0, Short.MAX_VALUE)
                    .addComponent(btCadastrar, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btAlterar, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btExcluir, javax.swing.GroupLayout.Alignment.LEADING, 0, 0, Short.MAX_VALUE))
                .addGap(17, 17, 17))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btCadastrarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btCadastrarActionPerformed
//        limparFormulario();
        esquemaCadastro();

        tfLogin.setEnabled(false);
        tfLogin.setText(null);
        tfSenha.setEnabled(false);
        tfSenha.setText(null);
        tfSenha_confirm.setEnabled(false);
        tfSenha_confirm.setText(null);
        rbAlmoxarife.setEnabled(false);
        rbAlmoxarife.setSelected(false);
        rbSupervisor.setEnabled(false);
        rbSupervisor.setSelected(false);
        rbAtivo.setEnabled(false);
        rbAtivo.setSelected(false);
        rbInativo.setEnabled(false);
        rbInativo.setSelected(false);

        btSelecionar.setVisible(true);
        btSelecionar.setEnabled(false);
        btLocalizar.setEnabled(true);
        btLocalizar.setVisible(true);
        painelFuncionario.setVisible(false);



        // chama a aba de cadatro no painel
        painelAbas.setSelectedIndex(1);
        /*
         *
         *
         * Errado na versão 1.0
         *
         */
        almoxarife = new Almoxarife();
        /*
         *
         *
         * Errado na versão 1.0
         *
         */
    }//GEN-LAST:event_btCadastrarActionPerformed

    private void btAlterarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btAlterarActionPerformed
        //preenche os campos de cadastro com os dados do funcionário selecionado na tabela
        almoxarife = controller.retornarAlmoxarifeIndex(tabelaAlmoxarife.getSelectedRow());
        funcionario = almoxarife.getFuncionario();
        tfCodigo.setText(almoxarife.getFuncionario().getIdFunc().toString());
        tfCpf.setText(almoxarife.getFuncionario().getCpfFunc());
        tfNome.setText(almoxarife.getFuncionario().getNomeFunc());
        tfDataCad.setText(new SimpleDateFormat("E dd/MM/yyyy HH:mm:ss").format(almoxarife.getFuncionario().getDtCadFunc()));
        esquemaCadastro();
        tfLogin.setText(almoxarife.getLoginAlmoxarife());
        tfSenha.setText(almoxarife.getSenhaAlmoxarife());
        tfSenha_confirm.setText(almoxarife.getSenhaAlmoxarife());
        if (almoxarife.getSupervisorAlmoxarife() == false) {
            rbAlmoxarife.setSelected(true);
        } else {
            rbSupervisor.setSelected(true);
        }
        // chama a aba de cadatro no painel
        btLocalizar.setVisible(false);

        tfLogin.setEnabled(true);
        tfSenha.setEnabled(true);
        tfSenha_confirm.setEnabled(true);
        rbAlmoxarife.setEnabled(true);
        rbSupervisor.setEnabled(true);
        rbAtivo.setEnabled(true);
        rbInativo.setEnabled(true);

        if (almoxarife.getAtivoAlmoxarife() == true) {
            rbAtivo.setSelected(true);
        } else {
            rbInativo.setSelected(true);
        }

        int controle = controller.quantidadeAlmoxarifeSupervisor(dao);
        if (controle <= 1 && almoxarife.getSupervisorAlmoxarife() == true && almoxarife.getAtivoAlmoxarife() == true) {
            rbInativo.setEnabled(false);
            rbAlmoxarife.setEnabled(false);
        }

        painelAbas.setSelectedIndex(1);
    }//GEN-LAST:event_btAlterarActionPerformed

    private void btExcluirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btExcluirActionPerformed
        //pede a confirmação da exclusão
        int confirmacao = JOptionPane.showConfirmDialog(rootPane, "Este almoxarife será excluído permanentemente. Confirma a ação?");
        if (confirmacao == 0) {
            boolean excluir = true;
            int controle = controller.quantidadeAlmoxarifeSupervisor(dao);
            almoxarife = controller.retornarAlmoxarifeIndex(tabelaAlmoxarife.getSelectedRow());
            if (almoxarife.getSupervisorAlmoxarife() == true && controle == 1 && almoxarife.getAtivoAlmoxarife() == true) {
                excluir = false;
            }
            int a, b;
            a = alm.getIdAlmoxarife();
            b = almoxarife.getIdAlmoxarife();
            boolean ultimo = false;
            if (a == b){
                excluir = false;
                ultimo = true;
            }
            if (excluir) {
                int resultado = controller.excluir(dao, almoxarife);
                // se a exclusão foi realizada com sucesso, exibe mensagem
                if (resultado == Dao.SUCESSO) {
                    JOptionPane.showMessageDialog(rootPane, "Exclusão realizada com sucesso!");
                    inicializar();
                    limparPesquisa();
                    // se o método excluir retorna o ERRO_1451, é porque o MySql lançou esse erro, o que significa que
                    // um registro associado não permite a exclusão desse objeto. No caso do funcionário, quando esse erro
                    // é lançado é porque há um almoxarife que é o funcionário que o usuário tentou excluir, e o banco não permitiu.

                } else if (resultado == Dao.ERRO_1451) {
                    JOptionPane.showMessageDialog(rootPane, "Esse almoxarife não pode ser excluído!");
                } else {
                    JOptionPane.showMessageDialog(rootPane, "Falha durante a exclusão");
                }
            } else {
                String mes = "Não é possível remover este almoxarife no momento.";
                if(ultimo){
                    mes = mes+"\nUsuário em uso no momento.";
                }
                JOptionPane.showMessageDialog(null, mes);
            }
        } else if (confirmacao == 1) {
            inicializar();
            limparPesquisa();
        }
    }//GEN-LAST:event_btExcluirActionPerformed

    private void btVoltarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btVoltarActionPerformed
        esquemaConsulta();
        tfCodigo.setText(null);
        tfCpf.setText(null);
        tfDataCad.setText(null);
        tfNome.setText(null);
        tfPesquisaNome1.setText(null);
        tfLogin.setText(null);
        tfSenha_confirm.setText(null);
        //exibe aba consulta
        painelAbas.setSelectedIndex(0);
    }//GEN-LAST:event_btVoltarActionPerformed

    private void tfPesquisaNomeKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_tfPesquisaNomeKeyPressed
        //limpa o campo de pesquisa quando o usuario tecla dentro do campo
        if (tfPesquisaNome.getText().equals("Digite o nome do almoxarife")) {
            tfPesquisaNome.setText("");
        }
    }//GEN-LAST:event_tfPesquisaNomeKeyPressed
    /*
     * método que refaz a tabela sempre que o usuário tecla no campo de pesquisa
     */
    private void tfPesquisaNomeKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_tfPesquisaNomeKeyReleased
        tabelaAlmoxarife.setModel(controller.preencherTabelaParametroNome(dao, tfPesquisaNome.getText()));
        System.out.println("oi");
        esquemaConsulta();
    }//GEN-LAST:event_tfPesquisaNomeKeyReleased
    /*
     * método que faz o objeto funcionário receber o funcionário selecionado na tabela, sempre
     * que o usuário clica com o mouse na tabela
     */
    private void tabelaAlmoxarifeMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tabelaAlmoxarifeMouseClicked
        esquemaConsultaSelecao();
    }//GEN-LAST:event_tabelaAlmoxarifeMouseClicked

    private void btSalvarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btSalvarActionPerformed
        // verifica se todos os campos obrigatórios estão preenchidos
        if (tfLogin.getText().equals("")) {
            JOptionPane.showMessageDialog(null, "O login do almoxarife é obrigatório!");
        } else if (tfSenha.getText().toString().equals("")) {
            JOptionPane.showMessageDialog(null, "A senha do almoxarife é obrigatória!");
        } else if (tfSenha_confirm.getText().toString().equals("")) {
            JOptionPane.showMessageDialog(null, "A confirmação de senha é obrigatória!");
        } else if (!tfSenha.getText().toString().equals(tfSenha_confirm.getText().toString())) {
            JOptionPane.showMessageDialog(null, "Existe uma divergencia entre os dados informados nos campos de senha.");
            tfSenha_confirm.setText(null);
        } else if ((rbAlmoxarife.isSelected() == false) && (rbSupervisor.isSelected() == false)) {
            JOptionPane.showMessageDialog(null, "O tipo de almoxarife é obrigatório!");
        } else {
            if (rbAtivo.isSelected() == true) {
                almoxarife.setAtivoAlmoxarife(true);
            } else {
                almoxarife.setAtivoAlmoxarife(false);
            }
            if (rbAlmoxarife.isSelected() == true) {
                almoxarife.setSupervisorAlmoxarife(false);
            } else {
                almoxarife.setSupervisorAlmoxarife(true);
            }
            almoxarife.setLoginAlmoxarife(tfLogin.getText());
            almoxarife.setSenhaAlmoxarife(tfSenha_confirm.getText().toString());
            almoxarife.setFuncionario(funcionario);
            int login = controller.quantidadeLogin(dao, almoxarife.getLoginAlmoxarife());
            boolean cadastro = true;
            if (login >= 1) {
                Almoxarife a_aux = new Almoxarife();
                a_aux = controller.findAlmoxarife(dao, almoxarife.getLoginAlmoxarife());
                int a, b;
                a = almoxarife.getIdAlmoxarife();
                b = a_aux.getIdAlmoxarife();
                if(a != b){
                    System.out.println(a_aux.getIdAlmoxarife());
                    System.out.println(almoxarife.getIdAlmoxarife());
                    System.out.println(alm.getIdAlmoxarife());
                    cadastro = false;
                }
            }
            if(cadastro) {
                if (controller.gravar(dao, almoxarife) == Dao.SUCESSO) {
                    JOptionPane.showMessageDialog(null, "Almoxarife gravado com sucesso!");
                } else {
                    JOptionPane.showMessageDialog(null, "Erro durante a operação!");
                }
                inicializar();
            // exibe aba de cadastro
            painelAbas.setSelectedIndex(0);
            limparPesquisa();
            } else {
                JOptionPane.showMessageDialog(null, "O login informado ja foi cadastrado para outro almoxarife.");
            }
            
        }
    }//GEN-LAST:event_btSalvarActionPerformed

    private void tfLoginActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tfLoginActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_tfLoginActionPerformed

private void tfPesquisaNome1KeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_tfPesquisaNome1KeyPressed
    //limpa o campo de pesquisa quando o usuario tecla dentro do campo
    btSelecionar.setEnabled(false);
    if (tfPesquisaNome1.getText().equals("Digite o nome do funcionário")) {
        tfPesquisaNome1.setText("");
    }
}//GEN-LAST:event_tfPesquisaNome1KeyPressed

private void tfPesquisaNome1KeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_tfPesquisaNome1KeyReleased
    //JOptionPane.showMessageDialog(null, tfPesquisaNome1.getText());
    tabelaFuncionario.setModel(controller2.preencherTabelaParametroNomeSemAlmoxarife(dao, tfPesquisaNome1.getText()));
    //esquemaConsulta();
}//GEN-LAST:event_tfPesquisaNome1KeyReleased

private void tabelaFuncionarioMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tabelaFuncionarioMouseClicked
    if (tabelaFuncionario.getSelectedRowCount() == 0) {
        btSelecionar.setEnabled(false);
    } else {
        btSelecionar.setEnabled(true);
    }
}//GEN-LAST:event_tabelaFuncionarioMouseClicked

private void btSelecionarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btSelecionarActionPerformed
    //preenche os campos de cadastro com os dados do funcionário selecionado na tabela
    funcionario = controller2.retornarFuncionarioIndex(tabelaFuncionario.getSelectedRow());
    tfCodigo.setText(funcionario.getIdFunc().toString());
    tfCpf.setText(funcionario.getCpfFunc());
    tfNome.setText(funcionario.getNomeFunc());
    tfDataCad.setText(new SimpleDateFormat("E dd/MM/yyyy HH:mm:ss").format(funcionario.getDtCadFunc()));
    tfLogin.setEnabled(true);
    tfLogin.setText(null);
    tfSenha.setEnabled(true);
    tfSenha.setText(null);
    tfSenha_confirm.setEnabled(true);
    tfSenha_confirm.setText(null);
    rbAlmoxarife.setEnabled(true);
    rbAlmoxarife.setSelected(true);
    rbSupervisor.setEnabled(true);
    rbSupervisor.setSelected(false);
    rbAtivo.setEnabled(true);
    rbAtivo.setSelected(true);
    rbInativo.setEnabled(true);
    rbInativo.setSelected(false);
    painelFuncionario.setVisible(false);
    btSelecionar.setEnabled(false);
    btLocalizar.setEnabled(true);
}//GEN-LAST:event_btSelecionarActionPerformed

private void btLocalizarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btLocalizarActionPerformed
// TODO add your handling code here:
    painelFuncionario.setVisible(true);
    btLocalizar.setEnabled(false);
}//GEN-LAST:event_btLocalizarActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        java.awt.EventQueue.invokeLater(new Runnable() {

            public void run() {
                new TelaAlmoxarife().setVisible(true);
            }
        });
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btAlterar;
    private javax.swing.JButton btCadastrar;
    private javax.swing.JButton btExcluir;
    private javax.swing.ButtonGroup btGroupAtivo;
    private javax.swing.ButtonGroup btGroupTipoAlmoxarife;
    private javax.swing.JButton btLocalizar;
    private javax.swing.JButton btSalvar;
    private javax.swing.JButton btSelecionar;
    private javax.swing.JButton btVoltar;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JLabel lbCodigo;
    private javax.swing.JLabel lbCpf;
    private javax.swing.JLabel lbDataCad;
    private javax.swing.JLabel lbLogin;
    private javax.swing.JLabel lbNome;
    private javax.swing.JLabel lbPesquisaNome;
    private javax.swing.JLabel lbPesquisaNome1;
    private javax.swing.JLabel lbSenha;
    private javax.swing.JLabel lbSenha1;
    private javax.swing.JLabel lbTipo;
    private javax.swing.JLabel lbTipo1;
    private javax.swing.JLabel lbTitulo;
    private javax.swing.JTabbedPane painelAbas;
    private javax.swing.JPanel painelCadastro;
    private javax.swing.JPanel painelComponentesCadastro;
    private javax.swing.JPanel painelConsulta;
    private javax.swing.JPanel painelFuncionario;
    private javax.swing.JRadioButton rbAlmoxarife;
    private javax.swing.JRadioButton rbAtivo;
    private javax.swing.JRadioButton rbInativo;
    private javax.swing.JRadioButton rbSupervisor;
    private javax.swing.JTable tabelaAlmoxarife;
    private javax.swing.JTable tabelaFuncionario;
    private javax.swing.JTextField tfCodigo;
    private javax.swing.JFormattedTextField tfCpf;
    private javax.swing.JTextField tfDataCad;
    private javax.swing.JTextField tfLogin;
    private javax.swing.JTextField tfNome;
    private javax.swing.JTextField tfPesquisaNome;
    private javax.swing.JTextField tfPesquisaNome1;
    private javax.swing.JPasswordField tfSenha;
    private javax.swing.JPasswordField tfSenha_confirm;
    // End of variables declaration//GEN-END:variables
}
