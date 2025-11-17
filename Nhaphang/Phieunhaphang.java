package Nhaphang;
import java.io.BufferedWriter;
import java.time.LocalDate;
import java.util.Scanner;
import java.io.IOException;

public class Phieunhaphang {
    Scanner sc = new Scanner(System.in);

    private String MaPN;
    private String MaNCC;
    private LocalDate ngaynhap;
    private float TongTien;
    private String maNV; 

    // Constructor mặc định
    public Phieunhaphang() {
        MaPN = "";
        ngaynhap = null;
        MaNCC = "";
        maNV = ""; // Thêm
    }

    // Constructor đầy đủ
    public Phieunhaphang(String MaPN, LocalDate ngaynhap, String MaNCC, String maNV, float TongTien) { // Thêm maNV
        this.MaPN = MaPN;
        this.MaNCC = MaNCC;
        this.ngaynhap = ngaynhap;
        this.maNV = maNV; // Thêm
        this.TongTien = TongTien;
    }

    // Constructor sao chép
    public Phieunhaphang(Phieunhaphang other) {
        this(other.MaPN, other.ngaynhap, other.MaNCC, other.maNV, other.TongTien); // Thêm other.maNV
    }

    // Getter - Setter
    public String getMaPN() { return MaPN; }
    public void setMaPN(String MaPN) { this.MaPN = MaPN; }

    public String getMaNCC() { return MaNCC; }
    public void setMaNCC(String MaNCC) { this.MaNCC = MaNCC; }

    // Thêm Getter/Setter cho maNV
    public String getMaNV() { return maNV; }
    public void setMaNV(String maNV) { this.maNV = maNV; }

    public LocalDate getNgaynhap() { return ngaynhap; }
    public void setNgaynhap(LocalDate ngaynhap) { this.ngaynhap = ngaynhap;}

    public float getTongTien() { return TongTien; }
    public void setTongTien(float TongTien) { this.TongTien = TongTien;}

    public void them() {
        System.out.print("Nhap ma phieu nhap: ");
        MaPN = sc.nextLine();
        System.out.print("Nhap ma nha cung cap: ");
        MaNCC = sc.nextLine();
        System.out.print("Nhap ma khach hang: "); // Thêm
        maNV = sc.nextLine(); // Thêm
        System.out.print("Nhap ngay nhap (yyyy-mm-dd): ");
        ngaynhap = LocalDate.parse(sc.nextLine());
    }

    public void xuat() {
        // Cập nhật hàm xuat
        System.out.printf(" %-10s |  %-10s |  %-10s |  %-10s%n", MaPN, ngaynhap, MaNCC, maNV);
    }

    public void ghiFile( BufferedWriter bw) throws IOException {

        bw.write(MaPN);
        bw.newLine();
        bw.write(MaNCC);
        bw.newLine();
        bw.write(maNV); // Thêm
        bw.newLine();
        bw.write(String.valueOf(ngaynhap));
        bw.newLine();
        bw.write(String.valueOf(TongTien));
        bw.newLine();
    }
}