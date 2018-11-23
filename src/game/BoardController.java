package game;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;

import javax.swing.Timer;

import renderer.Board;
import renderer.Renderer;

public class BoardController implements MouseListener, MouseMotionListener, KeyListener, ActionListener{
	
	Board b;
	Renderer r;
	Timer t;
	
	public BoardController(Board b, int ms) {
		this.b = b;
		this.b.setBoardController(this);
		this.r = new Renderer(b.getSize());
		t = new Timer(ms, this);
		b.addRenderer(r);
	}
	
	public void start() {
		t.start();
	}
	
	public void suspend() {
		t.stop();
	}

	@Override
	public void keyPressed(KeyEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void keyReleased(KeyEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void keyTyped(KeyEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseDragged(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseMoved(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseClicked(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseEntered(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseExited(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mousePressed(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseReleased(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	public void update() {
		r.setBoardSize(b.getSize());
		this.r.repaint();
	}

	@Override
	public void actionPerformed(ActionEvent arg0) {
		this.update();
	}

}
