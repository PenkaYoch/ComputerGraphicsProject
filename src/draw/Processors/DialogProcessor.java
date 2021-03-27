/**
 * DialogProcessor.java
 */

package draw.Processors;

import java.awt.*;

import javax.swing.JColorChooser;
import javax.swing.JFrame;

import draw.Utils.DimentionUtils;
import draw.Utils.ShapeBorderSize;

/**
 * Класът, който ще бъде използван при управляване на диалога.
 */
public class DialogProcessor extends DisplayProcessor {
	/**
	 * Избран елемент.
	 */
	private draw.Model.Shape selection;
	
	private Point startPoint;
	private Point endPoint;

	// Не е необходим в реализацията на Java
	/// **
	// * Дали в момента диалога е в състояние на "влачене" на избрания елемент.
	// */
	// private boolean isDragging;

	/**
	 * Последна позиция на мишката при "влачене". Използва се за определяне на
	 * вектора на транслация.
	 */
	private Point lastLocation;

	public DialogProcessor() {
	}

	/**
	 * Добавя примитив - правоъгълник на произволно място върху клиентската област.
	 */
	public void AddRandomRectangle(boolean isFinishDrawing) {
		int[] values = DimentionUtils.findShapeBetweenTwoPoints(this.startPoint, this.endPoint);
		draw.Model.RectangleShape rect = new draw.Model.RectangleShape(new Rectangle(values[0], values[1], values[4], values[5]));
		rect.setFinishDrawing(isFinishDrawing);
		rect.setFillColor(java.awt.Color.WHITE);
		rect.setBorderColor(java.awt.Color.BLUE);
		shapeList.add(rect);
	}

	/**
	 * Добавя примитив - елипса на произволно място върху клиентската област.
	 */
	public void AddRandomEllipse(boolean isFinishDrawing) {
//		int x = 100 + (int) Math.round(Math.random() * 900);
//		int y = 100 + (int) Math.round(Math.random() * 500);
		int[] values = DimentionUtils.findShapeBetweenTwoPoints(this.startPoint, this.endPoint);
		draw.Model.EllipseShape rect = new draw.Model.EllipseShape(new Rectangle(values[0], values[1], values[4], values[5]));
		rect.setFinishDrawing(isFinishDrawing);
		rect.setFillColor(java.awt.Color.WHITE);
		rect.setBorderColor(java.awt.Color.BLUE);
		shapeList.add(rect);
	}

	/**
	 * Добавя примитив - квадрат на произволно място върху клиентската област.
	 */
	public void AddRandomSquare(boolean isFinishDrawing) {
//		int x = 100 + (int) Math.round(Math.random() * 900);
//		int y = 100 + (int) Math.round(Math.random() * 500);
		int[] values = DimentionUtils.findShapeBetweenTwoPoints(this.startPoint, this.endPoint);
		draw.Model.SquareShape rect = new draw.Model.SquareShape(new Rectangle(values[0], values[1], values[4], values[4]));
		rect.setFinishDrawing(isFinishDrawing);
		rect.setFillColor(java.awt.Color.WHITE);
		rect.setBorderColor(java.awt.Color.BLUE);
		shapeList.add(rect);
	}

	/**
	 * Добавя примитив - отсечка на произволно място върху клиентската област.
	 */
	public void AddRandomSegment(boolean isFinishDrawing) {
//		int x = 100 + (int) Math.round(Math.random() * 900);
//		int y = 100 + (int) Math.round(Math.random() * 500);
		int[] values = DimentionUtils.findShapeBetweenTwoPoints(this.startPoint, this.endPoint);
		draw.Model.SegmentShape rect = new draw.Model.SegmentShape(new Rectangle(values[0], values[1], values[2], values[3]));
		rect.setFinishDrawing(isFinishDrawing);
//        rect.setFillColor(java.awt.Color.WHITE);
		shapeList.add(rect);
	}

	/**
	 * Добавя примитив - трапец на произволно място върху клиентската област.
	 */
	public void AddRandomPolygon(boolean isFinishDrawing) {
		int[] values = DimentionUtils.findShapeBetweenTwoPoints(this.startPoint, this.endPoint);
		Point point1 = new Point();
		point1.x = values[0];
		point1.y = values[3];
		Point point2 = new Point();
		point2.x = values[0];
		point2.y = values[1];
		Point point3 = new Point();
		point3.x = values[2];
		point3.y = values[1];
		draw.Model.TriangleShape rect = new draw.Model.TriangleShape(new Rectangle(0, 0, 100, 100), point1, point2, point3);
		rect.setFinishDrawing(isFinishDrawing);
		rect.setFillColor(java.awt.Color.WHITE);
		rect.setBorderColor(java.awt.Color.BLUE);
		shapeList.add(rect);
	}

	public void borderColorSelection(JFrame frame) {
		Color recentColor = Color.BLACK;
		Color color = JColorChooser.showDialog(frame, "Select a color", recentColor);
		this.setBorderColor(color);
	}

	public void fillColorSelection(JFrame frame) {
		Color recentColor = Color.BLACK;
		Color color = JColorChooser.showDialog(frame, "Select a color", recentColor);
		this.setFillColor(color);
	}

	public void borderSizeSelection(int thickness) {
		ShapeBorderSize border = new ShapeBorderSize(new Insets(thickness, thickness, thickness, thickness));
		this.setBorderSize(border);
	}

	/**
	 * Проверява дали дадена точка е в елемента. Обхожда в ред обратен на
	 * визуализацията с цел намиране на "най-горния" елемент т.е. този който виждаме
	 * под мишката.
	 * 
	 * @param point - Указана точка.
	 * @return Елемента на изображението, на който принадлежи дадената точка.
	 */
	public draw.Model.Shape ContainsPoint(Point point) {
		for (int i = shapeList.size() - 1; i >= 0; i--) {
			if (shapeList.get(i).Contains(point)) {
				shapeList.get(i).setFillColor(Color.RED);
				return shapeList.get(i);
			}
		}
		return null;
	}

	/**
	 * Транслация на избраният елемент на вектор определен от <paramref name="p>p<
	 * paramref>
	 * 
	 * @param p - Вектор на транслация.
	 */
	public void TranslateTo(Point p) {
		if (selection != null) {
//			selection.moveTranslateTo(p, this.lastLocation);
			selection.setLocation(new Point(selection.getLocation().x + p.x - lastLocation.x,
					selection.getLocation().y + p.y - lastLocation.y));
			lastLocation = p;
		}
	}
	//

	public draw.Model.Shape getSelection() {
		return selection;
	}

	public void setSelection(draw.Model.Shape value) {
		selection = value;
	}

	public void setBorderColor(Color color) {
		selection.setBorderColor(color);
	}

	public void setFillColor(Color color) {
		selection.setFillColor(color);
	}

	public void setBorderSize(ShapeBorderSize shapeBorderSize) {
		selection.setBorderSize(shapeBorderSize);
	}

	// public boolean getIsDragging() {
	// return isDragging;
	// }

	// public void setIsDragging(boolean value) {
	// isDragging = value;
	// }

	public Point getLastLocation() {
		return lastLocation;
	}

	public void setLastLocation(Point value) {
		lastLocation = value;
	}
	
	public Point getStartPoint() {
		return startPoint;
	}
	
	public void setStartPoint(Point newStartPoint) {
		startPoint = newStartPoint;
	}

	public Point getEndPoint() {
		return endPoint;
	}
	
	public void setEndPoint(Point newEndPoint) {
		endPoint = newEndPoint;
	}
	
	public void rotate() {
		
	}
}
