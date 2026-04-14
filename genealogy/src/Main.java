import java.util.*;
import java.time.LocalDate;

public class Main
{
    public static void main(String[] args) throws Exception
    {
        // Person[] people = new Person[10];
        List<Person> people2 = new ArrayList<>(List.of(
            new Person("Wawa1", "Pluh", LocalDate.of(1990, 1, 4)),
            new Person("Wawa1", "Pluh", LocalDate.of(2007, 1, 4)),
            new Person("Wawa3", "Pluh", LocalDate.of(2030, 1, 4)),
            new Person("Wawa4", "Pluh", LocalDate.of(2090, 1, 4))
        ));

        people2.forEach((Person p) -> { System.out.println(p.toString()); });
        people2.get(0).adopt(people2.get(2));
        people2.get(0).adopt(people2.get(3));
        Family f = new Family();
        
        //f.add(people2.toArray(new Person[people2.size()]));
        
        System.out.println(f.get("Wawa1 Pluh"));
        System.out.println(people2.get(0).getYoungestChild());

		List<Person> ppl = Person.fromCsv("family.csv");
		System.out.println(ppl);
		
		Person.toBinaryFile(ppl, "test.ppl");
		System.out.println("\n\n" + Person.fromBinaryFile("test.ppl"));
    }
}