package QuanLy;
import Sach.DS_Sach;
import Hoadon.DanhsachChiTietHoaDon;
import Hoadon.Danhsachhoadon;
import Khachhang.DS_Khachhang;
import Nhanvien.DS_Nhanvien;
//import Hoadon.DS_Hoadon;

public class QLBH {
    protected static DS_Sach ds_Sach = new DS_Sach();
    protected static DS_Khachhang ds_Khachhang = new DS_Khachhang();
    protected static DS_Nhanvien ds_Nhanvien = new DS_Nhanvien();
    protected static Danhsachhoadon ds_HD = new Danhsachhoadon();
    protected static DanhsachChiTietHoaDon ds_CTHD_Tong = new DanhsachChiTietHoaDon();

    public void loadFile(){
        ds_Sach.loadFile();
        ds_Khachhang.loadFile();
        ds_Nhanvien.loadFile();
        ds_HD.loadFile(ds_Khachhang, ds_Nhanvien);
        ds_CTHD_Tong.loadFile();
    }

    public void menuChinh(){}
}
