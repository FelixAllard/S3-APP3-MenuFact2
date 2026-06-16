package menufact;
import menufact.exceptions.MenuException;
import menufact.plats.PlatAuMenu;

public interface IteratorPlatAuMenu {
    boolean hasNext();
    PlatAuMenu next() throws MenuException;
    boolean hasPrevious();
    PlatAuMenu previous() throws MenuException;
}