package frontiere;

import java.util.Scanner;
import controleur.ControlAcheterProduit;
import personnages.Gaulois;
import villagegaulois.Etal;


public class BoundaryAcheterProduit {
	private Scanner scan = new Scanner(System.in);
	private ControlAcheterProduit controlAcheterProduit;

	public BoundaryAcheterProduit(ControlAcheterProduit controlAcheterProduit) {
		this.controlAcheterProduit = controlAcheterProduit;
	}

	public void acheterProduit(String nomAcheteur) {
		boolean acheteurReconnu = controlAcheterProduit.isHabitant(nomAcheteur);
		if (!acheteurReconnu) System.out.println("Je suis d�sol� " + nomAcheteur + " mais il faut être un habitant de notre village pour acheter un produit.\n");
		else {
			System.out.println("Quel produit voulez-vous acheter ?\n");
			String produit = scan.next();
			Gaulois[] vendeurs = controlAcheterProduit.rechercherVendeursProduit(produit);
			if (vendeurs==null) System.out.println("D�sol�, personne ne vend ce produit au march�.\n");
			else {
				System.out.println("Chez quel commer�ant voulez-vous acheter des fleurs ?\n");
				for (int i = 0; i < vendeurs.length; i++) {
					System.out.println((i+1) + " - " + vendeurs[i].getNom() + "\n");
				}
				int vendeur = Clavier.entrerEntier("");
				Etal etalVendeur = controlAcheterProduit.trouverEtalVendeur(vendeurs[vendeur-1].getNom());
				System.out.println(nomAcheteur + " se d�place jusqu'� l'�tal du vendeur " + etalVendeur.getVendeur().getNom());
				System.out.println("Bonjour " + nomAcheteur);
				
				int nbProduit = Clavier.entrerEntier("Combien de " + etalVendeur.getProduit() + " voulez-vous acheter ?");
				if (etalVendeur.getQuantite()==0) System.out.println(nomAcheteur + " veut acheter " + nbProduit + " " + produit + ", malheureusement il n�y en a plus !\n");
				else if (nbProduit>etalVendeur.getQuantite()) {
					System.out.println(nomAcheteur + " veut acheter " + nbProduit + " " + produit + ", malheureusement " + etalVendeur.getVendeur().getNom() + " n�en a plus que " + etalVendeur.getQuantite() + ". " + nomAcheteur + " ach�te tout le stock de " + etalVendeur.getVendeur().getNom() + ".\n");
					etalVendeur.acheterProduit(etalVendeur.getQuantite());
				}
				else {
					System.out.println(nomAcheteur + " ach�te " + nbProduit + " " + produit + " � " + etalVendeur.getVendeur().getNom() + ".\n");
					etalVendeur.acheterProduit(nbProduit);
				}
			}
		}
	}
}