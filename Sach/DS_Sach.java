package Sach;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.Scanner;
import java.util.Formatter;

public class DS_Sach {
    Scanner sc = new Scanner(System.in);

    // Thuoc tinh
    private int soLuongSach;
    private Sach[] dsSach;

    // Constructor
    public DS_Sach() {
        soLuongSach = 0;
        dsSach = new Sach[0];
    }

    public DS_Sach(DS_Sach other) {
        this.soLuongSach = other.soLuongSach;
        dsSach = Arrays.copyOf(other.dsSach, other.soLuongSach);
    }

    // Phương thức
    public void nhap(){
        System.out.print("Nhập số lượng sách: ");
        soLuongSach = Integer.parseInt(sc.nextLine());
        dsSach = new Sach[soLuongSach];

        for (int i = 0; i < soLuongSach; i++) {
            System.out.println("\nNhập thông tin sách thứ " + (i + 1) + ":");
            Sach sach = null;
            int choice;

            do {
                System.out.println("Loại sách (1: SGK, 2: SNC): "); choice = Integer.parseInt(sc.nextLine());
                switch (choice) {
                    case 1:
                        sach = new SGK();
                        break;
                    case 2:
                        sach = new SNC();
                        break;
                    default:
                        System.out.println("Vui lòng nhập số từ khoảng 1-2: ");
                }
            } while (sach == null);
            sach.nhap();
            dsSach[i] = sach;
        }
    }

    public void xuat() {
        System.out.println("===[Danh sách sản phẩm]===");
        System.out.println("Số lượng: " + soLuongSach + '\n');
        for (int i = 0; i < soLuongSach; i++) {
            System.out.println("Sách thứ " + (i + 1) + ":");
            dsSach[i].xuat();
        }
    }

    public void loadFile(){
        try {
            String FilePath = "DATA/DS_Sach.dat";

            // Kiểm tra file rỗng hoặc ko tồn tại
            Path path = Paths.get(FilePath);

            if (!Files.exists(path) || !Files.isRegularFile(path) || Files.size(path) == 0) {
                return;
            }

            // Đọc file
            BufferedReader reader = new BufferedReader(new FileReader(FilePath));
            int n = Integer.parseInt(reader.readLine().trim());
            
            for (int i = 0; i < n; i++){
                int loaiSach = Integer.parseInt(reader.readLine().trim());
                // Đọc các thuộc tính của sách
                String
                    masach = reader.readLine().trim(),
                    tensach = reader.readLine().trim(),
                    matheloai = reader.readLine().trim(),
                    matg = reader.readLine().trim(),
                    manxb = reader.readLine().trim();

                int
                    soluong = Integer.parseInt(reader.readLine().trim()),
                    gia = Integer.parseInt(reader.readLine().trim());
                
                // Thêm vào ds sách
                if (loaiSach == 1){
                    String
                        monhoc = reader.readLine().trim();
                    int
                        lop = Integer.parseInt(reader.readLine().trim());

                    this.them(new SGK(masach, tensach, matheloai, matg, manxb, soluong, gia, monhoc, lop));
                }
                else{
                    String
                        linhvuc = reader.readLine().trim(),
                        detai = reader.readLine().trim();
                    
                    this.them(new SNC(masach, tensach, matheloai, matg, manxb, soluong, gia, linhvuc, detai));
                }
            }

            reader.close();
        } catch (IOException e) {
            return;
        }
    }

    public void saveFile(){
        try (BufferedWriter writer = new BufferedWriter(new FileWriter("DATA/DS_Sach.dat"))) {
            writer.write(String.valueOf(soLuongSach));
            for (Sach sach : dsSach){
                if (sach instanceof SGK){
                    writer.newLine();
                    writer.write("1");
                }
                else if (sach instanceof SNC){
                    writer.newLine();
                    writer.write("2");
                }
                writer.newLine();
                writer.write(sach.getMasach());
                writer.newLine();
                writer.write(sach.getTensach());
                writer.newLine();
                writer.write(sach.getMatheloai());
                writer.newLine();
                writer.write(sach.getMatg());
                writer.newLine();
                writer.write(sach.getManxb());
                writer.newLine();
                writer.write(String.valueOf(sach.getSoluong()));
                writer.newLine();
                writer.write(String.valueOf(sach.getGia()));
                if (sach instanceof SGK){
                    writer.newLine();
                    writer.write(((SGK)sach).getMonHoc());
                    writer.newLine();
                    writer.write(String.valueOf(((SGK)sach).getLop()));
                }
                else if (sach instanceof SNC){
                    writer.newLine();
                    writer.write(((SNC)sach).getLinhVuc());
                    writer.newLine();
                    writer.write(String.valueOf(((SNC)sach).getDeTai()));
                }
            }
            
            System.out.println("Đã lưu dữ liệu vào file: DS_Sach.dat");
        } catch (IOException e) {
            System.err.println("Lỗi khi lưu danh sách sản phẩm vào file: " + e.getMessage());
        }
    }

