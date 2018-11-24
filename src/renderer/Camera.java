package renderer;

public class Camera {
	
	protected double theta, phi;
	protected double x, y, z;
	protected Point3 xyz;
	
	public Camera(double th, double ph, double x, double y, double z) {
		this.theta = th;
		this.phi = ph;
		this.x = x;
		this.y = y;
		this.z = z;
		this.xyz = new Point3(x, y, z);
	}
}
