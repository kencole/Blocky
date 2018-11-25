package main;

import java.awt.Dimension;
import java.awt.Toolkit;

import controller.BoardController;
import controller.PersonController;
import controller.WorldController;
import game.World;
import game.Person;
import renderer.Board;

public class Blocky {
	
	final int updatedelay = 1;

	public static void main(String[] args) {
		
		Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
		Board b = new Board("Blocky");
		World w = new World();
		WorldController wc = new WorldController(w);
		PersonController pc = new PersonController(new Person(), w);
		BoardController bc = new BoardController(b, 20, wc, pc);
		b.setSize(screenSize.width / 2, (int)(screenSize.height / 1.7));
		b.show(true);
		bc.start();
		
	}

}
