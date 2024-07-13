package in.com.person;
import java.util.HashSet;
import java.util.Set;
import java.util.stream.Collectors;

	public class Conference {
	    private Set<Person> attendees;

	    public Conference() {
	        this.attendees = new HashSet<>();
	    }

	    public void addAttendee(Person person) {
	        attendees.add(person);
	    }

	    public void removeAttendee(Person person) {
	        attendees.remove(person);
	    }

	    public Set<Person> getAttendees() {
	        return attendees;
	    }

	    public Set<Person> findDuplicateAttendees() {
	        Set<Person> uniqueAttendees = new HashSet<>();
	        return attendees.stream()
	                .filter(person -> !uniqueAttendees.add(person))
	                .collect(Collectors.toSet());
	    }

	    public Set<Person> listUniqueAttendees() {
	        return new HashSet<>(attendees);
	    }

	    public Set<Person> findAttendeesInAgeRange(int minAge, int maxAge) {
	        return attendees.stream()
	                .filter(person -> person.getAge() >= minAge && person.getAge() <= maxAge)
	                .collect(Collectors.toSet());
	    }
	}
	               


