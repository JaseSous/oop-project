package Nhaphang;
import java.io.*;
import java.util.Arrays;
import java.util.Scanner;
public class DanhsachCTPNH {
    private CTPNH[] dsct;
    private int soluongchitiet;

    public DanhsachCTPNH() {
        dsct = new CTPNH[0];
        soluongchitiet = 0;
    }

    public DanhsachCTPNH(CTPNH[] dsct,int soluongchitiet) {
        this.dsct = java.util.Arrays.copyOf(dsct, soluongchitiet);
        this.soluongchitiet = soluongchitiet;
    }
    
    public DanhsachCTPNH(DanhsachCTPNH other) {
        this.dsct = java.util.Arrays.copyOf(other.dsct, other.soluongchitiet);
        this.soluongchitiet = other.soluongchitiet;
    }

    public CTPNH[] getds()
    {
        return dsct;
    }
    public void setds(CTPNH[] dsct,int soluongchitiet)
    {
        this.dsct=Arrays.copyOf(dsct, soluongchitiet);
        this.soluongchitiet=soluongchitiet;
        return;
    }
    public void loadFile() {
        try (BufferedReader br = new BufferedReader(new FileReader("INPUT/DSCTPNH.txt"))) {
            soluongchitiet = Integer.parseInt(br.readLine());
            dsct = new CTPNH[soluongchitiet]; //  cấp phát mảng

            for (int i = 0; i < soluongchitiet; i++) {
                dsct[i] = new CTPNH();
                dsct[i].setMaPN(br.readLine().trim());
                dsct[i].setMaSP(br.readLine().trim());
                dsct[i].setsoluonghangnhap(Integer.parseInt(br.readLine().trim()));
                dsct[i].setDongia(Double.parseDouble(br.readLine().trim()));
            }
        } catch (Exception e) {
            System.out.println("Loi doc file: " );
        }
    }

    public void saveFile() {
        try  {
            BufferedWriter bw = new BufferedWriter(new FileWriter("OUTPUT/DSCTPN.txt"));
            BufferedWriter wb = new BufferedWriter(new FileWriter("INPUT/DSCTPN.txt"));
            bw.write(String.format("%-10s | %-10s | %-10s | %-10s | %-10s",
                    "MaPN", "MaSP", "SoLuong", "DonGia", "ThanhTien"));
            bw.newLine();
            bw.write("--------------------------------------------------------------");
            bw.newLine();

            for (int i = 0; i < soluongchitiet; i++) {
                dsct[i].ghifile(bw, wb);
            }

            System.out.println("Ghi file CT thanh cong !");

        } catch (IOException e) {
            System.out.println("Loi ghi file: ");
        }
    }
    public void xuat()
    {
        for(CTPNH p:dsct)
        {
            p.xuat();
             System.out.println("----------------------------------------");
        }
    }
//------------------timtheoMaPN---------------------
    public CTPNH[] timTheoMaPN(String MaPN) {
        CTPNH[] ketqua = new CTPNH[0];
        int count = 0;

        for (int i = 0; i < soluongchitiet; i++) {
            if (dsct[i].getMaPN().equals(MaPN)) {
                ketqua = java.util.Arrays.copyOf(ketqua, count + 1);
                ketqua[count] = dsct[i];
                count++;
            }
        }
        return ketqua;
    }
    //------------------------timtheomaSP------------------
    public CTPNH[] timtheomaSP (String MaSP){
        CTPNH[] ketqua = new CTPNH[0];
        int count = 0;
        for (int i = 0; i < soluongchitiet; i++) {
            if (dsct[i].getMaSP().equals(MaSP)) {
                ketqua = java.util.Arrays.copyOf(ketqua, count + 1);
                ketqua[count] = dsct[i];
                count++;
            }
        }
        return ketqua;
    }
    //-------------------menutimkiem--------------------------
public void menutimkiemCTPNH() {
    Scanner sc = new Scanner(System.in);
    int chon;

    do {
        System.out.println("\n===== MENU TIM KIEM =====");
        System.out.println("1. Tim theo ma phieu nhap");
        System.out.println("2. Tim theo ma san pham");
        System.out.println("0. Thoat");
        System.out.print("Nhap lua chon: ");
        chon = sc.nextInt();
        sc.nextLine(); // đọc bỏ dòng thừa

        switch (chon) {
            case 1:
                System.out.print("Nhap ma phieu nhap can tim: ");
                String mapntim = sc.nextLine();
                CTPNH[] kq1 = timTheoMaPN(mapntim);
                if (kq1 != null) {
                    System.out.printf("%-11s | %-10s | %-10s | %-10s%n", 
                        "MASP", "SoLuongNhap", "DonGia", "ThanhTien");
                    for (CTPNH ct : kq1) {
                        ct.xuat();
                    }
                } else {
                    System.out.println("Khong tim thay ma phieu " + mapntim);
                }
                break;

            case 2:
                System.out.print("Nhap ma san pham can tim: ");
                String masptim = sc.nextLine();
                CTPNH[] kq2 = timtheomaSP(masptim);
                if (kq2 != null) {
                    System.out.printf("%-10s | %-20s | %-10s | %-10s%n",
                        "MASP", "SoLuongNhap", "DonGia", "ThanhTien");
                    for (CTPNH ct : kq2) {
                        ct.xuat();
                    }
                } else {
                    System.out.println("Khong tim thay ma san pham " + masptim);
                }
                break;

            case 0:
                System.out.println("Thoat tim kiem...");
                break;

            default:
                System.out.println("Lua chon khong hop le!");
                break;
        }

    } while (chon != 0);
    
}

