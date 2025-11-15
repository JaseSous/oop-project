package Nhanvien;

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

public class DS_Nhanvien {
    //----Thuoc tinh----
    private NhanVien[] nv;
    private int soluong;

    //----Ham thiet lap----
    public DS_Nhanvien(){
        this.nv= new NhanVien[0];
        this.soluong=0;
    }
    public DS_Nhanvien(DS_Nhanvien other) {
        this.soluong = other.soluong;
        nv = Arrays.copyOf(other.nv, other.soluong);
    }

    // Phương thức
    public void loadFile(){
        try {
            String FilePath = "DATA/DS_Nhanvien.dat";

            // Kiểm tra file rỗng hoặc ko tồn tại
            Path path = Paths.get(FilePath);

            if (!Files.exists(path) || !Files.isRegularFile(path) || Files.size(path) == 0) {
                return;
            }

            // Đọc file
            BufferedReader reader = new BufferedReader(new FileReader(FilePath));
            int n = Integer.parseInt(reader.readLine().trim());
            
            for (int i = 0; i < n; i++){
                // Đọc các thuộc tính của class
                String manv = reader.readLine().trim();
                String ho = reader.readLine().trim();
                String ten = reader.readLine().trim();
                String ngaysinh = reader.readLine().trim();
                long luongthang = Long.parseLong(reader.readLine().trim());
                
                // Thêm vào ds
                this.them(manv, ho, ten, ngaysinh, luongthang);
            }

            reader.close();
        } catch (IOException e) {
            return;
        }
    }
    public void saveFile(){
        try (BufferedWriter writer = new BufferedWriter(new FileWriter("DATA/DS_Nhanvien.dat"))) {
            writer.write(String.valueOf(soluong));
            for (int i = 0; i < soluong; i++){
                NhanVien nhanVien = nv[i];
                writer.newLine();
                writer.write(nhanVien.getManv());
                
                writer.newLine();
                writer.write(nhanVien.getHo());
                
                writer.newLine();
                writer.write(nhanVien.getTen());
                
                writer.newLine();
                writer.write(nhanVien.getNgaysinh());
                
                writer.newLine();
                writer.write(String.valueOf(nhanVien.getLuongthang()));
            }
            
            System.out.println("Đã lưu dữ liệu vào file: DS_Nhanvien.dat");
        } catch (IOException e) {
            System.err.println("Lỗi khi lưu danh sách nhân viên vào file: " + e.getMessage());
        }
    }
    public void xem() {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter("OUTPUT/DanhSachNhanVien.txt"));
            Formatter formatter = new Formatter(writer)) {
            
                formatter.format("===[Danh sách Nhân viên]===\n");
                formatter.format("Số lượng: " + soluong + "\n\n");

                if (soluong > 0){
                    formatter.format("-".repeat(94));
                    formatter.format("\n| %-3s | %-10s | %-20s | %-10s | %-15s | %-15s |\n",
                                     "STT", "Mã NV", "Họ", "Tên", "Ngày sinh", "Lương tháng");
                    formatter.format("-".repeat(94) + "\n");

                    for (int i = 0; i < soluong; i++){
                        NhanVien nhanVien = nv[i]; // Lấy nhân viên
                        formatter.format("| %-3s | %-10s | %-20s | %-10s | %-15s | %-15s |\n",
                                        i+1,
                                        nhanVien.getManv(),
                                        nhanVien.getHo(),
                                        nhanVien.getTen(),
                                        nhanVien.getNgaysinh(),
                                        nhanVien.getLuongthang() + " ₫"); // Thêm ₫ cho đẹp
                    }
                    formatter.format("-".repeat(94));
            }

            System.out.println("Đã ghi dữ liệu vào file: DanhSachNhanVien.txt");

        } catch (IOException e) {
            System.err.println("Lỗi I/O khi xuất danh sách nhân viên: " + e.getMessage());
        }
    }
    public void them() {
        System.out.println("===[ Thêm Nhân Viên Mới ]===");
        
        // 1. Tạo một nhân viên mới
        NhanVien nvMoi = new NhanVien();
        
        nvMoi.nhap();

        // 3. Thêm nhân viên mới này vào mảng
        nv = Arrays.copyOf(nv, soluong + 1);
        nv[soluong] = nvMoi;
        soluong++;

        System.out.println("Đã thêm nhân viên " + nvMoi.getTen() + " vào danh sách.");
    }

    public void them(String manv, String ho, String ten, String ngaysinh, long luongthang) {
        nv = Arrays.copyOf(nv, soluong + 1);
        nv[soluong] = new NhanVien(manv, ho, ten, ngaysinh, luongthang);
        soluong++;
    }

    //-----Hàm xuất console----
    public void xuat() {
        if (soluong == 0) {
            System.out.println("Danh sách nhân viên rỗng.");
            return;
        }
        System.out.println("\n----- DANH SÁCH NHÂN VIÊN -----");
        for (int i = 0; i < soluong; i++) {
            System.out.println("--- Nhân viên " + (i + 1) + " ---");
            // Gọi hàm xuat() của lớp NhanVien
            nv[i].xuat(); 
            System.out.println("\n-----------------------------");
        }
    }


    //----ham xoa nhan vien----
    public void xoanv(){
        @SuppressWarnings("resource")//Dòng bỏ qua cái sc vàng 
        Scanner sc = new Scanner(System.in);
        System.out.print("Nhap ma NV muon xoa: ");
        String maxoa = sc.nextLine().trim();
        
        int vitri = -1;
        for (int i = 0; i < soluong; i++) {
            if (nv[i].getManv().equals(maxoa)) {
                vitri = i;
                break;
            }
        }
        if (vitri == -1) {
            System.out.println("Khong tim thay Nhan vien!");
            return;
        }
        for (int i = vitri; i < soluong - 1; i++) {
            nv[i] = nv[i + 1];
        }
        nv = Arrays.copyOf(nv, soluong - 1);
        soluong--;
        System.out.println("Xoa thanh cong!");
    }

    //-----ham sua nhan vien----
    public void suasv() {
        @SuppressWarnings("resource")//Dòng bỏ qua cái sc vàng 
        Scanner sc = new Scanner(System.in);
        System.out.print("Nhap ma NV muon sua: ");
        String masua = sc.nextLine();
        int vitri = -1;
        for (int i = 0; i < soluong; i++) {
            if (nv[i].getManv().equals(masua)) {
                vitri = i;
                break;
            }
        }
        if (vitri == -1) {
            System.out.println("Khong tim thay nhan vien!");
            return;
        }
        System.out.println("Tim thay nhan vien. Vui long nhap thong tin moi:");
        nv[vitri].nhap(); 

        System.out.println("Sua thong tin thanh cong!");
    }

    //----CÁC HÀM TÌM-----

    //----ham tim nhan vien theo manv----
    public void timTheoma() { // Bỏ tham số đầu vào
        @SuppressWarnings("resource")//Dòng bỏ qua cái sc vàng 
        Scanner sc = new Scanner(System.in);
        System.out.print("Nhap ma Nhan vien muon tim: ");
        String matim = sc.nextLine();
        
        // Gọi hàm helper bên dưới
        NhanVien nv_tim = timNhanVienTheoMa(matim);

        if (nv_tim != null) {
            System.out.println("Tim thay nhan vien:");
            nv_tim.xuat();
            System.out.println("---------------------------");
        } else {
            System.out.println("Khong tim thay Nhan vien!");
        }
    }

    //---- HÀM HELPER MỚI: Dùng để trả về đối tượng NhanVien ----
    public NhanVien timNhanVienTheoMa(String maNV) {
        for (int i = 0; i < soluong; i++) {
            if (nv[i].getManv().equals(maNV)) {
                return nv[i];
            }
        }
        return null;
    }

    //----Ham tim nhan vien theo Ten----
    public void timTheoten() {
        @SuppressWarnings("resource")//Dòng bỏ qua cái sc vàng 
        Scanner sc = new Scanner(System.in);
        System.out.print("Nhap ten (hoac ten mot phan) cua nhan vien muon tim: ");
        String tentim = sc.nextLine().toLowerCase();
        boolean timThay = false; // Thêm cờ

        for (int i = 0; i < soluong; i++) {
            if (nv[i].getTen().toLowerCase().contains(tentim)) {
                System.out.println("Tim thay nhan vien:");
                nv[i].xuat(); 
                System.out.println("---------------------------");
                timThay = true;
            }
        }
    
        if (!timThay) { // Chỉ in nếu không tìm thấy
            System.out.println("Khong tim thay nhan vien nao co ten phu hop!");
        }
    }

    //----Ham tim nhan vien theo ho----
    public void timTheoho() {
        @SuppressWarnings("resource")//Dòng bỏ qua cái sc vàng 
        Scanner sc = new Scanner(System.in);
        System.out.print("Nhap ho (hoac ten mot phan) cua nhan vien muon tim: ");
        String hotim = sc.nextLine().toLowerCase();
        boolean timThay = false; // Thêm cờ

        for (int i = 0; i < soluong; i++) {
            if (nv[i].getHo().toLowerCase().contains(hotim)) {
                System.out.println("Tim thay nhan vien:");
                nv[i].xuat(); 
                System.out.println("---------------------------");
                timThay = true; // Đánh dấu đã tìm thấy
            }
        }
    
        if (!timThay) { // Chỉ in nếu không tìm thấy
            System.out.println("Khong tim thay nhan vien nao co ho phu hop!");
        }
    }

    //---------CÁC HÀM THỐNG KÊ----------

    //----hàm thống kê nhan vien theo tuổi----
    public void Thongketheonhomtuoi() {
        int duoi20 = 0;
        int tu20den29 = 0;
        int tren30 = 0;
    
        for (int i = 0; i < soluong; i++) {
            int tuoi = nv[i].age();  // Gọi hàm age() của từng nhân viên
    
            if (tuoi < 20) {
                duoi20++;
            } else if (tuoi < 30) {
                tu20den29++;
            } else {
                tren30++;
            }
        }
    
        System.out.println("----- Thong ke theo nhom tuoi -----");
        System.out.println("Duoi 20 tuoi: " + duoi20 + " nhan vien");
        System.out.println("Tu 20 den 29 tuoi: " + tu20den29 + " nhan vien");
        System.out.println("Tu 30 tuoi tro len: " + tren30 + " nhan vien");
    }

    //----Hàm thống kê theo Tên----
    public void Thongketheoten() {
        String[] cacTen = new String[0]; // Mảng chứa các tên khác nhau
        int[] demTen = new int[0];       // Mảng chứa số lượng tương ứng
    
        for (int i = 0; i < soluong; i++) {
            String ten = nv[i].getTen().trim(); // Lấy ten của nhan vien
            boolean daCo = false;
    
            for (int j = 0; j < cacTen.length; j++) {
                if (cacTen[j].equalsIgnoreCase(ten)) {
                    demTen[j]++;
                    daCo = true;
                    break;
                }
            }
    
            if (!daCo) { // Nếu tên này chưa có trong mảng
                cacTen = Arrays.copyOf(cacTen, cacTen.length + 1);
                demTen = Arrays.copyOf(demTen, demTen.length + 1);
                cacTen[cacTen.length - 1] = ten;
                demTen[demTen.length - 1] = 1;
            }
        }
    
        // In kết quả
        System.out.println("----- Thong ke theo Ten -----");
        for (int i = 0; i < cacTen.length; i++) {
            System.out.println(cacTen[i] + ": " + demTen[i] + " nhan vien");
        }
    }
    
}