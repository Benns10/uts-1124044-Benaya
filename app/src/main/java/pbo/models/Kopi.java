package pbo.models;

import java.util.List;

public class Kopi extends MenuItem implements Customizable{
    private int rum = 0;
    private int karamel = 0;
    private double totalTambahan = 0;
    public Kopi(String id, String nama, int hargaBase, int stok) throws InputTidakValidException {
        super(id, nama, hargaBase, stok);
    }

    @Override 
    public double hitungHargaTotal() {
        return this.hargaBase + this.totalTambahan;
    }

    @Override   
    public void customize(List<Integer> customizations) {
        for (int pilih : customizations) {
            tambah(pilih);
        }
    } 

    @Override
    public void customize(int[] customizations) {
        for (int pilih : customizations) {
            tambah(pilih);
        }
    }

    public double getTotalTambahan() {
        return totalTambahan;
    }
    private void tambah(int tambah) {
        if (pilih == 1) {
            this.rum++;
            this.totalTambahan += 3000;
        } else if (pilih == 2) {
            this.karamel++;
            this.totalTambahan += 3000;
        }
    }

    @Override
    public String getOrderDetail() {
       return "Menu: " + nama + " | Tambahan Rum : " + rum + " | Tambahan Karamel : " + karamel ;
    }
}
