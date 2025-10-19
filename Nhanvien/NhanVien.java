package Nhanvien;

import java.time.LocalDate;
import java.time.Period;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;

public class NhanVien {
    //----Thuộc tính----
    private long manv;
    private String ho;
    private String ten;
    private String ngaysinh;
    private long luongthang;

    //----Hàm thiết lập----
    public NhanVien(){
        manv=0;
        ho="";
        ten="";
        ngaysinh="";
        luongthang=0;
    }
    public NhanVien(long manv, String ho, String ten, String ngaysinh, long luongthang){
        this.manv=manv;
        this.ho=ho;
        this.ten=ten;
        this.ngaysinh=ngaysinh;
        this.luongthang=luongthang;
    }
    public NhanVien(NhanVien a){
        manv=a.manv;
        ho=a.ho;
        ten=a.ten;
        ngaysinh=a.ngaysinh;
        luongthang=a.luongthang;
    }

    //----Hàm nhập----
    public void nhap(){
        @SuppressWarnings("resource")//Dòng bỏ qua cái sc vàng 
        Scanner sc = new Scanner(System.in);
        System.out.print("\nMa Nhan Vien: ");
        manv = sc.nextLong();
        sc.nextLine();
        System.out.print("\nHo: ");
        ho = sc.nextLine();
        System.out.print("\nTen: ");
        ten = sc.nextLine();
        System.out.print("\nNgay sinh(dd/MM/yyyy): ");
        ngaysinh = sc.nextLine();
        System.out.print("\nLuong thang nay: ");
        luongthang = sc.nextLong();
    }

    //----Hàm xuất----
    public void xuat(){
        System.out.printf("%-10d %-10s %-5s %-10s %-10d",
        manv,ho,ten,ngaysinh,luongthang);

        System.out.println("Tuoi cua nhan vien: " + age());
    }

    //----Hàm Tính Tuổi----
    public int age(){
        DateTimeFormatter df = DateTimeFormatter.ofPattern("dd/MM/yyyy");//lệnh để dịch dòng String thành định dạng localdate
        LocalDate birthDate = LocalDate.parse(ngaysinh, df);//lưu ngày vừa dịch vô cho biến birthdate
        LocalDate today = LocalDate.now();
        return Period.between(birthDate, today).getYears();//lệnh cho biết khoảng tgian giữa 2 đơn vi thời gian 
    }

    //----Hàm get/set----
    public long getManv(){
        return manv;
    }
    public String getHo(){
        return ho;
    }
    public String getTen(){
        return ten;
    }
    public String getNgaysinh(){
        return ngaysinh;
    }
    public long getLuongthang(){
        return luongthang;
    }

    public void setManv(long manv_x){
        manv=manv_x;
    }
    public void setHo(String ho_x){
        ho=ho_x;
    }
    public void setTen(String ten_x){
        ten=ten_x;
    }
    public void setNgaysinh(String ngaysinh_x){
        ngaysinh=ngaysinh_x;
    }
    public void setLuongthang(long luongthang_x){
        luongthang=luongthang_x;
    }
}
