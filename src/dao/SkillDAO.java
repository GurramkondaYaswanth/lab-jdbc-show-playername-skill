package dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import model.Skill;
import utility.ConnectionManager;

public class SkillDAO{
	

	public Skill getSkillBylD(Long id) throws SQLException {
		Connection con = ConnectionManager.getConnection();
		Statement stmt=  con.createStatement();
		ResultSet rs =stmt.executeQuery("SELECT * FROM SKILL");
		while(rs.next())
		{
			if(id.equals(rs.getLong("ID")))
			{
				//long id=rs.getLong(1);
				String name=rs.getString(2);
				Skill skill=new Skill(id,name);
//			System.out.println("skil Id : "+rs.getLong(1));
//			System.out.println("skill Name : "+rs.getString(2));
			return skill;
			}
			
		}
		return null;
		
	}
}