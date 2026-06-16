package menufact;

import menufact.exceptions.MenuException;
import menufact.plats.PlatAuMenu;
import java.util.ArrayList;

public class MenuIterator implements IteratorPlatAuMenu {
    private final ArrayList<PlatAuMenu> listePlats;
    private int index = 0;

    MenuIterator(ArrayList<PlatAuMenu> listePlats) {
        this.listePlats = listePlats;
    }

    @Override
    public boolean hasNext() {
        return index < listePlats.size();
    }

    @Override
    public PlatAuMenu next() throws MenuException {
        if (!hasNext()) {
            throw new MenuException("On depasse le nombre maximale de plats.");
        }
        return listePlats.get(index++);
    }

    @Override
    public boolean hasPrevious() {
        return index > 0;
    }

    @Override
    public PlatAuMenu previous() throws MenuException {
        if (!hasPrevious()) {
            throw new MenuException("On depasse le nombre minimale de plats");
        }
        return listePlats.get(--index);
    }
}