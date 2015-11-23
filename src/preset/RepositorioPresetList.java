/*
* RepositórioPresetList
* Versão: 1.0
* Data de Criação : 19/10/2015
* Nielson Vieira
*/

package preset;

import java.util.ArrayList;

import javax.swing.JOptionPane;

import excecoesEqualizadores.NomeVazioException;
import excecoesPresets.PresetJaCadastradoException;
import excecoesPresets.PresetNaoEncontradoException;

public class RepositorioPresetList implements IRepositorioPreset {

	private ArrayList<Preset> arrayListPreset;
	private int indice;

	public RepositorioPresetList() {
		arrayListPreset = new ArrayList<Preset>();
		indice = 1;
	}

	@Override
	public void cadastrar(Preset preset) throws  NomeVazioException, PresetJaCadastradoException {
		// System.out.println("Estou no RepositorioClienteArrayList");
		
		if(existe(preset.getNomePreset()))throw new PresetJaCadastradoException();
		if(preset.getNomePreset().equals(null))throw new NomeVazioException();
		
		preset.setIdPreset(indice);
		arrayListPreset.add(preset);
		indice++;
		JOptionPane.showMessageDialog(null, "Preset Cadastrado!");
	}

	@Override
	public void atualizar(Preset preset) {
		String p = preset.getNomePreset();
		for (Preset preset2 : arrayListPreset) {
			if (p.equals(preset2.getNomePreset())) {

				arrayListPreset.remove(preset2);
				arrayListPreset.add(preset);
				JOptionPane.showMessageDialog(null, "Preset Atualizado!");
			}
		}

	}

	@Override
	public void remover(String nome) throws PresetNaoEncontradoException {
		for (Preset preset : arrayListPreset) {
			if (preset.getNomePreset().equals(nome)) {
				arrayListPreset.remove(preset);
				JOptionPane.showMessageDialog(null, "Preset Removido!");
			}
		}
		throw new PresetNaoEncontradoException();
	}

	@Override
	public Preset procurar(String nome) throws PresetNaoEncontradoException {
		for (Preset preset : arrayListPreset) {
			if (preset.getNomePreset().equals(nome)) {
				return preset;
			}
		}
		throw new PresetNaoEncontradoException();
	}

	@Override
	public Boolean existe(String nome) {
		for (Preset preset : arrayListPreset) {
			if (preset.getNomePreset().equals(nome)) {
				return true;
			}
		}
		return false;
	}

	@Override
	public ArrayList<Preset> listar() {
		return arrayListPreset;
	}

}
