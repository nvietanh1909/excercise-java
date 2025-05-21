package Week1;
import java.util.Scanner;

/**
Bài tập 2: Kiểm tra năm nhuận 
Yêu cầu: Nhập một năm, kiểm tra xem năm đó có phải năm nhuận hay không. 
Điều kiện: 
Năm nhuận chia hết cho 4 và không chia hết cho 100, hoặc chia hết cho 400.
 */

public class Ex2 {
    private static Scanner input = new Scanner(System.in, "UTF-8");
    public static void main(String[] args) {
        System.out.println("Nhập vào một năm: ");
        int year = input.nextInt();

        if(check_leap_year(year)){
            System.out.println("Năm " + year + " là năm nhuận");
        }
        else{
            System.out.println("Năm " + year + " không phải là năm nhuận");
        }
        input.close();
    }

    public static boolean check_leap_year(int year){
        return (year % 4 == 0 && year % 100 != 0) || (year % 400 == 0);
    }
}
