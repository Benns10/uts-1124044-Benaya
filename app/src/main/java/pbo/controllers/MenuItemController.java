package pbo.controllers;

import java.util.ArrayList;
import java.util.List;
import pbo.models.MenuItem;
import pbo.models.MenuTidakDitemukanException;
import pbo.models.Roti;
import pbo.models.Teh;
import pbo.models.InputTidakValidException;
import pbo.models.Kopi;

public class MenuItemController {
    private List<MenuItem> daftarMenu = new ArrayList<>();

    public MenuItemController() throws InputTidakValidException {
        daftarMenu.add(new Kopi("K-01", "Kopi Omakase", 30000, 15));
        daftarMenu.add(new Teh("T-01", "Teh Ichi Ocha", 8000, 10));
        daftarMenu.add(new Roti("R-01", "Roti Garut", 15000, 5));
    }

    public List<MenuItem> getDaftarMenu() {
        return daftarMenu;
    }

    public MenuItem cariMenu(String id) throws MenuTidakDitemukanException {
        for (MenuItem menu : daftarMenu) {
            if (menu.getId().equalsIgnoreCase(id)) {
                return menu;
            }
        }
        throw new MenuTidakDitemukanException("ID Menu " + id + " tidak terdaftar. ");
    }

}