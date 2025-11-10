import java.util.Scanner;

public class QLSP extends QLBH {
    @Override public void menuChinh(){
        // Menu chính
        System.out.println("\n===[Giao diện quản lý danh sách sản phẩm]===\n");

        System.out.println("1) Xem danh sách");
        System.out.println("2) Thêm");
        System.out.println("3) Xóa");
        System.out.println("4) Sửa");
        System.out.println("5) Tìm kiếm theo mã sách");
        System.out.println("6) Tìm kiếm theo mã thể loại");
        System.out.println("7) Thống kê");
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
                    ds_Sach.timKiemTheoMaSach();
                    break;
                case 6: // Tìm kiếm theo mã thể loại
                    ds_Sach.timKiemTheoMaTheLoai();
                    break;
                case 7: // Thống kê

                    break;
                case 8:
                    running = false;
                    break;
            }
        }
    }
}
