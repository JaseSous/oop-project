import QuanLy.*;

import java.util.Scanner;

public class HeThong {
    Scanner sc = new Scanner(System.in);
    
    public void menuChinh(){
        QLBH qlbh = new QLBH();
        qlbh.loadFile();

        // Menu chính
        boolean running = true;

        while (running){
            System.out.println("===[Chương trình quản lý cửa hàng sách]===");
            System.out.println("\nHãy chọn menu quản lý");
            System.out.println("\t1) Quản lý sản phẩm");
            System.out.println("\t2) Quản lý hóa đơn");
            System.out.println("\t3) Quản lý phiếu nhập hàng");
            System.out.println("\t4) Quản lý khách hàng");
            System.out.println("\t5) Quản lý nhân viên");
            System.out.println("\t6) Quản lý nhà xuất bản");
            System.out.println("\t7) Quản lý nhà cung cấp");
            System.out.println("\t8) Quản lý thể loại");
            System.out.println("\t9) Quản lý tác giả");
            System.out.println("\t10) Thống kê chính");
            System.out.println("\t0) Thoát");
            
            System.out.print("Hãy nhập số của menu bạn muốn chọn (1-10): ");

            int choice = 0;

            // Kiểm tra hợp lệ
            while (true){ 
                try{
                    choice = Integer.parseInt(sc.nextLine().trim());
                    if (choice < 0 || choice > 10)
                        System.out.print("Vui lòng nhập số từ khoảng 0-10: ");
                    else
                        break; 
                }
                catch (NumberFormatException e){
                    System.out.print("Hãy nhập số hợp lệ: ");
                }
            }
            //
            
            switch (choice){
                case 1: // Quản lý sản phẩm
                    QLBH qlsp = new QLSP();
                    qlsp.menuChinh();
                    break;
                case 2: // Quản lý hóa đơn
                    QLBH qlhd = new QLHD();
                    qlhd.menuChinh();
                    break;
                case 3: // Quản lý phiếu nhập hàng
                    QLBH qlpnh_ctpnh = new QLPNH_CTPNH();
                    qlpnh_ctpnh.menuChinh();
                    break;
                case 4: // Quản lý khách hàng
                    QLBH qlkh = new QLKH();
                    qlkh.menuChinh();
                    break;
                case 5: // Quản lý nhân viên
                    QLBH qlnv = new QLNV();
                    qlnv.menuChinh();
                    break;
                case 6: // Quản lý nhà xuất bản
                    QLBH qlnxb = new QLNXB();
                    qlnxb.menuChinh();
                    break;
                case 7: // Quản lý nhà cung cấp
                    QLBH qlncc = new QLNCC();
                    qlncc.menuChinh();
                    break;
                case 8: // Quản lý thể loại
                    QLBH qltl = new QLTL();
                    qltl.menuChinh();
                    break;
                case 9: // Quản lý tác giả
                    QLBH qltg = new QLTG();
                    qltg.menuChinh();
                    break;
                case 10://Thông kê Chính
                    QLBH tk=new Thongkechinh();
                    tk.menuChinh();
                    break;
                case 0: // Thoát
                    running = false;
                    break;
            }
        }
    }

    public static void main(String args[]){
        HeThong hethong = new HeThong();

        hethong.menuChinh();
    }
}
