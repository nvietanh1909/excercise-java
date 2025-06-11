package Week4.Ex2;

public class CongThucTinh implements CongThuc {
    private double sHV, sHCN, cHV, cHCN;

    @Override
    public void sHV(double a) {
        this.sHV = a * a;
    }

    @Override
    public void sHCN(double a, double b) {
        this.sHCN = a * b;
    }

    @Override
    public void cHV(double a) {
        this.cHV = 4 * a;
    }

    @Override
    public void cHCN(double a, double b) {
        this.cHCN = 2 * (a + b);
    }

    public double getSHV() {
        return sHV;
    }

    public double getSHCN() {
        return sHCN;
    }

    public double getCHV() {
        return cHV;
    }

    public double getCHCN() {
        return cHCN;
    }
}
