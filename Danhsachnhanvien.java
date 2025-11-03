import java.util.Arrays;
import java.util.Scanner;

public class Danhsachnhanvien {
    //----Thuoc tinh----
    private NhanVien[] nv;
    private int soluong;

    //----Ham thiet lap----
    public Danhsachnhanvien(){
        this.nv= new NhanVien[0];
        this.soluong=0;
    }

    //----ham nhap----
    public void nhapnv(){
        @SuppressWarnings("resource")//Dòng bỏ qua cái sc vàng 
        Scanner sc = new Scanner(System.in);
        System.out.print("Nhap so luong Nhan vien: ");
        int n = sc.nextInt(); sc.nextLine();
        nv = new NhanVien[n];
        soluong = n;
        for (int i = 0; i < n; i++){
            System.out.println("Nhap Nhan vien thu " + (i + 1) + ":");
            nv[i] = new NhanVien();
            nv[i].nhap();
        }
    }

    //----ham xuat----
    public void xuatkh(){
        if (soluong == 0) {
            System.out.println("Danh sach rong!");
            return;
        }
        System.out.println("----- DANH SACH NHAN VIEN -----");
        for (int i = 0; i < soluong; i++) {
            nv[i].xuat();
            System.out.println("--------------------");
        }
    }

    //----ham them vao danh sach----
    public void themvaodanhsach() {
        NhanVien nhanvien = new NhanVien();
        nhanvien.nhap();
        nv = Arrays.copyOf(nv, soluong + 1);
        nv[soluong] = nhanvien;
        soluong++;
    }

