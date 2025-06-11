package Week4.Ex3;

public class NhanVienChinhThuc extends NhanVien {
    // Attribute
    private int SoNgayLam;
    private final int LUONG_CO_BAN = 4500000;

    // Properties
    public int getSoNgayLam() { return SoNgayLam;}
    public void setSoNgayLam(int SoNgayLam) { this.SoNgayLam = SoNgayLam;}

    // Constructor
    public NhanVienChinhThuc(int SoNgayLam, String CMND, String ten, int ma, int namSinh) {
        super(CMND, ten, ma, namSinh);
        this.SoNgayLam = SoNgayLam;
    }

    // Method
    public String printInfoCT() {
        return super.printInfo() + ", SoNgayLam=" + SoNgayLam + ", Luong=" + String.format("%.0f", tinhLuong());
    }

    @Override
    public double tinhLuong() {
        return SoNgayLam * LUONG_CO_BAN;
    }
}
