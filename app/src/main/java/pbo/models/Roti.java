package pbo.models;

public class Roti extends MenuItem {

    public Roti(String id, String nama, int hargaBase, int stok) throws InputTidakValidException {
        super(id, nama, hargaBase, stok);
    }

    @Override 
    public double hitungHargaTotal(int jumlah) {
        return 0;
    }   

    @Override
    public String getOrderDetail() {
       return "Anjing [";
    }
}