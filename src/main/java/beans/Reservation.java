package beans;

import java.util.Date;

public class Reservation {

    private int id;
    private String reference;
    private Date dateReservation;
    private String nomClient;
    private int idSalle;
    private Salle salle;
    private int count;
    
    
   
    
    public Reservation(int id, String reference, Salle salle, int count) {
		super();
		this.id = id;
		this.reference = reference;
		this.salle = salle;
		this.count = count;
	}



	public Reservation(String reference, Salle salle, int count) {
		super();
		this.reference = reference;
		this.salle = salle;
		this.count = count;
	}



	public Reservation(int id, String reference, Date dateReservation, String nomClient, int idSalle) {
        super();
        this.id = id;
        this.reference = reference;
        this.dateReservation = dateReservation;
        this.nomClient = nomClient;
        this.idSalle = idSalle;
    }
    
    
    
    public Reservation(String reference, Date dateReservation, String nomClient, Salle salle) {
		super();
		this.reference = reference;
		this.dateReservation = dateReservation;
		this.nomClient = nomClient;
		this.salle = salle;
	}



	public Reservation(int id, String reference, Date dateReservation, String nomClient, Salle salle) {
		super();
		this.id = id;
		this.reference = reference;
		this.dateReservation = dateReservation;
		this.nomClient = nomClient;
		this.salle = salle;
	}



	public Reservation(String reference, Date dateReservation, String nomClient, int idSalle) {
        super();
        this.reference = reference;
        this.dateReservation = dateReservation;
        this.nomClient = nomClient;
        this.idSalle = idSalle;
    }

    public Reservation(String reference, Date dateReservation, String nomClient) {
        super();
        this.reference = reference;
        this.dateReservation = dateReservation;
        this.nomClient = nomClient;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getReference() {
        return reference;
    }

    public void setReference(String reference) {
        this.reference = reference;
    }

    public Date getDateReservation() {
        return dateReservation;
    }

    public void setDateReservation(Date dateReservation) {
        this.dateReservation = dateReservation;
    }

    public String getnomClient() {
        return nomClient;
    }

    public void setnomClient(String nomClient) {
        this.nomClient = nomClient;
    }
    
    

    public int getIdSalle() {
		return idSalle;
	}

	public void setIdSalle(int idSalle) {
		this.idSalle = idSalle;
	}

	@Override
    public String toString() {
        return this.id + " " + this.reference;
    }

}
