/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package persistencia;

import java.sql.Connection;
import java.sql.Date;
import java.util.*;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import persistencia.ConFactory;

import persistencia.IVenda;
import negocio.Venda;

/**
 *
 * @author andregoro
 */
public class VendaDAO implements IVenda {

    private Connection connection;

    public VendaDAO() {
        this.connection = new ConFactory().getConnection();
    }

    @Override
    public void adiciona(Venda venda) {
        String sql = "insert into vendas(quantidade,valor,Data,idfuncionario,idestoque) values (?,?,?,?,?)";
        PreparedStatement stmt;
        try {
            stmt = connection.prepareStatement(sql);
            stmt.setInt(1, venda.getQuantidade());
            stmt.setDouble(2, venda.getValor());
            stmt.setDate(3, new Date(venda.getData().getTimeInMillis()));
            stmt.setInt(4, venda.getIdFuncionario());
            stmt.setInt(5, venda.getIdEstoque());
            stmt.execute();
            stmt.close();

        } catch (SQLException ex) {
            Logger.getLogger(VendaDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public void altera(Venda venda) {
        String sql = "update vendas set quantidade = ?, valor = ?, Data = ?,idFuncionario=?,idEstoque=? where idVendas = ?";
        try (PreparedStatement preparedStatement = this.connection.prepareStatement(sql)) {
            preparedStatement.setInt(1, venda.getQuantidade());
            preparedStatement.setDouble(2, venda.getValor());
            preparedStatement.setDate(3, new Date(venda.getData().getTimeInMillis()));
            preparedStatement.setInt(4, venda.getIdFuncionario());
            preparedStatement.setInt(5, venda.getIdEstoque());
            preparedStatement.setInt(6, venda.getIdVendas());
            preparedStatement.execute();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void remove(int id) {
        String sql = "delete from Vendas where idVendas= ?";
        try {
            PreparedStatement stmt = this.connection.prepareStatement(sql);
            stmt.setInt(1, id);
            stmt.execute();
        } catch (SQLException ex) {
            Logger.getLogger(VendaDAO.class.getName()).log(Level.SEVERE, null, ex);
            System.out.println("Erro");
        }
    }

    @Override
    public List<Venda> listarTodos() {
        List<Venda> VendaL = new ArrayList<>();
        try {
            PreparedStatement stmt = this.connection.prepareStatement("select * from vendas");
            ResultSet rs = stmt.executeQuery();

            while (rs.next()) {
                Venda vd = new Venda();
                Calendar data = Calendar.getInstance();

                vd.setIdVendas(rs.getInt("idVendas"));
                vd.setValor(rs.getDouble("valor"));

                data.setTime(rs.getDate("Data"));
                vd.setData(data);

                vd.setIdEstoque(rs.getInt("idEstoque"));

                vd.setQuantidade(rs.getInt("quantidade"));

                vd.setIdFuncionario(rs.getInt("idFuncionario"));
                VendaL.add(vd);
            }
            rs.close();
            stmt.close();
            return VendaL;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public Venda getByID(int id) {
        String sql = "select * from Vendas where idVendas=?";
        Venda venda = null;
        try (PreparedStatement stmt = this.connection.prepareStatement(sql)) {
            stmt.setInt(1, id);
            ResultSet result = stmt.executeQuery();
            if (result.next()) {
                venda = new Venda();
                venda.setQuantidade(result.getInt(2));
                venda.setValor(result.getDouble(3));
////////////////////////////////////////////////////////////
                Calendar data1 = Calendar.getInstance();
                data1.setTime(result.getDate("Data"));
                venda.setData(data1);

                SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
                String data = sdf.format(venda.getData().getTime());
//                 System.out.println(venda.getQuantidade()+" "+data);

            }
            result.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return venda;
    }

    @Override
    public List<Venda> pesquisar(String nome) {
        List<Venda> VendaL = new ArrayList<>();
        try {
            String sql = "select * from Vendas ";
            if (!nome.equals("")) {
                sql = sql + " where idVendas LIKE ? ";
            }
            PreparedStatement stmt = this.connection.prepareStatement(sql);
            if (!nome.equals("")) {
                stmt.setString(1, "%" + nome + "%");
            }
            ResultSet rs = stmt.executeQuery();

            while (rs.next()) {
                Venda vd = new Venda();
                Calendar data = Calendar.getInstance();

                vd.setValor(rs.getDouble("valor"));

                data.setTime(rs.getDate("Data"));
                vd.setData(data);

                vd.setIdEstoque(rs.getInt("idEstoque"));

                vd.setQuantidade(rs.getInt("quantidade"));

                vd.setIdVendas(rs.getInt("idVendas"));

                vd.setIdFuncionario(rs.getInt("idFuncionario"));
                VendaL.add(vd);
            }
            rs.close();
            stmt.close();
            return VendaL;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;

    }

}
