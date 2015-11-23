/*
* IRepositorioCliente.java
* Versão: 1.0
* Data de Criação : 19/10/2015
* Nielson Vieira
*/

package equalizador;
import java.sql.SQLException;
import java.util.ArrayList;

import excecoesEqualizadores.EqualizadorJaCadastradoException;
import excecoesEqualizadores.EqualizadorNaoEncontradoException;
import excecoesEqualizadores.NomeVazioException;

public interface IRepositorioEqualizador {
	public void 		cadastrar	(Equalizador equalizador) 	throws SQLException, EqualizadorJaCadastradoException, NomeVazioException;
	public void 		atualizar	(Equalizador equalizador) 	throws SQLException, EqualizadorNaoEncontradoException;
	public void 		remover		(String nome) 				throws SQLException, EqualizadorNaoEncontradoException;
	public Equalizador 	procurar	(String nome) 				throws SQLException, EqualizadorNaoEncontradoException;
	public boolean 		existe		(String nome);
	
	public ArrayList<Equalizador> listar() 						throws SQLException;
	
}
