package frontiere;

import controleur.ControlEmmenager;

public class BoundaryEmmenager {
	private ControlEmmenager controlEmmenager;

	public BoundaryEmmenager(ControlEmmenager controlEmmenager) {
		this.controlEmmenager = controlEmmenager;
	}

	public void emmenager(String nomVisiteur) {
		if (controlEmmenager.isHabitant(nomVisiteur)) {
			System.out.println(
					"Mais vous êtes déjà un habitant du village !");
		} else {
			StringBuilder question = new StringBuilder();
			question.append("Êtes-vous :\n");
			question.append("1 - un druide.\n");
			question.append("2 - un gaulois.\n");
			int choixUtilisateur = -1;
			do {
				choixUtilisateur = Clavier.entrerEntier(question.toString());
				switch (choixUtilisateur) {
				case 1:
					emmenagerDruide(nomVisiteur);
					break;
					
				case 2:
					StringBuilder questionVillagois= new StringBuilder();
					System.out.println("test");
					questionVillagois.append("Bienvenue villageois"+nomVisiteur+" \n");
					questionVillagois.append("Quel est votre force ? \n");
					int force = Clavier.entrerEntier(questionVillagois.toString());
					controlEmmenager.ajouterGaulois(nomVisiteur,force);
					break;

				default:
					System.out
							.println("Vous devez choisir le chiffre 1 ou 2 !");
					break;
				}
			} while (choixUtilisateur != 1 && choixUtilisateur != 2);
		}
	}

	private void emmenagerDruide(String nomVisiteur) {
		int forceDruide;
		int effetPotionMin;
		int effetPotionMax;
		System.out.println("Bienvenue druide " + nomVisiteur);
		StringBuilder question = new StringBuilder();
		question.append("Quelle est votre force?\n");
		forceDruide = Clavier.entrerEntier(question.toString());
		do {
			StringBuilder questioneffetPotionMin = new StringBuilder();
			questioneffetPotionMin.append("Quelle est la force de la potion la plus faible que vous produisez?\n");
			effetPotionMin = Clavier.entrerEntier(questioneffetPotionMin.toString());
			StringBuilder questioneffetPotionMax = new StringBuilder();
			questioneffetPotionMax.append("Quelle est la force de la potion la plus forte que vous produisez?\n");
			effetPotionMax = Clavier.entrerEntier(questioneffetPotionMax.toString());
			if (effetPotionMax < effetPotionMin) System.out.println("Attention Druide, vous vous �tes tromp� entre le minimum et le maximum ");
		} while (effetPotionMax < effetPotionMin);
		controlEmmenager.ajouterDruide(nomVisiteur, forceDruide, effetPotionMin, effetPotionMax);

	}

}