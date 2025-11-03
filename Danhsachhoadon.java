import java.util.Arrays;
import java.util.Scanner;

class Danhsachhoadon {
    private Hoadon[] ds;
    private int siso;

    public Danhsachhoadon() {
        this.ds = new Hoadon[0];
        this.siso = 0;
    }

    public void nhapds(Scanner sc, DanhSachKhachHang dskh, Danhsachnhanvien dsnv) {
        System.out.print("Nhap so luong hoa don: ");
        int n = sc.nextInt(); sc.nextLine();
        ds = new Hoadon[n];
        siso = n;
        for (int i = 0; i < n; i++) {
            System.out.println("Nhap Hoa don thu " + (i + 1) + ":");
            ds[i] = new Hoadon();
            ds[i].nhap(sc, dskh, dsnv); // Truyền danh sách xuống
        }
    }
    public void themvaodanhsach(Scanner sc, DanhSachKhachHang dskh, Danhsachnhanvien dsnv) {
        Hoadon hd = new Hoadon();
        hd.nhap(sc, dskh, dsnv); // Truyền danh sách xuống
        ds = Arrays.copyOf(ds, siso + 1);
        ds[siso] = hd;
        siso++;
    }

    public void xuatds() {
        if (siso == 0) {
            System.out.println("Danh sach rong!");
            return;
        }
        System.out.println("----- DANH SACH HOA DON -----");
        for (int i = 0; i < siso; i++) {
            ds[i].xuat();
            System.out.println("--------------------");
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
        for (int i = 0; i < siso; i++) {
            if (ds[i].getMaHD().equals(matim)) {
                ds[i].xuat();
                return;
            }
        }
        System.out.println("Khong tim thay hoa don!");
    }
    // ----- Thêm vào file Danhsachhoadon.java -----

public void menu(Scanner sc, DanhSachKhachHang dskh, Danhsachnhanvien dsnv) {
    int chon;
    do {
        System.out.println("\n---- MENU QUAN LY HOA DON ----");
        System.out.println("1. Them hoa don moi");
        System.out.println("2. Xuat danh sach hoa don");
        System.out.println("3. Xoa hoa don (theo ma)");
        System.out.println("4. Tim hoa don (theo ma)");
        System.out.println("5. Nhap lai toan bo danh sach hoa don");
        System.out.println("0. Quay lai menu chinh");
        System.out.print("Lua chon cua ban: ");
        
        chon = sc.nextInt();
        sc.nextLine(); // Hấp thụ phím Enter

        switch (chon) {
            case 1:
                // Phải truyền cả 3 tham số
                themvaodanhsach(sc, dskh, dsnv);
                break;
            case 2:
                xuatds();
                break;
            case 3:
                xoahd(sc);
                break;
            case 4:
                tim(sc);
                break;
            case 5:
                // Phải truyền cả 3 tham số
                nhapds(sc, dskh, dsnv);
                break;
            case 0:
                System.out.println("Quay lai menu chinh...");
                break;
            default:
                System.out.println("Lua chon khong hop le!");
        }
    } while (chon != 0);
}
}