package br.com.sca.relatorios;


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Date;
import javax.swing.JOptionPane;

/**
 * Classe para acesso e persistencia em banco.
 * @since Classe criada em 02/11/2011
 * @author Gregorio
 */

public class AcessaBD {

    Connection conexao = null;
    ResultSet resultado = null;

    //Construtor vazio
    public AcessaBD(){}
/*

    //Método para gravar dados na tabela info_detento na Base Controle_Prisional
    public boolean gravarDadosDetento(String nome, int idade, String cpf , String RG, String sexo, String codigo_penal, String data_entrada, String data_saida, String cela, String bloco, String visita_aberta) throws SQLException, ClassNotFoundException{
        //objeto que recebe clausulas SQL
        Statement comandos;
        int linhasAdicionadas;
        conexao = getConnection();
        comandos = conexao.createStatement();
        //INSERT INTO info_detento VALUES ('tx_nome','int_idade', 'tx_cpf', 'tx_rg', 'ao_sexo' ...)
        
        linhasAdicionadas = comandos.executeUpdate("INSERT INTO info_detentos VALUES ('"+nome+"',"
                                                                                        + "'"+idade+"',"
                                                                                            + "'"+cpf+"',"
                                                                                                + "'"+RG+"',"
                                                                                                    + "'"+sexo+"',"
                                                                                                        + "'"+codigo_penal+"',"
                                                                                                            + "'"+data_entrada+"',"
                                                                                                                + "'"+data_saida+"',"
                                                                                                                    + "'"+cela+"',"
                                                                                                                        + "'"+bloco+"',"
                                                                                                                            + "'"+visita_aberta+"')");
        if(linhasAdicionadas >0){
            JOptionPane.showMessageDialog(null,"Dados gravados com sucesso");
            return true;
        }
         else{
                JOptionPane.showMessageDialog(null, "Erro ao gravar dados!");
                return false;
        }
    }




    public boolean gravarDadosVisitante(String nome, String RG, String CPF, Integer idade, String dt_visita, String visitar_detento, String horario) throws SQLException, ClassNotFoundException{
        //objeto que recebe clausulas SQL
        Statement comandos;
        int linhasAdicionadas;
        conexao = getConnection();
        comandos = conexao.createStatement();

        //INSERT INTO info_detento VALUES ('tx_nome','tx_rg', 'int_idade', 'dt_visita', 'tx_visitar_detento' ...)
        linhasAdicionadas = comandos.executeUpdate("INSERT INTO info_visitante VALUES ('"+nome+"',"
                                                                                            + "'"+RG+"',"
                                                                                                + "'"+CPF+"',"
                                                                                                     + "'"+idade+"',"
                                                                                                         + "'"+dt_visita+"',"
                                                                                                                  + "'"+visitar_detento+"',"
                                                                                                                               + "'"+horario+"')");
        if(linhasAdicionadas >0){
            JOptionPane.showMessageDialog(null,"Dados gravados com sucesso");
            return true;
        }
         else{
                JOptionPane.showMessageDialog(null, "Erro ao gravar dados!");
                return false;
        }
    }

*/
      //Método para estabelecer conexãocom o BD
    public Connection getConnection()throws ClassNotFoundException, SQLException{
            Connection con;
            //driver de conexão
            Class.forName("com.mysql.jdbc.Driver");
            //parâmetros: localizaocao base "jdbc:mysql:localhost/controle_prisional", "login", "senha"
            con = DriverManager.getConnection("jdbc:mysql://localhost/sca", "root", "root");

        return con;
    }
}
