package controleur;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import villagegaulois.Village;
import personnages.Chef;
import personnages.Gaulois;

class ControlLibererEtalTest {
    private Village village;
    private ControlTrouverEtalVendeur controlTrouverEtalVendeur;
    private ControlLibererEtal controlLibererEtal;
	private Chef abraracourcix;

    @BeforeEach
    public void setUp() {
        village = new Village("le village des irréductibles", 10, 5);
        controlTrouverEtalVendeur = new ControlTrouverEtalVendeur(village);
        controlLibererEtal = new ControlLibererEtal(controlTrouverEtalVendeur);
		abraracourcix = new Chef("Abraracourcix",10,village);
		village.setChef(abraracourcix);
    }

    @Test
    void testIsVendeur() {
        // Créer un étal avec un vendeur
        village.installerVendeur(new Gaulois("Obelix", 9), "Poisson", 10);
        
        //si un vendeur inexistant retourne false
        assertFalse(controlLibererEtal.isVendeur("Asterix"));
    }

    @Test
    void testLibererEtal() {
        village.installerVendeur(new Gaulois("Obelix", 9), "Potion", 10);
        // Libérer l'étal d'Obelix
        String[] donneesEtal = controlLibererEtal.libererEtal("Obelix");
        assertTrue(!Boolean.parseBoolean(donneesEtal[0]));
    }
}
