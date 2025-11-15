package Nhaphang;
import java.util.Scanner;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

import java.time.LocalDate;
import java.util.Arrays;

public class Danhsachphieunhap {
    private Phieunhaphang[] ds;
    private int soluongphieunhap;

    public Danhsachphieunhap() {
        ds = new Phieunhaphang[0];
        soluongphieunhap = 0;
    }

    public Danhsachphieunhap(Phieunhaphang[] ds,int soluongphieunhap) {
        this.ds = Arrays.copyOf(ds, soluongphieunhap);
        this.soluongphieunhap = soluongphieunhap;
    }

    public Danhsachphieunhap(Danhsachphieunhap other) {
        this.ds = Arrays.copyOf(other.ds, other.soluongphieunhap);
        this.soluongphieunhap =other.soluongphieunhap;
    }

        public Phieunhaphang[] getds()
    {
        return ds;
    }

    //-----------------------nhapfile-------------------------------
 public void loadFile() {
        try{
            BufferedReader br = new BufferedReader(new FileReader("INPUT/DSPNH.txt"));
        soluongphieunhap = Integer.parseInt(br.readLine().trim());//Integer.parseINt dung de ep kieu du lieu dong thanh kieu INT
        ds= new Phieunhaphang[soluongphieunhap];
        for (int i = 0; i < soluongphieunhap; i++) {
            ds[i]=new Phieunhaphang();
            ds[i].setMaPN(br.readLine().trim());
            ds[i].setMaNCC(br.readLine().trim());
            ds[i].setNgaynhap(LocalDate.parse(br.readLine().trim()));
        }
        br.close();
        System.out.println("\n Nhap du lieu hoan tat");
        }
        catch(IOException e)
        {
            System.out.println("\n loi nhap file DSPN.txt");
        }
    } 
    //-------------------ghifile-------------------------
    public void saveFile() {
    try  {
        BufferedWriter bw = new BufferedWriter(new FileWriter("OUTPUT/DSPNH.txt"));
        BufferedWriter wb =new BufferedWriter(new FileWriter("INPUT/DSPNH.txt"));
        // Ghi file output danh sach
        bw.write("-----------Danh Sach Phieu Nhap Hang-----------");
        bw.newLine();
        bw.write("\t\tMaPN |\t NgayNhap \t\t| MaNCC");
        bw.newLine();
        bw.write("-----------------------------------------------");
        bw.newLine();
        //cap nhat so luong  phieu
        wb.write(String.valueOf(soluongphieunhap));
        wb.newLine();

        for (int i = 0; i < soluongphieunhap; i++) {
            ds[i].ghiFile(bw,wb);
        }
        bw.close();
        wb.close();
        System.out.println("Ghi file thanh cong!");
    } catch (IOException e) {
        System.out.println("Loi ghi file: ");
    }
    }   
    
  

    // -----------------thêm--------------------------------------------
    public void themvaodanhsach(Phieunhaphang p) {
        ds = Arrays.copyOf(ds, soluongphieunhap + 1);
        ds[soluongphieunhap++] = new Phieunhaphang(p);
    }

    // -------------------------xóa-----------------------------------
    public void xoa(String mapn) {
        int vitri = -1;
        for (int i = 0; i < soluongphieunhap; i++) {
            if (ds[i].getMaPN().equals(mapn)) {
                vitri = i;
                break;
            }
        }
        if (vitri == -1) {
            System.out.println("Khong tim thay ma phieu!");
            return;
        }

        for (int i = vitri; i < soluongphieunhap - 1; i++)
            ds[i] = ds[i + 1];

        soluongphieunhap--;
        ds = Arrays.copyOf(ds, soluongphieunhap);
        System.out.println("Da xoa phieu nhap " + mapn);
    }

    //--------------------- sửa ngày nhấp------------------------------
    public void suaNgayNhap(String mapn, LocalDate ngayMoi) {
        for (Phieunhaphang p : ds) {
            if (p.getMaPN().equals(mapn)) {
                p.setNgaynhap(ngayMoi);
                System.out.println("Da sua ngay nhap cho phieu " + mapn);
                return;
            }
        }
        System.out.println("Khong tim thay phieu can sua!");
    }
    //-------------------sửa maNCC----------------------------
        public void suamancc(String mapn,String mancc) {
        for (Phieunhaphang p : ds) {
            if (p.getMaPN().equals(mapn)) {
                p.setMaNCC(mancc);
                System.out.println("Da sua ncc cua mapn");
                return;
            }
        }
        System.out.println("Khong tim thay phieu can sua!");
    }

    // tìm kiếm
  public Phieunhaphang[]  TimTheoNgay (LocalDate ngay) {
        Phieunhaphang[]ketqua=new Phieunhaphang[0];
    int num=0;
    for ( int i=0;i<soluongphieunhap;i++) {
        if (ds[i].getNgaynhap().equals(ngay)) {
            ketqua=Arrays.copyOf(ketqua,num+1);
            ketqua[num]=ds[i];
            num++;
        }
    }
    return ketqua;
    }

      public Phieunhaphang  Timkiemtheoma (String matim) {
        Phieunhaphang ketqua=new Phieunhaphang();
    boolean found =false;
    for ( int i=0;i<soluongphieunhap;i++) {
        if (ds[i].getMaPN().equals(matim)) {
            found=true;
            ketqua=ds[i];
        }   
    }
       if (!found) {
        return null ;
    } else 
        return ketqua;
    }
    //-------------------------menutimkiem---------------------------
    public void menutimkiemDSPNH() {
    Scanner sc = new Scanner(System.in);
    int chon;

    do {
        System.out.println("\n===== MENU TIM KIEM =====");
        System.out.println("1. Tim theo ngay");
        System.out.println("2. Tim theo ma phieu");
        System.out.println("0. Thoat");
        System.out.print("Nhap lua chon: ");
        chon = sc.nextInt();
        sc.nextLine();

        switch (chon) {
            case 1:
                System.out.print("Nhap ngay can tim (yyyy-mm-dd): ");
                LocalDate ngay = LocalDate.parse(sc.nextLine());
                Phieunhaphang[] kq1 = TimTheoNgay(ngay);
                if (kq1.length>0) {
                    for (Phieunhaphang ct : kq1) {
                        ct.xuat();
                    }
                }
                 else {
                    System.out.println("Khong tim thay " ) ;
                }
                break;

            case 2:
                System.out.print("Nhap ma phieu can tim: ");
                String mapntim = sc.nextLine();
                Phieunhaphang kq2 = Timkiemtheoma (mapntim);
                if (kq2 != null) {
                    kq2.xuat();
                } else {
                    System.out.println("Khong tim thay ma san pham " + mapntim);
                }
                break;

            case 0:
                System.out.println("Thoat tim kiem...");
                break;

            default:
                System.out.println("Lua chon khong hop le!");
                break;
        }

    } while (chon != 0);
    
}
    // xuất
    public void xuatpn() {
        for (Phieunhaphang p : ds) {
            p.xuat();
            System.out.println("----------------------------------------");
        }
    }


    public int [] ThongkesophieunhapTheoQuy() {
        int[] dem = new int[4]; // quý 1-4

        for (Phieunhaphang p : ds) {
            int month = p.getNgaynhap().getMonthValue();
            int quy=(month-1)/3;
            dem[quy]++;
        }
        return dem;
    }
}

