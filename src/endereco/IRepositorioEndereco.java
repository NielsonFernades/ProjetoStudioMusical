/*
* RepositórioEndereço
* Versão: 1.0
* Data de Criação : 19/10/2015
* Nielson Vieira
*/

package endereco;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;


public interface IRepositorioEndereco {
	
	public void 		cadastrar	(Endereco endereco) 		throws SQLException, IOException; 
	public void 		atualizar	(Endereco endereco) 		throws SQLException, IOException;
	public void 		remover		(Integer idEndereco) 		throws SQLException, IOException;
	public Endereco 	procurar	(Integer idEndereco) 		throws SQLException, 				Exception;
	public boolean 		existir		(Integer idEndereco) 		throws SQLException, IOException;
	
	public ArrayList<Endereco> listar() 						throws SQLException, IOException;

}
