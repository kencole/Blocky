package renderer;

public class Cube3 {
	
	public Point3 TNW, TNE, TSW, TSE, BNW, BNE, BSW, BSE;
	
	public Cube3(Point3 TNW, Point3 TNE, Point3 TSW, Point3 TSE, Point3 BNW, Point3 BNE, Point3 BSW, Point3 BSE) {
		this.TNW = TNW;
		this.TNE = TNE;
		this.TSW = TSW;
		this.TSE = TSE;
		this.BNW = BNW;
		this.BNE = BNE;
		this.BSW = BSW;
		this.BSE = BSE;
	}
	
	public SqFace3[] getFaces() {
		return new SqFace3[]{
				new SqFace3(TNW, TNE, TSE, TSW),
				new SqFace3(TNW, TSW, BSW, BNW),
				new SqFace3(TNE, TSE, BSE, BNE),
				new SqFace3(TSW, TSE, BSE, BSW),
				new SqFace3(TNW, TNE, BNE, BNW),
				new SqFace3(BNW, BNE, BSE, BSW)};
	}

}
