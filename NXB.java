import java.util.Scanner;
public class NXB {
    private String maNXB;
    private String tenNXB;
    private int sdt;

    public NXB() {
        this.maNXB = "";
        this.tenNXB = "";
        this.sdt = 0;
    }

    public NXB(String maNXB, String tenNXB, int sdt) {
        this.maNXB = maNXB;
        this.tenNXB = tenNXB;
        this.sdt = sdt;
    }

    public void nhap(Scanner sc) {
        System.out.print("Nhap ma NXB: ");
        this.maNXB = sc.nextLine();
        System.out.print("Nhap ten NXB: ");
        this.tenNXB = sc.nextLine();
        System.out.print("Nhap so dien thoai NXB: ");
        this.sdt = sc.nextInt();
    }

    public void xuat() {
        System.out.printf("Ma NXB: %s, Ten NXB: %s, So dien thoai: %d\n", maNXB, tenNXB, sdt);
    }

    public String getMaNXB() {
        return maNXB;
    }

    public String getTenNXB() {
        return tenNXB;
    }

    public int getSdt() {
        return sdt;
    }
    public void setMaNXB(String maNXB) {
        this.maNXB = maNXB;
    }
    public void setTenNXB(String tenNXB) {
        this.tenNXB = tenNXB;
    }
    public void setSdt(int sdt) {
        this.sdt = sdt;
    }

}