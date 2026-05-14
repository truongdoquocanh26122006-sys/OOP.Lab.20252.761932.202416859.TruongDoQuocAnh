package hust.soict.media;
import java.util.Comparator;
public abstract class Media {
    private int id;
    private String title;
    private String category;
    private float cost;
    public static final Comparator<Media> COMPARE_BY_TITLE_COST =new MediaComparatorByTitleCost();
    public static final Comparator<Media> COMPARE_BY_COST_TITLE =new MediaComparatorByCostTitle();
    public int getId(){
        return id;
    }
    public String getTitle(){
        return title;
    }
    public String getCategory(){
        return category;
    }
    public float getCost(){
        return cost;
    }
    public void setId(int id){
        this.id=id;
    }
    public void setTitle(String title){
        this.title=title;
    }
    public void setCategory(String category){
        this.category=category;
    }
    public void setCost(float cost){
        this.cost=cost;
    }
    public boolean equals(Object o){
        if(!(o instanceof Media)){
            return false;
        }
        Media b=(Media) o;
        if(this.getTitle()==b.getTitle()){
            return true;
        }
        return false;
    }
    public String toString(){
        return "ID: "+this.getId()+" Title: "+this.getTitle()+" Category: "+this.getCategory()+" Cost: "+this.getCost();
    };
}
