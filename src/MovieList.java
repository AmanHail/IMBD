import java.io.File;
import java.util.Collections;
import java.util.LinkedList;
import java.util.Scanner;
import java.util.Set;
import java.util.TreeSet;

public class MovieList {
	
	public static void main (String[] args) {
		LinkedList<Movie> movies = readFile("movies.txt");
		
		//Sorting by TITLE (part b)
//		Collections.sort(movies);
//		for (int i = 0; i<movies.size(); i++) {
//			System.out.println(movies.get(i));
//		}
		
		//Sorting by DIRECTOR (part c)
//		Collections.sort(movies, new MovieComparator());
//		for (int i = 0; i<movies.size(); i++) {
//			System.out.println(movies.get(i));
//		}
		
//		printActors(movies); //(part d)

	}
	
	/**
	 * Creates and prints a list of all actors in a list of movies
	 * sorted alphabetically by last then first name
	 * @param movies
	 */
	public static void printActors(LinkedList<Movie> movies) {
		Set<Person> acts= new TreeSet<Person>();
		for (int i = 0; i<movies.size(); i++) { //loop through movies
			for (int j = 0; j<movies.get(i).getActors().size(); j++) { //loop through actors in movie
				acts.add(movies.get(i).getActors().get(j));
			}
		}
		System.out.println("Total number of actors: " + acts.size());
		System.out.println(acts);
	}

	public static LinkedList<Movie> readFile(String path){
		LinkedList<Movie> movies=new LinkedList<>();
        try{
            File f = new File(path);
            Scanner s = new Scanner(f);
            while(s.hasNextLine()){
                movies.add(new Movie(s.nextLine()));
            }
            s.close();
        }catch(Exception e){e.printStackTrace();}
        return movies;
	}
}
