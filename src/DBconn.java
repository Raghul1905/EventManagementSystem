
import java.sql.*;

public class DBconn {
	public static Connection connectDB()
	{
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/EventManagement",
					"root", "Rama@2002");
			System.out.println(con);
			return con;
		}
		catch (SQLException | ClassNotFoundException e) {
			System.out.println(e);
			return null;
		}
	}

	public int  insertEvent(Event event) throws SQLException {
		Connection conn = connectDB();
		String sql = "INSERT INTO events (name,date,location,capacity) VALUES (?,?,?,?)";
		PreparedStatement stmt = conn.prepareStatement(sql,Statement.RETURN_GENERATED_KEYS);
		stmt.setString(1, event.getName());
		stmt.setString(2, event.getDate());
		stmt.setString(3,event.getLocation());
		stmt.setInt(4,event.getCapacity());
		int generatedeventId=-1;
		int rowsInserted = stmt.executeUpdate();
		if (rowsInserted > 0) {
			ResultSet rs = stmt.getGeneratedKeys();
			if (rs.next()) {
				generatedeventId = rs.getInt(1); // Retrieve the auto-generated reg_id
			}
		}
		return generatedeventId;

	}
	public void getEvents() throws SQLException {
		Connection conn=connectDB();
		String sql = "SELECT * FROM events";
		PreparedStatement stmt = conn.prepareStatement(sql);
		ResultSet rs = stmt.executeQuery();

		while (rs.next()) {
			System.out.println(rs.getInt(1)+"  "+rs.getString(2)
					+"   "+rs.getString(3)+"  "+rs.getString(4)+"  "+rs.getInt(5));
		}
	}
	public void UpdateEventName(int id,String name) throws SQLException {
		Connection conn = connectDB();
		String sql = "UPDATE events SET name=? WHERE event_id=?";
		PreparedStatement stmt = conn.prepareStatement(sql);
		stmt.setString(1,name);
		stmt.setInt(2,id);
		stmt.executeUpdate();
	}
	public void UpdateEventDate(int id,String date) throws SQLException {
		Connection conn = connectDB();
		String sql = "UPDATE events SET name=? WHERE event_id=?";
		PreparedStatement stmt = conn.prepareStatement(sql);
		stmt.setString(1,date);
		stmt.setInt(2,id);
		stmt.executeUpdate();
	}
	public void UpdateEventLocation(int id,String location) throws SQLException {
		Connection conn = connectDB();
		String sql = "UPDATE events SET name=? WHERE event_id=?";
		PreparedStatement stmt = conn.prepareStatement(sql);
		stmt.setString(1,location);
		stmt.setInt(2,id);
		stmt.executeUpdate();
	}
	public void UpdateEventCapacity(int id,int capacity) throws SQLException {
		Connection conn = connectDB();
		String sql = "UPDATE events SET capacity=? WHERE event_id=?";
		PreparedStatement stmt = conn.prepareStatement(sql);
		stmt.setInt(1,capacity);
		stmt.setInt(2,id);
		stmt.executeUpdate();
	}
	public void removeEvent(int id) throws SQLException {
		Connection conn = connectDB();
		String sql = "DELETE FROM events WHERE event_id=?";
		PreparedStatement stmt = conn.prepareStatement(sql);
		stmt.setInt(1,id);
		stmt.executeUpdate();

	}
	public int insertParticipant(Participant participant) throws SQLException {
		Connection conn = connectDB();
		String sql = "INSERT INTO participants (name,email,phone_number) VALUES ( ?,?,?)";
		PreparedStatement stmt = conn.prepareStatement(sql,Statement.RETURN_GENERATED_KEYS);
		stmt.setString(1, participant.getName());
		stmt.setString(2, participant.getEmail());
		stmt.setString(3, participant.getPhone_number());
		int generatedParticipantId = -1;
		int rowsInserted = stmt.executeUpdate();
		if (rowsInserted > 0) {
			ResultSet rs = stmt.getGeneratedKeys();
			if (rs.next()) {
				generatedParticipantId = rs.getInt(1); // Retrieve the auto-generated reg_id
			}
		}
		return generatedParticipantId;
	}
	public void getParticipants() throws SQLException {
		Connection conn=connectDB();
		String sql = "SELECT * FROM participants";
		PreparedStatement stmt = conn.prepareStatement(sql);
		ResultSet rs = stmt.executeQuery();

		while (rs.next()) {
			System.out.println(rs.getInt(1)+"  "+rs.getString(2)
					+"   "+rs.getString(3)+"  "+rs.getString(4));
		}
	}
	public void UpdatePartcipantName(int id,String name) throws SQLException {
		Connection conn = connectDB();
		String sql = "UPDATE participants SET name=? WHERE participant_id=?";
		PreparedStatement stmt = conn.prepareStatement(sql);
		stmt.setString(1,name);
		stmt.setInt(2,id);
		stmt.executeUpdate();
	}
	public void UpdateParticipantEmail(int id,String email) throws SQLException {
		Connection conn = connectDB();
		String sql = "UPDATE participants SET email=? WHERE participant_id=?";
		PreparedStatement stmt = conn.prepareStatement(sql);
		stmt.setString(1,email);
		stmt.setInt(2,id);
		stmt.executeUpdate();
	}

	public void UpdateParticipantPhoneNumber(int id,String phone_number) throws SQLException {
		Connection conn = connectDB();
		String sql = "UPDATE participants SET phone_number=? WHERE event_id=?";
		PreparedStatement stmt = conn.prepareStatement(sql);
		stmt.setString(1,phone_number);
		stmt.setInt(2,id);
		stmt.executeUpdate();
	}
	public void removeParticipant(int id) throws SQLException {
		Connection conn = connectDB();
		String sql = "DELETE FROM participants WHERE participant_id=?";
		PreparedStatement stmt = conn.prepareStatement(sql);
		stmt.setInt(1, id);
		stmt.executeUpdate();
	}
	public int registerparticipantforevent(Registeration reg) throws SQLException {
		Connection conn = connectDB();
		String sql = "INSERT INTO registration (event_id,participant_id,date) VALUES (?,?,?)";
		PreparedStatement stmt = conn.prepareStatement(sql,Statement.RETURN_GENERATED_KEYS);
		stmt.setInt(1,reg.getEvent_id());
		stmt.setInt(2,reg.getParticipant_id());
		stmt.setString(3,reg.getDate());
		int generatedRegId = -1;
		int rowsInserted = stmt.executeUpdate();
		if (rowsInserted > 0) {
			ResultSet rs = stmt.getGeneratedKeys();
			if (rs.next()) {
				generatedRegId = rs.getInt(1); // Retrieve the auto-generated reg_id
			}
		}
		ChangeCapacity(reg.getEvent_id(),-1);
		return generatedRegId;
	}
	public void cancelregisteration(int reg_id) throws SQLException {

		Connection conn = connectDB();
		String sql="Select event_id from registration where registration_id=?";
		PreparedStatement stmt = conn.prepareStatement(sql);
		stmt.setInt(1,reg_id);
		int event_id=0;
		ResultSet rs = stmt.executeQuery();
		while(rs.next()) {
			event_id = rs.getInt(1);
		}
		System.out.println(event_id);
		sql = "DELETE FROM registration WHERE registration_id=?";
		stmt = conn.prepareStatement(sql);
		stmt.setInt(1,reg_id);
		stmt.executeUpdate();
		ChangeCapacity(event_id,1);
	}
	public void viewregisterationdetails() throws SQLException {
		Connection conn=connectDB();
		String sql = "SELECT * FROM registration";
		PreparedStatement stmt = conn.prepareStatement(sql);
		ResultSet rs = stmt.executeQuery();

		while (rs.next()) {
			System.out.println(rs.getInt(1)+"  "+rs.getInt(2)
					+"   "+rs.getInt(3)+"  "+rs.getString(4));
		}
	}
	public void getParticipantsOfEvent(int event_id) throws SQLException {
		Connection conn = connectDB();
		String sql = "SELECT p.* FROM participants p JOIN registration r ON p.participant_id = r.participant_id WHERE r.event_id = ?";
		PreparedStatement stmt = conn.prepareStatement(sql);
		stmt.setInt(1,event_id);
		ResultSet rs = stmt.executeQuery();
		while (rs.next()) {
			System.out.println(rs.getInt(1)+"  "+rs.getString(2)
					+"   "+rs.getString(3)+"  "+rs.getString(4));
		}


	}
	public void ChangeCapacity(int event_id,int capacity) throws SQLException {
		System.out.println(event_id);
		Connection conn = connectDB();
		String sql = "SELECT capacity FROM events WHERE event_id=?";

		PreparedStatement stmt = conn.prepareStatement(sql);
		stmt.setInt(1,event_id);
		ResultSet rs = stmt.executeQuery();
		int old_capacity=0;
		while(rs.next()) {
			old_capacity=rs.getInt(1);
		}
		System.out.println(old_capacity);
		String sql1 = "UPDATE events SET capacity=? WHERE event_id=?";
		PreparedStatement stmt1 = conn.prepareStatement(sql1);
		stmt1 = conn.prepareStatement(sql1);
		stmt1.setInt(1,capacity+old_capacity);
		stmt1.setInt(2,event_id);
		stmt1.executeUpdate();
	}

}
