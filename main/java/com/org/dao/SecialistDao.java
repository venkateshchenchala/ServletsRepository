package com.org.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.org.entity.Specalist;
import com.org.helper.ConnetionHelper;

public class SecialistDao
{
private Connection con =  ConnetionHelper.GetConObj();
	
	public boolean addSpecialist(String name) {
		boolean f = false ; 
		try {
			
			String sql = "INSERT INTO specialist(spec_name) VALUES(?)" ;
			PreparedStatement ps = con.prepareStatement(sql) ;
			ps.setString(1, name);
			
			int i = ps.executeUpdate() ;
			
			if(i==1) {
				f = true ;
			}
			
		}catch (Exception e) {
			e.printStackTrace(); 
		}	
		return f ;
	}
	
	public List<Specalist> getAllSpecialist(){
		List<Specalist> list = new ArrayList<Specalist>() ; 
		Specalist s = null ;
		
		try {
			String sql = "SELECT * FROM specialist" ;
			PreparedStatement ps = con.prepareStatement(sql) ;
			ResultSet rs = ps.executeQuery() ;
			while(rs.next()) {
				s= new com.org.entity.Specalist() ;
				s.setId(rs.getInt(1));
				s.setSpecialistName(rs.getString(2));
				list.add(s) ;
			}			
		}catch (Exception e) {
			e.printStackTrace();
		}		
		return list ;
	}
}

