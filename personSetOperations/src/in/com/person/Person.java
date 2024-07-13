package in.com.person;
import java.util.Objects;

	public class Person {
	    private int id;
	    private String name;
	    private int age;

	    public Person(int id, String name, int age) {
	        this.id = id;
	        this.name = name;
	        this.age = age;
	    }

	    public int getId() {
	        return id;
	    }

	    public String getName() {
	        return name;
	    }

	    public int getAge() {
	        return age;
	    }

	    @Override
	    public boolean equals(Object o) {
	        if (this == o) return true;
	        if (o == null || getClass() != o.getClass()) return false;
	        Person person = (Person) o;
	        return id == person.id;
	    }

	    @Override
	    public int hashCode() {
	    	return Objects.hash(id);
	    }
	    }
	


