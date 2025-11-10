// Tên file: ChiTietHoaDon.java
import java.util.Scanner;

public class ChiTietHoaDon {
    // --- THUỘC TÍNH ---
    private String maSach;
    private int soLuong;
    private float dongia; 

    // --- CONSTRUCTOR ---
    public ChiTietHoaDon() {
    }

    public ChiTietHoaDon(String maSach, int soLuong, float dongia) {
        this.maSach = maSach;
        this.soLuong = soLuong;
        this.dongia = dongia;
    }

    // --- PHƯƠNG THỨC NHẬP/XUẤT ---
    
    public void nhap(Scanner sc,DS_Sach dss) {
        Sach sachTimThay = null;
        do {
            System.out.print("Nhap ma sach: ");
            String maTam = sc.nextLine();
            
            sachTimThay = dss.timKiem(maTam); // Gọi hàm tìm kiếm bên danh sách sách
            
            if (sachTimThay == null) {
                System.out.println("⚠️ Ma sach khong ton tai trong kho! Vui long nhap lai.");
            } else {
                this.maSach = maTam;
                this.dongia = sachTimThay.getGiaBan(); 
                System.out.println("✅ Da chon: " + sachTimThay.getTenSach());
            }
        } while (sachTimThay == null);
        System.out.print("Nhap so luong: ");
        this.soLuong = sc.nextInt();
    }

    public void xuat() {
        // Xuất theo dạng 1 dòng trong bảng
        System.out.printf("  | %-10s | %-8d | %-10.0f | %-10.0f |\n", 
            this.maSach, this.soLuong, this.dongia, this.getThanhTien());
    }

    public float getThanhTien() {
        return this.soLuong * this.dongia;
    }

    public String getMaSach() {
        return maSach;
    }

    public void setMaSach(String maSach) {
        this.maSach = maSach;
    }

    public int getSoLuong() {
        return soLuong;
    }

}