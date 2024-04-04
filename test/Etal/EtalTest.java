package Etal  ;
import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import personnages.Gaulois;
import villagegaulois.Etal;

class EtalTest {

    private Etal etal;
    private Gaulois vendeur;

    @BeforeEach
    void setUp() {
        etal = new Etal();
        vendeur = new Gaulois("Ast�rix", 10);
    }

    @Test
    void testOccuperEtal() {
        etal.occuperEtal(vendeur, "Potion", 10);
        assertTrue(etal.isEtalOccupe());
        assertEquals("Ast�rix", etal.getVendeur().getNom());
        assertEquals("Potion", etal.getProduit());
        assertEquals(10, etal.getQuantite());
    }

    @Test
    void testContientProduit() {
        etal.occuperEtal(vendeur, "Potion", 10);
        assertTrue(etal.contientProduit("Potion"));
        assertFalse(etal.contientProduit("Pain"));
    }

    @Test
    void testAcheterProduit() {
        etal.occuperEtal(vendeur, "Potion", 10);
        assertEquals(5, etal.acheterProduit(5));
        assertEquals(5, etal.getQuantite());

        assertEquals(5, etal.acheterProduit(7));
        assertEquals(0, etal.getQuantite());
    }

    @Test
    void testLibererEtal() {
        etal.occuperEtal(vendeur, "Potion", 10);
        etal.libererEtal();
        assertFalse(etal.isEtalOccupe());
    }

    @Test
    void testEtatEtal() {
        etal.occuperEtal(vendeur, "Potion", 10);
        String[] donneesVente = etal.etatEtal();
        assertEquals(5, donneesVente.length);
        assertTrue(Boolean.parseBoolean(donneesVente[0]));
        assertEquals("Ast�rix", donneesVente[1]);
        assertEquals("Potion", donneesVente[2]);
        assertEquals("10", donneesVente[3]);
        assertEquals("0", donneesVente[4]);
    }

    // Test vendreProduit
    @Test
    void testVendreProduit() {
        etal.occuperEtal(vendeur, "Potion", 10);
        assertEquals(5, etal.vendreProduit(5)); // Vendre 5 produits
        assertEquals(5, etal.getQuantite()); // V�rifier la quantit� restante
        assertEquals(5, etal.vendreProduit(7)); // Vendre 7 produits alors qu'il n'en reste que 5
        assertEquals(0, etal.getQuantite()); // V�rifier que la quantit� est �puis�e
    }
}
