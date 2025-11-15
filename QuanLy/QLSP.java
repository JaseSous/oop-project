package QuanLy;

import java.util.Scanner;
import Sach.Sach;

public class QLSP extends QLBH implements IQuanLy {
    @Override public void menuChinh(){
        // Menu chính
        System.out.println("\n===[Giao diện quản lý danh sách sản phẩm]===\n");

        System.out.println("1) Xem danh sách");
        System.out.println("2) Thêm");
        System.out.println("3) Xóa");
        System.out.println("4) Sửa");
        System.out.println("5) Tìm kiếm theo mã sách");
        System.out.println("6) Tìm kiếm theo mã thể loại");
        System.out.println("7) Thống kê theo số lượng loại sách");
        System.out.println("8) Lưu và thoát");

        Scanner sc = new Scanner(System.in);
        
        int choice = 0;
        boolean running = true;
        
        while (running){
            System.out.print("\nHãy nhập số của thao tác bạn muốn thực hiện (1-8): ");
            // Kiểm tra hợp lệ
            while (true){
                try{
                    choice = Integer.parseInt(sc.nextLine().trim());
                    if (choice < 1 || choice > 8)
                        System.out.print("Vui lòng nhập số từ khoảng 1-8: ");
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
                    ds_Sach.xem();
                    break;
                case 2: // Thêm
                    ds_Sach.them();
                    break;
                case 3: // Xóa
                    ds_Sach.xoa();
                    break;
                case 4: // Sửa
                    ds_Sach.sua();
                    break;
                case 5: // Tìm kiếm theo mã sách
                
                    System.out.print("Hãy nhập mã sách cần tim kiếm: "); String masachcantim = sc.nextLine().trim();
                    
                    Sach resultsearchmasach = ds_Sach.timKiemTheoMaSach(masachcantim);
                    if (masachcantim != null){
                        System.out.println("Đã tìm thấy sách cần tìm, thông tin sách:");
                        resultsearchmasach.xuat();
                    }
                    else
                        System.out.println("Không tìm thấy sách cần tìm.");
                    
                    break;
                case 6: // Tìm kiếm theo mã thể loại

                    System.out.print("Hãy nhập mã thể loại cần tim kiếm: "); String matheloaicantim = sc.nextLine().trim();
                    
                    Sach[] resultsearchmatheloai = ds_Sach.timKiemTheoMaTheLoai(matheloaicantim);
                    if (resultsearchmatheloai.length > 0){
                        System.out.println("Đã tìm thấy " + resultsearchmatheloai.length + " sách có mã thể loại " + matheloaicantim + ":");
                        for (int i = 0; i < resultsearchmatheloai.length; i++){
                            System.out.println("Sách thứ " + (i+1) + ":");
                            resultsearchmatheloai[i].xuat();
                        }
                    }
                    else
                        System.out.println("Không tìm thấy sách cần tìm.");
                        
                    break;
                case 7: // Thống kê theo số lượng loại sách

                    int[] resultthongkeloaisach = ds_Sach.thongKeLoaiSach();
                    System.out.println("Thống kê theo số lượng loại sách:");
                    System.out.println("\tSách giáo khoa: " + resultthongkeloaisach[0]);
                    System.out.println("\tSách nghiên cứu: " + resultthongkeloaisach[1]);

                    break;
                case 8: // Lưu và thoát
                    ds_Sach.saveFile();
                    running = false;
                    break;
            }
        }
    }
}
