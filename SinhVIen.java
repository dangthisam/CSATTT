import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;

public class SinhVIen {
    private String ma;
    private String hoTen, ngaySinh;
    private double diemLt, diemTh;
    private static int cnt=1;
    public SinhVIen(int ma, String hoTen, String ngaySinh, double diemLt, double diemTh) {
        this.ma="PH"+String.format("%02d", cnt++);
        this.hoTen = hoTen;
        this.ngaySinh = ngaySinh;
        this.diemLt = diemLt;
        this.diemTh = diemTh;
    }



    public void setDiemTh(double diemTh) {
        this.diemTh = diemTh;
    }

    public void chuanHoaTen() {
        String[] tenn = this.hoTen.trim().split("\\s+");
        String res = "";
        for (int i = 0; i < tenn.length; i++) {
            res += tenn[i].toUpperCase().charAt(0);
            for (int j = 1; j < tenn[i].length(); j++) {
                res += tenn[i].toLowerCase().charAt(j);
            }
            res += " ";


        }
        this.hoTen=res.trim();
    }

    public double diemTHuong(){
        double diem=0.0;
        if(this.diemLt>=8&&diemTh>=8) diem+=1.0;
        else if(this.diemTh>=7.5&&diemLt>=7.5)diem+=0.5;
        else diem+=0.0;
        return diem;
    }
    public double score(){
        double diem=0.0;
        diem+=((this.diemLt+this.diemTh)/2)+this.diemTHuong();
        diem=Math.min(10, Math.round(diem));
        return diem;
    }
    public String status(){
        String res="";
        if(this.score()==10||this.score()==9){
            res="Xuat sac";
        }
        else if(this.score()==8) res="Gioi";
        else if(this.score()==7)res="Kha";
        else if(this.score()==5||this.score()==6)res="Trung binh";
        else res="Truot";
        return res;
    }
    public int tuoi(){
        int tuoi=0;
        String []ss=this.ngaySinh.trim().split("/");
        int nam=Integer.parseInt(ss[2]);
        tuoi+=2021-nam;
        return tuoi;
    }
    public String toString(){
        return this.ma+" "+this.hoTen+" "+this.tuoi()+" "+String.format("%.0f", this.score())+" "+this.status();
    }

    public static void main(String[] args) throws FileNotFoundException {
        Scanner sc=new Scanner(new File("BANGDIEM.in"));
        int n=Integer.parseInt(sc.nextLine());
        ArrayList<SinhVIen>arr=new ArrayList<>();

        for(int i=1;i<=n;i++){
            String ten=sc.nextLine();
            String ngaySinh=sc.nextLine();
            double diemlt=Double.parseDouble(sc.nextLine());
            double diemth=Double.parseDouble(sc.nextLine());
            SinhVIen ts=new SinhVIen(i, ten, ngaySinh, diemlt,diemth);

            ts.chuanHoaTen();
            ts.score();
            ts.status();
            ts.tuoi();
            arr.add(ts);
        }
        for(SinhVIen ts:arr){
            System.out.println(ts);
        }

    }
}
