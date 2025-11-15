package QuanLy;
import Sach.DS_Sach;
import Khachhang.DS_Khachhang;
import Nhanvien.DS_Nhanvien;
import Nhaphang.DanhsachCTPNH;
import Nhaphang.Danhsachphieunhap;
//import Hoadon.DS_Hoadon;


public class QLBH {
    protected static DS_Sach ds_Sach = new DS_Sach();
    protected static DS_Khachhang ds_Khachhang = new DS_Khachhang();
    protected static DS_Nhanvien ds_Nhanvien = new DS_Nhanvien();
    protected static DanhsachCTPNH ds_Ctpnh=new DanhsachCTPNH();
    protected static Danhsachphieunhap ds_phieunhap = new Danhsachphieunhap();
    //protected static DS_Hoadon ds_Hoadon = new DS_Hoadon();

    public void loadFile(){
        ds_Sach.loadFile();
        ds_Khachhang.loadFile();
        ds_Nhanvien.loadFile();
        ds_phieunhap.loadFile();
        ds_Ctpnh.loadFile();
        //ds_Hoadon.loadFile(ds_Khachhang, ds_Nhanvien);
    }
    public void xem(){
        ds_Ctpnh.xem();
        ds_phieunhap.xem();
    }

    public void menuChinh(){}
public static void main(String[] args) {
    QLBH ql=new QuanlyPNH_CTPNH();
    ql.loadFile();
    ql.menuChinh();
}
}
