import java.util.Scanner;
import java.util.Arrays;

public class DanhSachNXB {
    private NXB[] dsNXB;
    private int soLuongNXB;

    public DanhSachNXB() {
        this.dsNXB = new NXB[0];
        this.soLuongNXB = 0;
    }

    public DanhSachNXB(NXB[] dsNXB, int soLuongNXB) {
        this.dsNXB = dsNXB;
        this.soLuongNXB = soLuongNXB;
    }

    public void nhapNXB(Scanner sc) {
        System.out.print("Nhap so luong NXB can them: ");
        int n = sc.nextInt();
        sc.nextLine();

        for (int i = 0; i < n; i++) {
            System.out.println("Nhap thong tin NXB thu " + (i + 1) + ":");
            NXB nxb = new NXB();
            nxb.nhap(sc);
            themNXB(sc);
        }
    }

    public void xuatNXB() {
        if (soLuongNXB == 0) {
            System.out.println("Danh sach NXB rong!");
            return;
        }
        System.out.println("----- DANH SACH NXB -----");
        for (int i = 0; i < soLuongNXB; i++) {
            dsNXB[i].xuat();
            System.out.println("--------------------");
        }
    }

    public void themNXB(Scanner sc) {
        NXB newDsNXB = new NXB();
        newDsNXB.nhap(sc);
        dsNXB = Arrays.copyOf(dsNXB, soLuongNXB + 1);
        dsNXB[soLuongNXB] = newDsNXB;
        soLuongNXB++;
    }

    public void timKiemtheoma(Scanner sc) {
        System.out.print("Nhap ma NXB can tim: ");
        String maNXB = sc.nextLine();
        for (int i = 0; i < soLuongNXB; i++) {
            if (dsNXB[i].getMaNXB().equals(maNXB)) {
                dsNXB[i].xuat();
                return;
            }
        }
        System.out.println("Khong tim thay NXB voi ma da cho.");
    }

    public void xoaNXB(Scanner sc) {
        System.out.print("Nhap ma NXB can xoa: ");
        String maNXB = sc.nextLine();
        int viTri = -1;
        for (int i = 0; i < soLuongNXB; i++) {
            if (dsNXB[i].getMaNXB().equals(maNXB)) {
                viTri = i;
                break;
            }
        }
        if (viTri == -1) {
            System.out.println("Khong tim thay NXB voi ma da cho.");
            return;
        }
        for (int i = viTri; i < soLuongNXB - 1; i++) {
            dsNXB[i] = dsNXB[i + 1];
        }
        dsNXB = Arrays.copyOf(dsNXB, soLuongNXB - 1);
        soLuongNXB--;
        System.out.println("Da xoa NXB voi ma: " + maNXB);
    }

    public void suaNXB(Scanner sc) {
        System.out.print("Nhap ma NXB can sua: ");
        String maSua = sc.nextLine();
        int vitri = -1;
        for (int i = 0; i < soLuongNXB; i++) {
            if (dsNXB[i].getMaNXB().equals(maSua)) {
                vitri = i;
                break;
            }
        }
        if (vitri == -1) {
            System.out.println("Khong tim thay NXB voi maa da cho.");
            return;
        }
        do {
            System.out.println("Ban muon sua thong tin gi?");
            System.out.println("1. Ten NXB");
            System.out.println("2. So dien thoai NXB");
            System.out.println("3. Ma NXB");
            System.out.println("4. Thoat");
            System.out.print("Lua chon cua ban: ");
            int choice = sc.nextInt();
            sc.nextLine(); // Consume newline

            switch (choice) {
                case 1:
                    System.out.print("Nhap ten NXB moi: ");
                    String tenMoi = sc.nextLine();
                    dsNXB[vitri].setTenNXB(tenMoi);
                    System.out.println("Da cap nhat ten NXB.");
                    break;
                case 2:
                    System.out.print("Nhap so dien thoai NXB moi: ");
                    int sdtMoi = sc.nextInt();
                    dsNXB[vitri].setSdt(sdtMoi);
                    System.out.println("Da cap nhat so dien thoai NXB.");
                    break;
                case 3:
                    System.out.print("Nhap ma NXB moi: ");
                    String maNXBMoi = sc.nextLine();
                    dsNXB[vitri].setMaNXB(maNXBMoi);
                    System.out.println("Da cap nhat maNXB.");
                    break;
                case 4:
                    return;
                default:
                    System.out.println("Lua chon khong hop le. Vui long thu lai.");
            }
        }
        while (true);
    }
}