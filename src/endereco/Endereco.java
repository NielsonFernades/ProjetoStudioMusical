/*
* Endereço
* Versão: 1.0
* Data de Criação : 19/10/2015
* Nielson Vieira
*/

package endereco;

import artista.Artista;

public class Endereco {

	private 	Artista 	artista;
	private 	Integer 	idEndereco;
	private 	String 		rua;
	private 	String 		bairro;
	private 	String 		numero;
	private 	String 		cep;
	private 	String 		cidade;
	
	public Endereco(Integer idEndereco, String rua, String bairro, String numero, String cep, String cidade, Artista artista) {
		this.setIdEndereco 	(idEndereco);
		this.setRua 		(rua);
		this.setBairro 		(bairro);
		this.setNumero 		(numero);
		this.setCep			(cep);
		this.setCidade 		(cidade);
		this.setArtista 	(artista);	
	}
	
	public Endereco(Integer idEndereco, String rua, String bairro, String numero, String cep, String cidade) {
		this.setIdEndereco 		(idEndereco);
		this.setRua 			(rua);
		this.setBairro 			(bairro);
		this.setNumero 			(numero);
		this.setCep				(cep);
		this.setCidade 			(cidade);
	}
	
	public Endereco(String rua, String bairro, String numero, String cep, String cidade) {
		setRua 		(rua);
		setBairro 	(bairro);
		setNumero 	(numero);
		setCep 		(cep);
		setCidade 	(cidade);
	}

	public Artista getArtista() {
		return artista;
	}

	public void setArtista(Artista artista) {
		this.artista = artista;
	}

	public Integer getIdEndereco() {
		return idEndereco;
	}

	public void setIdEndereco(Integer idEndereco) {
		this.idEndereco = idEndereco;
	}

	public String getRua() {
		return rua;
	}

	public void setRua(String rua) {
		this.rua = rua;
	}

	public String getBairro() {
		return bairro;
	}

	public void setBairro(String bairro) {
		this.bairro = bairro;
	}

	public String getNumero() {
		return numero;
	}

	public void setNumero(String numero) {
		this.numero = numero;
	}

	public String getCep() {
		return cep;
	}

	public void setCep(String cep) {
		this.cep = cep;
	}

	public String getCidade() {
		return cidade;
	}

	public void setCidade(String cidade) {
		this.cidade = cidade;
	}

	@Override
	public String toString() {
		return "Endereco [artista=" + artista + ", idEndereco=" + idEndereco + ", rua=" + rua + ", bairro=" + bairro
				+ ", numero=" + numero + ", cep=" + cep + ", cidade=" + cidade + "]";
	}

}