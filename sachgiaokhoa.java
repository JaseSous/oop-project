import java.util.Scanner;

public class sachgiaokhoa extends sach {
    // Thuoc tinh
    String monhoc;
    int lop;

    // Constructor
    public sachgiaokhoa(){
        super();

        monhoc = "";
        lop = 1;
    }

    public sachgiaokhoa(String masach, String tensach, String matheloai, String matg, String manxb, int soluong, int gia, String monhoc, int lop){
        super(masach, tensach, matheloai, matg, manxb, soluong, gia);

        this.monhoc = monhoc;
        this.lop = lop;
    }

    public sachgiaokhoa(sachgiaokhoa other){
        super(other);

        this.monhoc = other.monhoc;
        this.lop = other.lop;
    }

    // Get/set
    String getMonHoc(){
        return monhoc;
    }

    int getLop(){
        return lop;
    }

    void setMonHoc(String monhoc){
        this.monhoc = monhoc;
    }

    void setLop(int lop){
        this.lop = lop;
    }

    // Phương thức
    @Override public void nhap(){
        super.nhap();
        Scanner sc = new Scanner(System.in);

        System.out.print("\tMôn học: "); monhoc = sc.nextLine();
        System.out.print("\tLớp: "); lop = sc.nextInt();       
    }

    @Override public void xuat(){
        super.xuat();
        System.out.println("\tMôn học: " + monhoc);
        System.out.println("\tLớp: " + lop);
    }
}