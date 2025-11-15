package QuanLy;
import Sach.DS_Sach;
import Khachhang.DS_Khachhang;
import NXB.DS_NXB;
import Nhanvien.DS_Nhanvien;
import Nhaphang.DS_CTPNH;
//import Hoadon.DS_Hoadon;
import Nhaphang.DS_PhieuNhap;

public class QLBH implements IQuanLy {
    protected static DS_Sach ds_Sach = new DS_Sach();
    protected static DS_Khachhang ds_Khachhang = new DS_Khachhang();
    protected static DS_Nhanvien ds_Nhanvien = new DS_Nhanvien();
    //protected static DS_Hoadon ds_Hoadon = new DS_Hoadon();
    protected static DS_NXB ds_NXB = new DS_NXB();
    protected static DS_PhieuNhap ds_Phieunhap = new DS_PhieuNhap();
    protected static DS_CTPNH ds_CTPNH = new DS_CTPNH();

    public void loadFile(){
        ds_Sach.loadFile();
        ds_Khachhang.loadFile();
        ds_Nhanvien.loadFile();
        //ds_Hoadon.loadFile(ds_Khachhang, ds_Nhanvien);
        ds_NXB.loadFile();
        ds_Phieunhap.loadFile();
        ds_CTPNH.loadFile();
    }

    public void menuChinh(){}
}
