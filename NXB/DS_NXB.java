package NXB;
import java.util.Scanner;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.Formatter;

import Sach.DS_Sach;
import Sach.Sach;

public class DS_NXB {
    private NXB[] dsNXB;
    private int soLuongNXB;

    public DS_NXB() {
        this.dsNXB = new NXB[0];
        this.soLuongNXB = 0;
    }

    public DS_NXB(NXB[] dsNXB, int soLuongNXB) {
        this.dsNXB = dsNXB;
        this.soLuongNXB = soLuongNXB;
    }

    // Get/set
    public int getSoLuongNXB(){
        return soLuongNXB;
    }

    public NXB[] getDSNXB(){
        return dsNXB;
    }

    public void setSoLuongNXB(int soLuongNXB){
        this.soLuongNXB = soLuongNXB;
    }

    public void setDSNXB(NXB[] dsNXB){
        this.dsNXB = dsNXB;
    } 

    // --- HÀM LOAD FILE ---
    public void loadFile() {
        try {
            String filePath = "DATA/DS_NXB.dat";
            Path path = Paths.get(filePath);
            if (!Files.exists(path) || Files.size(path) == 0) {
                System.out.println("File NXB rong hoac khong ton tai.");
                return;
            }

            BufferedReader reader = new BufferedReader(new FileReader(filePath));
            soLuongNXB = Integer.parseInt(reader.readLine().trim());
            dsNXB = new NXB[soLuongNXB]; // Cấp phát mảng

            for (int i = 0; i < soLuongNXB; i++) {
                String ma = reader.readLine().trim();
                String ten = reader.readLine().trim();
                String sdt = reader.readLine().trim();
                dsNXB[i] = new NXB(ma, ten, sdt);
            }
            reader.close();
            System.out.println("--> Da tai " + soLuongNXB + " Nha Xuat Ban.");
        } catch (Exception e) {
            System.err.println("Loi khi doc file DS_NXB.dat: " + e.getMessage());
        }
    }

