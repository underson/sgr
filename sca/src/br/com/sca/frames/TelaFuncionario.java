 /*
 * TelaFuncionario.java
 *
 * Created on 21/04/2012, 11:40:46
 */
package br.com.sca.frames;

import br.com.sca.controller.FuncionarioController;
import br.com.sca.entidades.Departamento;
import br.com.sca.entidades.Funcionario;
import br.com.sca.persistencia.Dao;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import javax.swing.JOptionPane;

/**
 *
 * @author
 * @since 
 * @version 1.0
 */
public class TelaFuncionario extends javax.swing.JFrame {

    private FuncionarioController controller;
    private Funcionario funcionario;
    private Dao dao;
    public List<Departamento> listaDepto;

    public TelaFuncionario() {
        initComponents();
        dao = new Dao();
        inicializar();
    }
    /*
     * método para instanciar entidade e controller e preencher a tabela
     */

    private void inicializar() {
        controller = new FuncionarioController();
        tabelaFuncionario.setModel(controller.retornaModelTabelaCompleta(dao));
        funcionario = new Funcionario();
        esquemaConsulta();
        limparFormulario();
        

    }
    /*
     * método para limpar os campos de cadastro
     */

    private void limparFormulario() {
        tfCodigo.setText("");
        ftfCpf.setText("");
        tfNome.setText("");
        tfDataCad.setText("");
    }
    /*
     * método para deixar os botões de ação na configuração da aba de consulta
     */
     public void preencherCbDepto(){
        listaDepto = dao.pesquisar("Departamento.findAll");
        cbDepto.removeAllItems();
        for (Departamento depto : listaDepto) {
            String aux = depto.getIdDept() + " - " + depto.getNomeDept();

            cbDepto.addItem(aux);
        }
     }

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
        preencherCbDepto();
        tabelaFuncionario.clearSelection();
        btCadastrar.setEnabled(false);
        btAlterar.setEnabled(false);
        btExcluir.setEnabled(false);
        btVoltar.setVisible(true);
        btSalvar.setVisible(true);
        tfDataCad.setText(new SimpleDateFormat("E dd/MM/yyyy HH:mm:ss").format(System.currentTimeMillis()));
    }

    private void limparPesquisa() {
        tfPesquisaNome.setText("");
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        bgSituacao = new javax.swing.ButtonGroup();
        painelAbas = new javax.swing.JTabbedPane();
        painelConsulta = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tabelaFuncionario = new javax.swing.JTable();
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
        lbDepto = new javax.swing.JLabel();
        cbDepto = new javax.swing.JComboBox();
        lbAtivo = new javax.swing.JLabel();
        rbAtivo = new javax.swing.JRadioButton();
        rbInativo = new javax.swing.JRadioButton();
        ftfCpf = new javax.swing.JFormattedTextField();
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

        tabelaFuncionario.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tabelaFuncionarioMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tabelaFuncionario);

        lbPesquisaNome.setText("Pesquisa por nome:");

        tfPesquisaNome.setText("Digite o nome do funcionário");
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
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 922, Short.MAX_VALUE)
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

        lbCodigo.setText("Código:");

        lbCpf.setText("Cpf:");

        lbNome.setText("Nome:");

        lbDataCad.setText("Data de Cadastro:");

        tfCodigo.setEditable(false);

        tfDataCad.setEditable(false);

        lbDepto.setText("Departamento:");

        lbAtivo.setText("Situação:");

        bgSituacao.add(rbAtivo);
        rbAtivo.setText("Ativo");

        bgSituacao.add(rbInativo);
        rbInativo.setText("Inativo");

        try {
            ftfCpf.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.MaskFormatter("###.###.###-##")));
        } catch (java.text.ParseException ex) {
            ex.printStackTrace();
        }

        javax.swing.GroupLayout painelComponentesCadastroLayout = new javax.swing.GroupLayout(painelComponentesCadastro);
        painelComponentesCadastro.setLayout(painelComponentesCadastroLayout);
        painelComponentesCadastroLayout.setHorizontalGroup(
            painelComponentesCadastroLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(painelComponentesCadastroLayout.createSequentialGroup()
                .addGap(14, 14, 14)
                .addGroup(painelComponentesCadastroLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(lbAtivo)
                    .addComponent(lbDepto)
                    .addComponent(lbCpf)
                    .addComponent(lbDataCad)
                    .addComponent(lbNome)
                    .addComponent(lbCodigo))
                .addGap(18, 18, 18)
                .addGroup(painelComponentesCadastroLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(tfCodigo, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(cbDepto, javax.swing.GroupLayout.PREFERRED_SIZE, 102, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(tfDataCad, javax.swing.GroupLayout.DEFAULT_SIZE, 239, Short.MAX_VALUE)
                    .addComponent(tfNome)
                    .addGroup(painelComponentesCadastroLayout.createSequentialGroup()
                        .addComponent(rbAtivo)
                        .addGap(18, 18, 18)
                        .addComponent(rbInativo))
                    .addComponent(ftfCpf))
                .addGap(491, 491, 491))
        );
        painelComponentesCadastroLayout.setVerticalGroup(
            painelComponentesCadastroLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(painelComponentesCadastroLayout.createSequentialGroup()
                .addGap(46, 46, 46)
                .addGroup(painelComponentesCadastroLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(tfCodigo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lbCodigo))
                .addGap(18, 18, 18)
                .addGroup(painelComponentesCadastroLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(tfNome, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lbNome))
                .addGap(18, 18, 18)
                .addGroup(painelComponentesCadastroLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lbCpf)
                    .addComponent(ftfCpf, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(painelComponentesCadastroLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(tfDataCad, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lbDataCad))
                .addGap(18, 18, 18)
                .addGroup(painelComponentesCadastroLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lbDepto)
                    .addComponent(cbDepto, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(painelComponentesCadastroLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lbAtivo)
                    .addComponent(rbAtivo)
                    .addComponent(rbInativo))
                .addContainerGap(72, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout painelCadastroLayout = new javax.swing.GroupLayout(painelCadastro);
        painelCadastro.setLayout(painelCadastroLayout);
        painelCadastroLayout.setHorizontalGroup(
            painelCadastroLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(painelCadastroLayout.createSequentialGroup()
                .addGap(66, 66, 66)
                .addComponent(painelComponentesCadastro, javax.swing.GroupLayout.PREFERRED_SIZE, 851, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(25, Short.MAX_VALUE))
        );
        painelCadastroLayout.setVerticalGroup(
            painelCadastroLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(painelCadastroLayout.createSequentialGroup()
                .addGap(38, 38, 38)
                .addComponent(painelComponentesCadastro, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        painelAbas.addTab("Cadastro", painelCadastro);

        lbTitulo.setFont(new java.awt.Font("Times New Roman", 0, 24));
        lbTitulo.setText("FUNCIONÁRIO");

        btCadastrar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/br/com/sca/imagem/novo_32x32.png"))); // NOI18N
        btCadastrar.setToolTipText("Cadastrar Novo");
        btCadastrar.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));
        btCadastrar.setBorderPainted(false);
        btCadastrar.setContentAreaFilled(false);
        btCadastrar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btCadastrarActionPerformed(evt);
            }
        });

        btAlterar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/br/com/sca/imagem/editar_32x32.png"))); // NOI18N
        btAlterar.setToolTipText("Editar Funcionário");
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
        btVoltar.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));
        btVoltar.setBorderPainted(false);
        btVoltar.setContentAreaFilled(false);
        btVoltar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btVoltarActionPerformed(evt);
            }
        });

        btExcluir.setIcon(new javax.swing.ImageIcon(getClass().getResource("/br/com/sca/imagem/delete_32x32.png"))); // NOI18N
        btExcluir.setToolTipText("Excluir Funcionário");
        btExcluir.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));
        btExcluir.setBorderPainted(false);
        btExcluir.setContentAreaFilled(false);
        btExcluir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btExcluirActionPerformed(evt);
            }
        });

        btSalvar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/br/com/sca/imagem/salvar_32x32.png"))); // NOI18N
        btSalvar.setToolTipText("Salvar");
        btSalvar.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));
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
                        .addGap(400, 400, 400)
                        .addComponent(lbTitulo))
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(btCadastrar, javax.swing.GroupLayout.PREFERRED_SIZE, 47, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(16, 16, 16)
                                .addComponent(btAlterar, javax.swing.GroupLayout.PREFERRED_SIZE, 56, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(btExcluir, javax.swing.GroupLayout.PREFERRED_SIZE, 51, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(btVoltar, javax.swing.GroupLayout.PREFERRED_SIZE, 62, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(75, 75, 75)
                                .addComponent(btSalvar, javax.swing.GroupLayout.PREFERRED_SIZE, 47, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(painelAbas, javax.swing.GroupLayout.DEFAULT_SIZE, 947, Short.MAX_VALUE))))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(lbTitulo)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(painelAbas, javax.swing.GroupLayout.PREFERRED_SIZE, 405, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(btAlterar, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 43, Short.MAX_VALUE)
                    .addComponent(btCadastrar, javax.swing.GroupLayout.DEFAULT_SIZE, 43, Short.MAX_VALUE)
                    .addComponent(btSalvar, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 43, Short.MAX_VALUE)
                    .addComponent(btExcluir, javax.swing.GroupLayout.DEFAULT_SIZE, 43, Short.MAX_VALUE)
                    .addComponent(btVoltar, javax.swing.GroupLayout.DEFAULT_SIZE, 43, Short.MAX_VALUE))
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btCadastrarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btCadastrarActionPerformed
        limparFormulario();
        esquemaCadastro();
        rbAtivo.setSelected(true);





        // chama a aba de cadatro no painel
        painelAbas.setSelectedIndex(1);
        /*
         *
         *
         * Errado na versão 1.0
         *
         */
        funcionario = new Funcionario();
        /*
         *
         *
         * Errado na versão 1.0
         *
         */
    }//GEN-LAST:event_btCadastrarActionPerformed

    private void btAlterarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btAlterarActionPerformed
        //preenche os campos de cadastro com os dados do funcionário selecionado na tabela
        funcionario = controller.retornarFuncionarioIndex(tabelaFuncionario.getSelectedRow());
        if (funcionario.isAtivoFunc() == true) {
            rbAtivo.setSelected(true);
            rbInativo.setSelected(false);
        } else if (funcionario.isAtivoFunc() == false) {
            rbInativo.setSelected(true);
            rbAtivo.setSelected(false);
        }
        tfCodigo.setText(funcionario.getIdFunc().toString());
        ftfCpf.setText(funcionario.getCpfFunc());
        tfNome.setText(funcionario.getNomeFunc());
        tfDataCad.setText(new SimpleDateFormat("E dd/MM/yyyy HH:mm:ss").format(funcionario.getDtCadFunc()));
        esquemaCadastro();
        Departamento depto = new Departamento();
        depto = funcionario.getDepartamento();
        int x = listaDepto.indexOf(depto);
        cbDepto.setSelectedIndex(x);
        // chama a aba de cadatro no painel
        painelAbas.setSelectedIndex(1);
    }//GEN-LAST:event_btAlterarActionPerformed

    private void btExcluirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btExcluirActionPerformed
        //pede a confirmação da exclusão
        int confirmacao = JOptionPane.showConfirmDialog(rootPane, "Este funcionário será excluído permanentemente. Confirma a ação?");
        if (confirmacao == 0) {
            funcionario = controller.retornarFuncionarioIndex(tabelaFuncionario.getSelectedRow());
            int resultado = controller.excluir(dao, funcionario);
            // se a exclusão foi realizada com sucesso, exibe mensagem
            if (resultado == Dao.SUCESSO) {
                JOptionPane.showMessageDialog(rootPane, "Exclusão realizada com sucesso!");
                inicializar();
                limparPesquisa();
                // se o método excluir retorna o ERRO_1451, é porque o MySql lançou esse erro, o que significa que
                // um registro associado não permite a exclusão desse objeto. No caso do funcionário, quando esse erro
                // é lançado é porque há um almoxarife que é o funcionário que o usuário tentou excluir, e o banco não permitiu.
            } else if (resultado == Dao.ERRO_1451) {
                JOptionPane.showMessageDialog(rootPane, "Esse funcionário não pode ser excluído pois ele é um almoxarife!");
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
        if (tfPesquisaNome.getText().equals("Digite o nome do funcionário")) {
            tfPesquisaNome.setText("");
        }
    }//GEN-LAST:event_tfPesquisaNomeKeyPressed
    /*
     * método que refaz a tabela sempre que o usuário tecla no campo de pesquisa
     */
    private void tfPesquisaNomeKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_tfPesquisaNomeKeyReleased
        tabelaFuncionario.setModel(controller.preencherTabelaParametroNome(dao, tfPesquisaNome.getText()));
        esquemaConsulta();
    }//GEN-LAST:event_tfPesquisaNomeKeyReleased
    /*
     * método que faz o objeto funcionário receber o funcionário selecionado na tabela, sempre
     * que o usuário clica com o mouse na tabela
     */
    private void tabelaFuncionarioMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tabelaFuncionarioMouseClicked
        esquemaConsultaSelecao();
    }//GEN-LAST:event_tabelaFuncionarioMouseClicked

    private void btSalvarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btSalvarActionPerformed
        // verifica se todos os campos obrigatórios estão preenchidos
        listaDepto = dao.pesquisar("Departamento.findAll");

        String[] cod = null;
        String c = (String) cbDepto.getSelectedItem();
        cod = c.split(" - ");
        int aux = Integer.parseInt(cod[0].toString());
        Departamento dep = new Departamento();
        listaDepto = dao.pesquisar("Departamento.findByIdDept", new Object[]{aux});
        dep = listaDepto.get(0);

        funcionario.setDepaartamento(dep);

        if (rbAtivo.isSelected() == true) {
            funcionario.setAtivoFunc(true);
        } else if (rbInativo.isSelected() == true) {
            funcionario.setAtivoFunc(false);
        }
        
        if (tfNome.getText().equals("")) {
            JOptionPane.showMessageDialog(null, "O nome do funcionário é obrigatório!");
        } else if (ftfCpf.getText().equals("   .   .   -  ")) {
            JOptionPane.showMessageDialog(null, "O CPF do funcionário é obrigatório!");
        } else {
            funcionario.setCpfFunc(ftfCpf.getText());
            funcionario.setNomeFunc(tfNome.getText());
            
            // se a chave primária do objeto é nula, é um novo registro. Nesse caso, pega a data do sistema
            // e seta no funcionário.
            if (funcionario.getIdFunc() == null) {
                Date data = new Date(System.currentTimeMillis());
                funcionario.setDtCadFunc(data);
            }
            if (controller.gravar(dao, funcionario) == Dao.SUCESSO) {
                JOptionPane.showMessageDialog(null, "Funcionário gravado com sucesso!");
            } else {
                JOptionPane.showMessageDialog(null, "Erro durante a operação!");
            }
            inicializar();
            // exibe aba de cadastro
            painelAbas.setSelectedIndex(0);
            limparPesquisa();
        }
    }//GEN-LAST:event_btSalvarActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        java.awt.EventQueue.invokeLater(new Runnable() {

            public void run() {
                new TelaFuncionario().setVisible(true);
            }
        });
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.ButtonGroup bgSituacao;
    private javax.swing.JButton btAlterar;
    private javax.swing.JButton btCadastrar;
    private javax.swing.JButton btExcluir;
    private javax.swing.JButton btSalvar;
    private javax.swing.JButton btVoltar;
    private javax.swing.JComboBox cbDepto;
    private javax.swing.JFormattedTextField ftfCpf;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel lbAtivo;
    private javax.swing.JLabel lbCodigo;
    private javax.swing.JLabel lbCpf;
    private javax.swing.JLabel lbDataCad;
    private javax.swing.JLabel lbDepto;
    private javax.swing.JLabel lbNome;
    private javax.swing.JLabel lbPesquisaNome;
    private javax.swing.JLabel lbTitulo;
    private javax.swing.JTabbedPane painelAbas;
    private javax.swing.JPanel painelCadastro;
    private javax.swing.JPanel painelComponentesCadastro;
    private javax.swing.JPanel painelConsulta;
    private javax.swing.JRadioButton rbAtivo;
    private javax.swing.JRadioButton rbInativo;
    private javax.swing.JTable tabelaFuncionario;
    private javax.swing.JTextField tfCodigo;
    private javax.swing.JTextField tfDataCad;
    private javax.swing.JTextField tfNome;
    private javax.swing.JTextField tfPesquisaNome;
    // End of variables declaration//GEN-END:variables
}
