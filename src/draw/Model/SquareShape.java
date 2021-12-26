package draw.Model;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Insets;
import java.awt.Point;
import java.awt.Rectangle;

//import com.sun.prism.BasicStroke;

import draw.Utils.ShapeBorderSize;

public class SquareShape extends draw.Model.Shape {
	
	private Point point1;
	private Point point2;
	private Point point3;
	private Point point4;
	
	public SquareShape(Rectangle rect) {
	        super(rect);
	    }

	public SquareShape(draw.Model.SquareShape rectangle) {
	    }

	/**
	 * �������� �� ������������� �� ����� point ��� �������������. � ������ ��
	 * ������������ ���� ����� ���� �� �� ���� �����������, ������ ������������
	 * ������� � ���� �� ����������� ���� Shape, ����� ��������� ���� ������� � �
	 * ���������� ������������ �� �������� (� ��� ������� � �������� � ���� ������).
	 */
	@Override
	public boolean Contains(Point point) {
		if (super.Contains(point)) {
			// �������� ���� � � ������ ����, ��� ������� � � ���������� ������������.
			// � ������ �� ������������ - �������� ������� true
			return true;
		} else {
			return false;
		}
	}

	/**
	 * ������, ������������� ���������� ��������.
	 */
	@Override
	public void DrawSelf(Graphics grfx) {
		super.DrawSelf(grfx);
		Rectangle r = getRectangle();
		grfx.setColor(getFillColor());
		grfx.fillRect(r.x, r.y, r.width, r.height);
		grfx.setColor(getBorderColor());
		ShapeBorderSize shapeBorder = getBorderSize();
		shapeBorder.paintBorder(null, grfx, r.x, r.y, r.width, r.height);
		makeRotation(grfx);
		grfx.drawRect(r.x, r.y, r.width, r.height);
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