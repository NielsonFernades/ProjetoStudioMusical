package preset;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;

import javax.swing.JOptionPane;

import excecoesEqualizadores.NomeVazioException;
import excecoesPresets.PresetJaCadastradoException;
import excecoesPresets.PresetNaoEncontradoException;

public class RepositorioPresetMap implements IRepositorioPreset {

	private HashMap<Integer, Preset> arrayMapPreset;
	private int indice;

	public RepositorioPresetMap() {

		arrayMapPreset = new HashMap<Integer, Preset>();
		indice = 1;
	}

	@Override
	public void cadastrar(Preset preset) throws SQLException, NomeVazioException, PresetJaCadastradoException, IOException {
		if (existe(preset.getNomePreset()))
			throw new PresetJaCadastradoException();
		if (preset.getNomePreset().equals(null))
			throw new NomeVazioException();

		preset.setIdPreset(indice);
		arrayMapPreset.put(indice, preset);
		indice++;

		JOptionPane.showMessageDialog(null, "Preset Cadastrado!");

	}

	@Override
	public void atualizar(Preset preset) throws SQLException, PresetNaoEncontradoException {
		for (int i = 1; i < indice; i++) {
			Preset preset2 = arrayMapPreset.get(i);
			if (preset2.getIdPreset().equals(preset.getIdPreset())) {

				arrayMapPreset.remove(preset2);
				arrayMapPreset.put(i, preset);

				JOptionPane.showMessageDialog(null, "Preset Atualizado!");
			}

		}
	}

	@Override
	public void remover(String nome) throws SQLException, PresetNaoEncontradoException {
		for (int i = 0; i < indice; i++) {
			Preset preset = arrayMapPreset.get(i);
			if (preset.getNomePreset().equals(nome)) {

				arrayMapPreset.remove(i, preset);

				JOptionPane.showMessageDialog(null, "Preset Removido!");

			}
		}

	}

	@Override
	public Preset procurar(String nome) throws SQLException, PresetNaoEncontradoException {
		for (int i = 0; i < indice; i++) {
			Preset preset = arrayMapPreset.get(i);
			if (preset.getNomePreset().equals(nome)) {

				return preset;
			}
		}
		throw new PresetNaoEncontradoException();
	}

	@Override
	public Boolean existe(String nome) throws SQLException {
		for (int i = 0; i < indice; i++) {
			Preset preset = arrayMapPreset.get(i);
			if (preset.getNomePreset().equals(nome)) {

				return true;
			}
		}
		return false;
	}

	@Override
	public ArrayList<Preset> listar() throws SQLException {
		ArrayList<Preset> arrayListPreset = new ArrayList<Preset>();
		for (int i = 1; i < indice; i++) {
			Preset preset = arrayListPreset.get(i);
			arrayListPreset.add(preset);

		}

		return arrayListPreset;
	}

}
