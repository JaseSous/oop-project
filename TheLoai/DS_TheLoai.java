package TheLoai;
import java.io.*;
import java.util.*;
import Sach.DS_Sach;
import Sach.Sach;

public class DS_TheLoai {
    Scanner sc = new Scanner(System.in);

    private int soluongTL;
    private Theloai[] dsTL;

    public DS_TheLoai() {
        soluongTL = 0;
        dsTL = new Theloai[0];
    }

    // Doc file danh sach
    public void loadFile() {
        try (BufferedReader br = new BufferedReader(new FileReader("DATA/DS_TL.dat"))) {
            soluongTL = Integer.parseInt(br.readLine().trim());
            dsTL = new Theloai[soluongTL];
            for (int i = 0; i < soluongTL; i++) {
                dsTL[i] = new Theloai();
                dsTL[i].setMaTL(br.readLine().trim());
                dsTL[i].setTenTL(br.readLine().trim());
            }
            System.out.println("Da doc du lieu the loai thanh cong!");
        } catch (Exception e) {
            System.out.println("Loi doc file DSTL.txt");
        }
    }

    // Ghi file danh sach
    public void SaveFile() {
        try {
            BufferedWriter bw = new BufferedWriter(new FileWriter("OUTPUT/DS_TL.txt"));
            BufferedWriter wb = new BufferedWriter(new FileWriter("DATA/DS_TL.dat"));
            bw.write ("\tDanh sach the loai\n");
            bw.write("-----------------------------\n");
            bw.write(String.format("%-10s | %-20s%n", "Ma TL", "Ten The Loai"));
            bw.write("-----------------------------\n");

            wb.write(String.valueOf(soluongTL));
            wb.newLine();

            for (Theloai tl : dsTL) {
                tl.ghifile(bw, wb);
            }

            bw.close();
            wb.close();
            System.out.println("Ghi file thanh cong!");
        } catch (Exception e) {
            System.out.println("Loi ghi file!");
        }
    }

    // Xuat danh sach
    public void xuatdsTL() {
        System.out.printf("%-10s | %-20s%n", "Ma TL", "Ten the loai");
        for (Theloai tl : dsTL) {
            tl.xuat();
        }
    }

    // Them the loai
    public void themTL(Theloai temp) {
        dsTL = Arrays.copyOf(dsTL, soluongTL + 1);
        dsTL[soluongTL++] = temp;
        System.out.println("Da them the loai moi!");
    }

    // Xoa the loai
    public void xoaTL(String maTLmuonxoa) {
        int vitri = -1;
        for (int i = 0; i < soluongTL; i++) {
            if (dsTL[i].getMaTL().equals(maTLmuonxoa)) {
                vitri = i;
                break;
            }
        }

        if (vitri == -1) {
            System.out.println("Khong tim thay ma TL: " + maTLmuonxoa);
            return;
        }

        for (int i = vitri; i < soluongTL - 1; i++) {
            dsTL[i] = dsTL[i + 1];
        }

        soluongTL--;
        dsTL = Arrays.copyOf(dsTL, soluongTL);

        System.out.println("Da xoa the loai ma: " + maTLmuonxoa);
    }

    // Tim theo ma
    public Theloai timtheomaTL(String maTL) {
        for (Theloai tl : dsTL) {
            if (tl.getMaTL().equalsIgnoreCase(maTL)) {
                return tl;
            }
        }
        return null;
    }

    // Tim theo ten
    public Theloai[] timtheotenTL(String ten) {
        Theloai[] kq = new Theloai[0];
        int count = 0;
        for (Theloai tl : dsTL) {
            if (tl.getTenTL().toLowerCase().contains(ten.toLowerCase())) {
                kq = Arrays.copyOf(kq, count + 1);
                kq[count++] = tl;
            }
        }
        return kq;
    }

    // Menu tim kiem
    public void menutimTL() {
        int chon;
        do {
            System.out.println("\n===== MENU TIM KIEM THE LOAI =====");
            System.out.println("1. Tim theo ma");
            System.out.println("2. Tim theo ten");
            System.out.println("0. Thoat");
            System.out.print("Chon: ");
            chon = sc.nextInt();
            sc.nextLine();

            switch (chon) {
                case 1:
                    System.out.print("Nhap ma TL can tim: ");
                    String ma = sc.nextLine();
                    Theloai tl = timtheomaTL(ma);
                    if (tl != null) {
                        System.out.printf("%-10s %-20s%n", "Ma TL", "Ten TL");
                        tl.xuat();
                    } else {
                        System.out.println("Khong tim thay ma TL: " + ma);
                    }
                    break;
                case 2:
                    System.out.print("Nhap ten TL can tim: ");
                    String ten = sc.nextLine();
                    Theloai[] ds = timtheotenTL(ten);
                    if (ds.length == 0)
                        System.out.println("Khong tim thay the loai co ten chua: " + ten);
                    else {
                        System.out.printf("%-10s %-20s%n", "Ma TL", "Ten TL");
                        for (Theloai t : ds)
                            t.xuat();
                    }
                    break;
                case 0:
                    break;
                default:
                    System.out.println("Lua chon khong hop le!");
            }
        } while (chon != 0);
    }
    //------------------------thong ke ------------
public void Thongkesosachtheotheloai(DS_Sach a) {
    System.out.println("\n--- THỐNG KÊ SỐ LƯỢNG SÁCH THEO THỂ LOẠI ---");
    for (Theloai tl : dsTL) {
        int sosach = 0;
        for (Sach s : a.getDsSach()) {
            if (s.getMatheloai().equals(tl.getMaTL())) {
                sosach++;
            }
        }
        System.out.println("So sach thuoc the loai " + tl.getTenTL() + ": " + sosach);
    }
    System.out.println("----------------------------------------------");
}
}
