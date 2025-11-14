package QuanLy;
import Sach.DS_Sach;
import Khachhang.DS_Khachhang;

public class QLBH {
    protected static DS_Sach ds_Sach = new DS_Sach();
    protected static DS_Khachhang ds_Khachhang = new DS_Khachhang();

    public void loadFile(){
        ds_Sach.loadFile();
        ds_Khachhang.loadFile();
    }

    public void menuChinh(){}
}
