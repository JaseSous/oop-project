package Hoadon;

import Khachhang.DS_Khachhang;
import Khachhang.Khachhang;
import Nhanvien.DS_Nhanvien;
import Nhanvien.NhanVien;

import java.util.Formatter;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Arrays;

public class DS_HoaDon {
    private Hoadon[] ds;
    private int siso;

    public DS_HoaDon() {
        ds = new Hoadon[0];
        siso = 0;
    }

    public DS_HoaDon(DS_HoaDon other) {
        this.ds = Arrays.copyOf(other.ds, other.siso);
        this.siso = other.siso;
    }

    public Hoadon[] getds() {
        return ds;
    }
    public int getSiso() {
        return siso;
    }

    // --- LOAD FILE ---
    public void loadFile(DS_Khachhang dskh, DS_Nhanvien dsnv) {
        try {
            String filePath = "DATA/DS_HoaDon.dat";
            Path path = Paths.get(filePath);
            if (!Files.exists(path) || Files.size(path) == 0) return;

            BufferedReader reader = new BufferedReader(new FileReader(filePath));
            siso = Integer.parseInt(reader.readLine().trim());
            ds = new Hoadon[siso]; // Cấp phát mảng

            for (int i = 0; i < siso; i++) {
                String maHD = reader.readLine().trim();
                LocalDate ngayLap = LocalDate.parse(reader.readLine().trim(), DateTimeFormatter.ofPattern("dd/MM/yyyy"));
                // Đọc mã KH/NV và tìm kiếm đối tượng tương ứng
                String maKH_str = reader.readLine().trim();
                String maNV_str = reader.readLine().trim();
                double TongTien = Double.parseDouble(reader.readLine().trim());
                ds[i] = new Hoadon(maHD, ngayLap, maKH_str, maNV_str, TongTien);
            }
            reader.close();
            System.out.println("--> Da tai " + siso + " hoa don.");
        } catch (Exception e) {
            System.err.println("Loi khi doc file DS_HoaDon.dat: " + e.getMessage());
        }
    }

