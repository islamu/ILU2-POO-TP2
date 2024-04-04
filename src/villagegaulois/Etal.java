package villagegaulois;

import personnages.Gaulois;

public class Etal {
	private Gaulois vendeur;
	private String produit;
	private int quantiteDebutMarche;
	private int quantite;
	private boolean etalOccupe = false;

	public boolean isEtalOccupe() {
		return etalOccupe;
	}

	public Gaulois getVendeur() {
		return vendeur;
	}

	public int getQuantite() {
		return quantite;
	}

	public String getProduit() {
		return produit;
	}

	public void occuperEtal(Gaulois vendeur, String produit, int quantite) {
		this.vendeur = vendeur;
		this.produit = produit;
		this.quantite = quantite;
		quantiteDebutMarche = quantite;
		etalOccupe = true;
	}

	public boolean contientProduit(String produit) {
		return this.produit.equals(produit);
	}

	public int acheterProduit(int quantiteAcheter) {
		if (quantite == 0) {
			quantiteAcheter = 0;
		}
		if (quantiteAcheter > quantite) {
			quantiteAcheter = quantite;
		}
		if (etalOccupe) {
			quantite -= quantiteAcheter;
		}
		return quantiteAcheter;
	}

	/**
	 * 
	 * @param produit
	 * @return donneesVente est un tableau de chaine contenant [0] : un boolean
	 *         indiquant si l'Ã©tal est occupÃ© [1] : nom du vendeur [2] : produit
	 *         vendu [2] : quantitÃ© de produit Ã  vendre au dÃ©but du marchÃ© [4] :
	 *         quantitÃ© de produit vendu
	 */
	public void libererEtal() {
		etalOccupe = false;
	}

	/**
	 * 
	 * @param produit
	 * @return donneesVente est un tableau de chaine contenant [0] : un boolean
	 *         indiquant si l'Ã©tal est occupÃ© [1] : nom du vendeur [2] : produit
	 *         vendu [2] : quantitÃ© de produit Ã  vendre au dÃ©but du marchÃ© [4] :
	 *         quantitÃ© de produit vendu
	 */
	public String[] etatEtal() {
		String[] donneesVente = new String[5];
		donneesVente[0] = String.valueOf(etalOccupe);
		if (etalOccupe) {
			donneesVente[1] = vendeur.getNom();
			donneesVente[2] = produit;
			donneesVente[3] = String.valueOf(quantiteDebutMarche);
			donneesVente[4] = String.valueOf(quantiteDebutMarche - quantite);
		}
		return donneesVente;
	}
	//add
    public int vendreProduit(int quantiteAcheter) {
        int quantiteVendue = 0;
        if (quantite > 0 && quantiteAcheter > 0) { // S'il y a du produit disponible et une demande d'achat valide
            if (quantite >= quantiteAcheter) { // Si la quantité demandée est disponible
                quantiteVendue = quantiteAcheter; // Vendre la quantité demandée
            } else { // Si la quantité demandée est supérieure à la quantité disponible
                quantiteVendue = quantite; // Vendre toute la quantité disponible
            }
            quantite -= quantiteVendue; // Mettre à jour la quantité restante
        }
        return quantiteVendue;
    }

}
