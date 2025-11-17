package QuanLy;
import Nhaphang.*;
import java.time.LocalDate;
import java.util.Scanner;

public class QLPNH_CTPNH extends QLBH{
    Scanner sc = new Scanner(System.in);

    public void xuatthongtinhphieu(){
        // KHÔNG CẦN GỌI tinhtongtien1phieu() Ở ĐÂY NỮA
        // Vì TongTien đã luôn đúng sau khi Thêm/Xóa/Sửa.
        
        for(Phieunhaphang p : ds_Phieunhap.getds())
        {
            p.xuat();
            System.out.println("----------------Xuat thong tin phieu nhap nhang----------------");
            System.out.printf("%-11s | %-10s | %-10s | %-20s%n","MaSP","So luong","Don gia","Tong tien");
            for (CTPNH c:ds_CTPNH.getds())
            {
                if(c.getMaPN().equals(p.getMaPN()))
                {
                    c.xuat();
                }
            }
            // Hiển thị tổng tiền (đã được tính toán và lưu trong đối tượng p)
            System.out.printf("Tong tien phieu nhap hang: %,.0f VND%n", p.getTongTien());
            System.out.println("----------------------------------------------------------\n");
        }
    }

    // Hàm này dùng để tính lại tổng tiền cho TẤT CẢ phiếu (chạy rất nhanh)
    public void tinhtongtien1phieu(){
        for(Phieunhaphang p : ds_Phieunhap.getds())
        {
            float tongtiennhap1phieu = 0;
            for (CTPNH c : ds_CTPNH.getds())
            {
                if(c.getMaPN().equals(p.getMaPN()))
                {
                    tongtiennhap1phieu += c.getThanhtien();
                }
            }
            p.setTongTien(tongtiennhap1phieu);
        }
    }

    public void themphieunhap()
    {
        Phieunhaphang p = new Phieunhaphang();
        p.them();
        ds_Phieunhap.themvaodanhsach(p);    
        System.out.print("Nhap so luong chi tiet cua phieu: ");
        int sochitietthem = sc.nextInt();
        sc.nextLine(); 
        for(int i=0; i<sochitietthem; i++)
        {
            System.out.println("Nhap chi tiet thu " + (i + 1));
            CTPNH h = new CTPNH(); 
            h.them(); 
            h.setMaPN(p.getMaPN());
            ds_CTPNH.themvaodanhsach(h);
        }
        // THÊM: Tính lại tổng tiền ngay sau khi nhập xong phiếu mới
        tinhtongtien1phieu(); 
        System.out.println("Da them phieu nhap thanh cong.");
    }
    
    public void menuTimKiemPN() {
        // ... (Giữ nguyên code menu tìm kiếm của bạn) ...
        int chon;
        do {
            System.out.println("\n===== MENU TIM KIEM =====");
            // ...
            // (Copy lại đoạn code menuTimKiemPN từ file gốc của bạn vào đây)
            // ...
            System.out.println("1. Tim trong danh sach phieu nhap");
            System.out.println("2. Tim trong danh sach chi tiet phieu nhap");
            System.out.println("0. Thoat");
            System.out.print("Nhap lua chon: ");
            chon = sc.nextInt();
            sc.nextLine();

            switch (chon) {
                case 1:
                    ds_Phieunhap.menutimkiemDSPNH(); 
                    break;
                case 2:
                    ds_CTPNH.menutimkiemCTPNH(); 
                    break;
                case 0:
                    System.out.println("Thoat menu tim kiem tong...");
                    break;
                default:
                    System.out.println("Lua chon khong hop le!");
                    break;
            }
        } while (chon != 0);
    }

    public void menusuathongtin(){
        int chon;
        do {
            System.out.println("\n===== MENU SUA PHIEU NHAP=====");
            System.out.println("1. sua ma nha cung cap");
            System.out.println("2. sua ngay nhap");
            System.out.println("3. sua don gia cua san pham ");
            System.out.println("4. sua so luong cua san pham ");
            System.out.println("0. Thoat");
            System.out.print("Nhap lua chon: ");
            chon = sc.nextInt();
            sc.nextLine();

            switch (chon) {
                case 1:
                    System.out.println("mancc muon thay doi");
                    String manccsua=sc.nextLine();
                    System.out.println("ma phieu nhap hang can sua");
                    String mapntim1=sc.nextLine();
                    ds_Phieunhap.suamancc(mapntim1, manccsua);
                    break;

                case 2:
                    System.out.println("ngay muon thay doi (yyyy-mm-dd)"); 
                    LocalDate ngay = LocalDate.parse(sc.nextLine());
                    System.out.println("ma phieu nhap hang can sua");
                    String mapntim2=sc.nextLine();
                    ds_Phieunhap.suaNgayNhap(mapntim2, ngay);
                    break;

                case 3:
                    System.out.println("don gio muon thay doi"); 
                    double dongia = sc.nextDouble();
                    sc.nextLine();
                    System.out.println("ma phieu nhap hang can sua");
                    String mapntim3=sc.nextLine();
                    System.out.println("ma san pham can sua");
                    String masptim1=sc.nextLine();
                    ds_CTPNH.suaDonGia(mapntim3, masptim1, dongia);

                    tinhtongtien1phieu(); 
                    break;

                case 4:
                    System.out.println("so luong muon thay doi"); 
                    int soluong = sc.nextInt();
                    sc.nextLine();
                    System.out.println("ma phieu nhap hang can sua");
                    String mapntim4=sc.nextLine();
                    System.out.println("ma san pham can sua");
                    String masptim2=sc.nextLine();
                    ds_CTPNH.suaSoLuong(mapntim4, masptim2, soluong);
                    
                    tinhtongtien1phieu(); 
                    break; // THÊM BREAK QUAN TRỌNG

                case 0:
                    System.out.println("Thoat menu sua...");
                    break;

                default:
                    System.out.println("Lua chon khong hop le!");
                    break;
            }
        } while (chon != 0);
    } 

