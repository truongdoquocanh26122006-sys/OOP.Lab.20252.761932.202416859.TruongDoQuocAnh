package hust.soict.media;
import java.util.Comparator;

public class MediaComparatorByTitleCost implements Comparator<Media> {
    @Override
    public int compare(Media m1, Media m2) {
        // So sánh tiêu đề theo bảng chữ cái (giống strcmp trong C)
        int titleDiff = m1.getTitle().compareTo(m2.getTitle());
        if (titleDiff != 0) return titleDiff;
        
        return Float.compare(m2.getCost(), m1.getCost());
    }
}