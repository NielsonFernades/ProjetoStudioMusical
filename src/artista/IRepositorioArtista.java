/*
* IRepositorioArtista.java
* Versão: 1.0
* Data de Criação : 19/010/2015
*
*/
package artista;
import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;

import excecoesArtistas.ArtistaJaCadastradoException;
import excecoesArtistas.ArtistaNaoEncontradoExecption;

public interface IRepositorioArtista {
	
	public 		void 		cadastrar	(Artista artista) 	throws 		SQLException, 									ArtistaJaCadastradoException, 	IOException; 
	public 		void 		atualizar	(Artista artista) 	throws 		SQLException, ArtistaNaoEncontradoExecption, 	ArtistaJaCadastradoException, 	IOException;
	public 		void 		remover		(String cpf) 		throws 		SQLException, ArtistaNaoEncontradoExecption, 	ArtistaNaoEncontradoExecption, 	IOException;
	public 		Artista 	procurar	(String cpf) 		throws 		SQLException, ArtistaNaoEncontradoExecption, 	ArtistaJaCadastradoException, 	IOException;
	public 		boolean 	existe		(String cpf) 		throws 		SQLException, 																	IOException;

	public ArrayList<Artista> listar() throws SQLException, IOException;
}
