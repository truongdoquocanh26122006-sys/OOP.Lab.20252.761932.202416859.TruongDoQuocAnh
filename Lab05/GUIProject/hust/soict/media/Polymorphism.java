package hust.soict.media;
import java.util.ArrayList;
import hust.soict.media.*;
public class Polymorphism{
public static void main(String[] args) {
    ArrayList<Media> mediae = new ArrayList<Media>();

    // Tạo CD và thêm Track để có độ dài (Length)
    CompactDisc cd = new CompactDisc("Miu Le");
    cd.setTitle("Em la ba noi cua anh");
    cd.setCategory("Pop");
    cd.setCost(15.5f);
    // CD cần có track thì getLength() mới khác 0
    // Track t1 = new Track(...); cd.addTrack(t1); 

    // Tạo DVD với đầy đủ thông tin
    DigitalVideoDisc dvd = new DigitalVideoDisc("Director Name", "Sci-Fi", "Inception", 148, 24.99f);

    // Tạo Book và thêm tác giả
    Book buk = new Book();
    buk.setTitle("Dac Nhan Tam");
    buk.setCategory("Self-help");
    buk.addAuthor("Dale Carnegie");

    mediae.add(cd);
    mediae.add(dvd);
    mediae.add(buk);

    for(Media m : mediae){
        System.out.println(m.toString());
        System.out.println("-------------------");
    }
}}