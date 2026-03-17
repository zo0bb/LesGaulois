package personnages;

import objets.Chaudron;

public class Druide {

	private String nom;
	private int force;
	private Chaudron chaudron = new Chaudron();

	public Druide(String nom, int force) {
		super();
		this.nom = nom;
		this.force = force;
	}

	public String getNom() {
		return nom;
	}

	public void parler(String texte) {
		System.out.println(prendreParole() + "\"" + texte + "\"");
	}

	private String prendreParole() {
		return "Le druide " + nom + " : ";
	}

	public void fabriquerPotion(int quantite, int forcePotion) {
		chaudron.remplirChaudron(quantite, forcePotion);
		parler("J'ai concocté " + quantite + " doses de potion magique. Elle a une force de " + forcePotion + ".");
	}

	public void booster(Gaulois gaulois) {
		if (chaudron.resterPotion()) {
			if (gaulois.getNom().equals("Obélix")) {
				parler("Non, " + gaulois + " Non !... Et tu le sais très bien!");
			} else {
				int forcePotion = chaudron.prendreLouche();
				parler("Tiens " + gaulois + " un peu de potion magique. ");
				gaulois.boirePotion(forcePotion);
			}

		} else {
			parler("Désolé" + gaulois + " il n'y a plus une seule goute de potion");
		}
	}
}
