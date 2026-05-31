package hust.soict.hedspi.aims.screen;

import hust.soict.hedspi.aims.Cart;
import hust.soict.hedspi.aims.Store;

import javax.swing.*;
import java.awt.*;

public abstract class AddItemToStoreScreen extends JFrame {
    protected Store store;
    protected Cart cart;

    protected JTextField tfTitle;
    protected JTextField tfCategory;
    protected JTextField tfCost;

    public AddItemToStoreScreen(Store store, Cart cart) {
        this.store = store;
        this.cart  = cart;

        setLayout(new BorderLayout());
        setJMenuBar(createMenuBar());
        add(createFormPanel(), BorderLayout.CENTER);

        setSize(400, 300);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setVisible(true);
    }

    JMenuBar createMenuBar() {
        JMenu menu = new JMenu("Options");

        JMenu smUpdateStore = new JMenu("Update Store");
        JMenuItem miAddBook = new JMenuItem("Add Book");
        JMenuItem miAddCD   = new JMenuItem("Add CD");
        JMenuItem miAddDVD  = new JMenuItem("Add DVD");
        miAddBook.addActionListener(e -> { dispose(); new AddBookToStoreScreen(store, cart); });
        miAddCD.addActionListener(e ->   { dispose(); new AddCompactDiscToStoreScreen(store, cart); });
        miAddDVD.addActionListener(e ->  { dispose(); new AddDigitalVideoDiscToStoreScreen(store, cart); });
        smUpdateStore.add(miAddBook);
        smUpdateStore.add(miAddCD);
        smUpdateStore.add(miAddDVD);

        JMenuItem miViewStore = new JMenuItem("View store");
        miViewStore.addActionListener(e -> { dispose(); new StoreScreen(store, cart); });

        JMenuItem miViewCart = new JMenuItem("View Cart");
        miViewCart.addActionListener(e -> new CartScreen(cart));

        menu.add(smUpdateStore);
        menu.add(miViewStore);
        menu.add(miViewCart);

        JMenuBar menuBar = new JMenuBar();
        menuBar.setLayout(new FlowLayout(FlowLayout.LEFT));
        menuBar.add(menu);
        return menuBar;
    }

    JPanel createFormPanel() {
        JPanel panel = new JPanel(new GridLayout(0, 2, 5, 5));
        panel.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));

        tfTitle    = new JTextField();
        tfCategory = new JTextField();
        tfCost     = new JTextField();

        panel.add(new JLabel("Title:"));
        panel.add(tfTitle);
        panel.add(new JLabel("Category:"));
        panel.add(tfCategory);
        panel.add(new JLabel("Cost:"));
        panel.add(tfCost);

        addExtraFields(panel);

        JButton btnAdd = new JButton("Add");
        btnAdd.addActionListener(e -> addMediaToStore());
        panel.add(new JLabel());
        panel.add(btnAdd);

        return panel;
    }

    // Subclass thêm các field riêng vào panel
    protected abstract void addExtraFields(JPanel panel);

    // Subclass implement logic tạo media và thêm vào store
    protected abstract void addMediaToStore();
}
