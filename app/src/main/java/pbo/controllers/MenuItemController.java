package pbo.controllers;

import java.util.ArrayList;
import java.util.List;
import pbo.models.MenuItem;

public class MenuItemController {
    private List<MenuItem> daftarMenu = new ArrayList<>();

    public void addHewan(MenuItem menuItem) {
        daftarMenu.add(menuItem);
    }

    public void printAllHewan() {
        if (daftarMenu.isEmpty()) {
            System.out.println("Belum ada pasien hewan yang terdaftar.");
            return;
        }
        for (MenuItem m : daftarMenu) {
            System.out.println("> " + m.getOrderDetail());
        }
    }
}