/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package persistencia;

import java.util.List;
import negocio.Venda;

/**
 *
 * @author andregoro
 */
public interface IVenda {

    public void adiciona(Venda venda);

    public void altera(Venda venda);

    public void remove(int id);

    public List<Venda> listarTodos();

    public Venda getByID(int id);

    public List<Venda> pesquisar(String nome);

}
