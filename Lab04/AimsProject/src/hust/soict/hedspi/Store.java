package hust.soict.hedspi;
import java.util.ArrayList;
import hust.soict.media.Media;
public class Store {
    private ArrayList<Media> itemsInStore=new ArrayList<Media>();

    public int getQtyInStore(){
        return itemsInStore.size();
    }
    public void addMedia( Media mail)
    {
        if(!itemsInStore.contains(mail)){
            itemsInStore.add(mail);
            System.out.println("Da them media");
        }
        else{
            System.out.println("Da co media nay roi");
        }
    }
    public void removeMedia(Media mail)
    {   
        if(itemsInStore.contains(mail)){
            itemsInStore.remove(mail);
        System.out.println("Da xoa media");       
         }
         else{
            System.out.println("Khong tim thay media");
         }
    }
    public void printStore() {
    System.out.println("***********************STORE***********************");
    for (int i = 0; i < itemsInStore.size(); i++) {
        System.out.println((i + 1) + ". " + itemsInStore.get(i).toString());
    }
    System.out.println("***************************************************");
}

// Thêm hàm tìm kiếm để dùng cho Menu bài 13
public Media searchByTitle(String title) {
    for (Media m : itemsInStore) {
        if (m.getTitle().equalsIgnoreCase(title)) {
            return m;
        }
    }
    return null;
}
}
