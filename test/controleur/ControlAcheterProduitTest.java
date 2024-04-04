package controleur;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import villagegaulois.Village;
//import villagegaulois.Etal;
import personnages.Chef;
import personnages.Gaulois;

class ControlAcheterProduitTest {
    private Village village;
    private ControlAcheterProduit controlAcheterProduit;
    private ControlTrouverEtalVendeur controlTrouverEtalVendeur;
    private ControlVerifierIdentite controlVerifierIdentite;
	private Chef abraracourcix;

    @BeforeEach
    public void setUp() {
        village = new Village("le village des irr�ductibles", 10, 5);
		abraracourcix = new Chef("Abraracourcix",10,village);
		village.setChef(abraracourcix);
        controlVerifierIdentite = new ControlVerifierIdentite(village);
        controlTrouverEtalVendeur = new ControlTrouverEtalVendeur(village);
        controlAcheterProduit = new ControlAcheterProduit(controlVerifierIdentite, controlTrouverEtalVendeur, village);
    }

    @Test
    void testAcheterProduit() {
        // Cr�ation d'un vendeur et installation de l'�tal
        Gaulois vendeur = new Gaulois("Ob�lix", 25);
        village.ajouterHabitant(vendeur);
//        Etal etal = new Etal();
        village.installerVendeur(vendeur, "Poisson", 10);

        int quantiteAchete = controlAcheterProduit.acheterProduit("Ob�lix", 15);

        assertEquals(10, quantiteAchete, "La quantit� achet�e doit �tre �gale � la quantit� disponible dans l'�tal");
    }
}
