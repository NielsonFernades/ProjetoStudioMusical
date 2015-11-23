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

public interface IRepositorioPreset {
	
	public 		void 		cadastrar	(Preset preset) 	throws SQLException, NomeVazioException, 			IOException, 	PresetJaCadastradoException;
	public 		void 		atualizar	(Preset preset) 	throws SQLException, PresetNaoEncontradoException, 	IOException;
	public 		void 		remover		(String nome)		throws SQLException, PresetNaoEncontradoException, 	IOException;
	public 		Preset 		procurar	(String nome) 		throws SQLException, PresetNaoEncontradoException, 	IOException;
	public 		Boolean 	existe		(String nome) 		throws SQLException, 								IOException;
	
	public ArrayList<Preset> listar() 						throws SQLException, 								IOException;
}
