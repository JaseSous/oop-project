package Tacgia;

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

public class DS_Tacgia {
    private Tacgia[] tg;
    private int soluong;

    //----Ham thiet lap----
    public DS_Tacgia(){
        this.tg=new Tacgia[0];
        this.soluong=0;
    }
    public DS_Tacgia(DS_Tacgia other) {
        this.soluong = other.soluong;
        tg = Arrays.copyOf(other.tg, other.soluong);
    }
    
    public void loadFile(){
        try {
            String FilePath = "DATA/DS_Tacgia.dat";

            // Kiểm tra file rỗng hoặc ko tồn tại
            Path path = Paths.get(FilePath);

            if (!Files.exists(path) || !Files.isRegularFile(path) || Files.size(path) == 0) {
                return;
            }

            // Đọc file
            BufferedReader reader = new BufferedReader(new FileReader(FilePath));
            
            int n = Integer.parseInt(reader.readLine().trim());
            
            for (int i = 0; i < n; i++){
                // Đọc các thuộc tính của sách
                long matg = Long.parseLong(reader.readLine().trim());
                String ho = reader.readLine().trim();
                String ten = reader.readLine().trim();
                String trinhdo = reader.readLine().trim();
                String ngaysinh = reader.readLine().trim();
                
                //Gọi hàm them() (có tham số) mới
                this.them(matg, ho, ten, trinhdo, ngaysinh);
            }

            reader.close();
        } catch (IOException | NumberFormatException e) {
            System.err.println("Lỗi khi đọc file DS_Tacgia.dat: " + e.getMessage());
        }
    }

    public void saveFile(){
        try (BufferedWriter writer = new BufferedWriter(new FileWriter("DATA/DS_Tacgia.dat"))) {
            
            // Ghi tổng số lượng
            writer.write(String.valueOf(soluong));
            
            // Lặp qua mảng và ghi 5 thuộc tính
            for (int i = 0; i < soluong; i++){
                Tacgia tacGia = tg[i]; 

                writer.newLine();
                writer.write(String.valueOf(tacGia.getMatg()));
                
                writer.newLine();
                writer.write(tacGia.getHo());
                
                writer.newLine();
                writer.write(tacGia.getTen());
                
                writer.newLine();
                writer.write(tacGia.getTrinhdo());

                writer.newLine();
                writer.write(tacGia.getNgaysinh());
            }
            
            System.out.println("Đã lưu dữ liệu vào file: DS_Tacgia.dat");

        } catch (IOException e) {
            System.err.println("Lỗi khi lưu danh sách tác giả vào file: " + e.getMessage());
        }
    }
    
