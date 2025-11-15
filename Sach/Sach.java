package Sach;

import java.util.Scanner;

public class Sach {
    // Thuoc tinh
    private String masach, tensach, matheloai, matg, manxb;
    private int soluong, gia;

    // Constructor
    public Sach(){
        masach = "";
        tensach = "";
        matheloai = "";
        matg = "";
        manxb = "";

        soluong = 0;
        gia = 0;
    }

    public Sach(String masach, String tensach, String matheloai, String matg, String manxb, int soluong, int gia){
        this.masach = masach;
        this.tensach = tensach;
        this.matheloai = matheloai;
        this.matg = matg;
        this.manxb = manxb;

        this.soluong = soluong;
        this.gia = gia;
    }

    public Sach(Sach other){
        this.masach = other.masach;
        this.tensach = other.tensach;
        this.matheloai = other.matheloai;
        this.matg = other.matg;
        this.manxb = other.manxb;

        this.soluong = other.soluong;
        this.gia = other.gia;
    }

    // Get/set
    public String getMasach(){
        return masach;
    }

    public String getTensach(){
        return tensach;
    }

    public String getMatheloai(){
        return matheloai;
    }

    public String getMatg(){
        return matg;
    }

    public String getManxb(){
        return manxb;
    }

    public int getSoluong(){
        return soluong;
    }

    public int getGia(){
        return gia;
    }

    public void setMasach(String masach){
        this.masach = masach;
    }

    public void setTensach(String tensach){
        this.tensach = tensach;
    }

    public void setMatheloai(String matheloai){
        this.matheloai = matheloai;
    }

    public void setMatg(String matg){
        this.matg = matg;
    }

    public void setManxb(String manxb){
        this.manxb = manxb;
    }

    public void setSoluong(int soluong){
        this.soluong = soluong;
    }

    public void setGia(int gia){
        this.gia = gia;
    }

    // Phương thức
    public void nhap(){
        Scanner sc = new Scanner(System.in);

        System.out.print("\tMã sách: "); masach = sc.nextLine();
        System.out.print("\tTên sách: "); tensach = sc.nextLine();
        System.out.print("\tMã thể loại: "); matheloai = sc.nextLine();
        System.out.print("\tMã tác giả: "); matg = sc.nextLine();
        System.out.print("\tMã nhà xuất bản: "); manxb = sc.nextLine();
        System.out.print("\tSố lượng: "); soluong = sc.nextInt(); sc.nextLine();
        System.out.print("\tGiá: "); gia = sc.nextInt(); sc.nextLine();
    }

    public void xuat(){
        System.out.println("\tMã sách: " + masach);
        System.out.println("\tTên sách: " + tensach);
        System.out.println("\tMã thể loại: " + matheloai);
        System.out.println("\tMã tác giả: " + matg);
        System.out.println("\tMã nhà xuất bản: " + manxb);
        System.out.println("\tSố lượng: " + soluong);
        System.out.println("\tGiá: " + gia);
    }
}