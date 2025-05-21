package Week1;
import java.util.Scanner;

/**
Bài tập 6: Đổi điểm số sang chữ 
Yêu cầu: Nhập điểm (0–10) → chuyển sang xếp loại chữ: 
A: 8–10 
B: 7–7.9 
C: 5.0–6.9 
D: dưới 5.0
 */
public class Ex6 {
    private static Scanner input = new Scanner(System.in, "UTF-8");
    public static void main(String[] args) {
        System.out.print("Nhập điểm của bạn: ");
        double point = input.nextDouble();
        System.out.println("Xếp loại của bạn: " + convert_point_to_grade(point));
        input.close();
    }

    public static String convert_point_to_grade(double point){
        if(point >= 8 && point <= 10){
            return "A";
        }
        else if(point >= 7 && point < 8){
            return "B";
        }
        else if(point >= 5 && point < 7){
            return "C";
        }
        else{
            return "D";
        }
    }
}
