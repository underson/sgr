/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/*
 * TelaMateriais.java
 *
 * Created on 07/05/2012, 17:17:33
 */
package br.com.sca.frames;

import br.com.sca.controller.MateriaisController;
import br.com.sca.entidades.Materiais;
import br.com.sca.entidades.Categoria;
import br.com.sca.persistencia.Dao;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import javax.swing.JOptionPane;
import javax.swing.JFormattedTextField;

/**
 *
 * @author Bruno Gomes
 */
public class TelaMateriais extends javax.swing.JFrame {

    private MateriaisController controller;
    private Materiais materiais;
    private Dao dao;
    public List<Categoria> listaCategoria;

    /** Creates new form TelaMateriais */
    public TelaMateriais() {
        initComponents();
        dao = new Dao();
        inicializar();
    }

    /*
     * método para instanciar entidade e controller e preencher a tabela
     */
    private void inicializar() {
        controller = new MateriaisController();
        tabelaMateriais.setModel(controller.retornaModelTabelaCompleta(dao));
        materiais = new Materiais();
        esquemaConsulta();
        limparFormulario();
    }

    /*
     * método para limpar os campos de cadastro
     */
    private void limparFormulario() {
        tfCodigo.setText("");
        tfNome.setText("");
        tfQuantidade.setText("");
        tfQuantMin.setText("");
        taDesc.setText("");
        tfDataCad.setText("");
        tfMarca.setText("");

    }

    public void preencherCbMat() {
        listaCategoria = dao.pesquisar("Categoria.findAll");
        cbMat.removeAllItems();
        for (Categoria mat : listaCategoria) {
            cbMat.addItem(mat.getNomeCateg());
        }
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
        preencherCbMat();
        tfCodigo.setEnabled(false);
        lbCodigo.setVisible(true);
        tabelaMateriais.clearSelection();
        btCadastrar.setEnabled(false);
        btAlterar.setEnabled(false);
        btExcluir.setEnabled(false);
        btVoltar.setVisible(true);
        btSalvar.setVisible(true);
        tfDataCad.setText(new SimpleDateFormat("E dd/MM/yyyy HH:mm:ss").format(System.currentTimeMillis()));
        rbAtivo.setEnabled(true);
        rbInativo.setEnabled(true);
        rbUnitario.setEnabled(true);
        rbPacote.setEnabled(true);
        cbMat.setEnabled(true);
    }

