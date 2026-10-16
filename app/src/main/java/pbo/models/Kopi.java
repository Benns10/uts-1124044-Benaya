package pbo.models;

public class Kopi extends MenuItem{
    public Kopi(String id, String nama, int hargaBase, int stok) throws InputTidakValidException {
        super(id, nama, hargaBase, stok);
    }

    @Override 
    public double hitungHargaTotal(int jumlah) {
        if (jumlah <= 0) {
            throw new InputTidakValidException("Jumlah tidak boleh negatif atau nol;")
        };
    }

    @Override
    void customization() {
    } 

    @Override
    public String getOrderDetail() {
       return "";
    }
}
