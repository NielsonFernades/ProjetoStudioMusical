/*
* ControladorEndereço
* Versão: 1.0
* Data de Criação : 19/10/2015
* Nielson Vieira
*/

package endereco;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;

public class ControladorEndereco {

	private IRepositorioEndereco repositorioEndereco;

	public ControladorEndereco() throws ClassNotFoundException {

		this.repositorioEndereco = new RepositorioEnderecoList();
		// this.repositorioEndereco = new RepositorioEnderecoSet();
		// this.repositorioEndereco = new RepositorioEnderecoMap();
		// repositorioEndereco = new RepositorioEnderecoIO();
	}

	public void cadastrar(Endereco endereco) throws SQLException, IOException {
		repositorioEndereco.cadastrar(endereco);

	}

	public void atualizar(Endereco endereco) throws SQLException, IOException {
		repositorioEndereco.atualizar(endereco);

	}

	public void remover(Integer codigoEndereco) throws SQLException, IOException {
		repositorioEndereco.remover(codigoEndereco);
	}

	public Endereco procurar(Integer codigoEndereco) throws Exception {
		return repositorioEndereco.procurar(codigoEndereco);
	}

	public boolean existir(Integer codigoEndereco) throws SQLException, IOException {
		return repositorioEndereco.existir(codigoEndereco);
	}

	public ArrayList<Endereco> listar() throws SQLException, IOException {
		return repositorioEndereco.listar();
	}

}