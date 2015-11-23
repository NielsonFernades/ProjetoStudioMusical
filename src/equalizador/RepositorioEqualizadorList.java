/*
* RepositórioEqualizadorList
* Versão: 1.0
* Data de Criação : 19/10/2015
* Nielson Vieira
*/

package equalizador;

import java.util.ArrayList;

import javax.swing.JOptionPane;

import excecoesEqualizadores.EqualizadorJaCadastradoException;
import excecoesEqualizadores.EqualizadorNaoEncontradoException;

public class RepositorioEqualizadorList implements IRepositorioEqualizador {

	ArrayList<Equalizador> arrayListEqualizador;
	int indice;

	public RepositorioEqualizadorList() {
		this.arrayListEqualizador = new ArrayList<Equalizador>();
		this.indice = 1;
	}

	@Override
	public void cadastrar(Equalizador equalizador) throws EqualizadorJaCadastradoException {
		equalizador.setIdEqualizador(indice);
		arrayListEqualizador.add(equalizador);
		indice++;
		JOptionPane.showMessageDialog(null, "Equalizador Cadastrado!");
	}

	@Override
	public void atualizar(Equalizador equalizador) throws EqualizadorNaoEncontradoException {
		int i = equalizador.getIdEqualizador();
		for (Equalizador equalizador2 : arrayListEqualizador) {
			if (i == equalizador2.getIdEqualizador()) {
				arrayListEqualizador.remove(equalizador2);
				arrayListEqualizador.add(equalizador);
				JOptionPane.showMessageDialog(null, "Equalizador Atualizado!");

			}
		}
	}

	@Override
	public void remover(String nomeEqualizador) throws EqualizadorNaoEncontradoException {
		for (Equalizador equalizador : arrayListEqualizador) {
			if (equalizador.getNomeEqualizador().equals(nomeEqualizador)) {
				arrayListEqualizador.remove(equalizador);

				JOptionPane.showMessageDialog(null, "Equalizador Removido!");

			}

		}
		throw new EqualizadorNaoEncontradoException();
	}

	@Override
	public Equalizador procurar(String nomeEqualizador) throws EqualizadorNaoEncontradoException {
		for (Equalizador equalizador : arrayListEqualizador) {
			if (equalizador.getNomeEqualizador().equals(nomeEqualizador)) {

				return equalizador;
			}
		}
		throw new EqualizadorNaoEncontradoException();

	}

	@Override
	public boolean existe(String nomeEqualizador) {
		for (Equalizador equalizador : arrayListEqualizador) {

			if (equalizador.getNomeEqualizador().equals(nomeEqualizador)) {
				return true;
			}
		}

		return false;
	}

	@Override
	public ArrayList<Equalizador> listar() {
		return arrayListEqualizador;
	}

}
