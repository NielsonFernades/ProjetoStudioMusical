/*
* RepositorioEndere�oSet
* Vers�o: 1.0
* Data de Cria��o : 19/10/2015
* Nielson Vieira
*/

package endereco;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashSet;

import javax.swing.JOptionPane;

public class RepositorioEndercoSet implements IRepositorioEndereco {

	HashSet<Endereco> arrayEnderecoSet;
	int indice;

	public RepositorioEndercoSet() {

		this.arrayEnderecoSet = new HashSet<Endereco>();
		indice = 1;
	}

	@Override
	public void cadastrar(Endereco endereco) throws SQLException, IOException {
		endereco.setIdEndereco(indice);
		arrayEnderecoSet.add(endereco);
		indice++;

		JOptionPane.showMessageDialog(null, "Endere�o Cadastrado!");

	}

	@Override
	public void atualizar(Endereco endereco) throws SQLException, IOException {
		int i = endereco.getIdEndereco();
		for (Endereco endereco2 : arrayEnderecoSet) {
			if (i == endereco.getIdEndereco()) {
				arrayEnderecoSet.remove(endereco2);
				arrayEnderecoSet.add(endereco);

				JOptionPane.showMessageDialog(null, "Endere�o Atualizado!");
			}
		}
	}

	@Override
	public void remover(Integer idEndereco) throws SQLException, IOException {
		for (Endereco endereco : arrayEnderecoSet) {
			if (idEndereco == endereco.getIdEndereco()) {
				arrayEnderecoSet.remove(endereco);

				JOptionPane.showMessageDialog(null, "Endere�o Removido!");
			}
		}
	}

	@Override
	public Endereco procurar(Integer idEndereco) throws SQLException, Exception {
		for (Endereco endereco : arrayEnderecoSet) {
			if (endereco.getIdEndereco() == idEndereco)
				return endereco;
		}
		JOptionPane.showInternalMessageDialog(null, "Endere�o n�o Encontrado!");

		return null;
	}

	@Override
	public boolean existir(Integer idEndereco) throws SQLException, IOException {
		for (Endereco endereco : arrayEnderecoSet) {
			if (endereco.getIdEndereco() == idEndereco) {

				JOptionPane.showInternalMessageDialog(null, "Endere�o existe!");
				return true;
			}
		}
		JOptionPane.showInternalMessageDialog(null, "Endere�o n�o existe!");
		return false;
	}

	@Override
	public ArrayList<Endereco> listar() throws SQLException, IOException {

		ArrayList<Endereco> arrayEndereco = new ArrayList<>();

		for (Endereco endereco : arrayEndereco) {
			arrayEndereco.add(endereco);
		}
		return arrayEndereco;
	}

}
