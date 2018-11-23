package renderer;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;

import javax.swing.JComponent;

public class Renderer extends JComponent{
	
	private static final long serialVersionUID = 1L;
	
	Dimension size;
	
	public Renderer(Dimension size) {
		this.size = size;
	}
	
	public void paint(Graphics g) {
		System.out.println("Painting " + size.width +" x " + size.height);
		g.setColor(new Color(0,0,0));
		g.fillRect(0, 0, size.width, size.height);
		
//		for(int x = 0; x < 10; x++) {
//			g.setColor(c[x]);
//			g.fillRect(x*160 + 130, 1000, 60, 60);
//		}
//		for(int x = 0; x < 24; x++) {
//			for(int y = 0; y < 15; y++) {
//				g.setColor(new Color(110,110,110));
//				if(circles[x][y].equals(new Color(0,0,0))) {
//					g.fillOval(40 + 70*x + (y%2==0?35:0), 40 + 61 * y, 40, 40);
//					g.setColor(Color.black);
//					g.fillOval(48 + 70*x + (y%2==0?35:0), 48 + 61 * y, 24, 24);
//				}else {
//					g.setColor(circles[x][y]);
//					g.fillOval(40+70*x + (y%2==0?35:0), 40 + 61 * y, 40, 40);
//				}
//			}
//		}
	}

	public void setBoardSize(Dimension size) {
		this.size = size;
	}

}
