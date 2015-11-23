package com.fafica.aula10.exemplo;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Properties;
/**
* Exemplo simples para conectar banco de dados MySql usando o MySQL JDBC driver thin
* Certifique-se de que você tem o MySql JDBC driver thin em seu classpath antes de executar este exemplo
* @Author
*/
public class ExemploMySqlAtualizar {
    public static void main(String args[]) throws SQLException {
    	
        // Cria a conexão com o banco de dados MySql usando o JDBC
        Connection conn = DriverManager
        		.getConnection("jdbc:mysql://localhost/aula10", "root", "root");
        
        /*
         * Exemplo de Atualizar
         */
        // Criando a String SQL
        String sql ="update cliente set nome = ? where cliente_id = ?";
        // Criar o PreparedStatement, objeto para executar a query
        PreparedStatement preStatement = conn.prepareStatement(sql);
        preStatement.setString(1, "Pedro");
        preStatement.setInt(2, 1);
        // Executando o select
        preStatement.executeUpdate();
        
        // Fechando a Conexão
        preStatement.close();
        conn.close();
    }
}