package Hoadon;

import Khachhang.DanhsachKhachhang;
import Nhanvien.DanhsachNhanvien;
import Khachhang.Khachhang;
import Nhanvien.Nhanvien;
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
import java.util.Scanner;

public class Danhsachhoadon {
    private Hoadon[] ds;
    private int siso;

    public Danhsachhoadon() {
        ds = new Hoadon[0];
        siso = 0;
    }

    public Hoadon[] getds() {
        return ds;
    }
    public int getSiso() {
        return siso;
    }

    // --- LOAD FILE ---
    public void loadFile(DanhsachKhachhang dskh, DanhsachNhanvien dsnv) {
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
                Khachhang kh = dskh.timKiem(reader.readLine().trim());
                Nhanvien nv = dsnv.timKiem(reader.readLine().trim());
                ds[i] = new Hoadon(maHD, ngayLap, kh, nv);
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
        } catch (IOException e) {
            System.err.println("Lỗi khi lưu file DS_HoaDon.dat: " + e.getMessage());
        }
    }
    // --- Hàm xem (xuất) danh sách hóa đơn ra file ---
    public void xem(DanhsachChiTietHoaDon ds_CTHD_Tong) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter("OUTPUT/DanhSachHoaDon_BaoCao.txt"));
             Formatter formatter = new Formatter(writer)) {

            formatter.format("===[DANH SÁCH HÓA ĐƠN]===\n");
            formatter.format("Tổng số hóa đơn: %d\n\n", siso);

            for (int i = 0; i < siso; i++) {
                Hoadon hd = ds[i];
                formatter.format("------------------------------------------------------------\n");
                formatter.format("HÓA ĐƠN SỐ: %s\n", hd.getMaHD());
                formatter.format("Ngày lập: %s\n", hd.getNgayLapHD().format(DateTimeFormatter.ofPattern("dd/MM/yyyy")));
                if (hd.getKhachHang() != null) formatter.format("Khách hàng: %s (%s)\n", hd.getKhachHang().getTenkh(), hd.getKhachHang().getMakh());
                if (hd.getNhanVien() != null) formatter.format("Nhân viên lập: %s (%s)\n", hd.getNhanVien().getTennv(), hd.getNhanVien().getManv());

                formatter.format("\n--- Chi tiết đơn hàng ---\n");
                formatter.format("| %-10s | %-8s | %-11s | %-13s |\n", "Mã sách", "SL", "Đơn giá", "Thành tiền");
                formatter.format("|------------|----------|-------------|---------------|\n");

                double tongTienPhieu = 0;
                for (ChiTietHoaDon ct : ds_CTHD_Tong.getds()) {
                    if (ct.getMaHD().equals(hd.getMaHD())) {
                        formatter.format("| %-10s | %-8d | %,11.0f | %,13.0f |\n",
                                ct.getMaSach(), ct.getSoLuong(), ct.getDongia(), ct.getThanhTien());
                        tongTienPhieu += ct.getThanhTien();
                    }
                }
                
                formatter.format("|-----------------------------------------------------|\n");
                formatter.format("%43s: %,.0f VND\n", "TỔNG CỘNG", tongTienPhieu);
                formatter.format("\n");
            }
            formatter.format("============================================================\n");
            System.out.println("Đã xuất báo cáo ra file: OUTPUT/DanhSachHoaDon_BaoCao.txt");
        } catch (IOException e) {
            System.err.println("Lỗi khi ghi file báo cáo: " + e.getMessage());
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

    public Hoadon[] timKiemTheoTenKhachHang(String tenKH) {
        Hoadon[] ketqua = new Hoadon[0];
        int count = 0;
        
        for (int i = 0; i < siso; i++) {
            Khachhang kh = ds[i].getKhachHang();
            if (kh != null) {
                // Kiểm tra xem tên khách hàng có chứa chuỗi tìm kiếm không
                if (kh.getTenkh().toLowerCase().contains(tenKH.toLowerCase())) {
                    ketqua = Arrays.copyOf(ketqua, count + 1);
                    ketqua[count] = ds[i];
                    count++;
                }
            }
        }
        return ketqua;
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
    public void suaKhachHang(String maHD, Khachhang khMoi) {
        Hoadon hd = timKiemTheoMa(maHD);
        if (hd != null) {
            hd.setKhachHang(khMoi);
            System.out.println("Da sua KH cho HD: " + maHD);
        } else {
            System.out.println("Khong tim thay HD de sua!");
        }
    }
}