    //----ham xoa nhan vien----
    public void xoanv(){
        @SuppressWarnings("resource")//Dòng bỏ qua cái sc vàng 
        Scanner sc = new Scanner(System.in);
        System.out.print("Nhap ma NV muon xoa: ");
        long maxoa = sc.nextLong();
        
        int vitri = -1;
        for (int i = 0; i < soluong; i++) {
            if (nv[i].getManv() == maxoa) {
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
        long masua = sc.nextLong();
        int vitri = -1;
        for (int i = 0; i < soluong; i++) {
            if (nv[i].getManv() == masua) {
                vitri = i;
                break;
            }
        }
        if (vitri == -1) {
            System.out.println("Khong tim thay nhan vien!");
            return;
        }
        System.out.print("\nNhap ma nhan vien moi: ");
        long makh = sc.nextLong();
        sc.nextLine();
        System.out.print("Nhap ho moi: ");
        String ho = sc.nextLine();
        System.out.print("Nhap ten moi: ");
        String ten = sc.nextLine();
        System.out.print("Nhap ngay sinh moi(dd/MM/yyyy): ");
        String ngaysinh = sc.nextLine();
        System.out.print("Nhap luong thang moi: ");
        long luongthang = sc.nextLong();

        nv[vitri] = new NhanVien(makh,ho,ten,ngaysinh,luongthang);

        System.out.println("Sua thong tin thanh cong!");
    }
    //----CÁC HÀM TÌM-----

    //----ham tim nhan vien theo manv----
    public void timTheoma() { // Bỏ tham số đầu vào
        @SuppressWarnings("resource")//Dòng bỏ qua cái sc vàng 
        Scanner sc = new Scanner(System.in);
        System.out.print("Nhap ma Nhan vien muon tim: ");
        long matim = sc.nextInt();
        
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
    public NhanVien timNhanVienTheoMa(long maNV) {
        for (int i = 0; i < soluong; i++) {
            if (nv[i].getManv() == maNV) {
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

        for (int i = 0; i < soluong; i++) {
            if (nv[i].getTen().toLowerCase().contains(tentim)) {
                // dùng contains để tìm gần đúng
                System.out.println("Tim thay nhan vien:");
                nv[i].xuat();
                System.out.println("---------------------------");
            }
        }
        System.out.println("Khong tim thay nhan vien nao co ten phu hop!");
    }

    //----Ham tim nhan vien theo ho----
    public void timTheoho() {
        @SuppressWarnings("resource")//Dòng bỏ qua cái sc vàng 
        Scanner sc = new Scanner(System.in);
        System.out.print("Nhap ho (hoac ten mot phan) cua nhan vien muon tim: ");
        String hotim = sc.nextLine().toLowerCase();

        for (int i = 0; i < soluong; i++) {
            if (nv[i].getHo().toLowerCase().contains(hotim)) {
                // dùng contains để tìm gần đúng
                System.out.println("Tim thay nhan vien:");
                nv[i].xuat();
                System.out.println("---------------------------");
            }
        }
        System.out.println("Khong tim thay nhan vien nao co ho phu hop!");
    }

    //---------CÁC HÀM THỐNG KÊ----------

    //----hàm thống kê nhan vien theo tuổi----
    public void Thongketheonhomtuoi() {
        int duoi20 = 0;
        int tu20den29 = 0;
        int tren30 = 0;
    
        for (int i = 0; i < soluong; i++) {
            int tuoi = nv[i].age();  // Gọi hàm age() của từng sinh viên
    
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
        System.out.println("----- Thong ke theo Ho -----");
        for (int i = 0; i < cacTen.length; i++) {
            System.out.println(cacTen[i] + ": " + demTen[i] + " nhan vien");
        }
    }

    //----thống kê nhan vien co ngaysinh trong tháng này----
    public void Thongkesinhnhattrongthanghientai() {
        @SuppressWarnings("resource")
        Scanner sc = new Scanner(System.in);
        System.out.print("Nhap thang muon kiem tra (1–12): ");
        int thangNhap = sc.nextInt();
        int dem = 0;

        System.out.println("----- Danh sach nhan vien co ngaysinh trong thang " + thangNhap + " -----");

        for (int i = 0; i < soluong; i++) {
            // Lấy chuỗi ngày sinh, tách ra phần tháng
            String[] parts = nv[i].getNgaysinh().split("/");

            // Kiểm tra chuỗi có đúng định dạng dd/MM/yyyy không
            if (parts.length == 3) {
                try {
                    int thangSinh = Integer.parseInt(parts[1]);
                    if (thangSinh == thangNhap) {
                        nv[i].xuat(); // in ra thông tin khách hàng
                        dem++;
                    }
                } catch (NumberFormatException e) {
                    System.out.println("Loi dinh dang ngaysinh cua nhan vien thu " + (i + 1));
                }
            } else {
                System.out.println("Ngaysinh cua nhan vien thu " + (i + 1) + " khong dung dinh dang dd/MM/yyyy!");
            }
        }

        if (dem == 0) {
            System.out.println("Khong co nhan vien nao co ngaysinh trong thang nay.");
        } else {
            System.out.println("Tong cong co " + dem + " nhan vien co ngaysinh trong thang nay.");
        }
    }
    
    //----Hàm menu----
    public void menu() {
        nhapnv(); // nhập danh sách ban đầu (nếu bạn muốn)

        int chon;
        do {
            @SuppressWarnings("resource")//Dòng bỏ qua cái sc vàng 
            Scanner sc = new Scanner(System.in);
            System.out.println("\n---- MENU ----");
            System.out.println("1. Xuat danh sach");
            System.out.println("2. Them Nhan vien");
            System.out.println("3. Xoa Nhan vien");
            System.out.println("4. Sua Nhan vien");
            System.out.println("5. Tim theo nv theo Ma Nhan vien");
            System.out.println("6. Tim theo Ten");
            System.out.println("7. Tim theo Ho");
            System.out.println("8. Thong ke theo nhom tuoi cua Nhan vien");
            System.out.println("9. Thong ke theo Ten cua Nhan vien");
            System.out.println("10. Thong ke Nhan vien co sinh nhat trong thang hien tai");
            System.out.println("0. Thoat");
            System.out.print("Lua chon: ");
            chon = sc.nextInt();
            sc.nextLine();
            
        switch (chon) {
            case 1: xuatkh(); break;
            case 2: themvaodanhsach(); break;
            case 3: xoanv(); break;
            case 4: suasv(); break;
            case 5: timTheoma(); break;
            case 6: timTheoten(); break;
            case 7: timTheoho(); break;
            case 8: Thongketheonhomtuoi(); break;
            case 9: Thongketheoten(); break;
            case 10: Thongkesinhnhattrongthanghientai(); break;
            case 0: System.out.println("Thoat!"); break;
            default: System.out.println("Lua chon khong hop le!");
        }
    } while (chon != 0);
    }
}
