package hust.soict.hedspi;
import javax.swing.JOptionPane;
import java.util.ArrayList;
import hust.soict.media.Media;
import java.util.Collections;
public class Cart{
private ArrayList<Media> itemsOrdered=new ArrayList<Media>();
public void addMedia(Media mail){
if(itemsOrdered.contains(mail)){
	System.out.println("Da ton tai media nay");
}
else{
	itemsOrdered.add(mail);
	System.out.println("Da add media");
}

}
public void removeMedia(Media mail){
if(itemsOrdered.contains(mail)){
	itemsOrdered.remove(mail);
	System.out.println("Da xoa media");
}
else{
	System.out.println("Khong tim thay media de xoa");
}
}
public float totalCost() {
float sum=0;
for(Media p:itemsOrdered)
{
	sum+=p.getCost();
}
return sum;
}
public void viewCart(){
System.out.println("***********************CART***********************");
int i=1;
for(Media p:itemsOrdered){
	System.out.println(i+". "+p.toString());
	i++;
}
System.out.println("Total cost: "+ totalCost());
System.out.println("**************************************************");
}

//Tìm theo ID
public Media searchById(int id) {
for (Media p:itemsOrdered) {
	if (p.getId() == id) { 
		return p;
	}
}
return null;
}

// Tìm theo Title
public Media searchByTitle(String title) {
for (Media mail:itemsOrdered) {
	if (title.equals(mail.getTitle())) { 
		return mail;
	}
}
return null;
}
public void sortByTitleCost(){
	Collections.sort(itemsOrdered,Media.COMPARE_BY_TITLE_COST);
	System.out.println("Da sort theo title");
}
public void sortByCostTitle(){
	Collections.sort(itemsOrdered,Media.COMPARE_BY_COST_TITLE); 
	System.out.println("Da sort theo Cost");
}
}

//alo alo alo 123}