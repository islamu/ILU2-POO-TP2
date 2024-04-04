package controleur;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import personnages.Chef;
import villagegaulois.Village;

class ControlAfficherMarcheTest {
    private Village village;
    private ControlAfficherMarche controlAfficherMarche;
	private Chef abraracourcix;

    @BeforeEach
    public void initialisation() {
        System.out.println("Initialisation...");
        village = new Village("le village des irréductibles", 10, 5);
        controlAfficherMarche = new ControlAfficherMarche(village);
		abraracourcix = new Chef("Abraracourcix",10,village);
		village.setChef(abraracourcix);
    }

    @Test
    void testDonnerInfosMarche() {
        String[] infosMarche = controlAfficherMarche.donnerInfosMarche();

        assertNotNull(infosMarche, "La méthode ne devrait pas renvoyer null");

    }
}
