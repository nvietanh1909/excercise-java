package Week1;

import java.util.Scanner;

/**
Bài tập 4: Máy tính đơn giản 
Yêu cầu: Nhập hai số và phép toán (+, -, *, /), in ra kết quả tương ứng.
 */
public class Ex4 {
    private static Scanner input = new Scanner(System.in, "UTF-8");
    public static void main(String[] args) {
        System.out.println("Nhập vào số nguyên a: ");
        int a = input.nextInt();
        System.out.println("Nhập vào số nguyên b: ");
        int b = input.nextInt();
        System.out.println("Nhập vào phép tính bạn muốn tính (VD: +, -, *, /): ");
        String operator = input.next();
        calculate(a, b, operator);
        input.close();
    }

    public static void calculate(int a, int b, String operator){
        switch(operator){
            case "+":
                System.out.println(a + " + " + b + " = " + (a + b));
                break;
            case "-":
                System.out.println(a + " - " + b + " = " + (a - b));
                break;
            case "*":
                System.out.println(a + " * " + b + " = " + (a * b));
                break;
            case "/":
                System.out.println(a + " / " + b + " = " + (a / b));
                break;
        }
    }
}
