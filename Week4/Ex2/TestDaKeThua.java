package Week4.Ex2;

public class TestDaKeThua {
    public static void main(String[] args) {
        CongThucTinh congThuc = new CongThucTinh();

        congThuc.sHV(5);
        congThuc.cHV(5);
        System.out.printf("Square: Area=%.2f, Perimeter=%.2f%n", congThuc.getSHV(), congThuc.getCHV());

        congThuc.sHCN(6, 4);
        congThuc.cHCN(6, 4);
        System.out.printf("Rectangle: Area=%.2f, Perimeter=%.2f%n", congThuc.getSHCN(), congThuc.getCHCN());
    }
}
