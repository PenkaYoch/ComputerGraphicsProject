package draw.Model;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Point;
import java.awt.Rectangle;

public class SegmentShape extends draw.Model.Shape {
	
	private Point point1;
	private Point point2;
	
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

        this.point1 = new Point(point1.x + next.x - last.x, point1.y + next.y - last.y);
        this.point2 = new Point(point2.x + next.x - last.x, point2.y + next.y - last.y);
	}
}