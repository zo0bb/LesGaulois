package village_gaulois;

import personnages.Gaulois;

public class Village {

	private String nom;
	private int nbVillageois = 0;
	private Gaulois[] villageois ;
	private Gaulois chef;
	
	public Village(String nom, Gaulois chef, int nbVillageoisMax) {
		this.nom = nom;
		this.villageois = new Gaulois[nbVillageoisMax];
		this.chef = chef;
		this.chef.setVillage(this);
	}
	

	public String getNom() {
		return nom;
	}
	
	public Gaulois getChef() {
		return chef;
	}
	

	public void ajouterVillageois(Gaulois gaulois) {
		villageois[nbVillageois] = gaulois;
		nbVillageois++;
		gaulois.setVillage(this);
	}

	public Gaulois trouverVillageois(int numVillageois) {
		if (numVillageois>0 && numVillageois<=nbVillageois) {
			return villageois[numVillageois-1];
		}
		else {
			System.out.println("Il n'y a pas autant d'habitant dans notre village !");
			return null;
		}
	}
	
	public static void main(String[] args) {
		Gaulois abraracourcix = new Gaulois("Abraracourcix", 6);
		Village village = new Village("Village des Irréductibles", abraracourcix, 30);
		village.trouverVillageois(30);
		Gaulois asterix = new Gaulois("Astérix", 8);
		village.ajouterVillageois(asterix);
		Gaulois gaulois = village.trouverVillageois(1);
		System.out.println(gaulois);
		gaulois = village.trouverVillageois(2);
		System.out.println(gaulois);
		village.afficherVillageois();
		
		Gaulois obelix = new Gaulois("Obélix", 25);
		village.ajouterVillageois(obelix);
		village.afficherVillageois();
		Gaulois doublepolémix = new Gaulois("Doublepolémix", 4);
		abraracourcix.sePresenter();
		asterix.sePresenter();
		doublepolémix.sePresenter();

	}

	public void afficherVillageois() {
		System.out.println("Dans le village \"" + nom + "\" du chef " + chef + " vivent les légendaires gaulois :");
		for (int i = 0; i < nbVillageois; i++) {
			System.out.println("- " + villageois[i]);
		}
	}
	
	public void afficherVillage() {

	}

}
