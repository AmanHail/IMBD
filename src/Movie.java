import java.util.Arrays;
import java.util.LinkedList;
import java.util.Set;
import java.util.TreeSet;

public class Movie implements Comparable<Movie>{

	private int year;
	private String title;
	private LinkedList<Person> actors;
	private LinkedList<Person> dir;
	
	public Movie(String line) {
		year = Integer.valueOf(line.substring(0, 5).trim());
		title = line.substring(5, 38).trim();
		String[] names = line.substring(38, 84).trim().split(", ");
		actors = new LinkedList<Person>();
		for (String name : names) {
			actors.add(new Person(name.substring(0, name.indexOf(" ")), name.substring(name.indexOf(" ")+1)));
		}
		String[] dirs = line.substring(89).trim().split(", ");
		dir = new LinkedList<Person>();
		for (String d : dirs) {
			dir.add(new Person(d.substring(0, d.indexOf(" ")), d.substring(d.indexOf(" ")+1)));
		}
	}
	
	
	public Person getDirector() {
		return dir.get(0);
	}
	public LinkedList<Person> getActors() {
		return actors;
	}

	@Override
	public int compareTo(Movie o) {
		// TODO Auto-generated method stub
		return title.compareTo(o.title);
	}
	
	public String toString() {
		String out =  "" + year + " " + title;
		int i = out.length();
		while (i<38) {
			out+=" ";
			i++;
		}
		for (int j = 0; j<actors.size()-1; j++) {
			out+=actors.get(j) + ", ";
		}
		out+=actors.get(actors.size()-1);
		
		i = out.length();
		while (i<84) {
			out+=" ";
			i++;
		}
		out+= "Dir: ";
		for (int j = 0; j<dir.size()-1; j++) {
			out+=dir.get(j) + ", ";
		}
		out+=dir.get(dir.size()-1);
		
		return out;
	}
}
