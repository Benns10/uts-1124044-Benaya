package pbo.models;

public class Kucing extends Hewan implements DiskonInap{
    private String jenisRas;

    public Kucing(String id, String nama, int umur, double biayaPerawatan, String jenisRas) throws InvalidDataHewanException {
        super(id, nama, umur, biayaPerawatan);
        this.jenisRas = jenisRas;
    }

    @Override 
    public double hitungDiskon(int hari) {
        double subTotalDiskon = getBiayaPerawatan() * hari;
        if (hari >= 7) {
            return subTotalDiskon * 0.15;
        } else if (hari >= 3) {
            return subTotalDiskon * 0.05;
        } 
        return 0.0;
    }

    @Override 
    public double HitungTotalBiaya(int hari) {
        if (hari < 1) {
            throw new IllegalArgumentException("Minimal lama inap adalah 1 hari!");
        }
        double totalBiaya =  getBiayaPerawatan() * hari;
        return totalBiaya - hitungDiskon(hari);
    }
    
    @Override
    public String getStatusVaksin() {
        return "Sudah Vaksin Rabies";
    }

    @Override
    public String getInfoHewan() {
       return "Kucing [" + getNama() + "] (ID: " + getId() + ") - Umur: " + getUmur() + " | Biaya Perawatan: " + getBiayaPerawatan() + " | Jenis Ras: " + jenisRas;
    }
}
