package hust.soict.media;
public class Disc extends Media{
    private int length;
    private String director;
    public int getLength(){
        return length;
    }
    public String getDirector(){
        return director;
    }
    public void setLength(int length){
        this.length=length;
    }
    public void setDirector(String director){
        this.director=director;
    }
    public Disc(int length,String director){
        super();
        this.length=length;
        this.director=director;
    }
    public Disc(){
        super();
        length=0;
        director=null;
    }
    public Disc(int length){
         this(length,null);
    }
    public Disc(String director){
        this(0,director);
    }
}