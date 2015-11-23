/*
* RepositórioEndereçoList
* Versão: 1.0
* Data de Criação : 19/10/2015
* Nielson Vieira
*/

package endereco;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.swing.JOptionPane;

public class RepositorioEnderecoList implements IRepositorioEndereco {

	ArrayList<Endereco> arrayListEndereco;
	int indice;

	public RepositorioEnderecoList() {

		this.arrayListEndereco = new ArrayList<Endereco>();
		this.indice = 1;
	}

	@Override
	public void cadastrar(Endereco endereco) throws SQLException, IOException {
		endereco.setIdEndereco(indice);
		arrayListEndereco.add(endereco);
		indice++;
		JOptionPane.showMessageDialog(null, "Cadastro realizado!");

	}

	@Override
	public void atualizar(Endereco endereco) throws SQLException, IOException {
		int i = endereco.getIdEndereco();

		for (Endereco endereco1 : arrayListEndereco) {
			if (i == endereco1.getIdEndereco()) {
				arrayListEndereco.remove(endereco1);
				arrayListEndereco.add(endereco);
				JOptionPane.showMessageDialog(null, "Endereço Atualizado!");
			}
		}
	}

	@Override
	public void remover(Integer idEndereco) throws SQLException, IOException {

		for (Endereco endereco1 : arrayListEndereco) {

			if (endereco1.getIdEndereco() == idEndereco) {
				arrayListEndereco.remove(endereco1);
				JOptionPane.showMessageDialog(null, "Endereço Removido com Sucesso");
			}

		}
	}

	@Override
	public Endereco procurar(Integer idEndereco) throws SQLException, Exception {
		for (Endereco endereco : arrayListEndereco) {
			if (endereco.getIdEndereco() == idEndereco) {
				return endereco;
			}
		}
		JOptionPane.showInternalMessageDialog(null, "ENDEREÇO NÃO ENCONTRADO!");
		return null;
	}

	@Override
	public boolean existir(Integer idEndereco) throws SQLException, IOException {

		for (Endereco endereco : arrayListEndereco) {
			if (endereco.getIdEndereco() == idEndereco) {

				JOptionPane.showInternalMessageDialog(null, "Endereco existe!");
				return true;
			}
			JOptionPane.showInternalMessageDialog(null, "Endereco não existe!!");
		}
		return false;

	}

	@Override
	public ArrayList<Endereco> listar() throws SQLException, IOException {
		return arrayListEndereco;
	}

}
