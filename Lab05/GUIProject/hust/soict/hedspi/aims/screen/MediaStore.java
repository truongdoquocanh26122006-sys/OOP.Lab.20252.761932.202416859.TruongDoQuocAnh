package hust.soict.hedspi.aims.screen;

import javax.swing.*;
import javax.swing.BorderFactory;
import java.awt.*;

import hust.soict.hedspi.aims.Cart;
import hust.soict.media.Media;
import hust.soict.media.Playable;

public class MediaStore extends JPanel {
    private Media media;
    private Cart cart;

    public MediaStore(Media media, Cart cart) {
        this.media = media;
        this.cart=cart;

        // xếp dọc từ trên xuống
        this.setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));

        // tạo label tên media
        JLabel title = new JLabel(media.getTitle());
        title.setFont(new Font(title.getFont().getName(), Font.PLAIN, 20));
        title.setAlignmentX(CENTER_ALIGNMENT);

        // tạo label giá tiền
        JLabel cost = new JLabel("" + media.getCost() + " $");
        cost.setAlignmentX(CENTER_ALIGNMENT);

        // panel chứa các nút bấm
        JPanel container = new JPanel();
        container.setLayout(new FlowLayout(FlowLayout.CENTER));
        JButton btnAddToCart=new JButton("Add to cart");
        btnAddToCart.addActionListener(e -> {
            cart.addMedia(media);
        });
        container.add(btnAddToCart);

        // chỉ thêm nút Play nếu media là Playable
        if (media instanceof Playable) {
            JButton play=new JButton("Play");
            play.addActionListener(e -> {
                JOptionPane.showMessageDialog(this,media.toString());
            });
            container.add(play);
        }

        // thêm tất cả vào panel theo thứ tự
        this.add(Box.createVerticalGlue());
        this.add(title);
        this.add(cost);
        this.add(Box.createVerticalGlue());
        this.add(container);

        // viền đen xung quanh
        this.setBorder(BorderFactory.createLineBorder(Color.BLACK));
    }

}