package Week1;
import java.util.Scanner;

/**
Bài tập 8: Tính BMI và phân loại cơ thể 
Yêu cầu: BMI=cân nặng / (chiều cao * chiều cao) 
BMI <18.5: Gầy 
BMI<24.9: Bình thường 
BMI<29.9: Thừa cân 
BMI>=29.9: Béo ph
 */

public class Ex8 {
    private static Scanner input = new Scanner(System.in, "UTF-8");
    public static void main(String[] args) {
        System.out.print("Nhập cân nặng (kg): ");
        double weight = input.nextDouble();
        System.out.print("Nhập chiều cao (m): ");
        double height = input.nextDouble();
        calculate_bmi(weight, height);
        input.close();
    }
    
    public static void calculate_bmi(double weight, double height){
        double bmi = weight / (height * height);
        System.out.println("BMI: " + (double)Math.round(bmi * 100) / 100);
        if(bmi < 18.5 && bmi > 0){
            System.out.println("Gầy");
        }
        else if(bmi < 24.9 && bmi >= 18.5){
            System.out.println("Bình thường");
        }
        else if(bmi < 29.9 && bmi >= 24.9){
            System.out.println("Thừa cân");
        }
        else{
            System.out.println("Béo phì");
        }
    }
   
}