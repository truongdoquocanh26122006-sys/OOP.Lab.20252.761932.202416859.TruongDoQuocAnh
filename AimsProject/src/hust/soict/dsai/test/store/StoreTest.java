package hust.soict.dsai.test.store;
import hust.soict.dsai.aims.store.Store;
import hust.soict.dsai.aims.disc.DigitalVideoDisc;
public class StoreTest {
    public static void main(String[] args) {
        Store store = new Store();

        DigitalVideoDisc dvd1 = new DigitalVideoDisc("The Lion King", "Animation", "Roger Allers", 87, 19.95f);
        DigitalVideoDisc dvd2 = new DigitalVideoDisc("Star Wars", "Science Fiction", "George Lucas", 87, 24.95f);
        DigitalVideoDisc dvd3= new DigitalVideoDisc(null);
        // Test thêm đĩa 
        store.addDVD(dvd1);
        store.addDVD(dvd2);

        // Test xóa đĩa 
        store.removeDVD(dvd1);
        store.removeDVD(dvd2);
        store.removeDVD(dvd3);
    }
}

