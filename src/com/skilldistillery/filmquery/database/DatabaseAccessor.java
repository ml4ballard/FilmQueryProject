package com.skilldistillery.filmquery.database;

import java.sql.SQLException;
import java.util.List;

import com.skilldistillery.filmquery.entities.Actor;
import com.skilldistillery.filmquery.entities.Film;

public interface DatabaseAccessor {  //You have provided a method to read the below

	public Film findFilmById(int filmId) throws SQLException;

	public Actor findActorById(int actorId);

	public List<Actor> findActorsByFilmId(int filmId);
	
	// public xxxxxxx findActorsByFilmId ( int filmId);
	// will retunrn a list of actor id's
	// already given see above
}
