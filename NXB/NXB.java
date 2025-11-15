package NXB;
import java.io.BufferedWriter;
import java.io.IOException;
import java.util.Scanner;
public class NXB {
    private String maNXB;
    private String tenNXB;
    private String sdt;

    public NXB() {
        this.maNXB = "";
        this.tenNXB = "";
        this.sdt = "";
    }

    public NXB(String maNXB, String tenNXB, String sdt) {
        this.maNXB = maNXB;
        this.tenNXB = tenNXB;
        this.sdt = sdt;
    }

    public void nhap(Scanner sc) {
        System.out.print("Nhap ma NXB: ");
        this.maNXB = sc.nextLine().trim();
        System.out.print("Nhap ten NXB: ");
        this.tenNXB = sc.nextLine().trim();
        System.out.print("Nhap so dien thoai NXB: ");
        this.sdt = sc.nextLine().trim();
    }

    public void xuat() {
        System.out.printf("Ma NXB: %s, Ten NXB: %s, So dien thoai: %s\n", maNXB, tenNXB, sdt);
    }

    public void ghiFile(BufferedWriter bw) throws IOException {
        bw.write(maNXB);
        bw.newLine();
        bw.write(tenNXB);
        bw.newLine();
        bw.write(sdt);
        bw.newLine();
    }

    public String getMaNXB() {
        return maNXB;
    }

    public String getTenNXB() {
        return tenNXB;
    }

    public String getSdt() {
        return sdt;
    }
    public void setMaNXB(String maNXB) {
        this.maNXB = maNXB;
    }
    public void setTenNXB(String tenNXB) {
        this.tenNXB = tenNXB;
    }
    public void setSdt(String sdt) {
        this.sdt = sdt;
    }

}