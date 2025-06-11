package Week2;
import java.util.Scanner;

public class Ex2 {

    private static Scanner input = new Scanner(System.in, "UTF-8");

    public static void main(String[] args) {
        // In 2 dòng đầu tiên là 4 dấu *
        for (int i = 0; i < 2; i++) {
            for (int j = 0; j < 4; j++) {
                System.out.print("*");
            }
            System.out.println();
        }
        
        for (int i = 2; i <= 4; i++) {
            // In các số giảm dần từ i về 2
            for (int j = i; j >= 2; j--) {
                System.out.print(j + " ");
            }
            // In 4 dấu *
            for (int k = 0; k < 4; k++) {
                System.out.print("*");
            }
            System.out.println();
        }
        input.close();
    }
   
}