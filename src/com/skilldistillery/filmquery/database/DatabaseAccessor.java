package com.skilldistillery.filmquery.database;

import java.sql.SQLException;
import java.util.List;

import com.skilldistillery.filmquery.entities.Actor;
import com.skilldistillery.filmquery.entities.Film;

public interface DatabaseAccessor {  //You have provided a method to read the below

	public Film findFilmById(int filmId) throws SQLException;
	
	public Film findFilmLanguage(int filmId,  String languageName) throws SQLException;
	
	public Film findFilmsBySearchWord(String searchWord) throws SQLException;

	public Actor findActorById(int actorId) throws SQLException;

	public List<Actor> findActorsByFilmId(int filmId) throws SQLException;
	
	// public xxxxxxx findActorsByFilmId ( int filmId);
	// will retunrn a list of actor id's
	// already given see above
	
} //end DatabaseAccessor
