package hust.soict.hedspi.aims;
import javax.swing.JOptionPane;
import hust.soict.media.Media;
import java.util.Collections;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import hust.soict.hedspi.aims.exception.LimitExceededException;
public class Cart{
private static final int MAX_NUMBERS_ORDERED = 20;
private ObservableList<Media> itemsOrdered = FXCollections.observableArrayList();

public void addMedia(Media mail) throws LimitExceededException {
    if(itemsOrdered.size() >= MAX_NUMBERS_ORDERED) {
        throw new LimitExceededException("ERROR: The number of media has reached its limit");
    }
    if(itemsOrdered.contains(mail)){
        System.out.println("Da ton tai media nay");
    } else {
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
public ObservableList<Media> getItemsOrdered() {
    return itemsOrdered;
}
}

//alo alo alo 123}