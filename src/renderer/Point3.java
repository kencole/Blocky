package renderer;

public class Point3 {

	double x, y, z;
	
	public Point3(double x, double y, double z) {
		this.x = x;
		this.y = y;
		this.z = z;
	}
	
	public static double distSq(Point3 A, Point3 B) {
		double x = A.x - B.x;
		double y = A.y - B.y;
		double z = A.z - B.z;
		return x*x + y*y + z*z;
	}
	
	public double[] getVec() {
		return new double[] {x, y, z};
	}
}
