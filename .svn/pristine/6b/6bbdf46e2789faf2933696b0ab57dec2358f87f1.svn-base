package draw.Utils;

import java.awt.Point;

public class DimentionUtils {

	public static int[] findShapeBetweenTwoPoints(Point startPoint, Point endPoint) {
		int[] values = new int[6];
		values[0] = Math.min(startPoint.x, endPoint.x); // minX
		values[1] = Math.min(startPoint.y, endPoint.y); // minY
		values[2] = Math.max(startPoint.x, endPoint.x); // maxX
		values[3] = Math.max(startPoint.y, endPoint.y); // maxY
		values[4] = values[2] - values[0]; // width
		values[5] = values[3] - values[1]; // height
		return values;
	}
	
}
