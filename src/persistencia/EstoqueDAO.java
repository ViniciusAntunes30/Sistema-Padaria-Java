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
//import java.util.logging.Level;;
//import java.util.logging.Logger;
import persistencia.ConFactory;
import negocio.Estoque;
import negocio.Venda;
import persistencia.IEstoque;

/**
 *
 * @author andregoro
 */
public class EstoqueDAO implements IEstoque {

    private Connection connection;

    public EstoqueDAO() {
        this.connection = new ConFactory().getConnection();
    }

    @Override
    public void adiciona(Estoque estoque) {
        String sql = "insert into Estoque(data_vencimento,quantidade,nomeProduto,codProduto,idFuncionario) value(?,?,?,?,?)";
        try {
            PreparedStatement stmt = connection.prepareStatement(sql);
            stmt.setDate(1, new Date(estoque.getData_vencimento().getTimeInMillis()));
            stmt.setInt(2, estoque.getQuantidade());
            stmt.setString(3, estoque.getNomeProduto());
            stmt.setString(4, estoque.getCodProduto());
            stmt.setInt(5, estoque.getIdFuncionario());

            stmt.execute();
            stmt.close();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public void altera(Estoque estoque) {
        String sql = "update Estoque set data_vencimento=? ,quantidade = ?, nomeProduto = ?, codProduto = ?,idFuncionario=? where idEstoque = ?";
        try (PreparedStatement preparedStatement = this.connection.prepareStatement(sql)) {
            preparedStatement.setDate(1, new Date(estoque.getData_vencimento().getTimeInMillis()));
            preparedStatement.setInt(2, estoque.getQuantidade());
            preparedStatement.setString(3, estoque.getNomeProduto());
            preparedStatement.setString(4, estoque.getCodProduto());
            preparedStatement.setInt(5, estoque.getIdFuncionario());
            preparedStatement.setInt(6, estoque.getIdEstoque());

            preparedStatement.execute();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void remove(int id) {
        String sql = "delete from Estoque where idEstoque= ?";
        try {
            PreparedStatement stmt = this.connection.prepareStatement(sql);
            stmt.setInt(1, id);
            stmt.execute();
        } catch (SQLException ex) {
            Logger.getLogger(EstoqueDAO.class.getName()).log(Level.SEVERE, null, ex);
            System.out.println("Erro");
        }
    }

    @Override
    public List<Estoque> listarTodos() {
        try {
            List<Estoque> estoqueL = new ArrayList<Estoque>();
            PreparedStatement stmt = this.connection.prepareStatement("select * from Estoque");
            ResultSet rs = stmt.executeQuery();

            while (rs.next()) {
                Estoque es = new Estoque();
                Calendar data = Calendar.getInstance();
                es.setCodProduto(rs.getString("codProduto"));
                data.setTime(rs.getDate("data_vencimento"));
                es.setData_vencimento(data);
                es.setIdEstoque(rs.getInt("idEstoque"));
                es.setNomeProduto(rs.getString("nomeProduto"));
                es.setIdFuncionario(rs.getInt("idFuncionario"));
                es.setQuantidade(rs.getInt("quantidade"));
                estoqueL.add(es);
            }
            rs.close();
            stmt.close();
            return estoqueL;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public Estoque getByID(int id) {
        String sql = "select * from Estoque where idEstoque=?";
        Estoque estoque = null;
        try (PreparedStatement stmt = this.connection.prepareStatement(sql)) {
            stmt.setInt(1, id);
            ResultSet result = stmt.executeQuery();
            if (result.next()) {
                estoque = new Estoque();
                Calendar data1 = Calendar.getInstance();
                data1.setTime(result.getDate("data_vencimento"));
                estoque.setData_vencimento(data1);

                estoque.setQuantidade(result.getInt("quantidade"));
                estoque.setCodProduto(result.getString("codProduto"));
                estoque.setNomeProduto(result.getString("nomeProduto"));
                // estoque.setIdFuncionario(result.getInt("idFuncionario"));
            }
            result.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return estoque;
    }

    @Override
    public List<Estoque> pesquisar(String nome) {
        List<Estoque> estoqueL = new ArrayList<Estoque>();
        try {
            String sql = "select * from estoque ";
            if (!nome.equals("")) {
                sql = sql + " where nomeProduto LIKE ? ";
            }
            PreparedStatement stmt = this.connection.prepareStatement(sql);
            if (!nome.equals("")) {
                stmt.setString(1, "%" + nome + "%");
            }
            ResultSet rs = stmt.executeQuery();
            while (rs.next()) {
                Estoque es = new Estoque();
                Calendar data = Calendar.getInstance();
                es.setCodProduto(rs.getString("codProduto"));
                data.setTime(rs.getDate("data_vencimento"));
                es.setData_vencimento(data);
                es.setIdEstoque(rs.getInt("idEstoque"));
                es.setNomeProduto(rs.getString("nomeProduto"));
                es.setIdFuncionario(rs.getInt("idFuncionario"));
                es.setQuantidade(rs.getInt("quantidade"));
                estoqueL.add(es);
            }
            rs.close();
            stmt.close();
            return estoqueL;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

}
