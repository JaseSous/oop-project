package QuanLy;

import java.util.Scanner;

public class QLKH extends QLBH {
    Scanner sc = new Scanner(System.in);
    
    @Override public void menuChinh(){
        // Menu chính
        System.out.println("\n===[Giao diện quản lý danh sách khách hàng]===\n");

        int choice = 0;
        boolean running = true;
        
        while (running){
            System.out.println("1) Xem danh sách (In ra Console)");
            System.out.println("2) Thêm khách hàng (Nhập tay)");
            System.out.println("3) Xóa khách hàng");
            System.out.println("4) Sửa khách hàng");
            System.out.println("5) Tìm kiếm theo Mã KH");
            System.out.println("6) Tìm kiếm theo Họ");
            System.out.println("7) Tìm kiếm theo Tên");
            System.out.println("8) Tìm kiếm theo Số điện thoại");
            System.out.println("9) Thống kê theo nhóm tuổi");
            System.out.println("10) Thống kê theo họ");
            System.out.println("11) Thống kê theo tên");
            System.out.println("12) Thống kê theo Quý mua hàng"); // <-- SỬA
            System.out.println("13) Xuất danh sách ra file (OUTPUT)"); // <-- THÊM MỚI
            System.out.println("14) Lưu và thoát"); // <-- SỬA

            // 3. Sửa lại dải số nhập
            System.out.print("\nHãy nhập số của thao tác bạn muốn thực hiện (1-14): ");
            
            // 4. Sửa lại kiểm tra
            while (true){
                try{
                    choice = Integer.parseInt(sc.nextLine().trim());
                    if (choice < 1 || choice > 14) // SỬA
                        System.out.print("Vui lòng nhập số từ khoảng 1-14: "); // SỬA
                    else
                        break;
                }
                catch (NumberFormatException e){
                    System.out.print("Hãy nhập số hợp lệ: ");
                }
            }
            //

            // 5. Sửa lại toàn bộ switch case
            switch (choice){
                case 1: // Xem danh sách (Console)
                    ds_Khachhang.xuat();
                    break;
                case 2: // Thêm
                    ds_Khachhang.them();
                    // Sửa thông báo
                    System.out.println("Đã thêm khách hàng thành công.");
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
                case 12:// Thống kê theo Quý
                    ds_Khachhang.thongKeTheoQuy();
                    break;
                case 13: // Thêm chức năng xuất file
                    ds_Khachhang.xem();
                    break;
                case 14: // Lưu và thoát
                    ds_Khachhang.saveFile(); // Thêm saveFile()
                    running = false;
                    System.out.println("Đã lưu và thoát chương trình.");
                    break;
            }
        }
    }
}