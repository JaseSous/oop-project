package Khachhang;

import java.time.LocalDate;
import java.time.Period;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;

public class Khachhang {
    private String makh;
    private String ho;
    private String ten;
    private String dchi;
    private long sdt;
    private String ngaysinh;
    private String ngaymuahang;

    public Khachhang(){
        this.makh=" ";
        this.ho="";
        this.ten="";
        this.dchi="";
        this.sdt=0;
        this.ngaysinh="";
        this.ngaymuahang="";
    }

    public Khachhang(String makh,String ho,String ten,String dchi,long sdt,String ngaysinh,String ngaymuahang){
        this.makh=makh;
        this.ho=ho;
        this.ten=ten;
        this.dchi=dchi;
        this.sdt=sdt;
        this.ngaysinh=ngaysinh;
        this.ngaymuahang=ngaymuahang;
    }
    
    public void nhap(){
        @SuppressWarnings("resource")
        Scanner sc = new Scanner(System.in);
    
        System.out.print("\nMa Khach Hang: ");
        makh = sc.nextLine();
        sc.nextLine(); // bỏ dòng trống còn lại sau khi nhập số
        System.out.print("Ho: ");
        ho = sc.nextLine();
        System.out.print("Ten: ");
        ten = sc.nextLine();
        System.out.print("Dia chi: ");
        dchi = sc.nextLine();
        System.out.print("So dien thoai: ");
        sdt = sc.nextLong();
        sc.nextLine();
        System.out.print("Ngay sinh (dd/MM/yyyy): ");
        ngaysinh = sc.nextLine();
        System.out.print("Ngay mua hang (dd/MM/yyyy): ");
        ngaymuahang = sc.nextLine();
    }
    

    public void xuat(){
        System.out.println("-----------------------------------------------------------------------------------------");
        System.out.printf("| Mã KH: %-10d | Họ: %-15s | Tên: %-10s | Tuổi: %-3d |\n", makh, ho, ten, age());
        System.out.printf("| SĐT: %-10d   | Địa chỉ: %-48s |\n", sdt, dchi);
        System.out.printf("| Ngày sinh: %-10s | Ngày mua: %-47s |\n", ngaysinh, ngaymuahang);
        System.out.println("-----------------------------------------------------------------------------------------");
    }

    //----Hàm Tính Tuổi----
    public int age(){
        try {
            DateTimeFormatter df = DateTimeFormatter.ofPattern("dd/MM/yyyy");
            LocalDate birthDate = LocalDate.parse(ngaysinh, df);
            LocalDate today = LocalDate.now();
            return Period.between(birthDate, today).getYears();
        } catch (Exception e) {
            return 0; // Trả về 0 nếu ngày sinh không hợp lệ
        }
    }

    //----Hàm get/set----
    public String getMakh(){
        return makh;
    }
    public String getHo(){
        return ho;
    }
    public String getTen(){
        return ten;
    }
    public String getDchi(){
        return dchi;
    }
    public long getSdt(){
        return sdt;
    }
    public String getNgaysinh(){
        return ngaysinh;
    }
    public String getNgaymuahang(){
        return ngaymuahang;
    }

    public void setMakh(String makh_x){
        makh=makh_x;
    }
    public void setHo(String ho_x){
        ho=ho_x;
    }
    public void setTen(String ten_x){
        ten=ten_x;
    }
    public void setDchi(String dchi_x){
        dchi=dchi_x;
    }
    public void setSdt(long sdt_x){
        sdt=sdt_x;
    }
    public void setNgaysinh(String ngaysinh_x){
        ngaysinh=ngaysinh_x;
    }
    public void setNgaymuahang(String ngaymuahang_x){
        ngaymuahang=ngaymuahang_x;
    }
}
