package Week4.Ex1;

public class Circle extends GeometricObject {
    // Attribute
    private double radius;

    // Properties
    public double getRadius() { return radius;}
    public void setRadius(double radius) { this.radius = radius;}
    public double getDiameter() { return 2 * radius;}
    public double getPerimeter() { return 2 * Math.PI * radius;}
    public double getArea() { return Math.PI * radius * radius;}

    // Constructor
    public Circle() {}
    public Circle (double radius, String color, boolean filled) {
        super(color, filled);
        this.radius = radius;
    }

    // Method
    @Override
    public String toString() {
        return "Circle [radius=" + radius + ", color=" + getColor() + ", filled=" + isFilled() + ", createdDate=" + getCreatedDate() + "]";
    }
}
