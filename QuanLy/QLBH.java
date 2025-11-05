import java.io.FileInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;

public class QLBH {
    private static DS_Sach ds_Sach;

    public void loadFileDSSach(){
        // Load dữ liệu của ds sách
        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream("../DATA/DS_Sach.dat"))){
            Object obj = ois.readObject();
            
            ds_Sach = new DS_Sach((DS_Sach) obj);
        } catch (IOException | ClassNotFoundException e) {
            ds_Sach = new DS_Sach();
        }
    }

    public void menuChinh(){}
}
