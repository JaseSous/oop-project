package Khachhang;
import java.util.Scanner;

public class QLKH extends QLBH {
    @Override public void menuChinh(){
        // Menu chính
        System.out.println("\n===[Giao diện quản lý danh sách khách hàng]===\n");

        System.out.println("1) Xem danh sách");
        System.out.println("2) Thêm");
        System.out.println("3) Xóa");
        System.out.println("4) Sửa");
        System.out.println("5) Tìm kiếm khách hàng theo Mã khách hàng");
        System.out.println("6) Tìm kiếm khách hàng theo Họ");
        System.out.println("7) Tìm kiếm khách hàng theo Tên");
        System.out.println("8) Tìm kiếm khách hàng theo Số điện thoại");
        System.out.println("9) Thống kê khách hàng theo nhóm tuổi");
        System.out.println("10) Thống kê khách hàng theo họ");
        System.out.println("11) Thống kê khách hàng theo tên");
        System.out.println("12) Thống kê khách hàng theo năm sinh");
        System.out.println("7) Lưu và thoát");

        Scanner sc = new Scanner(System.in);
        
        int choice = 0;
        boolean running = true;
        
        while (running){
            System.out.print("\nHãy nhập số của thao tác bạn muốn thực hiện (1-7): ");
            // Kiểm tra hợp lệ
            while (true){
                try{
                    choice = Integer.parseInt(sc.nextLine().trim());
                    if (choice < 1 || choice > 13)
                        System.out.print("Vui lòng nhập số từ khoảng 1-13: ");
                    else
                        break;
                }
                catch (NumberFormatException e){
                    System.out.print("Hãy nhập số hợp lệ: ");
                }
            }
            //

            switch (choice){
                case 1: // Xem danh sách
                    ds_Khachhang.xem();
                    break;
                case 2: // Thêm
                    ds_Khachhang.them();
                    System.out.println("Đã thêm thành công sách vào danh sách sản phẩm");
                    break;
                case 3: // Xóa
                    ds_Khachhang.xoakh();
                    break;
                case 4: // Sửa
                    ds_Khachhang.suakh();
                    break;
                case 5: // Tìm kiếm theo Mã Khách Hàng
                    ds_Khachhang.timTheoma();
                    break;
                case 6:// Tìm kiếm theo Họ
                    ds_Khachhang.timTheoho();
                    break;
                case 7:// Tìm kiếm theo Tên
                    ds_Khachhang.timTheoten();
                    break;
                case 8:// Tìm kiếm theo Số điện thoại
                    ds_Khachhang.timTheosdt();
                    break;
                case 9: // Thống kê Khách Hàng theo tuổi 
                    ds_Khachhang.thongKeTheoNhomTuoi();
                    break;
                case 10: //Thống kê Khách Hàng theo họ
                    ds_Khachhang.thongKeTheoHo();
                    break;
                case 11://Thống kê Khách Hàng theo tên
                    ds_Khachhang.thongKeTheoTen();
                    break;
                case 12:// Thống kê Khách Hàng theo năm sinh
                    ds_Khachhang.thongKeTheoNamSinh();
                    break;
                case 13:
                    running = false;
                    break;
            }
        }
    }
}