    // --- HÀM SAVE FILE (Đã thêm) ---
    public void saveFile() {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter("DATA/DS_NXB.dat"))) {
            writer.write(String.valueOf(soLuongNXB)); // Ghi tổng số lượng
            writer.newLine();

            for (int i = 0; i < soLuongNXB; i++) {
                dsNXB[i].ghiFile(writer); // Gọi hàm ghi file của NXB
            }
        } catch (IOException e) {
            System.err.println("Lỗi khi lưu file DS_NXB.dat: " + e.getMessage());
        }
    }

    // --- HÀM XEM (Xuất file báo cáo - Đã thêm) ---
    public void xem(DS_Sach ds_Sach) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter("OUTPUT/DanhSachNXB.txt"));
            Formatter formatter = new Formatter(writer)) {

            formatter.format("===[DANH SÁCH NHÀ XUẤT BẢN VÀ SÁCH]===\n");
            formatter.format("Tổng số NXB: %d\n\n", soLuongNXB);

            Sach[] allBooks = ds_Sach.getDsSach();

            for (int i = 0; i < soLuongNXB; i++) {
                NXB nxb = dsNXB[i];
                formatter.format("--------------------------------------------------\n");
                formatter.format("Ma NXB: %s\n", nxb.getMaNXB());
                formatter.format("Ten NXB: %s\n", nxb.getTenNXB());
                formatter.format("SDT: %d\n", nxb.getSdt());
                formatter.format("\n  --- Các sách thuộc NXB này:\n");

                boolean foundBook = false;
                for (Sach sach : allBooks) {
                    if (sach.getManxb() != null && sach.getManxb().equals(nxb.getMaNXB())) {
                        formatter.format("    + [ %s ] - %s\n", sach.getMasach(), sach.getTensach());
                        foundBook = true;
                    }
                }
                if (!foundBook) {
                    formatter.format("    (Không có sách nào)\n");
                }
                formatter.format("\n");
            }
            System.out.println("Đã xuất báo cáo NXB ra file: OUTPUT/DanhSachNXB.txt");

        } catch (IOException e) {
            System.err.println("Lỗi khi ghi file báo cáo NXB: " + e.getMessage());
        }
    }

    public void nhapNXB(Scanner sc) {
        System.out.print("Nhap so luong NXB can them: ");
        int n = sc.nextInt();
        sc.nextLine();

        for (int i = 0; i < n; i++) {
            System.out.println("Nhap thong tin NXB thu " + (i + 1) + ":");
            NXB nxb = new NXB();
            nxb.nhap(sc);
            themNXB(sc);
        }
    }

    public void xuatNXB() {
        if (soLuongNXB == 0) {
            System.out.println("Danh sach NXB rong!");
            return;
        }
        System.out.println("----- DANH SACH NXB -----");
        for (int i = 0; i < soLuongNXB; i++) {
            dsNXB[i].xuat();
            System.out.println("--------------------");
        }
    }

    public void themNXB(Scanner sc) {
        NXB newDsNXB = new NXB();
        newDsNXB.nhap(sc);
        dsNXB = Arrays.copyOf(dsNXB, soLuongNXB + 1);
        dsNXB[soLuongNXB++] = new NXB(newDsNXB);
    }

    public void timKiemtheoma(Scanner sc) {
        System.out.print("Nhap ma NXB can tim: ");
        String maNXB = sc.nextLine();
        for (int i = 0; i < soLuongNXB; i++) {
            if (dsNXB[i].getMaNXB().equals(maNXB)) {
                dsNXB[i].xuat();
                return;
            }
        }
        System.out.println("Khong tim thay NXB voi ma da cho.");
    }

    public void xoaNXB(Scanner sc) {
        System.out.print("Nhap ma NXB can xoa: ");
        String maNXB = sc.nextLine();
        int viTri = -1;
        for (int i = 0; i < soLuongNXB; i++) {
            if (dsNXB[i].getMaNXB().equals(maNXB)) {
                viTri = i;
                break;
            }
        }
        if (viTri == -1) {
            System.out.println("Khong tim thay NXB voi ma da cho.");
            return;
        }
        for (int i = viTri; i < soLuongNXB - 1; i++) {
            dsNXB[i] = dsNXB[i + 1];
        }
        dsNXB = Arrays.copyOf(dsNXB, soLuongNXB - 1);
        soLuongNXB--;
        System.out.println("Da xoa NXB voi ma: " + maNXB);
    }

    public void inNXBVaSach(DS_Sach ds_Sach) {
        if (soLuongNXB == 0) {
            System.out.println("Danh sach NXB rong!");
            return;
        }

        System.out.println("\n===== DANH SÁCH NHÀ XUẤT BẢN VÀ SÁCH TƯƠNG ỨNG =====");
        
        // Lấy toàn bộ sách ra 1 lần
        Sach[] allBooks = ds_Sach.getDsSach(); // Giả định DS_Sach có hàm getds() trả về mảng Sach[]

        for (int i = 0; i < soLuongNXB; i++) {
            NXB nxb = dsNXB[i];
            nxb.xuat(); // In thông tin NXB
            
            System.out.println("  --- Các sách thuộc NXB này:");
            boolean foundBook = false;
            
            // Duyệt qua danh sách sách để tìm sách khớp NXB
            for (Sach sach : allBooks) {
                // Giả định class Sach có hàm getManxb()
                if (sach.getManxb() != null && sach.getManxb().equals(nxb.getMaNXB())) {
                    // Giả định class Sach có hàm getMasach() và getTensach()
                    System.out.printf("    + [ %s ] - %s\n", sach.getMasach(), sach.getTensach());
                    foundBook = true;
                }
            }

            if (!foundBook) {
                System.out.println("    (Không có sách nào thuộc NXB này trong danh sách)");
            }
            System.out.println("-----------------------------------------------------");
        }
    }

    public void suaNXB(Scanner sc) {
        System.out.print("Nhap ma NXB can sua: ");
        String maSua = sc.nextLine();
        int vitri = -1;
        for (int i = 0; i < soLuongNXB; i++) {
            if (dsNXB[i].getMaNXB().equals(maSua)) {
                vitri = i;
                break;
            }
        }
        if (vitri == -1) {
            System.out.println("Khong tim thay NXB voi maa da cho.");
            return;
        }
        do {
            System.out.println("Ban muon sua thong tin gi?");
            System.out.println("1. Ten NXB");
            System.out.println("2. So dien thoai NXB");
            System.out.println("3. Ma NXB");
            System.out.println("4. Thoat");
            System.out.print("Lua chon cua ban: ");
            int choice = sc.nextInt();
            sc.nextLine(); // Consume newline

            switch (choice) {
                case 1:
                    System.out.print("Nhap ten NXB moi: ");
                    String tenMoi = sc.nextLine();
                    dsNXB[vitri].setTenNXB(tenMoi);
                    System.out.println("Da cap nhat ten NXB.");
                    break;
                case 2:
                    System.out.print("Nhap so dien thoai NXB moi: ");
                    String sdtMoi = sc.nextLine().trim();
                    dsNXB[vitri].setSdt(sdtMoi);
                    System.out.println("Da cap nhat so dien thoai NXB.");
                    break;
                case 3:
                    System.out.print("Nhap ma NXB moi: ");
                    String maNXBMoi = sc.nextLine();
                    dsNXB[vitri].setMaNXB(maNXBMoi);
                    System.out.println("Da cap nhat maNXB.");
                    break;
                case 4:
                    return;
                default:
                    System.out.println("Lua chon khong hop le. Vui long thu lai.");
            }
        }
        while (true);
    }

    public void thongKeSoLuongSach(DS_Sach ds_Sach) {
        if (soLuongNXB == 0) {
            System.out.println("Chưa có NXB nào để thống kê.");
            return;
        }

        System.out.println("\n--- THONG KE SO LUONG SACH TREN TUNG NXB ---");
        
        Sach[] allBooks = ds_Sach.getDsSach(); // Lấy mảng sách
        
        for (int i = 0; i < soLuongNXB; i++) {
            NXB nxb = dsNXB[i];
            int count = 0;
            
            // Duyệt qua mảng sách để đếm
            for (Sach sach : allBooks) {
                if (sach.getManxb() != null && sach.getManxb().equals(nxb.getMaNXB())) {
                    count++;
                }
            }
            
            // In kết quả thống kê của NXB này
            System.out.printf("| %-10s | %-25s | %d (đầu sách)\n", 
                              nxb.getMaNXB(), nxb.getTenNXB(), count);
        }
        System.out.println("---------------------------------------------");
    }
}