    private void limparPesquisa() {
        tfPesquisaNome.setText("");
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        tipoItem = new javax.swing.ButtonGroup();
        situacao = new javax.swing.ButtonGroup();
        jLabel1 = new javax.swing.JLabel();
        painelAbas = new javax.swing.JTabbedPane();
        jPanel1 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tabelaMateriais = new javax.swing.JTable();
        jLabel2 = new javax.swing.JLabel();
        tfPesquisaNome = new javax.swing.JTextField();
        jPanel2 = new javax.swing.JPanel();
        lbCodigo = new javax.swing.JLabel();
        lbNome = new javax.swing.JLabel();
        lbQuant = new javax.swing.JLabel();
        lbQuantMin = new javax.swing.JLabel();
        lbTipo = new javax.swing.JLabel();
        lbDescricao = new javax.swing.JLabel();
        lbData = new javax.swing.JLabel();
        lbAtivo = new javax.swing.JLabel();
        lbCategoria = new javax.swing.JLabel();
        tfCodigo = new javax.swing.JTextField();
        tfNome = new javax.swing.JTextField();
        tfDataCad = new javax.swing.JTextField();
        cbMat = new javax.swing.JComboBox();
        rbUnitario = new javax.swing.JRadioButton();
        rbPacote = new javax.swing.JRadioButton();
        rbAtivo = new javax.swing.JRadioButton();
        rbInativo = new javax.swing.JRadioButton();
        jScrollPane2 = new javax.swing.JScrollPane();
        taDesc = new javax.swing.JTextArea();
        lbMarca = new javax.swing.JLabel();
        tfMarca = new javax.swing.JTextField();
        tfQuantidade = new javax.swing.JFormattedTextField();
        tfQuantMin = new javax.swing.JFormattedTextField();
        btCadastrar = new javax.swing.JButton();
        btAlterar = new javax.swing.JButton();
        btExcluir = new javax.swing.JButton();
        btVoltar = new javax.swing.JButton();
        btSalvar = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        jLabel1.setFont(new java.awt.Font("Times New Roman", 0, 24));
        jLabel1.setText("MATERIAIS");

        painelAbas.setEnabled(false);

        tabelaMateriais.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4", "Title 5"
            }
        ));
        tabelaMateriais.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tabelaMateriaisMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tabelaMateriais);

        jLabel2.setText("Pesquisa por nome do material:");

        tfPesquisaNome.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                tfPesquisaNomeKeyPressed(evt);
            }
            public void keyReleased(java.awt.event.KeyEvent evt) {
                tfPesquisaNomeKeyReleased(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 877, Short.MAX_VALUE)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel2)
                        .addGap(18, 18, 18)
                        .addComponent(tfPesquisaNome, javax.swing.GroupLayout.PREFERRED_SIZE, 292, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(tfPesquisaNome, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 300, Short.MAX_VALUE)
                .addContainerGap())
        );

        painelAbas.addTab("Pesquisa", jPanel1);

        jPanel2.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));

        lbCodigo.setText("Código:");

        lbNome.setText("Nome do material:");

        lbQuant.setText("Quantidade em estoque:");

        lbQuantMin.setText("Quantidade mínima:");

        lbTipo.setText("Tipo de material:");

        lbDescricao.setText("Descrição:");

        lbData.setText("Data de cadastro:");

        lbAtivo.setText("Situação:");

        lbCategoria.setText("Categoria:");

        tfCodigo.setEditable(false);

        tfDataCad.setEditable(false);

        cbMat.setEnabled(false);

        tipoItem.add(rbUnitario);
        rbUnitario.setSelected(true);
        rbUnitario.setText("Unitário");
        rbUnitario.setEnabled(false);

        tipoItem.add(rbPacote);
        rbPacote.setText("Pacote");
        rbPacote.setEnabled(false);

        situacao.add(rbAtivo);
        rbAtivo.setSelected(true);
        rbAtivo.setText("Ativo");
        rbAtivo.setEnabled(false);

        situacao.add(rbInativo);
        rbInativo.setText("Inativo");
        rbInativo.setEnabled(false);

        taDesc.setColumns(20);
        taDesc.setRows(5);
        jScrollPane2.setViewportView(taDesc);

        lbMarca.setText("Marca:");

        tfQuantidade.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.NumberFormatter(new java.text.DecimalFormat("##########"))));
        tfQuantidade.setText("0");

        tfQuantMin.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.NumberFormatter(new java.text.DecimalFormat("##########"))));
        tfQuantMin.setText("0");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(53, 53, 53)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(lbQuant)
                            .addComponent(lbNome)
                            .addComponent(lbCodigo)
                            .addComponent(lbMarca)
                            .addComponent(lbQuantMin))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(tfNome, javax.swing.GroupLayout.DEFAULT_SIZE, 200, Short.MAX_VALUE)
                                .addComponent(tfCodigo, javax.swing.GroupLayout.PREFERRED_SIZE, 69, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(tfMarca, javax.swing.GroupLayout.DEFAULT_SIZE, 200, Short.MAX_VALUE))
                            .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                .addComponent(tfQuantMin, javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(tfQuantidade, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 73, Short.MAX_VALUE))))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(39, 39, 39)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(lbTipo)
                            .addComponent(lbAtivo))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addComponent(rbAtivo)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(rbInativo))
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addComponent(rbPacote)
                                .addGap(18, 18, 18)
                                .addComponent(rbUnitario)))
                        .addGap(60, 60, 60)))
                .addGap(38, 38, 38)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(lbDescricao)
                    .addComponent(lbCategoria)
                    .addComponent(lbData))
                .addGap(10, 10, 10)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(cbMat, javax.swing.GroupLayout.PREFERRED_SIZE, 192, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(tfDataCad, javax.swing.GroupLayout.PREFERRED_SIZE, 202, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 266, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(106, 106, 106))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lbCodigo)
                    .addComponent(tfCodigo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(cbMat, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lbCategoria))
                .addGap(18, 18, 18)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(lbNome)
                            .addComponent(tfNome, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(lbDescricao))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(lbMarca)
                            .addComponent(tfMarca, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(lbQuant)
                            .addComponent(tfQuantidade, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 96, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lbQuantMin)
                    .addComponent(lbData)
                    .addComponent(tfDataCad, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(tfQuantMin, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(48, 48, 48)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(rbAtivo)
                            .addComponent(lbAtivo)
                            .addComponent(rbInativo)))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(18, 18, 18)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(lbTipo)
                            .addComponent(rbPacote)
                            .addComponent(rbUnitario))))
                .addContainerGap(94, Short.MAX_VALUE))
        );

        painelAbas.addTab("Cadastro", jPanel2);

        btCadastrar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/br/com/sca/imagem/novo_32x32.png"))); // NOI18N
        btCadastrar.setToolTipText("Novo Material");
        btCadastrar.setBorderPainted(false);
        btCadastrar.setContentAreaFilled(false);
        btCadastrar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btCadastrarActionPerformed(evt);
            }
        });

        btAlterar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/br/com/sca/imagem/editar_32x32.png"))); // NOI18N
        btAlterar.setToolTipText("Editar Material");
        btAlterar.setBorderPainted(false);
        btAlterar.setContentAreaFilled(false);
        btAlterar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btAlterarActionPerformed(evt);
            }
        });

        btExcluir.setIcon(new javax.swing.ImageIcon(getClass().getResource("/br/com/sca/imagem/delete_32x32.png"))); // NOI18N
        btExcluir.setToolTipText("Deletar Material");
        btExcluir.setBorderPainted(false);
        btExcluir.setContentAreaFilled(false);
        btExcluir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btExcluirActionPerformed(evt);
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
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(btCadastrar)
                        .addGap(18, 18, 18)
                        .addComponent(btAlterar)
                        .addGap(18, 18, 18)
                        .addComponent(btExcluir)
                        .addGap(18, 18, 18)
                        .addComponent(btVoltar)
                        .addGap(79, 79, 79)
                        .addComponent(btSalvar))
                    .addComponent(painelAbas, javax.swing.GroupLayout.PREFERRED_SIZE, 902, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(404, Short.MAX_VALUE)
                .addComponent(jLabel1)
                .addGap(390, 390, 390))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(painelAbas, javax.swing.GroupLayout.PREFERRED_SIZE, 376, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(btCadastrar, javax.swing.GroupLayout.PREFERRED_SIZE, 31, Short.MAX_VALUE)
                    .addComponent(btAlterar, javax.swing.GroupLayout.PREFERRED_SIZE, 31, Short.MAX_VALUE)
                    .addComponent(btExcluir, javax.swing.GroupLayout.PREFERRED_SIZE, 31, Short.MAX_VALUE)
                    .addComponent(btVoltar, javax.swing.GroupLayout.PREFERRED_SIZE, 31, Short.MAX_VALUE)
                    .addComponent(btSalvar, 0, 0, Short.MAX_VALUE))
                .addContainerGap(21, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btCadastrarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btCadastrarActionPerformed
        limparFormulario();
        esquemaCadastro();
        // chama a aba de cadatro no painel
        painelAbas.setSelectedIndex(1);
        materiais = new Materiais();//

    }//GEN-LAST:event_btCadastrarActionPerformed

    private void btAlterarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btAlterarActionPerformed
        //altera os campos mutáveis do material

        materiais = controller.retornarMateriaisIndex(tabelaMateriais.getSelectedRow());
        esquemaCadastro();
        if (materiais.isAtivoMat() == true) {
            rbAtivo.setSelected(true);
            rbInativo.setSelected(false);
        } else if (materiais.isAtivoMat() == false) {
            rbInativo.setSelected(true);
            rbAtivo.setSelected(false);
        }
        tfCodigo.setText(materiais.getIdMat().toString());
        tfCodigo.setVisible(true);
        lbCodigo.setVisible(true);
        tfNome.setText(materiais.getNomeMat());
        tfMarca.setText(materiais.getMarcaMat());
        tfQuantidade.setText(String.valueOf(materiais.getQtdEstqMat()));
        tfQuantMin.setText(String.valueOf(materiais.getQtdMinMat()));
        if ("Unitário".equals(materiais.getTipoMat())) {
            rbUnitario.setSelected(true);
            rbPacote.setSelected(false);
        } else if ("Pacote".equals(materiais.getTipoMat())) {
            rbPacote.setSelected(true);
            rbUnitario.setSelected(false);
        }
        taDesc.setText(materiais.getDescMat());
        tfDataCad.setText(new SimpleDateFormat("E dd/MM/yyyy HH:mm:ss").format(materiais.getDtCadMat()));
        Categoria cat = new Categoria();
        cat = materiais.getCategoria();
        int x = listaCategoria.indexOf(cat);
        cbMat.setSelectedIndex(x);
        // chama a aba de cadatro no painel

        painelAbas.setSelectedIndex(1);
    }//GEN-LAST:event_btAlterarActionPerformed

    private void btExcluirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btExcluirActionPerformed
        //pede a confirmação da exclusão
        int confirmacao = JOptionPane.showConfirmDialog(rootPane, "Este material será excluído permanentemente. Confirma a ação?");
        if (confirmacao == 0) {
            materiais = controller.retornarMateriaisIndex(tabelaMateriais.getSelectedRow());
            int resultado = controller.excluir(dao, materiais);
            // se a exclusão foi realizada com sucesso, exibe mensagem
            if (resultado == Dao.SUCESSO) {
                JOptionPane.showMessageDialog(rootPane, "Exclusão realizada com sucesso!");
                inicializar();
                limparPesquisa();
                // se o método excluir retorna o ERRO_1451, é porque o MySql lançou esse erro, o que significa que
                // um registro associado não permite a exclusão desse objeto. No caso do material, quando esse erro
                // é lançado é porque houve alguma movimentação desse material, e por isso banco não permitiu.
            } else if (resultado == Dao.ERRO_1451) {
                JOptionPane.showMessageDialog(rootPane, "Esse material não pode ser excluído pois está relacionado a compras ou requisições!");
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

    private void btSalvarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btSalvarActionPerformed
        // verifica se todos os campos obrigatórios estão preenchidos

        listaCategoria = dao.pesquisar("Categoria.findAll");
        materiais.setCategoria(listaCategoria.get(cbMat.getSelectedIndex()));
        if (rbAtivo.isSelected() == true) {
            materiais.setAtivoMat(true);
        } else if (rbInativo.isSelected() == true) {
            materiais.setAtivoMat(false);
        }
        if (tfNome.getText().equals("")) {
            JOptionPane.showMessageDialog(null, "O nome do material é obrigatório!");
        } else if (tfMarca.getText().trim().equals("")) {
            JOptionPane.showMessageDialog(null, "A Marca é obrigatória!");
        } else if (tfQuantidade.getText().equals("")) {
            JOptionPane.showMessageDialog(null, "A Quantidade inicial é obrigatória!");
        } else if (tfQuantMin.getText().equals("")) {
            JOptionPane.showMessageDialog(null, "A Quantidade mínima é obrigatória!");
        } else {
            if (rbUnitario.isSelected() == true) {
                materiais.setTipoMat(rbUnitario.getText());
            } else if (rbPacote.isSelected() == true) {
                materiais.setTipoMat(rbPacote.getText());
            }
            materiais.setMarcaMat(tfMarca.getText());
            materiais.setDescMat(taDesc.getText());
            materiais.setNomeMat(tfNome.getText());
            materiais.setQtdEstqMat(Long.parseLong(tfQuantidade.getText()));
            materiais.setQtdMinMat(Long.parseLong(tfQuantMin.getText()));

            // se a chave primária do objeto é nula, é um novo registro. Nesse caso, pega a data do sistema
            // e seta no material.
            if (materiais.getIdMat() == null) {
                Date data = new Date(System.currentTimeMillis());
                materiais.setDtCadMat(data);
            }
            if (controller.gravar(dao, materiais) == Dao.SUCESSO) {
                JOptionPane.showMessageDialog(null, "Material gravado com sucesso!");
            } else {
                JOptionPane.showMessageDialog(null, "Erro durante a operação!");
            }
            inicializar();
            // exibe aba de cadastro
            painelAbas.setSelectedIndex(0);
            limparPesquisa();
            rbAtivo.setEnabled(false);
            rbInativo.setEnabled(false);
            rbUnitario.setEnabled(false);
            rbPacote.setEnabled(false);
            cbMat.setEnabled(false);
        }
    }//GEN-LAST:event_btSalvarActionPerformed

    private void tfPesquisaNomeKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_tfPesquisaNomeKeyPressed
        //limpa o campo de pesquisa quando o usuario tecla dentro do campo
        if (tfPesquisaNome.getText().equals("Digite o nome do material")) {
            tfPesquisaNome.setText("");
        }
    }//GEN-LAST:event_tfPesquisaNomeKeyPressed

    /*
     * método que refaz a tabela sempre que o usuário tecla no campo de pesquisa
     */
    private void tfPesquisaNomeKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_tfPesquisaNomeKeyReleased
        tabelaMateriais.setModel(controller.preencherTabelaParametroNome(dao, tfPesquisaNome.getText()));
        esquemaConsulta();
    }//GEN-LAST:event_tfPesquisaNomeKeyReleased

    private void tabelaMateriaisMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tabelaMateriaisMouseClicked
        esquemaConsultaSelecao();
    }//GEN-LAST:event_tabelaMateriaisMouseClicked

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
            java.util.logging.Logger.getLogger(TelaCategoria.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(TelaCategoria.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(TelaCategoria.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(TelaCategoria.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */

        java.awt.EventQueue.invokeLater(new Runnable() {

            public void run() {
                new TelaMateriais().setVisible(true);
            }
        });
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btAlterar;
    private javax.swing.JButton btCadastrar;
    private javax.swing.JButton btExcluir;
    private javax.swing.JButton btSalvar;
    private javax.swing.JButton btVoltar;
    private javax.swing.JComboBox cbMat;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JLabel lbAtivo;
    private javax.swing.JLabel lbCategoria;
    private javax.swing.JLabel lbCodigo;
    private javax.swing.JLabel lbData;
    private javax.swing.JLabel lbDescricao;
    private javax.swing.JLabel lbMarca;
    private javax.swing.JLabel lbNome;
    private javax.swing.JLabel lbQuant;
    private javax.swing.JLabel lbQuantMin;
    private javax.swing.JLabel lbTipo;
    private javax.swing.JTabbedPane painelAbas;
    private javax.swing.JRadioButton rbAtivo;
    private javax.swing.JRadioButton rbInativo;
    private javax.swing.JRadioButton rbPacote;
    private javax.swing.JRadioButton rbUnitario;
    private javax.swing.ButtonGroup situacao;
    private javax.swing.JTextArea taDesc;
    private javax.swing.JTable tabelaMateriais;
    private javax.swing.JTextField tfCodigo;
    private javax.swing.JTextField tfDataCad;
    private javax.swing.JTextField tfMarca;
    private javax.swing.JTextField tfNome;
    private javax.swing.JTextField tfPesquisaNome;
    private javax.swing.JFormattedTextField tfQuantMin;
    private javax.swing.JFormattedTextField tfQuantidade;
    private javax.swing.ButtonGroup tipoItem;
    // End of variables declaration//GEN-END:variables
}
