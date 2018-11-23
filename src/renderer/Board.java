package renderer;




import java.awt.Dimension;

import javax.swing.JFrame;

import game.BoardController;

public class Board{

	JFrame frame;
	BoardController cont;
	Renderer r;
	
	public Board(String name, BoardController c) {
		this(name);
		this.setBoardController(c);
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
		r.setBoardSize(frame.getSize());
	}
	
	public void setBoardController(BoardController c) {
		cont = c;
		frame.addMouseMotionListener(c);
		frame.addMouseListener(c);
		frame.addKeyListener(c);
	}
	
	public BoardController getBoardController() {
		return this.cont;
	}
	
	public void addRenderer(Renderer r) {
		this.r = r;
		frame.add(r);
	}

	public Dimension getSize() {
		return frame.getSize();
	}
	
}
