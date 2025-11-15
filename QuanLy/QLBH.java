package QuanLy;
import Sach.DS_Sach;
import Khachhang.DS_Khachhang;
import Nhanvien.DS_Nhanvien;
//import Hoadon.DS_Hoadon;

public class QLBH implements IQuanLy {
    protected static DS_Sach ds_Sach = new DS_Sach();
    protected static DS_Khachhang ds_Khachhang = new DS_Khachhang();
    protected static DS_Nhanvien ds_Nhanvien = new DS_Nhanvien();
    //protected static DS_Hoadon ds_Hoadon = new DS_Hoadon();

    public void loadFile(){
        ds_Sach.loadFile();
        ds_Khachhang.loadFile();
        ds_Nhanvien.loadFile();
        //ds_Hoadon.loadFile(ds_Khachhang, ds_Nhanvien);
    }

    public void menuChinh(){}
}