    public void ghiFile() {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter("OUTPUT/DanhSachSanPham.txt"));
            Formatter formatter = new Formatter(writer)) {
            
            formatter.format("===[Danh sách sản phẩm]===\n");
            formatter.format("Số lượng: " + soLuongSach + "\n\n");

            if (soLuongSach > 0){
                formatter.format("-".repeat(156));
                formatter.format("\n| %-3s | %-9s | %-7s | %-25s | %-11s | %-10s | %-6s | %-8s | %-9s | %-9s | %-3s | %-8s | %-8s |\n",
                                "STT", "Loại sách", "Mã sách", "Tên sách", "Mã thể loại", "Mã tác giả", "Mã NXB", "Số lượng", "Giá", " Môn học ", "Lớp", "Lĩnh vực", " Đề tài ");
                formatter.format("-".repeat(156) + "\n");

                for (int i = 0; i < soLuongSach; i++){
                    if (dsSach[i] instanceof SGK){
                        formatter.format("| %-3s | %-9s | %-7s | %-25s | %-11s | %-10s | %-6s | %-8s | %-9s | %-9s | %-3s | %-8s | %-8s |\n",
                                i+1,
                                "SGK",
                                dsSach[i].getMasach(),
                                dsSach[i].getTensach(),
                                dsSach[i].getMatheloai(),
                                dsSach[i].getMatg(),
                                dsSach[i].getManxb(),
                                dsSach[i].getSoluong(),
                                dsSach[i].getGia() + " ₫",
                                ((SGK)dsSach[i]).getMonHoc(),
                                String.valueOf(((SGK)dsSach[i]).getLop()),
                                "",
                                "");
                    }
                    else if (dsSach[i] instanceof SNC){
                        formatter.format("| %-3s | %-9s | %-7s | %-25s | %-11s | %-10s | %-6s | %-8s | %-9s | %-9s | %-3s | %-8s | %-8s |\n",
                                i+1,
                                "SNC",
                                dsSach[i].getMasach(),
                                dsSach[i].getTensach(),
                                dsSach[i].getMatheloai(),
                                dsSach[i].getMatg(),
                                dsSach[i].getManxb(),
                                dsSach[i].getSoluong(),
                                dsSach[i].getGia() + " ₫",
                                "",
                                "",
                                ((SNC)dsSach[i]).getLinhVuc(),
                                String.valueOf(((SNC)dsSach[i]).getDeTai()));
                    }
                }
                formatter.format("-".repeat(156));
            }

            System.out.println("Đã ghi dữ liệu vào file: DanhSachSanPham.txt");

        } catch (IOException e) {
            System.err.println("Lỗi I/O: " + e.getMessage());
        }
    }

    public void them() {
        dsSach = Arrays.copyOf(dsSach, dsSach.length + 1);
        System.out.println("Nhập thông tin sách để thêm vào danh sách sản phẩm: ");
        System.out.print("\tLoại sách (1: SGK, 2: SNC): "); int loaisach = Integer.parseInt(sc.nextLine().trim());
        
        if (loaisach == 1)
            dsSach[soLuongSach] = new SGK();
        else
            dsSach[soLuongSach] = new SNC();

        dsSach[soLuongSach].nhap();
        soLuongSach++;

        System.out.println("Đã thêm thành công sách " + dsSach[soLuongSach-1].getTensach() + " vào danh sách sản phẩm");
    }

    public void them(Sach sach) {
        dsSach = Arrays.copyOf(dsSach, dsSach.length + 1);
        if (sach instanceof SGK)
            dsSach[soLuongSach] = new SGK((SGK)sach);
        else if (sach instanceof SNC)
            dsSach[soLuongSach] = new SNC((SNC)sach);
        soLuongSach++;
    }

    public void xoa(){
        System.out.print("Nhập mã sách của sách cần xóa khỏi danh sách sản phẩm: "); String maSachCanXoa = sc.nextLine().trim();
        
        for (int i = 0; i < soLuongSach; i++){
            if (dsSach[i].getMasach().equals(maSachCanXoa)){
                for (int j = i; j < soLuongSach-1; j++){
                    dsSach[j] = dsSach[j+1];
                }

                soLuongSach -= 1;
                dsSach = Arrays.copyOf(dsSach, soLuongSach);

                System.out.println("Đã xóa sách có mã sách " + maSachCanXoa + " ra khỏi danh sách sản phẩm");
                return;
            }
        }

        System.out.println("Không tìm thấy sách cần xóa.");
    }

    public void sua(){
        System.out.print("Nhập mã sách của sách cần sửa trong danh sách sản phẩm: "); String maSachCanSua = sc.nextLine().trim();
        
        for (int i = 0; i < soLuongSach; i++){
            if (dsSach[i].getMasach().equals(maSachCanSua)){
                System.out.println("Hãy nhập thông tin của sách sau khi sửa:");
                dsSach[i].nhap();

                System.out.println("Đã sửa sách có mã sách " + maSachCanSua + " trong khỏi danh sách sản phẩm");
                return;
            }
        }

        System.out.println("Không tìm thấy sách cần sửa.");
    }

    public Sach timKiemTheoMaSach(String maSachCanTim){
        for (Sach sach : dsSach){
            if (sach.getMasach().equals(maSachCanTim)){
                return sach;
            }
        }

        return null;
    }

    public Sach[] timKiemTheoMaTheLoai(String matheloaicantim){
        Sach[] result = new Sach[0];
        
        for (Sach sach : dsSach){
            if (sach.getMatheloai().equals(matheloaicantim)){
                result = Arrays.copyOf(result, result.length+1);
                result[result.length-1] = new Sach(sach);
            }
        }

        return result;
    }

    public int[] thongKeLoaiSach(){
        //result[0] là sgk, result[1] là snc
        int[] result = new int[2];
        
        for (Sach sach : dsSach){
            if (sach instanceof SGK)
                result[0]++;
            else if (sach instanceof SNC)
                result[1]++;
        }

        return result;
    }
}
