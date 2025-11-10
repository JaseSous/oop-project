import java.util.Arrays;
import java.util.Scanner;
<<<<<<< HEAD
=======
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
>>>>>>> d0b017cda086b8f196b493dac5f99b4ca50e4bb6

class Danhsachhoadon {
    private Hoadon[] ds;
    private int siso;

    public Danhsachhoadon() {
        this.ds = new Hoadon[0];
        this.siso = 0;
    }

<<<<<<< HEAD
    public void nhapds(Scanner sc, DanhSachKhachHang dskh, Danhsachnhanvien dsnv) {
=======
    public void nhapds(Scanner sc, DanhsachKhachhang dskh, DanhsachNhanvien dsnv,DS_Sach dss) {
>>>>>>> d0b017cda086b8f196b493dac5f99b4ca50e4bb6
        System.out.print("Nhap so luong hoa don: ");
        int n = sc.nextInt(); sc.nextLine();
        ds = new Hoadon[n];
        siso = n;
        for (int i = 0; i < n; i++) {
            System.out.println("Nhap Hoa don thu " + (i + 1) + ":");
            ds[i] = new Hoadon();
<<<<<<< HEAD
            ds[i].nhap(sc, dskh, dsnv); // Truyền danh sách xuống
=======
            ds[i].nhap(sc, dskh, dsnv,dss);
>>>>>>> d0b017cda086b8f196b493dac5f99b4ca50e4bb6
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

<<<<<<< HEAD
=======
    public void themvaodanhsach(Scanner sc,DanhsachKhachhang dskh, DanhsachNhanvien dsnv,DS_Sach dss) {
        Hoadon hd = new Hoadon();
        hd.nhap(sc,dskh, dsnv,dss);
        ds = Arrays.copyOf(ds, siso + 1);
        ds[siso] = hd;
        siso++;
        System.out.println("Them hoa don thanh cong!");
    }

>>>>>>> d0b017cda086b8f196b493dac5f99b4ca50e4bb6
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
<<<<<<< HEAD
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
=======

    public void suahd(Scanner sc, DanhsachKhachhang dskh, DanhsachNhanvien dsnv, DS_Sach dss) {
        System.out.print("Nhap ma hoa don can sua: ");
        String maSua = sc.nextLine();
        int vitri = -1;
        for (int i = 0; i < siso; i++) {
            if (ds[i].getMaHD().equals(maSua)) {
                vitri = i;
                break;
            }
        }

        if (vitri == -1) {
            System.out.println("Khong tim thay hoa don voi ma da cho.");
            return;
        }

        boolean dangfix = true;
        while (dangfix) {
            System.out.println("\n--- BAN MUON SUA THONG TIN GI CUA HOA DON " + maSua + "? ---");
            System.out.println("1. Ngay lap hoa don");
            System.out.println("2. Khach hang (Ma KH)");
            System.out.println("3. Nhan vien lap (Ma NV)");
            System.out.println("4. Sua danh sach chi tiet sach (Nhap lai toan bo)");
            System.out.println("0. Thoat che do sua");
            System.out.print("Lua chon cua ban: ");
            
            int choice;
            try {
                choice = Integer.parseInt(sc.nextLine().trim());
            } catch (NumberFormatException e) {
                choice = -1;
            }

            switch (choice) {
                case 1: // Sửa ngày lập
                    boolean ngayHopLe = false;
                    while (!ngayHopLe) {
                        try {
                            System.out.print("Nhap Ngay lap moi (dd/MM/yyyy): ");
                            String ngayStr = sc.nextLine();
                            ds[vitri].setNgayLapHD(LocalDate.parse(ngayStr, DateTimeFormatter.ofPattern("dd/MM/yyyy")));
                            System.out.println("Da cap nhat ngay lap.");
                            ngayHopLe = true;
                        } catch (Exception e) {
                            System.out.println("Dinh dang ngay khong hop le! Vui long nhap lai.");
                        }
                    }
                    break;
                case 2: // Sửa khách hàng
                    System.out.print("Nhap ma Khach Hang moi: ");
                    String maKH = sc.nextLine();
                    Khachhang khMoi = dskh.timKiem(maKH);
                    if (khMoi != null) {
                        ds[vitri].setKhachHang(khMoi);
                        System.out.println("Da cap nhat khach hang: " + khMoi.getTenkh());
                    } else {
                        System.out.println("Khong tim thay khach hang co ma: " + maKH);
                    }
                    break;
                case 3: // Sửa nhân viên
                    System.out.print("Nhap ma Nhan Vien moi: ");
                    String maNV = sc.nextLine();
                    Nhanvien nvMoi = dsnv.timKiem(maNV);
                    if (nvMoi != null) {
                        ds[vitri].setNhanVien(nvMoi);
                        System.out.println("Da cap nhat nhan vien: " + nvMoi.getTennv());
                    } else {
                        System.out.println("Khong tim thay nhan vien co ma: " + maNV);
                    }
                    break;
                case 4: // Sửa chi tiết (Nhập lại từ đầu)
                    System.out.println("Ban da chon nhap lai toan bo chi tiet hoa don nay.");
                    System.out.print("Ban co chac chan khong? (y/n): ");
                    String confirm = sc.nextLine();
                    if (confirm.equalsIgnoreCase("y")) {
                        ds[vitri] = new Hoadon(); // Reset hóa đơn này (cẩn thận: sẽ mất cả mã HD cũ nếu không set lại)
                        // HOẶC cách tốt hơn là chỉ reset phần chi tiết:
                        // ds[vitri].getDsChiTiet().reset(); // Nếu bạn viết thêm hàm reset() cho DanhsachChiTiet
                        
                        // Cách đơn giản nhất hiện tại để giữ mã HD cũ:
                        String maHDCu = ds[vitri].getMaHD();
                        System.out.println("--- Nhap lai thong tin ---");
                        ds[vitri].nhap(sc, dskh, dsnv, dss);
                        ds[vitri].setMaHD(maHDCu); // Khôi phục mã HD cũ nếu lỡ nhập mã mới khác
                    }
                    break;
                case 0:
                    dangfix = false;
                    System.out.println("Da thoat che do sua.");
                    break;
                default:
                    System.out.println("Lua chon khong hop le.");
            }
        }
    }

    public void thongkeHDtheonam(Scanner sc) {
        System.out.print("Nhap nam muon thong ke: ");
        int namCanTim = sc.nextInt();
        sc.nextLine();

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
>>>>>>> d0b017cda086b8f196b493dac5f99b4ca50e4bb6
}