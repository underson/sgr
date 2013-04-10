/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package br.com.sca.controller;

import br.com.sca.entidades.Materiais;
import br.com.sca.entidades.MaterialCompra;
import br.com.sca.persistencia.Dao;
import java.util.List;

/**
 *
 * @author Anderson
 */
public class EstoqueController {
    Dao dao;

    public EstoqueController (){
        dao = new Dao();
    }

    public void adicionarQuantidadeDeMaterialAoEstoque(Materiais material, int quantidadeAAcrescentar){
        material.setQtdEstqMat(quantidadeAAcrescentar + material.getQtdEstqMat());
        dao.gravar(material);
    }

   

}
