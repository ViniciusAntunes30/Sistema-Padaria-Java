/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package persistencia;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import persistencia.ConFactory;
import negocio.Funcionario;
import negocio.Venda;
import persistencia.IFuncionario;

/**
 *
 * @author andregoro
 */
public class FuncionarioDAO implements IFuncionario {

    private Connection connection;

    public FuncionarioDAO() {
        this.connection = new ConFactory().getConnection();
    }

    @Override
    public void adiciona(Funcionario funcionario) {

        String sql = "insert into Funcionario(nome,cpf,data_nascimento,sexo,endereco,telefone,cargo,data_cadastro,login,senha) value(?,?,?,?,?,?,?,now(),?,?)";
        try {
            PreparedStatement stmt = connection.prepareStatement(sql);
            stmt.setString(1, funcionario.getNome());
            stmt.setString(2, funcionario.getCpf());
            stmt.setDate(3, new Date(funcionario.getData_nascimento().getTimeInMillis()));
            stmt.setString(4, funcionario.getSexo());
            stmt.setString(5, funcionario.getEndereco());
            stmt.setString(6, funcionario.getTelefone());
            stmt.setString(7, funcionario.getCargo());
            stmt.setString(8, funcionario.getLogin());
            stmt.setString(9, funcionario.getSenha());
            stmt.execute();
            stmt.close();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public void altera(Funcionario funcionario) {
        String sql = "update funcionario set nome=? ,cpf=?, data_nascimento=?, sexo=?,endereco=?,cargo=?,data_cadastro=?,login=?,senha=?,telefone=?  where idFuncionario=?";
        try {
            PreparedStatement stmt = connection.prepareStatement(sql);
            stmt.setString(1, funcionario.getNome());
            stmt.setString(2, funcionario.getCpf());
            stmt.setDate(3, new Date(funcionario.getData_nascimento().getTimeInMillis()));
            stmt.setString(4, funcionario.getSexo());
            stmt.setString(5, funcionario.getEndereco());
            stmt.setString(6, funcionario.getCargo());
            stmt.setDate(7, new Date(funcionario.getData_cadastro().getTimeInMillis()));
            stmt.setString(8, funcionario.getLogin());;
            stmt.setString(9, funcionario.getSenha());
            stmt.setString(10, funcionario.getTelefone());
            stmt.setInt(11, funcionario.getIdFuncionario());
            stmt.execute();
            //stmt.close();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public void remove(int id) {
        String sql = "delete from Funcionario where idFuncionario= ?";
        try {
            PreparedStatement stmt = this.connection.prepareStatement(sql);
            stmt.setInt(1, id);
            stmt.execute();
            stmt.close();
        } catch (SQLException ex) {
            Logger.getLogger(VendaDAO.class.getName()).log(Level.SEVERE, null, ex);
            System.out.println("Erro");
        }
    }

    @Override
    public List<Funcionario> listarTodos() {
        String sql = "select * from funcionario";
        Funcionario funcionario = null;
        List<Funcionario> funcionarioL = new ArrayList<>();
        try (PreparedStatement stmt = this.connection.prepareStatement(sql); ResultSet result = stmt.executeQuery()) {

            while (result.next()) {
                funcionario = new Funcionario();
                funcionario.setIdFuncionario(result.getInt("idfuncionario"));
                funcionario.setNome(result.getString("nome"));
                funcionario.setCpf(result.getString("cpf"));

                Calendar data1 = Calendar.getInstance();
                data1.setTime(result.getDate("data_nascimento"));
                funcionario.setData_nascimento(data1);

                funcionario.setSexo(result.getString("sexo"));
                funcionario.setEndereco(result.getString("endereco"));
                funcionario.setCargo(result.getString("cargo"));

                data1.setTime(result.getDate("data_cadastro"));
                funcionario.setData_cadastro(data1);
                funcionario.setTelefone(result.getString("telefone"));
                funcionario.setLogin(result.getString("login"));
                funcionario.setSenha(result.getString("senha"));
                funcionarioL.add(funcionario);
                //               stmt.close();

            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return funcionarioL;
    }

    @Override
    public Funcionario getByID(int id) {
        String sql = "select * from funcionario where idFuncionario=?";
        Funcionario funcionario = null;
        try (PreparedStatement stmt = this.connection.prepareStatement(sql)) {
            stmt.setInt(1, id);
            ResultSet result = stmt.executeQuery();
            if (result.next()) {
                funcionario = new Funcionario();
                funcionario.setNome(result.getString("nome"));
                funcionario.setCpf(result.getString("cpf"));

                Calendar data1 = Calendar.getInstance();
                data1.setTime(result.getDate("data_nascimento"));
                funcionario.setData_nascimento(data1);

                funcionario.setSexo(result.getString("sexo"));
                funcionario.setEndereco(result.getString("endereco"));
                funcionario.setCargo(result.getString("cargo"));

                data1.setTime(result.getDate("data_cadastro"));
                //funcionario.setData_cadastro(data1);
                funcionario.setTelefone(result.getString("telefone"));
                funcionario.setLogin(result.getString("login"));
                funcionario.setSenha(result.getString("senha"));
////////////////////////////////////////////////////////////
                result.close();
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return funcionario;
    }

    @Override
    public List<Funcionario> pesquisar(String nome) {
        List<Funcionario> funcionarioL = new ArrayList<>();
        Funcionario funcionario = null;
        try {
            String sql = "select * from funcionario ";
            if (!nome.equals("")) {
                sql = sql + " where Nome LIKE ? ";
            }
            PreparedStatement stmt = this.connection.prepareStatement(sql);
            if (!nome.equals("")) {
                stmt.setString(1, "%" + nome + "%");
            }
            ResultSet result = stmt.executeQuery();

            while (result.next()) {
                funcionario = new Funcionario();
                funcionario.setIdFuncionario(result.getInt("idfuncionario"));
                funcionario.setNome(result.getString("nome"));
                funcionario.setCpf(result.getString("cpf"));

                Calendar data1 = Calendar.getInstance();
                data1.setTime(result.getDate("data_nascimento"));
                funcionario.setData_nascimento(data1);

                funcionario.setSexo(result.getString("sexo"));
                funcionario.setEndereco(result.getString("endereco"));
                funcionario.setCargo(result.getString("cargo"));

                data1.setTime(result.getDate("data_cadastro"));
                funcionario.setData_cadastro(data1);
                funcionario.setTelefone(result.getString("telefone"));
                funcionario.setLogin(result.getString("login"));
                funcionario.setSenha(result.getString("senha"));
                funcionarioL.add(funcionario);

            }
            result.close();
            stmt.close();
            return funcionarioL;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;

    }

}
