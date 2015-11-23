package main;

import java.io.IOException;
import java.sql.SQLException;

import endereco.Endereco;
import equalizador.Equalizador;
import excecoesEqualizadores.EqualizadorJaCadastradoException;
import excecoesEqualizadores.NomeVazioException;
import fachada.Fachada;

public class CadastrarEndereco {

	public static void main(String[] args) throws ClassNotFoundException, IOException, SQLException, NomeVazioException, EqualizadorJaCadastradoException {


		Fachada fachada = Fachada.getInstance();
		//Endereco endereco = new Endereco("rua", "bairro", "numero", "cep", "cidade");
			Equalizador equalizador1 = new Equalizador("nomeEqualizador", "1", "1", "1", "1");
	
		fachada.cadastrarEqualizador(equalizador1);
		
		System.out.println(equalizador1);
	}

}
