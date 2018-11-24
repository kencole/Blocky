package renderer;

import java.util.ArrayList;
import java.util.List;

public class Cube3 {
	
	public Point3 TNW, TNE, TSW, TSE, BNW, BNE, BSW, BSE, center;
	
	public Cube3(Point3 TNW, Point3 TNE, Point3 TSW, Point3 TSE, Point3 BNW, Point3 BNE, Point3 BSW, Point3 BSE) {
		this.TNW = TNW;
		this.TNE = TNE;
		this.TSW = TSW;
		this.TSE = TSE;
		this.BNW = BNW;
		this.BNE = BNE;
		this.BSW = BSW;
		this.BSE = BSE;
		this.center = new Point3(this.BNW.x + 0.5, this.BNW.y + 0.5, this.BNW.z + 0.5);
	}
	
	public List<SqFace3> getFaces() {
		ArrayList<SqFace3> lis = new ArrayList<SqFace3>(6);
		lis.add(new SqFace3(TNW, TNE, TSE, TSW));
		lis.add(new SqFace3(TNW, TSW, BSW, BNW));
		lis.add(new SqFace3(TNE, TSE, BSE, BNE));
		lis.add(new SqFace3(TSW, TSE, BSE, BSW));
		lis.add(new SqFace3(TNW, TNE, BNE, BNW));
		lis.add(new SqFace3(BNW, BNE, BSE, BSW));
		return lis;
	}

}
