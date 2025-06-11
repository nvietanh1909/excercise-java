package Week4.Ex1;

import java.util.Scanner;

public class TestGeometric {
    public static Scanner input = new Scanner(System.in, "UTF-8");
    public static void main(String[] args) {
        Circle circle = new Circle();
        Rectangle rectangle = new Rectangle();

        inputCircle(circle);
        inputRectangle(rectangle);

        System.out.println(circle);
        System.out.println(rectangle);
    }

    public static void inputCircle(Circle circle) {
        boolean filled;
        System.out.print("Nhập bán kính: ");
        circle.setRadius(input.nextDouble());
        input.nextLine();
        System.out.print("Nhập màu sắc: ");
        circle.setColor(input.nextLine());
        do {
            System.out.print("Nhập trạng thái (true/false): ");
            try {
                filled = input.nextBoolean();
                break;
            } catch (Exception e) {
                System.out.println("Vui lòng nhập true hoặc false!");
                input.nextLine();
            }
        } while (true);
        circle.setFilled(filled);
    }

    public static void inputRectangle(Rectangle rectangle) {
        boolean filled;
        System.out.print("Nhập chiều dài: ");
        rectangle.setWidth(input.nextDouble());
        input.nextLine();
        System.out.print("Nhập chiều rộng: ");
        rectangle.setHeight(input.nextDouble());
        input.nextLine();
        System.out.print("Nhập màu sắc: ");
        rectangle.setColor(input.nextLine());
        do {
            System.out.print("Nhập trạng thái (true/false): ");
            try {
                filled = input.nextBoolean();
                break;
            } catch (Exception e) {
                System.out.println("Vui lòng nhập true hoặc false!");
                input.nextLine();
            }
        } while (true);
        rectangle.setFilled(filled);
    }
}
