package com.fafica.aula10.exemplo;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Properties;

import com.fafica.aula02.cliente.Cliente;
/**
* Exemplo simples para conectar banco de dados MySql usando o MySQL JDBC driver thin
* Certifique-se de que você tem o MySql JDBC driver thin em seu classpath antes de executar este exemplo
* @Author
*/
public class ExemploOracleConsulta {
    public static void main(String args[]) throws SQLException {
    	
        // Cria a conexão com o banco de dados MySql usando o JDBC
        Connection conn = DriverManager
        		.getConnection("jdbc:oracle:thin:@192.168.43.59:1521:XE", "system", "root");
        
        /*
         * Exemplo de Consultar
         */
        // Criando a String SQL
        String sql ="select * from cliente";
        //String sql ="select * from cliente where cliente_id = ?";
        // Criar o PreparedStatement, objeto para executar a query
        PreparedStatement preStatement = conn.prepareStatement(sql);
        
        //preStatement.setInt(1, 2);
        // Executando o select
        ResultSet resultSet = preStatement.executeQuery();
        
        /*
         * Exemplo de Select
         */
        
        ArrayList<Cliente> lista = new ArrayList<Cliente>();
        
        //System.out.println("Imprimindo Dados do Banco");
        //System.out.println("ID\tID\tNome\t\tCPF");
        // Verifica se retornou dados na consulta
        while(resultSet.next()){
        	// Pegando as colunas do registro
        	/*System.out.print(resultSet.getString(1) 	+ "\t");
        	System.out.print(resultSet.getString("cliente_id") 	+ "\t");
        	System.out.print(resultSet.getString("nome") 	+ "\t");
        	System.out.print(resultSet.getString("cpf")	+ "\t");
        	System.out.println();*/
        	Cliente cliente = new Cliente(resultSet.getInt("cliente_id"), resultSet.getString("nome"), resultSet.getString("cpf"));
        	lista.add(cliente);
        }
        System.out.println(lista);
        // Fechando a Conexão
        preStatement.close();
        resultSet.close();
        conn.close();
    }
}