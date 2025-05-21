package Week1;
import java.util.concurrent.ThreadLocalRandom;
import java.util.Scanner;

/**
Bài tập 1: Viết chương trình xổ số 
Yêu cầu: người dùng nhập vào 1 số dự đoán. -Chương trình cho ra một số ngẫu nhiên gồm 2 chữ số 
Trường hợp 1: Nếu đáp án người chơi trùng khớp với số của máy thì giải 
thưởng là $10.000 
Trường hợp 2: Nếu các chữ số của người chơi khớp với các chữ số của máy, 
mặc dù thứ tự không khớp. Ví dụ: người chơi 34, máy 43 thì cũng được thưởng 
$3.000 
Trường hợp 3: Nếu các chữ số của người chơi khớp 1 chữ số so với máy thì 
được thưởng $1.000 
Trường hợp 4: Nếu không trùng khớp thì in ra thông báo “Sorry, no match”.
 */

 class Ex1 {
    private static Scanner input = new Scanner(System.in, "UTF-8");
    public static void main(String[] args) {
        menu();
        input.close();
    }

    public static void menu(){
        System.out.println("Chương trình xổ số");

        int randomNumber = ThreadLocalRandom.current().nextInt(10, 100);

        System.out.println("Nhập vào 1 số dự đoán: ");
        int number_guess = input.nextInt();
        
        System.out.println("Số ngẫu nhiên: " + randomNumber);
        System.out.println("Số dự đoán của bạn: " + number_guess);

        if(number_guess == randomNumber){
            System.out.println("Chúc mừng bạn nhận được $10.000");
        }
        else if(check_match_2_number(number_guess, randomNumber)){
            System.out.println("Chúc mừng bạn nhận được $3.000 ");
        }
        else if(check_match_1_number(number_guess, randomNumber)){
            System.out.println("Chúc mừng bạn nhận được $1.000");
        }
        else{
            System.out.println("Sorry, no match");
        }
    }

    public static boolean check_match_2_number(int number_guess, int randomNumber){
        int a = number_guess / 10;
        int _a = number_guess % 10;

        int b = randomNumber / 10;
        int _b = randomNumber % 10;

        return (a == b && _a == _b) || (a == _b && _a == b);
    }

    public static boolean check_match_1_number(int number_guess, int randomNumber){
        int a = number_guess / 10;
        int _a = number_guess % 10;

        int b = randomNumber / 10;
        int _b = randomNumber % 10;

        return (a == b || a == _b || _a == b || _a == _b);
    }
}