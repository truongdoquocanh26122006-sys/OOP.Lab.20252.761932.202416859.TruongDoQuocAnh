package hust.soict.hedspi;
import javax.swing.JOptionPane;
public class Cart {
public static final int MAX_NUMBERS_ORDERED =20;
int qtyOrdered;
private DigitalVideoDisc itemsOrdered[]=new DigitalVideoDisc[MAX_NUMBERS_ORDERED];
public void addDigitalVideoDisc(DigitalVideoDisc disc) {
	itemsOrdered[qtyOrdered]=disc;
	qtyOrdered+=1;
	JOptionPane.showMessageDialog(null,"The disc has been added",null, JOptionPane.INFORMATION_MESSAGE);
	if(qtyOrdered==MAX_NUMBERS_ORDERED) JOptionPane.showMessageDialog(null, "The cart is almost full",null,JOptionPane.WARNING_MESSAGE);
}
public void removeDigitalVideoDisc(DigitalVideoDisc disc) {
	for(int i=0;i<qtyOrdered;i++)
	{
		if(itemsOrdered[i]==disc) {
			for(int j=i+1;j<qtyOrdered;j++)
			{
				itemsOrdered[j-1]=itemsOrdered[j];
			}
			qtyOrdered-=1;
		}
	}
}
public void addDigitalVideoDisc(DigitalVideoDisc[] dvdList) {
	int n=dvdList.length;
	int cur=qtyOrdered;
	if(cur+n>MAX_NUMBERS_ORDERED) {
		JOptionPane.showMessageDialog(null,"Limit exceeded");
	}
	else {
		for(int i=0;i<n;i++)
		{
			addDigitalVideoDisc(dvdList[i]);
		}
	}
}
public float totalCost() {
	float sum=0;
	for(int i=0;i<qtyOrdered;i++)
	{
		sum+=itemsOrdered[i].getCost();
	}
	return sum;
}
public void viewCart(){
	System.out.println("***********************CART***********************");
	for(int i=0;i<qtyOrdered;i++){
		System.out.println(i+1+". "+itemsOrdered[i].toString());
	}
	System.out.println("Total cost: "+ totalCost());
	System.out.println("**************************************************");
}
//Tìm theo ID
public void searchById(int id) {
    boolean found = false;
    for (int i = 0; i < qtyOrdered; i++) {
        if (itemsOrdered[i].getId() == id) { 
            System.out.println("Found: " + itemsOrdered[i].toString());
            found = true;
            break;
        }
    }
    if (!found) System.out.println("No DVD with ID " + id + " found."); 
}

// Tìm theo Title
public void searchByTitle(String title) {
    boolean found = false;
    for (int i = 0; i < qtyOrdered; i++) {
        if (title.equals(itemsOrdered[i].getTitle())) { 
            System.out.println("Found: " + itemsOrdered[i].toString());
            found = true;
            break;
        }
    }
    if (!found) System.out.println("No DVD with title " + title + " found."); 
}
}


//alo alo alo 123