package QuanLy;
import java.util.Scanner;
import Nhacungcap.Nhacungcap;
public class QLNCC extends QLBH {

@Override
    public void menuChinh()
    {
        Scanner sc = new Scanner(System.in);
        int choice;
        
        do {
            System.out.println("\n===== MENU QUAN LY NHA CUNG CAP =====");
            System.out.println("1. Them NCC ");
            System.out.println("2. Xuat danh sach");
            System.out.println("3. Thong ke NCC theo khu vuc(HCM/HN/DN)");
            System.out.println("4. Tim kiem NCC");
            System.out.println("5. Xoa NCC");
            System.out.println("6. Sua thong tin ");
            System.out.println("0. Luu File va Thoat chuong trinh");
            System.out.println("=========================================");
                choice = sc.nextInt();
                sc.nextLine();
            switch (choice) {
                case 1:
                    Nhacungcap temp = new Nhacungcap();
                    temp.them();
                    ds_NCC.themNCC(temp);
                    break;
                case 2:
                    ds_NCC.xuatNCC();
                    break;
                case 3:
                    ds_NCC.ThongkekhuvucNCC();
                    break;
                case 4:
                    ds_NCC.menutimNCC();
                    break;
                case 5:
                    System.out.print("Nhap ma NCC can xoa: ");
                    String maNCC = sc.nextLine();
                    ds_NCC.xoaNCC(maNCC);
                    break;
                case 6:
                    ds_NCC.menusua();
                    break;
                case 0:
                    ds_NCC.saveFile();
                    System.out.println("Da luu du lieu va Thoat chuong trinh.");
                    break;
                default:
                    System.out.println("Lua chon khong hop le. Vui long chon lai.");
            }
        } while (choice != 0);
        sc.close();
    }

 
}
