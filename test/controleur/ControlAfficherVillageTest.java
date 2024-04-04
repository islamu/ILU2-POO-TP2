package controleur;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import villagegaulois.Village;
import personnages.Chef;

class ControlAfficherVillageTest {
    private Village village;
    private ControlAfficherVillage controlAfficherVillage;
	private Chef abraracourcix;

    @BeforeEach
    public void setUp() {
        village = new Village("le village des irr�ductibles", 10, 5);
        controlAfficherVillage = new ControlAfficherVillage(village);
//        village.ajouterHabitant(new Gaulois("Asterix", 8));
		abraracourcix = new Chef("Abraracourcix",10,village);
		village.setChef(abraracourcix);
    }

    @Test
    void testDonnerNomsVillageois() {
        String[] nomsVillageois = controlAfficherVillage.donnerNomsVillageois();

        assertNotNull(nomsVillageois, "La m�thode ne devrait pas renvoyer null");
        assertEquals(1, nomsVillageois.length, "Le nombre de villageois doit �tre correct");
        assertEquals("Abraracourcix", nomsVillageois[0], "Le nom du chef du village doit �tre correct");
    }

    @Test
    void testDonnerNomVillage() {
        String nomVillage = controlAfficherVillage.donnerNomVillage();

        assertNotNull(nomVillage, "Le nom du village ne devrait pas �tre null");
        assertEquals("le village des irr�ductibles", nomVillage, "Le nom du village doit �tre correct");
    }

    @Test
    void testDonnerNbEtals() {
        int nbEtals = controlAfficherVillage.donnerNbEtals();

        assertEquals(5, nbEtals, "Le nombre d'�tals doit �tre correct");
    }
}
