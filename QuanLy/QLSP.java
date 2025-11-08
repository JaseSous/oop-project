import java.util.Scanner;

public class QLSP extends QLBH {
    @Override public void menuChinh(){
        // Menu chính
        System.out.println("\n===[Giao diện quản lý danh sách sản phẩm]===\n");

        System.out.println("1) Xem danh sách");
        System.out.println("2) Thêm");
        System.out.println("3) Xóa");
        System.out.println("4) Sửa");
        System.out.println("5) Tìm kiếm");
        System.out.println("6) Thống kê");

        System.out.print("\nHãy nhập số của thao tác bạn muốn thực hiện (1-6): ");
        Scanner sc = new Scanner(System.in);
        
        int choice = 0;

        // Kiểm tra hợp lệ
        while (true){
            try{
                choice = Integer.parseInt(sc.nextLine().trim());
                if (choice < 1 || choice > 6)
                    System.out.print("Vui lòng nhập số từ khoảng 1-6: ");
                else
                    break;
            }
            catch (NumberFormatException e){
                System.out.print("Hãy nhập số hợp lệ: ");
            }
        }
        //

        choice = sc.nextInt();
        switch (choice){
            case 1: // Xem danh sách
                ds_Sach.xem();
                break;
            case 2: // Thêm

                break;
            case 3: // Xóa

                break;
            case 4: // Sửa

                break;
            case 5: // Tìm kiếm

                break;
            case 6: // Thống kê

                break;
        }
    }
}
