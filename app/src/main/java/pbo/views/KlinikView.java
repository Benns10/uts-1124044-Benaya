package pbo.views;

import pbo.controllers.KlinikController;
import pbo.models.Kucing;
import pbo.models.Anjing;
import pbo.models.Burung;
import pbo.models.Hewan;
import pbo.util.InputUtil; // Sesuaikan dengan utilitas input kalian

public class KlinikView {
    // Controller ditaruh di luar method agar list pasien tidak ter-reset saat looping menu
    private KlinikController controller = new KlinikController();

    public void showMenu() {
        boolean running = true;

        while (running) {
            System.out.println("\n=== APLIKASI KLINIK HEWAN ===");
            System.out.println("1. Tambah Pasien Hewan");
            System.out.println("2. Tampilkan Semua Pasien Hewan");
            System.out.println("3. Keluar");
            int choice = InputUtil.readInt("Pilih menu: ");

            switch (choice) {
                case 1:
                    System.out.println("\nPilih Kategori Hewan:");
                    System.out.println("1. Kucing");
                    System.out.println("2. Anjing");
                    System.out.println("3. Burung");
                    int subChoice = InputUtil.readInt("Pilih jenis (1-3): ");

                    String id = InputUtil.readString("Masukkan ID Hewan: ");
                    String nama = InputUtil.readString("Masukkan Nama Hewan: ");
                    int umur = InputUtil.readInt("Masukkan Umur (tahun): ");
                    double biaya = InputUtil.readDouble("Masukkan Biaya Perawatan per Hari (Rp): ");

                    try {
                        // Exception handling saat instansiasi objek (memicu Custom Exception jika data negatif)
                        if (subChoice == 1) {
                            String ras = InputUtil.readString("Masukkan Jenis Ras Kucing: ");
                            Kucing kucing = new Kucing(id, nama, umur, biaya, ras);
                            controller.addHewan(kucing);
                            System.out.println("Data Kucing berhasil ditambahkan!");
                        } else if (subChoice == 2) {
                            String ukuran = InputUtil.readString("Masukkan Ukuran Ras Anjing (Kecil/Sedang/Besar): ");
                            Anjing anjing = new Anjing(id, nama, umur, biaya, ukuran);
                            controller.addHewan(anjing);
                            System.out.println("Data Anjing berhasil ditambahkan!");
                        } else if (subChoice == 3) {
                            String paruh = InputUtil.readString("Masukkan Jenis Paruh Burung: ");
                            Burung burung = new Burung(id, nama, umur, biaya, paruh);
                            controller.addHewan(burung);
                            System.out.println("Data Burung berhasil ditambahkan!");
                        } else {
                            System.out.println("Pilihan jenis hewan tidak valid!");
                        }
                    } catch (Exception e) {
                        // Menangkap Custom Exception atau error validasi lainnya
                        System.out.println("[ERROR] Gagal menambahkan pasien: " + e.getMessage());
                    }
                    break;

                case 2:
                    System.out.println("\n--- DAFTAR PASIEN KLINIK HEWAN ---");
                    controller.printAllHewan();
                    break;

                case 3:
                    running = false;
                    System.out.println("Keluar dari aplikasi. Terima kasih!");
                    break;

                default:
                    System.out.println("Pilihan menu tidak valid!");
            }
        }
    }
}