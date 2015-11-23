/*
* Preset
* Versão: 1.0
* Data de Criação : 19/10/2015
* Nielson Vieira
*/

package preset;

import equalizador.Equalizador;

public class Preset {

	private 	Equalizador	equalizador;
	private 	Integer 	IdPreset;
	private 	String 		nomePreset;
	private 	String 		generoPreset;
	private 	String 		DataPreset;
	
	public Preset(Equalizador equalizador, Integer idPreset, String nomePreset, String generoPreset, String dataPreset) {
		this.setEqualizador  	(equalizador);
		this.setIdPreset 		(idPreset);
		this.setNomePreset  	(nomePreset);
		this.setGeneroPreset 	(generoPreset);
		this.setDataPreset 		(dataPreset);
	}
	
	public Preset(Integer idPreset, String nomePreset, String generoPreset, String dataPreset) {
		IdPreset 			= idPreset;
		this.nomePreset 	= nomePreset;
		this.generoPreset 	= generoPreset;
		DataPreset 			= dataPreset;
	}

	public Equalizador getEqualizador() {
		return equalizador;
	}

	public void setEqualizador(Equalizador equalizador) {
		this.equalizador = equalizador;
	}

	public Integer getIdPreset() {
		return IdPreset;
	}

	public void setIdPreset(Integer idPreset) {
		IdPreset = idPreset;
	}

	public String getNomePreset() {
		return nomePreset;
	}

	public void setNomePreset(String nomePreset) {
		this.nomePreset = nomePreset;
	}

	public String getGeneroPreset() {
		return generoPreset;
	}

	public void setGeneroPreset(String generoPreset) {
		this.generoPreset = generoPreset;
	}

	public String getDataPreset() {
		return DataPreset;
	}

	public void setDataPreset(String dataPreset) {
		DataPreset = dataPreset;
	}

	@Override
	public String toString() {
		return "Preset [equalizador=" + equalizador + ", IdPreset=" + IdPreset + ", nomePreset=" + nomePreset
				+ ", generoPreset=" + generoPreset + ", DataPreset=" + DataPreset + "]";
	}

}
