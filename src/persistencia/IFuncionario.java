/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package persistencia;

import java.util.List;
import negocio.Funcionario;
import negocio.Venda;

/**
 *
 * @author andregoro
 */
public interface IFuncionario {

    public void adiciona(Funcionario sessao);

    public void altera(Funcionario sessao);

    public void remove(int id);

    public List<Funcionario> listarTodos();

    public Funcionario getByID(int id);

    public List<Funcionario> pesquisar(String nome);

}
