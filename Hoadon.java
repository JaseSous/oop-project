import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Arrays; 
import java.util.Scanner;

public class Hoadon {

    // --- THUỘC TÍNH ---
    private String maHD;
    private LocalDate ngayLapHD;
    private Khachhang khachHang; 
    private Nhanvien nhanVien;   
    
    private ChiTietHoaDon[] dsChiTiet; 
    private int soLuongChiTiet;      

    // --- CONSTRUCTOR ---
    public Hoadon() {
        this.dsChiTiet = new ChiTietHoaDon[0];
        this.soLuongChiTiet = 0;
    }

    public Hoadon(String maHD, LocalDate ngayLapHD, Khachhang khachHang, Nhanvien nhanVien) {
        this.maHD = maHD;
        this.ngayLapHD = ngayLapHD;
        this.khachHang = khachHang;
        this.nhanVien = nhanVien;
        this.dsChiTiet = new ChiTietHoaDon[0];
        this.soLuongChiTiet = 0;
    }

    // --- PHƯƠNG THỨC NHẬP/XUẤT ---
    public void nhap(Scanner sc) {
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
        
        
         System.out.println("Nhap ma Khach Hang: ");
         String maKH = sc.nextLine();
         this.khachHang = danhSachKhachHang.timKiem(maKH);
         System.out.println("Nhap ma Nhan vien: ");
         String maNV = sc.nextLine();
         this.Nhanvien= danhSachNhanvien.timKiem(maNV);
        

        
        System.out.print("Ban muon mua bao nhieu loai sach? ");
        this.soLuongChiTiet = sc.nextInt();
        sc.nextLine();
        

        this.dsChiTiet = new ChiTietHoaDon[this.soLuongChiTiet];
        
        System.out.println("--- Bat dau nhap chi tiet hoa don ---");
        for (int i = 0; i < this.soLuongChiTiet; i++) {
            System.out.println("Nhap thong tin sach thu " + (i + 1) + ":");
            this.dsChiTiet[i] = new ChiTietHoaDon();
            this.dsChiTiet[i].nhap(sc); // Gọi hàm nhap() của ChiTietHoaDon
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