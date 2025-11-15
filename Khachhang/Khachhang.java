package Khachhang;

import java.time.LocalDate;
import java.time.Period;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;
import java.time.format.DateTimeParseException;

public class Khachhang {
    private String makh;
    private String ho;
    private String ten;
    private String dchi;
    private long sdt;
    private LocalDate ngaysinh;
    private LocalDate ngaymuahang;
    // Dùng 'static final' vì nó là hằng số và chung cho tất cả đối tượng Khachhang
    private static final DateTimeFormatter df = DateTimeFormatter.ofPattern("dd/MM/yyyy");

    public Khachhang(){
        this.makh="";
        this.ho="";
        this.ten="";
        this.dchi="";
        this.sdt=0;
        this.ngaysinh = null;
        this.ngaymuahang = null;
    }

    public Khachhang(String makh,String ho,String ten,String dchi,long sdt,LocalDate ngaysinh, LocalDate ngaymuahang){
        this.makh=makh;
        this.ho=ho;
        this.ten=ten;
        this.dchi=dchi;
        this.sdt=sdt;
        this.ngaysinh=ngaysinh;
        this.ngaymuahang=ngaymuahang;
    }

    public Khachhang(Khachhang other){
        this.makh = other.makh;
        this.ho = other.ho;
        this.ten = other.ten;
        this.dchi = other.dchi;
        this.sdt = other.sdt;
        this.ngaysinh = other.ngaysinh;
        this.ngaymuahang = other.ngaymuahang;
    }
    
    public void nhap(){
        @SuppressWarnings("resource")
        Scanner sc = new Scanner(System.in);

        System.out.print("\nMa Khach Hang: ");
        makh = sc.nextLine();
        System.out.print("Ho: ");
        ho = sc.nextLine();
        System.out.print("Ten: ");
        ten = sc.nextLine();
        System.out.print("Dia chi: ");
        dchi = sc.nextLine();
        System.out.print("So dien thoai: ");
        sdt = sc.nextLong();
        sc.nextLine(); // Xử lý trôi lệnh
        
        while (true) {
            System.out.print("Ngay sinh (dd/MM/yyyy): ");
            String ngaySinhStr = sc.nextLine();
            try {
                // Thử chuyển đổi
                this.ngaysinh = LocalDate.parse(ngaySinhStr, df);
                // Nếu thành công, thoát khỏi vòng lặp
                break; 
            } catch (DateTimeParseException e) {
                // Nếu thất bại, thông báo lỗi và vòng lặp tiếp tục
                System.out.println("(!) Sai định dạng. Vui lòng nhập lại (ví dụ: 25/10/1999).");
            }
        }

        while (true) {
            System.out.print("Ngay mua hang (dd/MM/yyyy): ");
            String ngayMuaHangStr = sc.nextLine();
            try {
                this.ngaymuahang = LocalDate.parse(ngayMuaHangStr, df);
                break;
            } catch (DateTimeParseException e) {
                System.out.println("(!) Sai định dạng. Vui lòng nhập lại (ví dụ: 01/12/2025).");
            }
        }
    }
    

    public void xuat() {
        // Định dạng lại ngày tháng trước khi in để tránh lỗi NullPointerException
        // và đảm bảo đúng định dạng dd/MM/yyyy
        String ngaySinhStr = (ngaysinh != null) ? ngaysinh.format(df) : "N/A";
        String ngayMuaHangStr = (ngaymuahang != null) ? ngaymuahang.format(df) : "N/A";

        System.out.println("-----------------------------------------------------------------------------------------");
        System.out.printf("| Mã KH: %-10s | Họ: %-15s | Tên: %-10s | Tuổi: %-3d |\n", makh, ho, ten, age());
        System.out.printf("| SĐT: %-10d   | Địa chỉ: %-48s |\n", sdt, dchi);
        System.out.printf("| Ngày sinh: %-10s | Ngày mua: %-47s |\n", ngaySinhStr, ngayMuaHangStr);
        System.out.println("-----------------------------------------------------------------------------------------");
    }

    //----Hàm Tính Tuổi----
    public int age() {
        // Nếu ngày sinh không hợp lệ (null) thì trả về 0
        if (this.ngaysinh == null) {
            return 0;
        }
        // Không cần parse nữa, chỉ cần tính toán
        LocalDate today = LocalDate.now();
        return Period.between(this.ngaysinh, today).getYears();
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
    public LocalDate getNgaysinh() {
        return ngaysinh;
    }
    public LocalDate getNgaymuahang() {
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
    public void setNgaysinh(LocalDate ngaysinh_x) {
        ngaysinh = ngaysinh_x;
    }
    public void setNgaymuahang(LocalDate ngaymuahang_x) {
        ngaymuahang = ngaymuahang_x;
    }

}