package hust.soict.hedspi.aims.screen;

import hust.soict.hedspi.aims.Cart;
import hust.soict.hedspi.aims.Store;
import hust.soict.hedspi.aims.exception.PlayerException;
import hust.soict.media.Media;
import hust.soict.media.Playable;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.collections.transformation.FilteredList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;

public class CartScreenController {
    private Cart cart;
    private Store store;

    @FXML private TableView<Media> tblMedia;
    @FXML private TableColumn<Media, String> colMediaTitle;
    @FXML private TableColumn<Media, String> colMediacategory;
    @FXML private TableColumn<Media, Float> colMediaCost;
    @FXML private Button btnPlay;
    @FXML private Button btnRemove;
    @FXML private Label labelTotal;
    @FXML private TextField tfFilter;
    @FXML private RadioButton radioBtnFilterId;
    @FXML private RadioButton radioBtnFilterTitle;

    private FilteredList<Media> filteredList;

    public CartScreenController(Store store, Cart cart) {
        super();
        this.store = store;
        this.cart  = cart;
    }

    @FXML
    private void initialize() {
        colMediaTitle.setCellValueFactory(new PropertyValueFactory<>("title"));
        colMediacategory.setCellValueFactory(new PropertyValueFactory<>("category"));
        colMediaCost.setCellValueFactory(new PropertyValueFactory<>("cost"));

        // Section 10: wrap ObservableList trong FilteredList
        filteredList = new FilteredList<>(cart.getItemsOrdered(), p -> true);
        tblMedia.setItems(filteredList);

        // Ẩn button ban đầu, chỉ hiện khi chọn item (section 8)
        btnPlay.setVisible(false);
        btnRemove.setVisible(false);

        // Section 11: set total ban đầu và cập nhật khi cart thay đổi
        labelTotal.setText(cart.totalCost() + " $");
        cart.getItemsOrdered().addListener((javafx.collections.ListChangeListener<Media>) change -> {
            labelTotal.setText(cart.totalCost() + " $");
        });

        // Section 10: ChangeListener cho filter text
        tfFilter.textProperty().addListener(new ChangeListener<String>() {
            @Override
            public void changed(ObservableValue<? extends String> observable,
                                String oldValue, String newValue) {
                showFilteredMedia(newValue);
            }
        });

        // ChangeListener: cập nhật button khi user chọn item trong TableView
        tblMedia.getSelectionModel().selectedItemProperty().addListener(
            new ChangeListener<Media>() {
                @Override
                public void changed(ObservableValue<? extends Media> observable,
                                    Media oldValue, Media newValue) {
                    if (newValue != null) {
                        updateButtonBar(newValue);
                    }
                }
            }
        );
    }

    // Section 10: lọc danh sách theo filter text và radio button
    void showFilteredMedia(String filterText) {
        filteredList.setPredicate(media -> {
            if (filterText == null || filterText.isEmpty()) return true;
            if (radioBtnFilterId.isSelected()) {
                return String.valueOf(media.getId()).contains(filterText);
            } else {
                return media.getTitle().toLowerCase().contains(filterText.toLowerCase());
            }
        });
    }

    // Hiện/ẩn button tùy loại media (section 8)
    void updateButtonBar(Media media) {
        btnRemove.setVisible(true);
        if (media instanceof Playable) {
            btnPlay.setVisible(true);
        } else {
            btnPlay.setVisible(false);
        }
    }

    // Section 9: xóa media khỏi cart
    @FXML
    void btnRemovePressed(ActionEvent event) {
        Media media = tblMedia.getSelectionModel().getSelectedItem();
        cart.removeMedia(media);
    }

    // Play media được chọn
    @FXML
    void btnPlayPressed(ActionEvent event) {
        Media media = tblMedia.getSelectionModel().getSelectedItem();
        if (media instanceof Playable) {
            try {
                ((Playable) media).play();
            } catch (PlayerException e) {
                javafx.scene.control.Alert alert = new javafx.scene.control.Alert(
                    javafx.scene.control.Alert.AlertType.ERROR);
                alert.setTitle("Error");
                alert.setContentText(e.getMessage());
                alert.showAndWait();
            }
        }
    }

    // Place order
    @FXML
    void btnPlaceOrderPressed(ActionEvent event) {
        cart.getItemsOrdered().clear();
        labelTotal.setText("0 $");
    }

    // Menu actions
    @FXML void addBook(ActionEvent event) { new AddBookToStoreScreen(store, cart); }
    @FXML void addCD(ActionEvent event)   { new AddCompactDiscToStoreScreen(store, cart); }
    @FXML void addDVD(ActionEvent event)  { new AddDigitalVideoDiscToStoreScreen(store, cart); }
    @FXML void viewStore(ActionEvent event) { new StoreScreen(store, cart); }
    @FXML void viewCart(ActionEvent event)  { /* đang ở cart rồi, không làm gì */ }
}
