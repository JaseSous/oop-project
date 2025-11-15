package Hoadon;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;
import Sach.DS_Sach;
import Khachhang.DanhsachKhachhang;
import Khachhang.Khachhang; // <-- Cần import Khachhang
import Nhanvien.DanhsachNhanvien;
import Nhanvien.Nhanvien; // <-- Cần import Nhanvien

public class QLHD extends QLBH {
    // Thêm 2 thằng này vô QLBH
    // protected static Danhsachhoadon ds_HD;
    // protected static DanhsachChiTietHoaDon ds_CTHD_Tong;
    
    // --- HÀM HỖ TRỢ IN ẤN ---
    private void xuatDayDuMotHoaDon(Hoadon hd) {
        if (hd == null) return;
        
        double tongTienHD = 0.0;
        hd.xuat(); // Xuất thông tin chung
        
        System.out.println("  --- Chi tiet cua hoa don " + hd.getMaHD() + " ---");
        System.out.printf("  | %-10s | %-8s | %-11s | %-13s |\n", "Ma Sach", "So Luong", "Don Gia", "Thanh Tien");
        System.out.println("  |------------|----------|-------------|---------------|");

        // Duyệt danh sách tổng (ds_CTHD_Tong) để tìm chi tiết
        for (ChiTietHoaDon ct : ds_CTHD_Tong.getds()) {
            if (ct.getMaHD().equals(hd.getMaHD())) {
                ct.xuat();
                tongTienHD += ct.getThanhTien();
            }
        }
        System.out.println("  |-----------------------------------------------------|");
        System.out.printf("  ==> TONG TIEN HOA DON: %,.0f VND\n\n", tongTienHD);
    }

    // --- Hàm xuất ---
    public void xuatThongTinHoaDon() {
        if (ds_HD.getSiso() == 0) {
            System.out.println("Danh sach hoa don rong.");
            return;
        }
        
        for (Hoadon hd : ds_HD.getds()) {
            xuatDayDuMotHoaDon(hd); // Gọi hàm hỗ trợ để in đầy đủ
        }
    }

    // --- Hàm thêm ---
    public void themHoaDon(Scanner sc) {
        Hoadon hd = new Hoadon();
        hd.nhap(sc, dskh, dsnv); // Nhập thông tin chung
        ds_HD.themvaodanhsach(hd); // Thêm vào danh sách HD

        System.out.print("Nhap so luong loai sach can them: ");
        int soChiTiet = Integer.parseInt(sc.nextLine());

        for (int i = 0; i < soChiTiet; i++) {
            System.out.println("Nhap chi tiet thu " + (i + 1) + " cho HD: " + hd.getMaHD());
            ChiTietHoaDon ct = new ChiTietHoaDon();
            ct.nhap(sc, dss); // Nhập chi tiết
            ct.setMaHD(hd.getMaHD()); // Gán MaHD cho chi tiết
            ds_CTHD_Tong.themvaodanhsach(ct); // Thêm vào danh sách TỔNG chi tiết
        }
        System.out.println("Da them hoa don moi thanh cong!");
    }

    // --- Hàm xóa này xóa cả hóa đơn lẫn chi tiết hóa đơn---
    public void xoaHoaDon(Scanner sc) {
        System.out.print("Nhap ma hoa don can xoa (se xoa ca chi tiet): ");
        String maHDXoa = sc.nextLine();
        
        ds_HD.xoa(maHDXoa);
        ds_CTHD_Tong.xoatheoMaHD(maHDXoa);
    }

    // --- Menu sửa (Giữ nguyên) ---
    public void menuSuaThongTin(Scanner sc) {
        int chon;
        do {
            System.out.println("\n===== MENU SUA HOA DON =====");
            System.out.println("1. Sua Ngay lap hoa don");
            System.out.println("2. Sua Khach hang cua hoa don");
            System.out.println("3. Sua Don gia cua 1 san pham trong hoa don");
            System.out.println("4. Sua So luong cua 1 san pham trong hoa don");
            System.out.println("0. Thoat");
            System.out.print("Nhap lua chon: ");
            chon = Integer.parseInt(sc.nextLine());

            switch (chon) {
                case 1:
                    System.out.print("Ma hoa don can sua: "); String maHD1 = sc.nextLine();
                    System.out.print("Ngay lap moi (dd/MM/yyyy): ");
                    LocalDate ngayMoi = LocalDate.parse(sc.nextLine(), DateTimeFormatter.ofPattern("dd/MM/yyyy"));
                    ds_HD.suaNgayLap(maHD1, ngayMoi);
                    break;
                case 2:
                    System.out.print("Ma hoa don can sua: "); String maHD2 = sc.nextLine();
                    System.out.print("Ma khach hang moi: ");
                    Khachhang khMoi = dskh.timKiem(sc.nextLine());
                    if (khMoi != null) ds_HD.suaKhachHang(maHD2, khMoi);
                    else System.out.println("Khong tim thay khach hang!");
                    break;
                case 3:
                    System.out.print("Ma hoa don can sua: "); String maHD3 = sc.nextLine();
                    System.out.print("Ma san pham can sua: "); String maSP1 = sc.nextLine();
                    System.out.print("Don gia moi: "); float giaMoi = Float.parseFloat(sc.nextLine());
                    ds_CTHD_Tong.suaDonGia(maHD3, maSP1, giaMoi);
                    break;
                case 4:
                    System.out.print("Ma hoa don can sua: "); String maHD4 = sc.nextLine();
                    System.out.print("Ma san pham can sua: "); String maSP2 = sc.nextLine();
                    System.out.print("So luong moi: "); int slMoi = Integer.parseInt(sc.nextLine());
                    ds_CTHD_Tong.suaSoLuong(maHD4, maSP2, slMoi);
                    break;
                case 0: break;
                default: System.out.println("Lua chon khong hop le!");
            }
        } while (chon != 0);
    }
    
