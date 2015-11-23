/*
* ControladorPreset
* Versão: 1.0
* Data de Criação : 19/10/2015
* Nielson Vieira
*/

package preset;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;

import excecoesEqualizadores.NomeVazioException;
import excecoesPresets.PresetJaCadastradoException;
import excecoesPresets.PresetNaoEncontradoException;


public class ControladorPreset {

	private IRepositorioPreset repositorioPreset;

	public ControladorPreset() throws ClassNotFoundException, IOException {
		this.repositorioPreset = new RepositorioPresetList();
	}

	public void cadastrar(Preset preset) throws NomeVazioException, PresetJaCadastradoException, SQLException, IOException{
		this.repositorioPreset.cadastrar(preset);
	}

	public void atualizar(Preset preset) throws SQLException, PresetNaoEncontradoException, IOException {
		this.repositorioPreset.atualizar(preset);

		/*
		 * / Validações da Classe Preset if
		 * (!ValidarCPF.validaCPF(preset.getNome())) System.out.println(
		 * "CPF Inválido."); else if (preset.getNome() == "")
		 * System.out.println("Nome é nulo ou Inválido."); else {
		 * this.repositorioPreset.atualizar(preset); }
		 */
	}

	public void remover(String nome) throws PresetNaoEncontradoException, SQLException, IOException {
		this.repositorioPreset.remover(nome);

		/*
		 * boolean retorno = false;
		 * 
		 * if (!ValidarCPF.validaCPF(preset)) System.out.println(
		 * "Preset Inválido ou Nome esta em branco."); else { retorno =
		 * this.repositorioPreset.remover(preset); } return retorno;
		 */
	}

	public Preset procurar(String nome ) throws PresetNaoEncontradoException, SQLException, IOException {
		return this.repositorioPreset.procurar(nome);

		/*
		 * Preset preset = null;
		 * 
		 * if (!Preset.(Preset)) System.out.println("Preset Não encontrado");
		 * else { preset = this.repositorioPreset.procurar(Preset); } return
		 * preset;
		 */
	}

	public ArrayList<Preset> listar() throws SQLException, IOException {
		return this.repositorioPreset.listar();
	}
}
