package pbo.controllers;

import java.util.ArrayList;
import java.util.List;
import pbo.models.Hewan;

public class KlinikController {
    private List<Hewan> daftarHewan = new ArrayList<>();

    public void addHewan(Hewan hewan) {
        daftarHewan.add(hewan);
    }

    public void printAllHewan() {
        if (daftarHewan.isEmpty()) {
            System.out.println("Belum ada pasien hewan yang terdaftar.");
            return;
        }
        for (Hewan h : daftarHewan) {
            System.out.println("> " + h.getInfoHewan());
            System.out.println("  Status Vaksin: " + h.getStatusVaksin());
        }
    }
}