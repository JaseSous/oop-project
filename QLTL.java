import java.util.Scanner;

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
            System.out.println("0. Luu file va thoat");
            System.out.println("==================================");
            System.out.print("Chon: ");
            choice = sc.nextInt();
            sc.nextLine();

            switch (choice) {
                case 1:
                    dsTL.themTL();
                    break;
                case 2:
                    dsTL.xuatdsTL();
                    break;
                case 3:
                    dsTL.menutimTL();
                    break;
                case 4:
                    System.out.print("Nhap ma TL can xoa: ");
                    String ma = sc.nextLine();
                    dsTL.xoaTL(ma);
                    break;
                case 0:
                    dsTL.xem();
                    System.out.println("Da luu du lieu va thoat!");
                    break;
                default:
                    System.out.println("Lua chon khong hop le!");
            }
        } while (choice != 0);
    }


}
