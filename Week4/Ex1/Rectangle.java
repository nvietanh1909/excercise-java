package Week4.Ex1;

public class Rectangle extends GeometricObject {
    // Attribute
    private double width;
    private double height;

    // Properties
    public double getWidth() { return width;}
    public void setWidth(double width) { this.width = width;}
    public double getHeight() { return height;}
    public void setHeight(double height) { this.height = height;}
    public double getArea() { return width * height;}
    public double getPerimeter() { return 2 * (width + height);}

    // Constructor
    public Rectangle() {};

    public Rectangle(double width, double height, String color, boolean filled) {
        super(color, filled);
        this.width = width;
        this.height = height;
    }

    // Method
    @Override
    public String toString() {
        return "Rectangle [width=" + width + ", height=" + height + ", color=" + getColor() + ", filled=" + isFilled() + ", createdDate=" + getCreatedDate() + "]";
    }
}
