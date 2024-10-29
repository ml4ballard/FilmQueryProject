package com.skilldistillery.filmquery.database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import com.skilldistillery.filmquery.entities.Actor;
import com.skilldistillery.filmquery.entities.Film;

public class DatabaseAccessorObject implements DatabaseAccessor {
	private static final String URL = "jdbc:mysql://localhost:3306/sdvid";

	public DatabaseAccessorObject() {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	@Override
	public Film findFilmById(int filmId) throws SQLException {	
		Film film = null;
		String name = "student";
		String pwd = "student";
		
		String sql = "SELECT * from film where id = ?";
		
		Connection conn = DriverManager.getConnection(URL, name, pwd);
		PreparedStatement ps = conn.prepareStatement(sql);
		ps.setInt(1, filmId);
		ResultSet rs = ps.executeQuery();
		
		while ( rs.next() ) {
			 int id = rs.getInt("id");
			 String title = rs.getString("title");
			 String description = rs.getString("description");
			 Integer releaseYear = rs.getInt("release_year");
			 int languageId = rs.getInt("language_id");
			 int rentalDuration = rs.getInt("rental_duration");
			 double rentalRate = rs.getDouble("rental_rate");
			 int length = rs.getInt("length");
			 double replacementCost = rs.getDouble("replacement_cost");
			 String rating = rs.getString("rating");
			 String specialFeatures = rs.getString("special_features");

			film = new Film(id, title, description, releaseYear, languageId, rentalDuration, rentalRate, length, replacementCost, rating, specialFeatures);
	
			// the film exists now
			// now set its actors
			
			//film.setActors(finish this);
			
		} //end while and if

		ps.close();
		conn.close();	
		return film;
		
	} //end findFilmById
	
	@Override
	public Film findFilmsBySearchWord(String searchWord) throws SQLException {
		String name = "student";
		String pwd = "student";
		
        String sql = "SELECT * FROM film WHERE film.title LIKE ? OR film.description LIKE ?";

        Connection conn = DriverManager.getConnection(URL, name, pwd);
        PreparedStatement ps = conn.prepareStatement(sql);
        ps.setString(1, "%" + searchWord + "%");
        ps.setString(2, "%" + searchWord + "%");
        ResultSet rs = ps.executeQuery();

        int numberOfFilms = 0;
        
        while ( rs.next() ) {      	
			 int id = rs.getInt("id");
			 String title = rs.getString("title");
			 String description = rs.getString("description");
			 Integer releaseYear = rs.getInt("release_year");
/*			int languageId = rs.getInt("language_id");
			int rentalDuration = rs.getInt("rental_duration");
			double rentalRate = rs.getDouble("rental_rate");
			int length = rs.getInt("length");
			double replacementCost = rs.getDouble("replacement_cost");
*/
			String rating = rs.getString("rating");
//			String specialFeatures = rs.getString("special_features");	

			numberOfFilms++; 
			System.out.println("Number of films: " + numberOfFilms);
//	        System.out.println("Film ID:" + id + "\tFilm Name:" + title + "\t\t\tDescription: " + description);
	        System.out.println("Title:" + title + "Release Year: " + releaseYear + " rating: " + rating); 
	        System.out.println("Description: " + description + "\n");  
        } //end while	 
        if (numberOfFilms == 0) {
		    System.out.println("No film name or description found containing" + " searchWord.");
		} 
		
		return null;
	} //end findFilmsBySearchWord
	

	@Override
	public Actor findActorById(int actorId) {
		// TODO Auto-generated method stub
		return null;
	} //end findActorById

	@Override
	public List<Actor> findActorsByFilmId(int filmId) {
		// TODO Auto-generated method stub
		return null;
	} //end findActorsByFilmId

} //end class DatabaseAccessorObject implements DatabaseAccessor
