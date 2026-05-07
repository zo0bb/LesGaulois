package personnages;

import objets.Equipement;
import village_gaulois.Village;

public class Gaulois {
	public Gaulois(String nom, int force, int effetPotion) {
		super();
		this.nom = nom;
		this.force = force;
		this.effetPotion = effetPotion;
	}

	public Gaulois(String nom, int force) {
		this(nom, force, 1);
	}

	private String nom;
	private int effetPotion = 1;
	private Village village;
	private int force;
	private int nbTrophees;
	private Equipement[] trophees = new Equipement[100];

	public String getNom() {
		return nom;
	}
	
	public void setVillage(Village village) {
		this.village = village;
	}

	public void parler(String texte) {
		System.out.println(prendreParole() + "\"" + texte + "\"");
	}
	
	private String prendreParole() {
		return "Le gaulois " + nom + " : ";
	}


	public static void main(String[] args) {
		Gaulois asterix = new Gaulois("asterix", 8);
		System.out.println(asterix);
	}

	public void boirePotion(int forcePotion) {
		effetPotion = forcePotion;
	}

	
	public void frapper(Romain romain) {
		System.out.println(nom + " envoie un grand coup dans la mâchoire de "
		+ romain.getNom());
		Equipement[] trgagnes = romain.recevoirCoup((force / 3) * effetPotion);
		effetPotion--;
		if (effetPotion < 1) {
		effetPotion = 1;
		}
		for (int i = 0; trgagnes != null && i < trgagnes.length; i++,
				nbTrophees++) {
		this.trophees[nbTrophees] = trgagnes[i];
		}
	}

	
	public void sePresenter() {
		String presentation = "Le Gaulois " + nom + " : \"Bonjour, je m'appelle " + nom;
		if (village==null) {
			System.out.println(presentation + ". Je voyage de villages en villages.\"");
		}
		else if (village.getChef() == this) { 
	        System.out.println(presentation + ". Je suis le chef du village " + village.getNom() + ".\"");
		}
	    else {
	        System.out.println(presentation + ". J'habite le village " + village.getNom() + ".\"");
	    }
	}

	@Override
	public String toString() {
		return "" + nom + "";
	}

}
