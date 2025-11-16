package Sach;

import java.util.Scanner;

public class SNC extends Sach {
    Scanner sc = new Scanner(System.in);
    
    // Thuoc tinh
    private String linhvuc, detai;

    // Constructor
    public SNC(){
        super();

        linhvuc = "";
        detai = "";
    }

    public SNC(String masach, String tensach, String matheloai, String matg, String manxb, int soluong, int gia, String linhvuc, String detai){
        super(masach, tensach, matheloai, matg, manxb, soluong, gia);

        this.linhvuc = linhvuc;
        this.detai = detai;
    }

    public SNC(SNC other){
        super(other);

        this.linhvuc = other.linhvuc;
        this.detai = other.detai;
    }

    // Get/set
    String getLinhVuc(){
        return linhvuc;
    }

    String getDeTai(){
        return detai;
    }

    void setLinhVuc(String linhvuc){
        this.linhvuc = linhvuc;
    }

    void setLop(String detai){
        this.detai = detai;
    }

    // Phương thức
    @Override public void nhap(){
        super.nhap();

        System.out.print("\tLĩnh vực: "); linhvuc = sc.nextLine();
        System.out.print("\tĐề tài: "); detai = sc.nextLine();       
    }

    @Override public void xuat(){
        super.xuat();
        System.out.println("\tLĩnh vực: " + linhvuc);
        System.out.println("\tĐề tài: " + detai);
    }
}