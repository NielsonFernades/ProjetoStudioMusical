/*
* EndereçoRepositorioIO
* Versão: 1.0
* Data de Criação : 19/10/2015
* Nielson Vieira
*/

package endereco;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.swing.JOptionPane;

public class RepositorioEnderecoIO implements IRepositorioEndereco {

	Path path = Paths.get("");

	Charset utf8 = StandardCharsets.UTF_8;
	Integer indice = 1;

	public RepositorioEnderecoIO() throws IOException {
		Files.createDirectories(path.getParent());
	}

	@Override
	public void cadastrar(Endereco endereco) throws SQLException, IOException {
		endereco.setIdEndereco(indice);
		BufferedWriter escrever = Files.newBufferedWriter(path, utf8, StandardOpenOption.APPEND);
		escrever.write(endereco.getIdEndereco() + ";" + endereco.getRua() + ";" + endereco.getBairro() + ";" +  endereco.getNumero()+ ";" + endereco.getCep() + ";" + endereco.getCidade());
		indice++;
		
		JOptionPane.showMessageDialog(null, "Endereço Cadastrado!");
	}

	@Override
	public void atualizar(Endereco endereco) throws SQLException, IOException {
		ArrayList<Endereco> arrayEndereco = listar();
		for (Endereco endereco2 : arrayEndereco) {
			if(endereco2.getIdEndereco().equals(endereco.getIdEndereco())){
				
				arrayEndereco.remove(endereco2);
				arrayEndereco.add(endereco);
				break;
			}
		}
		try(BufferedWriter escrever = Files.newBufferedWriter(path, utf8)){
			escrever.write(" ");
			
			for (Endereco endereco2 : arrayEndereco) {
				try(BufferedWriter escrever1 = Files.newBufferedWriter(path, utf8, StandardOpenOption.APPEND)){
					
					escrever1.write(endereco2.getIdEndereco() + ";" + endereco2.getRua() + ";" + endereco2.getBairro() + ";" + endereco2.getNumero() + ";" + endereco2.getCep() + ";" + endereco2.getCidade());
				}
			}
		}
		JOptionPane.showMessageDialog(null, "Endereço Atualizado!");
	}

	@Override
	public void remover(Integer idEndereco) throws SQLException, IOException {

		ArrayList<Endereco> arrayEndereco = listar();
		for (Endereco endereco : arrayEndereco) {
			if(endereco.getIdEndereco() == idEndereco){
				break;
			} else {
				JOptionPane.showMessageDialog(null, "Endereço Inexistente!");
			}
		}
		try (BufferedWriter escrever = Files.newBufferedWriter(path, utf8);) {
			escrever.write(" ");
		}
		JOptionPane.showMessageDialog(null, "Endereço Removido!");
	}


	@Override
	public Endereco procurar(Integer idEndereco) throws SQLException, Exception {

		ArrayList<Endereco> arrayEndereco = listar();
		for (Endereco endereco : arrayEndereco) {
			if(endereco.getIdEndereco() == idEndereco){
				JOptionPane.showMessageDialog(null, "Endereço Existente");
				return endereco;

			} else {
				JOptionPane.showMessageDialog(null, "Endereço Inexistente!");
			}
		}

		return null;
	}

	@Override
	public boolean existir(Integer idEndereco) throws SQLException, IOException {
		ArrayList<Endereco> arrayList = listar();
		
		for (Endereco endereco : arrayList) {
			if (endereco.getIdEndereco() == idEndereco) {

				JOptionPane.showMessageDialog(null, "Endereço existe!");
				return true;

			}
		}
		JOptionPane.showMessageDialog(null, "Endereço não existe!");
		return false;
	}


	@Override
	public ArrayList<Endereco> listar() throws SQLException, IOException {
		ArrayList<Endereco> arrayEndereco = new ArrayList<Endereco>();
		String linha = null;
		Integer indice = 1;
		
		try {
			try (BufferedReader ler = Files.newBufferedReader(path, utf8)) {
				
				while ((linha = ler.readLine()) != null) {
					
					String[] dados = linha.split(";");
					
					int idEndereco = Integer.parseInt(dados[0]);
					String rua = dados[1];
					String bairro = dados[2];
					String numero = dados[3];
					String cep = dados[4];
					String cidade = dados[5];
					
					Endereco endereco = new Endereco(idEndereco, rua, bairro, numero, cep, cidade);
					indice++;
					arrayEndereco.add(endereco);
				}

				return null;
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return arrayEndereco;

	}
}
