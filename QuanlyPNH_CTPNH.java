import java.time.LocalDate;
import java.util.Scanner;

public class QuanlyPNH_CTPNH extends QLBH{
    public void xuatthongtinhphieu(){
        for(Phieunhaphang p :dsPN.getds())
        {
            double  tongtiennhap1phieu=0.0;
            p.xuat();
            System.out.println("----------------Xuat thong tin phieu nhap nhang----------------");
            System.out.printf("%-11s | %-10s | %-10s | %-20s%n","MaSP","So luong","Don gia","Tong tien");
            for (CTPNH c:dsCT.getds())
            {
                if(c.getMaPN().equals(p.getMaPN()))
                {
                    c.xuat();
                    tongtiennhap1phieu+=c.getThanhtien();
                }
            }
            System.out.printf("Tong tien phieu nhap hang: %,.0f VND%n", tongtiennhap1phieu);
            System.out.println("----------------------------------------------------------\n");
        }
    }

    public double[] ThongKeTienNhapHang()
    {
        double[] Tongtientheoquy={0.0,0.0,0.0,0.0};
        for (Phieunhaphang p:dsPN.getds())
        {
            double tongtienphieu=0.0;
            int month=p.getNgaynhap().getMonthValue();
            int quy=(month-1)/3;
            for(CTPNH s:dsCT.getds())
            {
                if(s.getMaPN().equals(p.getMaPN()))
                {
                    tongtienphieu+=s.getThanhtien();
                }
            }
            Tongtientheoquy[quy]+=tongtienphieu;
        }
        return Tongtientheoquy;
    }
        
    public void themphieunhap()
    {
        Scanner sc =new Scanner(System.in);
        Phieunhaphang p=new Phieunhaphang();
        p.them();
        dsPN.themvaodanhsach(p);     
        System.out.println("nhap so luong chi tiet cua phieu");
        int sochitietthem =sc.nextInt();
        sc.nextLine(); 
        for(int i=0;i<sochitietthem;i++)
        {
            System.out.println("Nhap chi tiet thu " + (i + 1));
            CTPNH h=new CTPNH(); 
            h.them(); 
            h.setMaPN(p.getMaPN());
            dsCT.themvaodanhsach(h);
        }
    }
    
    public void menuTimKiemPN() {
    Scanner sc = new Scanner(System.in);
    int chon;

    do {
        System.out.println("\n===== MENU TIM KIEM =====");
        System.out.println("1. Tim trong danh sach phieu nhap");
        System.out.println("2. Tim trong danh sach chi tiet phieu nhap");
        System.out.println("0. Thoat");
        System.out.print("Nhap lua chon: ");
        chon = sc.nextInt();
        sc.nextLine();

        switch (chon) {
            case 1:
                dsPN.menutimkiemDSPNH(); // gọi menu tìm kiếm phiếu nhập
                break;

            case 2:
                dsCT.menutimkiemCTPNH(); // gọi menu tìm kiếm chi tiết phiếu nhập
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
            Scanner sc = new Scanner(System.in);
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
                dsPN.suamancc(mapntim1, manccsua);
                break;

            case 2:
                System.out.println("ngay muon thay doi"); 
                LocalDate ngay=LocalDate.parse(sc.nextLine());
                System.out.println("ma phieu nhap hang can sua");
                String mapntim2=sc.nextLine();
                dsPN.suaNgayNhap(mapntim2, ngay);
                break;

            case 3:
                System.out.println("don gio muon thay doi"); 
                double dongia=sc.nextDouble();
                System.out.println("ma phieu nhap hang can sua");
                String mapntim3=sc.nextLine();
                System.out.println("ma san pham  can sua");
                String masptim1=sc.nextLine();
                dsCT.suaDonGia(mapntim3,masptim1,dongia);
                break;

                case 4:
                System.out.println("so luong muon thay doi"); 
                int soluong=sc.nextInt();
                System.out.println("ma phieu nhap hang can sua");
                String mapntim4=sc.nextLine();
                System.out.println("ma san pham  can sua");
                String masptim2=sc.nextLine();
                dsCT.suaDonGia(mapntim4,masptim2,soluong);
                break;
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
        Scanner sc = new Scanner(System.in);
        int choice;
        do {
            System.out.println("\n===== MENU QUAN LY PHIEU NHAP HANG =====");
            System.out.println("1. Them Phieu Nhap Hang moi (Bao gom Chi Tiet)");
            System.out.println("2. Xuat thong tin tat ca Phieu Nhap va Chi Tiet");
            System.out.println("3. Thong ke");
            System.out.println("4. Tim kiem Phieu Nhap");
            System.out.println("5. Xoa Phieu Nhap");
            System.out.println("6. Sua thong tin ");
            System.out.println("0. Luu File va Thoat chuong trinh");
            System.out.println("=========================================");
                choice = sc.nextInt();
                sc.nextLine();
            switch (choice) {
                case 1:
                    themphieunhap();
                    break;
                case 2:
                    xuatthongtinhphieu();
                    break;
                case 3:
                    int chon;
                    do{
                        System.out.println("-------------Chon thong tin thong ke-------------");
                        System.out.println("1. Thong ke tong tien nhap hang theo Quy");
                        System.out.println("2. Thong ke so phieu nhap theo quy ");
                        System.out.println("0. Thoat chuc nang ");
                         chon=sc.nextInt();
                        sc.nextLine();
                    switch (chon) {
                        case 1:
                        double[] tongTien = ThongKeTienNhapHang();
                        System.out.println("--- THONG KE TONG TIEN NHAP HANG THEO QUY ---");
                        for (int i = 0; i < tongTien.length; i++) {
                            System.out.printf("Quy %d: %.2f VND%n", (i + 1), tongTien[i]);
                            }
                            break;
                        case 2:
                                int[] sp = dsPN.ThongkesophieunhapTheoQuy();
                            System.out.println("--- THONG KE SO PHIEU NHAP HANG THEO QUY ---");
                        for (int i = 0; i < sp.length; i++) {
                            System.out.printf("Quy %d: %02d Phieu%n", (i + 1), sp[i]);
                            }
                            break;
                        default:
                            break;
                    }}while (chon!=0);
            
                break;
                case 4:
                    menuTimKiemPN();
                    break;
                case 5:
                    System.out.print("Nhap ma phieu nhap can xoa: ");
                    String maPNXoa = sc.nextLine();
                    dsPN.xoa(maPNXoa);
                    dsCT.xoatheoMaPN(maPNXoa);
                    break;
                case 6:
                    menusuathongtin();
                    break;
                case 0:
                    xem();
                    System.out.println("Da luu du lieu va Thoat chuong trinh.");
                    break;
                default:
                    System.out.println("Lua chon khong hop le. Vui long chon lai.");
            }
        } while (choice != 0);
        sc.close();
    }
}
