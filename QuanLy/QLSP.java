import java.util.Scanner;

public class QLSP extends QLBH {
    @Override public void menuChinh(){
        // Xóa màn hình
        ProcessBuilder pb = new ProcessBuilder("cmd", "/c", "cls");
        pb.inheritIO();

        // Menu chính
        System.out.println("\n===[Giao diện quản lý danh sách sản phẩm]===\n");

        System.out.println("1) Xem danh sách");
        System.out.println("2) Thêm");
        System.out.println("3) Xóa");
        System.out.println("4) Sửa");
        System.out.println("5) Tìm kiếm");
        System.out.println("6) Thống kê");

        System.out.print("\nHãy nhập số 1-6 tương ứng với thao tác bạn muốn thực hiện: ");
        Scanner sc = new Scanner(System.in);
        int choice;

        while (!sc.hasNextInt()){
            System.out.print("Vui lòng nhập số của thao tác hợp lệ (1-6): ");
        }

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
