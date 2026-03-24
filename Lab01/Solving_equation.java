package Lab01;
import java.util.Scanner;
public class Solving_equation{
    public static void main(String[] args) {
        Scanner qa=new Scanner(System.in);
        int cmd=new Scanner(System.in).nextInt();
        if(cmd==1)
        {
            System.out.println("Giai phuong trinh bac nhat 1 an");
            System.out.println("Nhap he so:");
            double a=qa.nextDouble();
            double b=qa.nextDouble();
            double c=qa.nextDouble();
            System.out.println("Phuong trinh da nhap la: "+a+"x"+(b>0?("+"+b):b)+"="+c);
            System.out.println(giaihe1anbacnhat(a,b,c));
        }
        else if(cmd==2)
        {
            System.out.println("Giai phuong trinh bac nhat 2 an");
            System.out.println("Nhap he so:");
            double a11=qa.nextDouble();
            double a12=qa.nextDouble();
            double b1=qa.nextDouble();
            double a21=qa.nextDouble();
            double a22=qa.nextDouble();
            double b2=qa.nextDouble();
            System.out.println("Phuong trinh da nhap la: "+a11+"x+"+a12+"y="+b1+"; "+a21+"x+"+a22+"y="+b2);
            System.out.println(giaihe2an(a11, a11, b1, a21, a22, b2));
        }
        else if(cmd==3)
        {
            System.out.println("Giai he phuong trinh bac 2");
            System.out.println("Nhap he so");
            double a,b,c;
            a=qa.nextDouble();
            b=qa.nextDouble();
            c=qa.nextDouble();
            System.out.println("Phuong trinh da nhap la: "+a+"x^2+"+b+"x+"+c+"=0");
            System.out.println(giaihe1anbac2(a,b,c));
        }
    }
    public static String giaihe1anbacnhat(double a,double b,double c)
    {   String toreturn;
        if(a==0)
        {
            if(b!=c) toreturn=("Phuong trinh vo nghiem");
            else toreturn=("Phuong trinh co vo so nghiem");
        }
        else
        {
            if(b==0) toreturn=("x="+(c/a));
            else toreturn=("x="+((c-b)/a));
        }
        return toreturn;
    }
    public static String giaihe2an(double a11,double a12,double b1,double a21,double a22,double b2)
    {
        String toreturn;
        double D=(a11*a22-a21*a12);
        double D1=b1*a22-b2*a12;
        double D2=a11*b2-b1*a21;
        if(D==0) 
        {
            if(D1==0&&D2==0) toreturn=("Phuong trinh vo so nghiem");
            else toreturn=("Phuong trinh vo nghiem");
        }
        else{
            double x=D1/D;
            double y=D2/D;
            toreturn=("x="+x);
            toreturn+=("y="+y);
        }
        return toreturn;
    }
    public static String giaihe1anbac2(double a,double b,double c){
        String toreturn;
        if (a==0) 
            return giaihe1anbacnhat(b, c, 0);
        else {
            double delta=b*b-4*a*c;
            if(delta==0)
            {
                double nghiem=-b/2/a;
                toreturn=("Nghiep kep cua phuong trinh la: "+"x="+nghiem);
                return toreturn;
            }
            else if(delta<0)
            {
                toreturn="Phuong trinh vo nghiem";
            }
            else if(delta>0)
            {
                double qa=Math.sqrt(delta);
                double nghiem1=(-b+qa)/2/a;
                double nghiem2=(-b-qa)/2/a;
                toreturn=("Phuong trinh co 2 nghiem la: "+"x1="+nghiem1+";"+"x2="+nghiem2);
            }
        }
    }
}