    // --- Thống kê ---
    public double[] thongKeDoanhThuTheoQuy() {
        double[] doanhThuQuy = {0.0, 0.0, 0.0, 0.0};
        
        for(Hoadon hd : ds_HD.getds()) {
            int month = hd.getNgayLapHD().getMonthValue();
            int quy = (month - 1) / 3;
            
            double tongTienHD = 0.0;
            for(ChiTietHoaDon ct : ds_CTHD_Tong.getds()) {
                if(ct.getMaHD().equals(hd.getMaHD())) {
                    tongTienHD += ct.getThanhTien();
                }
            }
            doanhThuQuy[quy] += tongTienHD;
        }
        return doanhThuQuy;
    }
    
    // --- Menu chính ---
    @Override
    public void menuChinh() {
        // thêm 2 thằng này vào QLBH
        //ds_HD.loadFile(dskh, dsnv);
        //ds_CTHD_Tong.loadFile();
        
        Scanner sc = new Scanner(System.in);
        int choice;
        do {
            System.out.println("\n===== MENU QUAN LY HOA DON =====");
            System.out.println("1. Xuat thong tin tat ca Hoa Don (ra console)");
            System.out.println("2. Them Hoa Don moi");
            System.out.println("3. Xoa Hoa Don (Theo MaHD)");
            System.out.println("4. Tim kiem theo Ma Hoa Don"); 
            System.out.println("5. Tim kiem theo Ten Khach Hang"); 
            System.out.println("6. Sua thong tin Hoa Don / Chi Tiet");
            System.out.println("7. Thong ke theo quy");
            System.out.println("8. XUAT file bao cao (xem())");
            System.out.println("9. LUU vao file");
            System.out.println("0. Thoat");
            System.out.println("==================================");
            System.out.print("Lua chon: ");
            choice = Integer.parseInt(sc.nextLine());

            switch (choice) {
                case 1:
                    xuatThongTinHoaDon();
                    break;
                case 2:
                    themHoaDon(sc);
                    break;
                case 3:
                    xoaHoaDon(sc);
                    break;
                case 4: 
                    System.out.print("Nhap Ma Hoa Don can tim: ");
                    String maHD = sc.nextLine();
                    Hoadon hdTimThay = ds_HD.timKiemTheoMa(maHD);
                    if (hdTimThay != null) {
                        System.out.println("--- Tim thay 1 hoa don ---");
                        xuatDayDuMotHoaDon(hdTimThay);
                    } else {
                        System.out.println("Khong tim thay hoa don co ma: " + maHD);
                    }
                    break;
                case 5:
                    System.out.print("Nhap Ten Khach Hang can tim: ");
                    String tenKH = sc.nextLine();
                    Hoadon[] dsTimThay = ds_HD.timKiemTheoTenKhachHang(tenKH);
                    if (dsTimThay.length > 0) {
                        System.out.println("--- Tim thay " + dsTimThay.length + " hoa don ---");
                        for (Hoadon hd : dsTimThay) {
                            xuatDayDuMotHoaDon(hd);
                        }
                    } else {
                        System.out.println("Khong tim thay hoa don nao cua khach hang: " + tenKH);
                    }
                    break;
                case 6:
                    menuSuaThongTin(sc);
                    break;
                case 7:
                    double[] doanhThu = thongKeDoanhThuTheoQuy();
                    int[] soLuong = ds_HD.ThongKeSoLuongTheoQuy();
                    System.out.println("\n--- THONG KE THEO QUY ---");
                    for(int i=0; i<4; i++) {
                        System.out.printf("Quy %d: %d hoa don - Doanh thu: %,.0f VND\n", (i+1), soLuong[i], doanhThu[i]);
                    }
                    break;
                case 8:
                    ds_HD.xem(ds_CTHD_Tong);
                    break;
                case 9:
                    ds_HD.saveFile();
                    ds_CTHD_Tong.saveFile();
                    System.out.println("Da luu du lieu vao 2 file DATA.");
                    break;
                case 0:
                    ds_HD.saveFile();
                    ds_CTHD_Tong.saveFile();
                    System.out.println("Da luu du lieu va Thoat.");
                    break;
                default:
                    System.out.println("Lua chon khong hop le.");
            }
        } while (choice != 0);
    }
}