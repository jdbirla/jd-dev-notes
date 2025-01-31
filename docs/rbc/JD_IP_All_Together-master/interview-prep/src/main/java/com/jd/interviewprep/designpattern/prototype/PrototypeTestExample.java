package com.jd.interviewprep.designpattern.prototype;

import java.util.HashMap;
import java.util.Map;

public class PrototypeTestExample {
	public static void main(String[] args) {
	    ShapeCache.loadCache();

	    PrototypeExample clonedCircle = ShapeCache.getShape("Circle");
	    System.out.println("Cloned Circle Type: " + clonedCircle.getType());

	    PrototypeExample clonedRectangle = ShapeCache.getShape("Rectangle");
	    System.out.println("Cloned Rectangle Type: " + clonedRectangle.getType());
	}
	}

abstract class PrototypeExample implements Cloneable {
    protected String type;

    abstract void draw();

    public String getType() {
        return type;
    }

    @Override
    public PrototypeExample clone() {
        PrototypeExample clone = null;
        try {
            clone = (PrototypeExample) super.clone();
        } catch (CloneNotSupportedException e) {
            e.printStackTrace();
        }
        return clone;
    }
}

class Circle extends PrototypeExample {
    public Circle() {
        type = "Circle";
    }

    @Override
    public void draw() {
        System.out.println("Drawing a circle");
    }
}

class Rectangle extends PrototypeExample {
    public Rectangle() {
        type = "Rectangle";
    }

    @Override
    public void draw() {
        System.out.println("Drawing a rectangle");
    }
}

class ShapeCache {
    private static Map<String, PrototypeExample> shapeMap = new HashMap<>();

    public static PrototypeExample getShape(String type) {
        PrototypeExample cachedShape = shapeMap.get(type);
        return cachedShape.clone();
    }

    public static void loadCache() {
        Circle circle = new Circle();
        shapeMap.put(circle.getType(), circle);

        Rectangle rectangle = new Rectangle();
        shapeMap.put(rectangle.getType(), rectangle);
    }
}


