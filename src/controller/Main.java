package controller;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;

import dao.PlayerDAO;
import dao.SkillDAO;
import model.Player;
import model.Skill;

public class Main {

	public static void main(String[] args) throws NumberFormatException, IOException, ClassNotFoundException, SQLException 	{
		SkillDAO skilldao=new SkillDAO();
		PlayerDAO pd = new PlayerDAO();
		ArrayList<Player>  list= (ArrayList<Player>) pd.getAllPlayers();
		System.out.println(" List of all player and their skill");
		System.out.println("Id  Name      Country 	 Skill");
		//System.out.println("");
		for(Player p: list)
		{
			long Id = p.getPlayerId();
			String Name = p.getName();
			String Country = p.getCountry();
			String Skill = p.getSkill().getSkillName();
			
			int spaces = 10- (Name.length());  
			int spaces1 = 11 - (Country.length());
			if(spaces<0) {
				spaces = 0;
			}
			if(spaces1<0)
				spaces1=0;
			for(int i=0; i<spaces; i++) {
				Name = Name + " "; 
			}
			for(int j=0; j<spaces1; j++) {
				Country = Country + " "; 
			}
			
			String output = Id+"   "+Name+Country+Skill;
			System.out.println(output);
			//System.out.println(p.getPlayerId() +"  "+p.getName()+"   "+p.getCountry()+"   "+p.getSkill().getSkillName());
		}
	}
}

