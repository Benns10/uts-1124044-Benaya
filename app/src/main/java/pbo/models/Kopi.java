package pbo.models;

public class Kopi extends MenuItem {

    public Kopi(String id, String nama, int hargaBase, int stok) {
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
