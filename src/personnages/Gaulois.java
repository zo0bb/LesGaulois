package personnages;

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
	private int force;
	private int effetPotion = 1;
	private int forceCoup;
	private Village village;

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
		String nomRomain = romain.getNom();
		System.out.println(nom + " envoie un grand coup dans la mâchoire de " + nomRomain);
		forceCoup = force * effetPotion;
		forceCoup = forceCoup / 3;
		romain.recevoirCoup(forceCoup);
		if (effetPotion > 1) {
			effetPotion--;
		} else {
			System.out.println("L'effet se dissipe");
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
