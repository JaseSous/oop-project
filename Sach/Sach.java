package Sach;

import java.util.Scanner;

public abstract class Sach {
    Scanner sc = new Scanner(System.in);
    
    // Thuoc tinh
    private String masach, tensach, matheloai, matg, manxb;
    private int soluong, gia;

    // Constructor
    public Sach(){
        masach = "";
        tensach = "";
        matheloai = "";
        matg = "";
        manxb = "";

        soluong = 0;
        gia = 0;
    }

    public Sach(String masach, String tensach, String matheloai, String matg, String manxb, int soluong, int gia){
        this.masach = masach;
        this.tensach = tensach;
        this.matheloai = matheloai;
        this.matg = matg;
        this.manxb = manxb;

        this.soluong = soluong;
        this.gia = gia;
    }

    public Sach(Sach other){
        this.masach = other.masach;
        this.tensach = other.tensach;
        this.matheloai = other.matheloai;
        this.matg = other.matg;
        this.manxb = other.manxb;

        this.soluong = other.soluong;
        this.gia = other.gia;
    }

    // Get/set
    public String getMasach(){
        return masach;
    }

    public String getTensach(){
        return tensach;
    }

    public String getMatheloai(){
        return matheloai;
    }

    public String getMatg(){
        return matg;
    }

    public String getManxb(){
        return manxb;
    }

    public int getSoluong(){
        return soluong;
    }

    public int getGia(){
        return gia;
    }

    public void setMasach(String masach){
        this.masach = masach;
    }

    public void setTensach(String tensach){
        this.tensach = tensach;
    }

    public void setMatheloai(String matheloai){
        this.matheloai = matheloai;
    }

    public void setMatg(String matg){
        this.matg = matg;
    }

    public void setManxb(String manxb){
        this.manxb = manxb;
    }

    public void setSoluong(int soluong){
        this.soluong = soluong;
    }

    public void setGia(int gia){
        this.gia = gia;
    }

    public abstract String getLoaiSach();

    // Phương thức
    public void nhap(){
        System.out.print("\tMã sách: "); masach = sc.nextLine();
        System.out.print("\tTên sách: "); tensach = sc.nextLine();
        System.out.print("\tMã thể loại: "); matheloai = sc.nextLine();
        System.out.print("\tMã tác giả: "); matg = sc.nextLine();
        System.out.print("\tMã nhà xuất bản: "); manxb = sc.nextLine();
        System.out.print("\tSố lượng: "); soluong = sc.nextInt(); sc.nextLine();
        System.out.print("\tGiá: "); gia = sc.nextInt(); sc.nextLine();
    }

    public void xuat(){
        System.out.printf("| %-7s | %-35s | %-11s | %-10s | %-6s | %-8s | %-9s ",
                            getMasach(),
                            getTensach(),
                            getMatheloai(),
                            getMatg(),
                            getManxb(),
                            getSoluong(),
                            getGia() + " ₫");
    }

    public void sua(){
        boolean running = true;
        int choice;
        while (running){
            System.out.println("===[Chỉnh sửa thông tin sách có mã " + this.getMasach() + "]===");
            System.out.println("1. Tên sách: " + tensach);
            System.out.println("2. Mã thể loại: " + matheloai);
            System.out.println("3. Mã tác giả: " + matg);
            System.out.println("4. Mã nhà xuất bản: " + manxb);
            System.out.println("5. Số lượng: " + soluong);
            System.out.println("6. Giá: " + gia);
            System.out.println("0. Thoát");

            System.out.print("\nHãy nhập số của thông tin cần sửa hoặc thoát (0-6): ");

            // Kiểm tra hợp lệ
            while (true){
                try{
                    choice = Integer.parseInt(sc.nextLine().trim());
                    if (choice < 0 || choice > 6)
                        System.out.print("Vui lòng nhập số từ khoảng 0-6: ");
                    else
                        break;
                }
                catch (NumberFormatException e){
                    System.out.print("Hãy nhập số hợp lệ: ");
                }
            }

            switch(choice){
                case 1:
                    System.out.print("Bạn đang thay đổi tên sách: " + this.getTensach() + " --> "); String tensachmoi = sc.nextLine().trim();
                    this.setTensach(tensachmoi);
                    break;
                case 2:
                    System.out.print("Bạn đang thay đổi mã thể loại: " + this.getMatheloai() + " --> "); String matlmoi = sc.nextLine().trim();
                    this.setMatheloai(matlmoi);
                    break;
                case 3:
                    System.out.print("Bạn đang thay đổi mã tác giả: " + this.getMatg() + " --> "); String matgmoi = sc.nextLine().trim();
                    this.setMatg(matgmoi);
                    break;
                case 4:
                    System.out.print("Bạn đang thay đổi mã nhà xuất bản: " + this.getManxb() + " --> "); String manxbmoi = sc.nextLine().trim();
                    this.setManxb(manxbmoi);
                    break;
                case 5:
                    System.out.print("Bạn đang thay đổi số lượng: " + this.getSoluong() + " --> "); int soluongmoi = Integer.parseInt(sc.nextLine().trim());
                    this.setSoluong(soluongmoi);;
                    break;
                case 6:
                    System.out.print("Bạn đang thay đổi giá: " + this.getGia() + " --> "); int giamoi = Integer.parseInt(sc.nextLine().trim());
                    this.setGia(giamoi);
                    break;
                case 0:
                    System.out.println("Đang thoát menu sửa thông tin sách...");
                    running = false;
                    break;
                default:
                    System.out.println("Số không hợp lệ");
                    break;
            }
        }
    }
}