    // --- SAVE FILE ---
    public void saveFile() {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter("DATA/DS_HoaDon.dat"))) {
            writer.write(String.valueOf(siso)); // Ghi tổng số lượng
            writer.newLine();

            for (int i = 0; i < siso; i++) {
                ds[i].ghiFile(writer); // Gọi hàm ghi file của Hoadon
            }
            
            writer.close();
        } catch (IOException e) {
            System.err.println("Loi khi lưu file DS_HoaDon.dat: " + e.getMessage());
        }
    }
    // --- Hàm (xuất) danh sách hóa đơn ra file OUTPUT---
    public void ghiFile(DS_Khachhang dskh, DS_Nhanvien dsnv) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter("OUTPUT/DanhSachHoaDon.txt"));
             Formatter formatter = new Formatter(writer)) {

            formatter.format("===[DANH SACH HOA DON]===\n");
            formatter.format("Tong so hoa don: %d\n\n", siso);
            
            // Header bảng
            formatter.format("| %-10s | %-12s | %-25s | %-25s | %-15s |\n", 
                            "Ma HD", "Ngay Lap", "Khach Hang", "Nhan Vien", "Tong Tien");
            formatter.format("|------------|--------------|---------------------------|---------------------------|-----------------|\n");

            for (int i = 0; i < siso; i++) {
                Hoadon hd = ds[i];
                
                // 1. Tra cứu tên KH đầy đủ
                String tenKH = "N/A"; 
                Khachhang kh = dskh.timKhachHangTheoMa(hd.getKhachHang());
                if (kh != null) {
                    // Lấy cả Họ và Tên cho đẹp (Hoặc chỉ getTen() tùy bạn)
                    tenKH = kh.getHo() + " " + kh.getTen(); 
                }
                
                // 2. Tra cứu tên NV đầy đủ
                String tenNV = "N/A";
                NhanVien nv = dsnv.timNhanVienTheoMa(hd.getNhanVien());
                if (nv != null) {
                    tenNV = nv.getHo() + " " + nv.getTen();
                }

                // 3. In biến TÊN vào bảng (Thay vì in hd.getKhachHang())
                formatter.format("| %-10s | %-12s | %-25s | %-25s | %,15.0f |\n",
                        hd.getMaHD(),
                        hd.getNgayLapHD().format(DateTimeFormatter.ofPattern("dd/MM/yyyy")),
                        tenKH, // <-- ĐÃ SỬA: Dùng biến tên vừa tìm được
                        tenNV, // <-- ĐÃ SỬA: Dùng biến tên vừa tìm được
                        hd.getTongtien());
            }
            formatter.format("|------------|--------------|---------------------------|---------------------------|-----------------|\n");
            
            System.out.println("Da xuat danh sach hoa don ra file: OUTPUT/DanhSachHoaDon.txt");
        } catch (IOException e) {
            System.err.println("Loi khi ghi file hoa don: " + e.getMessage());
        }
    }
    // Thêm hóa đơn
    public void themvaodanhsach(Hoadon hd) {
        ds = Arrays.copyOf(ds, siso + 1);
        ds[siso++] = new Hoadon(hd);
    }

    // Xóa theo mã
    public void xoa(String maHD) {
        int vitri = -1;
        for (int i = 0; i < siso; i++) {
            if (ds[i].getMaHD().equals(maHD)) {
                vitri = i;
                break;
            }
        }
        if (vitri == -1) {
            System.out.println("Khong tim thay hoa don " + maHD);
            return;
        }
        for (int i = vitri; i < siso - 1; i++) {
            ds[i] = ds[i + 1];
        }
        siso--;
        ds = Arrays.copyOf(ds, siso);
        System.out.println("Da xoa hoa don " + maHD);
    }

    // Tìm theo mã
    public Hoadon timKiemTheoMa(String maHD) {
        for (int i = 0; i < siso; i++) {
            if (ds[i].getMaHD().equals(maHD)) {
                return ds[i];
            }
        }
        return null;
    }
    
    // Thống kê số lượng
    public int[] ThongKeSoLuongTheoQuy() {
        int[] dem = new int[4]; // quý 1-4
        for (int i = 0; i < siso; i++) {
            int month = ds[i].getNgayLapHD().getMonthValue();
            int quy = (month - 1) / 3;
            dem[quy]++;
        }
        return dem;
    }

    public double[] ThongKeDoanhThuTheoQuy(DS_ChiTietHoaDon ds_CTHD_Tong) {
        double[] doanhThuQuy = new double[4]; 
        // Vòng lặp 1: Duyệt qua từng hóa đơn trong danh sách (ds)
        for (int i = 0; i < siso; i++) {
            Hoadon hd = ds[i];
            // Lấy tháng và quý của hóa đơn
            int month = hd.getNgayLapHD().getMonthValue();
            int quy = (month - 1) / 3;

            double tongTienCuaHoaDonNay = 0;

            // Vòng lặp 2: Duyệt qua TẤT CẢ chi tiết trong danh sách TỔNG
            for (ChiTietHoaDon ct : ds_CTHD_Tong.getds()) {
                if (ct.getMaHD().equals(hd.getMaHD())) {
                    tongTienCuaHoaDonNay += ct.getThanhTien();
                }
            }
            doanhThuQuy[quy] += tongTienCuaHoaDonNay;
        }
        
        return doanhThuQuy;
    }
    
    // Các hàm sửa
    public void suaNgayLap(String maHD, LocalDate ngayMoi) {
        Hoadon hd = timKiemTheoMa(maHD);
        if (hd != null) {
            hd.setNgayLapHD(ngayMoi);
            System.out.println("Da sua ngay lap cho HD: " + maHD);
        } else {
            System.out.println("Khong tim thay HD de sua!");
        }
    }
    public void suaKhachHang(String maHD, String khMoi) {
        Hoadon hd = timKiemTheoMa(maHD);
        if (hd != null) {
            hd.setKhachHang(khMoi);
            System.out.println("Da sua KH cho HD: " + maHD);
        } else {
            System.out.println("Khong tim thay HD de sua!");
        }
    }



































    //tinh r
}