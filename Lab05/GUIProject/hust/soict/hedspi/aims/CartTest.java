package hust.soict.hedspi.aims;
import hust.soict.media.DigitalVideoDisc;
import hust.soict.hedspi.aims.exception.LimitExceededException;
public class CartTest{
    public static void main(String[] args) {
        Cart cart=new Cart();
        try {
            DigitalVideoDisc dvd1= new DigitalVideoDisc("The Lion King","Animation","Roger Allers",87,19.95f);
            cart.addMedia(dvd1);
            DigitalVideoDisc dvd2=new DigitalVideoDisc("Star Wars","Science Fiction","George Lucas",87,24.95f);
            cart.addMedia(dvd2);
            DigitalVideoDisc dvd3=new DigitalVideoDisc("Aladin","Animation",18.99f);
            cart.addMedia(dvd3);
        } catch (LimitExceededException e) {
            System.out.println(e.getMessage());
        }
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