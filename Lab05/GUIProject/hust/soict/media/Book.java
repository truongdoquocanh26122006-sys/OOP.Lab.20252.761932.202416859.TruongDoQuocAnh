package hust.soict.media;
import java.util.ArrayList;
public class Book extends Media{
    private ArrayList<String> authors =new ArrayList<String>();
    public Book(){}
    public ArrayList<String> getAuthors(){
        return authors;
    }
    public void addAuthor(String authorName){
        if(!authors.contains(authorName)){
            authors.add(authorName);
            System.out.println("Da them author");
        }
        else{
            System.out.println("Da ton tai author");
        }
    }
    public void removeAuthor(String authorName){
        if(authors.contains(authorName)){
            authors.remove(authorName);
            System.out.println("Da xoa author");
        }
        else{
            System.out.println("Khong tim thay author");
        }
    }
    public String toString(){
        return "Book - "+this.getTitle()+"\nCategory: "+this.getCategory()+ "\nAuthorList: "+this.getAuthors();
    }
}
