
import java.util.Scanner;
import java.util.Arrays;
public class ArrayProccessing {
    public static void main(String args[]){
        /*
        System.out.println("Nhap so luong phan tu cua mang");
        int n=new Scanner(System.in).nextInt();
        int []array=new int[n]; 
        for(int i=0;i<n;i++)
        {
            array[i]=qa.nextInt();
        }
         */
        int array[]={100,69,67,36,18,36,36}; //neu chon tu nhap mang thi bo dong nay di
        System.out.println("Chuoi ban dau la: "+Arrays.toString(array));
        Arrays.sort(array);
        System.out.println("Chuoi sau khi sort la: "+Arrays.toString(array));
        int sum=0;
        for(int i=0;i<array.length;i++)
        {
            sum+=array[i];
        }
        System.out.println("Tong cua chuoi la: "+sum);
        double Sum=sum;
        System.out.println("Trung binh cong cua chuoi la: "+(Sum)/array.length);
    }
    
}
