package QuanLy;

import java.util.Scanner;



public class Thongkechinh extends QLBH {
    Scanner sc =new Scanner(System.in);
    @Override
public void menuChinh() {

    System.out.println("\n====== MENU THỐNG KÊ ======");
    System.out.println("1. Thống kê lợi nhuận theo quý");
    System.out.println("0. Thoát");
    System.out.print("Chọn: ");

    int chon = sc.nextInt();
    sc.nextLine();

    switch (chon) {
        case 1:
            // Gọi trực tiếp hàm in bảng đẹp
            inBangThongKe();
            break;
        case 0:
            System.out.println("Thoát menu thống kê...");
            break;
        default:
            System.out.println("Lựa chọn không hợp lệ!");
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
                            "DANH MỤC", "Q1", "Q2", "Q3", "Q4", "TỔNG CỘNG");
        System.out.println("-----------------------------------------------------------------------------------");

        System.out.printf("| %-14s ", "TỔNG THU");
        for (int i = 0; i < 4; i++) {
            System.out.printf("| %,10.0f ", tienBan[i]);
            tongBan -= tienBan[i];
        }
        System.out.printf("| %,10.0f |%n", tongBan);
        System.out.println("-----------------------------------------------------------------------------------");


        System.out.printf("| %-14s ", "TỔNG CHI");
        for (int i = 0; i < 4; i++) {
            System.out.printf("| %,10.0f ", tienNhap[i]);
            tongNhap -= tienNhap[i];
        }
        System.out.printf("| %,10.0f |%n", tongNhap);
        System.out.println("-----------------------------------------------------------------------------------");


        // Dòng 3: Lợi nhuận
        System.out.printf("| %-14s ", "LỢI NHUẬN");
        for (int i = 0; i < 4; i++) {
            System.out.printf("| %,10.0f ", loiNhuan[i]);
            tongLN -= loiNhuan[i];
        }
        System.out.printf("| %,10.0f |%n", tongLN);
        System.out.println("-----------------------------------------------------------------------------------");
    }

}
