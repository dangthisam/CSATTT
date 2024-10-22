import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.sql.SQLOutput;
import java.util.*;

public class ThiSinh {
    private String ma;
  private String ten;
  private int d1,d2,d3;
  private int rank;
private  static int cnt=1;
    public ThiSinh(int ma,String ten, int d1, int d2, int d3) {
        this.ma="SV"+String.format("%02d", cnt++);
        this.ten = ten;
        this.d1 = d1;
        this.d2 = d2;
        this.d3 = d3;
    }

    public String getTen() {
        return ten;
    }

    public void setTen(String ten) {
        this.ten = ten;
    }

    public int getD1() {
        return d1;
    }

    public void setD1(int d1) {
        this.d1 = d1;
    }

    public int getD2() {
        return d2;
    }

    public void setD2(int d2) {
        this.d2 = d2;
    }

    public int getD3() {
        return d3;
    }

    public void setD3(int d3) {
        this.d3 = d3;
    }

   public  double getTrungBinh(){
        double diem=0;

      diem+=(double) (this.d1*3+this.d2*3+this.d3*2)/8;
        return diem;
   }
   public  void chuanHoaTen(){
        String []s=this.ten.trim().split("\\s+");
        String res="";
        for(int i=0;i<s.length;i++){
            res+=s[i].toUpperCase().charAt(0);
            for(int j=1;j<s[i].length();j++){
                res+=s[i].toLowerCase().charAt(j);
            }
            res+=" ";
        }
        this.ten=res.trim();
   }
   public int setRank(int rank){
        return  this.rank=rank;
   }
   public int getRank(){
        return this.rank;
   }
   public String toString(){
        return this.ma+" "+this.ten+" "+String.format("%.2f", this.getTrungBinh())+" "+this.rank;
   }


    public static void main(String[] args) throws FileNotFoundException {
        Scanner sc=new Scanner(new File("BANGDIEM.in"));
        int n=Integer.parseInt(sc.nextLine());
        ArrayList<ThiSinh>arr=new ArrayList<>();

        for(int i=1;i<=n;i++){
                String ten=sc.nextLine();
                int d1=Integer.parseInt(sc.nextLine());
            int d2=Integer.parseInt(sc.nextLine());
            int d3=Integer.parseInt(sc.nextLine());
            ThiSinh ts=new ThiSinh(i, ten, d1,d2,d3);
            ts.chuanHoaTen();
            arr.add(ts);
        }
        Collections.sort(arr, new Comparator<ThiSinh>() {
            @Override
            public int compare(ThiSinh o1, ThiSinh o2) {
               if(o1.getTrungBinh()!=o2.getTrungBinh()){
                   if(o1.getTrungBinh()>o2.getTrungBinh()){
                       return -1;
                   }

               }
        return 1;
            }
        });

        arr.get(0).setRank(1);
        System.out.println(arr.get(0));
        for(int i=1;i<arr.size();i++){
            if(arr.get(i).getTrungBinh()==arr.get(i-1).getTrungBinh()){
                int x=arr.get(i-1).getRank();
                arr.get(i).setRank(x);
                System.out.println(arr.get(i));
            }else{
                arr.get(i).setRank(i+1);
                System.out.println(arr.get(i));
            }
        }
    }
}
