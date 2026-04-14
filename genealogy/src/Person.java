import java.io.*;
import java.util.*;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;

public class Person implements Comparable<Person>, Serializable
{
    private String firstName, lastName;
    private LocalDate birthDate, deathDate;
    private Set<Person> children = new HashSet<Person>();
    public Person(String firstName, String lastName, LocalDate birthDate)
    {
        this.firstName = firstName;
        this.lastName = lastName;
        this.birthDate = birthDate;
        deathDate = null;
    }
    public Person(String firstName, String lastName, LocalDate birthDate, LocalDate deathDate) throws NegativeLifespanException
    {
        this(firstName, lastName, birthDate);
        if (deathDate != null && deathDate.isBefore(birthDate)) throw new NegativeLifespanException(this);
        this.deathDate = deathDate;
    }
    public String getFirstName() { return firstName; }
    public String getLastName() { return lastName; }
    public String getName() { return firstName + " " + lastName; }
    public LocalDate getBirthDate() { return birthDate; }
    public LocalDate getDeathDate() { return deathDate; }
    public boolean adopt(Person p) throws ParentingAgeException
    {
        if (deathDate != null && ChronoUnit.YEARS.between(birthDate, deathDate) <= 15) throw new ParentingAgeException();
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
        return firstName + ' ' + lastName + ", born " + birthDate.toString() + "\nchildren: " + children;
    }
    @Override
    public int compareTo(Person p) 
    {
        return birthDate.compareTo(p.birthDate);
    }
    static DateTimeFormatter format = DateTimeFormatter.ofPattern("dd.MM.yyyy");
    public static Person fromCsvLine(String line) throws NegativeLifespanException
    {
        String[] s = line.split(",");
        String[] n = s[0].split(" ");
        return new Person(
            n[0], n[1], 
            LocalDate.parse(s[1], format), 
            s[2].length() == 0 ? null : LocalDate.parse(s[2], format)
        );
    }
    public static List<Person> fromCsv(String path) throws NegativeLifespanException, AmbiguousPersonException, FileNotFoundException, IOException
    {
        File f = new File(path);
        BufferedReader br = new BufferedReader(new FileReader(f));
        List<Person> ret = new ArrayList<Person>();
        String[] lines = (String[])br.lines().skip(1).toArray(String[]::new);
		
        for (String line : lines) 
        {
            Person p = fromCsvLine(line);
            if (ret.stream().anyMatch(p2 -> p.firstName == p2.firstName && p.lastName == p2.lastName)) 
            {
                br.close();
                throw new AmbiguousPersonException();
            }
            ret.add(p);
        }
        for (int i = 0; i < lines.length; i++)
        {
			String[] s = lines[i].split(",");
			if (s.length < 4)
				continue;
            for (int j = 0; j < lines.length; j++)
            {
				if (i == j)
					continue;
                if (ret.get(j).getName().contentEquals(s[3]))
				{
					ret.get(i).safeAdopt(ret.get(j));
				}
				if (s.length > 4 && ret.get(j).getName().contentEquals(s[4]))
				{
					ret.get(i).safeAdopt(ret.get(j));
				}
	
            }
        }
        br.close();
        return ret;
    }
	public void safeAdopt(Person p)
	{
		try 
		{
			adopt(p);
		} 
		catch (ParentingAgeException e) 
		{
			System.out.print("Parent too young, adopt anyway? [y/n]");
			Scanner s = new Scanner(System.in);
			if (s.nextLine().contentEquals("y"))
				children.add(p);
		}
	}
	public static void toBinaryFile(List<Person> ppl, String path) throws FileNotFoundException, IOException
	{
		FileOutputStream file = new FileOutputStream(path);
		ObjectOutputStream out = new ObjectOutputStream(file);
		out.writeObject(ppl);
		out.close();
		file.close();
	}
	public static List<Person> fromBinaryFile(String path) throws 
		FileNotFoundException, IOException,
		ClassNotFoundException, InvalidClassException,
		OptionalDataException, StreamCorruptedException
	{
		FileInputStream file = new FileInputStream(path);
		ObjectInputStream in = new ObjectInputStream(file);
		List<Person> ret = null;
		
		ret = (List<Person>) in.readObject();
		
		in.close();
		file.close();
		return ret;
	}
}
