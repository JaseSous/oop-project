package Tacgia;

import java.util.Scanner;

public class QLTG extends QLBH {
    @Override public void menuChinh(){
        
        ds_Tacgia.loadFile();

        System.out.println("\n===[Giao diện quản lý danh sách Tác Giả]===\n"); 

        Scanner sc = new Scanner(System.in);
        int choice = 0;
        boolean running = true;
        
        while (running){
            // 2. Sửa lại toàn bộ menu text
            System.out.println("1) Xem danh sách (In ra Console)");
            System.out.println("2) Thêm tác giả (Nhập tay)");
            System.out.println("3) Xóa tác giả");
            System.out.println("4) Sửa tác giả");
            System.out.println("5) Tìm kiếm theo Mã Tác Giả");
            System.out.println("6) Tìm kiếm theo Tên");
            System.out.println("7) Tìm kiếm theo Họ");
            System.out.println("8) Thống kê theo nhóm tuổi");
            System.out.println("9) Thống kê theo họ");
            System.out.println("10) Thống kê theo tên");
            System.out.println("11) Xuất danh sách ra file (OUTPUT)");
            System.out.println("12) Lưu và thoát");

            System.out.print("\nHãy nhập số của thao tác bạn muốn thực hiện (1-12): ");
            
            while (true){
                try{
                    choice = Integer.parseInt(sc.nextLine().trim());
                    if (choice < 1 || choice > 12) // SỬA
                        System.out.print("Vui lòng nhập số từ khoảng 1-12: "); // SỬA
                    else
                        break;
                }
                catch (NumberFormatException e){
                    System.out.print("Hãy nhập số hợp lệ: ");
                }
            }


            switch (choice){
                case 1: // Xem danh sách (Console)
                    ds_Tacgia.xuat(); // Gọi hàm xuat()
                    break;
                case 2: // Thêm
                    ds_Tacgia.them(); // Gọi hàm them() không tham số
                    break;
                case 3: // Xóa
                    ds_Tacgia.xoatg(); // Gọi hàm xoatg()
                    break;
                case 4: // Sửa
                    ds_Tacgia.suatg(); // Gọi hàm suatg()
                    break;
                case 5: // Tìm kiếm theo Mã TG
                    ds_Tacgia.timTheoma();
                    break;
                case 6: // Tìm kiếm theo Tên
                    ds_Tacgia.timTheoten();
                    break;
                case 7: // Tìm kiếm theo Họ
                    ds_Tacgia.timTheoho();
                    break;
                case 8: // Thống kê theo tuổi
                    ds_Tacgia.thongKeTheoNhomTuoi();
                    break;
                case 9: // Thống kê theo họ
                    ds_Tacgia.thongKeTheoHo();
                    break;
                case 10: // Thống kê theo tên
                    ds_Tacgia.thongKeTheoTen();
                    break;
                case 11: // Xuất ra file
                    ds_Tacgia.xem(); // Gọi hàm xem() (xuất file)
                    break;
                case 12: // Lưu và thoát
                    ds_Tacgia.saveFile(); // Thêm saveFile()
                    running = false;
                    System.out.println("Đã lưu và thoát chương trình.");
                    break;
            }
        }
    }
}
