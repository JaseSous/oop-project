package Khachhang;

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

public class DS_Khachhang {
    private Khachhang[] kh;
    private int soluong;

    //----Ham thiet lap----
    public DS_Khachhang(){
        this.kh=new Khachhang[0];
        this.soluong=0;
    }
    public DS_Khachhang(DS_Khachhang other) {
        this.soluong = other.soluong;
        kh = Arrays.copyOf(other.kh, other.soluong);
    }
    // Phương thức
    public void loadFile(){
        try {
            String FilePath = "../DATA/DS_Khachhang.dat";

            // Kiểm tra file rỗng hoặc ko tồn tại
            Path path = Paths.get(FilePath);

            if (!Files.exists(path) || !Files.isRegularFile(path) || Files.size(path) == 0) {
                return;
            }

            // Đọc file
            BufferedReader reader = new BufferedReader(new FileReader(FilePath));
            int n = Integer.parseInt(reader.readLine().trim());
            
            for (int i = 0; i < n; i++){
                // Đọc các thuộc tính của khách hàng 
                long makh = Long.parseLong(reader.readLine().trim()); 
                String ho = reader.readLine().trim();
                String ten = reader.readLine().trim();
                String dchi = reader.readLine().trim();
                long sdt = Long.parseLong(reader.readLine().trim()); 
                String ngaysinh = reader.readLine().trim();
                String ngaymuahang = reader.readLine().trim();

                // them vào danh sách khách hàng
                this.them(makh, ho, ten, dchi, sdt, ngaysinh,ngaymuahang);
            }

            reader.close();
        } catch (IOException e) {
            return;
        }
    }
    public void xem() {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter("../OUTPUT/DanhSachKhachHang.txt")); // Đổi tên file cho đúng ngữ cảnh
             Formatter formatter = new Formatter(writer)) {
                
            formatter.format("===[Danh sách Khách hàng]===\n"); // Đổi tiêu đề
            formatter.format("Số lượng: " + soluong + "\n\n");
    
            if (soluong > 0){
                formatter.format("-".repeat(122)); 
                formatter.format("\n| %-3s | %-7s | %-15s | %-10s | %-15s | %-10s | %-15s | %-15s\n", // 7 cột
                                     "STT", "Mã KH", "Họ", "Tên", "SĐT", "Địa chỉ", "Ngày sinh","Ngày mua hàng"); 
                formatter.format("-".repeat(122) + "\n"); 
    
                for (int i = 0; i < soluong; i++){
                    formatter.format("| %-3s | %-7s | %-15s | %-10s | %-15s | %-10s | %-15s | %-15s\n",
                                    i+1,
                                    kh[i].getMakh(),
                                    kh[i].getHo(),
                                    kh[i].getTen(),
                                    kh[i].getSdt(),
                                    kh[i].getDchi(),
                                    kh[i].getNgaysinh(),
                                    kh[i].getNgaymuahang());
                }
                formatter.format("-".repeat(122));
            }
    
            System.out.println("Đã ghi dữ liệu vào file: DanhSachKhachHang.txt"); // Đổi tên file
    
        } catch (IOException e) {
            System.err.println("Lỗi I/O: " + e.getMessage());
        }
    }

    public void saveFile(){
        try (BufferedWriter writer = new BufferedWriter(new FileWriter("DATA/DS_Khachhang.dat"))) {
    
            // 1. Ghi tổng số lượng
            writer.write(String.valueOf(soluong));
    
            // 2. Lặp qua mảng và ghi 7 thuộc tính
            for (int i = 0; i < soluong; i++){
                Khachhang khach = kh[i]; 
    
                writer.newLine();
                writer.write(String.valueOf(khach.getMakh()));
    
                writer.newLine();
                writer.write(khach.getHo());
    
                writer.newLine();
                writer.write(khach.getTen());
    
                writer.newLine();
                writer.write(khach.getDchi());
    
                writer.newLine();
                writer.write(String.valueOf(khach.getSdt()));
    
                writer.newLine();
                writer.write(khach.getNgaysinh());
    
                writer.newLine();
                writer.write(khach.getNgaymuahang());
            }
    
            System.out.println("Đã lưu dữ liệu vào file: DS_Khachhang.dat");
    
        } catch (IOException e) {
            System.err.println("Lỗi khi lưu danh sách khách hàng vào file: " + e.getMessage());
        }
    }

    public void them() {
        System.out.println("===[ Thêm Khách Hàng Mới ]===");
    
        // 1. Tạo một khách hàng mới
        Khachhang khMoi = new Khachhang();
        khMoi.nhap(); 
    
        // 3. Thêm khách hàng mới này vào mảng
        kh = Arrays.copyOf(kh, soluong + 1);
        kh[soluong] = khMoi;
        soluong++;
    
        System.out.println("Đã thêm khách hàng " + khMoi.getTen() + " vào danh sách.");
    }
    
    public void them(long makh, String ho, String ten, String dchi,long sdt, String ngaysinh,String ngaymuahang ) {
        kh = Arrays.copyOf(kh, kh.length + 1);
        kh[soluong] = new Khachhang(makh, ho, ten, dchi,sdt, ngaysinh, ngaymuahang);
        soluong++;
    }

    //-----Hàm xuất ra console----
    public void xuat() {
        if (soluong == 0) {
            System.out.println("Danh sách khách hàng rỗng.");
            return;
        }
        System.out.println("\n----- DANH SÁCH KHÁCH HÀNG -----");
        for (int i = 0; i < soluong; i++) {
            System.out.println("--- Khách hàng " + (i + 1) + " ---");
            // Gọi hàm xuat() của lớp Khachhang
            // (Hàm này đã được dùng trong timTheoma() nên chắc chắn đã có)
            kh[i].xuat(); 
            System.out.println("\n-----------------------------");
        }
    }

    //----Ham xoa khach hang----
    public void xoakh(){
        @SuppressWarnings("resource")//Dòng bỏ qua cái sc vàng 
        Scanner sc = new Scanner(System.in);
        System.out.print("Nhap ma KH muon xoa: ");
        long maxoa = sc.nextLong();
        
        int vitri = -1;
        for (int i = 0; i < soluong; i++) {
            if (kh[i].getMakh() == maxoa) {
                vitri = i;
                break;
            }
        }
        if (vitri == -1) {
            System.out.println("Khong tim thay khach hang!");
            return;
        }
        for (int i = vitri; i < soluong - 1; i++) {
            kh[i] = kh[i + 1];
        }
        kh = Arrays.copyOf(kh, soluong - 1);
        soluong--;
        System.out.println("Xoa thanh cong!");
    }
    
    //----Ham sua khach hang----
    public void suakh() {
        @SuppressWarnings("resource")
        Scanner sc = new Scanner(System.in);
        System.out.print("Nhap ma KH muon sua: ");
        long masua = sc.nextLong();
        int vitri = -1;
    
        // 1. Tìm vị trí
        for (int i = 0; i < soluong; i++) {
            if (kh[i].getMakh() == masua) {
                vitri = i;
                break;
            }
        }
    
        if (vitri == -1) {
            System.out.println("Khong tim thay khach hang!");
            return;
        }
    
        // 2. Gọi hàm nhap() của chính đối tượng đó
        System.out.println("Tim thay! Vui long nhap thong tin moi:");
        kh[vitri].nhap();
    
        System.out.println("Sua thong tin thanh cong!");
    }
    
    //--------CÁC HÀM TÌM-----------

    //----Ham tim khach hang theo makh----
    public void timTheoma() { // Bỏ tham số đầu vào
        @SuppressWarnings("resource")//Dòng bỏ qua cái sc vàng 
        Scanner sc = new Scanner(System.in);
        System.out.print("Nhap ma Khach Hang muon tim: ");
        long matim = sc.nextInt();
        
        // Gọi hàm helper bên dưới
        Khachhang kh_tim = timKhachHangTheoMa(matim); 
        
        if (kh_tim != null) {
            System.out.println("Tim thay khach hang:");
            kh_tim.xuat();
            System.out.println("---------------------------");
        } else {
            System.out.println("Khong tim thay Khach Hang!");
        }
    }

    //---- HÀM HELPER MỚI: Dùng để trả về đối tượng Khachhang ----
    public Khachhang timKhachHangTheoMa(long maKH) {
        for (int i = 0; i < soluong; i++) {
            if (kh[i].getMakh() == maKH) {
                return kh[i]; // Trả về đối tượng tìm thấy
            }
        }
        return null; // Không tìm thấy
    }

    //----Ham tim khach hang theo Ten----
    public void timTheoten() {
        @SuppressWarnings("resource")//Dòng bỏ qua cái sc vàng 
        Scanner sc = new Scanner(System.in);
        System.out.print("Nhap ten (hoac ten mot phan) cua khach hang muon tim: ");
        String tentim = sc.nextLine().toLowerCase();
        boolean timThay = false; // Thêm cờ

        for (int i = 0; i < soluong; i++) {
            if (kh[i].getTen().toLowerCase().contains(tentim)) {
                System.out.println("Tim thay khach hang:");

                kh[i].xuat();

                System.out.println("---------------------------");
                timThay = true;//Đánh dấu đã tìm thấy
            }
        }
        if (!timThay) {
            System.out.println("Khong tim thay khach hang nao co ten phu hop!");
        }
    }

    //----Ham tim khach hang theo ho----
    public void timTheoho() {
        @SuppressWarnings("resource")//Dòng bỏ qua cái sc vàng 
        Scanner sc = new Scanner(System.in);
        System.out.print("Nhap ho (hoac ten mot phan) cua khach hang muon tim: ");
        String hotim = sc.nextLine().toLowerCase();
        boolean timThay = false; // Thêm cờ

        for (int i = 0; i < soluong; i++) {
            if (kh[i].getHo().toLowerCase().contains(hotim)) {
                System.out.println("Tim thay khach hang:");

                kh[i].xuat();

                System.out.println("---------------------------");
                timThay = true;//Đánh dấu đã tìm thấy
            }
        }
        if (!timThay) {
            System.out.println("Khong tim thay khach hang nao co ho phu hop!");
        }
    }

    //----Ham tim khach hang theo sdt----
    public void timTheosdt() {
        @SuppressWarnings("resource")//Dòng bỏ qua cái sc vàng 
        Scanner sc = new Scanner(System.in);
        System.out.print("Nhap so dien thoai Khach Hang muon tim: ");
        
        long sdttim = sc.nextLong();
        boolean timThay = false;// Thêm cờ

        for (int i = 0; i < soluong; i++) {
            if (kh[i].getSdt() == sdttim) {
                System.out.println("Tim thay khach hang:");
                kh[i].xuat();
                System.out.println("---------------------------");
                timThay = true;// Đánh dấu đã tìm thấy
            }
        }
        
        //Chỉ thông báo khi không tìm thấy
        if (!timThay) {
            System.out.println("Khong tim thay Khach Hang!");
        }
    }

    //---------CÁC HÀM THỐNG KÊ----------

    //----hàm thống kê khách hàng theo tuổi----
    public void thongKeTheoNhomTuoi() {
        int duoi20 = 0;
        int tu20den29 = 0;
        int tren30 = 0;
    
        for (int i = 0; i < soluong; i++) {
            int tuoi = kh[i].age();  // Gọi hàm age() của từng Khách hàng
    
            if (tuoi < 20) {
                duoi20++;
            } else if (tuoi < 30) {
                tu20den29++;
            } else {
                tren30++;
            }
        }
    
        System.out.println("----- Thong ke theo nhom tuoi -----");
        System.out.println("Duoi 20 tuoi: " + duoi20 + " sinh vien");
        System.out.println("Tu 20 den 29 tuoi: " + tu20den29 + " sinh vien");
        System.out.println("Tu 30 tuoi tro len: " + tren30 + " sinh vien");
    }

    //----Hàm thống kê theo Họ----
    public void thongKeTheoHo() {
        String[] cacHo = new String[0]; // Mảng chứa các họ khác nhau
        int[] demHo = new int[0];       // Mảng chứa số lượng tương ứng
    
        for (int i = 0; i < soluong; i++) {
            String ho = kh[i].getHo().trim(); // Lấy họ của khách hàng
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
            System.out.println(cacHo[i] + ": " + demHo[i] + " khach hang");
        }
    }
    
    //----Hàm thống kê theo Tên----
    public void thongKeTheoTen() {
        String[] cacTen = new String[0]; // Mảng chứa các tên khác nhau
        int[] demTen = new int[0];       // Mảng chứa số lượng tương ứng
    
        for (int i = 0; i < soluong; i++) {
            String ten = kh[i].getTen().trim(); // Lấy ten của khách hàng
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
            System.out.println(cacTen[i] + ": " + demTen[i] + " khach hang");
        }
    }

    //----Hàm thống kê khách hàng theo Quý (dựa trên ngày mua hàng)----
    public void thongKeTheoQuy() {
        int[] dem = new int[4];// quý 1->4
        int loi = 0; // Đếm các ngày mua hàng bị lỗi định dạng

        for (int i = 0; i < soluong; i++) {
            try {
                // Lấy chuỗi ngày mua hàng, ví dụ: "25/10/2025"
                String ngayMuaStr = kh[i].getNgaymuahang(); 
                
                // Tách chuỗi bằng dấu "/"
                String[] parts = ngayMuaStr.split("/"); // parts = ["25", "10", "2025"]
                
                if (parts.length == 3) {
                    // 1. Lấy tháng từ chuỗi (tương đương p.getNgaynhap().getMonthValue())
                    int month = Integer.parseInt(parts[1]); // Lấy "10" -> 10
                    
                    // 2. Áp dụng chính xác logic của bạn
                    int quy = (month - 1) / 3; // (10 - 1) / 3 = 9 / 3 = 3

                    // 3. Tăng biến đếm (cần kiểm tra để tránh tháng > 12)
                    if (quy >= 0 && quy < 4) {
                        dem[quy]++; // Tăng dem[3] (Quý 4)
                    } else {
                        loi++; // Lỗi nếu tháng là 0 hoặc > 12
                    }
                } else {
                    loi++; // Lỗi định dạng (ví dụ: "12-05-2025")
                }
            } catch (Exception e) {
                // Lỗi nếu ngày mua hàng rỗng, null, hoặc "MM" không phải là số
                loi++; 
            }
        }

        // In kết quả thống kê
        System.out.println("----- Thong ke khach hang theo quy mua hang -----");
        System.out.println("Quy 1 (Thang 1-3): " + dem[0] + " khach hang");
        System.out.println("Quy 2 (Thang 4-6): " + dem[1] + " khach hang");
        System.out.println("Quy 3 (Thang 7-9): " + dem[2] + " khach hang");
        System.out.println("Quy 4 (Thang 10-12): " + dem[3] + " khach hang");

        if (loi > 0) {
            System.out.println("(!) Khong the thong ke " + loi + " khach hang do loi dinh dang ngay mua hang.");
        }
    }
}
