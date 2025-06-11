package Week3;
import java.util.Scanner;

/*
    Bài 3: Viết hàm in ra bảng  
    Thuế thu nhập cá nhân liên bang của Hoa Kỳ được tính dựa trên tình trạng khai thuế và thu 
    nhập chịu thuế. Có bốn trạng thái nộp đơn: người khai đơn lẻ, người kết hôn khai chung 
    hoặc góa phụ đủ điều kiện, người kết hôn khai riêng và chủ hộ. Thuế suất thay đổi hàng 
    năm. Bảng 3.2 cho thấy các mức thuế cho năm 2009. Ví dụ: nếu bạn độc thân có thu nhập 
    chịu thuế là $10.000, thì $8.350 đầu tiên bị đánh thuế ở mức 10% và $1.650 còn lại bị đánh 
    thuế ở mức 15%, vì vậy tổng số thuế của bạn là $1.082,50.  
    Đối với mỗi tình trạng nộp đơn có sáu mức thuế. Mỗi tỷ lệ được áp dụng cho một khoản 
    thu nhập chịu thuế nhất định. Ví dụ: đối với thu nhập chịu thuế là 400.000 đô la đối với 
    người khai thuế một mình, 8.350 đô la bị đánh thuế ở mức 10%, (33.950 - 8.350) ở mức 
    15%, (82.250 - 33.950) ở mức 25%, (171.550 - 82.250) ở mức 28%,  
    (372.950 - 171.550) ở mức 33% và (400.000 - 372.950) ở mức 35%.

    Bạn hãy viết chương trình tính thuế thu nhập cá nhân. Chương trình của bạn sẽ nhắc người 
    dùng nhập trạng thái nộp đơn và thu nhập chịu thuế và tính thuế. Nhập 0 cho người khai 
    độc thân, 1 cho người kết hôn khai chung hoặc góa phụ đủ điều kiện, 2 cho người kết hôn 
    khai riêng và 3 cho chủ hộ. 
 */

public class Ex3 {
    private static Scanner input = new Scanner(System.in, "UTF-8");

    public static void main(String[] args) {
        menu();
        input.close();
    }

    public static void menu() {
        int status = personStatus();
        double income = incomeTax();
        tax(income, status);
    }

    public static int personStatus() {
        int status;
        do {
            System.out.println("Nhập trạng thái nộp đơn: ");
            System.out.println("0: Người khai độc thân");
            System.out.println("1: Người kết hôn khai chung hoặc góa phụ đủ điều kiện");
            System.out.println("2: Người kết hôn khai riêng");
            System.out.println("3: Chủ hộ");
            status = input.nextInt();
        } while (status < 0 || status > 3);

        return status;
    }

    public static double incomeTax () {
        double incomeTax = 0;

        do {
            System.out.print("Nhập thu nhập chịu thuế: ");
            incomeTax = input.nextDouble();
        } while (incomeTax < 0);

        return incomeTax;
    }

    public static void tax(double income, int status) {
        double[] rates = {0.10, 0.15, 0.25, 0.28, 0.33, 0.35};
        switch (status) {
            case 0:
                System.out.println("Người khai độc thân");
                double[] thresholds_single = {8350, 33950, 82250, 171550, 372950};
                double tax_result_single =calculateTax(income, thresholds_single, rates);
                System.out.println("Thuế thu nhập cá nhân: " + tax_result_single);
                break;
            case 1:
                System.out.println("Người kết hôn khai chung hoặc góa phụ đủ điều kiện");
                double[] thresholds_married = {16700, 67900, 137050, 208850, 372950};
                double tax_result_married =calculateTax(income, thresholds_married, rates);
                System.out.println("Thuế thu nhập cá nhân: " + tax_result_married);
                break;
            case 2:
                System.out.println("Người kết hôn khai riêng");
                double[] thresholds_married_separate = {8350, 33950, 68525, 104425, 186475};
                double tax_result_married_separate =calculateTax(income, thresholds_married_separate, rates);
                System.out.println("Thuế thu nhập cá nhân: " + tax_result_married_separate);
                break;
            case 3:
                System.out.println("Chủ hộ");
                double[] thresholds_head_of_household = {11950, 45500, 117450, 190200, 372950};
                double tax_result_head_of_household =calculateTax(income, thresholds_head_of_household, rates);
                System.out.println("Thuế thu nhập cá nhân: " + tax_result_head_of_household);
                break;
            default:
                System.out.println("Trạng thái không hợp lệ");
                break;
        }
    }


    public static double calculateTax(double income, double[] thresholds, double[] rates) {  
        double tax = 0.0;
        double previousLimit = 0.0;  

        for (int i = 0; i < thresholds.length; i++) {
            if (income <= thresholds[i]) {
                tax += (income - previousLimit) * rates[i];
                return tax;
            } else {
                tax += (thresholds[i] - previousLimit) * rates[i];
                previousLimit = thresholds[i];
            }
        }
    
        tax += (income - previousLimit) * rates[rates.length - 1];
    
        return tax;
    }

}
