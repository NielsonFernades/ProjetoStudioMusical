package excecoesArtistas;

public class ArtistaJaCadastradoException extends Exception {
	public ArtistaJaCadastradoException(){
		super("Artista j� cadastrado em nossa base de dados");
	}

}
