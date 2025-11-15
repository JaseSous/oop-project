package QuanLy;

import Nhaphang.DanhsachCTPNH;
import Nhaphang.Danhsachphieunhap;
//import Hoadon.DS_Hoadon;


public class QLBH {

    protected static DanhsachCTPNH ds_CTPNH=new DanhsachCTPNH();
    protected static Danhsachphieunhap ds_phieunhap = new Danhsachphieunhap();
    //protected static DS_Hoadon ds_Hoadon = new DS_Hoadon();

    public void loadFile(){

        ds_phieunhap.loadFile();
        ds_CTPNH.loadFile();
        //ds_Hoadon.loadFile(ds_Khachhang, ds_Nhanvien);
    }

    public void menuChinh(){}
public static void main(String[] args) {
    QLBH ql=new QuanlyPNH_CTPNH();
    ql.loadFile();
    ql.menuChinh();
}
}
