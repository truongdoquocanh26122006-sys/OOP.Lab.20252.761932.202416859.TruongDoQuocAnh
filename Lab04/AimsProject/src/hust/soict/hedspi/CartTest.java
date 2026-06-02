package hust.soict.hedspi;
import hust.soict.media.DigitalVideoDisc;
public class CartTest{
    public static void main(String[] args) {
        Cart cart=new Cart();
		DigitalVideoDisc dvd1= new DigitalVideoDisc("The Lion King","Animation","Roger Allers",87,19.95f);
		cart.addMedia(dvd1);
		DigitalVideoDisc dvd2=new DigitalVideoDisc("Star Wars","Science Fiction","George Lucas",87,24.95f);
		cart.addMedia(dvd2);
		DigitalVideoDisc dvd3=new DigitalVideoDisc("Aladin","Animation",18.99f);
		cart.addMedia(dvd3);
        System.out.println("Viewcart goc:");
        cart.viewCart();
        // cart.searchById(2);
        // cart.searchById(67);
        // cart.searchByTitle("Aladin");
        // cart.searchByTitle("Doraemon");
        cart.sortByTitleCost();
        System.out.println("Viewcart sau khi sort theo title:");
        cart.viewCart();
    }
}