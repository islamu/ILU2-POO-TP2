package controleur;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import villagegaulois.Village;
import personnages.Chef;
import personnages.Gaulois;

class ControlPrendreEtalTest {
    private Village village;
    private ControlVerifierIdentite controlVerifierIdentite;
    private ControlPrendreEtal controlPrendreEtal;
	private Chef abraracourcix;

    @BeforeEach
    public void initialisation() {
        System.out.println("Initialisation...");
        village = new Village("le village des irréductibles", 10, 5);
		abraracourcix = new Chef("Abraracourcix",10,village);
		village.setChef(abraracourcix);
        controlVerifierIdentite = new ControlVerifierIdentite(village);
        controlPrendreEtal = new ControlPrendreEtal(controlVerifierIdentite, village);
    }

    @Test
    void testResteEtals() {
        assertTrue(controlPrendreEtal.resteEtals());

    }

    @Test
    void testPrendreEtal() {
        Gaulois gaulois = new Gaulois("Asterix", 10);
        village.ajouterHabitant(gaulois);
        
        String nomVendeur = "Asterix";
        String produit = "Potion magique";
        int nbProduit = 5;
        int numeroEtal = controlPrendreEtal.prendreEtal(nomVendeur, produit, nbProduit);

        assertFalse(numeroEtal >= 0);
        assertTrue(numeroEtal <0);
    }

    @Test
    void testVerifierIdentite() {
        Gaulois gaulois = new Gaulois("Asterix", 10);
        village.ajouterHabitant(gaulois);
        
        assertTrue(controlPrendreEtal.verifierIdentite("Asterix"));
        assertFalse(controlPrendreEtal.verifierIdentite("Obelix"));
    }
}
