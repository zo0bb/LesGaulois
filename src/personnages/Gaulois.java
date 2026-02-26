package personnages;

public class Gaulois {
	public Gaulois(String nom, int force) {
		super();
		this.nom = nom;
		this.force = force;
	}
	private String nom;
	private int force;
	
	public String getNom() {
		return nom;
	}
	
	public void parler(String texte) {
		System.out.println(prendreParole()+ "\"" + texte + "\"");
	}

	private String prendreParole() {
		
		return "Le gaulois" + nom + " : ";
	}
	
	
}
