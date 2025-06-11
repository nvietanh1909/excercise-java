package Week3;
import java.util.Scanner;

/*
    Bài 2: Quản lý thu chi cá nhân đơn giản 
    Mô tả: 
    1) Xây dựng chương trình có menu lựa chọn: 
    2) Nhập khoản thu 
    3) Nhập khoản chi 
    4) Hiển thị tổng thu, tổng chi, số dư 
    5) Thoát 
    Yêu cầu: Viết mỗi chức năng thành một hàm riêng
*/
public class Ex2 {
    private static Scanner input = new Scanner(System.in, "UTF-8");

    public static void main(String[] args) {
        menu();
        input.close();
    }

    public static void menu() {
        double income = 0;
        double expense = 0;

        while (true) {
            int choice;
            do {
                System.out.println("1. Nhập khoản thu");
                System.out.println("2. Nhập khoản chi");
                System.out.println("3. Hiển thị tổng thu, tổng chi, số dư");
                System.out.println("4. Thoát");
                System.out.print("Chọn chức năng: ");
                choice = input.nextInt();
            } while (choice < 1 || choice > 4);

            switch (choice) {
                case 1:
                    income += inputIncome();
                    System.out.println("Khoản thu đã nhập: " + income);
                    break;
                case 2:
                    expense = inputExpense();
                    System.out.println("Khoản chi đã nhập: " + expense);
                    break;
                case 3:
                    displayBalance(income, expense);
                    break;
                default:
                    System.out.println("Thoát");
                    break;
            }

            if (choice == 4) {
                break;
            }
        }
    }

    public static double inputIncome() {
        System.out.print("Nhập khoản thu: ");
        double income = input.nextDouble();

        return income;
    }

    public static double inputExpense() {
        System.out.print("Nhập khoản chi: ");
        double expense = input.nextDouble();

        return expense;
    }

    public static void displayBalance(double income, double expense) {
        double balance = income - expense;
        System.out.printf("Tổng thu: %.2f\n", income);
        System.out.printf("Tổng chi: %.2f\n", expense);
        System.out.printf("Số dư: %.2f\n", balance);
    }

}
