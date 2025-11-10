package Hoadon;
import java.util.Scanner;

public class QLHD extends QLBH {
    @Override public void menuChinh() {
        Scanner sc = new Scanner(System.in);
        int choice = 0;

        do {
            System.out.println("\n===[Giao diện quản lý danh sách hóa đơn]===\n");
            System.out.println("1) Xem danh sách");
            System.out.println("2) Thêm");
            System.out.println("3) Xóa");
            System.out.println("4) Sửa");
            System.out.println("5) Tìm kiếm");
            System.out.println("6) Thống kê theo năm");
            System.out.println("0) Thoát");
            System.out.print("Lựa chọn của bạn: ");

            try {
                choice = Integer.parseInt(sc.nextLine().trim());
            } catch (NumberFormatException e) {
                choice = -1;
            }

            switch (choice) {
                case 1:
                    ds_HD.xuatds();
                    break;
                case 2:
                    //ds_Sach là danh sách dùng để check mã sách
                    ds_HD.themvaodanhsach(sc, ds_KhachHang, ds_NhanVien, ds_Sach);
                    break;
                case 3:
                    ds_HD.xoahd(sc);
                    break;
                case 4:
                    ds_HD.suahd(sc, ds_KhachHang, ds_NhanVien, ds_Sach);
                    break;
                case 5:
                    ds_HD.tim(sc);
                    break;
                case 6:
                    ds_HD.thongkeHDtheonam(sc);
                    break;
                case 0:
                    System.out.println("Đã thoát menu hóa đơn.");
                    break;
                default:
                    System.out.println("Lựa chọn không hợp lệ!");
            }
        } while (choice != 0);
    }
}