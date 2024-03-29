package draw.Model;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Point;
import java.awt.Polygon;
import java.awt.Rectangle;

import draw.Utils.ShapeBorderSize;

public class TriangleShape extends draw.Model.Shape {
	
	public TriangleShape(Rectangle rect) {
		super(rect);
	}

	public TriangleShape(draw.Model.TriangleShape rectangle) {

	}

	private int[] xPoly;
	private int[] yPoly;

	/**
	 * �������� �� ������������� �� ����� point ��� �������������. � ������ ��
	 * ������������ ���� ����� ���� �� �� ���� �����������, ������ ������������
	 * ������� � ���� �� ����������� ���� Shape, ����� ��������� ���� ������� � �
	 * ���������� ������������ �� �������� (� ��� ������� � �������� � ���� ������).
	 */
	@Override
	public boolean Contains(Point point) {
		if (isInside(points[0].x, points[0].y, points[1].x, points[1].y, points[2].x, points[2].y, point.x, point.y))
			return true;
		else
			return false;
	}

	/*
	 * A utility function to calculate area of triangle formed by (x1, y1) (x2, y2)
	 * and (x3, y3)
	 */
	static double area(int x1, int y1, int x2, int y2, int x3, int y3) {
		return Math.abs((x1 * (y2 - y3) + x2 * (y3 - y1) + x3 * (y1 - y2)) / 2.0);
	}

	/*
	 * A function to check whether point P(x, y) lies inside the triangle formed by
	 * A(x1, y1), B(x2, y2) and C(x3, y3)
	 */
	private boolean isInside(int x1, int y1, int x2, int y2, int x3, int y3, int x, int y) {
		/* Calculate area of triangle ABC */
		double A = area(x1, y1, x2, y2, x3, y3);

		/* Calculate area of triangle PBC */
		double A1 = area(x, y, x2, y2, x3, y3);

		/* Calculate area of triangle PAC */
		double A2 = area(x1, y1, x, y, x3, y3);

		/* Calculate area of triangle PAB */
		double A3 = area(x1, y1, x2, y2, x, y);

		/* Check if sum of A1, A2 and A3 is same as A */
		return (A == A1 + A2 + A3);
	}

	/**
	 * ������, ������������� ���������� ��������.
	 */
	@Override
	public void DrawSelf(Graphics grfx) {
		super.DrawSelf(grfx);
		this.xPoly = new int[] { this.points[0].x, points[1].x, points[2].x };
		this.yPoly = new int[] { this.points[0].y, points[1].y, points[2].y };
		Polygon polygon = new Polygon(this.xPoly, this.yPoly, 3);
		grfx.setColor(getFillColor());
		grfx.fillPolygon(polygon);
		grfx.setColor(getBorderColor());
//		ShapeBorder shapeBorder = getBorderSize();
//		shapeBorder.paintBorder(null, grfx, r.x, r.y, r.width, r.height);
		makeRotation(grfx);
		grfx.drawPolygon(polygon);
	}

	@Override
	public void moveTranslateTo(Point next, Point last) {
		// TODO Auto-generated method stub
		super.moveTranslateTo(next, last);
		
		points[0] = new Point(points[0].x + (next.x - last.x), points[0].y + (next.y - last.y));
		points[1] = new Point(points[1].x + (next.x - last.x), points[1].y + (next.y - last.y));
		points[2] = new Point(points[2].x + (next.x - last.x), points[2].y + (next.y - last.y));
	}
}
