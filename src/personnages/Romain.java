package personnages;

import objets.Equipement;

public class Romain {
	
	private String nom;
	private int force;
	private Equipement[] tabEquipements;
	private int nbEquipement = 0;
	
	
	public Romain(String nom, int force) {
		super();
		this.nom = nom;
		this.force = force;
		this.tabEquipements = new Equipement[2];
		assert isInvariantVerified();
	}
	
	private boolean isInvariantVerified() {
		return force>=0;
	}

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
	
	public int sEquiper(Equipement equipement) {
		String presentation = "Le soldat " + nom;
		switch (nbEquipement) {
		
		case 2:
			System.out.println( presentation + " est déjà bien protégé !");
			break;
		case 1:
			if (tabEquipements[0]==equipement) {
				System.out.println(presentation + " possède déjà un " + equipement + " ! ");
			}
			else {
				tabEquipements[1]=equipement;
				nbEquipement++;
				System.out.println(presentation + " s'équipe avec un " + equipement + ". ");
			}
			break;
			
		default:
			tabEquipements[0]=equipement;
			nbEquipement++;
			System.out.println( presentation + " s'équipe avec un " + equipement + ". ");
			break;

		}
		return nbEquipement;
	}
	
	public static void main(String[] args) {
		Romain minus = new Romain("Minus", 6);
		minus.sEquiper(Equipement.CASQUE);
		minus.sEquiper(Equipement.CASQUE);
		minus.sEquiper(Equipement.BOUCLIER);
		minus.sEquiper(Equipement.CASQUE);
	}
	
	
	

}
