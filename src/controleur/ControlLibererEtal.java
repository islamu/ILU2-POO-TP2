package controleur;

import villagegaulois.Etal;

public class ControlLibererEtal {
	private ControlTrouverEtalVendeur controlTrouverEtalVendeur;

	public ControlLibererEtal(
			ControlTrouverEtalVendeur controlTrouverEtalVendeur) {
		this.controlTrouverEtalVendeur = controlTrouverEtalVendeur;
	}

	public boolean isVendeur(String nomVendeur) {
		Etal etal=controlTrouverEtalVendeur.trouverEtalVendeur(nomVendeur);
		return etal!=null;
	}
	/**
	 * 
	 * @param produit
	 * @return donneesVente est un tableau de chaine contenant [0] : un boolean
	 *         indiquant si l'�tal est occup� [1] : nom du vendeur [2] : produit
	 *         vendu [3] : quantit� de produit � vendre au d�but du march� [4] :
	 *         quantit� de produit vendu
	 */
	public String[] libererEtal(String nomVendeur) {
	    Etal etal = controlTrouverEtalVendeur.trouverEtalVendeur(nomVendeur);
	    if (etal != null) {
	        String[] donneesEtal = etal.etatEtal();
	        etal.libererEtal();
	        return donneesEtal;
	    } else {
	        // Retourner une valeur par d�faut ou une indication appropri�e
	        return new String[]{"�tal non trouv�"};
	    }
	}}