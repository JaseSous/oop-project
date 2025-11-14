package QuanLy;
import Sach.DS_Sach;
import Khachhang.DS_Khachhang;
import Nhanvien.DS_Nhanvien;

public class QLBH {
    protected static DS_Sach ds_Sach = new DS_Sach();
    protected static DS_Khachhang ds_Khachhang = new DS_Khachhang();
    protected static DS_Nhanvien ds_Nhanvien = new DS_Nhanvien();

    public void loadFile(){
        ds_Sach.loadFile();
        ds_Khachhang.loadFile();
        ds_Nhanvien.loadFile();
    }

    public void menuChinh(){}
}
