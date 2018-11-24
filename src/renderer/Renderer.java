package renderer;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

import javax.swing.JComponent;

import game.Block;
import game.World;

import matrix.MatrixMath;

public class Renderer extends JComponent{
	
	private static final long serialVersionUID = 1L;
	
	List<Cube3> cubes;
	
	Dimension size;
	static Camera cam;
	World world;
	double[][] dmat;
	double[] cVec;
	
	public Renderer(Dimension size, World w, Camera cam) {
		updateCamera(cam);
		this.size = size;
		this.world = w;
		cubes = new ArrayList<Cube3>();
	}
	
	public void updateCamera(Camera c) {
		cam = c;
		double[][] A = new double[][] {
			{1,0, 0},
			{0, Math.cos(c.theta), Math.sin(c.theta)},
			{0, -Math.sin(c.theta), Math.cos(c.theta)}
		};
		double[][] B = new double[][] {
			{Math.cos(c.phi), 0, -Math.sin(c.phi)},
			{0, 1, 0},
			{Math.sin(c.phi), 0, Math.cos(c.phi)}
		};
		dmat = MatrixMath.matrixMult33(A, B);
		cVec = MatrixMath.matrixVecMult33(dmat, MatrixMath.scalarVec3(-1, new double[] {c.x, c.y, c.z}));
	}
	
	public void paint(Graphics g) {
		g.setColor(new Color(126,192,238));
		g.fillRect(0, 0, size.width, size.height);
		for(int i = 0; i < this.world.blocks.length; i++) {
			for(int j = 0; j < this.world.blocks[0].length; j++) {
				for(int k = 0; k < this.world.blocks[0].length; k++) {
					if(this.world.blocks[i][j][k].type == Block.Type.GROUND) {
						cubes.add(this.world.blocks[i][j][k].getCube());
					}
				}
			}
		}
		Collections.sort(cubes, new SortdistAscending());
		g.setColor(new Color(0,0,0));
		//System.out.println("Render");
		for(int i = cubes.size() - 1; i >= 0; i--) {
			List<SqFace3> faces = cubes.get(i).getFaces();
			Collections.sort(faces, new SortdistAscendingFace());
			for(int j = faces.size() - 1; j >= 0; j--) {
				g.setColor(new Color(255,255,0));
				//System.out.println("Render2");
				double[] dvec1 = MatrixMath.vecplus3(cVec, MatrixMath.matrixVecMult33(dmat, faces.get(j).p1.getVec()));
				double[] dvec2 = MatrixMath.vecplus3(cVec, MatrixMath.matrixVecMult33(dmat, faces.get(j).p2.getVec()));
				double[] dvec3 = MatrixMath.vecplus3(cVec, MatrixMath.matrixVecMult33(dmat, faces.get(j).p3.getVec()));
				double[] dvec4 = MatrixMath.vecplus3(cVec, MatrixMath.matrixVecMult33(dmat, faces.get(j).p4.getVec()));
				double bx1 = 100/dvec1[2] * dvec1[0] + size.width/2;
				double by1 = 100/dvec1[2] * dvec1[1] + size.height/2;
				double bx2 = 100/dvec2[2] * dvec2[0] + size.width/2;
				double by2 = 100/dvec2[2] * dvec2[1] + size.height/2;
				double bx3 = 100/dvec3[2] * dvec3[0] + size.width/2;
				double by3 = 100/dvec3[2] * dvec3[1] + size.height/2;
				double bx4 = 100/dvec4[2] * dvec4[0] + size.width/2;
				double by4 = 100/dvec4[2] * dvec4[1] + size.height/2;
				if(bx1 > 0 && by1 > 0 && bx2 > 0 && by2 > 0 && bx3 > 0 && by3 > 0 && bx4 > 0 && by4 > 0 && 
						dvec1[2] > 0 && dvec2[2] > 0 && dvec3[2] > 0 && dvec4[2] > 0) {
					g.fillPolygon(
							new int[] {(int)bx1, (int)bx2, (int)bx3, (int)bx4},
							new int[] {(int)by1, (int)by2, (int)by3, (int)by4}, 4);
				}
				
				List<Line3> lines = faces.get(j).getLines();
				g.setColor(new Color(0,0,0));
				for(int k = 0; k < lines.size(); k++) {
					dvec1 = MatrixMath.vecplus3(cVec, MatrixMath.matrixVecMult33(dmat, lines.get(k).a.getVec()));
					dvec2 = MatrixMath.vecplus3(cVec, MatrixMath.matrixVecMult33(dmat, lines.get(k).b.getVec()));
					bx1 = 100/dvec1[2] * dvec1[0] + size.width/2;
					by1 = 100/dvec1[2] * dvec1[1] + size.height/2;
					bx2 = 100/dvec2[2] * dvec2[0] + size.width/2;
					by2 = 100/dvec2[2] * dvec2[1] + size.height/2;
					if(bx1 > 0 && by1 > 0 && bx2 > 0 && by2 > 0 && dvec1[2] > 0 && dvec2[2] > 0)
						g.drawLine((int)bx1, (int)by1, (int)bx2, (int)by2);
				}
			}
		}
		
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

	public void updateWorld(World world) {
		this.world = world;
	}

	
	private class SortdistAscending implements Comparator<Cube3>{

		@Override
		public int compare(Cube3 arg0, Cube3 arg1) {
			double dist0 = Point3.distSq(arg0.center, Renderer.cam.xyz);
			double dist1 = Point3.distSq(arg1.center, Renderer.cam.xyz);
			if(dist0 == dist1) return 0;
			return dist0 > dist1 ? 1 : -1;
		}
		
	}
	
	private class SortdistAscendingFace implements Comparator<SqFace3>{

		@Override
		public int compare(SqFace3 arg0, SqFace3 arg1) {
			double dist0 = Point3.distSq(arg0.center, Renderer.cam.xyz);
			double dist1 = Point3.distSq(arg1.center, Renderer.cam.xyz);
			if(dist0 == dist1) return 0;
			return dist0 > dist1 ? 1 : -1;
		}
		
	}
}
