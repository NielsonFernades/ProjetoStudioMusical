/*
* Classe Equalizador.java
* Versão: 1.0
* Data de Criação : 19/10/2015
* Nielson Vieira
*/
package equalizador;

//import artista.Artista;
//import preset.Preset;

public class Equalizador {

	//private Artista artista;
	//private Preset preset;
	private  	int 		IdEqualizador;
	private 	String 		nomeEqualizador;
	private 	String 		volumeEqualizador;
	private 	String 		graveEqualizador;
	private 	String 		medioEqualizador;
	private 	String 		agudoEqualizador;

	public Equalizador(Integer idEqualizador, String nomeEqualizador, String volumeEqualizador, String graveEqualizador, String medioEqualizador, String agudoEqualizador) {
		super();
		IdEqualizador 			= idEqualizador;
		this.nomeEqualizador 	= nomeEqualizador;
		this.volumeEqualizador 	= volumeEqualizador;
		this.graveEqualizador 	= graveEqualizador;
		this.medioEqualizador 	= medioEqualizador;
		this.agudoEqualizador 	= agudoEqualizador;
	}

	public Equalizador(String nomeEqualizador, String volumeEqualizador, String graveEqualizador, String medioEqualizador, String agudoEqualizador) {
		super();
		this.nomeEqualizador 	= nomeEqualizador;
		this.volumeEqualizador 	= volumeEqualizador;
		this.graveEqualizador 	= graveEqualizador;
		this.medioEqualizador 	= medioEqualizador;
		this.agudoEqualizador 	= agudoEqualizador;
	}

	public int getIdEqualizador() {
		return IdEqualizador;
	}

	public void setIdEqualizador(int idEqualizador) {
		IdEqualizador = idEqualizador;
	}

	public String getNomeEqualizador() {
		return nomeEqualizador;
	}

	public void setNomeEqualizador(String nomeEqualizador) {
		this.nomeEqualizador = nomeEqualizador;
	}

	public String getVolumeEqualizador() {
		return volumeEqualizador;
	}

	public void setVolumeEqualizador(String volumeEqualizador) {
		this.volumeEqualizador = volumeEqualizador;
	}

	public String getGraveEqualizador() {
		return graveEqualizador;
	}

	public void setGraveEqualizador(String graveEqualizador) {
		this.graveEqualizador = graveEqualizador;
	}

	public String getMedioEqualizador() {
		return medioEqualizador;
	}

	public void setMedioEqualizador(String medioEqualizador) {
		this.medioEqualizador = medioEqualizador;
	}

	public String getAgudoEqualizador() {
		return agudoEqualizador;
	}

	public void setAgudoEqualizador(String agudoEqualizador) {
		this.agudoEqualizador = agudoEqualizador;
	}

	@Override
	public String toString() {
		return "Equalizador [IdEqualizador=" + IdEqualizador + ", nomeEqualizador=" + nomeEqualizador
				+ ", volumeEqualizador=" + volumeEqualizador + ", graveEqualizador=" + graveEqualizador
				+ ", medioEqualizador=" + medioEqualizador + ", agudoEqualizador=" + agudoEqualizador + "]";
	}

}