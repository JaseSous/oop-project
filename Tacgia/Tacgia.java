package Tacgia;

import java.time.LocalDate;
import java.time.Period;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;

public class Tacgia {
    private long matg;
    private String ho;
    private String ten;
    private String trinhdo;
    private String ngaysinh;

    public Tacgia(){
        this.matg=0;
        this.ho="";
        this.ten="";
        this.trinhdo="";
        this.ngaysinh="";
    }
    public Tacgia(long matg,String ho,String ten,String trinhdo,String ngaysinh){
        this.matg=matg;
        this.ho=ho;
        this.ten=ten;
        this.trinhdo=trinhdo;
        this.ngaysinh=ngaysinh;
    }
    public Tacgia(Tacgia other){
        this.matg = other.matg;
        this.ho = other.ho;
        this.ten = other.ten;
        this.trinhdo = other.trinhdo;
        this.ngaysinh = other.ngaysinh;
    }
    
    public void nhap(){
        @SuppressWarnings("resource")
        Scanner sc = new Scanner(System.in);
    
        System.out.print("\nMa Tac Gia: ");
        matg = sc.nextLong();
        sc.nextLine(); // bỏ dòng trống còn lại sau khi nhập số
        System.out.print("Ho: ");
        ho = sc.nextLine();
        System.out.print("Ten: ");
        ten = sc.nextLine();
        System.out.print("Trinh do hoc van cua tac gia: ");
        trinhdo = sc.nextLine();
        System.out.print("Ngay sinh (dd/MM/yyyy): ");
        ngaysinh = sc.nextLine();
    }
    

    public void xuat(){
        System.out.println("---------------------------------------------------------");
        System.out.printf("| Mã TG: %-10d | Họ Tên: %-15s %-10s |\n",
                matg, ho, ten);
        System.out.printf("| Ngày sinh: %-12s | Tuổi: %-3d                 |\n",
                ngaysinh, age());
        System.out.printf("| Trình độ: %-15s                           |\n",
                trinhdo);
        System.out.println("---------------------------------------------------------");
    }

    //----Hàm Tính Tuổi----
    public int age(){
        try {
            DateTimeFormatter df = DateTimeFormatter.ofPattern("dd/MM/yyyy");
            LocalDate birthDate = LocalDate.parse(ngaysinh, df);
            LocalDate today = LocalDate.now();
            return Period.between(birthDate, today).getYears();
        } catch (Exception e) { 
            // Nếu ngày sinh bị lỗi, trả về 0
            return 0; 
        }
    }

    //----Hàm get/set----
    public long getMatg(){
        return matg;
    }
    public String getHo(){
        return ho;
    }
    public String getTen(){
        return ten;
    }
    public String getTrinhdo(){
        return trinhdo;
    }
    public String getNgaysinh(){
        return ngaysinh;
    }

    public void setMatg(long matg_x){
        matg=matg_x;
    }
    public void setHo(String ho_x){
        ho=ho_x;
    }
    public void setTen(String ten_x){
        ten=ten_x;
    }
    public void setTrinhdo(String trinhdo_x){
        trinhdo=trinhdo_x;
    }
    public void setNgaysinh(String ngaysinh_x){
        ngaysinh=ngaysinh_x;
    }
}
