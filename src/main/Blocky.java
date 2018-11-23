package main;

import java.awt.Dimension;
import java.awt.Toolkit;

import game.BoardController;
import renderer.Board;

public class Blocky {
	
	final int updatedelay = 20;

	public static void main(String[] args) {
		
		Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
		Board b = new Board("Blocky");
		BoardController cont = new BoardController(b, 20);
		b.setSize(screenSize.width / 2, (int)(screenSize.height / 1.7));
		b.show(true);
		cont.start();
		
	}

}
