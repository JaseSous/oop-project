import java.util.Scanner;
public class main {
    public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    
    // 1. Tạo các đối tượng quản lý
    DanhSachKhachHang dskh = new DanhSachKhachHang();
    Danhsachnhanvien dsnv = new Danhsachnhanvien();
    Danhsachhoadon dshd = new Danhsachhoadon();
    
    // (Có thể gọi dskh.nhapkh() và dsnv.nhapnv() ở đây để nhập sẵn)

    int luaChonChinh;
    do {
        System.out.println("\n=== MENU CHUONG TRINH ===");
        System.out.println("1. Quan ly Khach hang");
        System.out.println("2. Quan ly Nhan vien");
        System.out.println("3. Quan ly Hoa don");
        System.out.println("0. Thoat");
        System.out.print("Chon: ");
        luaChonChinh = sc.nextInt();
        sc.nextLine();

        switch (luaChonChinh) {
            case 1:
                dskh.menu(); // Gọi menu khách hàng
                break;
            case 2:
                dsnv.menu(); // Gọi menu nhân viên
                break;
            case 3:
                // Gọi menu hóa đơn và truyền dskh, dsnv vào
                dshd.menu(sc, dskh, dsnv); 
                break;
            case 0:
                System.out.println("Thoat chuong trinh.");
                break;
        }
    } while (luaChonChinh != 0);
}
}