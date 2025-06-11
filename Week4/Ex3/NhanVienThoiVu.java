package Week4.Ex3;

public class NhanVienThoiVu extends NhanVien {
    // Attribute
    private int SoNLV;
    private final int THU_LAO = 50000;

    // Properties
    public int getSoNLV() { return SoNLV;}
    public void setSoNLV(int SoNLV) { this.SoNLV = SoNLV;}

    // Constructor
    public NhanVienThoiVu(int SoNLV, String CMND, String ten, int ma, int namSinh) {
        super(CMND, ten, ma, namSinh);
        this.SoNLV = SoNLV;
    }

    // Method
    public String printInfoTV() {
        return super.printInfo() + ", SoNLV=" + SoNLV + ", Luong=" + String.format("%.0f", tinhLuong());
    }

    @Override
    public double tinhLuong() {
        return SoNLV * THU_LAO;
    }
}
