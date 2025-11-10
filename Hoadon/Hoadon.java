package Hoadon;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Arrays; 
import java.util.Scanner;

public class Hoadon {

    // --- THUỘC TÍNH ---
    private String maHD;
    private LocalDate ngayLapHD;
    private Khachhang khachHang;
    private NhanVien nhanVien;  
    
    private ChiTietHoaDon[] dsChiTiet; 
    private int soLuongChiTiet;      

    // --- CONSTRUCTOR ---
    public Hoadon() {
        this.dsChiTiet = new ChiTietHoaDon[0];
        this.soLuongChiTiet = 0;
    }

    public Hoadon(String maHD, LocalDate ngayLapHD, Khachhang khachHang, NhanVien nhanVien) {
        this.maHD = maHD;
        this.ngayLapHD = ngayLapHD;
        this.khachHang = khachHang;
        this.nhanVien = nhanVien;
        this.dsChiTiet = new ChiTietHoaDon[0];
        this.soLuongChiTiet = 0;
    }

    // --- PHƯƠNG THỨC NHẬP/XUẤT ---
    public void nhap(Scanner sc, DanhSachKhachHang dskh, Danhsachnhanvien dsnv) {
        System.out.print("Nhap ma hoa don: ");
        this.maHD = sc.nextLine();

        boolean ngayHopLe = false;
        while (!ngayHopLe) {
            try {
                System.out.print("Nhap Ngay lap hoa don (theo dinh dang dd/MM/yyyy): ");
                String ngayStr = sc.nextLine();
                DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
                this.ngayLapHD = LocalDate.parse(ngayStr, formatter);
                ngayHopLe = true;
            } catch (Exception e) {
                System.out.println("Dinh dang ngay khong hop le. Vui long nhap lai.");
            }
        }
        
        this.khachHang = null;
        while (this.khachHang == null) {
            System.out.print("Nhap ma Khach Hang: ");
            long maKH = sc.nextLong();
            this.khachHang = dskh.timKhachHangTheoMa(maKH);
            if (this.khachHang == null) {
                System.out.println("Loi: Khong tim thay Khach Hang voi ma " + maKH + ". Vui long nhap lai.");
            } else {
                System.out.println("Da chon Khach Hang: " + this.khachHang.getHo() + " " + this.khachHang.getTen());
            }
        }
        
        this.nhanVien = null;
        while (this.nhanVien == null) {
            System.out.print("Nhap ma Nhan vien: ");
            long maNV = sc.nextLong();
            this.nhanVien = dsnv.timNhanVienTheoMa(maNV);
            if (this.nhanVien == null) {
                System.out.println("Loi: Khong tim thay Nhan vien voi ma " + maNV + ". Vui long nhap lai.");
            } else {
                System.out.println("Da chon Nhan Vien: " + this.nhanVien.getHo() + " " + this.nhanVien.getTen());
            }
        }
        sc.nextLine();
        System.out.print("Ban muon mua bao nhieu loai sach? ");
        this.soLuongChiTiet = sc.nextInt();
        sc.nextLine();
        
        this.dsChiTiet = new ChiTietHoaDon[this.soLuongChiTiet];
        
        System.out.println("--- Bat dau nhap chi tiet hoa don ---");
        for (int i = 0; i < this.soLuongChiTiet; i++) {
            System.out.println("Nhap thong tin sach thu " + (i + 1) + ":");
            this.dsChiTiet[i] = new ChiTietHoaDon();
            this.dsChiTiet[i].nhap(sc); 
        }
    }

    public void xuat() {
        System.out.println("-------------------- THONG TIN HOA DON --------------------");
        System.out.println("Ma hoa don: " + this.maHD);
        
        if (khachHang != null) {
            System.out.println("Ma Khach hang: " + khachHang.getMakh()); 
        }
        if (nhanVien != null) {
            System.out.println("Ma Nhan vien: " + nhanVien.getManv());
        }
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        System.out.println("Ngay lap: " + this.ngayLapHD.format(formatter));
        
        System.out.println("\n--- Chi Tiet Cac Mat Hang Da Mua ---");
        System.out.println("  | Ma Sach    | So Luong | Don Gia    | Thanh Tien |");
        System.out.println("  |------------|----------|------------|------------|");
        if (soLuongChiTiet == 0) {
            System.out.println("  (Hoa don rong)");
        } else {
            for (int i = 0; i < this.soLuongChiTiet; i++) {
                this.dsChiTiet[i].xuat(); // Gọi hàm xuat() của ChiTietHoaDon
            }
        }
        System.out.println("  |--------------------------------------------------|");

        // Dòng tổng tiền
        System.out.printf("Tong tien: %.0f\n", tinhTongTien());
        System.out.println("----------------------------------------------------------");
    }

    public float tinhTongTien() {
        float tong = 0;
        for (int i = 0; i < this.soLuongChiTiet; i++) {
            tong += this.dsChiTiet[i].getThanhTien(); // Cộng dồn thành tiền của TỪNG chi tiết
        }
        return tong;
    }

    // --- GETTER/SETTER
    public String getMaHD() {
        return maHD;
    }

    public void setMaHD(String maHD) {
        this.maHD = maHD;
    }

    public LocalDate getNgayLapHD() {
        return ngayLapHD;
    }
}