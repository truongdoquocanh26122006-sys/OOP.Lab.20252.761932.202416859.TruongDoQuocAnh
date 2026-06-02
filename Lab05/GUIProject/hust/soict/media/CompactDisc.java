package hust.soict.media;
import java.util.ArrayList;
import hust.soict.hedspi.aims.exception.PlayerException;
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
    public void play() throws PlayerException {
        if(getLength() > 0){
            System.out.println("Playing CD: "+getTitle()+"\nArtist name: "+this.getArtist());
            java.util.Iterator<Track> iter = tracks.iterator();
            Track nextTrack;
            while(iter.hasNext()){
                nextTrack = iter.next();
                try {
                    nextTrack.play();
                } catch(PlayerException e) {
                    throw e;
                }
            }
        } else {
            System.err.println("ERROR: CD length is non-positive!");
            throw new PlayerException("ERROR: CD length is non-positive!");
        }
    }
    public String toString(){
        return "CD - "+this.getTitle()+"\nCategory: "+this.getCategory()+"\nArtist: "+this.getArtist()+"\nDirector: "+this.getDirector()+"\nLength: "+this.getLength()+"\nCost: "+this.getCost()+"$";
    }
    
}
