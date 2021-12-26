package draw.Utils;

import java.util.Vector;

public class Matrix {
	// this class isn't used, it contains functions for possible operations with matrix
	    double[][] v;

	    Matrix(double[][] v){
	       this.v = v;
	    }
	    /** Creates an Matrix that will used to translate the picture to the coordinates
	    * clicked on the screen. 
	    **/
	    public static Matrix translate(int dx, int dy){
	        double dM[][] = {{1, 0, 0}, {0, 1, 0}, {Math.round(-dx), Math.round(-dy), 1}};
	        return new Matrix(dM);
	    }
	    public static Matrix rotate(double a){
	        double rad = -(Math.PI * a / 180);
	        double dM[][] = {{Math.cos(rad), Math.sin(rad), 0},{Math.sin(rad), Math.cos(rad), 0}, {0, 0, 1}};

	        return new Matrix(dM);
	    }
	    
	    /** Creates an Matrix that will used to scale the picture by the given factor. **/
	    public static Matrix scale(double f){
	        double dM[][] = {{1/f, 0, 0}, {0, 1/f, 0}, {0, 0, 1}};
	        return new Matrix(dM);
	    }
	    public static Matrix shearX(double sX){
	        double dM[][] = {{1, 0, 0}, {-sX, 1, 0}, {0, 0, 1}};
	        return new Matrix(dM);
	    }
	    public static Matrix shearY(double sY){
	        double dM[][] = {{1, -sY, 0}, {0, 1, 0}, {0, 0, 1}};
	        return new Matrix(dM);
	    }
	    public static Matrix multiply(Matrix x, Matrix y){
	        double[][] p = new double[3][3];
	        for(int i = 0; i < x.v.length; ++i){
	            for(int j = 0; j < x.v[i].length; j++){
	                for(int k = 0; k < 3; k++){
	                    p[i][j] += + x.v[k][j] * y.v[i][k];
	                }
	             }
	         }
	         return new Matrix(p);  
	     }
}
