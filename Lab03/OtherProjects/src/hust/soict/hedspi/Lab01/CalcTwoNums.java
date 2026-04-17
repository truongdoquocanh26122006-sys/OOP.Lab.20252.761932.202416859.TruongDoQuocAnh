
import java.util.Scanner;
public class CalcTwoNums{
    public static double tong(double a,double b){
        return a+b;
    }
    public static double tich(double a,double b){
        return a*b;
    }
    public static double hieu(double a,double b){
        return a-b;
    }
    public static double thuong(double a,double b){
        return a/b;
    }
    public static void main(String[] args) {
        Scanner qa=new Scanner(System.in);
        double a,b;
        System.out.println("Nhap 2 so");
        a=qa.nextDouble();
        b=qa.nextDouble();
        System.out.println("Tong cua 2 so la: "+tong(a,b));
        System.out.println("Hieu cua 2 so la: "+hieu(a,b));
        System.out.println("Tich cua 2 so la: "+tich(a,b));
        if(b==0) System.out.println("b khong duoc phep bang 0");
        else
            System.out.println("Thuong cua 2 so la: "+thuong(a,b));

    }
}