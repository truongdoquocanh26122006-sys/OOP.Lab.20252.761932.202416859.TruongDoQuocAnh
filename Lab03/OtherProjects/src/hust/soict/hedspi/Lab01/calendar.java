import java.time.Month;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeFormatterBuilder;
import java.util.Locale;
import java.time.temporal.ChronoField;
import java.util.Scanner;
public class calendar {
    public static boolean isLeapYear(int year)
    {
        if(year%4==0)
        {
            if(year%100==0&&year%400!=0)
                return true;
        }
        return false;
    }
    public static int returnDay(int month)
    {
        if(month<=7)
        {
            if(month%2==0) return 30;
            return 31;
        }
        if(month>=8)
        {
            if(month%2==0) return 31;
            return 30;
        }
        return 67;
    }

    public static int parseMonth(String input) {
        input = input.trim();
        
        // Nếu là số (1, 01, 2...), xử lý luôn cho nhanh
        if (input.matches("\\d+")) {
            int m = Integer.parseInt(input);
            return (m >= 1 && m <= 12) ? m : -1;
        }

        // Nếu là chữ (Jan, Jan., January), dùng Formatter
        try {
            DateTimeFormatter fmt = new DateTimeFormatterBuilder()
                .appendPattern("[MMMM][MMM][MMM.]") // Chấp nhận full name, viết tắt 3 chữ, hoặc có dấu chấm
                .toFormatter(Locale.ENGLISH);
            
            return Month.from(fmt.parse(input)).getValue();
        } catch (Exception e) {
            return -1;
        }
    }
    public static void main(String[] args) {
        System.out.println("Nhap nam");
        Scanner qa=new Scanner(System.in);
        int year=qa.nextInt();
        System.out.println("Nhap thang");
        qa.nextLine();
        String month=qa.nextLine();
        int monthED=parseMonth(month);
        if(monthED>12||monthED<0) System.out.println("Thang khong hop le");
        else if(isLeapYear(year))
        {
            if(monthED==2) System.out.println("Thang nay co 29 ngay");
            else
            {
                int day=returnDay(monthED);
                System.out.println("Thang nay co "+day+" ngay");
            }
        }
        else{
            if(monthED==2) System.out.println("Thang nay co 28 ngay");
            else{
                int day=returnDay(monthED);
                System.out.println("Thang nay co "+day+" ngay");
            }
        }
    }
}
