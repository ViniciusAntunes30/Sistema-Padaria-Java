/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package persistencia;

import java.util.List;
import negocio.Estoque;
import negocio.Venda;

/**
 *
 * @author andregoro
 */
public interface IEstoque {

    public void adiciona(Estoque estoque);

    public void altera(Estoque estoque);

    public void remove(int id);

    public List<Estoque> listarTodos();

    public Estoque getByID(int id);

    public List<Estoque> pesquisar(String nome);

}
