package draw.Utils;

import java.awt.Color;
import java.awt.Component;
import java.awt.Graphics;
import java.awt.Insets;
import javax.swing.border.AbstractBorder;
import javax.swing.border.Border;

@SuppressWarnings("serial")
public class ShapeBorderSize extends AbstractBorder implements Border {

	protected Insets thickness;

	public ShapeBorderSize(Insets thickness) {
		this.thickness = thickness;
	}

	public void paintBorder(Graphics g, int x, int y, int width, int height) {
		Color oldColor = g.getColor();

		for (int i = 0; i < thickness.top; i++) {
			g.drawLine(x, y + i, x + width, y + i);
		}
		// bottom
		for (int i = 0; i < thickness.bottom; i++) {
			g.drawLine(x, y + height - i - 1, x + width, y + height - i - 1);
		}
		// right
		for (int i = 0; i < thickness.right; i++) {
			g.drawLine(x + width - i - 1, y, x + width - i - 1, y + height);
		}
		// left
		for (int i = 0; i < thickness.left; i++) {
			g.drawLine(x + i, y, x + i, y + height);
		}
		g.setColor(oldColor);
	}

	/*
	 * this is method is not working
	 */
//	  public void paintBorderOval(Graphics g, int x, int y, int width, int height, int ovalWidth, int ovalHeight) {
//		    width--;
//		    height--;
//
////		    g.setColor(lightColor);
//		    g.drawLine(x, y + height - ovalHeight, x, y + ovalHeight);
//		    g.drawArc(x, y, 2 * ovalWidth, 2 * ovalHeight, 180, -90);
//		    g.drawLine(x + ovalWidth, y, x + width - ovalWidth, y);
//		    g.drawArc(x + width - 2 * ovalWidth, y, 2 * ovalWidth, 2 * ovalHeight,
//		        90, -90);
//
////		    g.setColor(darkColor);
//		    g.drawLine(x + width, y + ovalHeight, x + width, y + height
//		        - ovalHeight);
//		    g.drawArc(x + width - 2 * ovalWidth, y + height - 2 * ovalHeight,
//		        2 * ovalWidth, 2 * ovalHeight, 0, -90);
//		    g
//		        .drawLine(x + ovalWidth, y + height, x + width - ovalWidth, y
//		            + height);
//		    g.drawArc(x, y + height - 2 * ovalHeight, 2 * ovalWidth,
//		        2 * ovalHeight, -90, -90);
//		  }

	public Insets getThickness() {
		return thickness;
	}

	/**
	 * Returns whether or not the border is opaque.
	 */
	public boolean isBorderOpaque() {
		return false;
	}

}
