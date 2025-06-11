package Week4.Ex3;

public abstract class NhanVien {
    // Attribute
    private String CMND, ten;
    private int ma, namSinh;

    // Properties
    public String getCMND() { return CMND;}
    public String getTen() { return ten;}
    public int getMa() { return ma;}
    public int getNamSinh() { return namSinh;}
    public void setTen(String ten) { this.ten = ten;}
    public void setNamSinh(int namSinh) { this.namSinh = namSinh;}

    // Constructor
    public NhanVien() {}

    public NhanVien(String CMND, String ten, int ma, int namSinh) {
        this.CMND = CMND;
        this.ten = ten;
        this.ma = ma;
        this.namSinh = namSinh;
    }

    // Method
    public String printInfo() {
        return "NhanVien [CMND=" + CMND + ", ten=" + ten + ", ma=" + ma + ", namSinh=" + namSinh + "]";
    }

    public abstract double tinhLuong();
}
