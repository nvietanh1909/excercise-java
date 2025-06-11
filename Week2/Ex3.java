package Week2;

public class Ex3 {
    public static void main(String[] args) {
        for (int i = 1; i <= 10; i++) {
            printPyramid(i);
        }
        System.out.println();
        printPowerTriangle(7);
        System.out.println();
        printLeftTriangle(6);
        System.out.println();
        printRightTriangle(6);
        System.out.println();
        printLeftReverseTriangle(6);
        System.out.println();
        printRightReverseTriangle(6);
    }

    public static void printPyramid(int n) {
        // In khoảng trắng để căn giữa
        for (int i = 0; i < 10 - n; i++) {
            System.out.print("  ");
        }
        // In dãy số giảm dần từ n về 1
        for (int i = n; i >= 1; i--) {
            System.out.print(i + " ");
        }
        // In dãy số tăng dần từ 2 đến n
        for (int i = 2; i <= n; i++) {
            System.out.print(i + " ");
        }
        System.out.println();
    }

    public static void printPowerTriangle(int n) {
        for (int i = 0; i < n; i++) {
            // In khoảng trắng căn giữa
            for (int j = 0; j < n - i; j++) {
                System.out.print("  ");
            }
            // In dãy số mũ 2 tăng dần
            int val = 1;
            for (int j = 0; j <= i; j++) {
                System.out.print(val + " ");
                val *= 2;
            }
            // In dãy số mũ 2 giảm dần
            val /= 4;
            for (int j = 0; j < i; j++) {
                System.out.print(val + " ");
                val /= 2;
            }
            System.out.println();
        }
    }

    public static void printLeftTriangle(int n) {
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= i; j++) {
                System.out.print(j + " ");
            }
            System.out.println();
        }
    }

    public static void printRightTriangle(int n) {
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= n - i; j++) {
                System.out.print("  ");
            }
            for (int j = i; j >= 1; j--) {
                System.out.print(j + " ");
            }
            System.out.println();
        }
    }

    public static void printLeftReverseTriangle(int n) {
        for (int i = 1; i <= n; i++) {
            for (int j = i; j >= 1; j--) {
                System.out.print(j + " ");
            }
            System.out.println();
        }
    }
    
    public static void printRightReverseTriangle(int n) {
        for (int i = n; i >= 1; i--) {
            for (int j = 1; j <= n - i; j++) {
                System.out.print("  ");
            }
            for (int j = 1; j <= i; j++) {
                System.out.print(j + " ");
            }
            System.out.println();
        }
    }
}