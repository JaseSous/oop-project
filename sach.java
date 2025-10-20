import java.util.Scanner;

public class sach {
    // Thuoc tinh
    String masach, tensach, matheloai, matg, manxb;
    int soluong, gia;

    // Constructor
    public sach(){
        masach = "";
        tensach = "";
        matheloai = "";
        matg = "";
        manxb = "";

        soluong = 0;
        gia = 0;
    }

    public sach(String masach, String tensach, String matheloai, String matg, String manxb, int soluong, int gia){
        this.masach = masach;
        this.tensach = tensach;
        this.matheloai = matheloai;
        this.matg = matg;
        this.manxb = manxb;

        this.soluong = soluong;
        this.gia = gia;
    }

    public sach(sach other){
        this.masach = other.masach;
        this.tensach = other.tensach;
        this.matheloai = other.matheloai;
        this.matg = other.matg;
        this.manxb = other.manxb;

        this.soluong = other.soluong;
        this.gia = other.gia;
    }

    // Get/set
    String getMasach(){
        return masach;
    }

    String getTensach(){
        return tensach;
    }

    String getMatheloai(){
        return matheloai;
    }

    String getMatg(){
        return matg;
    }

    String getManxb(){
        return manxb;
    }

    int getSoluong(){
        return soluong;
    }

    int getGia(){
        return gia;
    }

    void setMasach(String masach){
        this.masach = masach;
    }

    void setTensach(String tensach){
        this.tensach = tensach;
    }

    void setMatheloai(String matheloai){
        this.matheloai = matheloai;
    }

    void setMatg(String matg){
        this.matg = matg;
    }

    void setManxb(String manxb){
        this.manxb = manxb;
    }

    void setSoluong(int soluong){
        this.soluong = soluong;
    }

    void setGia(int gia){
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
        System.out.print("\tSố lượng: "); soluong = sc.nextInt();
        System.out.print("\tGiá: "); gia = sc.nextInt();        
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