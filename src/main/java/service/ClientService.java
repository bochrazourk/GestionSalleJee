package service;
import connexion.Connexion;
import dao.IDao;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.sql.ResultSet;
import beans.Client;
import beans.Salle;
public class ClientService implements IDao<Client> {

	@Override
	public boolean create(Client o) {
		String sql = "insert into client values (null, ?, ?)";
        try {
            PreparedStatement ps = Connexion.getInstane().getConnection().prepareStatement(sql);
            ps.setString(1, o.getNom());
            ps.setString(2, o.getPrenom());
            if (ps.executeUpdate() == 1) {
                return true;
            }
        } catch (SQLException e) {
            System.out.println("create : erreur sql : " + e.getMessage());

        }
        return false;
	}

	@Override
	public boolean delete(Client o) {
		String sql = "delete from client where id  = ?";
        try {
            PreparedStatement ps = Connexion.getInstane().getConnection().prepareStatement(sql);
            ps.setInt(1, o.getId());
            if (ps.executeUpdate() == 1) {
                return true;
            }
        } catch (SQLException e) {
            System.out.println("delete : erreur sql : " + e.getMessage());

        }
        return false;
	}

	@Override
	public boolean update(Client o) {
		String sql = "update client set nom  = ? ,prenom = ? where id  = ?";
        try {
            PreparedStatement ps = Connexion.getInstane().getConnection().prepareStatement(sql);
            ps.setString(1, o.getNom());
            ps.setString(2, o.getPrenom());
            ps.setInt(3, o.getId());
            if (ps.executeUpdate() == 1) {
                return true;
            }
        } catch (SQLException e) {
            System.out.println("update : erreur sql : " + e.getMessage());

        }
        return false;
	}
	
	public boolean update(Client o, int id) {
		String sql = "update client set nom  = ? , prenom= ? where id  = ?";
        try {
            PreparedStatement ps = Connexion.getInstane().getConnection().prepareStatement(sql);
            ps.setString(1, o.getNom());
            ps.setString(2, o.getPrenom());
            ps.setInt(3, id);
            if (ps.executeUpdate() == 1) {
                return true;
            }
        } catch (SQLException e) {
            System.out.println("update : erreur sql : " + e.getMessage());

        }
        return false;
	}

	@Override
	public Client findById(int id) {
		Salle m = null;
        String sql = "select * from client where id  = ?";
        try {
            PreparedStatement ps = Connexion.getInstane().getConnection().prepareStatement(sql);
            ps.setInt(1, id);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                return new Client(rs.getInt("id"), rs.getString("nom"), rs.getString("prenom"));
            }

        } catch (SQLException e) {
            System.out.println("findById " + e.getMessage());
        }
        return null;
	}

	@Override
	public List<Client> findAll() {
		List<Client> clients = new ArrayList<Client>();

        String sql = "select * from client";
        try {
            PreparedStatement ps = Connexion.getInstane().getConnection().prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                clients.add(new Client(rs.getInt("id"), rs.getString("nom"), rs.getString("prenom")));
            }

        } catch (SQLException e) {
            System.out.println("findAll " + e.getMessage());
        }
        return clients;
	}
	
	
	
	public List<Client> findClientByNom(String nom) {
        List<Client> clients = new ArrayList<Client>();

        String sql = "select * from client where nom =  ?";
        try {
            PreparedStatement ps = Connexion.getInstane().getConnection().prepareStatement(sql);;
            ps.setString(1, nom);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                clients.add(new Client(rs.getInt("id"), rs.getString("nom"), rs.getString("prenom")));
            }

        } catch (SQLException e) {
            System.out.println("findAll " + e.getMessage());
        }
        return clients;
    }
	
	 public List<String> findNom() {
	        List<String> types = new ArrayList<String>();
	        String sql = "select distinct(Nom) as co from Client";
	        try {
	            PreparedStatement ps = Connexion.getInstane().getConnection().prepareStatement(sql);;
	            ResultSet rs = ps.executeQuery();
	            while (rs.next()) {
	                types.add(rs.getString("co"));
	            }
	        } catch (SQLException e) {
	            System.out.println("findNom " + e.getMessage());
	        }
	        return types;
	    }
	 
	 public int countClient() {
	    	ClientService ms = new ClientService();
	        int count = 0 ;

	        String sql = "select count(*) as count from client ";
	        try {
	            PreparedStatement ps = Connexion.getInstane().getConnection().prepareStatement(sql);
	            ResultSet rs = ps.executeQuery();
	            while (rs.next()) {
	                count = rs.getInt("count");
	            }

	        } catch (SQLException e) {
	            System.out.println("findAll " + e.getMessage());
	        }

	        return count;
	    }

	}
