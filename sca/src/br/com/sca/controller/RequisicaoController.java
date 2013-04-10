/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package br.com.sca.controller;

import br.com.sca.datamodel.MTReq;
import br.com.sca.datamodel.MTRequisicao;
import br.com.sca.datamodel.ModelTabelaRequisicoes;
import br.com.sca.entidades.Departamento;
import br.com.sca.entidades.Funcionario;
import br.com.sca.entidades.Materiais;
import br.com.sca.entidades.MaterialRequisicao;
import br.com.sca.entidades.Requisicao;
import br.com.sca.frames.TelaPrincipal;
import br.com.sca.persistencia.Dao;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 *
 * @author Gregório
 */
public class RequisicaoController {

    private List <MaterialRequisicao> material;
    private List <MaterialRequisicao> materialreq;
    private List <Materiais> materiais;
    private Dao dao;
    private Requisicao requisicao;
    private TelaPrincipal telaPrincipal;
    private List <Requisicao> requisicoes;
    private ArrayList<Requisicao> arrayReq;
    private ModelTabelaRequisicoes modelTabelaRequisicoes;
    private MTRequisicao mtReq;


    public MTRequisicao preencherTabelaParametroNome(Dao dao, String nome) {
        materiais = dao.pesquisar("Materiais.encontrarPorNomeLike", new Object[]{"%" + nome.toLowerCase() + "%"});
        material = new ArrayList<MaterialRequisicao>();
        for(Materiais m: materiais){
            MaterialRequisicao matr = new MaterialRequisicao();
            matr.setMateriais(m);
            material.add(matr);
        }


        return mtReq  = new MTRequisicao (material);
    }


    public Requisicao retornarRequisicaoIndex(int indice) {
        return (Requisicao) modelTabelaRequisicoes.getObjectAt(indice);
    }

    public RequisicaoController(TelaPrincipal telaPrincipal){
        this.telaPrincipal = telaPrincipal;
        requisicao = new Requisicao();
        materialreq = new ArrayList<MaterialRequisicao>();
        this.dao = new Dao();

    }

    public RequisicaoController(){

        requisicao = new Requisicao();
        materialreq = new ArrayList<MaterialRequisicao>();
        this.dao = new Dao();

    }

     public ModelTabelaRequisicoes retornaModelTabelaCompleta(Dao dao) {
        return modelTabelaRequisicoes = new ModelTabelaRequisicoes(pesquisarTodas(dao));
    }

   

    public MTRequisicao preencherTabelaMat(){
        materiais = dao.pesquisar("Materiais.encontrarTodosAtivos", new Object[]{true});
        material = new ArrayList<MaterialRequisicao>();
        for(Materiais mat : materiais){
            MaterialRequisicao matr = new MaterialRequisicao();
            matr.setMateriais(mat);
            material.add(matr);

        }
        return new MTRequisicao(material);
    }
    
     public MTRequisicao preencherTabelaMatEstorno(){
        materiais = dao.pesquisar("MaterialRequisicao.findByIdRequisicao", new Object[]{true});
        material = new ArrayList<MaterialRequisicao>();
        for(Materiais mat : materiais){
            MaterialRequisicao matr = new MaterialRequisicao();
            matr.setMateriais(mat);
            material.add(matr);

        }
        return new MTRequisicao(material);
    }
/*
    public List pesquisarMateriaisPorIdReq (Dao dao,int id){
        material = dao.pesquisar("MaterialRequisicao.findByIdRequisicao", new Object[]{id});
        return material;
    }
*/
    public MTRequisicao adicionarMat (MaterialRequisicao matr){
        material.add(matr);
        return new MTRequisicao(material);
    }

    public MTRequisicao removerMat (int matr){
        material.remove(matr);
        return new MTRequisicao(material);
    }

    public MTReq adicionarReq (MaterialRequisicao matr){
        materialreq.add(matr);
        return new MTReq(materialreq);
    }

    public MTReq removerReq (int matr){
        materialreq.remove(matr);
        return new MTReq(materialreq);
    }

    public void limparLista(){
        materialreq.clear();
    }

    public MaterialRequisicao getObjectIndex (int indice, MTRequisicao model){
        return (MaterialRequisicao) model.getObjectAt(indice);
    }

     public MaterialRequisicao getObjectIndex (int indice, MTReq model){
        return (MaterialRequisicao) model.getObjectAt(indice);
    }

        public boolean gravarRequisicao(List<MaterialRequisicao> listaMatReq, Funcionario funcionario, Departamento depto, String obs) {

            
        Requisicao requisicao1 = new Requisicao();                      
        requisicao1.setAlmoxarife(this.telaPrincipal.almoxarife);
        requisicao1.setDepartamento(depto);
        requisicao1.setFuncionario(funcionario);
        requisicao1.setDataReq(new Date(System.currentTimeMillis()));
        requisicao1 = (Requisicao) dao.gravarObjeto(requisicao1);
        for (MaterialRequisicao itemRequisicao : listaMatReq) {
            itemRequisicao.setRequisicao(requisicao1);
            System.out.println("entrou for");
            if (dao.gravar(itemRequisicao) != Dao.SUCESSO) {
                return false;
            } else {
                Materiais mat = new Materiais();


                mat = itemRequisicao.getMateriais();
                mat.setQtdEstqMat(mat.getQtdEstqMat()-itemRequisicao.getQtdMatreq());
                if(dao.gravar(mat)!= Dao.SUCESSO){
                    System.out.println("nao");
                    return false;
                }
            }
        }
        return true;
    }

    private List pesquisarTodas(Dao dao) {
        requisicoes = dao.pesquisar("Requisicao.findAll");
        return requisicoes;
    }

}
