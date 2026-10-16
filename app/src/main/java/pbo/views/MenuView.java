package pbo.views;

import pbo.controllers.MenuItemController;
import pbo.models.InputTidakValidException;
import pbo.models.MenuTidakDitemukanException;
import pbo.models.StokTidakCukupException;
import pbo.models.Teh;
import pbo.models.Kopi;
import pbo.models.Roti;
import pbo.models.MenuItem;
import pbo.util.InputUtil;

public class MenuView {
    private MenuItemController controller;

    public MenuView() {
        try {
            this.controller = new MenuItemController();
        } catch (InputTidakValidException e) {
            System.out.println("Gagal memuat data menu!");
        }
    }

    public void showMenu() {
        boolean running = true;

        while (running) {
            System.out.println("\n=== COFFEE SOP ===");
            for (MenuItem m : controller.getDaftarMenu()) {
                System.out.println(m.getId() + ": " + m.getNama() + " (Stok: " + m.getStok() + ")");
            }
            System.out.println("0: Keluar");

            String idMenu = InputUtil.readString("Masukan ID Menu yang ingin dipesan: ");
            if (idMenu.equals("0")) {
                running = false;
                System.out.println("Terimakasi!");
                break;
            }
  
            try {        
                MenuItem pesan = controller.cariMenu(idMenu);
                int jumlah = InputUtil.readInt("Masukan jumlah pesanan: ");
                double totalHarga = pesan.hitungHargaTotal(jumlah);
                if (pesan instanceof Kopi) {
                    System.out.println("Pilih Tambahan (1: Rum, 2: Karamel, 0: Lewati)");
                    int pilih = InputUtil.readInt("Pilihan: ");
                    if (pilih != 0) {
                        ((Kopi) pesan).customize(new int[]{pilih});
                        totalHarga += (((Kopi) pesan).getTotalTambahan() * jumlah);
                    }
                } else if (pesan instanceof Teh) {
                    System.out.println("Pilih Tambahan (1: Boba, 2: Karamel, 0: Lewati)");
                    int pilih = InputUtil.readInt("Pilihan: ");
                    if (pilih != 0) {
                        ((Teh) pesan).customize(new int[]{pilih});
                        totalHarga += (((Teh) pesan).getTotalTambahan() * jumlah);
                    }
                } else if (pesan instanceof Roti) {
                    System.out.println("Pilih Tambahan (1: Meses, 2: Karamel, 0: Lewati)");
                    int pilih = InputUtil.readInt("Pilihan: ");
                    if (pilih != 0) {
                        ((Roti) pesan).customize(new int[]{pilih});
                        totalHarga += (((Roti) pesan).getTotalTambahan() * jumlah);
                    }
                } 

                System.out.println("\n--- STRUK PESANAN ---");
                System.out.println(pesan.getOrderDetail());
                System.out.println("Total Bayar: Rp" + totalHarga);
                System.out.println("Sisa Stok " + pesan.getNama() + " sekarang: " + pesan.getStok());
                
            } catch (MenuTidakDitemukanException | StokTidakCukupException | InputTidakValidException e) {
                System.out.println("[ERROR] Gagal: " + e.getMessage());
                System.out.println("Coba input lagi");
            } break;
        }
    }
}