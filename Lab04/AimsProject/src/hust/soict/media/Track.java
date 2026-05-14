package hust.soict.media;

public class Track implements Playable{
    private String title;
    private int length;
    public String getTitle(){
        return title;
    }
    public int getLength(){
        return length;
    }
    public Track(){
        title=null;
        length=0;
    }
    public void play(){
        if(getLength()!=0){
        System.out.println("Playing track: "+this.getTitle());
        System.out.println("Track length: "+this.getLength());}
        else{
            System.out.println("This track can't not be played");
        }
    }
    public boolean equals (Object o){
        if(!(o instanceof Track)){
            return false;
        }
        Track qa=(Track) o;
        if(this.getTitle()==qa.getTitle()&&this.getLength()==qa.getLength()){
            return true;
        }
        return false;
    }
    
}
