package Week1;
import java.util.Scanner;

/**
Bài tập 7: Tính tiền taxi theo số km 
Yêu cầu: 
Km đầu tiên: 15.000đ 
km tiếp theo đến 5 km: 13.500đ/km 
Trên 5 km: 11.000đ/km 
Nếu > 120km → giảm 10% tổng tiền 
 */
public class Ex7 {
    private static Scanner input = new Scanner(System.in, "UTF-8");
    public static void main(String[] args) {
       System.out.print("Nhập số km: ");
       int km = input.nextInt();
       System.out.println("Tổng tiền taxi: " + calculate_taxi(km));
       input.close();
    }

    public static double calculate_taxi(int km){
        if(km <= 1 && km >= 0){
            return 15000;
        }
        else if(km <= 5 && km > 1){
            return 15000 + (km - 1) * 13500;
        }
        else if(km > 5 && km <= 120){
            return (15000 + 4 * 13500 + (km - 5) * 11000);
        }
        else {
            return (15000 + 4 * 13500 + (km - 5) * 11000) * 0.9;
        }
    }
}
