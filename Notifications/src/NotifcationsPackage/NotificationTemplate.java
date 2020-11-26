package NotifcationsPackage;

import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.HashMap;

public abstract class NotificationTemplate {
	
	public HashMap <String, String> argumentsList = new HashMap <String, String>();
	public abstract void getPlaceholders(String currentTemplate);
	public abstract void create(String newTemplate);

	public String read(String table, String id) throws SQLException 
	{
		DBConnection.initiateConnection();
		String sql = String.format("SELECT template FROM %s WHERE id= ?", table);
		PreparedStatement st = DBConnection.myConn.prepareStatement(sql);
		st.setString(1, id);
		var rs = st.executeQuery();
		rs.next();
		String template = rs.getString("template");
		return template;
	}

	public abstract void update(String newTemplate);
	public void delete() {}
}
