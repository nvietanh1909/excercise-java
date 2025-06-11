package Week2;
import java.util.Scanner;

class Ex1 {
    private static Scanner input = new Scanner(System.in, "UTF-8");

    public static void main(String[] args) {
        System.out.print("Nhập một số nguyên dương: ");
        int n = input.nextInt();
        if (n <= 1 && n < 10) {
            System.out.println("Vui lòng nhập một số nguyên dương.");
        } else {
            multiplication_table(n);
        }
        input.close();
    }

    public static void multiplication_table(int n){
        System.out.print("    ");
        for (int j = 1; j <= n; j++) {
            System.out.print(j + "   ");
        }
        System.out.println("\n----------------------------------------------------");

        for (int i = 1; i <= 9; i++) {
            System.out.print(i + " | ");
            for (int j = 1; j <= 9; j++) {
                System.out.printf("%-3d ", i * j);
            }
            System.out.println();
            if (i < 9) System.out.println("\n----------------------------------------------------");
        }
    }
}