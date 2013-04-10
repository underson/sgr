/*
 * TelaRequisicao.java
 *
 * Created on 08/05/2012, 10:09:03
 */
package br.com.sca.frames;

import br.com.sca.controller.DepartamentoController;
import br.com.sca.controller.FuncionarioController;
import br.com.sca.controller.MateriaisController;
import br.com.sca.controller.RequisicaoController;
import br.com.sca.datamodel.MTReq;
import br.com.sca.datamodel.MTRequisicao;
import br.com.sca.entidades.Materiais;
import br.com.sca.entidades.MaterialRequisicao;
import br.com.sca.entidades.Requisicao;
import br.com.sca.persistencia.Dao;
import javax.swing.JOptionPane;
import javax.swing.SpinnerNumberModel;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Gregório
 */
public class TelaRequisicao extends javax.swing.JFrame {

    private FuncionarioController controller;
    private Dao dao;
    private RequisicaoController reqController;
    private DepartamentoController deptoController;
    private MaterialRequisicao matReq;
    private TelaPrincipal telaPrincipal;
    private MateriaisController matController;
    private Requisicao req;

    public TelaRequisicao(TelaPrincipal telaPrincipal) {
        this.telaPrincipal = telaPrincipal;
        initComponents();
        dao = new Dao();
        inicializar();
        reqController = new RequisicaoController(this.telaPrincipal);
        tabelaMateriais.setModel(reqController.preencherTabelaMat());
    }

    public TelaRequisicao() {
        initComponents();
        dao = new Dao();
        inicializar();

    }

