//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by Fernflower decompiler)
//

package UnitTests.menufact;

import java.util.Objects;
import menufact.IteratorPlatAuMenu;
import menufact.Menu;
import menufact.exceptions.MenuException;
import menufact.plats.PlatAuMenu;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class MenuTest {
    private Menu menu;

    MenuTest() {
    }

    @BeforeEach
    void setUp() {
        this.menu = new Menu("Menu Test");
        this.menu.ajoute(new PlatAuMenu(1, "Pizza", (double)12.0F));
        this.menu.ajoute(new PlatAuMenu(2, "Burger", (double)10.0F));
        this.menu.ajoute(new PlatAuMenu(3, "Pasta", (double)15.0F));
    }

    @Test
    void testAjouteAndPlatCourant() {
        this.menu.position(0);
        PlatAuMenu plat = this.menu.platCourant();
        Assertions.assertEquals("Pizza", plat.getDescription());
    }

    @Test
    void testPosition_changesCurrentPlat() {
        this.menu.position(2);
        Assertions.assertEquals("Pasta", this.menu.platCourant().getDescription());
    }

    @Test
    void testIterator_notNull() {
        IteratorPlatAuMenu it = this.menu.iterator();
        Assertions.assertNotNull(it);
    }

    @Test
    void testIterator_readsAllPlats() throws MenuException {
        IteratorPlatAuMenu it = this.menu.iterator();
        Assertions.assertEquals("Pizza", it.next().getDescription());
        Assertions.assertEquals("Burger", it.next().getDescription());
        Assertions.assertEquals("Pasta", it.next().getDescription());
    }

    @Test
    void testIterator_nextThrowsException() throws MenuException {
        IteratorPlatAuMenu it = this.menu.iterator();
        it.next();
        it.next();
        it.next();
        Objects.requireNonNull(it);
        MenuException ex = (MenuException)Assertions.assertThrows(MenuException.class, it::next);
    }

    @Test
    void testPositionSuivante() throws MenuException {
        this.menu.position(0);
        this.menu.positionSuivante();
        Assertions.assertEquals("Burger", this.menu.platCourant().getDescription());
    }

    @Test
    void testPositionSuivante_throws() {
        this.menu.position(2);
        MenuException ex = (MenuException)Assertions.assertThrows(MenuException.class, () -> this.menu.positionSuivante());
    }

    @Test
    void testPositionPrecedente() throws MenuException {
        this.menu.position(2);
        this.menu.positionPrecedente();
        Assertions.assertEquals("Burger", this.menu.platCourant().getDescription());
    }

    @Test
    void testToString_containsData() {
        String result = this.menu.toString();
        Assertions.assertTrue(result.contains("Menu Test"));
        Assertions.assertTrue(result.contains("Pizza"));
        Assertions.assertTrue(result.contains("Burger"));
        Assertions.assertTrue(result.contains("Pasta"));
    }
}
