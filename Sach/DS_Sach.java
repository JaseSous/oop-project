import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
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
    public void loadFile(){
        try {
            String FilePath = "DATA/DS_Sach.dat";

            // Kiểm tra file rỗng hoặc ko tồn tại
            Path path = Paths.get(FilePath);

            if (!Files.exists(path) || !Files.isRegularFile(path) || Files.size(path) == 0) {
                return;
            }

            // Đọc file
            BufferedReader reader = new BufferedReader(new FileReader(FilePath));
            int n = Integer.parseInt(reader.readLine().trim());
            
            for (int i = 0; i < n; i++){
                // Đọc các thuộc tính của sách
                String
                    masach = reader.readLine().trim(),
                    tensach = reader.readLine().trim(),
                    matheloai = reader.readLine().trim(),
                    matg = reader.readLine().trim(),
                    manxb = reader.readLine().trim();

                int
                    soluong = Integer.parseInt(reader.readLine().trim()),
                    gia = Integer.parseInt(reader.readLine().trim());

                // Thêm vào ds sách
                this.them(masach, tensach, matheloai, matg, manxb, soluong, gia);
            }

            reader.close();
        } catch (IOException e) {
            return;
        }
    }

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

    public void them() {        
        dsSach = Arrays.copyOf(dsSach, dsSach.length + 1);
        dsSach[soLuongSach] = new Sach();
        System.out.println("Nhập thông tin sách để thêm vào danh sách sản phẩm: ");
        dsSach[soLuongSach].nhap();
        soLuongSach++;

        System.out.println("Đã thêm thành công sách vào danh sách sản phẩm");
    }

    public void them(String masach, String tensach, String matheloai, String matg, String manxb, int soluong, int gia) {
        dsSach = Arrays.copyOf(dsSach, dsSach.length + 1);
        dsSach[soLuongSach] = new Sach(masach, tensach, matheloai, matg, manxb, soluong, gia);
        soLuongSach++;
    }

    public void xoa(){
        Scanner sc = new Scanner(System.in);

        System.out.print("Nhập mã sách của sách cần xóa khỏi danh sách sản phẩm: "); String maSachCanXoa = sc.nextLine().trim();
        
        for (int i = 0; i < soLuongSach; i++){
            if (dsSach[i].getMasach().equals(maSachCanXoa)){
                for (int j = i; j < soLuongSach-1; j++){
                    dsSach[j] = dsSach[j+1];
                }

                soLuongSach -= 1;
                dsSach = Arrays.copyOf(dsSach, soLuongSach);

                System.out.println("Đã xóa sách có mã sách " + maSachCanXoa + " ra khỏi danh sách sản phẩm");
                return;
            }
        }

        System.out.println("Không tìm thấy sách cần xóa.");
    }

    public void sua(){
        Scanner sc = new Scanner(System.in);

        System.out.print("Nhập mã sách của sách cần sửa trong danh sách sản phẩm: "); String maSachCanSua = sc.nextLine().trim();
        
        for (int i = 0; i < soLuongSach; i++){
            if (dsSach[i].getMasach().equals(maSachCanSua)){
                System.out.println("Hãy nhập thông tin của sách sau khi sửa:");
                dsSach[i].nhap();

                System.out.println("Đã sửa sách có mã sách " + maSachCanSua + " trong khỏi danh sách sản phẩm");
                return;
            }
        }

        System.out.println("Không tìm thấy sách cần sửa.");
    }

    public void timKiemTheoMaSach(){
        Scanner sc = new Scanner(System.in);

        System.out.print("Hãy nhập mã sách cần tim kiếm: "); String maSachCanTim = sc.nextLine().trim();

        for (Sach sach : dsSach){
            if (sach.getMasach().equals(maSachCanTim)){
                System.out.println("Đã tìm thấy sách cần tìm, thông tin sách:");
                sach.xuat();
                return;
            }
        }

        System.out.println("Không tìm thấy sách cần tìm.");
    }

    public void timKiemTheoMaTheLoai(){
        Sach[] result = new Sach[0];
        
        Scanner sc = new Scanner(System.in);

        System.out.print("Hãy nhập mã thể loại cần tim kiếm: "); String maTheLoaiCanTim = sc.nextLine().trim();

        for (Sach sach : dsSach){
            if (sach.getMatheloai().equals(maTheLoaiCanTim)){
                result = Arrays.copyOf(result, result.length+1);
                result[result.length-1] = new Sach(sach);
            }
        }

        if (result.length > 0){
            System.out.println("Đã tìm thấy " + result.length + " sách có mã thể loại " + maTheLoaiCanTim + ":");

            for (int i = 0; i < result.length; i++){
                System.out.println("Sách thứ " + (i+1) + ":");
                result[i].xuat();
            }
        }
        else
            System.out.println("Không tìm thấy sách cần tìm.");
    }
}
