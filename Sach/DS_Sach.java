import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Arrays;

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
    public void nhap() {
        try {
            BufferedReader br = new BufferedReader(new FileReader("INPUT/DSSach.txt"));

            soLuongSach = Integer.parseInt(br.readLine().trim());
            dsSach = new Sach[soLuongSach];
            for (int i = 0; i < soLuongSach; i++) {
                int loaiSach = Integer.parseInt(br.readLine().trim());
                switch (loaiSach){
                    case 1:
                        dsSach[i] = new Sach();
                        dsSach[i].nhapTuFile(br);
                        break;
                    case 2:
                        dsSach[i] = new SGK();
                        dsSach[i].nhapTuFile(br);
                        break;
                    case 3:
                        dsSach[i] = new SNC();
                        dsSach[i].nhapTuFile(br);
                        break;
                }
            }
            System.out.println("\n Nhap du lieu hoan tat");
            br.close();
        } catch (IOException e) {
            System.out.println("loi doc file DSNCC");
        }
    }
}
