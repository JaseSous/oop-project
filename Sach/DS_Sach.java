import java.util.Arrays;
import java.util.Scanner;

public class DS_Sach {
    // Thuoc tinh
    private int soLuongSach;
    private Sach[] dsSach;

    // Constructor
    public DS_Sach() {
        soLuongSach = 0;
        dsSach = new Sach[0];
    }

    public DS_Sach(DS_Sach other) {
        this.soLuongSach = other.soLuongSach;
        dsSach = Arrays.copyOf(other.dsSach, other.soLuongSach);
    }

    // Phương thức
    public void xem() {
        System.out.println("\n===[Danh sách sản phẩm]===\n");
        System.out.println("Số lượng: " + soLuongSach);
        
        if (soLuongSach > 0){
            System.out.println("-".repeat(104));
            System.out.printf(
                    "\n| %-3s | %-7s | %-25s | %-11s | %-10s | %-6s | %-8s | %-9s |\n\n",
                    "STT", "Mã sách", "Tên sách", "Mã thể loại", "Mã tác giả", "Mã NXB", "Số lượng", "Giá");
            System.out.println("-".repeat(104));

            for (int i = 0; i < soLuongSach; i++){
                System.out.printf(
                    "| %-3s | %-7s | %-25s | %-11s | %-10s | %-6s | %-8s | %-9s |\n",
                    i+1,
                    dsSach[i].getMasach(),
                    dsSach[i].getTensach(),
                    dsSach[i].getMatheloai(),
                    dsSach[i].getMatg(),
                    dsSach[i].getManxb(),
                    dsSach[i].getSoluong(),
                    dsSach[i].getGia());
            }
            System.out.println("-".repeat(104));
        }
    }

    public void them(String masach, String tensach, String matheloai, String matg, String manxb, int soluong, int gia) {
        dsSach = Arrays.copyOf(dsSach, dsSach.length + 1);
        dsSach[soLuongSach] = new Sach(masach, tensach, matheloai, matg, manxb, soluong, gia);
        soLuongSach++;
    }
}
