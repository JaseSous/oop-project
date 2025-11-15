package QuanLy;
import Sach.DS_Sach;
import TheLoai.DS_TheLoai;
import Khachhang.DS_Khachhang;
import Nhanvien.DS_Nhanvien;
import Nhaphang.DS_CTPNH;
import Nhacungcap.DS_NCC;
//import Hoadon.DS_Hoadon;
import Nhaphang.DS_PNH;

public class QLBH {
    protected static DS_Sach ds_Sach = new DS_Sach();
    protected static DS_Khachhang ds_Khachhang = new DS_Khachhang();
    protected static DS_Nhanvien ds_Nhanvien = new DS_Nhanvien();
    protected static DS_PNH ds_PNH=new DS_PNH();
    protected static DS_CTPNH ds_CTPNH =new DS_CTPNH();
    protected static DS_NCC ds_NCC=new DS_NCC();
    protected static DS_TheLoai ds_TheLoai =new DS_TheLoai();
    //protected static DS_Hoadon ds_Hoadon = new DS_Hoadon();

    public void loadFile(){
        ds_Sach.loadFile();
        ds_Khachhang.loadFile();
        ds_Nhanvien.loadFile();
        ds_CTPNH.loadFile();
        ds_PNH.loadFile();
        ds_NCC.loadFile();
        ds_TheLoai.loadFile(); 
        //ds_Hoadon.loadFile(ds_Khachhang, ds_Nhanvien);
    }

    public void menuChinh(){
    }
}
