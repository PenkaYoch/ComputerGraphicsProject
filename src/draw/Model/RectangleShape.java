/**
 * RectangleShape.java
 */

package draw.Model;

import java.awt.*;

import draw.Utils.ShapeBorderSize;

/**
 * Класът правоъгълник е основен примитив, който е наследник на базовия Shape.
 */
public class RectangleShape extends draw.Model.Shape {
    
	private Point point1;
	private Point point2;
	private Point point3;
	private Point point4;
	
    public RectangleShape(Rectangle rect) {
        super(rect);
    }
    
    public RectangleShape(draw.Model.RectangleShape rectangle) {
    }

    /**
     * Проверка за принадлежност на точка point към правоъгълника.
     * В случая на правоъгълник този метод може да не бъде пренаписван, защото
     * Реализацията съвпада с тази на абстрактния клас Shape, който проверява
     * дали точката е в обхващащия правоъгълник на елемента (а той съвпада с
     * елемента в този случай).
     */
    @Override
    public boolean Contains(Point point) {
        if ( super.Contains(point) ) {
            //  Проверка дали е в обекта само, ако точката е в обхващащия правоъгълник.
            //  В случая на правоъгълник - директно връщаме true
            return true;
        
        }
        else {
            return false;
        }
    }

    /**
     * Частта, визуализираща конкретния примитив.
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
        grfx.drawRect(r.x, r.y, r.width, r.height);
    }

    @Override
    public void moveTranslateTo(Point next, Point last) {
    	// TODO Auto-generated method stub
    	super.moveTranslateTo(next, last);

        int xDifference = next.x - last.x;
        int yDifference = next.y - last.y;

        this.point1 = new Point(this.point1.x + xDifference, this.point1.y + yDifference);
        this.point2 = new Point(this.point2.x + xDifference, this.point2.y + yDifference);
        this.point3 = new Point(this.point3.x + xDifference, this.point3.y + yDifference);
        this.point4 = new Point(this.point4.x + xDifference, this.point4.y + yDifference);
    }
      
}
