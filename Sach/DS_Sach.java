import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Arrays;
import java.util.Scanner;
import java.util.Formatter;

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
        try (BufferedWriter writer = new BufferedWriter(new FileWriter("OUTPUT/DanhSachSanPham.txt"));
            Formatter formatter = new Formatter(writer)) {

            formatter.format("===[Danh sách sản phẩm]===\n");
            formatter.format("Số lượng: " + soLuongSach + "\n\n");

            if (soLuongSach > 0){
                formatter.format("-".repeat(104));
                formatter.format("\n| %-3s | %-7s | %-25s | %-11s | %-10s | %-6s | %-8s | %-9s |\n",
                                "STT", "Mã sách", "Tên sách", "Mã thể loại", "Mã tác giả", "Mã NXB", "Số lượng", "Giá");
                formatter.format("-".repeat(104) + "\n");

                for (int i = 0; i < soLuongSach; i++){
                    formatter.format("| %-3s | %-7s | %-25s | %-11s | %-10s | %-6s | %-8s | %-9s |\n",
                            i+1,
                            dsSach[i].getMasach(),
                            dsSach[i].getTensach(),
                            dsSach[i].getMatheloai(),
                            dsSach[i].getMatg(),
                            dsSach[i].getManxb(),
                            dsSach[i].getSoluong(),
                            dsSach[i].getGia() + " ₫");
                }
                formatter.format("-".repeat(104));
            }

            System.out.println("Đã ghi dữ liệu vào file: DanhSachSanPham.txt");

        } catch (IOException e) {
            System.err.println("Lỗi I/O: " + e.getMessage());
        }
    }

    public void them(String masach, String tensach, String matheloai, String matg, String manxb, int soluong, int gia) {
        dsSach = Arrays.copyOf(dsSach, dsSach.length + 1);
        dsSach[soLuongSach] = new Sach(masach, tensach, matheloai, matg, manxb, soluong, gia);
        soLuongSach++;
    }
}
