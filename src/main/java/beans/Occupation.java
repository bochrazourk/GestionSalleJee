package beans;

import java.sql.Date;

public class Occupation {

	private Date date;
	private Salle salle;
	private Creneau creneau;
	private Client client;
	public Occupation(Date date, Salle salle, Creneau creneau, Client client) {
		super();
		this.date = date;
		this.salle = salle;
		this.creneau = creneau;
		this.client = client;
	}
	public Date getDate() {
		return date;
	}
	public void setDate(Date date) {
		this.date = date;
	}
	public Salle getSalle() {
		return salle;
	}
	public void setSalle(Salle salle) {
		this.salle = salle;
	}
	public Creneau getCreneau() {
		return creneau;
	}
	public void setCreneau(Creneau creneau) {
		this.creneau = creneau;
	}
	public Client getClient() {
		return client;
	}
	public void setClient(Client client) {
		this.client = client;
	}
	@Override
	public String toString() {
		return "Occupation [date=" + date + ", salle=" + salle + ", creneau=" + creneau + ", client=" + client + "]";
	}
}
