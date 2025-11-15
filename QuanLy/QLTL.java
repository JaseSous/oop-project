package QuanLy;
import java.util.Scanner;
import TheLoai.*;
public class QLTL extends QLBH {

    @Override
    public void menuChinh() {
        Scanner sc = new Scanner(System.in);
        int choice;
        do {
            System.out.println("\n===== MENU QUAN LY THE LOAI =====");
            System.out.println("1. Them the loai");
            System.out.println("2. Xuat danh sach the loai");
            System.out.println("3. Tim kiem the loai");
            System.out.println("4. Xoa the loai");
            System.out.println("5.Thong Ke so sach cua tung the loai");
            System.out.println("0. Luu file va thoat");
            System.out.println("==================================");
            System.out.print("Chon: ");
            choice = sc.nextInt();
            sc.nextLine();

            switch (choice) {
                case 1:
                    Theloai temp = new Theloai();
                    temp.themTL();
                    ds_Theloai.themTL(temp);
                    break;
                case 2:
                    ds_Theloai.xuatdsTL();
                    break;
                case 3:
                    ds_Theloai.menutimTL();
                    break;
                case 4:
                    System.out.print("Nhap ma TL can xoa: ");
                    String ma = sc.nextLine();
                    ds_Theloai.xoaTL(ma);
                    break;
                case 5: 
                    System.out.println("---------Thong ke---------");
                    ds_Theloai.Thongkesosachtheotheloai(ds_Sach);
                case 0:
                    ds_Theloai.SaveFile();
                    System.out.println("Da luu du lieu va thoat!");
                    break;
                default:
                    System.out.println("Lua chon khong hop le!");
            }
        } while (choice != 0);
        sc.close();
    }


}
