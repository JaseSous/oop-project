package Tacgia;

import java.time.LocalDate;
import java.util.Arrays;
import java.util.Scanner;

public class DanhSachTacGia {
    private Tacgia[] tg;
    private int soluong;

    //----Ham thiet lap----
    public DanhSachTacGia(){
        this.tg=new Tacgia[0];
        this.soluong=0;
    }
    
    //----Ham nhap----
    public void nhaptg(){
        @SuppressWarnings("resource")//Dòng bỏ qua cái sc vàng 
        Scanner sc = new Scanner(System.in);
        System.out.print("Nhap so luong Tac gia: ");
        int n = sc.nextInt(); sc.nextLine();
        tg = new Tacgia[n];
        soluong = n;
        for (int i = 0; i < n; i++){
            System.out.println("Nhap tac gia thu " + (i + 1) + ":");
            tg[i] = new Tacgia();
            tg[i].nhap();
        }
    }

    //----Ham xuat----
    public void xuattg(){
        if (soluong == 0) {
            System.out.println("Danh sach rong!");
            return;
        }
        System.out.println("----- DANH SACH TAC GIA ------");
        for (int i = 0; i < soluong; i++) {
            tg[i].xuat();
            System.out.println("--------------------");
        }
    }

    //----Ham them tac gia----
    public void themvaodanhsach() {
        Tacgia person = new Tacgia();
        person.nhap();
        tg = Arrays.copyOf(tg, soluong + 1);
        tg[soluong] = person;
        soluong++;
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
    public void suasv() {
        @SuppressWarnings("resource")//Dòng bỏ qua cái sc vàng 
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
        System.out.print("\nNhap ma tac gia moi: ");
        long matg = sc.nextLong();
        sc.nextLine();
        System.out.print("Nhap ho moi: ");
        String ho = sc.nextLine();
        System.out.print("Nhap ten moi: ");
        String ten = sc.nextLine();
        System.out.print("Nhap trinh do cua tac gia moi: ");
        String trinhdo = sc.nextLine();
        System.out.print("Nhap ngay sinh moi(dd/MM/yyyy): ");
        String ngaysinh = sc.nextLine();

        tg[vitri] = new Tacgia(matg,ho,ten,trinhdo,ngaysinh);

        System.out.println("Sua thong tin thanh cong!");
    }
    
    //--------CÁC HÀM TÌM-----------

    //----Ham tim tac gia theo matg----
    public void timTheoma() {
        @SuppressWarnings("resource")//Dòng bỏ qua cái sc vàng 
        Scanner sc = new Scanner(System.in);
        System.out.print("Nhap ma tac gia muon tim: ");
        int matim = sc.nextInt();
        for (int i = 0; i < soluong; i++) {
            if (tg[i].getMatg() == matim) {
                System.out.println("Tim thay tac gia:");
                tg[i].xuat();
                System.out.println("---------------------------");
            }
        }
        System.out.println("khong tim thay tac gia!");
    }

    //----Ham tim tac gia  theo Ten----
    public void timTheoten() {
        @SuppressWarnings("resource")//Dòng bỏ qua cái sc vàng 
        Scanner sc = new Scanner(System.in);
        System.out.print("Nhap ten (hoac ten mot phan) cua tac gia muon tim: ");
        String tentim = sc.nextLine().toLowerCase();

        for (int i = 0; i < soluong; i++) {
            if (tg[i].getTen().toLowerCase().contains(tentim)) {
                // dùng contains để tìm gần đúng
                System.out.println("Tim thay tac gia:");
                tg[i].xuat();
                System.out.println("---------------------------");
            }
        }
        System.out.println("khong tim thay tac gia nao co ten phu hop!");
    }

    //----Ham tim tac gia theo ho----
    public void timTheoho() {
        @SuppressWarnings("resource")//Dòng bỏ qua cái sc vàng 
        Scanner sc = new Scanner(System.in);
        System.out.print("Nhap ho (hoac ten mot phan) cua tac gia muon tim: ");
        String hotim = sc.nextLine().toLowerCase();

        for (int i = 0; i < soluong; i++) {
            if (tg[i].getHo().toLowerCase().contains(hotim)) {
                // dùng contains để tìm gần đúng
                System.out.println("Tim thay tac gia:");
                tg[i].xuat();
                System.out.println("---------------------------");
            }
        }
        System.out.println("khong tim thay tac gia nao co ho phu hop!");
    }

    //----Ham tim tac gia theo sdt----
    public void timTheosdt() {
        @SuppressWarnings("resource")//Dòng bỏ qua cái sc vàng 
        Scanner sc = new Scanner(System.in);
        System.out.print("Nhap so dien thoai tac gia muon tim: ");
        int sdttim = sc.nextInt();
        for (int i = 0; i < soluong; i++) {
            if (tg[i].getMatg() == sdttim) {
                System.out.println("Tim thay tac gia:");
                tg[i].xuat();
                System.out.println("---------------------------");
            }
        }
        System.out.println("khong tim thay tac gia!");
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
        System.out.println("----- Thong ke theo Ho -----");
        for (int i = 0; i < cacTen.length; i++) {
            System.out.println(cacTen[i] + ": " + demTen[i] + " tac gia");
        }
    }

    //----thống kê tac gia có sinh nhật trong tháng này----
    public void thongKeSinhNhatTrongThangHienTai() {
        int thangHienTai = LocalDate.now().getMonthValue(); // Lấy tháng hiện tại (1–12)
        int dem = 0;

        System.out.println("----- Danh sach tac gia co sinh nhat trong thang " + thangHienTai + " -----");

        for (int i = 0; i < soluong; i++) {
            // Lấy chuỗi ngày sinh, tách ra phần tháng
            String[] parts = tg[i].getNgaysinh().split("/");

            // Kiểm tra chuỗi có đúng định dạng dd/MM/yyyy tgông
            if (parts.length == 3) {
                try {
                    int thangSinh = Integer.parseInt(parts[1]);
                    if (thangSinh == thangHienTai) {
                        tg[i].xuat(); // in ra thông tin tac gia
                        dem++;
                    }
                } catch (NumberFormatException e) {
                    System.out.println("Loi dinh dang ngay sinh cua tac gia thu " + (i + 1));
                }
            } else {
                System.out.println("Ngay sinh cua tac gia thu " + (i + 1) + " khong dung dinh dang dd/MM/yyyy!");
            }
        }

        if (dem == 0) {
            System.out.println("khong co tac gia nao co sinh nhat trong thang nay.");
        } else {
            System.out.println("Tong cong co " + dem + " tac gia co sinh nhat trong thang nay.");
        }
    }
    
}
