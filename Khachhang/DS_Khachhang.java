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
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;

public class DS_Khachhang {
    private Khachhang[] kh;
    private int soluong;

    // Dùng để đọc/ghi file cho nhất quán
    private static final DateTimeFormatter df = DateTimeFormatter.ofPattern("dd/MM/yyyy");

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
            String FilePath = "DATA/DS_Khachhang.dat";

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
                String makh = reader.readLine().trim();
                String ho = reader.readLine().trim();
                String ten = reader.readLine().trim();
                String dchi = reader.readLine().trim();
                long sdt = Long.parseLong(reader.readLine().trim()); 
                String ngaysinhStr = reader.readLine().trim(); // 1. Đọc vào biến '...Str'
                String ngaymuahangStr = reader.readLine().trim();

                // Chuyển đổi String sang LocalDate
                LocalDate ngaysinh = null;
                LocalDate ngaymuahang = null;

                try {
                    // Nếu chuỗi không rỗng thì mới parse
                    if (ngaysinhStr != null && !ngaysinhStr.isEmpty()) {
                        ngaysinh = LocalDate.parse(ngaysinhStr, df);
                    }
                } catch (DateTimeParseException e) {
                    System.out.println("(!) Lỗi đọc ngày sinh của mã KH: " + makh);
                }

                try {
                    // Nếu chuỗi không rỗng thì mới parse
                   if (ngaymuahangStr != null && !ngaymuahangStr.isEmpty()) {
                       ngaymuahang = LocalDate.parse(ngaymuahangStr, df);
                   }
                } catch (DateTimeParseException e) {
                   System.out.println("(!) Lỗi đọc ngày mua hàng của mã KH: " + makh);
                }

                // them vào danh sách khách hàng
                this.them(makh, ho, ten, dchi, sdt, ngaysinh, ngaymuahang);
            }

            reader.close();
        } catch (IOException | NumberFormatException e) { // Bắt cả lỗi Parse số
            System.out.println("(!) Lỗi khi đọc file DS_Khachhang.dat: " + e.getMessage());
        }
    }
    public void xem() {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter("OUTPUT/DanhSachKhachHang.txt")); // Đổi tên file cho đúng ngữ cảnh
             Formatter formatter = new Formatter(writer)) {
                
            formatter.format("===[Danh sách Khách hàng]===\n"); // Đổi tiêu đề
            formatter.format("Số lượng: " + soluong + "\n\n");
    
            if (soluong > 0){
                formatter.format("-".repeat(119)); 
                formatter.format("\n| %-3s | %-7s | %-15s | %-10s | %-11d | %-15s | %-10s | %-10s |\n", // 8 cột
                                 "STT", "Mã KH", "Họ", "Tên", "SĐT", "Địa chỉ", "Ngày sinh","Ngày mua"); 
                formatter.format("-".repeat(119) + "\n"); 
    
                for (int i = 0; i < soluong; i++){
                    // Lấy LocalDate
                    LocalDate ns = kh[i].getNgaysinh();
                    LocalDate nmh = kh[i].getNgaymuahang();

                    // Format về String (hoặc "N/A" nếu null)
                    String ngaySinhStr = (ns != null) ? ns.format(df) : "N/A";
                    String ngayMuaHangStr = (nmh != null) ? nmh.format(df) : "N/A";

                    formatter.format("| %-3s | %-7s | %-15s | %-10s | %-11d | %-15s | %-10s | %-10s\n",
                                    i+1,
                                    kh[i].getMakh(),
                                    kh[i].getHo(),
                                    kh[i].getTen(),
                                    kh[i].getSdt(),
                                    kh[i].getDchi(),
                                    ngaySinhStr,      // Dùng chuỗi đã format
                                    ngayMuaHangStr);
                }
                formatter.format("-".repeat(119));
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
                writer.write(khach.getMakh());
    
                writer.newLine();
                writer.write(khach.getHo());
    
                writer.newLine();
                writer.write(khach.getTen());
    
                writer.newLine();
                writer.write(khach.getDchi());
    
                writer.newLine();
                writer.write(String.valueOf(khach.getSdt()));
    
                // Lấy LocalDate
                LocalDate ns = khach.getNgaysinh();
                LocalDate nmh = khach.getNgaymuahang();

                // Format về String (hoặc chuỗi rỗng nếu null)
                String ngaySinhStr = (ns != null) ? ns.format(df) : "";
                String ngayMuaHangStr = (nmh != null) ? nmh.format(df) : "";

                writer.newLine();
                writer.write(ngaySinhStr); // Ghi chuỗi đã format
    
                writer.newLine();
                writer.write(ngayMuaHangStr); // Ghi chuỗi đã format
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
    
    // Đổi tham số từ String sang LocalDate
    public void them(String makh, String ho, String ten, String dchi, long sdt, LocalDate ngaysinh, LocalDate ngaymuahang ) {
        kh = Arrays.copyOf(kh, kh.length + 1);
        // Truyền thẳng LocalDate vào constructor mới
        kh[soluong] = new Khachhang(makh, ho, ten, dchi, sdt, ngaysinh, ngaymuahang);
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
        String maxoa = sc.nextLine();
        
        int vitri = -1;
        for (int i = 0; i < soluong; i++) {
            if (kh[i].getMakh().equals(maxoa)) {
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
        String masua = sc.nextLine();
        int vitri = -1;
    
        // 1. Tìm vị trí
        for (int i = 0; i < soluong; i++) {
            if (kh[i].getMakh().equals(masua)) {
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
        String matim = sc.nextLine();
        
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
    public Khachhang timKhachHangTheoMa(String maKH) {
        for (int i = 0; i < soluong; i++) {
            if (kh[i].getMakh().equals(maKH)) {
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
        System.out.println("Duoi 20 tuoi: " + duoi20 + " Khach hang");
        System.out.println("Tu 20 den 29 tuoi: " + tu20den29 + " Khach hang");
        System.out.println("Tu 30 tuoi tro len: " + tren30 + " Khach hang");
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
        int[] dem = new int[4]; // quý 1->4 (index 0->3)
        int loi = 0; // Đếm các ngày mua hàng bị null

        for (int i = 0; i < soluong; i++) {
            // Lấy thẳng đối tượng LocalDate
            LocalDate ngayMua = kh[i].getNgaymuahang(); 
            
            // Nếu ngày mua bị null (do nhập sai, hoặc file cũ)
            if (ngayMua == null) {
                loi++;
                continue; // Bỏ qua khách hàng này
            }
            
            // Lấy tháng (1-12)
            int month = ngayMua.getMonthValue(); 
            
            // Logic tính quý của bạn (rất chính xác)
            int quy = (month - 1) / 3; // (1-1)/3=0, (3-1)/3=0, (4-1)/3=1

            dem[quy]++; // Tăng biến đếm
        }

        // In kết quả thống kê
        System.out.println("----- Thong ke khach hang theo quy mua hang -----");
        System.out.println("Quy 1 (Thang 1-3): " + dem[0] + " khach hang");
        System.out.println("Quy 2 (Thang 4-6): " + dem[1] + " khach hang");
        System.out.println("Quy 3 (Thang 7-9): " + dem[2] + " khach hang");
        System.out.println("Quy 4 (Thang 10-12): " + dem[3] + " khach hang");

        if (loi > 0) {
            System.out.println("(!) Khong the thong ke " + loi + " khach hang do thieu ngay mua hang.");
        }
    }

    public static void main(String args[]){
        DS_Khachhang dskh = new DS_Khachhang();

        dskh.loadFile();
        dskh.xem();
    }
}