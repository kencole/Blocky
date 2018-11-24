package game;

import renderer.Camera;

public class Person {
	
	public double pos_x, pos_y, pos_z;
	public double angle_x, angle_y;
	public double vel_z, vel_x, vel_y;
	
	public static final double ACCEL = 0.1;

	public Person(){
		pos_x = 0;
		pos_y = 0;
		pos_z = 1;
		angle_x = 0;
		angle_y = 0;
		vel_x = 0;
		vel_y = 0;
		vel_z = 0;
	}
	
	public int[] getBlock() {
		return new int[] {(int) pos_x, (int) pos_y, (int) pos_x};
	}
	
	public void move() {
		pos_x += vel_x;
		pos_y += vel_y;
		pos_z += vel_z;		
	}

	public Camera getCamera() {
		return new Camera(angle_x, angle_y, pos_x, pos_y, pos_z + 2);
	}
}
