package Week2;

import java.util.Scanner;

public class Ex4 {
    private static Scanner sc = new Scanner(System.in);
    public static void main(String[] args) {
        menu();
        sc.close();
    }

    public static void menu() {
        System.out.print("Nhập số học sinh: ");
        int n = sc.nextInt();
        String tenMax = "";
        double diemMax = -1;
        for (int i = 1; i <= n; i++) {
            System.out.print("Nhập họ tên học sinh thứ " + i + ": ");
            String ten = sc.next();
            System.out.print("Nhập điểm: ");
            double diem = sc.nextDouble();
            if (diem > diemMax) {
                diemMax = diem;
                tenMax = ten;
            }
        }
        System.out.println("Học sinh có điểm cao nhất: " + tenMax);
    }
}
