package hust.soict.hedspi.aims;

import java.util.Scanner;
import hust.soict.media.*;
import java.util.ArrayList;
import hust.soict.hedspi.aims.exception.LimitExceededException;
import hust.soict.hedspi.aims.exception.PlayerException;

public class Aims {
    private static Store store = new Store();
    private static Cart cart = new Cart();
    private static Scanner qa = new Scanner(System.in);

    public static void main(String args[]) {
        // Khởi tạo một số dữ liệu mẫu để Store không bị trống
        initSetup();

        int input;
        do {
            showMenu();
            input = qa.nextInt();
            qa.nextLine(); // Chống trôi lệnh

            switch (input) {
                case 1:
                    viewStore();
                    break;
                case 2:
                    updateStore();
                    break;
                case 3:
                    viewCart();
                    break;
                case 0:
                    System.out.println("Goodbye!");
                    break;
                default:
                    System.out.println("Lựa chọn không hợp lệ, vui lòng chọn lại.");
            }
        } while (input != 0);
    }

    // --- MENU CẤP 1: VIEW STORE ---
    public static void viewStore() {
        store.printStore();
        int choice;
        do {
            storeMenu();
            choice = qa.nextInt();
            qa.nextLine();
            switch (choice) {
                case 1: // See details
                    System.out.print("Nhap tieu de media: ");
                    String title = qa.nextLine();
                    Media m = store.searchByTitle(title);
                    if (m != null) {
                        System.out.println(m.toString());
                        seeMediaDetailsMenu(m);
                    } else {
                        System.out.println("Khong tim thay media.");
                    }
                    break;
                case 2: // Add to cart
                    System.out.print("Nhap tieu de de add: ");
                    String t = qa.nextLine();
                    Media mediaAdd = store.searchByTitle(t);
                    if (mediaAdd != null) {
                        try {
                            cart.addMedia(mediaAdd);
                        } catch (LimitExceededException e) {
                            System.out.println(e.getMessage());
                        }
                    } else {
                        System.out.println("Khong tim thay.");
                    }
                    break;
                case 3: // Play
                    System.out.print("Nhap tieu de de play: ");
                    String tp = qa.nextLine();
                    Media mediaPlay = store.searchByTitle(tp);
                    if (mediaPlay != null && (mediaPlay instanceof Playable)) {
                        try {
                            ((Playable) mediaPlay).play();
                        } catch (PlayerException e) {
                            System.out.println(e.getMessage());
                            e.printStackTrace();
                        }
                    } else {
                        System.out.println("Media khong ton tai hoac khong the play.");
                    }
                    break;
                case 4:
                    viewCart();
                    break;
            }
        } while (choice != 0);
    }

    // --- MENU CON: MEDIA DETAILS ---
    public static void seeMediaDetailsMenu(Media m) {
        System.out.println("Options: \n--------------------------------\n1. Add to cart\n2. Play\n0. Back\n--------------------------------");
        int c = qa.nextInt();
        qa.nextLine();
        if (c == 1) {
            try {
                cart.addMedia(m);
            } catch (LimitExceededException e) {
                System.out.println(e.getMessage());
            }
        } else if (c == 2 && m instanceof Playable) {
            try {
                ((Playable) m).play();
            } catch (PlayerException e) {
                System.out.println(e.getMessage());
            }
        }
    }

    // --- MENU CẤP 1: VIEW CART ---
    public static void viewCart() {
        cart.viewCart();
        int choice;
        do {
            cartMenu();
            choice = qa.nextInt();
            qa.nextLine();
            switch (choice) {
                case 2: // Sort
                    System.out.println("1. Sort by Title\n2. Sort by Cost");
                    int s = qa.nextInt();
                    if (s == 1) cart.sortByTitleCost();
                    else cart.sortByCostTitle();
                    break;
                case 3: // Remove
                    System.out.print("Nhap tieu de de xoa: ");
                    String tr = qa.nextLine();
                    Media mr = cart.searchByTitle(tr); // Gia su lop Cart co ham nay
                    if (mr != null) cart.removeMedia(mr);
                    break;
                case 5: // Place order
                    System.out.println("Order created! Cart is empty now.");
                    cart = new Cart(); 
                    choice = 0;
                    break;
            }
        } while (choice != 0);
    }

    public static void updateStore() {
        System.out.println("Chuc nang dang phat trien (Them/Xoa kho hang).");
    }

    public static void initSetup() {
        store.addMedia(new DigitalVideoDisc("The Lion King", "Animation", "Roger Allers", 87, 19.95f));
        store.addMedia(new DigitalVideoDisc("Star Wars", "Science Fiction", "George Lucas", 87, 24.95f));
        
    }

    // Các hàm in Menu
    public static void showMenu() {
        System.out.println("\nAIMS: \n--------------------------------\n1. View store\n2. Update store\n3. See current cart\n0. Exit\n--------------------------------\nPlease choose a number: 0-1-2-3");
    }

    public static void storeMenu() {
        System.out.println("\nOptions: \n--------------------------------\n1. See a media's details\n2. Add a media to cart\n3. Play a media\n4. See current cart\n0. Back\n--------------------------------\nPlease choose a number: 0-1-2-3-4");
    }

    public static void cartMenu() {
        System.out.println("\nOptions: \n--------------------------------\n1. Filter medias in cart\n2. Sort medias in cart\n3. Remove media from cart\n4. Play a media\n5. Place order\n0. Back\n--------------------------------\nPlease choose a number: 0-1-2-3-4-5");
    }
}