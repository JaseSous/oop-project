package Hoadon;

import Khachhang.DS_Khachhang;
import Khachhang.Khachhang;
import Nhanvien.DS_Nhanvien;
import Nhanvien.NhanVien;
import Sach.DS_Sach;
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
import java.util.Formatter;

public class DS_Hoadon {
    private Hoadon[] ds;
    private int siso;

    public DS_Hoadon() {
        this.ds = new Hoadon[0];
        this.siso = 0;
    }

    public void loadFile(DS_Khachhang dskh, DS_Nhanvien dsnv) {
        try {
            String filePath = "DATA/DS_HoaDon.txt";
            Path path = Paths.get(filePath);

            if (!Files.exists(path) || Files.size(path) == 0) {
                return;
            }

            BufferedReader reader = new BufferedReader(new FileReader(filePath));
            String line = reader.readLine();
            if (line == null) return;
            
            int soLuongHD = Integer.parseInt(line.trim());

            for (int i = 0; i < soLuongHD; i++) {
                Hoadon hd = new Hoadon();
                hd.setMaHD(reader.readLine().trim());
                hd.setNgayLapHD(LocalDate.parse(reader.readLine().trim(), DateTimeFormatter.ofPattern("dd/MM/yyyy")));
                hd.setKhachHang(dskh.timKiem(reader.readLine().trim()));
                hd.setNhanVien(dsnv.timKiem(reader.readLine().trim()));

                int soLuongChiTiet = Integer.parseInt(reader.readLine().trim());
                for (int j = 0; j < soLuongChiTiet; j++) {
                    String maSach = reader.readLine().trim();
                    int soLuong = Integer.parseInt(reader.readLine().trim());
                    float donGia = Float.parseFloat(reader.readLine().trim());
                    hd.getDsChiTiet().them(new ChiTietHoaDon(maSach, soLuong, donGia));
                }
                this.them(hd);
            }
            reader.close();
            System.out.println("--> Da tai " + siso + " hoa don tu file.");
        } catch (IOException | NumberFormatException | NullPointerException e) {
            System.err.println("Loi khi doc file hoa don: " + e.getMessage());
        }
    }