    public void xem() {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter("OUTPUT/DanhSachTacgia.txt"));
             Formatter formatter = new Formatter(writer)) {
            
                formatter.format("===[Danh sách Tác giả]===\n");
                formatter.format("Số lượng: " + soluong + "\n\n");

                if (soluong > 0){
                    formatter.format("-".repeat(94));
                    formatter.format("\n| %-3s | %-10s | %-20s | %-10s | %-15s | %-15s |\n",
                                     "STT", "Mã Tác Giả", "Họ", "Tên", "Trình độ", "Ngày sinh");
                    formatter.format("-".repeat(94) + "\n");

                    for (int i = 0; i < soluong; i++){
                        Tacgia tacGia = tg[i]; // Lấy tác giả
                        formatter.format("| %-3s | %-10s | %-20s | %-10s | %-15s | %-15s |\n",
                                        i+1,
                                        tacGia.getMatg(),
                                        tacGia.getHo(),
                                        tacGia.getTen(),
                                        tacGia.getTrinhdo(), 
                                        tacGia.getNgaysinh());
                    }
                    formatter.format("-".repeat(94));
                }

                System.out.println("Đã ghi dữ liệu vào file: DanhSachTacgia.txt");

        } catch (IOException e) {
            System.err.println("Lỗi I/O: " + e.getMessage());
        }
    }

    //-----Hàm them ko tham số----
    public void them() {
        System.out.println("===[ Thêm Tác Giả Mới ]===");
        
        // Tạo một tác giả mới
        Tacgia tgMoi = new Tacgia();
        tgMoi.nhap(); 

        // Thêm vào mảng
        tg = Arrays.copyOf(tg, soluong + 1);
        tg[soluong] = tgMoi;
        soluong++;

        System.out.println("Đã thêm tác giả " + tgMoi.getTen() + " vào danh sách.");
    }

    //---- Hàm them có tham số----
    public void them(long matg, String ho, String ten, String trinhdo, String ngaysinh) {
        tg = Arrays.copyOf(tg, soluong + 1);
        tg[soluong] = new Tacgia(matg, ho, ten, trinhdo, ngaysinh);
        soluong++;
    }
    //----Hàm xuất ra console----
    public void xuat() {
        if (soluong == 0) {
            System.out.println("Danh sách tác giả rỗng.");
            return;
        }
        System.out.println("\n----- DANH SÁCH TÁC GIẢ -----");
        for (int i = 0; i < soluong; i++) {
            System.out.println("--- Tác giả " + (i + 1) + " ---");
            // Gọi hàm xuat() của lớp Tacgia
            // (Giả định lớp Tacgia.java của bạn có hàm xuat())
            tg[i].xuat(); 
            System.out.println("\n-----------------------------");
        }
    }
    

    //----Ham xoa tac gia----
    public void xoatg(){
        @SuppressWarnings("resource")//Dòng bỏ qua cái sc vàng 
        Scanner sc = new Scanner(System.in);
        System.out.print("Nhap ma tac gia muon xoa: ");
        long maxoa = sc.nextLong();
        
        int vitri = -1;
        for (int i = 0; i < soluong; i++) {
            if (tg[i].getMatg() == maxoa) {
                vitri = i;
                break;
            }
        }
        if (vitri == -1) {
            System.out.println("khong tim thay tac gia!");
            return;
        }
        for (int i = vitri; i < soluong - 1; i++) {
            tg[i] = tg[i + 1];
        }
        tg = Arrays.copyOf(tg, soluong - 1);
        soluong--;
        System.out.println("Xoa thanh cong!");
    }
    
    //----Ham sua tac gia----
    public void suatg() { 
        @SuppressWarnings("resource")
        Scanner sc = new Scanner(System.in);
        System.out.print("Nhap ma tac gia muon sua: ");
        long masua = sc.nextLong();
        int vitri = -1;
        
        for (int i = 0; i < soluong; i++) {
            if (tg[i].getMatg() == masua) {
                vitri = i;
                break;
            }
        }
        
        if (vitri == -1) {
            System.out.println("khong tim thay tac gia!");
            return;
        }
        System.out.println("Tim thay! Vui long nhap thong tin moi:");
        tg[vitri].nhap(); // Gọi hàm nhap() của lớp Tacgia

        System.out.println("Sua thong tin thanh cong!");
    }
    
    //--------CÁC HÀM TÌM-----------

    //----Ham tim tac gia theo matg----
    public void timTheoma() {
        @SuppressWarnings("resource")
        Scanner sc = new Scanner(System.in);
        System.out.print("Nhap ma tac gia muon tim: ");
        long matim = sc.nextLong(); // SỬA 1: Dùng long
        boolean timThay = false;     // SỬA 2: Thêm cờ

        for (int i = 0; i < soluong; i++) {
            if (tg[i].getMatg() == matim) {
                System.out.println("Tim thay tac gia:");
                tg[i].xuat();
                System.out.println("---------------------------");
                timThay = true; // SỬA 3: Đặt cờ
                break; // Mã là duy nhất, nên break
            }
        }
        
        if (!timThay) { // SỬA 4: Chỉ in nếu không tìm thấy
            System.out.println("khong tim thay tac gia!");
        }
    }

    //----Ham tim tac gia  theo Ten----
    public void timTheoten() {
        @SuppressWarnings("resource")
        Scanner sc = new Scanner(System.in);
        System.out.print("Nhap ten (hoac ten mot phan) cua tac gia muon tim: ");
        String tentim = sc.nextLine().toLowerCase();
        boolean timThay = false; // Thêm cờ

        for (int i = 0; i < soluong; i++) {
            if (tg[i].getTen().toLowerCase().contains(tentim)) {
                System.out.println("Tim thay tac gia:");
                tg[i].xuat();
                System.out.println("---------------------------");
                timThay = true; // Đặt cờ
            }
        }
        
        if (!timThay) {
            System.out.println("khong tim thay tac gia nao co ten phu hop!");
        }
    }

    //----Ham tim tac gia theo ho----
    public void timTheoho() {
        @SuppressWarnings("resource")
        Scanner sc = new Scanner(System.in);
        System.out.print("Nhap ho (hoac ten mot phan) cua tac gia muon tim: ");
        String hotim = sc.nextLine().toLowerCase();
        boolean timThay = false; // Thêm cờ

        for (int i = 0; i < soluong; i++) {
            if (tg[i].getHo().toLowerCase().contains(hotim)) {
                System.out.println("Tim thay tac gia:");
                tg[i].xuat();
                System.out.println("---------------------------");
                timThay = true; // Đặt cờ
            }
        }
        
        if (!timThay) {
            System.out.println("khong tim thay tac gia nao co ho phu hop!");
        }
    }

    //---------CÁC HÀM THỐNG KÊ----------

    //----hàm thống kê tac gia theo tuổi----
    public void thongKeTheoNhomTuoi() {
        int duoi20 = 0;
        int tu20den29 = 0;
        int tren30 = 0;
    
        for (int i = 0; i < soluong; i++) {
            int tuoi = tg[i].age();  // Gọi hàm age() của từng tac gia
    
            if (tuoi < 20) {
                duoi20++;
            } else if (tuoi < 30) {
                tu20den29++;
            } else {
                tren30++;
            }
        }
    
        System.out.println("----- Thong ke theo nhom tuoi -----");
        System.out.println("Duoi 20 tuoi: " + duoi20 + " tac gia");
        System.out.println("Tu 20 den 29 tuoi: " + tu20den29 + " tac gia");
        System.out.println("Tu 30 tuoi tro len: " + tren30 + " tac gia");
    }

    //----Hàm thống kê theo Họ----
    public void thongKeTheoHo() {
        String[] cacHo = new String[0]; // Mảng chứa các họ khac nhau
        int[] demHo = new int[0];       // Mảng chứa số lượng tương ứng
    
        for (int i = 0; i < soluong; i++) {
            String ho = tg[i].getHo().trim(); // Lấy họ của tac gia
            boolean daCo = false;
    
            for (int j = 0; j < cacHo.length; j++) {
                if (cacHo[j].equalsIgnoreCase(ho)) {
                    demHo[j]++;
                    daCo = true;
                    break;
                }
            }
    
            if (!daCo) { // Nếu họ này chưa có trong mảng
                cacHo = Arrays.copyOf(cacHo, cacHo.length + 1);
                demHo = Arrays.copyOf(demHo, demHo.length + 1);
                cacHo[cacHo.length - 1] = ho;
                demHo[demHo.length - 1] = 1;
            }
        }
    
        // In kết quả
        System.out.println("----- Thong ke theo Ho -----");
        for (int i = 0; i < cacHo.length; i++) {
            System.out.println(cacHo[i] + ": " + demHo[i] + " tac gia");
        }
    }
    
    //----Hàm thống kê theo Tên----
    public void thongKeTheoTen() {
        String[] cacTen = new String[0]; // Mảng chứa các tên khac nhau
        int[] demTen = new int[0];       // Mảng chứa số lượng tương ứng
    
        for (int i = 0; i < soluong; i++) {
            String ten = tg[i].getTen().trim(); // Lấy ten của tgách hàng
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
            System.out.println(cacTen[i] + ": " + demTen[i] + " tac gia");
        }
    }

}
