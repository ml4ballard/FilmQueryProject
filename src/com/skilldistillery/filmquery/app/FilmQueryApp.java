package com.skilldistillery.filmquery.app;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import com.skilldistillery.filmquery.database.DatabaseAccessor;
import com.skilldistillery.filmquery.database.DatabaseAccessorObject;
import com.skilldistillery.filmquery.entities.Film;

public class FilmQueryApp {

	DatabaseAccessor db = new DatabaseAccessorObject();

	public static void main(String[] args) {
		FilmQueryApp app = new FilmQueryApp();
//		app.test();
    app.launch();
	}

/*	private void test() {
		Film film;
		try {
			film = db.findFilmById(722);
			System.out.println(film.getTitle() + " " + film.getDescription());
		} catch (SQLException e) {
			e.printStackTrace();
		}
	} //end test */

	private void launch() {
		Scanner input = new Scanner(System.in);

	startUserInterface(input);
		
		input.close();
		
	} //end launch
	
	private void startUserInterface(Scanner input) {
		
	boolean correctAns = false;                 // Loop until user exits
	
    while (!correctAns) {
	  System.out.printf("\n\n\t\tWelcome to the Film Query Menu\n");
	  System.out.println();
	  System.out.println();
	  System.out.printf("\t\t1. Find by film id (findFilmById) \n");
	  System.out.printf("\t\t2. Look up a film by a search keyword (findFilmsBySearchWord) \n");
	  System.out.printf("\t\t3. Find Actor by film ID (findActorsByFilmId) \n");
	  System.out.printf("\t\t4. Go watch your film,  say goodbye\n\n");
	  System.out.printf("\t\tSelection:" );
	  String selection = input.nextLine();
					      				      
    // Validate and act on user input
			
		int enterID = 1;
		String searchWord = " ";
		String filmLang = " ";
		switch (selection) {
		case "1":             //get film id			
				System.out.printf("\n\t\tEnter film id:\n");
				enterID = input.nextInt();
				input.nextLine();
				Film film;
				try {
					film = db.findFilmById(enterID);
					if (film == null) {
					    System.out.println("No film found with the given ID.");
					} else {
				    System.out.println("Title:" + film.getTitle() + "  Release Year: " + film.getReleaseYear() + "  rating: " + film.getRating()); 
				    System.out.println("Description: " + film.getDescription() + "\n");  	
				   
					}
				} catch (SQLException e) {
					e.printStackTrace();
				}				
				break;		
		case "2":              //get actor id					 	     
				System.out.printf("\t\tEnter search keyword:\t\n\n");
				System.out.println();
				searchWord = input.nextLine();
				try { 
				List <Film>	films = db.findFilmsBySearchWord(searchWord);
				for (Film film2 : films) {
					System.out.println(film2);
				}
				} catch (SQLException e) {
					e.printStackTrace();
				}				
				break;				
		case "3":             //get film id to find Actor				 	     
				System.out.printf("\t\tEnter film id to find actor:\t\n\n");
				System.out.println();
				enterID = input.nextInt();
				input.nextLine();
				break;				
		case "4":            //exit the program
			    correctAns = true;
			    System.out.printf("\n\t\tEnjoy your movie! Have some popcorn\t\n\n");
			    input.nextLine();
			    break;
	    default:
	    	    System.out.printf("\n\t\tPlease choose a valid option\t\n\n");
	    	    input.nextLine();
			    break;
		} // end switch selection
					      			
      } //end correctAns while	
		
   } // end startUserInterface

} // end FilmQueryApp
