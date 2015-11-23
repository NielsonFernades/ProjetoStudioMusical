package main;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Scanner;

import javax.swing.JOptionPane;

import excecoesArtistas.ArtistaJaCadastradoException;
import excecoesArtistas.ArtistaNaoEncontradoExecption;

import artista.Artista;
import endereco.Endereco;
import fachada.Fachada;

public class CadastrarArtista {

	public static void main(String[] args) throws ClassNotFoundException, IOException, SQLException, ArtistaJaCadastradoException, ArtistaNaoEncontradoExecption {

		Fachada fachada = Fachada.getInstance();
		
		Artista a1 = new Artista("Nielson", "050.529.494-05", "nielson@hotmail.com", "nielson.com.br", "81,93285131", "metal");
		fachada.cadastrarAtista(a1);
		JOptionPane.showMessageDialog(null, "Artista Cadastrado!");
		//fachada.removerArtista("050.529.494-05");
		
		Endereco e1 = new Endereco("rua", "bairro", "numero", "cep", "cidade");
		fachada.cadastrarEndereco(e1);
		JOptionPane.showMessageDialog(null, "Endereço Cadastrado!");

		
		ArrayList<Artista> artistas = fachada.listarArtista();
		for (Artista artista : artistas) {
			System.out.println(artista);
		}
		ArrayList<Endereco> endereco = fachada.listarEndereco();
		for (Endereco endereco2 : endereco) {
			System.out.println(endereco2);
		}

	}
}

/*
		Endereco e1 = new Endereco(a1, "idEndereco", "rua", "bairro", "numero", "cep", "cidade");
		a1.setEndereco(e1);
		fachada.cadastrarAtista(a1);

		System.out.println("Cadastrado");

		ArrayList<Artista> artistas = fachada.listarArtista();
		for (Artista artista : artistas) {
			System.out.println(artista);
		}

		fachada.removerArtista("050.529.494-05");
		System.out.println("Após a Remoção");

		Artista artista1 = new Artista("nome", "cpf", "email", "webSite", "telefone", "genero");
		fachada.cadastrarAtista(artista1);

		System.out.println("Depois de add");
		artistas = fachada.listarArtista();
		for (Artista artista : artistas) {
			System.out.println(artista);

			
		}
		String linha = null;
		// Inicializando o path
		Path path = Paths.get("c:/temp/aulapoo/exemplo2.txt");
		// Declarando variável do tipo charset (Codificação de Caracteres)
		Charset charset = StandardCharsets.ISO_8859_1;
		// Criando variável do tipo BufferedWriter
		BufferedWriter w = null;
		try {
			// Inicializando Variável
			w = Files.newBufferedWriter(path, charset);
			// Gravando Variável
			w.write("Maurício\r\n");
			w.write("Manoel\r\n");
			w.write("Coelho\r\n");
			w.write("Coelho\r\n");
			w.write("Coelho\r\n");
			w.write("Coelho\r\n");
			// Libera os dados da memoria e grava no arquivo
			w.flush();
			w.close();// Fecha o Arquivo
		} catch (IOException e) {
			System.out.println(e.getMessage());
		} finally {
			if (w != null) {
				w.close();
			}
		}
		
		
		Scanner ler = new Scanner(System.in); 
		int i, n; 
		System.out.printf("Informe o número para a tabuada:\n"); 
		n = ler.nextInt(); 
		FileWriter arq = new FileWriter("c:/temp/aulapoo/tabuada.txt"); 
		PrintWriter gravarArq = new PrintWriter(arq); 
		gravarArq.printf("+--Resultado--+%n"); 
		for (i=1; i<=10; i++) { gravarArq.printf("| %2d X %d = %2d |%n", i, n, (i*n)); } 
		gravarArq.printf("+-------------+%n"); 
		arq.close(); 
		System.out.printf("\nTabuada do %d foi gravada com sucesso em \"c:/temp/aulapoo/tabuada.txt\".\n", n); } 
		
}
*/
