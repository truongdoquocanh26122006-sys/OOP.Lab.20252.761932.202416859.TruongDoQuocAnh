
package hust.soict.hedspi;
public class DigitalVideoDisc {
private String title;
private String category;
private String director;
private int length;
private float cost;
private static int nbDigitalVideoDiscs=0;
private int id;
public String getTitle() {
	return title;
}
public String getCategory() {
	return category;
}
public String getDirector() {
	return director;
}
public int getLength() {
	return length;
}
public float getCost() {
	return cost;
}
public int getId(){
	return id;
}
public void setTitle(String title){
	this.title=title;
}
public void setCategory(String category){
	this.category=category;
}
public void setDirector(String director){
	this.director=director;
}
public void setLength(int length){
	this.length=length;
}
public void setCost(float cost){
	this.cost=cost;
}
public DigitalVideoDisc(String title) {
	this.title=title;
	this.id=nbDigitalVideoDiscs;
	nbDigitalVideoDiscs+=1;
}
public DigitalVideoDisc(String title,String category,float cost) {
	this.category=category;
	this.title=title;
	this.cost=cost;
	this.id=nbDigitalVideoDiscs;
	nbDigitalVideoDiscs+=1;
}
public DigitalVideoDisc(String director,String category,String title,float cost) {
	this.director=director;
	this.category=category;
	this.title=title;
	this.cost=cost;
	this.id=nbDigitalVideoDiscs;
	nbDigitalVideoDiscs+=1;
}
public DigitalVideoDisc(String title,String category,String director,int length,float cost) {
	this.director=director;
	this.category=category;
	this.title=title;
	this.cost=cost;
	this.length=length;
	this.id=nbDigitalVideoDiscs;
	nbDigitalVideoDiscs+=1;
}
public String toString()
{	String rt="DVD - ";
	rt=rt+getTitle()+" - "+getCategory()+" - "+getDirector()+" - "+getLength()+": "+getCost()+"$";
	return rt;
}
}
