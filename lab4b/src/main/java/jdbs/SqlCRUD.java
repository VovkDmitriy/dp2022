package jdbs;


import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import insect.Insect;
import servlets.LabCRUDInterface;

public class SqlCRUD implements LabCRUDInterface<Insect> {

Connection connection;
	
	
	public SqlCRUD() {
		
		this.connection = new Connect().getCon();
		System.out.println(connection);
		
	}

	public Connection getConnection() {
		return connection;
	}

	public void setConnection(Connection connection) {
		this.connection = connection;
	}

	@Override
	public void create(Insect t) {
		// TODO Auto-generated method stub
		try (PreparedStatement st = connection.prepareStatement("INSERT INTO insect (\"title\",\"age\",\"desc\") " + "VALUES (?,?,?)")) {
			st.setString(1, t.getTitle());
			st.setInt(2, t.getAge());
			st.setString(3, t.getDesc());
			st.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	@Override
	public List<Insect> read() {
		// TODO Auto-generated method stub
		List<Insect> list = new ArrayList<>();

		try (Statement st = connection.createStatement(); 
				ResultSet rs = st.executeQuery("SELECT * FROM insect;");) {
			while (rs.next()) {
				list.add(new Insect(rs.getInt(1), rs.getString(2), rs.getInt(3), rs.getString(4)));
			}

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return list;
	}

	@Override
	public void update(int id, Insect t) {
		// TODO Auto-generated method stub
		try (PreparedStatement st = connection
				.prepareStatement("UPDATE insect " + "SET \"title\"=?, \"age\"=?, \"desc\"=? WHERE id=?;")) {
			st.setString(1, t.getTitle());
			st.setInt(2, t.getAge());
			st.setString(3, t.getDesc());
			st.setInt(4, id);
			st.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	@Override
	public void delete(int id) {
		// TODO Auto-generated method stub
		try (PreparedStatement st = connection
				.prepareStatement("DELETE FROM insect WHERE id=?;")) {
			st.setInt(1, id);			
			st.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

}
