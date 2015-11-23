/*
* RepositórioArtistaIO
* Versão: 1.0
* Data de Criação : 19/10/2015
* Nielson Vieira
*/

package artista;

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

import excecoesArtistas.ArtistaJaCadastradoException;
import excecoesArtistas.ArtistaNaoEncontradoExecption;

public class RepositorioArtistaIO implements IRepositorioArtista {

	Path path = Paths.get("C:/Users/Alternativo8/git/AutoFood/files/repositorioio.txt");
	Charset utf8 = StandardCharsets.UTF_8;
	// Integer index;

	public RepositorioArtistaIO() throws IOException {
		// index = 1;
		Files.createDirectories(path.getParent());
	}

	@Override
	public void cadastrar(Artista artista) throws SQLException, ArtistaJaCadastradoException, IOException {
		// artista.setCodigo(index);
		if (existe(artista.getCpf()))
			try (BufferedWriter escrever = Files.newBufferedWriter(path, utf8, StandardOpenOption.APPEND);) {
				escrever.write(artista.getNome() + ";" + artista.getCpf() + ";" + artista.getEmail() + ";"
						+ artista.getWebSite() + ";" + artista.getGenero() + ";" + artista.getEmail() + ";"
						+ artista.getTelefone() + "\n");

				// index++;
				JOptionPane.showMessageDialog(null, "Cadastro realizado com sucesso");
			}

	}

	@Override
	public void atualizar(Artista artista) throws SQLException, ArtistaJaCadastradoException, IOException {
		ArrayList<Artista> arrayLocal = listar();
		for (Artista artista2 : arrayLocal) {
			if (artista2.getCpf().equals(artista.getCpf())) {

				arrayLocal.remove(artista2);
				arrayLocal.add(artista);
				JOptionPane.showInternalMessageDialog(null, "Atualizado!");
				break;
			}
		}

		try (BufferedWriter digitar1 = Files.newBufferedWriter(path, utf8);) {
			digitar1.write(" ");
		}

		for (Artista artista2 : arrayLocal) {
			try (BufferedWriter digitar = Files.newBufferedWriter(path, utf8, StandardOpenOption.APPEND);) {
				digitar.write(artista2.getNome() + ";" + artista2.getCpf() + ";" + artista2.getEmail() + ";"
						+ artista2.getWebSite() + ";" + artista2.getTelefone() + "\n");
			}
		}
	}

	@Override
	public void remover(String cpf) throws SQLException, ArtistaNaoEncontradoExecption, IOException {
		ArrayList<Artista> arrayLocal = listar();
		for (Artista artista2 : arrayLocal) {
			if (artista2.getCpf().equals(cpf)) {
				arrayLocal.remove(artista2);
				JOptionPane.showMessageDialog(null, " Removido!");
				break;
			}
		}

		try (BufferedWriter digitar1 = Files.newBufferedWriter(path, utf8);) {
			digitar1.write(" ");
		}

		for (Artista artista2 : arrayLocal) {
			try (BufferedWriter digitar = Files.newBufferedWriter(path, utf8, StandardOpenOption.APPEND);) {
				digitar.write(artista2.getNome() + ";" + artista2.getCpf() + ";" + artista2.getEmail() + ";"
						+ artista2.getWebSite() + ";" + artista2.getTelefone() + "\n");

			}
		}
	}

	@Override
	public Artista procurar(String cpf)
			throws SQLException, ArtistaJaCadastradoException, IOException, ArtistaNaoEncontradoExecption {
		ArrayList<Artista> arrayLocal = listar();
		for (Artista artista2 : arrayLocal) {
			if (artista2.getCpf().equals(cpf)) {
				return artista2;

			}
		}
		throw new ArtistaNaoEncontradoExecption();
	}

	@Override
	public boolean existe(String cpf) throws SQLException, IOException {

		ArrayList<Artista> arrayLocal = listar();

		for (Artista artista2 : arrayLocal) {
			if (artista2.getCpf().equals(cpf)) {
				return true;
			}

		}
		return false;
	}

	@Override
	public ArrayList<Artista> listar() throws SQLException, IOException {

		ArrayList<Artista> arrayLocal = new ArrayList<Artista>();

		try (BufferedReader ler = Files.newBufferedReader(path, utf8)) {
			String linha = null;
			Integer indice = 1;

			while ((linha = ler.readLine()) != null) {
				String[] dados = linha.split(";");

				Artista artista = new Artista(indice, dados[0], dados[1], dados[2], dados[3], dados[4], dados[5]);
				indice++;
				arrayLocal.add(artista);
			}

			return arrayLocal;
		}
	}

}
