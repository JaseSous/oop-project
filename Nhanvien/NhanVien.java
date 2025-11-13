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

    //----Hàm xuất ----
    public void xuat(){
        System.out.println("----------------------------------------------------------");
        System.out.printf("| Mã NV: %-10d | Họ Tên: %-15s %-10s |\n",
                manv, ho, ten);
        System.out.printf("| Ngày sinh: %-12s | Tuổi: %-3d                 |\n",
                ngaysinh, age());
        System.out.printf("| Lương tháng: %-15d ₫                           |\n",
                luongthang);
        System.out.println("----------------------------------------------------------");
    }

    //----Hàm Tính Tuổi----
    public int age(){
        try { //Thêm try
            DateTimeFormatter df = DateTimeFormatter.ofPattern("dd/MM/yyyy");
            LocalDate birthDate = LocalDate.parse(ngaysinh, df);
            LocalDate today = LocalDate.now();
            return Period.between(birthDate, today).getYears();
        } catch (Exception e) { //Thêm catch
            // Nếu ngày sinh bị lỗi (sai định dạng, ngày không tồn tại), trả về 0
            return 0; 
        } 
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
