import java.util.Scanner;

public class ThuNhap {
    private String ma, ten;
    private int luongCoBan;

    public ThuNhap(String ma, String ten, int luongCoBan) {
        this.ma = ma;
        this.ten = ten;
        this.luongCoBan = luongCoBan;
    }

    public String getMa() {
        return ma;
    }

    public void setMa(String ma) {
        this.ma = ma;
    }

    public String getTen() {
        return ten;
    }

    public void setTen(String ten) {
        this.ten = ten;
    }

    public int getLuongCoBan() {
        return luongCoBan;
    }

    public void setLuongCoBan(int luongCoBan) {
        this.luongCoBan = luongCoBan;
    }
    public int heso(){
        String s=this.ma;
        int res=0;
        res+=Integer.parseInt(this.ma.substring(2));
        return res;
    }
    public  int phuCap(){
        int ok=0;
       if(this.ma.substring(0,2).equals("HT"))ok+=2000000;
       else if(this.ma.substring(0,2).equals("HP"))ok+=900000;
       else ok+=500000;
        return  ok;

    }
    public int thuNhap(){
        return this.luongCoBan*this.heso()+this.phuCap();
    }

    public String toString(){
        return this.ma+" "+this.ten+" "+this.heso()+" "+this.phuCap()+" "+this.thuNhap();
    }

    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        String ma=sc.nextLine();
        String ten=sc.nextLine();
        int luong=sc.nextInt();
        ThuNhap tn=new ThuNhap(ma, ten, luong);
        System.out.println(tn);
    }
}
