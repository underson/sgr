 /*
 * TelaFuncionario.java
 *
 * Created on 21/04/2012, 11:40:46
 */
package br.com.sca.frames;


import br.com.sca.controller.DepartamentoController;
import br.com.sca.entidades.Departamento;
import br.com.sca.persistencia.Dao;
import java.text.SimpleDateFormat;
import java.util.Date;
import javax.swing.JOptionPane;


/**
 *
 * @author
 * @since 
 * @version 1.0
 */
public class TelaDepartamento extends javax.swing.JFrame {

    private DepartamentoController controller;
    private Departamento departamento;
    private Dao dao;

    public TelaDepartamento() {
        initComponents();
        dao = new Dao();
        inicializar();
    }
    /*
     * método para instanciar entidade e controller e preencher a tabela
     */

    private void inicializar() {
        controller = new DepartamentoController();
        tabelaDepartamento.setModel(controller.retornaModelTabelaCompleta(dao));
        departamento = new Departamento();
        esquemaConsulta();
        limparFormulario();
    }
    /*
     * método para limpar os campos de cadastro
     */

    private void limparFormulario() {
        tfCodigo.setText("");
        tfNome.setText("");
        textAreaDescricao.setText("");       
        
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
        tabelaDepartamento.clearSelection();
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

        btnGroupSituacao = new javax.swing.ButtonGroup();
        painelAbas = new javax.swing.JTabbedPane();
        painelConsulta = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tabelaDepartamento = new javax.swing.JTable();
        lbPesquisaNome = new javax.swing.JLabel();
        tfPesquisaNome = new javax.swing.JTextField();
        painelCadastro = new javax.swing.JPanel();
        painelComponentesCadastro = new javax.swing.JPanel();
        lbCodigo = new javax.swing.JLabel();
        lbNome = new javax.swing.JLabel();
        tfCodigo = new javax.swing.JTextField();
        tfNome = new javax.swing.JTextField();
        lbDescricao = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        textAreaDescricao = new javax.swing.JTextArea();
        tfDataCad = new javax.swing.JTextField();
        lbDataCad = new javax.swing.JLabel();
        lblSituacao = new javax.swing.JLabel();
        rbtAtivo = new javax.swing.JRadioButton();
        rbtInativo = new javax.swing.JRadioButton();
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

        tabelaDepartamento.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tabelaDepartamentoMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tabelaDepartamento);

        lbPesquisaNome.setText("Pesquisa por nome:");

