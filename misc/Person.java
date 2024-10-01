public class Person {

    // Default Variables
    private static final String DEFAULT_FIRST_NAME = "FNU";
    private static final String DEFAULT_LAST_NAME = "LNU";
    private static final String DEFAULT_YEAR_BORN = "1800";  
    
    private String firstName;
    private String lastName;
    private int yearBorn;

    public Person(String firstName, String lastName, int yearBorn) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.yearBorn = yearBorn;
    }

    public Person(String firstName) {

        /* works but not good code
        this.firstName = firstName;
        this.lastName = DEFAULT_LAST_NAME;
        this.yearBorn = DEFAULT_YEAR_BORN;
        */

        this(firstName, DEFAULT_LAST_NAME, DEFAULT_YEAR_BORN);)

    } 

    // Default Constructor //
    public Person() {
        this(DEFAULT_FIRST_NAME, DEFAULT_LAST_NAME, DEFAULT_YEAR_BORN);
    }

    // Getter Methods //
    public String getFirstName() {
        return this.firstName;
    }
    public String getLastName() {
        return this.lastName;
    }
    public int getYearBorn() {
        return this.yearBorn;
    }


    // Setter Methods //
    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }
    public void setLastName(String lastName) {
        this.lastName = lastName;
    }
    public void setYearBorn(int yearBorn) {
        this.yearBorn = yearBorn;
    }

}
