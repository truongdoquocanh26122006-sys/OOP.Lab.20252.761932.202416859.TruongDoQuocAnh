
import java.util.Scanner;
public class AddMatrices {
    public static void main(String args[]){
        System.out.println("Nhap so hang va so cot cho 2 ma tran");
        int hang=new Scanner(System.in).nextInt();
        int cot=new Scanner(System.in).nextInt();
        double [][]mat1=new double[hang][cot];
        double [][]mat2=new double[hang][cot];
        System.out.println("Nhap so cho ma tran 1 va 2");
        Scanner qa=new Scanner(System.in);
        qa.nextLine();
        for(int i=0;i<hang;i++)
        {
            for(int j=0;j<cot;j++)
            {
                mat1[i][j]=qa.nextDouble();
            }
        }
        for(int i=0;i<hang;i++)
        {
            for(int j=0;j<cot;j++)
            {
                mat2[i][j]=qa.nextDouble();
            }
        }
        qa.close();
        double [][]matResult=new double[hang][cot];
        for(int i=0;i<hang;i++)
        {
            for(int j=0;j<cot;j++)
            {
                matResult[i][j]=mat1[i][j]+mat2[i][j];
            }
        }
        System.out.println("Ma tran tong: ");
        for(int i=0;i<hang;i++)
        {
            for(int j=0;j<cot;j++)
            {
                System.out.printf("%f ",matResult[i][j]);
            }
            System.out.println();
        }
    }
    
}
