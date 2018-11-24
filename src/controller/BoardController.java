package controller;

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
	WorldController wc;
	PersonController pc;
	
	public BoardController(Board b, int ms, WorldController wc, PersonController pc) {
		this.b = b;
		this.b.setBoardController(this);
		this.r = new Renderer(b.getSize());
		t = new Timer(ms, this);
		b.addRenderer(r);
		this.wc = wc;
		this.pc = pc;
	}
	
	public void start() {
		t.start();
	}
	
	public void suspend() {
		t.stop();
	}

	@Override
	public void keyPressed(KeyEvent arg0) {
		switch(arg0.getKeyCode()) {
		case KeyEvent.VK_W:
			pc.forward();
			break;
		case KeyEvent.VK_A:
			pc.left();
			break;
		case KeyEvent.VK_S:
			pc.back();
			break;
		case KeyEvent.VK_D:
			pc.right();
			break;
		case KeyEvent.VK_SPACE:
			pc.jump();
			break;
		}
		
	}

	@Override
	public void keyReleased(KeyEvent arg0) {
		switch(arg0.getKeyCode()) {
		case KeyEvent.VK_W:
			pc.unforward();
			break;
		case KeyEvent.VK_A:
			pc.unleft();
			break;
		case KeyEvent.VK_S:
			pc.unback();
			break;
		case KeyEvent.VK_D:
			pc.unright();
			break;
		case KeyEvent.VK_SPACE:
			pc.unjump();
			break;
		}
		
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
