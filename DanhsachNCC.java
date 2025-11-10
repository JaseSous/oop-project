
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.util.Arrays;
import java.util.Scanner;

public class DanhsachNCC {
    private int soluongNCC;
    private Nhacungcap[] dsNCC;

    // ===== Constructor =====
    public DanhsachNCC() {
    }
    public DanhsachNCC(int soluongNCC,Nhacungcap []dsNCC)
    {
        this.soluongNCC=soluongNCC;
        this.dsNCC=Arrays.copyOf(dsNCC, soluongNCC);
    }
    public DanhsachNCC(DanhsachNCC other)
    {
        this.dsNCC=Arrays.copyOf(other.dsNCC, other.soluongNCC);
        this.soluongNCC=other.soluongNCC;
    }
        public  Nhacungcap [] getds(){return dsNCC;}

    // ===== Nhập danh sách =====
    public void loadFile(){
        try(BufferedReader br = new BufferedReader(new FileReader("INPUT/DSNCC.txt"))){
           
        soluongNCC = Integer.parseInt(br.readLine().trim());
        dsNCC = new Nhacungcap[soluongNCC]; // cấp phát mảng
        for (int i = 0; i < soluongNCC; i++) {
            dsNCC[i] = new Nhacungcap();
            dsNCC[i].nhapNCC(br);
        }
        System.out.println("\n Nhap du lieu hoan tat");
        }
        catch (Exception e)
        {
            System.out.println("loi file");
        }
    }

    // ===== Xuất danh sách =====
    public void xem() {
        try{
            BufferedWriter bw=new BufferedWriter(new FileWriter("OUTPUT/DSNCC.txt"));
            BufferedWriter wb=new BufferedWriter(new FileWriter("INPUT/DSNCC.txt"));
            bw.write(String.format("%-10s | %-20s |  %-20s%n", "Ma NCC", "Ten NCC", "Dia Chi"));
            bw.write("--------------------------------------------------\n");

            wb.write(String.valueOf(soluongNCC));
            wb.newLine();
            for (int i = 0; i < soluongNCC; i++) {
                dsNCC[i].ghifile(bw,wb);
            }
            bw.close();
            wb.close();
            System.out.println("Da luu file va ghi file thanh cong");
        }
        catch ( Exception e){
            System.out.println("lỗi đọc file");
        }
    }
        public void xuatNCC() {
        System.out.printf("%-10s | %-20s | %-20s%n", "MaNCC", "TenNCC", "Diachi");
        for (Nhacungcap p : dsNCC) {
            p.xuat();
        }
    }

    // ===== Thêm nhà cung cấp =====
    public void themNCC() {
        Nhacungcap temp = new Nhacungcap();
        temp.them();
        dsNCC = Arrays.copyOf(dsNCC, soluongNCC + 1);
        dsNCC[soluongNCC] = temp;
        soluongNCC++;
        System.out.println("Da them nha cung cap moi !");
    }

    // ===== Xóa nhà cung cấp =====
    public void xoaNCC(String maNCCmuonxoa) {
        int vitri = -1;
        for (int i = 0; i < soluongNCC; i++) {
            if (dsNCC[i].getmaNCC().equalsIgnoreCase(maNCCmuonxoa)) {
                vitri = i;
                break;
            }
        }

        if (vitri == -1) {
            System.out.println(" khong tim thay ma can xoa: " + maNCCmuonxoa);
            return;
        }

        for (int i = vitri; i < soluongNCC - 1; i++) {
            dsNCC[i] = dsNCC[i + 1];
        }
        soluongNCC--;
        dsNCC = Arrays.copyOf(dsNCC, soluongNCC);
        System.out.println("Da xoa nha cung cap ma: " + maNCCmuonxoa);
    }
//=============================sua thong tin nha cung cap=========================
    public void suatenNCC(String mancc,String tencansua )
    {
        for(Nhacungcap i : dsNCC)
        {
            if(i.getmaNCC().equals(mancc))
            {
                i.settenNCC(tencansua);
                break;
            }
            
        }
    }
        public void suadiachi(String mancc,String diachisua )
    {
        for(Nhacungcap i : dsNCC)
        {
            if(i.getmaNCC().equals(mancc))
            {
                i.setdiachi(diachisua);
                break;
            }
            
        }
    }
    void menusua(){
         Scanner sc = new Scanner(System.in);
        int choice;
        
        do {
            System.out.println("\n===== MENU QUAN LY NHA CUNG CAP =====");
            System.out.println("1. Sua ten NCC  ");
            System.out.println("1. Sua dia chi  ");
            System.out.println("0. Thoat chuc nang ");
            System.out.println("=========================================");
                choice = sc.nextInt();
                sc.nextLine();
            switch (choice) {
                case 1:
                    System.out.print("Nhap ma NCC can sua: ");
                    String maNCC1 = sc.nextLine();
                     System.out.print("Nhap ten moi : ");
                    String tensua = sc.nextLine();
                    suatenNCC(maNCC1,tensua);
                    break;
                case 2:
                    System.out.print("Nhap ma NCC can sua: ");
                    String maNCC2 = sc.nextLine();
                    System.out.print("Nhap ten moi : ");
                    String diachisua = sc.nextLine();
                    suadiachi(maNCC2,diachisua);
                    break;
                case 0:
                    break;
                default:
                    System.out.println("Lua chon khong hop le. Vui long chon lai.");
            }
        } while (choice != 0);
    }
    // ===== Tìm theo mã =====
    public Nhacungcap timtheomaNCC(String maNCC) {
        for (int i = 0; i < soluongNCC; i++) {
            if (dsNCC[i].getmaNCC().equals(maNCC)) {
                return dsNCC[i];
            }
        }
        return null;
    }

