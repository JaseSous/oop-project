package Hoadon;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.util.Formatter;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Arrays;

public class DS_ChiTietHoaDon {
    private ChiTietHoaDon[] ds;
    private int n; // Tổng số lượng chi tiết

    public DS_ChiTietHoaDon() {
        ds = new ChiTietHoaDon[0];
        n = 0;
    }

    public DS_ChiTietHoaDon(DS_ChiTietHoaDon other) {
        this.ds = Arrays.copyOf(other.ds, other.n);
        this.n = other.n;
    }

    public ChiTietHoaDon[] getds() {
        return ds;
    }
    public int getSoLuong() {
        return n;
    }

    // --- LOAD FILE ---
    public void loadFile() {
        try {
            String filePath = "DATA/DS_ChiTietHoaDon.dat";
            Path path = Paths.get(filePath);
            if (!Files.exists(path) || Files.size(path) == 0) return;

            BufferedReader reader = new BufferedReader(new FileReader(filePath));
            n = Integer.parseInt(reader.readLine().trim());
            ds = new ChiTietHoaDon[n]; // Cấp phát mảng

            for (int i = 0; i < n; i++) {
                String maHD = reader.readLine().trim();
                String maSach = reader.readLine().trim();
                int soLuong = Integer.parseInt(reader.readLine().trim());
                float donGia = Float.parseFloat(reader.readLine().trim());
                ds[i] = new ChiTietHoaDon(maHD, maSach, soLuong, donGia);
            }
            reader.close();
            System.out.println("--> Da tai " + n + " chi tiet hoa don.");
        } catch (Exception e) {
            System.err.println("Loi khi doc file DS_ChiTietHoaDon.dat: " + e.getMessage());
        }
    }

    // --- SAVE FILE ---
    public void saveFile() {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter("DATA/DS_ChiTietHoaDon.dat"))) {
            writer.write(String.valueOf(n)); // Ghi tổng số lượng
            writer.newLine();

            for (int i = 0; i < n; i++) {
                ds[i].ghiFile(writer); // Gọi hàm ghi file của ChiTietHoaDon
            }
        } catch (IOException e) {
            System.err.println("Loi khi luu file file DS_ChiTietHoaDon.dat: " + e.getMessage());
        }
    }

    public void ghiFile() {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter("OUTPUT/DanhSachChiTietHoaDon.txt"));
             Formatter formatter = new Formatter(writer)) {

            formatter.format("===[DANH SACH CHI TIET HOA DON]===\n");
            formatter.format("Tong so chi tiet: %d\n\n", n);
            
            // Header bảng
            formatter.format("| %-10s | %-10s | %-8s | %-12s | %-15s |\n", 
                            "Ma HD", "Ma Sach", "So Luong", "Don Gia", "Thanh Tien");
            formatter.format("|------------|------------|----------|--------------|-----------------|\n");

            for (int i = 0; i < n; i++) {
                ChiTietHoaDon ct = ds[i];
                formatter.format("| %-10s | %-10s | %-8d | %,12.0f | %,15.0f |\n",
                        ct.getMaHD(),
                        ct.getMaSach(),
                        ct.getSoLuong(),
                        ct.getDongia(),
                        ct.getThanhTien());
            }
            formatter.format("|------------|------------|----------|--------------|-----------------|\n");
            
            System.out.println("Da xuat danh sach chi tiet hoa don ra file: OUTPUT/DS_ChiTietHoaDon.txt");

        } catch (IOException e) {
            System.err.println("Loi khi ghi file chi tiet: " + e.getMessage());
        }
    }

    // Thêm
    public void themvaodanhsach(ChiTietHoaDon ct) {
        ds = Arrays.copyOf(ds, n + 1);
        ds[n++] = new ChiTietHoaDon(ct);
    }

    // Xóa theo mã HD
    public void xoatheoMaHD(String maHD) {
        boolean found = false;
        for (int i = 0; i < n;) {
            if (ds[i].getMaHD().equals(maHD)) {
                for (int j = i; j < n - 1; j++) {
                    ds[j] = ds[j + 1];
                }
                n--;
                ds = Arrays.copyOf(ds, n);
                found = true;
                // Không tăng i vì phần tử mới đã dồn lên vị trí i
            } else {
                i++; // Chỉ tăng i nếu không xóa
            }
        }
        if(!found) {
            System.out.println("Khong tim thay chi tiet thuoc HD: " + maHD);
        } else
        System.out.println("Da xoa cac chi tiet thuoc HD: " + maHD);
    }

    // Sửa
    public void suaDonGia(String maHD, String maSach, float donGiaMoi) {
        boolean found = false;
        for (int i = 0; i < n; i++) {
            if (ds[i].getMaHD().equals(maHD) && ds[i].getMaSach().equals(maSach)) {
                ds[i].setDongia(donGiaMoi);
                found = true;
            }
        }
        if (found) System.out.println("Da sua don gia cho SP " + maSach + " trong HD " + maHD);
        else System.out.println("Khong tim thay chi tiet de sua!");
    }
    
    public void suaSoLuong(String maHD, String maSach, int soLuongMoi) {
        boolean found = false;
        for (int i = 0; i < n; i++) {
            if (ds[i].getMaHD().equals(maHD) && ds[i].getMaSach().equals(maSach)) {
                ds[i].setSoLuong(soLuongMoi);
                found = true;
            }
        }
        if (found) System.out.println("Da sua so luong cho SP " + maSach + " trong HD " + maHD);
        else System.out.println("Khong tim thay chi tiet de sua!");
    }
}