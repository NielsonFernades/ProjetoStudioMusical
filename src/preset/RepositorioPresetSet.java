package preset;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashSet;

import javax.swing.JOptionPane;

import excecoesEqualizadores.NomeVazioException;
import excecoesPresets.PresetJaCadastradoException;
import excecoesPresets.PresetNaoEncontradoException;

public class RepositorioPresetSet implements IRepositorioPreset {

	private HashSet<Preset> arraySetPreset;
	private int indice;

	public RepositorioPresetSet() {
		arraySetPreset = new HashSet<Preset>();
		indice = 1;

	}

	@Override
	public void cadastrar(Preset preset) throws SQLException, NomeVazioException, PresetJaCadastradoException, IOException {
		if(existe(preset.getNomePreset())) throw new PresetJaCadastradoException();
		if(preset.getNomePreset().equals(null)) throw new NomeVazioException();
		
		preset.setIdPreset(indice);
		arraySetPreset.add(preset);
		indice++;

		JOptionPane.showMessageDialog(null, "Preset Cadastrado!");
	}

	@Override
	public void atualizar(Preset preset) throws SQLException, PresetNaoEncontradoException {
		for (Preset preset1 : arraySetPreset) {
			if (preset1.getNomePreset().equals(preset1.getNomePreset())) {

				arraySetPreset.remove(preset1);
				arraySetPreset.add(preset1);

				JOptionPane.showMessageDialog(null, "Preset Atualizado!");
			}
		}

	}

	@Override
	public void remover(String nome) throws SQLException, PresetNaoEncontradoException {
		for (Preset preset : arraySetPreset) {
			if (preset.getNomePreset().equals(nome)) {

				arraySetPreset.remove(preset);

				JOptionPane.showMessageDialog(null, "Preset Removido!");
			}
		}

	}

	@Override
	public Preset procurar(String nome) throws SQLException, PresetNaoEncontradoException {
		for (Preset preset : arraySetPreset) {
			if (preset.getNomePreset().equals(nome)) {
				return preset;
			}
		}

		return null;
	}

	@Override
	public Boolean existe(String nome) throws SQLException {
		for (Preset preset : arraySetPreset) {
			if (preset.getNomePreset().equals(nome)) {
				return true;
			}
		}

		return false;
	}

	@Override
	public ArrayList<Preset> listar() throws SQLException {
		ArrayList<Preset> arrayListPreset = new ArrayList<Preset>();
		for (Preset preset : arrayListPreset) {
			arrayListPreset.add(preset);
		}

		return arrayListPreset;
	}

}
