package controleur;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import villagegaulois.Village;
import villagegaulois.Etal;
import personnages.Chef;
import personnages.Gaulois;

class ControlTrouverEtalVendeurTest {
    private Village village;
    private ControlTrouverEtalVendeur controlTrouverEtalVendeur;
    private Chef abraracourcix ; 

    @BeforeEach
    public void setUp() {
        village = new Village("Le village des irréductibles", 10, 5);
        controlTrouverEtalVendeur = new ControlTrouverEtalVendeur(village);
		abraracourcix = new Chef("Abraracourcix",10,village);
		village.setChef(abraracourcix);
    }

    @Test
    void testTrouverEtalVendeur() {
        //créer un Gaulois
        Gaulois gaulois = new Gaulois("Astérix", 8);
        village.ajouterHabitant(gaulois);

        //étal pour Astérix
        village.installerVendeur(gaulois, "Poisson", 10);

        //Astérix
        Etal resultat = controlTrouverEtalVendeur.trouverEtalVendeur("Astérix");

        // Vérifier que l'étal retourné est celui attendu
        assertNotNull(resultat);
        assertEquals("Poisson", resultat.getProduit());
        assertEquals(10, resultat.getQuantite());
    }

    @Test
    void testTrouverEtalVendeurInexistant() {
        //un vendeur inexistant
        Etal resultat = controlTrouverEtalVendeur.trouverEtalVendeur("Obélix");

        //null est retourné car obelix n'a pas d'étal
        assertNull(resultat);
    }
}