    //them
    public void themvaodanhsach(CTPNH ct) {
    dsct = java.util.Arrays.copyOf(dsct, soluongchitiet + 1);
    dsct[soluongchitiet++] = new CTPNH(ct);
    }
    //--------------xoa
    public void xoatheoMaPN(String MaPN) {
    boolean De=false;
    for (int i = 0; i < soluongchitiet; ) {
        if (dsct[i].getMaPN().equals(MaPN)) {
            // dịch mảng
            for (int j = i; j < soluongchitiet - 1; j++) {
                dsct[j] = dsct[j + 1];
            }
            soluongchitiet--;
            dsct = java.util.Arrays.copyOf(dsct, soluongchitiet);
            De=true;
        } else {
            i++;
        }
    }
    if (!De)
        System.out.println(">> Khong tim thay chi tiet co ma phieu: " + MaPN);
    else
        System.out.println(">> Da xoa " + " chi tiet cua ma phieu: " + MaPN);
    }
    //sua
        public void suaDonGia(String MaPN, String maSP, double dongiaMoi) {
        boolean found = false;
        for (int i = 0; i < soluongchitiet; i++) {
            if (dsct[i].getMaPN().equals(MaPN) && dsct[i].getMaSP().equals(maSP)) {
                dsct[i].setDongia(dongiaMoi);
                System.out.println(">> Da sua don gia cho [" + MaPN + " - " + maSP + "]");
                found = true;
            }
        }

        if (!found) {
            System.out.println(">> Khong tim thay chi tiet de sua!");
        }
    }
    
    public void suaSoLuong(String MaPN, String maSP, int slMoi) {
    boolean found = false;

    for (int i = 0; i < soluongchitiet; i++) {
        if (dsct[i].getMaPN().equals(MaPN) &&dsct[i].getMaSP().equals(maSP)) {

            dsct[i].setsoluonghangnhap(slMoi);
            System.out.println(">> Da sua so luong cho [" + MaPN + " - " + maSP + "]");
            found = true;
        }
    }

    if (!found) {
        System.out.println(">> Khong tim thay chi tiet de sua!");
    }
}
    
}
