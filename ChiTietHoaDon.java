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
    
    public void nhap(Scanner sc) {
        System.out.print("Nhap ma sach: ");
        this.maSach = sc.nextLine();
        
        System.out.print("Nhap so luong: ");
        this.soLuong = sc.nextInt();
        
        System.out.print("Nhap don gia (giá tại thời điểm bán): ");
        this.dongia = sc.nextFloat();
        sc.nextLine();
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