
import java.io.BufferedWriter;
import java.time.LocalDate;
import java.util.Scanner;
import java.io.IOException;

public class Phieunhaphang {
    private String MaPN;
    private LocalDate ngaynhap;
    private String MaNCC;

    // Constructor mặc định
    public Phieunhaphang() {
        MaPN = "";
        ngaynhap = null;
        MaNCC="";
    }

    // Constructor đầy đủ
    public Phieunhaphang(String MaPN, LocalDate ngaynhap, String MaNCC) {
        this.MaPN = MaPN;
        this.ngaynhap = ngaynhap;
        this.MaNCC=MaNCC;
    }

    // Constructor sao chép
    public Phieunhaphang(Phieunhaphang other) {
        this(other.MaPN, other.ngaynhap,other.MaNCC);
    }

    // Getter - Setter
    public String getMaPN() { return MaPN; }
    public void setMaPN(String MaPN) { this.MaPN = MaPN; }

        public String getMaNCC() { return MaNCC; }
    public void setMaNCC(String MaNCC) { this.MaNCC = MaNCC; }

    public LocalDate getNgaynhap() { return ngaynhap; }
    public void setNgaynhap(LocalDate ngaynhap) { this.ngaynhap = ngaynhap;}

    public void them() {
       Scanner sc=new Scanner(System.in);
        System.out.print("Nhap ma phieu nhap: ");
        MaPN = sc.nextLine();
        System.out.print("Nhap ngay nhap (yyyy-mm-dd): ");
        ngaynhap = LocalDate.parse(sc.nextLine());
        System.out.print("Nhap ma nha cung cap: ");
        MaNCC=sc.nextLine();
       
    }
    public void xuat() {
        System.out.printf("Ma PN: %s | Ngay: %s | MaNCC: %s%n", MaPN, ngaynhap,MaNCC);
    }

    public void ghiFile(BufferedWriter bw) throws IOException {
        bw.write(MaPN + "\t" + ngaynhap + "\t" + MaNCC);
        bw.newLine();
    }

        

}
