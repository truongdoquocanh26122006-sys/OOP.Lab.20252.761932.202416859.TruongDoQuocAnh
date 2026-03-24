import java.util.Scanner;
 class linearEquation{
public static void main(String[] args) {
        System.out.println("Nhap he so: ");
        Scanner qa=new Scanner(System.in);
        double a=qa.nextDouble();
        double b=qa.nextDouble();
        double c=qa.nextDouble();
        System.out.println("Phuong trinh da nhap la: "+a+"x"+(b>0?("+"+b):b)+"="+c);
        if(a==0)
        {
            if(b!=c) System.out.println("Phuong trinh vo nghiem");
            else System.out.println("Phuong trinh co vo so nghiem");
        }
        else
        {
            if(b==0) System.out.println("x="+(c/a));
            else System.out.println("x="+((c-b)/a));
        }
        qa.close();
    }
}
class linearEquation_2v{
    public static void main(String[] args) {
        Scanner qa=new Scanner(System.in);
        System.out.println("Nhap he so");
    }
}