    public void xem() {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter("OUTPUT/DanhSachHoaDon.txt"));
             Formatter formatter = new Formatter(writer)) {

            formatter.format("===[DANH SÁCH HÓA ĐƠN]===\n");
            formatter.format("Tổng số hóa đơn: %d\n\n", siso);

            if (siso > 0) {
                for (int i = 0; i < siso; i++) {
                    Hoadon hd = ds[i];
                    // In thông tin chung của hóa đơn
                    formatter.format("------------------------------------------------------------\n");
                    formatter.format("HÓA ĐƠN SỐ: %s\n", hd.getMaHD());
                    
                    // Định dạng ngày tháng
                    String ngayLap = "N/A";
                    if (hd.getNgayLapHD() != null) {
                         ngayLap = hd.getNgayLapHD().format(java.time.format.DateTimeFormatter.ofPattern("dd/MM/yyyy"));
                    }
                    formatter.format("Ngày lập: %s\n", ngayLap);

                    // In thông tin khách hàng và nhân viên
                    if (hd.getKhachHang() != null) {
                        formatter.format("Khách hàng: %s (%s)\n", hd.getKhachHang().getTenkh(), hd.getKhachHang().getMakh());
                    }
                    if (hd.getNhanVien() != null) {
                        formatter.format("Nhân viên lập: %s (%s)\n", hd.getNhanVien().getTennv(), hd.getNhanVien().getManv());
                    }

                    formatter.format("\n--- Chi tiết đơn hàng ---\n");
                    // In bảng chi tiết sản phẩm
                    formatter.format("| %-10s | %-8s | %-11s | %-13s |\n", "Mã sách", "SL", "Đơn giá", "Thành tiền");
                    formatter.format("|------------|----------|-------------|---------------|\n");

                    // Duyệt và in từng dòng chi tiết
                    DanhsachChiTietHoaDon dsct = hd.getDsChiTiet();
                    hd.getDsChiTiet().xuatFile(formatter);

                    formatter.format("|-----------------------------------------------------|\n");
                    formatter.format("%43s: %,.0f VND\n", "TỔNG CỘNG", dsct.tinhTongTien());
                    formatter.format("\n"); // Dòng trống ngăn cách các hóa đơn
                }
                formatter.format("============================================================\n");
            }

            System.out.println("✅ Đã xuất danh sách hóa đơn ra file: OUTPUT/DanhSachHoaDon.txt");

        } catch (IOException e) {
            System.err.println("❌ Lỗi khi ghi file: " + e.getMessage());
        }
    }

    public void them(Hoadon hd) {
        ds = Arrays.copyOf(ds, siso + 1);
        ds[siso] = hd;
        siso++;
    }

    public void themvaodanhsach(Scanner sc, DS_Khachhang dskh, DS_Nhanvien dsnv, DS_Sach dss) {
        Hoadon hd = new Hoadon();
        hd.nhap(sc, dskh, dsnv, dss);
        them(hd);
        System.out.println("Them hoa don thanh cong!");
    }

    public void nhapds(Scanner sc, DS_Khachhang dskh, DS_Nhanvien dsnv, DS_Sach dss) {
        System.out.print("Nhap so luong hoa don: ");
        int n = sc.nextInt();
        sc.nextLine();
        for (int i = 0; i < n; i++) {
            System.out.println("Nhap thong tin hoa don thu " + (i + 1) + ":");
            themvaodanhsach(sc, dskh, dsnv, dss);
        }
    }

    public void xuatds() {
        if (siso == 0) {
            System.out.println("Danh sach rong!");
            return;
        }
        System.out.println("----- DANH SACH HOA DON -----");
        for (int i = 0; i < siso; i++) {
            ds[i].xuat();
            System.out.println("\n");
        }
    }

    public void xoahd(Scanner sc) {
        System.out.print("Nhap ma hoa don muon xoa: ");
        String maxoa = sc.nextLine();
        int vitri = -1;
        for (int i = 0; i < siso; i++) {
            if (ds[i].getMaHD().equals(maxoa)) {
                vitri = i;
                break;
            }
        }
        if (vitri == -1) {
            System.out.println("Khong tim thay hoa don!");
            return;
        }
        for (int i = vitri; i < siso - 1; i++) {
            ds[i] = ds[i + 1];
        }
        ds = Arrays.copyOf(ds, siso - 1);
        siso--;
        System.out.println("Xoa thanh cong!");
    }

    public void tim(Scanner sc) {
        System.out.print("Nhap ma hoa don muon tim: ");
        String matim = sc.nextLine();
        boolean timThay = false;
        for (int i = 0; i < siso; i++) {
            if (ds[i].getMaHD().equals(matim)) {
                ds[i].xuat();
                timThay = true;
                break;
            }
        }
        if (!timThay) {
            System.out.println("Khong tim thay hoa don!");
        }
    }

    public void suahd(Scanner sc, DS_Khachhang dskh, DS_Nhanvien dsnv, DS_Sach dss) {
        System.out.print("Nhap ma hoa don can sua: ");
        String maSua = sc.nextLine();
        int vitri = -1;
        for (int i = 0; i < siso; i++) {
            if (ds[i].getMaHD().equals(maSua)) {
                vitri = i;
                break;
            }
        }
        if (vitri == -1) {
            System.out.println("Khong tim thay hoa don!");
            return;
        }

        boolean isEditing = true;
        while (isEditing) {
            System.out.println("\n--- SUA HOA DON " + maSua + " ---");
            System.out.println("1. Ngay lap");
            System.out.println("2. Khach hang");
            System.out.println("3. Nhan vien");
            System.out.println("4. Nhap lai toan bo chi tiet");
            System.out.println("0. Thoat");
            System.out.print("Lua chon: ");
            int choice = sc.nextInt();
            sc.nextLine();
            switch (choice) {
                case 1:
                     System.out.print("Nhap Ngay lap moi (dd/MM/yyyy): ");
                     ds[vitri].setNgayLapHD(LocalDate.parse(sc.nextLine(), DateTimeFormatter.ofPattern("dd/MM/yyyy")));
                     break;
                case 2:
                     System.out.print("Nhap ma Khach Hang moi: ");
                     ds[vitri].setKhachHang(dskh.timKiem(sc.nextLine()));
                     break;
                case 3:
                     System.out.print("Nhap ma Nhan Vien moi: ");
                     ds[vitri].setNhanVien(dsnv.timKiem(sc.nextLine()));
                     break;
                case 4:
                     String maHDCu = ds[vitri].getMaHD();
                     ds[vitri] = new Hoadon();
                     ds[vitri].nhap(sc, dskh, dsnv, dss);
                     ds[vitri].setMaHD(maHDCu);
                     break;
                case 0:
                     isEditing = false;
                     break;
            }
        }
    }

    public void saveFile() {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter("DATA/DS_HoaDon.txt"))) {
            // Ghi tổng số lượng hóa đơn
            writer.write(String.valueOf(siso));
            writer.newLine();

            for (int i = 0; i < siso; i++) {
                Hoadon hd = ds[i];
                // Ghi thông tin chung của hóa đơn
                writer.write(hd.getMaHD());
                writer.newLine();
                // Lưu ngày dưới dạng dd/MM/yyyy để khớp với loadFile
                writer.write(hd.getNgayLapHD().format(DateTimeFormatter.ofPattern("dd/MM/yyyy")));
                writer.newLine();
                writer.write(hd.getKhachHang().getMakh()); // Chỉ cần lưu mã KH
                writer.newLine();
                writer.write(hd.getNhanVien().getManv()); // Chỉ cần lưu mã NV
                writer.newLine();

                // Ghi danh sách chi tiết
                DanhsachChiTietHoaDon dsct = hd.getDsChiTiet();
                writer.write(String.valueOf(dsct.getSoLuong())); // Ghi số lượng chi tiết
                writer.newLine();

                for (int j = 0; j < dsct.getSoLuong(); j++) {
                    ChiTietHoaDon ct = dsct.getChiTiet(j); // Cần có phương thức getChiTiet(index)
                    writer.write(ct.getMaSach());
                    writer.newLine();
                    writer.write(String.valueOf(ct.getSoLuong()));
                    writer.newLine();
                    // Lưu đơn giá dạng số thực (có thể dùng String.valueOf hoặc định dạng)
                    writer.write(String.valueOf(ct.getDongia())); 
                    writer.newLine();
                }
            }
            System.out.println("✅ Đã lưu danh sách hóa đơn vào file: DATA/DS_HoaDon.txt");
        } catch (IOException e) {
            System.err.println("❌ Lỗi khi lưu file hóa đơn: " + e.getMessage());
        }
    }
    
   public void thongkeHDtheoQuy() {
        // Mảng lưu số lượng và doanh thu cho 4 quý
        int[] soLuong = new int[4];
        double[] doanhThu = new double[4];

        // Duyệt hết toàn bộ danh sách hóa đơn
        for (int i = 0; i < siso; i++) {
            // Lấy tháng ra (1 đến 12)
            int thang = ds[i].getNgayLapHD().getMonthValue();
            // Tính quý (0 đến 3)
            int quy = (thang - 1) / 3;          
            // Cộng dồn vào quý tương ứng
            soLuong[quy]++;
            doanhThu[quy] += ds[i].getDsChiTiet().tinhTongTien();
        }

        // Xuất kết quả
        System.out.println("\n--- THONG KE THEO QUY (TAT CA DU LIEU) ---");
        for (int i = 0; i < 4; i++) {
            System.out.printf("Quy %d: %d hoa don - Doanh thu: %,.0f VND\n", 
                              (i + 1), soLuong[i], doanhThu[i]);
        }
    }
}