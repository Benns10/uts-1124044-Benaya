package pbo.models;

public class Roti extends MenuItem implements Costumizable {

    public Roti(String id, String nama, int hargaBase, int stok) {
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