package renderer;

public class SqFace3 {

	Point3 p1, p2, p3, p4;
	Point3 center;
	
	public SqFace3(Point3 p1, Point3 p2, Point3 p3, Point3 p4) {
		this.p1 = p1;
		this.p2 = p2;
		this.p3 = p3;
		this.p4 = p4;
		this.center = new Point3(
				(p1.x + p2.x + p3.x + p4.x) / 4,
				(p1.y + p2.y + p3.y + p4.y) / 4,
				(p1.z + p2.z + p3.z + p4.z) / 4);
	}
	public Point3 getCenter() {	
		return this.center;
	}

}
