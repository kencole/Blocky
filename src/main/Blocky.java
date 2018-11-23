package main;

import java.awt.Dimension;
import java.awt.Toolkit;

import game.Controller;
import renderer.Board;

public class Blocky {

	public static void main(String[] args) {
		
		Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
		Controller cont = new Controller();
		Board b = new Board("Blocky", cont);
		b.setSize(screenSize.width / 2, (int)(screenSize.height / 1.7));
		b.show(true);
		
	}

}
