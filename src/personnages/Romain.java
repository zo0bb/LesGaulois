package personnages;

public class Romain {
	public Romain(String nom, int force) {
		super();
		this.nom = nom;
		this.force = force;
		assert isInvariantVerified();
	}
	
	private boolean isInvariantVerified() {
		return force>=0;
	}
	

	private String nom;
	private int force;
	

	public String getNom() {
		return nom;
	}

	public void parler(String texte) {
		System.out.println(prendreParole() + "\"" + texte + "\"");
	}

	private String prendreParole() {
		return "Le romain " + nom + " : ";
	}

	@Override
	public String toString() {
		return "" + nom + "";
	}
	
	

	public void recevoirCoup(int forceCoup) {
		assert isInvariantVerified();
		int forceBase = force;
		force = force - forceCoup;
		if (force < 1) {
			force = 0;
			parler("J'abandonne !");
		} else {
			parler("Aïe " + force);
		}
		assert force < forceBase;
	}
	
	public static void main(String[] args) {
		Romain minus = new Romain("Minus", 6);
		
	}
	
	
	

}
