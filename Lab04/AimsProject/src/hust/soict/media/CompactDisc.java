package hust.soict.media;
import java.util.ArrayList;
public class CompactDisc extends Disc implements Playable{
    private String artist;
    private ArrayList<Track> tracks=new ArrayList<Track>();
    public String getArtist(){
        return artist;
    }
    public CompactDisc(String artist){
        super();
        this.artist=artist;
    }
    public void addTrack(Track newtrack){
        if(!tracks.contains(newtrack)){
            tracks.add(newtrack);
            System.out.println("Da them newtrack");
        }
        else{
            System.out.println("Da ton tai track");
        }
    }
    public void removeTrack(Track track){
        if(tracks.contains(track)){
            tracks.remove(track);
            System.out.println("Da xoa track");
        }
        else{
            System.out.println("Khong tim thay track");
        }
    }
    public int getLength(){
        int sum=0;
        for(Track p:tracks){
            sum+=p.getLength();
        }
        return sum;
    }
    public void play(){
        if(getLength()!=0){
        System.out.println("Playing CD: "+getTitle()+"\nArtist name: "+this.getArtist());
        for(Track p:tracks){
            p.play();
        }}
        else{
            System.out.println("This CD can't not be played");
        }
    }
    public String toString(){
        return "CD - "+this.getTitle()+"\nCategory: "+this.getCategory()+"\nArtist: "+this.getArtist()+"\nDirector: "+this.getDirector()+"\nLength: "+this.getLength()+"\nCost: "+this.getCost()+"$";
    }
    
}
