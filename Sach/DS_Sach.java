import java.io.Serializable;
import java.util.Arrays;
import java.util.Scanner;

public class DS_Sach implements Serializable {
    // serialVersionUID
    private static final long serialVersionUID = 1L;

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
        System.out.println("");
    }
}
