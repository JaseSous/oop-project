package Nhanvien;

import java.util.Scanner;

public class QLNV extends QLBH {
    @Override public void menuChinh(){

        ds_Nhanvien.loadFile();
   
        // Menu chính
        System.out.println("\n===[Giao diện quản lý danh sách Nhân Viên]===\n");

        Scanner sc = new Scanner(System.in);
        int choice = 0;
        boolean running = true;

        while (running){
            // In lại menu mới
            System.out.println("1) Xem danh sách (In ra Console)");
            System.out.println("2) Thêm nhân viên (Nhập tay)");
            System.out.println("3) Xóa nhân viên");
            System.out.println("4) Sửa nhân viên");
            System.out.println("5) Tìm kiếm theo Mã NV");
            System.out.println("6) Tìm kiếm theo Tên");
            System.out.println("7) Tìm kiếm theo Họ");
            System.out.println("8) Thống kê theo nhóm tuổi");
            System.out.println("9) Thống kê theo tên");
            System.out.println("10) Xuất danh sách ra file (OUTPUT/DanhSachNhanVien.txt)");
            System.out.println("11) Lưu và thoát");

            System.out.print("\nHãy nhập số của thao tác bạn muốn thực hiện (1-11): ");
        
        // Kiểm tra hợp lệ
        while (true){
            try{
                choice = Integer.parseInt(sc.nextLine().trim());
                if (choice < 1 || choice > 11)
                    System.out.print("Vui lòng nhập số từ khoảng 1-11: ");
                else
                    break;
            }
            catch (NumberFormatException e){
                System.out.print("Hãy nhập số hợp lệ: ");
            }
        }

        switch (choice){
            case 1: // Xem danh sách (Console)
                ds_Nhanvien.xuat(); // Gọi hàm xuat() MỚI
                break;
            case 2: // Thêm
                ds_Nhanvien.them(); // Gọi hàm them() không tham số
                break;
            case 3: // Xóa
                ds_Nhanvien.xoanv();
                break;
            case 4: // Sửa
                ds_Nhanvien.suasv();
                break;
            case 5: // Tìm kiếm theo Mã NV
                ds_Nhanvien.timTheoma();
                break;
            case 6: // Tìm kiếm theo Tên
                ds_Nhanvien.timTheoten();
                break;
            case 7: // Tìm kiếm theo Họ
                ds_Nhanvien.timTheoho();
                break;
            case 8: // Thống kê theo tuổi
                ds_Nhanvien.Thongketheonhomtuoi();
                break;
            case 9: // Thống kê theo tên
                ds_Nhanvien.Thongketheoten();
                break;
            case 10: // Xuất ra file
                ds_Nhanvien.xem(); // Gọi hàm xem() (xuất file)
                break;
            case 11: // Lưu và thoát
                ds_Nhanvien.saveFile(); // Lưu lại file
                running = false;
                System.out.println("Đã lưu và thoát chương trình.");
                break;
            }
        }
        sc.close();
    }
}
