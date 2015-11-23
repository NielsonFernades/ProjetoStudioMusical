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
public class ExemploMySqlInsert {
    public static void main(String args[]) throws SQLException {
    	
        // Cria a conexão com o banco de dados MySql usando o JDBC
        Connection conn = DriverManager
        		.getConnection("jdbc:mysql://localhost/aula10", "root", "root");
        
        /*
         * Exemplo de Insert
         */
        // Criando a String SQL
        String sql ="insert into cliente (nome, cpf, banco) values (?, ?, ?)";
 
        // Criar o PreparedStatement, objeto para executar a query
        PreparedStatement preStatement = conn.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
        // Atualizando o primeiro parametro
        preStatement.setString(1, "Mauricio Manoel");
        preStatement.setString(2, "91376081779");
        preStatement.setString(3, "Bradesco");
        preStatement.execute();
        // Retorna um ResultSet com todas as chaves geradas
        ResultSet resultSet = preStatement.getGeneratedKeys();
        Integer clienteId = 0;
        // Pegando o identificador gerado a partir do último insert
        while(resultSet.next()) {
        	clienteId = resultSet.getInt(1);
        }
        System.out.println("ID do Insert no Banco " + clienteId);
        
        // Fechando conexões
        conn.close();
        preStatement.close();
        resultSet.close();
    }
}