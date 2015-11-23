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
public class ExemploMySql2 {
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
        PreparedStatement preStatement = conn.prepareStatement(sql);
        // Atualizando o primeiro parametro
        preStatement.setString(1, "Mauricio Manoel");
        preStatement.setString(2, "913.760.817-76");
        preStatement.setString(3, "Bradesco");
        preStatement.execute();
        ResultSet resultSet = preStatement.executeQuery();
        // Retorna um ResultSet com todas as chaves geradas
        resultSet = preStatement.getGeneratedKeys();
        // Retorna um ResultSet com todas as chaves geradas
        resultSet = preStatement.getGeneratedKeys();
        int clienteId = 0;
        // Pegando o identificador gerado a partir do último insert
        while(resultSet.next()) {
        	clienteId = resultSet.getInt(1);
        }
        System.out.println("ID do Insert no Banco " + clienteId);
        
        /*
        // Executando o select
        ResultSet resultSet = preStatement.executeQuery();
        
        /*
         * Exemplo de Select
         */
        
        System.out.println("Imprimindo Dados do Banco");
        System.out.println("ID\tID\tNome\t\tCPF\t\tIdade");
        // Verifica se retornou dados na consulta
        while(resultSet.next()){
        	// Pegando as colunas do registro
        	System.out.print(resultSet.getString(1) 	+ "\t");
        	System.out.print(resultSet.getString("cliente_id") 	+ "\t");
        	System.out.print(resultSet.getString("nome") 	+ "\t");
        	System.out.print(resultSet.getString("cpf")	+ "\t");
        	System.out.print(resultSet.getInt("idade"));
        	System.out.println();
        }
        // Fechando a Conexão
        preStatement.close();
        resultSet.close();
        System.exit(0);
        System.out.println();
        System.out.println();
        System.out.println("Inserindo Dados no Banco");
        
        // Montando insert no banco
        sql = "insert into cliente (nome, cpf, idade) values(?, ?, ?)";
        
        // Criando um Statement
        preStatement = conn.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
        preStatement.setString(1, "Maurício Manoel");
        preStatement.setString(2, "85891466121");
        preStatement.setInt(3, 35);
        preStatement.execute();
        /*
        // Retorna um ResultSet com todas as chaves geradas
        resultSet = preStatement.getGeneratedKeys();
        int clienteId = 0;
        // Pegando o identificador gerado a partir do último insert
        while(resultSet.next()) {
        	clienteId = resultSet.getInt(1);
        }
        System.out.println("ID do Insert no Banco " + clienteId);
        
        // Inserindo Endereco
        sql = "insert into endereco (cliente_id, logradouro, numero, bairro, cidade, estado) values(?, ?, ?, ?, ?, ?)";
        preStatement = conn.prepareStatement(sql);
        preStatement.setInt(1, clienteId);
        preStatement.setString(2, "Rua do Cravo");
        preStatement.setString(3, "51");
        preStatement.setString(4, "Caxanga");
        preStatement.setString(5, "Recife");
        preStatement.setString(6, "PE");
        preStatement.execute();
        
        preStatement.close();
        resultSet.close();
        
        sql ="update cliente set nome = ? where cliente_id = ?";
        // Criar o PreparedStatement, objeto para executar a query
        preStatement = conn.prepareStatement(sql);
        // Setando o valor do primeiro parametro
        preStatement.setString(1, "Maurício 'Coelho");
        preStatement.setInt(2, 1);
        // Executando o select
        preStatement.executeUpdate();

        sql ="select * from cliente where cliente_id > ?";
        // Criar o PreparedStatement, objeto para executar a query
        preStatement = conn.prepareStatement(sql);
        // Setando o valor do primeiro parametro
        preStatement.setInt(1, 2);
        // Executando o select
        resultSet = preStatement.executeQuery();
        
        System.out.println("ID\tID\tNome\t\tCPF\t\tIdade");
        // Verifica se retornou dados na consulta
        while(resultSet.next()){
        	// Pegando as colunas do registro
        	System.out.print(resultSet.getString(1) 	+ "\t");
        	System.out.print(resultSet.getString("cliente_id") 	+ "\t");
        	System.out.print(resultSet.getString("nome") 	+ "\t");
        	System.out.print(resultSet.getString("cpf")	+ "\t");
        	System.out.print(resultSet.getInt("idade"));
        	System.out.println();
        }
        */
        // Fechando conexões
        conn.close();
        preStatement.close();
        resultSet.close();
    }
}