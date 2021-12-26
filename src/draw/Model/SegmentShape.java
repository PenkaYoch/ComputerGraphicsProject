package draw.Model;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Point;
import java.awt.Rectangle;

public class SegmentShape extends draw.Model.Shape {
	
	public SegmentShape(Rectangle rect) {
	        super(rect);
	    }

	public SegmentShape(draw.Model.SegmentShape rectangle) {
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
//		grfx.setColor(getFillColor());
//		grfx.fillLine(r.x, r.y, r.width, r.height);
		grfx.setColor(getBorderColor());
		grfx.drawLine(r.x, r.y, r.width, r.height);
	}
	
	@Override
	public void moveTranslateTo(Point next, Point last) {
		// TODO Auto-generated method stub
		super.moveTranslateTo(next, last);

		points[0] = new Point(points[0].x + next.x - last.x, points[0].y + next.y - last.y);
		points[1] = new Point(points[1].x + next.x - last.x, points[1].y + next.y - last.y);
	}
}