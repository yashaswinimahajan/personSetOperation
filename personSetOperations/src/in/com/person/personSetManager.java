package in.com.person;
import java.util.*;

public class personSetManager {
  public static void main(String[] args) {
	        // Task 1: Custom Object Manipulation
	        Set<Person> hashSet = new HashSet<>();
	        Set<Person> linkedHashSet = new LinkedHashSet<>();

	        Person person1 = new Person(1, "Alice", 30);
	        Person person2 = new Person(2, "Bob", 25);
	        Person person3 = new Person(3, "Charlie", 35);
	        Person person4 = new Person(1, "Alice", 30); // Duplicate of person1

	        addToSet(person1, hashSet, linkedHashSet);
	        addToSet(person2, hashSet, linkedHashSet);
	        addToSet(person3, hashSet, linkedHashSet);
	        addToSet(person4, hashSet, linkedHashSet); // Should not be added due to duplicate id

	        // Task 2: Set Operations
	        System.out.println("HashSet: " + hashSet);
	        System.out.println("LinkedHashSet: " + linkedHashSet);

	        Set<Person> unionSet = new HashSet<>(hashSet);
	        unionSet.addAll(linkedHashSet);
	        System.out.println("Union of sets: " + unionSet);

	        Set<Person> intersectionSet = new HashSet<>(hashSet);
	        intersectionSet.retainAll(linkedHashSet);
	        System.out.println("Intersection of sets: " + intersectionSet);

	        Set<Person> differenceSet1 = new HashSet<>(hashSet);
	        differenceSet1.removeAll(linkedHashSet);
	        System.out.println("Difference set 1 (hashSet - linkedHashSet): " + differenceSet1);

	        Set<Person> differenceSet2 = new HashSet<>(linkedHashSet);
	        differenceSet2.removeAll(hashSet);
	        System.out.println("Difference set 2 (linkedHashSet - hashSet): " + differenceSet2);

	        // Task 3: Complex Operations
	        System.out.println("Max age in HashSet: " + findMaxAge(hashSet));
	        System.out.println("Min age in HashSet: " + findMinAge(hashSet));
	        System.out.println("Sorted by age in HashSet: " + sortByAge(hashSet));

	        // Task 4: Performance Analysis
	        measurePerformance();

	        // Task 5: Real-World Scenario
	        Conference conference = new Conference();
	        conference.addAttendee(person1);
	        conference.addAttendee(person2);
	        conference.addAttendee(person3);
	        conference.addAttendee(person4);

	        System.out.println("Duplicate attendees in conference: " + conference.findDuplicateAttendees());
	        System.out.println("Unique attendees in conference: " + conference.listUniqueAttendees());
	        System.out.println("Attendees in age range 25-35: " + conference.findAttendeesInAgeRange(25, 35));
	    }

	    private static void addToSet(Person person, Set<Person> hashSet, Set<Person> linkedHashSet) {
	        hashSet.add(person);
	        linkedHashSet.add(person);
	    }

	    private static int findMaxAge(Set<Person> people) {
	        return people.stream()
	                .mapToInt(Person::getAge)
	                .max()
	                .orElseThrow(NoSuchElementException::new);
	    }

	    private static int findMinAge(Set<Person> people) {
	        return people.stream()
	                .mapToInt(Person::getAge)
	                .min()
	                .orElseThrow(NoSuchElementException::new);
	    }

	    private static List<Person> sortByAge(Set<Person> people) {
	        List<Person> sortedList = new ArrayList<>(people);
	        sortedList.sort(Comparator.comparingInt(Person::getAge));
	        return sortedList;
	    }

	    private static void measurePerformance() {
	        Set<Person> testSet = new HashSet<>();
	        Random random = new Random();

	        // Adding elements
	        long startTime = System.currentTimeMillis();
	        for (int i = 0; i < 1_000_000; i++) {
	            testSet.add(new Person(i, "Person" + i, random.nextInt(100)));
	        }
	        long addTime = System.currentTimeMillis() - startTime;
	        System.out.println("Time taken to add 1,000,000 elements to HashSet: " + addTime + " ms");

	        // Removing elements
	        startTime = System.currentTimeMillis();
	        for (int i = 0; i < 1_000_000; i++) {
	            testSet.remove(new Person(i, "Person" + i, random.nextInt(100)));
	        }
	        long removeTime = System.currentTimeMillis() - startTime;
	        System.out.println("Time taken to remove 1,000,000 elements from HashSet: " + removeTime + " ms");

	        // Checking containment
	        startTime = System.currentTimeMillis();
	        for (int i = 0; i < 1_000_000; i++) {
	            testSet.contains(new Person(i, "Person" + i, random.nextInt(100)));
	        }
	        long containsTime = System.currentTimeMillis() - startTime;
	        System.out.println("Time taken to check containment in HashSet: " + containsTime + "ms" );
	    }
}

	      


