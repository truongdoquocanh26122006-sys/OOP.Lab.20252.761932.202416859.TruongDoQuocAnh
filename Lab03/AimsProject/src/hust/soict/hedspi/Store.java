package hust.soict.hedspi;
public class Store {
    private DigitalVideoDisc[] itemsInStore=new DigitalVideoDisc[673636];
    private int qtyInStore;
    public int getQtyInStore(){
        return qtyInStore;
    }
    public void addDVD( DigitalVideoDisc dvd)
    {
        if(qtyInStore<673636)
        {
            itemsInStore[qtyInStore]=dvd;
            qtyInStore++;
        }
        else{
            System.out.println("The store is đầy");
        }
    }
    public void removeDVD(DigitalVideoDisc dvd)
    {   boolean rimove=false;
        for(int i=0;i<qtyInStore;i++)
        {
            if(itemsInStore[i].getId()==dvd.getId()){
                rimove=true;
                for(int j=i;j<qtyInStore-1;j++){
                    itemsInStore[j]=itemsInStore[j+1];
                }
                qtyInStore--;
                System.out.println("The DVD: "+ dvd.toString()+" has been xóa");
            }
        }
        if(!rimove) System.out.println("Không tìm thấy dvd "+dvd.toString());
    }
}
