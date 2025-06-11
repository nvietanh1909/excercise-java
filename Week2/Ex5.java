package Week2;

import java.util.Scanner;

public class Ex5 {
    private static Scanner sc = new Scanner(System.in);
    public static void main(String[] args) {
        menu();
        sc.close();
    }

    public static void menu() {
        final double BASE_SALARY = 5000;
        final double TARGET_INCOME = 30000;
        double sales = 0;
        while (true) {
            System.out.print("Nhập doanh số bán hàng (Sales Amount): ");
            sales = sc.nextDouble();
            double commission = calcCommission(sales);
            double totalIncome = BASE_SALARY + commission;
            System.out.printf("Tổng thu nhập: %.2f\n", totalIncome);
            if (totalIncome >= TARGET_INCOME) {
                System.out.printf("Đủ điều kiện: Doanh số %.2f giúp đạt thu nhập >= 30,000$\n", sales);
                break;
            } else {
                System.out.println("Chưa đủ 30,000$. Hãy thử doanh số cao hơn!");
            }
        }
    }

    public static double calcCommission(double sales) {
        double commission = 0;
        if (sales > 10000) {
            commission += (sales - 10000) * 0.12;
            sales = 10000;
        }
        if (sales > 5000) {
            commission += (sales - 5000) * 0.10;
            sales = 5000;
        }
        if (sales > 0) {
            commission += sales * 0.08;
        }
        return commission;
    }
}
