package pbo.models;

public class Teh extends MenuItem implements Costumizable {

    public Teh(String id, String nama, int hargaBase, int stok) {
        super(id, nama, hargaBase, stok);
    }

    @Override 
    public double hitungHargaTotal() {
        return 0;
    }   

    @Override
    public String getOrderDetail() {
       return "Anjing [";
    }
}