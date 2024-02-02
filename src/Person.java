
public class Person implements Comparable<Person>{

	private String first;
	private String last;
	
	public Person(String f, String l) {
		first = f;
		last = l;
	}
	
	public String getFirstName() {
		return first;
	}
	public String getLastName() {
		return last;
	}

	@Override
	public int compareTo(Person o) {
		// TODO Auto-generated method stub
		int comp = last.compareTo(o.last);
		if (comp == 0) {
			comp = first.compareTo(o.first);
		}
		return comp;
	}
	
	public String toString() {
		return first + " " + last;
	}
}
