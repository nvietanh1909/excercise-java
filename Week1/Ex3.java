package Week1;

import java.util.Scanner;

/**
Bài tập 3: Tính tiền điện 
Yêu cầu: Nhập số kWh điện sử dụng trong tháng và tính tiền theo bảng giá: 
0–50 kWh đầu: 1.678 đ/kWh 
51–100 kWh tiếp theo: 1.734 đ/kWh 
Trên 100 kWh: 2.014 đ/kWh 
 */

public class Ex3 {
    private static Scanner input = new Scanner(System.in, "UTF-8");
    public static void main(String[] args) {
        System.out.println("Nhập số kWh điện sử dụng trong tháng: ");
        int kWh = input.nextInt();
        System.out.println("Tiền điện là: " + calculate_electricity_bill(kWh));
        input.close();
    }
    
    public static int calculate_electricity_bill(int kWh){
        if(kWh <= 50 && kWh >= 0){
            return kWh * 1678;
        }
        else if(kWh <= 100 && kWh >= 51){
            return 50 * 1678 + (kWh - 50) * 1734;
        }
        else{
            return 50 * 1678 + 50 * 1734 + (kWh - 100) * 2014;
        }
    }
}
