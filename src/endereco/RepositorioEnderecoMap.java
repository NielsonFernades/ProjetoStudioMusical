/*
* RepositorioEndereçoMap
* Versão: 1.0
* Data de Criação : 19/10/2015
* Nielson Vieira
*/

package endereco;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;

import javax.swing.JOptionPane;

public class RepositorioEnderecoMap implements IRepositorioEndereco {

	HashMap<Integer, Endereco> arrayEnderecoMap;
	Integer indice;

	@Override
	public void cadastrar(Endereco endereco) throws SQLException, IOException {
		endereco.setIdEndereco(indice);
		arrayEnderecoMap.put(indice, endereco);
		indice++;

		JOptionPane.showMessageDialog(null, "Endereço Cadastro!");

	}

	@Override
	public void atualizar(Endereco endereco) throws SQLException, IOException {
		Integer i = endereco.getIdEndereco();
		arrayEnderecoMap.put(i, endereco);

		JOptionPane.showMessageDialog(null, "Endereço Atualizado!");

	}

	@Override
	public void remover(Integer idEndereco) throws SQLException, IOException {
		for (int i = 0; i < indice; i++) {
			Endereco endereco = arrayEnderecoMap.get(i);

			if (idEndereco == endereco.getIdEndereco()) {

				arrayEnderecoMap.remove(endereco);
			}
		}

	}

	@Override
	public Endereco procurar(Integer idEndereco) throws SQLException, Exception {
		for (int i = 0; i < indice; i++) {
			Endereco endereco = arrayEnderecoMap.get(i);
			if (idEndereco == endereco.getIdEndereco()) {

				return endereco;
			}
		}
		return null;
	}

	@Override
	public boolean existir(Integer idEndereco) throws SQLException, IOException {
		for (int i = 0; i < indice; i++) {
			Endereco endereco = arrayEnderecoMap.get(i);

			if (idEndereco == endereco.getIdEndereco()) {

				return true;
			}

		}
		return false;

	}

	@Override
	public ArrayList<Endereco> listar() throws SQLException, IOException {
		ArrayList<Endereco> arrayEndereco = new ArrayList<Endereco>();

		for (int i = 0; i < indice; i++) {

			Endereco enderecoN = arrayEnderecoMap.get(i);
			arrayEndereco.add(enderecoN);

		}
		return arrayEndereco;
	}

}
