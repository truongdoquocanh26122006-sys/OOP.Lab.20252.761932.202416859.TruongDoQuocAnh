package hust.soict.hedspi.aims.screen;
import java.util.ArrayList;
import java.awt.*;
import javax.swing.*;
import java.awt.event.*;

import hust.soict.hedspi.aims.Cart;
import hust.soict.hedspi.aims.Store;
import hust.soict.media.*;
public class StoreScreen extends JFrame{
    private Store store;
    private Cart cart;
    JPanel createNorth(){
        JPanel north= new JPanel();
        north.setLayout(new BoxLayout(north, BoxLayout.Y_AXIS));
        north.add(createMenuBar());
        north.add(createHeader());
        return north;
    }
    JMenuBar createMenuBar(){
        JMenu menu= new JMenu("Options");
        JMenu smUpdateStore = new JMenu("Update Store");
        smUpdateStore.add( new JMenuItem("Add Book"));
        smUpdateStore.add(new JMenuItem("Add CD"));
        smUpdateStore.add(new JMenuItem("Add DVD"));

        menu.add(smUpdateStore);
        menu.add(new JMenuItem("View store"));
        menu.add(new JMenuItem("View Cart"));
        JMenuBar menuBar=new JMenuBar();
        menuBar.setLayout(new FlowLayout(FlowLayout.LEFT));
        menuBar.add(menu);
        return menuBar;
    }
    JPanel createHeader(){
        JPanel header= new JPanel();
        header.setLayout(new BoxLayout(header,BoxLayout.X_AXIS));
        JLabel title= new JLabel("AIMS");
        title.setFont(new Font(title.getFont().getName(),Font.PLAIN,50));
        title.setForeground(Color.CYAN);

        JButton cart= new JButton("View cart");
        cart.setPreferredSize(new Dimension(100,50));
        cart.setMaximumSize(new Dimension(100,50));

        header.add(Box.createRigidArea(new Dimension(10,10)));
        header.add(title);
        header.add(Box.createHorizontalGlue());
        header.add(cart);
        header.add(Box.createRigidArea(new Dimension(10,10)));
        return header;
    }

    JPanel createCenter() {
        JPanel center = new JPanel();
        center.setLayout(new GridLayout(3, 3, 2, 2));

        ArrayList<Media> mediaInStore = store.getItemsInStore();
        for (int i = 0; i < 9; i++) {
            MediaStore cell = new MediaStore(mediaInStore.get(i),cart);
            center.add(cell);
        }

        return center;
    }
    public StoreScreen(Store store) {
        this.store = store;
        this.cart= new Cart();

        Container cp = getContentPane();
        cp.setLayout(new BorderLayout());

        cp.add(createNorth(), BorderLayout.NORTH);
        cp.add(createCenter(), BorderLayout.CENTER);

        setVisible(true);
        setTitle("Store");
        setSize(1024, 768);
    }

    public static void main(String[] args) {
        Store store = new Store();

        store.addMedia(new DigitalVideoDisc("The Lion King", "Animation", "Roger Allers", 87, 19.95f));
        store.addMedia(new DigitalVideoDisc("Star Wars", "Sci-Fi", "George Lucas", 121, 24.95f));
        store.addMedia(new DigitalVideoDisc("Inception", "Thriller", "Chris Nolan", 148, 29.95f));

        CompactDisc cd1 = new CompactDisc("Pink Floyd");
        cd1.setTitle("The Dark Side"); cd1.setCategory("Rock"); cd1.setCost(14.95f);
        store.addMedia(cd1);

        CompactDisc cd2 = new CompactDisc("Beatles");
        cd2.setTitle("Abbey Road"); cd2.setCategory("Pop"); cd2.setCost(12.95f);
        store.addMedia(cd2);

        CompactDisc cd3 = new CompactDisc("Michael Jackson");
        cd3.setTitle("Thriller"); cd3.setCategory("Pop"); cd3.setCost(15.95f);
        store.addMedia(cd3);

        Book b1 = new Book();
        b1.setTitle("Clean Code"); b1.setCategory("Programming"); b1.setCost(39.95f);
        store.addMedia(b1);

        Book b2 = new Book();
        b2.setTitle("Design Patterns"); b2.setCategory("Programming"); b2.setCost(49.95f);
        store.addMedia(b2);

        Book b3 = new Book();
        b3.setTitle("The Pragmatic Programmer"); b3.setCategory("Programming"); b3.setCost(44.95f);
        store.addMedia(b3);

        SwingUtilities.invokeLater(() -> new StoreScreen(store));
    }
}