    private void inicializar() {
        controller = new FuncionarioController();
        tabelaFuncionario.setModel(controller.retornaModelTabelaCompletaAtivo(dao));

        reqController = new RequisicaoController(this.telaPrincipal);
        tabelaMateriais.setModel(reqController.preencherTabelaMat());

        deptoController = new DepartamentoController();
        tabelaDepartamento.setModel(deptoController.retornaModelTabelaCompleta(dao));

    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jdAddMaterial = new javax.swing.JDialog();
        jsContador = new javax.swing.JSpinner();
        lbNomeMat = new javax.swing.JLabel();
        btConfirmar = new javax.swing.JButton();
        lbSelecioneQtde = new javax.swing.JLabel();
        jdSelecQtdEstorno = new javax.swing.JDialog();
        jsEstornoQtd = new javax.swing.JSpinner();
        lbNomeMatEstorno = new javax.swing.JLabel();
        lbIndiqueQtd = new javax.swing.JLabel();
        btConfirmarEstorno = new javax.swing.JButton();
        painelAbaRequisicao = new javax.swing.JTabbedPane();
        painelRequisicao = new javax.swing.JPanel();
        painelMateriais = new javax.swing.JScrollPane();
        tabelaMateriais = new javax.swing.JTable();
        lbMateriais = new javax.swing.JLabel();
        painelMaterialRequisicao = new javax.swing.JScrollPane();
        tabelaMaterialRequisicao = new javax.swing.JTable();
        lbMatReq = new javax.swing.JLabel();
        btAdicionarMaterial = new javax.swing.JButton();
        btRemoverMaterial = new javax.swing.JButton();
        painelFuncionario = new javax.swing.JScrollPane();
        tabelaFuncionario = new javax.swing.JTable();
        painelDepartamento = new javax.swing.JScrollPane();
        tabelaDepartamento = new javax.swing.JTable();
        tfDepartamento = new javax.swing.JTextField();
        lbPesquisaDpto = new javax.swing.JLabel();
        lbDepartamento = new javax.swing.JLabel();
        tfFuncionario = new javax.swing.JTextField();
        lbPesquisaFuncionario = new javax.swing.JLabel();
        lbFuncionario = new javax.swing.JLabel();
        btGravarReq = new javax.swing.JButton();
        lbPesquisaMat = new javax.swing.JLabel();
        tfPesquisaMatNome = new javax.swing.JTextField();
        jpEstorno = new javax.swing.JPanel();
        jspEstorno = new javax.swing.JScrollPane();
        tabelaRequisicoes = new javax.swing.JTable();
        lbRequisicoes = new javax.swing.JLabel();
        jsMateriaisEstorno = new javax.swing.JScrollPane();
        tabelaMateriaisEstorno = new javax.swing.JTable();
        btEstornar = new javax.swing.JButton();
        lbListaDeMat = new javax.swing.JLabel();
        btVoltar = new javax.swing.JButton();

        jdAddMaterial.setMinimumSize(new java.awt.Dimension(300, 200));

        lbNomeMat.setText("nome");

        btConfirmar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/br/com/sca/imagem/apply32x32.png"))); // NOI18N
        btConfirmar.setText("Confirmar");
        btConfirmar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btConfirmarActionPerformed(evt);
            }
        });

        lbSelecioneQtde.setFont(new java.awt.Font("Tahoma", 1, 12));
        lbSelecioneQtde.setText("Indique a quantidade:");

        javax.swing.GroupLayout jdAddMaterialLayout = new javax.swing.GroupLayout(jdAddMaterial.getContentPane());
        jdAddMaterial.getContentPane().setLayout(jdAddMaterialLayout);
        jdAddMaterialLayout.setHorizontalGroup(
            jdAddMaterialLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jdAddMaterialLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(lbNomeMat, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jsContador, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(44, 44, 44))
            .addGroup(jdAddMaterialLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(lbSelecioneQtde)
                .addContainerGap(102, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jdAddMaterialLayout.createSequentialGroup()
                .addContainerGap(115, Short.MAX_VALUE)
                .addComponent(btConfirmar)
                .addGap(18, 18, 18))
        );
        jdAddMaterialLayout.setVerticalGroup(
            jdAddMaterialLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jdAddMaterialLayout.createSequentialGroup()
                .addGap(12, 12, 12)
                .addComponent(lbSelecioneQtde)
                .addGap(18, 18, 18)
                .addGroup(jdAddMaterialLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lbNomeMat, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jsContador, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(34, 34, 34)
                .addComponent(btConfirmar)
                .addGap(21, 21, 21))
        );

        jdSelecQtdEstorno.setMinimumSize(new java.awt.Dimension(300, 250));

        lbNomeMatEstorno.setText("jLabel1");

        lbIndiqueQtd.setFont(new java.awt.Font("Tahoma", 1, 12));
        lbIndiqueQtd.setText("Indique a quantidade");

        btConfirmarEstorno.setIcon(new javax.swing.ImageIcon(getClass().getResource("/br/com/sca/imagem/apply32x32.png"))); // NOI18N
        btConfirmarEstorno.setText("Confirmar");
        btConfirmarEstorno.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btConfirmarEstornoActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jdSelecQtdEstornoLayout = new javax.swing.GroupLayout(jdSelecQtdEstorno.getContentPane());
        jdSelecQtdEstorno.getContentPane().setLayout(jdSelecQtdEstornoLayout);
        jdSelecQtdEstornoLayout.setHorizontalGroup(
            jdSelecQtdEstornoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jdSelecQtdEstornoLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jdSelecQtdEstornoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lbIndiqueQtd)
                    .addGroup(jdSelecQtdEstornoLayout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jdSelecQtdEstornoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(btConfirmarEstorno)
                            .addGroup(jdSelecQtdEstornoLayout.createSequentialGroup()
                                .addComponent(lbNomeMatEstorno, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jsEstornoQtd, javax.swing.GroupLayout.PREFERRED_SIZE, 66, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jdSelecQtdEstornoLayout.setVerticalGroup(
            jdSelecQtdEstornoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jdSelecQtdEstornoLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(lbIndiqueQtd)
                .addGap(18, 18, 18)
                .addGroup(jdSelecQtdEstornoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jsEstornoQtd, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lbNomeMatEstorno))
                .addGap(18, 18, 18)
                .addComponent(btConfirmarEstorno)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        painelAbaRequisicao.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                painelAbaRequisicaoFocusGained(evt);
            }
        });

        tabelaMateriais.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {},
                {},
                {},
                {}
            },
            new String [] {

            }
        ));
        tabelaMateriais.setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
        tabelaMateriais.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tabelaMateriaisMouseClicked(evt);
            }
        });
        painelMateriais.setViewportView(tabelaMateriais);

        lbMateriais.setText("Materiais");

        tabelaMaterialRequisicao.setModel(new DefaultTableModel(new Object[]{""}, 0));
        tabelaMaterialRequisicao.setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
        tabelaMaterialRequisicao.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tabelaMaterialRequisicaoMouseClicked(evt);
            }
        });
        painelMaterialRequisicao.setViewportView(tabelaMaterialRequisicao);

        lbMatReq.setText("Materiais Requisição");

        btAdicionarMaterial.setIcon(new javax.swing.ImageIcon(getClass().getResource("/br/com/sca/imagem/incluir_32x32.png"))); // NOI18N
        btAdicionarMaterial.setToolTipText("Adicionar Material");
        btAdicionarMaterial.setBorderPainted(false);
        btAdicionarMaterial.setContentAreaFilled(false);
        btAdicionarMaterial.setEnabled(false);
        btAdicionarMaterial.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btAdicionarMaterialActionPerformed(evt);
            }
        });

        btRemoverMaterial.setIcon(new javax.swing.ImageIcon(getClass().getResource("/br/com/sca/imagem/retirar_32x32.png"))); // NOI18N
        btRemoverMaterial.setToolTipText("Deletar Material");
        btRemoverMaterial.setBorderPainted(false);
        btRemoverMaterial.setContentAreaFilled(false);
        btRemoverMaterial.setEnabled(false);
        btRemoverMaterial.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btRemoverMaterialActionPerformed(evt);
            }
        });

        tabelaFuncionario.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {},
                {},
                {},
                {}
            },
            new String [] {

            }
        ));
        tabelaFuncionario.setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
        painelFuncionario.setViewportView(tabelaFuncionario);

        tabelaDepartamento.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {},
                {},
                {},
                {}
            },
            new String [] {

            }
        ));
        tabelaDepartamento.setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
        painelDepartamento.setViewportView(tabelaDepartamento);

        tfDepartamento.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                tfDepartamentoKeyReleased(evt);
            }
        });

        lbPesquisaDpto.setText("Pesquisa por nome:");

        lbDepartamento.setText("Departamento");

        tfFuncionario.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                tfFuncionarioKeyPressed(evt);
            }
            public void keyReleased(java.awt.event.KeyEvent evt) {
                tfFuncionarioKeyReleased(evt);
            }
        });

        lbPesquisaFuncionario.setText("Pesquisa por nome:");

        lbFuncionario.setText("Funcionário");

        btGravarReq.setIcon(new javax.swing.ImageIcon(getClass().getResource("/br/com/sca/imagem/apply32x32.png"))); // NOI18N
        btGravarReq.setText("Concluir");
        btGravarReq.setToolTipText("Gravar Requisição");
        btGravarReq.setBorderPainted(false);
        btGravarReq.setContentAreaFilled(false);
        btGravarReq.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btGravarReq.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        btGravarReq.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btGravarReqActionPerformed(evt);
            }
        });

        lbPesquisaMat.setText("Pesquisa por nome:");

        tfPesquisaMatNome.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                tfPesquisaMatNomeKeyReleased(evt);
            }
        });

        javax.swing.GroupLayout painelRequisicaoLayout = new javax.swing.GroupLayout(painelRequisicao);
        painelRequisicao.setLayout(painelRequisicaoLayout);
        painelRequisicaoLayout.setHorizontalGroup(
            painelRequisicaoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(painelRequisicaoLayout.createSequentialGroup()
                .addGap(10, 10, 10)
                .addGroup(painelRequisicaoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(painelRequisicaoLayout.createSequentialGroup()
                        .addComponent(lbFuncionario)
                        .addGap(490, 490, 490)
                        .addComponent(lbDepartamento))
                    .addGroup(painelRequisicaoLayout.createSequentialGroup()
                        .addComponent(lbPesquisaFuncionario)
                        .addGap(10, 10, 10)
                        .addComponent(tfFuncionario, javax.swing.GroupLayout.PREFERRED_SIZE, 225, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(216, 216, 216)
                        .addComponent(lbPesquisaDpto)
                        .addGap(10, 10, 10)
                        .addComponent(tfDepartamento, javax.swing.GroupLayout.PREFERRED_SIZE, 227, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(painelRequisicaoLayout.createSequentialGroup()
                        .addComponent(painelFuncionario, javax.swing.GroupLayout.PREFERRED_SIZE, 539, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(6, 6, 6)
                        .addComponent(painelDepartamento, javax.swing.GroupLayout.PREFERRED_SIZE, 562, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(lbMateriais)
                    .addGroup(painelRequisicaoLayout.createSequentialGroup()
                        .addGroup(painelRequisicaoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(painelRequisicaoLayout.createSequentialGroup()
                                .addComponent(lbPesquisaMat)
                                .addGap(4, 4, 4)
                                .addComponent(tfPesquisaMatNome, javax.swing.GroupLayout.PREFERRED_SIZE, 243, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(painelMateriais, javax.swing.GroupLayout.PREFERRED_SIZE, 465, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(6, 6, 6)
                        .addGroup(painelRequisicaoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(painelRequisicaoLayout.createSequentialGroup()
                                .addGap(59, 59, 59)
                                .addComponent(lbMatReq))
                            .addGroup(painelRequisicaoLayout.createSequentialGroup()
                                .addGap(59, 59, 59)
                                .addComponent(painelMaterialRequisicao, javax.swing.GroupLayout.PREFERRED_SIZE, 469, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(btGravarReq, javax.swing.GroupLayout.PREFERRED_SIZE, 87, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(btAdicionarMaterial)
                            .addComponent(btRemoverMaterial))))
                .addContainerGap())
        );
        painelRequisicaoLayout.setVerticalGroup(
            painelRequisicaoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(painelRequisicaoLayout.createSequentialGroup()
                .addGap(11, 11, 11)
                .addGroup(painelRequisicaoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lbFuncionario)
                    .addComponent(lbDepartamento))
                .addGap(18, 18, 18)
                .addGroup(painelRequisicaoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(painelRequisicaoLayout.createSequentialGroup()
                        .addGap(3, 3, 3)
                        .addComponent(lbPesquisaFuncionario))
                    .addComponent(tfFuncionario, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(painelRequisicaoLayout.createSequentialGroup()
                        .addGap(3, 3, 3)
                        .addComponent(lbPesquisaDpto))
                    .addComponent(tfDepartamento, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(11, 11, 11)
                .addGroup(painelRequisicaoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(painelFuncionario, javax.swing.GroupLayout.PREFERRED_SIZE, 191, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(painelDepartamento, javax.swing.GroupLayout.PREFERRED_SIZE, 191, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(lbMateriais)
                .addGap(3, 3, 3)
                .addGroup(painelRequisicaoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(painelRequisicaoLayout.createSequentialGroup()
                        .addGap(3, 3, 3)
                        .addGroup(painelRequisicaoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(painelRequisicaoLayout.createSequentialGroup()
                                .addGap(3, 3, 3)
                                .addComponent(lbPesquisaMat))
                            .addComponent(tfPesquisaMatNome, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(9, 9, 9)
                        .addComponent(painelMateriais, javax.swing.GroupLayout.PREFERRED_SIZE, 233, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(painelRequisicaoLayout.createSequentialGroup()
                        .addComponent(lbMatReq)
                        .addGap(6, 6, 6)
                        .addGroup(painelRequisicaoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(painelMaterialRequisicao, javax.swing.GroupLayout.PREFERRED_SIZE, 250, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(painelRequisicaoLayout.createSequentialGroup()
                                .addGap(12, 12, 12)
                                .addComponent(btAdicionarMaterial))
                            .addGroup(painelRequisicaoLayout.createSequentialGroup()
                                .addGap(64, 64, 64)
                                .addComponent(btRemoverMaterial)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 83, Short.MAX_VALUE)
                                .addComponent(btGravarReq)
                                .addContainerGap())))))
        );

        painelAbaRequisicao.addTab("Requisição", painelRequisicao);

        jpEstorno.addComponentListener(new java.awt.event.ComponentAdapter() {
            public void componentShown(java.awt.event.ComponentEvent evt) {
                jpEstornoComponentShown(evt);
            }
        });

        tabelaRequisicoes.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {

            }
        ));
        tabelaRequisicoes.setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
        tabelaRequisicoes.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                tabelaRequisicoesMousePressed(evt);
            }
        });
        jspEstorno.setViewportView(tabelaRequisicoes);

        lbRequisicoes.setText("Requisições:");

        tabelaMateriaisEstorno.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {

            }
        ));
        tabelaMateriaisEstorno.setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
        tabelaMateriaisEstorno.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tabelaMateriaisEstornoMouseClicked(evt);
            }
        });
        jsMateriaisEstorno.setViewportView(tabelaMateriaisEstorno);

        btEstornar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/br/com/sca/imagem/apply32x32.png"))); // NOI18N
        btEstornar.setToolTipText("Estornar");
        btEstornar.setBorderPainted(false);
        btEstornar.setContentAreaFilled(false);
        btEstornar.setEnabled(false);
        btEstornar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btEstornarActionPerformed(evt);
            }
        });

        lbListaDeMat.setText("Lista de materiais:");

        btVoltar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/br/com/sca/imagem/voltar_32x32.png"))); // NOI18N
        btVoltar.setToolTipText("Voltar");
        btVoltar.setBorderPainted(false);
        btVoltar.setContentAreaFilled(false);
        btVoltar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btVoltarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jpEstornoLayout = new javax.swing.GroupLayout(jpEstorno);
        jpEstorno.setLayout(jpEstornoLayout);
        jpEstornoLayout.setHorizontalGroup(
            jpEstornoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jpEstornoLayout.createSequentialGroup()
                .addGap(10, 10, 10)
                .addGroup(jpEstornoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lbRequisicoes)
                    .addComponent(jspEstorno, javax.swing.GroupLayout.PREFERRED_SIZE, 470, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(37, 37, 37)
                .addGroup(jpEstornoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lbListaDeMat, javax.swing.GroupLayout.PREFERRED_SIZE, 102, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jsMateriaisEstorno, javax.swing.GroupLayout.PREFERRED_SIZE, 567, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(28, 28, 28))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jpEstornoLayout.createSequentialGroup()
                .addContainerGap(665, Short.MAX_VALUE)
                .addComponent(btVoltar)
                .addGap(55, 55, 55)
                .addComponent(btEstornar)
                .addGap(262, 262, 262))
        );
        jpEstornoLayout.setVerticalGroup(
            jpEstornoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jpEstornoLayout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addGroup(jpEstornoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lbRequisicoes)
                    .addComponent(lbListaDeMat))
                .addGap(18, 18, 18)
                .addGroup(jpEstornoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jsMateriaisEstorno, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jspEstorno, javax.swing.GroupLayout.Alignment.TRAILING))
                .addGap(25, 25, 25)
                .addGroup(jpEstornoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btVoltar)
                    .addComponent(btEstornar))
                .addGap(52, 52, 52))
        );

        painelAbaRequisicao.addTab("Estorno", jpEstorno);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(painelAbaRequisicao, javax.swing.GroupLayout.DEFAULT_SIZE, 1117, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(painelAbaRequisicao, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void tfFuncionarioKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_tfFuncionarioKeyPressed
        if (tfFuncionario.getText().equals("Digite o nome do funcionário")) {
            tfFuncionario.setText("");
        }
    }//GEN-LAST:event_tfFuncionarioKeyPressed

    private void tfFuncionarioKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_tfFuncionarioKeyReleased
        tabelaFuncionario.setModel(controller.preencherTabelaParametroNome(dao, tfFuncionario.getText()));
    }//GEN-LAST:event_tfFuncionarioKeyReleased

    private void btAdicionarMaterialActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btAdicionarMaterialActionPerformed
        if (tabelaMateriais.getSelectedRow() == -1) {
            JOptionPane.showMessageDialog(null, "Selecione ao menos 1 material.");
        } else {

            matReq = reqController.getObjectIndex(tabelaMateriais.getSelectedRow(),
                    (MTRequisicao) tabelaMateriais.getModel());
            lbNomeMat.setText(matReq.getMateriais().getNomeMat());
            jsContador.setModel(new SpinnerNumberModel(1, 1, matReq.getMateriais().getQtdEstqMat(), 1));
            jdAddMaterial.setVisible(true);
        }
    }//GEN-LAST:event_btAdicionarMaterialActionPerformed

    private void btConfirmarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btConfirmarActionPerformed
        matReq = reqController.getObjectIndex(tabelaMateriais.getSelectedRow(),
                (MTRequisicao) tabelaMateriais.getModel());
        Double aux = new Double((Double) jsContador.getValue());
        int aux1 = (int) aux.doubleValue();
        long aux2 = (long) aux1;
        matReq.setQtdMatreq(aux2);
        tabelaMateriais.setModel(reqController.removerMat(tabelaMateriais.getSelectedRow()));
        tabelaMaterialRequisicao.setModel(reqController.adicionarReq(matReq));
        desabilitarBt();
        jdAddMaterial.dispose();

    }//GEN-LAST:event_btConfirmarActionPerformed

    private void btRemoverMaterialActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btRemoverMaterialActionPerformed
        matReq = reqController.getObjectIndex(tabelaMaterialRequisicao.getSelectedRow(), (MTReq) tabelaMaterialRequisicao.getModel());
        System.out.println(matReq.getMateriais().getNomeMat());
        tabelaMateriais.setModel(reqController.adicionarMat(matReq));
        matReq.setQtdMatreq(0);
        tabelaMaterialRequisicao.setModel(reqController.removerReq(tabelaMaterialRequisicao.getSelectedRow()));
        desabilitarBt();


    }//GEN-LAST:event_btRemoverMaterialActionPerformed

    private void tabelaMateriaisMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tabelaMateriaisMouseClicked
        btAdicionarMaterial.setEnabled(true);
    }//GEN-LAST:event_tabelaMateriaisMouseClicked

    private void tabelaMaterialRequisicaoMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tabelaMaterialRequisicaoMouseClicked
        btRemoverMaterial.setEnabled(true);
    }//GEN-LAST:event_tabelaMaterialRequisicaoMouseClicked

    private void btGravarReqActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btGravarReqActionPerformed


        if (tabelaDepartamento.getSelectedRow() == -1) {
            JOptionPane.showMessageDialog(null, "Selecione o departamento.");
        } else if (tabelaFuncionario.getSelectedRow() == -1) {
            JOptionPane.showMessageDialog(null, "Selecione o funcionário.");
        } else if (tabelaMaterialRequisicao.getModel().getRowCount() == 0) {
            JOptionPane.showMessageDialog(null, "Adicione os materiais à lista de requisição.");
        } else {
            MTReq modeloItem = (MTReq) tabelaMaterialRequisicao.getModel();
            if (reqController.gravarRequisicao(modeloItem.getList(), controller.retornarFuncionarioIndex(tabelaFuncionario.getSelectedRow()), deptoController.retornarDepartamentoIndex(tabelaDepartamento.getSelectedRow()), "")) {
                JOptionPane.showMessageDialog(null, "Requisição realizada com sucesso!");
                tabelaMateriais.setModel(reqController.preencherTabelaMat());
                tabelaFuncionario.clearSelection();
                tabelaDepartamento.clearSelection();
                tabelaMaterialRequisicao.setModel(new DefaultTableModel());
                reqController.limparLista();


            } else {
                JOptionPane.showMessageDialog(painelRequisicao, "Erro durante o processo!");

            }
        }


    }//GEN-LAST:event_btGravarReqActionPerformed

    private void jpEstornoComponentShown(java.awt.event.ComponentEvent evt) {//GEN-FIRST:event_jpEstornoComponentShown
        tabelaRequisicoes.setModel(reqController.retornaModelTabelaCompleta(dao));

    }//GEN-LAST:event_jpEstornoComponentShown

    private void tabelaRequisicoesMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tabelaRequisicoesMousePressed
        req = new Requisicao();
        req = reqController.retornarRequisicaoIndex(tabelaRequisicoes.getSelectedRow());
        tabelaMateriaisEstorno.setModel(new MTReq(req.getMaterialRequisicaoList()));
        btEstornar.setEnabled(false);
    }//GEN-LAST:event_tabelaRequisicoesMousePressed

    private void btEstornarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btEstornarActionPerformed
        if(tabelaMateriaisEstorno.getSelectedRow()== -1){
            JOptionPane.showMessageDialog(null, "Selecione o material para estorno.");
        } 
        else{
        matReq = reqController.getObjectIndex(tabelaMateriaisEstorno.getSelectedRow(), (MTReq) tabelaMateriaisEstorno.getModel());
        lbNomeMatEstorno.setText("" + matReq.getMateriais().getNomeMat());
        jsEstornoQtd.setModel(new SpinnerNumberModel(1, 1, matReq.getQtdMatreq(), 1));
        jdSelecQtdEstorno.setVisible(true);
        }
    }//GEN-LAST:event_btEstornarActionPerformed

    private void btConfirmarEstornoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btConfirmarEstornoActionPerformed
        if(tabelaMateriaisEstorno.getSelectedRow() == -1){
            JOptionPane.showMessageDialog(null, "Selecione o material para estorno.");
        }

        else{

        matReq = reqController.getObjectIndex(tabelaMateriaisEstorno.getSelectedRow(), (MTReq) tabelaMateriaisEstorno.getModel());
        Double aux = new Double((Double) jsEstornoQtd.getValue());
        int aux1 = (int) aux.doubleValue();
        long aux2 = (long) aux1;
        matReq.setQtdMatreq(matReq.getQtdMatreq() - aux2);
        dao.gravar(matReq);
        Materiais mat = new Materiais();
        mat = matReq.getMateriais();
        mat.setQtdEstqMat(mat.getQtdEstqMat() + aux2);
        dao.gravar(mat);
        jdSelecQtdEstorno.dispose();
        req = new Requisicao();
        req = reqController.retornarRequisicaoIndex(tabelaRequisicoes.getSelectedRow());
        tabelaMateriaisEstorno.setModel(new MTReq(req.getMaterialRequisicaoList()));
        }
    }//GEN-LAST:event_btConfirmarEstornoActionPerformed

    private void btVoltarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btVoltarActionPerformed
        painelAbaRequisicao.setSelectedIndex(0);
    }//GEN-LAST:event_btVoltarActionPerformed

    private void painelAbaRequisicaoFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_painelAbaRequisicaoFocusGained

    }//GEN-LAST:event_painelAbaRequisicaoFocusGained

    private void tabelaMateriaisEstornoMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tabelaMateriaisEstornoMouseClicked
        matReq = reqController.getObjectIndex(tabelaMateriaisEstorno.getSelectedRow(), (MTReq) tabelaMateriaisEstorno.getModel());
        if(matReq.getQtdMatreq()<1){
            
        }
 else{
            btEstornar.setEnabled(true);
 }

    }//GEN-LAST:event_tabelaMateriaisEstornoMouseClicked

    private void tfPesquisaMatNomeKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_tfPesquisaMatNomeKeyReleased
        tabelaMateriais.setModel(reqController.preencherTabelaParametroNome(dao, tfPesquisaMatNome.getText()));
    }//GEN-LAST:event_tfPesquisaMatNomeKeyReleased

    private void tfDepartamentoKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_tfDepartamentoKeyReleased
        tabelaDepartamento.setModel(deptoController.preencherTabelaParametroNome(dao, tfDepartamento.getText()));
    }//GEN-LAST:event_tfDepartamentoKeyReleased

    private void desabilitarBt() {
        btAdicionarMaterial.setEnabled(false);
        btRemoverMaterial.setEnabled(false);
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        java.awt.EventQueue.invokeLater(new Runnable() {

            public void run() {
                new TelaRequisicao().setVisible(true);
            }
        });
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btAdicionarMaterial;
    private javax.swing.JButton btConfirmar;
    private javax.swing.JButton btConfirmarEstorno;
    private javax.swing.JButton btEstornar;
    private javax.swing.JButton btGravarReq;
    private javax.swing.JButton btRemoverMaterial;
    private javax.swing.JButton btVoltar;
    private javax.swing.JDialog jdAddMaterial;
    private javax.swing.JDialog jdSelecQtdEstorno;
    private javax.swing.JPanel jpEstorno;
    private javax.swing.JSpinner jsContador;
    private javax.swing.JSpinner jsEstornoQtd;
    private javax.swing.JScrollPane jsMateriaisEstorno;
    private javax.swing.JScrollPane jspEstorno;
    private javax.swing.JLabel lbDepartamento;
    private javax.swing.JLabel lbFuncionario;
    private javax.swing.JLabel lbIndiqueQtd;
    private javax.swing.JLabel lbListaDeMat;
    private javax.swing.JLabel lbMatReq;
    private javax.swing.JLabel lbMateriais;
    private javax.swing.JLabel lbNomeMat;
    private javax.swing.JLabel lbNomeMatEstorno;
    private javax.swing.JLabel lbPesquisaDpto;
    private javax.swing.JLabel lbPesquisaFuncionario;
    private javax.swing.JLabel lbPesquisaMat;
    private javax.swing.JLabel lbRequisicoes;
    private javax.swing.JLabel lbSelecioneQtde;
    private javax.swing.JTabbedPane painelAbaRequisicao;
    private javax.swing.JScrollPane painelDepartamento;
    private javax.swing.JScrollPane painelFuncionario;
    private javax.swing.JScrollPane painelMateriais;
    private javax.swing.JScrollPane painelMaterialRequisicao;
    private javax.swing.JPanel painelRequisicao;
    private javax.swing.JTable tabelaDepartamento;
    private javax.swing.JTable tabelaFuncionario;
    private javax.swing.JTable tabelaMateriais;
    private javax.swing.JTable tabelaMateriaisEstorno;
    private javax.swing.JTable tabelaMaterialRequisicao;
    private javax.swing.JTable tabelaRequisicoes;
    private javax.swing.JTextField tfDepartamento;
    private javax.swing.JTextField tfFuncionario;
    private javax.swing.JTextField tfPesquisaMatNome;
    // End of variables declaration//GEN-END:variables
}
