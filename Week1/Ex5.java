package Week1;
import java.util.Scanner;

/**
Bài tập 5: Tính thuế thu nhập cá nhân đơn giản 
Yêu cầu: Nhập thu nhập/tháng và tính thuế phải nộp theo quy tắc: 
<= 5 triệu: không thuế 
5 triệu và <= 10 triệu: thuế 10% 
10 triệu và <= 18 triệu: thuế 15% 
18 triệu: thuế 20% 
 */

public class Ex5 {
    private static Scanner input = new Scanner(System.in, "UTF-8");
    public static void main(String[] args) {
        System.out.print("Nhập lương của bạn: ");
        double salary = input.nextDouble();
        System.out.println("Thuế phải nộp: " + calculate_tax_person(salary));
        input.close();
    }

    public static double calculate_tax_person(double salary){
        if(salary < 5000000 && salary >= 0){
            return 0;
        }
        else if(salary <= 10000000 && salary >= 5000000){
            return salary * 0.1;
        }
        else if(salary <= 18000000 && salary >= 10000000){
            return salary * 0.15;
        }
        else{
            return salary * 0.2;
        }
    }
}
