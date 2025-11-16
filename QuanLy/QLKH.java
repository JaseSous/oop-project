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
            System.out.println("1) Xem danh sach (In ra Console)");
            System.out.println("2) Them khach hang (Nhap tay)");
            System.out.println("3) Xoa khach hang");
            System.out.println("4) Sua khach hang");
            System.out.println("5) Tim kiem theo Ma KH");
            System.out.println("6) Tim kiem theo Ho");
            System.out.println("7) Tim kiem theo Ten");
            System.out.println("8) Tim kiem theo So đien thoai");
            System.out.println("9) Thong ke theo nhom tuoi");
            System.out.println("10) Thong ke theo ho");
            System.out.println("11) Thong ke theo ten");
            System.out.println("12) Thong ke theo Quy mua hang"); // <-- SỬA
            System.out.println("13) Xuat danh sach ra file (OUTPUT)"); // <-- THÊM MỚI
            System.out.println("14) Luu và thoat"); // <-- SỬA

            // 3. Sửa lại dải số nhập
            System.out.print("\nHay nhap so của thao tac ban muon thuc hien (1-14): ");
            
            // 4. Sửa lại kiểm tra
            while (true){
                try{
                    choice = Integer.parseInt(sc.nextLine().trim());
                    if (choice < 1 || choice > 14) // SỬA
                        System.out.print("Vui lòng nhap so tu khoang 1-14: "); // SỬA
                    else
                        break;
                }
                catch (NumberFormatException e){
                    System.out.print("Hay nhap so hop le: ");
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
                    System.out.println("Đa them khach hang thanh cong.");
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
                    System.out.println("Đa luu và thoat chuong trinh.");
                    break;
            }
        }
    }
}