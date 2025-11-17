package Hoadon;

import java.io.BufferedWriter;
import java.io.IOException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;


public class Hoadon {

    Scanner sc = new Scanner(System.in);
    private String maHD;
    private LocalDate ngayLapHD;
    private String maNV;
    private String maKH;
    private double Tongtien; 

    // Constructor
    public Hoadon() {
    }

    public Hoadon(String maHD, LocalDate ngayLapHD, String maKH, String maNV,double Tongtien) {
        this.maHD = maHD;
        this.ngayLapHD = ngayLapHD;
        this.maKH = maKH;
        this.maNV = maNV;
        this.Tongtien=Tongtien;
    }

    public Hoadon(Hoadon other) {
        this(other.maHD, other.ngayLapHD, other.maKH, other.maNV,other.Tongtien);
    }

    // Get/Set
    public String getMaHD() { return maHD; }
    public void setMaHD(String maHD) { this.maHD = maHD; }
    public LocalDate getNgayLapHD() { return ngayLapHD; }
    public void setNgayLapHD(LocalDate ngayLapHD) { this.ngayLapHD = ngayLapHD; }
    public String getKhachHang() { return maKH; }
    public void setKhachHang(String khachHang) { this.maKH = khachHang; }
    public String getNhanVien() { return maNV; }
    public void setNhanVien(String nhanVien) { this.maKH = nhanVien; }
    public double getTongtien() {return Tongtien;}
    public void setTongtien(double Tongtien){this.Tongtien=Tongtien;}

    // Hàm nhập 
    public void nhap() {
        System.out.print("Nhap ma hoa don: ");
        this.maHD = sc.nextLine();

        boolean ngayHopLe = false;
        while (!ngayHopLe) {
            try {
                System.out.print("Nhap Ngay lap (dd/MM/yyyy): ");
                this.ngayLapHD = LocalDate.parse(sc.nextLine(), DateTimeFormatter.ofPattern("dd/MM/yyyy"));
                ngayHopLe = true;
            } catch (Exception e) {
                System.out.println("Dinh dang ngay khong hop le!");
            }
        }
            System.out.print("Nhap ma Khach Hang: ");
            this.maKH = sc.nextLine();
       
            System.out.print("Nhap ma Nhan vien: ");
            this.maNV = sc.nextLine();
    }

    // Hàm xuất
    public void xuat() {
        String maKH = (this.maKH != null) ? getKhachHang() : "N/A";
        String tenNV = (this.maNV != null) ? getKhachHang() : "N/A";
        String ngay = (ngayLapHD != null) ? ngayLapHD.format(DateTimeFormatter.ofPattern("dd/MM/yyyy")) : "N/A";
        System.out.printf("Ma HD: %s | Ngay: %s | Khach: %s | Nhan Vien: %s\n", maHD, ngay, maKH, maNV);
    }

    // Hàm ghi file
    public void ghiFile(BufferedWriter bw) throws IOException {
        // Ghi vào file DATA
        String maKH = (this.maKH != null) ? getKhachHang() : "";
        String maNV = (this.maNV != null) ? getNhanVien() : "";
        
        bw.write(maHD); bw.newLine();
        bw.write(ngayLapHD.format(DateTimeFormatter.ofPattern("dd/MM/yyyy"))); bw.newLine();
        bw.write(maKH); bw.newLine();
        bw.write(maNV); bw.newLine();
    }
}