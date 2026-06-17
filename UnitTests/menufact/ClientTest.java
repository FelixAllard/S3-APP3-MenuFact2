//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by Fernflower decompiler)
//

package UnitTests.menufact;

import menufact.Client;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class ClientTest {
    ClientTest() {
    }

    @Test
    void testConstructorAndGetters() {
        Client client = new Client(1, "Alice", "1234");
        Assertions.assertEquals(1, client.getIdClient());
        Assertions.assertEquals("Alice", client.getNom());
        Assertions.assertEquals("1234", client.getNumeroCarteCredit());
    }

    @Test
    void testSetters() {
        Client client = new Client(1, "Alice", "1234");
        client.setIdClient(2);
        client.setNom("Bob");
        client.setNumeroCarteCredit("9999");
        Assertions.assertEquals(2, client.getIdClient());
        Assertions.assertEquals("Bob", client.getNom());
        Assertions.assertEquals("9999", client.getNumeroCarteCredit());
    }

    @Test
    void testToString_containsFields() {
        Client client = new Client(7, "Charlie", "5555");
        String result = client.toString();
        Assertions.assertTrue(result.contains("7"));
        Assertions.assertTrue(result.contains("Charlie"));
        Assertions.assertTrue(result.contains("5555"));
    }

    @Test
    void testObjectStateConsistency() {
        Client client = new Client(10, "David", "1111");
        client.setNom("David Updated");
        Assertions.assertEquals("David Updated", client.getNom());
        Assertions.assertEquals(10, client.getIdClient());
    }
}
