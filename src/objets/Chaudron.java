package objets;

public class Chaudron {
	public Chaudron(int quantitePotion, int forcePotion) {
		super();
		this.quantitePotion = quantitePotion;
		this.forcePotion = forcePotion;
	}
	private int quantitePotion;
	private int forcePotion;
	
	public void remplirChaudron(int quantite, int forcePotion) {
		quantitePotion = quantite;
		forcePotion = forcePotion;
	}
	
	public boolean resterPotion() {
		if (quantitePotion==0) {
			return false;
		}
		return true;
	}
	
	public void prendreLouche() {
		
	}
}
