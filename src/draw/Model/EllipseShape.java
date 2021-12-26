package draw.Model;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Point;
import java.awt.Rectangle;

import javax.swing.BorderFactory;
import javax.swing.border.Border;

import draw.Utils.ShapeBorderSize;

public class EllipseShape extends draw.Model.Shape {

//	private Point point1;
//	private Point point2;
//	private Point point3;
//	private Point point4;

	public EllipseShape(Rectangle rect) {
		super(rect);
	}

	public EllipseShape(draw.Model.EllipseShape rectangle) {
	}

	/**
	 * �������� �� ������������� �� ����� point ��� �������������. � ������ ��
	 * ������������ ���� ����� ���� �� �� ���� �����������, ������ ������������
	 * ������� � ���� �� ����������� ���� Shape, ����� ��������� ���� ������� � �
	 * ���������� ������������ �� �������� (� ��� ������� � �������� � ���� ������).
	 */
	@Override
	public boolean Contains(Point point) {
		int dx = (int) Math.abs(point.x - getRectangle().getCenterX());
		int dy = (int) Math.abs(point.y - getRectangle().getCenterY());
		int radius = getRectangle().height / 2;
		if (dx > radius) {
			return false;
		}
		if (dy > radius) {
			return false;
		}
		if (dx + dy <= radius) {
			return true;
		}
		return false;
	}

	/**
	 * ������, ������������� ���������� ��������.
	 */
	@Override
	public void DrawSelf(Graphics grfx) {
		super.DrawSelf(grfx);
		Rectangle r = getRectangle();
		grfx.setColor(getFillColor());
		grfx.fillOval(r.x, r.y, r.width, r.height);
		grfx.setColor(getBorderColor());
		makeRotation(grfx);
//		ShapeBorder shapeBorder = getBorderSize();
//		shapeBorder.paintBorderOval(null, grfx, r.x, r.y, r.width, r.height, getWidth(), getHeight());
		grfx.drawOval(r.x, r.y, r.width, r.height);
	}

	private int isPointInEllipse(double h, double k, int x, int y, int a, int b) {
		int p = ((int) Math.pow((x - h), 2) / (int) Math.pow(a, 2))
				+ ((int) Math.pow((y - k), 2) / (int) Math.pow(b, 2));

		return p;
	}

	@Override
	public void moveTranslateTo(Point next, Point last) {
		// TODO Auto-generated method stub
		super.moveTranslateTo(next, last);

		int xDifference = next.x - last.x;
		int yDifference = next.y - last.y;

		points[0] = new Point(points[0].x + xDifference, points[0].y + yDifference);
		points[1] = new Point(points[1].x + xDifference, points[1].y + yDifference);
		points[2] = new Point(points[2].x + xDifference, points[2].y + yDifference);
		points[3] = new Point(points[3].x + xDifference, points[3].y + yDifference);
	}
}
