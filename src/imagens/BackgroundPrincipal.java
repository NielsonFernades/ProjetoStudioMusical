package imagens;

import java.awt.Graphics;
import java.awt.Image;

import javax.swing.ImageIcon;

import telas.JanelaPrincipal;

public class BackgroundPrincipal extends JanelaPrincipal {

	private Image imf;

	public BackgroundPrincipal(String imf) {

		this.imf = new ImageIcon(imf).getImage();

	}

	public void painComponet(Graphics g) {
		g.drawImage(imf, 0, 0, getWidth(), getHeight(), this);
	}
}
