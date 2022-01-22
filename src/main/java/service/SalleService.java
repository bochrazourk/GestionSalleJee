package service;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import beans.Salle;
import connexion.Connexion;
import dao.IDao;

public class SalleService implements IDao<Salle>  {

	@Override
	public boolean create(Salle o) {
		String sql = "insert into salle values (null, ?, ?)";
        try {
            PreparedStatement ps = Connexion.getInstane().getConnection().prepareStatement(sql);
            ps.setString(1, o.getType());
            ps.setString(2, o.getCode());
            if (ps.executeUpdate() == 1) {
                return true;
            }
        } catch (SQLException e) {
            System.out.println("create : erreur sql : " + e.getMessage());

        }
        return false;
	}

	@Override
	public boolean delete(Salle o) {
		String sql = "delete from salle where id  = ?";
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
	public boolean update(Salle o) {
		String sql = "update salle set type  = ? ,code = ? where id  = ?";
        try {
            PreparedStatement ps = Connexion.getInstane().getConnection().prepareStatement(sql);
            ps.setString(1, o.getType());
            ps.setString(2, o.getCode());
            ps.setInt(3, o.getId());
            if (ps.executeUpdate() == 1) {
                return true;
            }
        } catch (SQLException e) {
            System.out.println("update : erreur sql : " + e.getMessage());

        }
        return false;
	}
	
	public boolean update(Salle o, int id) {
		String sql = "update salle set type  = ? ,code = ? where id  = ?";
        try {
            PreparedStatement ps = Connexion.getInstane().getConnection().prepareStatement(sql);
            ps.setString(1, o.getType());
            ps.setString(2, o.getCode());
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
	public Salle findById(int id) {
		Salle m = null;
        String sql = "select * from salle where id  = ?";
        try {
            PreparedStatement ps = Connexion.getInstane().getConnection().prepareStatement(sql);
            ps.setInt(1, id);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                return new Salle(rs.getInt("id"), rs.getString("type"), rs.getString("code"));
            }

        } catch (SQLException e) {
            System.out.println("findById " + e.getMessage());
        }
        return null;
	}

	@Override
	public List<Salle> findAll() {
		List<Salle> salles = new ArrayList<Salle>();

        String sql = "select * from salle";
        try {
            PreparedStatement ps = Connexion.getInstane().getConnection().prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                salles.add(new Salle(rs.getInt("id"), rs.getString("type"), rs.getString("code")));
            }

        } catch (SQLException e) {
            System.out.println("findAll " + e.getMessage());
        }
        return salles;
	}
	
	
	
	public List<Salle> findSalleByCode(String code) {
        List<Salle> salles = new ArrayList<Salle>();

        String sql = "select * from salle where code =  ?";
        try {
            PreparedStatement ps = Connexion.getInstane().getConnection().prepareStatement(sql);;
            ps.setString(1, code);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                salles.add(new Salle(rs.getInt("id"), rs.getString("type"), rs.getString("code")));
            }

        } catch (SQLException e) {
            System.out.println("findAll " + e.getMessage());
        }
        return salles;
    }
	
	 public List<String> findType() {
	        List<String> types = new ArrayList<String>();
	        String sql = "select distinct(type) as co from salle";
	        try {
	            PreparedStatement ps = Connexion.getInstane().getConnection().prepareStatement(sql);;
	            ResultSet rs = ps.executeQuery();
	            while (rs.next()) {
	                types.add(rs.getString("co"));
	            }
	        } catch (SQLException e) {
	            System.out.println("findCode " + e.getMessage());
	        }
	        return types;
	    }
	 
	 public int countSalle() {
	    	SalleService ms = new SalleService();
	        int count = 0 ;

	        String sql = "select count(*) as count from salle ";
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
