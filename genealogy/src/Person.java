import java.time.LocalDate;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Person implements Comparable<Person>
{
    private String firstName, lastName;
    private LocalDate birthDate; 
    private Set<Person> children = new HashSet<Person>();
    public Person(String firstName, String lastName, LocalDate birthDate)
    {
        this.firstName = firstName;
        this.lastName = lastName;
        this.birthDate = birthDate;
    }
    public String getFirstName() { return firstName; }
    public String getLastName() { return lastName; }
    public LocalDate getBirthDate() { return birthDate; }
    public boolean adopt(Person p)
    {
        if (children.contains(p)) return false;
        children.add(p);
        return true;
    }
    public Person getYoungestChild()
    {
        if (children.isEmpty()) return null;
        return Collections.max(children);
    }
    public List<Person> getChildren()
    {
        return List.copyOf(children);
    }
    @Override
    public String toString() 
    {
        return firstName + ' ' + lastName + ' ' + birthDate.toString();
    }
    @Override
    public int compareTo(Person p) 
    {
        return birthDate.compareTo(p.birthDate);
    }
}
