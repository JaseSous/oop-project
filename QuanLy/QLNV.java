package QuanLy;

import java.util.Scanner;

public class QLNV extends QLBH {
    @Override public void menuChinh(){
        // Menu chính
        System.out.println("\n===[Giao dien quan li danh sach nhan vien]===\n");

        Scanner sc = new Scanner(System.in);
        int choice = 0;
        boolean running = true;

        while (running){
            // In lại menu mới
            System.out.println("1) Xem danh sach (In ra Console)");
            System.out.println("2) Thêm nhan vien (Nhap tay)");
            System.out.println("3) Xoa nhan vien");
            System.out.println("4) Sua nhan vien");
            System.out.println("5) Tim kiem theo Ma NV");
            System.out.println("6) Tim kiem theo Ten");
            System.out.println("7) Tim kiếm theo Ho");
            System.out.println("8) Thong ke theo nhom tuoi");
            System.out.println("9) Thong ke theo ten");
            System.out.println("10) Xuat danh sach ra file (OUTPUT/DanhSachNhanVien.txt)");
            System.out.println("11) Luu và thoat");

            System.out.print("\nHay nhap so của thao tac ban muon thuc hien (1-11): ");
        
        // Kiểm tra hợp lệ
        while (true){
            try{
                choice = Integer.parseInt(sc.nextLine().trim());
                if (choice < 1 || choice > 11)
                    System.out.print("Vui long nhap so tu khoang 1-11: ");
                else
                    break;
            }
            catch (NumberFormatException e){
                System.out.print("Hay nhap so hop le: ");
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
                ds_Nhanvien.suanv();
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
                System.out.println("Đa luu va thoat chuong trinh.");
                break;
            }
        }
        sc.close();
    }
}
