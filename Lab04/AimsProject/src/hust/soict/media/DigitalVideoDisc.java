package hust.soict.media;
public class DigitalVideoDisc extends Disc implements Playable{
private static int nbDigitalVideoDiscs=0;
public DigitalVideoDisc(String title) {
	this.setTitle(title);
	this.setId(nbDigitalVideoDiscs);
	nbDigitalVideoDiscs+=1;
}
public DigitalVideoDisc(String title,String category,float cost) {
	this.setCategory(category);
	this.setTitle(title);
	this.setCost(cost);
	this.setId(nbDigitalVideoDiscs);
	nbDigitalVideoDiscs+=1;
}
public DigitalVideoDisc(String director,String category,String title,float cost) {
	super(director);
	this.setTitle(title);
	this.setCost(cost);
	this.setId(nbDigitalVideoDiscs);
	nbDigitalVideoDiscs+=1;
}
public DigitalVideoDisc(String title,String category,String director,int length,float cost) {
	super(length,director);
	this.setCategory(category);
	this.setTitle(title);
	this.setCost(cost);
	this.setId(nbDigitalVideoDiscs);
	nbDigitalVideoDiscs+=1;
}
public String toString()
{	String rt="DVD - ";
	rt=rt+getTitle()+"\nCategory: "+getCategory()+"\nDirector: "+getDirector()+"\nLength: "+getLength()+"\nCost: "+getCost()+"$";
	return rt;
}
public void play(){
	if(this.getLength()!=0){
	System.out.println("Playing DVD: "+ this.getTitle());
	System.out.println("DVD length: "+this.getLength());}
	else{
		System.out.println("This DVD can't be played");
	}
}
}
