package dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import model.Player;
import model.Skill;
import utility.ConnectionManager;

public class PlayerDAO{
	List<Player> list=new ArrayList<Player>();
	public List< Player > getAllPlayers() throws SQLException {
		Connection con = ConnectionManager.getConnection();
		Statement st = con.createStatement();
		SkillDAO sd = new SkillDAO();
		ResultSet rs = st.executeQuery("SELECT * FROM PLAYER");
		while(rs.next())
		{
			long id=rs.getLong(1);
			String name=rs.getString(2);
			String country =rs.getString(3);
			long skillId=rs.getLong(1);
			long teamId=rs.getLong(1);
			
			Skill skill=  sd.getSkillBylD(skillId);
			Player player = new Player(id,name,country,skill);
			list.add(player);
		}
		
		return list;
		
	}
	
}
