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
        village = new Village("Le village des irr�ductibles", 10, 5);
        controlTrouverEtalVendeur = new ControlTrouverEtalVendeur(village);
		abraracourcix = new Chef("Abraracourcix",10,village);
		village.setChef(abraracourcix);
    }

    @Test
    void testTrouverEtalVendeur() {
        //cr�er un Gaulois
        Gaulois gaulois = new Gaulois("Ast�rix", 8);
        village.ajouterHabitant(gaulois);

        //�tal pour Ast�rix
        village.installerVendeur(gaulois, "Poisson", 10);

        //Ast�rix
        Etal resultat = controlTrouverEtalVendeur.trouverEtalVendeur("Ast�rix");

        // V�rifier que l'�tal retourn� est celui attendu
        assertNotNull(resultat);
        assertEquals("Poisson", resultat.getProduit());
        assertEquals(10, resultat.getQuantite());
    }

    @Test
    void testTrouverEtalVendeurInexistant() {
        //un vendeur inexistant
        Etal resultat = controlTrouverEtalVendeur.trouverEtalVendeur("Ob�lix");

        //null est retourn� car obelix n'a pas d'�tal
        assertNull(resultat);
    }
}
