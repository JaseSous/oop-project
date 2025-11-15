package Nhaphang;
import java.util.Scanner;
import java.io.*;

public class CTPNH {
    private String MaPN;
    private String MaSP;
    private int soluonghangnhap;
    private double dongia;
    private double thanhtien;   

    public CTPNH() {
        MaSP = "";
        soluonghangnhap = 0;
        dongia = 0;
        MaPN = "";
        thanhtien = 0;
    }

    public CTPNH(String MaSP,String MaPN,int soluonghangnhap,double dongia) {
        this.MaSP = MaSP;
        this.soluonghangnhap = soluonghangnhap;
        this.dongia = dongia;
        this.MaPN = MaPN;
        this.thanhtien = soluonghangnhap * dongia;   // <--- tính luôn
    }

    public CTPNH(CTPNH other) {
        this(other.MaSP, other.MaPN, other.soluonghangnhap, other.dongia);
    }

    public String getMaPN() { return MaPN; }
    public void setMaPN(String MaPN) { this.MaPN = MaPN; }

    public String getMaSP() { return MaSP; }
    public void setMaSP(String MaSP) { this.MaSP = MaSP; }

    public int getsoluonghangnhap() { return soluonghangnhap; }
    public void setsoluonghangnhap(int soluonghangnhap) {
        this.soluonghangnhap = soluonghangnhap;
        this.thanhtien = this.soluonghangnhap * this.dongia;  
    }

    public double getDongia() { return dongia; }
    public void setDongia(double dongia) {
        this.dongia = dongia;
        this.thanhtien = this.soluonghangnhap * this.dongia;   
    }

    public double getThanhtien() { return thanhtien; }  

    public void them() {
        Scanner sc = new Scanner(System.in);
        System.out.print("Nhap ma san pham: ");
        MaSP = sc.nextLine();
        System.out.print("Nhap so luong: ");
        soluonghangnhap = sc.nextInt();
        sc.nextLine();
        System.out.print("Nhap don gia: ");
        dongia = sc.nextDouble();
        sc.nextLine();

        thanhtien = soluonghangnhap * dongia;  
    }

    public void xuat() {
        System.out.printf(" %-10s | %-10d | %-10.2f | %-10.2f%n", 
                MaSP, soluonghangnhap, dongia, thanhtien);
    }

    public void ghiFile(BufferedWriter bw) throws IOException {
        bw.write(String.format("%-10s | %-10s | %-10d | %-10.2f | %-10.2f",
                MaPN, MaSP, soluonghangnhap, dongia, thanhtien));
        bw.newLine();
    }
}
