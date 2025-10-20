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

    String getMonHoc(){
        return monhoc;
    }

    int getLop(){
        return lop;
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

    void setMonHoc(String monhoc){
        this.monhoc = monhoc;
    }

    void setLop(int lop){
        this.lop = lop;
    }

    // Phương thức
    public void nhap(){
        super.nhap();
        Scanner sc = new Scanner(System.in);
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