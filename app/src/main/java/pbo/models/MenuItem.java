package pbo.models;

public abstract class MenuItem implements Customizable {
    private String id;
    private String nama;
    private int hargaBase;
    private int stok;

    public MenuItem(String id, String nama, int hargaBase, int stok) throws InputTidakValidException {
        if (hargaBase <= 0 || stok <= 0) {
            throw new InputTidakValidException("Harga dan Stok tidak boleh negatif atau nol");
        }
        this.id = id;
        this.nama = nama;
        this.hargaBase = hargaBase;
        this.stok = stok;    
    }

    public String getId() { return id; }
    public void setId(String id) { this.id = id; }
    
    public String getNama() { return nama; }
    public void setNama(String nama) { this.nama = nama; }
    
    public int getHargaBase() { return hargaBase; }
    public void setHargaBase(int hargaBase) { this.hargaBase = hargaBase; }
    
    public int getStok() { return stok; }
    public void setStok(int stok) { this.stok = stok; }

    public abstract String getOrderDetail();
    public abstract double hitungHargaTotal();

    public double hitungHargaTotal(int jumlah) throws StokTidakCukupException, InputTidakValidException {
        validasiJumlah(jumlah);
        this.stok -= jumlah;
    }
}
