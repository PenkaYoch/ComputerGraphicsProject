/**
 * DialogProcessor.java
 */

package draw.Processors;

import java.awt.*;
import java.awt.geom.AffineTransform;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.Vector;

import javax.swing.JColorChooser;
import javax.swing.JFileChooser;
import javax.swing.JFrame;

import draw.Model.EllipseShape;
import draw.Model.RectangleShape;
import draw.Model.SegmentShape;
import draw.Model.Shape;
import draw.Model.SquareShape;
import draw.Model.TriangleShape;
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
        Point[] points = new Point[]{new Point(values[0], values[1]), new Point(values[2], values[1]), new Point(values[2], values[3]), new Point(values[0], values[3])};
        rect.setPoints(points);
		rect.setFinishDrawing(isFinishDrawing);
		rect.setFillColor(java.awt.Color.WHITE);
		rect.setBorderColor(java.awt.Color.BLUE);
		shapeList.add(rect);
	}

	 /**
     * Добавя примитив - правоъгълник на произволно място върху клиентската област.
     */
    public void AddRandomRectangle() {
        int x = 100 + (int)Math.round(Math.random()*900);
        int y = 100 + (int)Math.round(Math.random()*500);
        draw.Model.RectangleShape rect = new draw.Model.RectangleShape(new Rectangle(x,y,100,200));
        rect.setFillColor(java.awt.Color.WHITE);
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

	  public void AddRandomCircle() {
		  int x = 100 + (int) Math.round(Math.random() * 900);
			int y = 100 + (int) Math.round(Math.random() * 500);
//			int[] values = DimentionUtils.findShapeBetweenTwoPoints(this.startPoint, this.endPoint);
			// x
			// y
			// width
			// height
			draw.Model.NewEllipseShape rect = new draw.Model.NewEllipseShape(
					new Rectangle(x, y, 100, 100));
			rect.setFinishDrawing(true);
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
		draw.Model.TriangleShape rect = new draw.Model.TriangleShape(new Rectangle(0, 0, 100, 100));
        Point[] points = new Point[]{point1, point2, point3};
        rect.setPoints(points);
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
				Color recentColor = shapeList.get(i).getFillColor();
				shapeList.get(i).setFillColor(Color.GREEN);
//				shapeList.get(i).setFillColor(recentColor);
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
	
	
	public void rotateByPoints() {
		Point[] recentPoints = selection.getPoints();
		for(int i = 0; i < selection.getPoints().length; i++) {
			double newX = rotateXPoint(recentPoints[i]);
			double newY = rotateYPoint(recentPoints[i]);
			recentPoints[i].setLocation(newX, newY);
		}
	}
	
	private double rotateXPoint(Point p1) {
		return p1.getX() * Math.sin(Math.toRadians(45)) + p1.getY() * Math.cos(Math.toRadians(45));
	}
	
	private double rotateYPoint(Point p1) {
		return p1.getX() * Math.sin(Math.toRadians(45)) + p1.getY() * Math.cos(Math.toRadians(45));
	}

	 /**
     * Добавя примитив - правоъгълник на произволно място върху клиентската област.
     */
    public void AddNewRandomRectangle() {
    	int x = 100 + (int) Math.round(Math.random() * 900);
		int y = 100 + (int) Math.round(Math.random() * 500);
		draw.Model.NewRectangleShape rect = new draw.Model.NewRectangleShape(new Rectangle(x, y, 200, 100));
		rect.setFillColor(java.awt.Color.WHITE);
		rect.setBorderColor(java.awt.Color.BLUE);
		shapeList.add(rect);
    }
	
    public void rotate(boolean isRight) {
    	
        double angle = 45.0d;
        if(isRight) {
        	angle = angle*(-45d);
        }

        double rads = Math.toRadians(angle);
        double sin = Math.abs(Math.sin(rads));
        double cos = Math.abs(Math.cos(rads));
        
        int w = this.selection.getWidth();
        int h = this.selection.getHeight();
        int newWidth = (int) Math.floor(w * cos + h * sin);
        int newHeight = (int) Math.floor(h * cos + w * sin);
        AffineTransform at = new AffineTransform();
//       ---------------------------
//        промяна на мащаба (scale) и преместване (translation)
//       ---------------------------
        // translation
        at.translate((newWidth - w) / 2, (newHeight - h) / 2);
        // scale
        at.scale(0.5, 0.5);
        int x = w / 2; 
        int y = h / 2;

        at.rotate(rads, x, y);
        selection.setTransformMatrix(at);
        
        // other way using quadrant - 90 degree
////        ---------------------
////        at.translate(100, 40);
////        at.quadrantRotate(1, w / 2, h / 2);
    }
	
    public void serializeObject() {
	
    	File fileToSave = null;
   	// parent component of the dialog
   		JFrame parentFrame = new JFrame();
   		 
   		JFileChooser fileChooser = new JFileChooser();
   		fileChooser.setDialogTitle("Specify a file to save");   
   		 
   		int userSelection = fileChooser.showSaveDialog(parentFrame);
   		 
   		if (userSelection == JFileChooser.APPROVE_OPTION) {
   		    fileToSave = fileChooser.getSelectedFile();
   		    System.out.println("Save as file: " + fileToSave.getAbsolutePath());
   		} else { 
   			return; 
   		}
        // Serialization 
        try
        {   
            //Saving of object in a file
            FileOutputStream file = new FileOutputStream(fileToSave.getAbsolutePath());
            ObjectOutputStream out = new ObjectOutputStream(file);
              
            // Method for serialization of object'
            for(Shape object : shapeList) {
             out.writeObject(object);
            }
            
            out.close();
            file.close();
              
            System.out.println("Object has been serialized");

        }
          
        catch(IOException ex)
        {
            System.out.println("IOException is caught");
        }

   	}
   	
   	public void deserializeObject() {
   	
        FileDialog fd = new FileDialog(new JFrame());
        fd.setVisible(true);
          
        // Deserialization
        try
        {   
        	String filePath = fd.getFiles()[0].getAbsolutePath();
            // Reading the object from a file
            FileInputStream file = new FileInputStream(filePath);
            ObjectInputStream in = new ObjectInputStream(file);
            
            // clear array with objects -> shapeList
            shapeList.removeAllElements();
            
            Object object = in.readObject();
            this.findTypeAndAddToList(object);

            // Method for deserialization of object
            while (object != null) {
                object = in.readObject();
                this.findTypeAndAddToList(object);
            }

            in.close();
            file.close();
              
            System.out.println("Object has been deserialized ");
            System.out.println(shapeList);
        }
          
        catch(IOException ex)
        {
            System.out.println("IOException is caught");
        }
          
        catch(ClassNotFoundException ex)
        {
            System.out.println("ClassNotFoundException is caught");
        }
   	
    }
   	
   	private void findTypeAndAddToList(Object object) {
   		if(object instanceof RectangleShape) {
    		shapeList.add((RectangleShape)object);
    		
    	} else if(object instanceof SquareShape) {
    		shapeList.add((SquareShape)object);
    		
    	} else if(object instanceof SegmentShape) {
    		shapeList.add((SegmentShape)object);
    		
    	} else if(object instanceof EllipseShape) {
    		shapeList.add((EllipseShape)object);
    		
    	} else if(object instanceof TriangleShape) {
    		shapeList.add((TriangleShape)object);
    		
    	}
   	}
}