    // ===== Tìm theo tên =====
    public Nhacungcap[] timtheotenNCC(String ten) {
        Nhacungcap[] kq = new Nhacungcap[0];
        int count = 0;
        for (int i = 0; i < soluongNCC; i++) {
            if (dsNCC[i].gettenNCC().toLowerCase().contains(ten.toLowerCase())) {
                kq = Arrays.copyOf(kq, count + 1);
                kq[count] = dsNCC[i];
                count++;
            }
        }
        return kq;
    }

    // ===== Menu tìm kiếm =====
    public void menutimNCC() {
        Scanner sc = new Scanner(System.in);
        int chon;
        do {
            System.out.println("\n===== MENU tim kiem nha cung cap =====");
            System.out.println("1. tim theo ma");
            System.out.println("2. Tìm theo ten");
            System.out.println("0. Thoat");
            System.out.print("Chon: ");
            chon = sc.nextInt();
            sc.nextLine();

            switch (chon) {
            case 1:
                System.out.print("Nhap ma NCC can tim: ");
                String ma = sc.nextLine();
                Nhacungcap NCC = timtheomaNCC(ma);
                if (NCC != null) {
                    System.out.println("\nKQ:");
                    System.out.printf("%-10s | %-20s | %-20s%n", "Ma NCC", "Ten NCC", "Đia chi");
                    NCC.xuat();
                } else {
                    System.out.println(" Khong tim thay ma NCC: " + ma);
                }
                break;

            case 2:
                System.out.print("Nhap ten can tim: ");
                String ten = sc.nextLine();
                Nhacungcap[] ds = timtheotenNCC(ten);
                if (ds.length == 0) {
                    System.out.println("ko tim thay ten : " + ten);
                } else {
                    System.out.printf("%-10s %-20s %-20s%n", "Ma NCC", "Ten NCC", "Đia chi");
                    for (Nhacungcap n : ds)
                        n.xuat();
                }
                break;

            case 0:
                System.out.println("Thoat menu tim kiem.");
                break;

            default:
                System.out.println("lua chon ko hop le!");
                break;
            }
        } while (chon != 0);
  
    }
    //------------------thong ke ------------------------
    public void ThongkekhuvucNCC (){
        int[] tk=new int[3];
        for(Nhacungcap p: dsNCC)
        {
            if(p.getdiachi().contains("HCM"))
            {
                tk[0]++;
            }
            else if (p.getdiachi().contains("HN"))
            {
                tk[1]++;
            }
            else 
            {
                tk[2]++;
            }
        }
        for (int i=0;i<tk.length;i++)
        {
            if(i==0)
            {
                System.out.printf("%-10s : %-10s%n","So NCC den tu HCM :", tk[i] );
            }
            else if(i==1)
            {
                System.out.printf("%-10s : %-10s%n","So NCC den tu HN :", tk[i] );
            }
            else
            {
                System.out.printf("%-10s : %-10s%n","So NCC den tu DN :", tk[i] );
            }
        }
    }
        
}
