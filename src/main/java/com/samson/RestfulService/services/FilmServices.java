package com.samson.RestfulService.services;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Controller;

import com.samson.RestfulService.BO.FilmBO;
import com.samson.RestfulService.DB.DBUtils;

@Controller
public class FilmServices implements IFilmServices{
	
	@Override
	public List<FilmBO> findAllFilms() {
		// TODO Auto-generated method stub
		
		//Create listfilmBO
		List<FilmBO> listfilmbo=new ArrayList<FilmBO>();
		
		//Create connection
		Connection conn=DBUtils.getSQLConn();
		PreparedStatement pr=null;
		ResultSet rs=null;
		
		try {
			pr=conn.prepareStatement("select film_id,title,description,release_year from film");
			rs=pr.executeQuery();
			
			while(rs.next())
			{
				FilmBO filmbo=new FilmBO();
				filmbo.setFilm_id(rs.getInt("film_id"));
				filmbo.setTitle(rs.getString("title"));
				filmbo.setDescription(rs.getString("description"));
				filmbo.setRelease_year(rs.getInt("release_year"));
				
				//add filmbo's to the arraylist
				listfilmbo.add(filmbo);
			}
			
			return listfilmbo;
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		finally{
			DBUtils.closeDBConnection(null, rs, conn, pr);
		}
		
		return null;
	}

	@Override
	public FilmBO findFilmById(int id) {
		// TODO Auto-generated method stub
		
		Connection conn=DBUtils.getSQLConn();
		PreparedStatement pr=null;
		ResultSet rs=null;
		FilmBO filmbo=null;
		
		try {
			pr=conn.prepareStatement("select film_id,title,description,release_year from film where film_id=?");
			pr.setInt(1, id);
			rs=pr.executeQuery();
			
			if(rs.next())
			{
				filmbo=new FilmBO();
				filmbo.setFilm_id(rs.getInt("film_id"));
				filmbo.setTitle(rs.getString("title"));
				filmbo.setDescription(rs.getString("description"));
				filmbo.setRelease_year(rs.getInt("release_year"));
			}
			
			return filmbo;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		finally
		{
			DBUtils.closeDBConnection(null, rs, conn, pr);
		}
		return null;
	}

	@Override
	public List<FilmBO> insertFilm(FilmBO bo) {
		// TODO Auto-generated method stub
		
		Connection conn=DBUtils.getSQLConn();
		PreparedStatement pr=null;
		
		try {
			pr=conn.prepareStatement( "insert into film(title,description,release_year,language_id) values(?,?,?,1)" );
			pr.setString(1, bo.getTitle());
			pr.setString(2, bo.getDescription());
			pr.setInt(3, bo.getRelease_year());
			
			pr.execute();
		
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		finally{
			DBUtils.closeDBConnection(null, null, conn, pr);
		}
		
		return findAllFilms();
	}

	@Override
	public List<FilmBO> deleteFilm(int id) {
		// TODO Auto-generated method stub
		return null;
	}

}
