import java.util.Arrays;
import java.util.Scanner;

class Danhsachhoadon {
    private Hoadon[] ds;
    private int siso;

    public Danhsachhoadon() {
        this.ds = new Hoadon[0];
        this.siso = 0;
    }

    public void nhapds(Scanner sc) {
        System.out.print("Nhap so luong hoa don: ");
        int n = sc.nextInt(); sc.nextLine();
        ds = new Hoadon[n];
        siso = n;
        for (int i = 0; i < n; i++) {
            System.out.println("Nhap Hoa don thu " + (i + 1) + ":");
            ds[i] = new Hoadon();
            ds[i].nhap(sc);
        }
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

    public void themvaodanhsach(Scanner sc) {
        Hoadon hd = new Hoadon();
        hd.nhap(sc);
        ds = Arrays.copyOf(ds, siso + 1);
        ds[siso] = hd;
        siso++;
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
}