package QuanLy;
import java.util.Scanner;

public class QLNXB extends QLBH {
    @Override public void menuChinh(){
        // Menu chính
        System.out.println("\n===[Giao dien quan li danh sach nha xuat ban]===\n");

        System.out.println("1) Xem danh sach");
        System.out.println("2) Them");
        System.out.println("3) Xoa");
        System.out.println("4) Sua");
        System.out.println("5) Tim kiem");
        System.out.println("6) In NXB và Sach của NXB do");
        System.out.println("7) Thong ke so luong sach theo NXB");
        System.out.println("0) Luu và thoat");

        Scanner sc = new Scanner(System.in);
        
        int choice = 0;
        boolean running = true;
        
        while (running){
            System.out.print("\nHay nhap so thao tac ma ban muon thuc hien (0-7): ");
            // Kiểm tra hợp lệ
            while (true){
                try{
                    choice = Integer.parseInt(sc.nextLine().trim());
                    if (choice < 0 || choice > 7)
                        System.out.print("Vui long nhap so tu khoang 1-7: ");
                    else
                        break;
                }
                catch (NumberFormatException e){
                    System.out.print("Hay nhap so hop le: ");
                }
            }

            switch (choice){
                case 1: // Xem danh sách
                ds_NXB.xuatNXB();
                break;
                case 2: // Thêm
                    ds_NXB.themNXB(sc);
                    break;
                case 3: // Xóa
                    ds_NXB.xoaNXB(sc);
                    break;
                case 4: // Sửa
                    ds_NXB.suaNXB(sc);
                    break;
                case 5: // Tìm kiếm theo mã
                    ds_NXB.timKiemtheoma(sc);
                    break;
                case 6: // In NXB và Sách của NXB đó
                    ds_NXB.inNXBVaSach(ds_Sach); 
                    break;
                case 7: // Thống kê số lượng sách theo NXB
                    ds_Sach.thongKeTheoNXB(ds_NXB);
                    break;
                case 0: // Lưu và thoát
                    ds_NXB.saveFile();
                    running = false;
                    break;
            }
        }
    }
}
