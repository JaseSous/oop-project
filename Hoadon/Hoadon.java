package Hoadon;

import Khachhang.DanhsachKhachhang;
import Khachhang.Khachhang;
import Nhanvien.DanhsachNhanvien;
import Nhanvien.Nhanvien;
import Sach.DS_Sach;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;

public class Hoadon {

    private String maHD;
    private LocalDate ngayLapHD;
    private Khachhang khachHang;
    private Nhanvien nhanVien;
    private DanhsachChiTietHoaDon dsChiTiet; // Sử dụng lớp quản lý chi tiết

    public Hoadon() {
        this.dsChiTiet = new DanhsachChiTietHoaDon();
    }

    public void nhap(Scanner sc, DanhsachKhachhang dskh, DanhsachNhanvien dsnv, DS_Sach dss) {
        System.out.print("Nhap ma hoa don: ");
        this.maHD = sc.nextLine();

        boolean ngayHopLe = false;
        while (!ngayHopLe) {
            try {
                System.out.print("Nhap Ngay lap hoa don (dd/MM/yyyy): ");
                String ngayStr = sc.nextLine();
                this.ngayLapHD = LocalDate.parse(ngayStr, DateTimeFormatter.ofPattern("dd/MM/yyyy"));
                ngayHopLe = true;
            } catch (Exception e) {
                System.out.println("Dinh dang ngay khong hop le!");
            }
        }

        System.out.print("Nhap ma Khach Hang: ");
        String maKH = sc.nextLine();
        this.khachHang = dskh.timKiem(maKH);

        System.out.print("Nhap ma Nhan vien: ");
        String maNV = sc.nextLine();
        this.nhanVien = dsnv.timKiem(maNV);

        System.out.print("Ban muon mua bao nhieu loai sach? ");
        int soLuong = Integer.parseInt(sc.nextLine());

        System.out.println("--- Bat dau nhap chi tiet hoa don ---");
        // Truyền dss xuống cho danh sách chi tiết
        this.dsChiTiet.nhap(sc, soLuong, dss);
    }

    public void xuat() {
        System.out.println("-------------------- THONG TIN HOA DON --------------------");
        System.out.println("Ma HD: " + this.maHD);
        if (this.ngayLapHD != null) {
             System.out.println("Ngay lap: " + this.ngayLapHD.format(DateTimeFormatter.ofPattern("dd/MM/yyyy")));
        }

        if (khachHang != null) System.out.println("Khach hang: " + khachHang.getTenkh() + " (" + khachHang.getMakh() + ")");
        else System.out.println("Khach hang: [Khong tim thay]");

        if (nhanVien != null) System.out.println("Nhan vien lap: " + nhanVien.getTennv() + " (" + nhanVien.getManv() + ")");
        else System.out.println("Nhan vien lap: [Khong tim thay]");

        System.out.println("\n--- Chi Tiet ---");
        this.dsChiTiet.xuat();

        System.out.printf("TONG TIEN: %,.0f VND\n", this.dsChiTiet.tinhTongTien());
        System.out.println("-----------------------------------------------------------");
    }

    public String getMaHD() {
        return maHD;
    }

    public void setMaHD(String maHD) {
        this.maHD = maHD;
    }

    public LocalDate getNgayLapHD() {
        return ngayLapHD;
    }

    public Khachhang getKhachHang() {
        return khachHang;
    }

    public Nhanvien getNhanVien() {
        return nhanVien;
    }

    public void setNgayLapHD(LocalDate ngayLapHD) {
        this.ngayLapHD = ngayLapHD;
    }

    public void setKhachHang(Khachhang khachHang) {
        this.khachHang = khachHang;
    }

    public void setNhanVien(Nhanvien nhanVien) {
        this.nhanVien = nhanVien;
    }

    public DanhsachChiTietHoaDon getDsChiTiet() {
        return dsChiTiet;
    }
}