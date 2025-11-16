package QuanLy;

import java.util.Scanner;

public class QLTG extends QLBH {
    Scanner sc = new Scanner(System.in);

    @Override public void menuChinh(){
        System.out.println("\n===[Giao dien quan li danh sach tac gia]===\n"); 

        int choice = 0;
        boolean running = true;
        
        while (running){
            // 2. Sửa lại toàn bộ menu text
            System.out.println("1) Xem danh sach (In ra Console)");
            System.out.println("2) Them tac gia (Nhập tay)");
            System.out.println("3) Xoa tac gia");
            System.out.println("4) Sua tac gia");
            System.out.println("5) Tim kiem theo Ma Tac Gia");
            System.out.println("6) Tim kiem theo Ten");
            System.out.println("7) Tim kiem theo Ho");
            System.out.println("8) Thong ke theo nhom tuoi");
            System.out.println("9) Thong ke theo họ");
            System.out.println("10) Thong ke theo ten");
            System.out.println("11) Xuat danh sach ra file (OUTPUT)");
            System.out.println("12) Luu và thoat");

            System.out.print("\nHay nhap so cua thao tac ban muon thuc hien (1-12): ");
            
            while (true){
                try{
                    choice = Integer.parseInt(sc.nextLine().trim());
                    if (choice < 1 || choice > 12) // SỬA
                        System.out.print("Vui long nhap so tu khoang 1-12: "); // SỬA
                    else
                        break;
                }
                catch (NumberFormatException e){
                    System.out.print("Hay nhap so hop le: ");
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
                    System.out.println("Đa luu va thoat chuong trinh.");
                    break;
            }
        }
    }
}
