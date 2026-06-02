package hust.soict.hedspi.aims.screen;

import hust.soict.hedspi.aims.Cart;
import hust.soict.hedspi.aims.Store;
import hust.soict.media.CompactDisc;

import javax.swing.*;

public class AddCompactDiscToStoreScreen extends AddItemToStoreScreen {
    private JTextField tfArtist;

    public AddCompactDiscToStoreScreen(Store store, Cart cart) {
        super(store, cart);
        setTitle("Add CD");
    }

    @Override
    protected void addExtraFields(JPanel panel) {
        tfArtist = new JTextField();
        panel.add(new JLabel("Artist:"));
        panel.add(tfArtist);
    }

    @Override
    protected void addMediaToStore() {
        String title    = tfTitle.getText();
        String category = tfCategory.getText();
        String artist   = tfArtist.getText();
        float cost      = Float.parseFloat(tfCost.getText());

        CompactDisc cd = new CompactDisc(artist);
        cd.setTitle(title);
        cd.setCategory(category);
        cd.setCost(cost);

        store.addMedia(cd);
        JOptionPane.showMessageDialog(this, "CD added successfully!");
    }
}
