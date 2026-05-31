package hust.soict.hedspi.aims.screen;

import hust.soict.hedspi.aims.Cart;
import hust.soict.hedspi.aims.Store;
import hust.soict.media.DigitalVideoDisc;

import javax.swing.*;

public class AddDigitalVideoDiscToStoreScreen extends AddItemToStoreScreen {
    private JTextField tfDirector;
    private JTextField tfLength;

    public AddDigitalVideoDiscToStoreScreen(Store store, Cart cart) {
        super(store, cart);
        setTitle("Add DVD");
    }

    @Override
    protected void addExtraFields(JPanel panel) {
        tfDirector = new JTextField();
        tfLength   = new JTextField();
        panel.add(new JLabel("Director:"));
        panel.add(tfDirector);
        panel.add(new JLabel("Length (min):"));
        panel.add(tfLength);
    }

    @Override
    protected void addMediaToStore() {
        String title    = tfTitle.getText();
        String category = tfCategory.getText();
        String director = tfDirector.getText();
        float cost      = Float.parseFloat(tfCost.getText());
        int length      = Integer.parseInt(tfLength.getText());

        store.addMedia(new DigitalVideoDisc(title, category, director, length, cost));
        JOptionPane.showMessageDialog(this, "DVD added successfully!");
    }
}
