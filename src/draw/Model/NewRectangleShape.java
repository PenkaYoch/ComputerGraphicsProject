package draw.Model;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Point;
import java.awt.Rectangle;

import draw.Utils.ShapeBorderSize;

public class NewRectangleShape extends draw.Model.Shape {
	
    public NewRectangleShape(Rectangle rect) {
        super(rect);
    }
    
    public NewRectangleShape(draw.Model.NewRectangleShape rectangle) {
    }

    /**
     * РџСЂРѕРІРµСЂРєР° Р·Р° РїСЂРёРЅР°РґР»РµР¶РЅРѕСЃС‚ РЅР° С‚РѕС‡РєР° point РєСЉРј РїСЂР°РІРѕСЉРіСЉР»РЅРёРєР°.
     * Р’ СЃР»СѓС‡Р°СЏ РЅР° РїСЂР°РІРѕСЉРіСЉР»РЅРёРє С‚РѕР·Рё РјРµС‚РѕРґ РјРѕР¶Рµ РґР° РЅРµ Р±СЉРґРµ РїСЂРµРЅР°РїРёСЃРІР°РЅ, Р·Р°С‰РѕС‚Рѕ
     * Р РµР°Р»РёР·Р°С†РёСЏС‚Р° СЃСЉРІРїР°РґР° СЃ С‚Р°Р·Рё РЅР° Р°Р±СЃС‚СЂР°РєС‚РЅРёСЏ РєР»Р°СЃ Shape, РєРѕР№С‚Рѕ РїСЂРѕРІРµСЂСЏРІР°
     * РґР°Р»Рё С‚РѕС‡РєР°С‚Р° Рµ РІ РѕР±С…РІР°С‰Р°С‰РёСЏ РїСЂР°РІРѕСЉРіСЉР»РЅРёРє РЅР° РµР»РµРјРµРЅС‚Р° (Р° С‚РѕР№ СЃСЉРІРїР°РґР° СЃ
     * РµР»РµРјРµРЅС‚Р° РІ С‚РѕР·Рё СЃР»СѓС‡Р°Р№).
     */
    @Override
    public boolean Contains(Point point) {
        if ( super.Contains(point) ) {
            //  РџСЂРѕРІРµСЂРєР° РґР°Р»Рё Рµ РІ РѕР±РµРєС‚Р° СЃР°РјРѕ, Р°РєРѕ С‚РѕС‡РєР°С‚Р° Рµ РІ РѕР±С…РІР°С‰Р°С‰РёСЏ РїСЂР°РІРѕСЉРіСЉР»РЅРёРє.
            //  Р’ СЃР»СѓС‡Р°СЏ РЅР° РїСЂР°РІРѕСЉРіСЉР»РЅРёРє - РґРёСЂРµРєС‚РЅРѕ РІСЂСЉС‰Р°РјРµ true
            return true;
        
        }
        else {
            return false;
        }
    }

    /**
     * Р§Р°СЃС‚С‚Р°, РІРёР·СѓР°Р»РёР·РёСЂР°С‰Р° РєРѕРЅРєСЂРµС‚РЅРёСЏ РїСЂРёРјРёС‚РёРІ.
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
     
		grfx.setColor(Color.BLACK);
		grfx.drawLine((int)r.getMinX(), (int)r.getCenterY(), (int)r.getCenterX(), (int)r.getCenterY());
		grfx.setColor(Color.BLACK);
		grfx.drawLine((int)r.getCenterX(), (int)r.getCenterY(), (int)r.getMaxX(), (int)r.getMaxY());
		
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