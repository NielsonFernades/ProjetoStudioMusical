package preset;

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

import excecoesEqualizadores.NomeVazioException;
import excecoesPresets.PresetJaCadastradoException;
import excecoesPresets.PresetNaoEncontradoException;

public class RepositorioPresetIO implements IRepositorioPreset {

	Path path = Paths.get("c:/temp/aulapoo/tabuada.txt");
	Charset utf8 = StandardCharsets.UTF_8;

	public RepositorioPresetIO() throws IOException {

		Files.createDirectories(path.getParent());
	}

	public void cadastrar(Preset preset) throws SQLException, NomeVazioException, PresetJaCadastradoException, IOException {

		if (existe(preset.getNomePreset()))
			if (preset.getNomePreset().equals(null))

				try (BufferedWriter gravar = Files.newBufferedWriter(path, utf8, StandardOpenOption.APPEND);) {

					gravar.write(preset.getIdPreset() + ";" + preset.getNomePreset() + ";" + preset.getGeneroPreset()
							+ ";" + preset.getDataPreset());

					JOptionPane.showMessageDialog(null, "Preset Cadastro!");
				}
	}

	@Override
	public void atualizar(Preset preset) throws SQLException, PresetNaoEncontradoException, IOException {

		ArrayList<Preset> arrayArquivo = listar();

		for (Preset preset2 : arrayArquivo) {
			if (preset2.getIdPreset().equals(preset.getIdPreset())) {

				arrayArquivo.remove(preset2);
				arrayArquivo.add(preset);
				break;
			}
		}
	}

	@Override
	public void remover(String nome) throws SQLException, PresetNaoEncontradoException, IOException {

		ArrayList<Preset> arrayArquivo = listar();

		for (Preset preset : arrayArquivo) {
			if (preset.getNomePreset().equals(nome)) {
				arrayArquivo.remove(preset);
				break;

			}

		}

	}

	@Override
	public Preset procurar(String nome) throws SQLException, PresetNaoEncontradoException, IOException {

		ArrayList<Preset> arrayArquivo = listar();

		for (Preset preset : arrayArquivo) {
			if (preset.getNomePreset().equals(nome)) {
				arrayArquivo.remove(preset);

				return preset;
			}
		}
		throw new PresetNaoEncontradoException();

	}

	@Override
	public Boolean existe(String nome) throws SQLException, IOException {
		ArrayList<Preset> arrayArquivo = listar();

		for (Preset preset : arrayArquivo) {
			if (preset.getNomePreset().equals(nome)) {

				return true;
			}
		}
		return false;
	}

	@Override
	public ArrayList<Preset> listar() throws SQLException, IOException {
		ArrayList<Preset> arrayArquivo = listar();
		try (BufferedReader ler = Files.newBufferedReader(path, utf8)) {

			String contandoLinhas = null;
			Integer indice = 1;

			while ((contandoLinhas = ler.readLine()) != null) {
				String[] lista = contandoLinhas.split(";");

				Preset preset = new Preset(indice, lista[1], lista[2], lista[3]);
				indice++;
				arrayArquivo.add(preset);

			}

			return arrayArquivo;
		}
	}
}