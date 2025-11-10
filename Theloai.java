import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.util.Scanner;

public class Theloai {
    private String maTL;
    private String tenTL;

    public Theloai() {
        maTL = "";
        tenTL = "";
    }

    public Theloai(String maTL, String tenTL) {
        this.maTL = maTL;
        this.tenTL = tenTL;
    }

    public Theloai(Theloai other) {
        this.maTL = other.maTL;
        this.tenTL = other.tenTL;
    }

    // Getter & Setter
    public String getMaTL() { return maTL; }
    public void setMaTL(String maTL) { this.maTL = maTL; }

    public String getTenTL() { return tenTL; }
    public void setTenTL(String tenTL) { this.tenTL = tenTL; }

    // Nhập từ file
    public void nhapTL(BufferedReader br) throws IOException {
        maTL = br.readLine().trim();
        tenTL = br.readLine().trim();
    }

    // Nhập từ bàn phím
    public void themTL() {
        Scanner sc = new Scanner(System.in);
        System.out.print("Nhập mã thể loại: ");
        maTL = sc.nextLine();
        System.out.print("Nhập tên thể loại: ");
        tenTL = sc.nextLine();
    }

    // Xuất ra màn hình
    public void xuat() {
        System.out.printf("%-10s | %-20s%n", maTL, tenTL);
    }

    // Ghi file
    public void ghifile(BufferedWriter bw, BufferedWriter wb) throws IOException {
        bw.write(String.format("%-10s | %-20s", maTL, tenTL));
        bw.newLine();

        wb.write(maTL);
        wb.newLine();
        wb.write(tenTL);
        wb.newLine();
    }
}
