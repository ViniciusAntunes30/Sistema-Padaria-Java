/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package persistencia;

/**
 *
 * @author andregoro
 */
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.DriverManager;

public class ConFactory {
    public Connection getConnection(){
        try{
            return DriverManager.getConnection("jdbc:mysql://localhost:3306/banco_padaria","root","");
        }catch(SQLException excecao){
            throw new RuntimeException(excecao);
        }
    }
}