    @Override
    public void menuChinh() {
        // Scanner sc = new Scanner(System.in); // Đã khai báo ở class level
        int choice;
        // TÍNH TOÁN LẦN ĐẦU KHI MỞ MENU (để đảm bảo dữ liệu load lên là đúng)
        tinhtongtien1phieu(); 

        do {
            System.out.println("\n===== MENU QUAN LY PHIEU NHAP HANG =====");
            System.out.println("1. Them Phieu Nhap Hang moi (Bao gom Chi Tiet)");
            System.out.println("2. Xuat thong tin tat ca Phieu Nhap va Chi Tiet");
            System.out.println("3. Thong ke");
            System.out.println("4. Tim kiem Phieu Nhap");
            System.out.println("5. Xoa Phieu Nhap");
            System.out.println("6. Sua thong tin ");
            System.out.println("7. Xuat danh sach PNH (Don gian)");
            System.out.println("8. Xuat danh sach CTPNH ");
            System.out.println("0. Luu File va Thoat chuong trinh");
            System.out.println("=========================================");
            System.out.print("Lua chon: ");
            choice = sc.nextInt();
            sc.nextLine();
            
            switch (choice) {
                case 1:
                    themphieunhap(); // Đã tự gọi tinhtongtien1phieu()
                    break;
                case 2:
                    xuatthongtinhphieu();
                    break;
                case 3:
                    // ... (Giữ nguyên phần thống kê của bạn) ...
                    int chonTK;
                    do {
                        System.out.println("-------------Chon thong tin thong ke-------------");
                        System.out.println("1. Thong ke tong tien nhap hang theo Quy");
                        System.out.println("2. Thong ke so phieu nhap theo quy ");
                        System.out.println("0. Thoat chuc nang ");
                        chonTK = sc.nextInt();
                        sc.nextLine();
                        switch (chonTK) {
                            case 1:
                                double[] tongTien = ds_Phieunhap.ThongKeTienNhapHang(ds_CTPNH);
                                System.out.println("--- THONG KE TONG TIEN NHAP HANG THEO QUY ---");
                                for (int i = 0; i < tongTien.length; i++) {
                                    System.out.printf("Quy %d: %,.2f VND%n", (i + 1), tongTien[i]);
                                }
                                break;
                            case 2:
                                int[] sp = ds_Phieunhap.ThongkesophieunhapTheoQuy();
                                System.out.println("--- THONG KE SO PHIEU NHAP HANG THEO QUY ---");
                                for (int i = 0; i < sp.length; i++) {
                                    System.out.printf("Quy %d: %02d Phieu%n", (i + 1), sp[i]);
                                }
                                break;
                        }
                    } while (chonTK != 0);
                    break;
                case 4:
                    menuTimKiemPN();
                    break;
                case 5:
                    System.out.print("Nhap ma phieu nhap can xoa: ");
                    String maPNXoa = sc.nextLine();
                    ds_Phieunhap.xoa(maPNXoa);
                    ds_CTPNH.xoatheoMaPN(maPNXoa);
                    // KHÔNG CẦN GỌI LẠI Ở ĐÂY VÌ XÓA KHÔNG ẢNH HƯỞNG TỔNG TIỀN CỦA CÁC PHIẾU KHÁC
                    break;
                case 6:
                    menusuathongtin(); // Đã tự gọi tinhtongtien1phieu() khi sửa giá/số lượng
                    break;
                case 7:
                    // Gọi hàm xuatpn() (đã đổi tên trong DS_PhieuNhap mới)
                    ds_Phieunhap.xuat(); 
                    break;
                case 8:
                    // Gọi hàm xuatDanhSach() (đã đổi tên trong DS_CTPNH mới)
                    ds_CTPNH.xuat();
                    break;
                case 0:
                    // KHÔNG CẦN GỌI tinhtongtien1phieu() Ở ĐÂY NỮA
                    ds_CTPNH.saveFile();
                    ds_Phieunhap.saveFile();
                    System.out.println("Da luu du lieu va Thoat chuong trinh.");
                    break;
                default:
                    System.out.println("Lua chon khong hop le. Vui long chon lai.");
            }
        } while (choice != 0);
    }

}
