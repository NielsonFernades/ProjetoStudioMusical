/*
* Artista
* Versão: 1.0
* Data de Criação : 19/10/2015
* Nielson Vieira
*/

package artista;

import endereco.Endereco;

public class Artista {

	private 	int 		ID_Artista;
	private 	String 		nome;
	private 	String 		cpf;
	private 	String 		email;
	private 	String 		webSite;
	private 	String 		telefone;
	private 	String 		genero;

	private Endereco endereco;

	public Artista(Integer iD_Artista, String nome, String cpf, String email, String webSite, String telefone, String genero) {
		//setID_Artista(iD_Artista);
		setNome		(nome);
		setCpf		(cpf);
		setEmail	(email);
		setTelefone	(webSite);
		setTelefone	(telefone);
		setGenero	(genero);
	}

	public Artista(String nome, String cpf, String email, String webSite, String telefone, String genero) {
		this.nome 		= 	nome;
		this.cpf 		= 	cpf;
		this.email 		= 	email;
		this.webSite 	= 	webSite;
		this.telefone 	= 	telefone;
		this.genero 	= 	genero;
	}

	public int getID_Artista() {
		return ID_Artista;
	}

	public void setID_Artista(int iD_Artista) {
		ID_Artista = iD_Artista;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getCpf() {
		return cpf;
	}

	public void setCpf(String cpf) {
		this.cpf = cpf.replaceAll("\\.|\\-|\\ ", "");
	}

	public String formatarCpf() {
		return cpf.substring(0, 3) + '.' + cpf.substring(3, 6) + '.' + cpf.substring(6, 9) + '-' + cpf.substring(9, 11);
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getWebSite() {
		return webSite;
	}

	public void setWebSite(String webSite) {
		this.webSite = webSite;
	}

	public String getTelefone() {
		return telefone;
	}

	public void setTelefone(String telefone) {
		this.telefone = telefone;
	}

	public String getGenero() {
		return genero;
	}

	public void setGenero(String genero) {
		this.genero = genero;
	}

	public Endereco getEndereco() {
		return endereco;
	}

	public void setEndereco(Endereco endereco) {
		this.endereco = endereco;
	}

	@Override
	public String toString() {
		return "Artista [ID_Artista=" + ID_Artista + ", nome=" + nome + ", cpf=" + cpf + ", email=" + email
				+ ", webSite=" + webSite + ", telefone=" + telefone + ", genero=" + genero + "]";
	}

}
