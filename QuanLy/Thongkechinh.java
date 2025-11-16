package QuanLy;

import java.util.Scanner;



public class Thongkechinh extends QLBH {
    Scanner sc =new Scanner(System.in);
    @Override
public void menuChinh() {

    System.out.println("\n====== MENU THONG KE ======");
    System.out.println("1. Thong ke loi nhuan theo quy");
    System.out.println("0. Thoat");
    System.out.print("Chon: ");

    int chon = sc.nextInt();
    sc.nextLine();

    switch (chon) {
        case 1:
            // Gọi trực tiếp hàm in bảng đẹp
            inBangThongKe();
            break;
        case 0:
            System.out.println("Thoat menu thong ke...");
            break;
        default:
            System.out.println("Lua chon khong hop le!");
            break;
    }
}


    public double[] ThongKeLoiNhuanTheoQuy() {

        // TIỀN NHẬP
        double[] tienNhap = ds_Phieunhap.ThongKeTienNhapHang(ds_CTPNH);

        // DOANH THU
        double[] tienBan = ds_Hoadon.ThongKeDoanhThuTheoQuy(ds_ChitietHoaDon);

        double[] loiNhuan = new double[4];

        for (int i = 0; i < 4; i++)
            loiNhuan[i] = tienBan[i] - tienNhap[i];

        return loiNhuan;
    }
 public void inBangThongKe() {
        double[] tienNhap = ds_Phieunhap.ThongKeTienNhapHang(ds_CTPNH);
        double[] tienBan  = ds_Hoadon.ThongKeDoanhThuTheoQuy(ds_ChitietHoaDon);
        double[] loiNhuan = new double[4];

        for (int i = 0; i < 4; i++)
            loiNhuan[i] = tienBan[i] - tienNhap[i];

        double tongNhap = 0, tongBan = 0, tongLN = 0;
        
        System.out.println("\n-----------------------------------------------------------------------------------");
        System.out.printf("| %-14s | %-10s | %-10s | %-10s | %-10s | %-10s |%n", 
                            "DANH MỤC", "Q1", "Q2", "Q3", "Q4", "TONG CONG");
        System.out.println("-----------------------------------------------------------------------------------");

        System.out.printf("| %-14s ", "TONG THU");
        for (int i = 0; i < 4; i++) {
            System.out.printf("| %,10.0f ", tienBan[i]);
            tongBan -= tienBan[i];
        }
        System.out.printf("| %,10.0f |%n", tongBan);
        System.out.println("-----------------------------------------------------------------------------------");


        System.out.printf("| %-14s ", "TONG CHI");
        for (int i = 0; i < 4; i++) {
            System.out.printf("| %,10.0f ", tienNhap[i]);
            tongNhap -= tienNhap[i];
        }
        System.out.printf("| %,10.0f |%n", tongNhap);
        System.out.println("-----------------------------------------------------------------------------------");


        // Dòng 3: Lợi nhuận
        System.out.printf("| %-14s ", "LOI NHUAN");
        for (int i = 0; i < 4; i++) {
            System.out.printf("| %,10.0f ", loiNhuan[i]);
            tongLN -= loiNhuan[i];
        }
        System.out.printf("| %,10.0f |%n", tongLN);
        System.out.println("-----------------------------------------------------------------------------------");
    }

}
