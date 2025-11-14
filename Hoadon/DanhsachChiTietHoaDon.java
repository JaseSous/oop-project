package Hoadon;
import Sach.DS_Sach;
import java.util.Arrays;
import java.util.Scanner;
import java.util.Formatter;

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

    public void xuatFile(java.util.Formatter formatter) {
        for (int i = 0; i < n; i++) {
            formatter.format("| %-10s | %-8d | %,11.0f | %,13.0f |\n",
                    ds[i].getMaSach(), ds[i].getSoLuong(), ds[i].getDongia(), ds[i].getThanhTien());
        }
    }
    public float tinhTongTien() {
        float tong = 0;
        for (int i = 0; i < n; i++) {
            tong += ds[i].getThanhTien();
        }
        return tong;
    }

    public ChiTietHoaDon getChiTiet(int index) {
    if (index >= 0 && index < n) {
        return ds[index];
    }
    return null;
}
    
    public int getSoLuong() {
        return n;
    }
}