        tfPesquisaNome.setText("Digite o nome do departamento");
        tfPesquisaNome.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tfPesquisaNomeActionPerformed(evt);
            }
        });
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
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 901, Short.MAX_VALUE)
                    .addGroup(painelConsultaLayout.createSequentialGroup()
                        .addComponent(lbPesquisaNome, javax.swing.GroupLayout.PREFERRED_SIZE, 126, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(tfPesquisaNome, javax.swing.GroupLayout.PREFERRED_SIZE, 273, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap(498, Short.MAX_VALUE))))
        );
        painelConsultaLayout.setVerticalGroup(
            painelConsultaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(painelConsultaLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(painelConsultaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lbPesquisaNome)
                    .addComponent(tfPesquisaNome, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 232, Short.MAX_VALUE)
                .addContainerGap())
        );

        painelAbas.addTab("Pesquisa", painelConsulta);

        lbCodigo.setText("Código:");

        lbNome.setText("Nome:");

        tfCodigo.setEditable(false);
        tfCodigo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tfCodigoActionPerformed(evt);
            }
        });

        tfNome.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tfNomeActionPerformed(evt);
            }
        });

        lbDescricao.setText("Descrição:");

        textAreaDescricao.setColumns(20);
        textAreaDescricao.setRows(5);
        jScrollPane2.setViewportView(textAreaDescricao);

        tfDataCad.setEditable(false);

        lbDataCad.setText("Data de Cadastro:");

        lblSituacao.setText("Situação:");

        btnGroupSituacao.add(rbtAtivo);
        rbtAtivo.setSelected(true);
        rbtAtivo.setText("Ativo");

        btnGroupSituacao.add(rbtInativo);
        rbtInativo.setText("Inativo");

        javax.swing.GroupLayout painelComponentesCadastroLayout = new javax.swing.GroupLayout(painelComponentesCadastro);
        painelComponentesCadastro.setLayout(painelComponentesCadastroLayout);
        painelComponentesCadastroLayout.setHorizontalGroup(
            painelComponentesCadastroLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(painelComponentesCadastroLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(painelComponentesCadastroLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(lblSituacao)
                    .addComponent(lbCodigo)
                    .addComponent(lbDescricao)
                    .addComponent(lbNome)
                    .addComponent(lbDataCad))
                .addGap(18, 18, 18)
                .addGroup(painelComponentesCadastroLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(painelComponentesCadastroLayout.createSequentialGroup()
                        .addComponent(rbtAtivo)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(rbtInativo))
                    .addComponent(tfNome, javax.swing.GroupLayout.PREFERRED_SIZE, 261, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(tfCodigo, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 410, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(tfDataCad, javax.swing.GroupLayout.PREFERRED_SIZE, 164, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(390, Short.MAX_VALUE))
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
                    .addComponent(lbNome)
                    .addComponent(tfNome, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(painelComponentesCadastroLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lbDescricao)
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 78, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(20, 20, 20)
                .addGroup(painelComponentesCadastroLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblSituacao)
                    .addComponent(rbtAtivo)
                    .addComponent(rbtInativo))
                .addGap(18, 18, 18)
                .addGroup(painelComponentesCadastroLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(tfDataCad, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lbDataCad))
                .addContainerGap(17, Short.MAX_VALUE))
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
                .addComponent(painelComponentesCadastro, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );

        painelAbas.addTab("Cadastro", painelCadastro);

        lbTitulo.setFont(new java.awt.Font("Times New Roman", 0, 24));
        lbTitulo.setText("DEPARTAMENTO");

        btCadastrar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/br/com/sca/imagem/novo_32x32.png"))); // NOI18N
        btCadastrar.setToolTipText("Cadastrar Departamento");
        btCadastrar.setBorderPainted(false);
        btCadastrar.setContentAreaFilled(false);
        btCadastrar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btCadastrarActionPerformed(evt);
            }
        });

        btAlterar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/br/com/sca/imagem/editar_32x32.png"))); // NOI18N
        btAlterar.setToolTipText("Alterar Departamento");
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
        btExcluir.setToolTipText("Excluir Departamento");
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
                        .addGap(73, 73, 73)
                        .addComponent(btSalvar))
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(painelAbas, javax.swing.GroupLayout.PREFERRED_SIZE, 916, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(lbTitulo)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(painelAbas, javax.swing.GroupLayout.DEFAULT_SIZE, 313, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(btVoltar, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 41, Short.MAX_VALUE)
                    .addComponent(btExcluir, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 41, Short.MAX_VALUE)
                    .addComponent(btAlterar, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 41, Short.MAX_VALUE)
                    .addComponent(btCadastrar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btSalvar))
                .addGap(20, 20, 20))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btCadastrarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btCadastrarActionPerformed
        departamento = new Departamento();
        limparFormulario();
        esquemaCadastro();
        // chama a aba de cadatro no painel
        painelAbas.setSelectedIndex(1);
    }//GEN-LAST:event_btCadastrarActionPerformed

    private void btAlterarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btAlterarActionPerformed
         //preenche os campos de cadastro com os dados do funcionário selecionado na tabela
        departamento = controller.retornarDepartamentoIndex(tabelaDepartamento.getSelectedRow());
        //rbtAtivo.setContentAreaFilled(departamento.isAtivoDept() == false? false : true);
        if(departamento.isAtivoDept()){
            rbtAtivo.setSelected(true);
        }else{
            rbtInativo.setSelected(true);
        }
        tfCodigo.setText(departamento.getIdDept().toString());
        tfNome.setText(departamento.getNomeDept());
        textAreaDescricao.setText(departamento.getDescDept());
        tfDataCad.setText(new SimpleDateFormat("E dd/MM/yyyy HH:mm:ss").format(departamento.getDtCadDept()));
        esquemaCadastro();
        // chama a aba de cadatro no painel
        painelAbas.setSelectedIndex(1);
    }//GEN-LAST:event_btAlterarActionPerformed

    private void btExcluirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btExcluirActionPerformed
        //pede a confirmação da exclusão
        int confirmacao = JOptionPane.showConfirmDialog(rootPane, "Este departamento será excluído permanentemente. Confirma a ação?");
        if (confirmacao == 0) {
            departamento = controller.retornarDepartamentoIndex(tabelaDepartamento.getSelectedRow());
            int resultado = controller.excluir(dao, departamento);
            // se a exclusão foi realizada com sucesso, exibe mensagem
            if (resultado == Dao.SUCESSO) {
                JOptionPane.showMessageDialog(rootPane, "Exclusão realizada com sucesso!");
                inicializar();
                limparPesquisa();
                // se o método excluir retorna o ERRO_1451, é porque o MySql lançou esse erro, o que significa que
                // um registro associado não permite a exclusão desse objeto. No caso do funcionário, quando esse erro
                // é lançado é porque há um almoxarife que é o funcionário que o usuário tentou excluir, e o banco não permitiu.
            } else if (resultado == Dao.ERRO_1451) {
                JOptionPane.showMessageDialog(rootPane, "Esse departamento não pode ser excluído pois ele possui funcionarios ou professores vinculados à ele!");
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
        if (tfPesquisaNome.getText().equals("Digite o nome do departamento")) {
            tfPesquisaNome.setText("");
        }
    }//GEN-LAST:event_tfPesquisaNomeKeyPressed
    /*
     * método que refaz a tabela sempre que o usuário tecla no campo de pesquisa
     */
    private void tfPesquisaNomeKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_tfPesquisaNomeKeyReleased
        tabelaDepartamento.setModel(controller.preencherTabelaParametroNome(dao, tfPesquisaNome.getText()));
        esquemaConsulta();
    }//GEN-LAST:event_tfPesquisaNomeKeyReleased
    /*
     * método que faz o objeto funcionário receber o funcionário selecionado na tabela, sempre
     * que o usuário clica com o mouse na tabela
     */
    private void tabelaDepartamentoMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tabelaDepartamentoMouseClicked
        esquemaConsultaSelecao();
    }//GEN-LAST:event_tabelaDepartamentoMouseClicked

    private void btSalvarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btSalvarActionPerformed
        departamento.setAtivoDept(rbtAtivo.isSelected() == true? true: false);
        
        // verifica se todos os campos obrigatórios estão preenchidos
        if (tfNome.getText().equals("")) {
            JOptionPane.showMessageDialog(null, "O nome do departamento é obrigatório!");
        } else {            
            departamento.setNomeDept(tfNome.getText());
            departamento.setDescDept(textAreaDescricao.getText());
            // se a chave primária do objeto é nula, é um novo registro. Nesse caso, pega a data do sistema
            // e seta no funcionário.
            if (departamento.getIdDept() == null) {
                Date data = new Date(System.currentTimeMillis());
                departamento.setDtCadDept(data);
            }
            if (controller.gravar(dao, departamento) == Dao.SUCESSO) {
                JOptionPane.showMessageDialog(null, "Departamento gravado com sucesso!");
            } else {
                JOptionPane.showMessageDialog(null, "Erro durante a operação!");
            }
            inicializar();
            // exibe aba de cadastro
            painelAbas.setSelectedIndex(0);
            limparPesquisa();
        }
    }//GEN-LAST:event_btSalvarActionPerformed

    private void tfPesquisaNomeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tfPesquisaNomeActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_tfPesquisaNomeActionPerformed

    private void tfCodigoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tfCodigoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_tfCodigoActionPerformed

    private void tfNomeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tfNomeActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_tfNomeActionPerformed
      
    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        java.awt.EventQueue.invokeLater(new Runnable() {

            public void run() {
                new TelaDepartamento().setVisible(true);
            }
        });
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btAlterar;
    private javax.swing.JButton btCadastrar;
    private javax.swing.JButton btExcluir;
    private javax.swing.JButton btSalvar;
    private javax.swing.JButton btVoltar;
    private javax.swing.ButtonGroup btnGroupSituacao;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JLabel lbCodigo;
    private javax.swing.JLabel lbDataCad;
    private javax.swing.JLabel lbDescricao;
    private javax.swing.JLabel lbNome;
    private javax.swing.JLabel lbPesquisaNome;
    private javax.swing.JLabel lbTitulo;
    private javax.swing.JLabel lblSituacao;
    private javax.swing.JTabbedPane painelAbas;
    private javax.swing.JPanel painelCadastro;
    private javax.swing.JPanel painelComponentesCadastro;
    private javax.swing.JPanel painelConsulta;
    private javax.swing.JRadioButton rbtAtivo;
    private javax.swing.JRadioButton rbtInativo;
    private javax.swing.JTable tabelaDepartamento;
    private javax.swing.JTextArea textAreaDescricao;
    private javax.swing.JTextField tfCodigo;
    private javax.swing.JTextField tfDataCad;
    private javax.swing.JTextField tfNome;
    private javax.swing.JTextField tfPesquisaNome;
    // End of variables declaration//GEN-END:variables
}
