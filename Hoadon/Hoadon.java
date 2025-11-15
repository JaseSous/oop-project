package Hoadon;

import Khachhang.DanhsachKhachhang;
import Khachhang.Khachhang;
import Nhanvien.DanhsachNhanvien;
import Nhanvien.Nhanvien;
import java.io.BufferedWriter;
import java.io.IOException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;

public class Hoadon {
    private String maHD;
    private LocalDate ngayLapHD;
    private Khachhang khachHang; 
    private Nhanvien nhanVien;   

    // Constructor
    public Hoadon() {
    }

    public Hoadon(String maHD, LocalDate ngayLapHD, Khachhang khachHang, Nhanvien nhanVien) {
        this.maHD = maHD;
        this.ngayLapHD = ngayLapHD;
        this.khachHang = khachHang;
        this.nhanVien = nhanVien;
    }

    public Hoadon(Hoadon other) {
        this(other.maHD, other.ngayLapHD, other.khachHang, other.nhanVien);
    }

    // Getters / Setters
    public String getMaHD() { return maHD; }
    public void setMaHD(String maHD) { this.maHD = maHD; }
    public LocalDate getNgayLapHD() { return ngayLapHD; }
    public void setNgayLapHD(LocalDate ngayLapHD) { this.ngayLapHD = ngayLapHD; }
    public Khachhang getKhachHang() { return khachHang; }
    public void setKhachHang(Khachhang khachHang) { this.khachHang = khachHang; }
    public Nhanvien getNhanVien() { return nhanVien; }
    public void setNhanVien(Nhanvien nhanVien) { this.nhanVien = nhanVien; }

    // Hàm nhập 
    public void nhap(Scanner sc, DanhsachKhachhang dskh, DanhsachNhanvien dsnv) {
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

        while (this.khachHang == null) {
            System.out.print("Nhap ma Khach Hang: ");
            this.khachHang = dskh.timKiem(sc.nextLine());
            if (this.khachHang == null) System.out.println("Ma KH khong ton tai!");
        }

        while (this.nhanVien == null) {
            System.out.print("Nhap ma Nhan vien: ");
            this.nhanVien = dsnv.timKiem(sc.nextLine());
            if (this.nhanVien == null) System.out.println("Ma NV khong ton tai!");
        }
    }

    // Hàm xuất
    public void xuat() {
        String tenKH = (khachHang != null) ? khachHang.getTenkh() : "N/A";
        String tenNV = (nhanVien != null) ? nhanVien.getTennv() : "N/A";
        String ngay = (ngayLapHD != null) ? ngayLapHD.format(DateTimeFormatter.ofPattern("dd/MM/yyyy")) : "N/A";
        System.out.printf("Ma HD: %s | Ngay: %s | Khach: %s | Nhan Vien: %s\n", maHD, ngay, tenKH, tenNV);
    }

    // Hàm ghi file
    public void ghiFile(BufferedWriter bw) throws IOException {
        // Ghi vào file DATA
        String maKH = (khachHang != null) ? khachHang.getMakh() : "";
        String maNV = (nhanVien != null) ? nhanVien.getManv() : "";
        
        bw.write(maHD); bw.newLine();
        bw.write(ngayLapHD.format(DateTimeFormatter.ofPattern("dd/MM/yyyy"))); bw.newLine();
        bw.write(maKH); bw.newLine();
        bw.write(maNV); bw.newLine();
    }
}