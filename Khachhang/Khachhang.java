
package Khachhang;

import java.time.LocalDate; 
import java.time.Period; 
import java.time.format.DateTimeFormatter; 
import java.util.Scanner; 
public class Khachhang { 
    private long makh; 
    private String ho; 
    private String ten; 
    private String dchi; 
    private long sdt; 
    private String ngaysinh; 
    public Khachhang(){ 
        this.makh=0; this.ho=""; 
        this.ten=""; this.dchi=""; 
        this.sdt=0; this.ngaysinh=""; 
    } 
    public Khachhang(long makh,String ho,String ten,String dchi,long sdt,String ngaysinh){ 
        this.makh=makh; 
        this.ho=ho; 
        this.ten=ten; 
        this.dchi=dchi; 
        this.sdt=sdt; 
        this.ngaysinh=ngaysinh; 
    } public void nhap(){ 
        @SuppressWarnings("resource")//Dòng bỏ qua cái sc vàng 
        Scanner sc = new Scanner(System.in); 
        System.out.print("\nMa Khach Hang: "); 
        makh = sc.nextLong(); sc.nextLine(); 
        System.out.print("\nHo: "); 
        sc.nextLine(); 
        System.out.print("\nTen: "); 
        sc.nextLine(); 
        System.out.print("\nDia chi: "); 
        sc.nextLine(); 
        System.out.print("\nSo dien thoai: "); 
        sc.nextLong(); sc.nextLine(); 
        System.out.print("\nNgay sinh(dd/MM/yyyy): "); 
        sc.nextLine(); 
    } 
    public void xuat(){ 
        System.out.printf("%-10d %-10s %-5s %-10s %-10d %-10s", makh,ho,ten,dchi,sdt,ngaysinh); 
        System.out.println("Tuoi cua khach hang: " + age()); 
    } 
    //----Hàm Tính Tuổi---- 
    public int age(){ 
        DateTimeFormatter df = DateTimeFormatter.ofPattern("dd/MM/yyyy"); 
        LocalDate birthDate = LocalDate.parse(ngaysinh, df); LocalDate today = LocalDate.now(); 
        return Period.between(birthDate, today).getYears(); } 
        //----Hàm get/set---- 
        public long getMakh(){ 
            return makh; 
        } 
        public String getHo(){ 
            return ho; 
        } 
        public String getTen(){ 
            return ten; 
        } 
        public String getDiachi(){ 
            return dchi; 
        } 
        public long getSdt(){ 
            return sdt; 
        } 
        public String getNgaysinh(){ 
            return ngaysinh; 
        } 
        public void setMakh(long makh_x){ 
            makh=makh_x; 
        } 
        public void setHo(String ho_x){ 
            ho=ho_x; 
        } 
        public void setTen(String ten_x){ 
            ten=ten_x; 
        } 
        public void setDiachi(String dchi_x){ 
            dchi=dchi_x; 
        } 
        public void setSdt(long sdt_x){ 
            sdt=sdt_x; 
        } 
        public void setNgaysinh(String ngaysinh_x){
            ngaysinh=ngaysinh_x; 
        } 
    }