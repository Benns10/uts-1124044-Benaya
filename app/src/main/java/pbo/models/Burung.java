package pbo.models;

public class Burung extends Hewan{
    private String jenisParuh;

    public Burung(String id, String nama, int umur, double biayaPerawatan, String jenisParuh) throws InvalidDataHewanException {
        super(id, nama, umur, biayaPerawatan);
        this.jenisParuh = jenisParuh;
    }

    @Override 
    public double HitungTotalBiaya(int hari) {
        if (hari < 1) {
            throw new IllegalArgumentException("Minimal lama inap adalah 1 hari!");
        }
        return getBiayaPerawatan() * hari;
    }

    @Override
    public String getStatusVaksin() {
        return "Belum / Tidak Wajib";
    }

    @Override
    public String getInfoHewan() {
       return "Burung [" + getNama() + "] (ID: " + getId() + ") - Umur: " + getUmur() + " | Biaya Perawatan: " + getBiayaPerawatan() + " | Jenis Paruh: " + jenisParuh;
    }
}