package controleur;

import villagegaulois.Village;
import personnages.Gaulois;
import villagegaulois.Etal;

public class ControlAcheterProduit {
	private Village village;
	private ControlTrouverEtalVendeur controlTrouverEtalVendeur;
	private ControlVerifierIdentite controlVerifierIdentite;

	public ControlAcheterProduit(ControlVerifierIdentite controlVerifierIdentite,
			ControlTrouverEtalVendeur controlTrouverEtalVendeur,
			Village village) {
		this.village = village;
		this.controlVerifierIdentite = controlVerifierIdentite;
		this.controlTrouverEtalVendeur = controlTrouverEtalVendeur;
	}

	public boolean isHabitant(String nom) {
		return controlVerifierIdentite.verifierIdentite(nom);
	}
	
	public Gaulois[] rechercherVendeursProduit(String produit) {
		return village.rechercherVendeursProduit(produit);
	}
	//s
	public Etal trouverEtalVendeur(String nomVendeur) {
		return controlTrouverEtalVendeur.trouverEtalVendeur(nomVendeur);
	}
	public int acheterProduit(String nomVendeur, int quantite) {
        // Trouver l'étal du vendeur
        Etal etalVendeur = trouverEtalVendeur(nomVendeur);
        if (etalVendeur != null) {
            // Acheter le produit
            int quantiteAchetee = etalVendeur.vendreProduit(quantite);
            return quantiteAchetee;
        } else {
            // Le vendeur n'existe pas ou n'a pas d'étal
            return 0;
        }
}}


