import java.util.Arrays;
import java.util.Scanner;

class Danhsachhoadon {
    private Hoadon[] ds;
    private int siso;

    public Danhsachhoadon() {
        this.ds = new Hoadon[0];
        this.siso = 0;
    }

    public void nhapds(Scanner sc, DanhsachKhachhang dskh, DanhsachNhanvien dsnv,DS_Sach dss) {
        System.out.print("Nhap so luong hoa don: ");
        int n = sc.nextInt(); sc.nextLine();
        ds = new Hoadon[n];
        siso = n;
        for (int i = 0; i < n; i++) {
            System.out.println("Nhap Hoa don thu " + (i + 1) + ":");
            ds[i] = new Hoadon();
            ds[i].nhap(sc, dskh, dsnv,dss);
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

    public void themvaodanhsach(Scanner sc,DanhsachKhachhang dskh, DanhsachNhanvien dsnv,DS_Sach dss) {
        Hoadon hd = new Hoadon();
        hd.nhap(sc,dskh, dsnv,dss);
        ds = Arrays.copyOf(ds, siso + 1);
        ds[siso] = hd;
        siso++;
        System.out.println("Them hoa don thanh cong!");
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

    public void suahd(Scanner sc, DanhsachKhachhang dskh, DanhsachNhanvien dsnv,DS_Sach dss) {
        System.out.print("Nhap ma hoa don muon sua: ");
        String masua = sc.nextLine();
        for (int i = 0; i < siso; i++) {
            if (ds[i].getMaHD().equals(masua)) {
                System.out.println("Nhap thong tin hoa don moi:");
                ds[i].nhap(sc, dskh, dsnv, dss);
                System.out.println("Sua thanh cong!");
                return;
            }
        }
        System.out.println("Khong tim thay hoa don!");
    }

    public void thongkeHDtheonam(Scanner sc) {
        System.out.print("Nhap nam muon thong ke: ");
        int namCanTim = sc.nextInt();
        sc.nextLine(); // Đọc bỏ dòng thừa sau khi nhập số

        double tongDoanhThuNam = 0;
        int soLuongHDNam = 0;

        System.out.println("\n--- CAC HOA DON TRONG NAM " + namCanTim + " ---");
        boolean coHoaDon = false;
        for (int i = 0; i < siso; i++) {
            if (ds[i].getNgayLapHD().getYear() == namCanTim) {
                ds[i].xuat();
                System.out.println("--------------------");
                tongDoanhThuNam += ds[i].getDsChiTiet().tinhTongTien();
                soLuongHDNam++;
                coHoaDon = true;
            }
        }

        if (!coHoaDon) {
            System.out.println("Khong co hoa don nao trong nam " + namCanTim);
        } else {
            System.out.println("--> Tong so hoa don: " + soLuongHDNam);
            System.out.printf("--> TONG DOANH THU NAM %d: %,.0f VND\n", namCanTim, tongDoanhThuNam);
        }
    }
}