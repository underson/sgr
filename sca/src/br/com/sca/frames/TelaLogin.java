/*
 * Tela de login do sistema.
 * @author Gregório Araújo
 * @since 16/05/2012, 09:59:10
 */
package br.com.sca.frames;

import br.com.sca.entidades.Almoxarife;
import br.com.sca.entidades.Departamento;
import br.com.sca.entidades.Funcionario;
import br.com.sca.persistencia.Dao;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Date;
import java.util.List;
import javax.swing.JOptionPane;

/**
 *
 * @author Gregório
 */
public class TelaLogin extends javax.swing.JFrame {

    /** Creates new form TelaLogin */
    public TelaLogin() {
        initComponents();
    }
    Almoxarife almoxarife = new Almoxarife();

    private void efetuarLogin() {
         Connection conn;
        try {
            conn = DriverManager.getConnection("jdbc:mysql://localhost/sca?user=root&password=root");
            conn.close();
        } catch (SQLException ex) {
            System.out.println("erro pois o banco não existe------------------ ok");
            try {
                Connection connect = DriverManager.getConnection("jdbc:mysql://localhost/?user=root&password=root");
                Statement s = connect.createStatement();
                s.executeUpdate("CREATE DATABASE sca;");
                Dao dao = new Dao(); // criar as tabelas
                Almoxarife alm = new Almoxarife();
                alm.setLoginAlmoxarife("admin");
                alm.setSenhaAlmoxarife("admin");
                Funcionario func = new Funcionario();
                func.setNomeFunc("Administrador");
                func.setDtCadFunc(new Date(System.currentTimeMillis()));
                Departamento dept = new Departamento();
                dept.setNomeDept("Administrador");
                dept.setDtCadDept(new Date(System.currentTimeMillis()));
                dao.gravar(dept);
                func.setDepaartamento(new Departamento(1));
                dao.gravar(func);
                alm.setFuncionario(new Funcionario(1));
                alm.setSupervisorAlmoxarife(true);
                dao.gravar(alm);
            } catch (SQLException e) {
                System.out.println("erro ao criar o banco-------------------");
            }
        }
        Dao dao = new Dao();
        List<Almoxarife> almoxarifes;
        almoxarifes = dao.pesquisar("Almoxarife.findBySenhaLogin", new Object[]{new String(ptfSenha.getPassword()), tfUsuario.getText()});
        if (almoxarifes.isEmpty()) {
            JOptionPane.showMessageDialog(null, "Usuário ou senha incorreto.");
        } else {
            almoxarife = (Almoxarife) almoxarifes.get(0);
            tela.setVisible(false);
            TelaPrincipal telaPrincipal = new TelaPrincipal(almoxarife);
            telaPrincipal.setVisible(true);
        }
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        lbTitulo = new javax.swing.JLabel();
        lbUsuario = new javax.swing.JLabel();
        lbSenha = new javax.swing.JLabel();
        tfUsuario = new javax.swing.JTextField();
        ptfSenha = new javax.swing.JPasswordField();
        btEntrar = new javax.swing.JButton();
        btSair = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Bem vindo!");
        setBounds(new java.awt.Rectangle(500, 250, 0, 0));
        setResizable(false);

        lbTitulo.setFont(new java.awt.Font("Arial", 0, 18));
        lbTitulo.setText("Sistema de Controle de Almoxarifado");

        lbUsuario.setFont(new java.awt.Font("Tahoma", 0, 14));
        lbUsuario.setText("Usuário");

        lbSenha.setFont(new java.awt.Font("Tahoma", 0, 14));
        lbSenha.setText("Senha");

        btEntrar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/br/com/sca/imagem/login_32x32.png"))); // NOI18N
        btEntrar.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));
        btEntrar.setBorderPainted(false);
        btEntrar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btEntrarActionPerformed(evt);
            }
        });

        btSair.setIcon(new javax.swing.ImageIcon(getClass().getResource("/br/com/sca/imagem/cancelar_32x32.png"))); // NOI18N
        btSair.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));
        btSair.setBorderPainted(false);
        btSair.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btSairActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(lbTitulo)
                .addContainerGap())
            .addGroup(layout.createSequentialGroup()
                .addGap(62, 62, 62)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(btSair)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 120, Short.MAX_VALUE)
                        .addComponent(btEntrar))
                    .addComponent(lbSenha)
                    .addComponent(lbUsuario)
                    .addComponent(tfUsuario, javax.swing.GroupLayout.DEFAULT_SIZE, 190, Short.MAX_VALUE)
                    .addComponent(ptfSenha, javax.swing.GroupLayout.DEFAULT_SIZE, 190, Short.MAX_VALUE))
                .addGap(62, 62, 62))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(lbTitulo, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(lbUsuario)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(tfUsuario, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(1, 1, 1)
                .addComponent(lbSenha)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(ptfSenha, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btEntrar)
                    .addComponent(btSair))
                .addContainerGap(27, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btEntrarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btEntrarActionPerformed
        efetuarLogin();
    }//GEN-LAST:event_btEntrarActionPerformed

    private void btSairActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btSairActionPerformed
        System.exit(0);
    }//GEN-LAST:event_btSairActionPerformed
    /**
     * @param args the command line arguments
     */
    static TelaLogin tela = new TelaLogin();

    public static void main(String args[]) {

                //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Windows".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(TelaLogin.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(TelaLogin.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(TelaLogin.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(TelaLogin.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
     /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Windows".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(TelaLogin.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(TelaLogin.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(TelaLogin.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(TelaLogin.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>


        java.awt.EventQueue.invokeLater(new Runnable() {

            public void run() {

                tela.setVisible(true);
            }
        });
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btEntrar;
    private javax.swing.JButton btSair;
    private javax.swing.JLabel lbSenha;
    private javax.swing.JLabel lbTitulo;
    private javax.swing.JLabel lbUsuario;
    private javax.swing.JPasswordField ptfSenha;
    private javax.swing.JTextField tfUsuario;
    // End of variables declaration//GEN-END:variables
}
