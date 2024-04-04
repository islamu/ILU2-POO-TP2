package Etal;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import personnages.Chef;
import personnages.Gaulois;
import villagegaulois.Village;
class VillageTest {

    private Village village;
    private Chef chef;
    private Gaulois gaulois1;
    private Gaulois gaulois2;

    @BeforeEach
    void setUp() {
        village = new Village("Le village des Gaulois", 10, 5);
        chef = new Chef("Abraracourcix", 10, village);
        gaulois1 = new Gaulois("Assurancetourix", 8);
        gaulois2 = new Gaulois("Obelix", 9);
        village.setChef(chef);
        village.ajouterHabitant(gaulois1);
        village.ajouterHabitant(gaulois2);
    }

    @Test
    void testSetChef() {
        assertEquals("Abraracourcix", chef.getNom());
    }

    @Test
    void testAjouterHabitant() {
        assertTrue(village.trouverHabitant("Assurancetourix") instanceof Gaulois);
        assertTrue(village.trouverHabitant("Obelix") instanceof Gaulois);
    }

    @Test
    void testDonnerVillageois() {
        String[] villageois = village.donnerVillageois();
        assertEquals(3, villageois.length);
        assertEquals("Abraracourcix", villageois[0]);
        assertEquals("Assurancetourix", villageois[1]);
        assertEquals("Obelix", villageois[2]);
    }

    @Test
    void testInstallerVendeur() {
        int indiceEtal = village.installerVendeur(gaulois1, "Potion", 10);
        assertEquals(0, indiceEtal);
    }

    @Test
    void testPartirVendeur() {
        village.installerVendeur(gaulois1, "Potion", 10);
        village.partirVendeur(gaulois1);
        assertNull(village.rechercherEtal(gaulois2));
    }

    @Test
    void testRechercherEtalVide() {
        assertTrue(village.rechercherEtalVide());
        village.installerVendeur(gaulois1, "Potion", 10);
        assertTrue(village.rechercherEtalVide());
    }

    @Test
    void testRechercherVendeursProduit() {
        village.installerVendeur(gaulois1, "Potion", 10);
        village.installerVendeur(gaulois2, "Potion", 5);
        Gaulois[] vendeurs = village.rechercherVendeursProduit("Potion");
        assertEquals(2, vendeurs.length);
        assertEquals("Assurancetourix", vendeurs[0].getNom());
        assertEquals("Obelix", vendeurs[1].getNom());
    }

    @Test
    void testDonnerEtatMarche() {
        village.installerVendeur(gaulois1, "Potion", 10);
        village.installerVendeur(gaulois2, "Potion", 5);
        String[] etatMarche = village.donnerEtatMarche();
        assertEquals(6, etatMarche.length); // 2 vendeurs * 3 informations par vendeur
        assertEquals("Assurancetourix", etatMarche[0]);
        assertEquals("10", etatMarche[1]);
        assertEquals("Obelix", etatMarche[3]);
        assertEquals("5", etatMarche[4]);
    }
}
