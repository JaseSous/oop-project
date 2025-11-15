package Hoadon;

import Sach.Sach;
import Sach.DS_Sach;
import java.io.BufferedWriter;
import java.io.IOException;
import java.util.Scanner;

public class ChiTietHoaDon {
    private String maHD; // Khóa ngoại
    private String maSach;
    private int soLuong;
    private float dongia;

    // Constructors
    public ChiTietHoaDon() {
    }

    public ChiTietHoaDon(String maHD, String maSach, int soLuong, float dongia) {
        this.maHD = maHD;
        this.maSach = maSach;
        this.soLuong = soLuong;
        this.dongia = dongia;
    }

    // Getters / Setters
    public String getMaHD() { return maHD; }
    public void setMaHD(String maHD) { this.maHD = maHD; }
    public String getMaSach() { return maSach; }
    public void setMaSach(String maSach) { this.maSach = maSach; }
    public int getSoLuong() { return soLuong; }
    public void setSoLuong(int soLuong) { this.soLuong = soLuong; }
    public float getDongia() { return dongia; }
    public void setDongia(float dongia) { this.dongia = dongia; }

    // Tính thành tiền
    public float getThanhTien() {
        return this.soLuong * this.dongia;
    }

    // Hàm nhập
    public void nhap(Scanner sc, DS_Sach dss) {
        Sach sachTimThay = null;
        do {
            System.out.print("Nhap ma sach: ");
            String maTam = sc.nextLine();
            sachTimThay = dss.timKiemTheoMaSach(maTam); // Giả sử DS_Sach có hàm này
            
            if (sachTimThay == null) {
                System.out.println("Ma sach khong ton tai!");
            } else {
                this.maSach = maTam;
                this.dongia = sachTimThay.getGia(); // Tự động lấy giá
                System.out.println("Da chon: " + sachTimThay.getTensach());
            }
        } while (sachTimThay == null);
        
        System.out.print("Nhap so luong: ");
        this.soLuong = Integer.parseInt(sc.nextLine());
    }

    // Hàm xuất
    public void xuat() {
        System.out.printf("  | %-10s | %-8d | %,11.0f | %,13.0f |\n",
                maSach, soLuong, dongia, getThanhTien());
    }

    // Hàm ghi file
    public void ghiFile(BufferedWriter bw) throws IOException {
        // Ghi vào file DATA (để load lại)
        bw.write(maHD); bw.newLine();
        bw.write(maSach); bw.newLine();
        bw.write(String.valueOf(soLuong)); bw.newLine();
        bw.write(String.valueOf(dongia)); bw.newLine();
    }
}