package br.com.sca.relatorios;


import com.mysql.jdbc.Connection;
import com.mysql.jdbc.Statement;
import java.io.*;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashMap;
import net.sf.jasperreports.engine.*;
import net.sf.jasperreports.engine.util.*;
import net.sf.jasperreports.view.JasperViewer;

/**
 * 
 * @since Classe criada em 02/12/2011
 * @author Gregorio
 */
public class Relatorio {    
    AcessaBD conexao = new AcessaBD();
    Connection con;
    ResultSet result;

    public Relatorio() throws SQLException, JRException{
        try{
            con = (Connection) conexao.getConnection();
            Statement comandos;
            comandos = (Statement) con.createStatement();
            result = comandos.executeQuery("SELECT * FROM *");
            JRResultSetDataSource jrRS = new JRResultSetDataSource(result);
            JasperPrint jasperPrint = JasperFillManager.fillReport("./materiais.jasper", new HashMap(), jrRS);
            JasperViewer.viewReport(jasperPrint, false);
        } catch (ClassNotFoundException ex) {
            System.out.println("Classe nao encontrada "+ ex.getMessage());
        }
    }
    public Relatorio(String sql, String aux) throws SQLException, JRException{
        try{
            con = (Connection) conexao.getConnection();
            Statement comandos;
            comandos = (Statement) con.createStatement();
            result = comandos.executeQuery(sql);
            JRResultSetDataSource jrRS = new JRResultSetDataSource(result);

            InputStream jasperFile = getClass().getResourceAsStream("/br/com/sca/relatorios/jasper/"+aux+".jasper");

            JasperReport jasperReport = (JasperReport) JRLoader.loadObject( jasperFile );

            JasperPrint relatorio = JasperFillManager.fillReport(jasperReport, new HashMap(), jrRS);



        //    JasperPrint jasperPrint = JasperFillManager.fillReport("relatorios/"+aux+".jasper", new HashMap(), jrRS);
            JasperViewer.viewReport(relatorio, false);
        } catch (ClassNotFoundException ex) {
            System.out.println("Classe nao encontrada "+ ex.getMessage());
        }
    }
    /*
    public static void main (String args[]) throws SQLException, JRException
    {
        Relatorio relatorio = new Relatorio("select * from materiais;", "materiais");
    }*/


}
