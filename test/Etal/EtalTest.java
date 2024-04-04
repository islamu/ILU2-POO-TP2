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
        vendeur = new Gaulois("Astérix", 10);
    }

    @Test
    void testOccuperEtal() {
        etal.occuperEtal(vendeur, "Potion", 10);
        assertTrue(etal.isEtalOccupe());
        assertEquals("Astérix", etal.getVendeur().getNom());
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
        assertEquals("Astérix", donneesVente[1]);
        assertEquals("Potion", donneesVente[2]);
        assertEquals("10", donneesVente[3]);
        assertEquals("0", donneesVente[4]);
    }

    // Test vendreProduit
    @Test
    void testVendreProduit() {
        etal.occuperEtal(vendeur, "Potion", 10);
        assertEquals(5, etal.vendreProduit(5)); // Vendre 5 produits
        assertEquals(5, etal.getQuantite()); // Vérifier la quantité restante
        assertEquals(5, etal.vendreProduit(7)); // Vendre 7 produits alors qu'il n'en reste que 5
        assertEquals(0, etal.getQuantite()); // Vérifier que la quantité est épuisée
    }
}
