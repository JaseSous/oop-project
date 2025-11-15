package Nhacungcap;
import java.io.BufferedWriter;
import java.io.IOException;
import java.util.Scanner;

public class Nhacungcap {
    Scanner sc = new Scanner(System.in);

    private String maNCC;
    private String tenNCC;
    private String diachi;

    public Nhacungcap() {
        maNCC = "";
        tenNCC = "";
        diachi = "";
    }

    public Nhacungcap(String maNCC, String tenNCC, String diachi) {
        this.maNCC = maNCC;
        this.tenNCC = tenNCC;
        this.diachi = diachi;
    }
    public Nhacungcap(Nhacungcap other)
    {
        this.maNCC=other.maNCC;
        this.tenNCC=other.tenNCC;
        this.diachi=other.diachi;
    }

    public String getmaNCC() { return maNCC; }
    public void setmaNCC(String maNCC) { this.maNCC = maNCC; }

    public String gettenNCC() { return tenNCC; }
    public void settenNCC(String tenNCC) { this.tenNCC = tenNCC; }

    public String getdiachi() { return diachi; }
    public void setdiachi(String diachi) { this.diachi = diachi; }



     public void them(){
        System.out.print("Nhap ma nha cung cap: ");
        maNCC = sc.nextLine();
        System.out.print("Nhap ten NCC: ");
        tenNCC = sc.nextLine();
        System.out.print("Nhap dia chi: ");
        diachi = sc.nextLine();
      
    }
    public void xuat() {
        System.out.printf("%-10s | %-20s | %-20s%n", maNCC, tenNCC, diachi);
    }
    public void ghifile(BufferedWriter bw , BufferedWriter wb) throws IOException
    {
        bw.write(String.format("%-10s | %-20s | %-20s",maNCC,tenNCC,diachi));
        bw.newLine();

        wb.write(maNCC);
        wb.newLine();
        wb.write(tenNCC);
        wb.newLine();
        wb.write(diachi);
        wb.newLine();
    }

}


