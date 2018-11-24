package matrix;

public class MatrixMath {
	
	public static double[][] matrixMult33(double[][] A, double[][] B){
		double[][] C = new double[3][3];
		for(int i = 0; i < 3; i++) {
			for(int j = 0; j < 3; j++) {
				for(int k = 0; k < 3; k++) {
					C[i][j] += A[i][k] * B[j][k];
				}
			}
		}
		return C;
	}
	
	public static double[] matrixVecMult33(double[][]A , double[] x) {
		double[] b = new double[3];
		for(int i = 0; i < 3; i++) {
			for(int j = 0; j < 3; j++) {
				b[i] += A[i][j] * x[j];
			}
		}
		return b;
	}
	
	public static double[] vecMinus3(double[] v1, double[] v2) {
		return new double[] {v1[0] - v2[0], v1[1] - v2[1], v1[2] - v2[2]};
	}
	
	public static double[] vecplus3(double[] v1, double[] v2) {
		return new double[] {v1[0] + v2[0], v1[1] + v2[1], v1[2] + v2[2]};
	}
	
	public static double[] scalarVec3(double c, double[] v) {
		return new double[] {c * v[0], c * v[1], c * v[2]};
	}

}
