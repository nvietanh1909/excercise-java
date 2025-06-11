package Week4.Ex3;

import java.util.Scanner;

public class TestNhanVien {

    public static void main(String[] args){
        NhanVien[] nhanViens = new NhanVien[2];
        nhanViens[0] = new NhanVienThoiVu(20, "123456789", "Nguyen Van A", 1, 1990);
        nhanViens[1] = new NhanVienChinhThuc(22, "987654321", "Tran Thi B", 2, 1995);

        for (NhanVien nv : nhanViens) {
            if (nv instanceof NhanVienThoiVu) {
                System.out.println(((NhanVienThoiVu) nv).printInfoTV());
            } else if (nv instanceof NhanVienChinhThuc) {
                System.out.println(((NhanVienChinhThuc) nv).printInfoCT());
            }
        }
    }
}
