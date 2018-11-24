package game;

import renderer.Cube3;
import renderer.Point3;

public class Block {
	
	int x, y, z;
	Point3 center;
	Cube3 cube;

	public enum Type{
		GROUND, AIR;
	}
	
	public Type type;
	
	public Block(Type t, int x, int y, int z) {
		this.type = t;
		this.x = x;
		this.y = y;
		this.z = z;
		this.center = new Point3(x + 0.5, y + 0.5, z + 0.5);
		this.cube = new Cube3(new Point3(x, y, z + 1), new Point3(x + 1, y, z + 1),
				new Point3(x, y + 1, z + 1), new Point3(x + 1, y + 1, z + 1),
				new Point3(x, y, z), new Point3(x + 1, y, z),
				new Point3(x, y + 1, z), new Point3(x + 1, y + 1, z));
	}
	
	public Point3 getCenter() {
		return center;
	}
	
	public Cube3 getCube() {
		return cube;
	}
	
	
}
