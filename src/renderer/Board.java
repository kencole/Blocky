package renderer;




import javax.swing.JFrame;

import game.Controller;

public class Board{

	JFrame frame;
	Controller cont;
	
	public Board(String name, Controller c) {
		this(name);
		this.setController(c);
	}
	
	public Board(String name) {
		this();
		frame.setTitle(name);
	}
	
	public Board() {
		frame = new JFrame();
		frame.setResizable(true);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
	
	public void show(boolean show) {
		frame.setVisible(show);
	}
	
	public void setSize(int size_x, int size_y) {
		frame.setSize(size_x, size_y);
	}
	
	public void setController(Controller c) {
		cont = c;
		frame.addMouseMotionListener(c);
		frame.addMouseListener(c);
		frame.addKeyListener(c);
	}
	
	public Controller getController() {
		return this.cont;
	}
	
	public JFrame getFrame() {
		return this.frame;
	}

	
	
}
