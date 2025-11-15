package Nhaphang;
import java.io.BufferedWriter;
import java.time.LocalDate;
import java.util.Scanner;
import java.io.IOException;

public class Phieunhaphang {
    Scanner sc = new Scanner(System.in);

    private String MaPN;
    private String MaNCC;
    private LocalDate ngaynhap;

    // Constructor mặc định
    public Phieunhaphang() {
        MaPN = "";
        ngaynhap = null;
        MaNCC="";
    }

    // Constructor đầy đủ
    public Phieunhaphang(String MaPN, LocalDate ngaynhap, String MaNCC) {
        this.MaPN = MaPN;
        this.MaNCC=MaNCC;
        this.ngaynhap = ngaynhap;
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
        System.out.print("Nhap ma phieu nhap: ");
        MaPN = sc.nextLine();
        System.out.print("Nhap ma nha cung cap: ");
        MaNCC=sc.nextLine();
        System.out.print("Nhap ngay nhap (yyyy-mm-dd): ");
        ngaynhap = LocalDate.parse(sc.nextLine());
    }
    public void xuat() {
        System.out.printf("Ma PN: %s | Ngay: %s | MaNCC: %s%n", MaPN, ngaynhap,MaNCC);
    }

    public void ghiFile(BufferedWriter bw, BufferedWriter wb) throws IOException {
        bw.write("\t\t"+MaPN + "|\t" + ngaynhap + "\t\t|" + MaNCC);
        bw.newLine();

        wb.write(MaPN);
        wb.newLine();
        wb.write(MaNCC);
        wb.newLine();
        wb.write(String.valueOf(ngaynhap));
        wb.newLine();
    }

        

}
