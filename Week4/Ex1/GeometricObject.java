package Week4.Ex1;
import java.sql.Date;


public class GeometricObject {
    // Attribute
    private String color;
    private boolean filled;
    private Date createdDate;

    // Properties
    public String getColor() { return color;}
    public void setColor(String color) { this.color = color;}
    public boolean isFilled() { return filled;}
    public void setFilled(boolean filled) { this.filled = filled;}
    public Date getCreatedDate() { return createdDate = new Date(System.currentTimeMillis());}


    // Constructor
    public GeometricObject() {}

    public GeometricObject(String color, boolean filled) {
        this.color = color;
        this.filled = filled;
    }
    
    // Method
    @Override
    public String toString() {
        return "GeometricObject [color=" + color + ", filled=" + filled + ", createdDate=" + createdDate + "]";
    }
}



