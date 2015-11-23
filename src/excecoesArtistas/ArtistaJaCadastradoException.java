package excecoesArtistas;

public class ArtistaJaCadastradoException extends Exception {
	public ArtistaJaCadastradoException(){
		super("Artista já cadastrado em nossa base de dados");
	}

}
