import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;

public class Hoadon {

    // --- THUỘC TÍNH ---
    private String maHD;
    private LocalDate ngayLapHD; // Dùng LocalDate cho an toàn và tiện lợi

    private Khachhang khachHang;
    private Nhanvien nhanVien;
    private DanhsachSach danhSachMua;

    // --- CONSTRUCTOR ---
    public Hoadon() {
        // Có thể để trống hoặc khởi tạo các giá trị mặc định cơ bản
    }

    public Hoadon(int maHD, LocalDate ngayLapHD, Khachhang khachHang, Nhanvien nhanVien, DanhsachSach danhSachMua) {
        this.maHD = maHD;
        this.ngayLapHD = ngayLapHD;
        this.khachHang = khachHang;
        this.nhanVien = nhanVien;
        this.danhSachMua = danhSachMua;
    }

    // --- PHƯƠNG THỨC NHẬP/XUẤT ---
    public void nhap(Scanner sc) {
        System.out.print("Nhap ma hoa don: ");
        this.maHD = sc.nextLine();
        sc.nextLine();

        // Nhập ngày tháng một cách an toàn
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
        
    }

    public void xuat() {
        System.out.println("-------------------- THONG TIN HOA DON --------------------");
        System.out.println("Ma hoa don: " + this.maHD);
        
        // Sử dụng getter để lấy thông tin một cách an toàn
        if (khachHang != null) {
            System.out.println("Ma Khach hang: " + khachHang.getMakh()); 
        }
        if (nhanVien != null) {
            System.out.println("Ma Nhan vien: " + nhanVien.getManv());
        }

        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        System.out.println("Ngay lap: " + this.ngayLapHD.format(formatter));
        
        System.out.println("Tong tien: " + tinhTongTien());
        System.out.println("----------------------------------------------------------");
    }

    public double tinhTongTien() {
        if (this.danhSachMua != null) {
            return this.danhSachMua.tinhTongTien(); 
        }
        return 0;
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
}