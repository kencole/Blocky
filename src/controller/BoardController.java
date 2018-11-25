package controller;

import java.awt.AWTException;
import java.awt.MouseInfo;
import java.awt.Point;
import java.awt.Robot;
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
import renderer.Camera;

public class BoardController implements MouseListener, MouseMotionListener, KeyListener, ActionListener{
	
	Board b;
	Renderer r;
	Timer t;
	WorldController wc;
	PersonController pc;
	boolean mouseGrab = false;
	int mousex, mousey;
	Robot rob;
	
	public BoardController(Board b, int ms, WorldController wc, PersonController pc) {
		this.b = b;
		this.b.setBoardController(this);
		this.r = new Renderer(b.getSize(), wc.w, pc.getCamera());
		t = new Timer(ms, this);
		b.addRenderer(r);
		this.wc = wc;
		this.pc = pc;
		this.mousex = 0;
		this.mousey = 0;
		try {
			rob = new Robot();
		} catch (AWTException e) {
			e.printStackTrace();
			System.exit(1);
		}
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
		case KeyEvent.VK_UP:
			pc.p.angle_x += 0.05;
			break;
		case KeyEvent.VK_LEFT:
			pc.p.angle_y += 0.05;
			break;
		case KeyEvent.VK_DOWN:
			pc.p.angle_x -= 0.05;
			break;
		case KeyEvent.VK_RIGHT:
			pc.p.angle_y -= 0.05;
			break;
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
		case KeyEvent.VK_ESCAPE:
			this.mouseGrab = false;
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
		if(this.mouseGrab) {
			System.out.println((e.getX() - b.getSize().width / 2) + " " + (e.getY() - b.getSize().height / 2) );
			pc.p.angle_x += (e.getX() - b.getSize().width / 2) / 1000.0;
			pc.p.angle_y += (e.getY() - b.getSize().height / 2) / 1000.0;
			Point cent = b.getCenter();
			System.out.println(cent.x + " " + cent.y);
	        Point mert = MouseInfo.getPointerInfo().getLocation();
			System.out.println(mert.x + " " + mert.y);
		    rob.mouseMove(mert.x, mert.y);
		    rob.mouseMove(mert.x, mert.y);
		    rob.mouseMove(mert.x, mert.y);
		    rob.mouseMove(mert.x, mert.y);
		    rob.mouseMove(mert.x, mert.y);
		    rob.mouseMove(mert.x, mert.y);
	        mert = MouseInfo.getPointerInfo().getLocation();
			System.out.println(mert.x + " " + mert.y);

		}
		
	}

	@Override
	public void mouseClicked(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseEntered(MouseEvent e) {
		this.mouseGrab = true;
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

	@Override
	public void actionPerformed(ActionEvent arg0) {
		this.update();
	}

	public void update() {
		pc.update();
		r.setBoardSize(b.getSize());
		r.updateCamera(pc.getCamera());
		//r.updateWorld(wc.getWorld());
		this.r.repaint();
	}

}
