package personnages;

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

	public String getNom() {
		return nom;
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

	public void frapper(Romain romain) {
		String nomRomain = romain.getNom();
		System.out.println(nom + "envoie un grand coup dans la mâchoire de " + nomRomain);
		int forceCoup = force / 3;
		romain.recevoirCoup(forceCoup);
	}

	public void boirePotion(int forcePotion) {

	}

	@Override
	public String toString() {
		return "" + nom + "";
	}

}
