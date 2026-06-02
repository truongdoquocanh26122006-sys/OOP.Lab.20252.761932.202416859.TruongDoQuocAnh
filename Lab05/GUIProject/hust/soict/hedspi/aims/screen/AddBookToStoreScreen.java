package hust.soict.hedspi.aims.screen;

import hust.soict.hedspi.aims.Cart;
import hust.soict.hedspi.aims.Store;
import hust.soict.media.Book;

import javax.swing.*;

public class AddBookToStoreScreen extends AddItemToStoreScreen {
    private JTextField tfAuthor;

    public AddBookToStoreScreen(Store store, Cart cart) {
        super(store, cart);
        setTitle("Add Book");
    }

    @Override
    protected void addExtraFields(JPanel panel) {
        tfAuthor = new JTextField();
        panel.add(new JLabel("Author:"));
        panel.add(tfAuthor);
    }

    @Override
    protected void addMediaToStore() {
        String title    = tfTitle.getText();
        String category = tfCategory.getText();
        String author   = tfAuthor.getText();
        float cost      = Float.parseFloat(tfCost.getText());

        Book book = new Book();
        book.setTitle(title);
        book.setCategory(category);
        book.setCost(cost);
        book.addAuthor(author);

        store.addMedia(book);
        JOptionPane.showMessageDialog(this, "Book added successfully!");
    }
}
