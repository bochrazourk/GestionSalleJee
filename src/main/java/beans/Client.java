package beans;

import java.util.List;

public class Client {
	private int id;
	private String nom;
	private String prenom;
	private List<Occupation> occupations;
	public Client(int id, String nom, String prenom, List<Occupation> occupations) {
		super();
		this.id = id;
		this.nom = nom;
		this.prenom = prenom;
		this.occupations = occupations;
	}


	public Client(int id, String nom, String prenom) {
		super();
		this.id = id;
		this.nom = nom;
		this.prenom = prenom;
	}
	public Client( String nom, String prenom) {
		
		
		this.nom = nom;
		this.prenom = prenom;
	}

	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getNom() {
		return nom;
	}
	public void setNom(String nom) {
		this.nom = nom;
	}
	public String getPrenom() {
		return prenom;
	}
	public void setPrenom(String prenom) {
		this.prenom = prenom;
	}
	public List<Occupation> getOccupations() {
		return occupations;
	}
	public void setOccupations(List<Occupation> occupations) {
		this.occupations = occupations;
	}
	@Override
	public String toString() {
		return "Client [id=" + id + ", nom=" + nom + ", prenom=" + prenom + ", occupations=" + occupations + "]";
	}

}
