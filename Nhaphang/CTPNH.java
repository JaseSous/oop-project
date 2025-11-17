package Nhaphang;
import java.util.Scanner;
import java.io.*;

public class CTPNH {
    Scanner sc = new Scanner(System.in);

    private String MaPN;
    private String MaSP;
    private int soluonghangnhap;
    private double dongia;
    private double thanhtien;   

    public CTPNH() {
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
        
        System.out.printf("%-10s | %-10s | %-15d | %-10.2f | %-10.2f%n", 
                MaPN,MaSP, soluonghangnhap, dongia, thanhtien);
    }

    public void ghifile(BufferedWriter bw ) throws IOException
    {
        bw.write(MaPN);
        bw.newLine();
        bw.write(MaSP);
        bw.newLine();
        bw.write(String.valueOf(soluonghangnhap));
        bw.newLine();
        bw.write(String.valueOf(dongia));
        bw.newLine();
        bw.write(String.valueOf(thanhtien));
        bw.newLine();
    }
}
