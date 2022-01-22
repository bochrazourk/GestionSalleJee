package beans;

public class Salle {

	private int id;
	private String type;
	private String code;
	
	public Salle(int id, String type, String code) {
		this.id = id;
		this.type = type;
		this.code = code;
	}

	public Salle(String type, String code) {
		super();
		this.type = type;
		this.code = code;
	}
	
	public Salle(int  id, String code) {
		super();
		this.id = id;
		this.code = code;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	@Override
	public String toString() {
		return "Salle [id=" + id + ", type=" + type + ", code=" + code + "]";
	}
	
	
	
	
}
