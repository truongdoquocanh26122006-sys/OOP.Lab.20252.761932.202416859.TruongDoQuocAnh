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
public float totalCost() {
	float sum=0;
	for(int i=0;i<qtyOrdered;i++)
	{
		sum+=itemsOrdered[i].getCost();
	}
	return sum;
}
}
