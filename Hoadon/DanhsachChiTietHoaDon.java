package Hoadon;
import java.util.Arrays;
import java.util.Scanner;

public class DanhsachChiTietHoaDon {
    private ChiTietHoaDon[] ds;
    private int n; // Số lượng chi tiết hiện có

    public DanhsachChiTietHoaDon() {
        ds = new ChiTietHoaDon[0];
        n = 0;
    }

    public void them(ChiTietHoaDon ct) {
        ds = Arrays.copyOf(ds, n + 1);
        ds[n] = ct;
        n++;
    }
    
    public void nhap(Scanner sc, int soLuongCanNhap,DS_Sach dss) {
        for (int i = 0; i < soLuongCanNhap; i++) {
            System.out.println("Nhap thong tin sach thu " + (i + 1) + ":");
            ChiTietHoaDon ct = new ChiTietHoaDon();
            ct.nhap(sc,dss);
            them(ct);
        }
    }

    public void xuat() {
        System.out.println("  | Ma Sach    | So Luong | Don Gia    | Thanh Tien |");
        System.out.println("  |------------|----------|------------|------------|");
        if (n == 0) {
            System.out.println("  (Hoa don rong)");
        } else {
            for (int i = 0; i < n; i++) {
                ds[i].xuat();
            }
        }
        System.out.println("  |--------------------------------------------------|");
    }
    public float tinhTongTien() {
        float tong = 0;
        for (int i = 0; i < n; i++) {
            tong += ds[i].getThanhTien();
        }
        return tong;
    }
    
    public int getSoLuong() {
        return n;
    }
}