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
	
	public int getForce() {
		return force;
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
	
	public Equipement[] recevoirCoup(int forceCoup) {
		Equipement[] equipementEjecte = null;
		forceCoup = calculerResistanceEquipement(forceCoup);
		force -= forceCoup;
		if (force == 0) {
		parler("Aïe");
		}
		else {
		equipementEjecte = ejecterEquipement();
		parler("J'abandonne...");
		}
		return equipementEjecte;
		}

	private int calculerResistanceEquipement(int forceCoup) {
		String texte = "Ma force est de " + this.force + ", et la force du coup est de " + forceCoup;
		int resistanceEquipement = 0;
		if (nbEquipement != 0) {
			texte += "\n Mais heureusement, grace à mon équipement sa force est diminué de ";
			for (int i = 0; i < nbEquipement; i++) {
					if ((tabEquipements[i] != null && tabEquipements[i].equals(Equipement.BOUCLIER))) {
						resistanceEquipement += 8;
					} else {
						System.out.println("Equipement casque");
						resistanceEquipement += 5;
					}
			}
			texte += resistanceEquipement + "!";
		}
		parler(texte);
		forceCoup -= resistanceEquipement;
		if (forceCoup < 0) {
	        forceCoup = 0;
	    }
		return forceCoup;
	}
	
	private Equipement[] ejecterEquipement() {
		Equipement[] equipementEjecte = new Equipement[nbEquipement];
		System.out.println("L'équipement de " + nom + " s'envole sous la force du coup.");
		int nbEquipementEjecte = 0;
		for (int i = 0; i < nbEquipement; i++) {
		if (tabEquipements[i] == null) {
		} else {
		equipementEjecte[nbEquipementEjecte] = tabEquipements[i];
		nbEquipementEjecte++;
		tabEquipements[i] = null;
		}
		}
		return equipementEjecte;
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
