package Week3;
import java.util.regex.Pattern;
import java.util.Scanner;

/*
    Bài 1: Kiểm tra mật khẩu 
    Một số trang web áp đặt các quy tắc nhất định cho mật khẩu, hãy viết chương trình kiểm 
    tra xem một chuỗi có phải là mật khẩu hợp lệ không. Trường hợp mật khẩu hợp lệ phải 
    thỏa yêu cầu: - - - 
    Ít nhất có 8 ký tự 
    Chỉ chứa số và chữ cái 
    Phải có ít nhất 2 chữ số
*/
public class Ex1 {
    private static Scanner input = new Scanner(System.in, "UTF-8");

    public static void main(String[] args) {
        System.out.print("Nhập mật khẩu: ");
        String password = input.nextLine();
        if(checkPassword(password)) {
            System.out.println("Mật khẩu hợp lệ");
        } else {
            System.out.println("Mật khẩu không hợp lệ");
        }
        input.close();
    }

    public static boolean checkPassword(String password) {
        if(password.length() < 8) {
            return false;
        }
        if(!password.matches("^[a-zA-Z0-9]+$")) {
            return false;
        }
        if(!password.matches("^(?=(?:.*\\d){2,})[a-zA-Z0-9]+$")) {
            return false;
        }
        return true;
    }
}
