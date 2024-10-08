import java.util.Random;

public class Person implements Comparable<Person>, SillyActions {

    private static final String DEFAULT_LAST_NAME = "LNU";
    private static final String DEFAULT_FIRST_NAME = "FNU";
    private static final int DEFAULT_YEAR_BORN = 1800;

    private String firstName;
    private String lastName;
    private int yearBorn;

    public Person(String firstName, String lastName, int yearBorn) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.yearBorn = yearBorn;
    }

    public Person(String firstName) {
        this(firstName, DEFAULT_LAST_NAME, DEFAULT_YEAR_BORN);
    }

    /** Default constructor */
    public Person() {
        this(DEFAULT_FIRST_NAME, DEFAULT_LAST_NAME, DEFAULT_YEAR_BORN);
    }

    /**
     * Implements the Comparable interface to determine the relative order of two
     * persons based on their age.
     * 
     */
    public int compareTo(Person other) {
        return other.getYearBorn() - this.yearBorn;
    } // method compareTo

    @Override
    public String toString() {
        return "Person [firstName=" + firstName + ", lastName=" + lastName + ", yearBorn=" + yearBorn + "]";
    } // method toString

    //------------------- AUTO GENERATED METHODS ------------------------------
    
    public String getFirstName() {
        return this.firstName;
    }

    public String getLastName() {
        return this.lastName;
    }

    public int getYearBorn() {
        return this.yearBorn;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public void setYearBorn(int yearBorn) {
        this.yearBorn = yearBorn;
    }


    /**
     * Implements the SillyActions interface.
     * 
     */

    private static final Random random = new Random();

    public void makeRandomSound() {
        int index = random.nextInt(PoemWords.words.length);
        String randomSound = PoemWords.words[index];
        System.out.println(randomSound);
    }

    public void performSillyDance() {
        String[] danceSteps = {"left", "right", "backwards", "forwards"};
        int numberOfSteps = 5;
        System.out.println("Performing a silly dance:");
        for (int i = 0; i < numberOfSteps; i++) {
            int index = random.nextInt(danceSteps.length);
            System.out.print(danceSteps[index] +  ", ");
        }
        System.out.println();
    }

    public String reciteAlphabetBackwards() {
        String alphabet = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
        StringBuilder alphabetBackwards = new StringBuilder(alphabet).reverse();
        int forgottenLetterIndex = random.nextInt(alphabetBackwards.length());
        StringBuilder forgottenAlphabetBackwards = new StringBuilder();
        for (int i = 0; i< alphabetBackwards.length(); i++) {
            if (i != forgottenLetterIndex) {
                forgottenAlphabetBackwards.append(alphabetBackwards.charAt(i));
            }
        }
        return forgottenAlphabetBackwards.toString();
    }

    public void countToTenWeirdly() {
        int[] numbersToTen = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
        int forgottenNumberIndex = random.nextInt(10);
        System.out.print("Counting to ten weirdly: ");
        for (int i = 0; i < numbersToTen.length; i++) {
            if (i != forgottenNumberIndex) {
                System.out.print(numbersToTen[i]);
                if (i < numbersToTen.length - 1) {
                    System.out.print(", ");
                }
            }
        }
        System.out.println();
    }

    public String createWhimsicalPoem(String topic) {
        int poemDefaultLength = 5;
        StringBuilder whimsicalPoem = new StringBuilder();
        whimsicalPoem.append(topic).append(", ");
        for (int i = 0; i < poemDefaultLength; i++) {
            int nextWordIndex = random.nextInt(PoemWords.words.length);
            whimsicalPoem.append(PoemWords.words[nextWordIndex]);
            if (i < poemDefaultLength - 1) {
                whimsicalPoem.append(", ");
            }
        }
        return whimsicalPoem.toString();
    }

    public void winStateLottery() {
        int lotteryDefaultLength = 6;
        int numberOptions = 49;
        boolean[] selectedNumbers = new boolean[numberOptions];
        int[] lotteryNumbers = new int[lotteryDefaultLength];
        int count = 0;
        while (count < lotteryDefaultLength) {
            int currentNumber = random.nextInt(numberOptions);
            if (!selectedNumbers[currentNumber]) {
                selectedNumbers[currentNumber] = true;
                lotteryNumbers[count] = currentNumber + 1;
                count++;
            }
        }
        System.out.print("Lottery numbers: ");
        for (int i = 0; i < lotteryNumbers.length; i++) {
            System.out.print(lotteryNumbers[i]);
            if (i < lotteryNumbers.length - 1) {
                System.out.print(", ");
            }
        }
        System.out.println();
    }
    public static void main(String[] args) {

        //create Person objects
        Person p1 = new Person("Evey", "Kallmeyer", 2003);
        Person p2 = new Person("Cali", "Curro", 2003);
        Person p3 = new Person("Lucy", "Hamilton", 2002);
        Person p4 = new Person("Margie", "Guth", 2003);
        Person p5 = new Person("Rachel", "Krzesinski", 2002);
        Person p6 = new Person("Stephanie", "Zayed", 2003);

        //print Person objects
        System.out.println(p1);
        System.out.println(p2);
        System.out.println(p3);
        System.out.println(p4);
        System.out.println(p5);
        System.out.println(p6);

        //test compareTo method
        System.out.println("Age comparison between Evey and Lucy: " + p1.compareTo(p3));

        //test SillyActions interface methods
        p1.makeRandomSound();
        p2.performSillyDance();
        System.out.println("Reciting the alphabet incorrectly: " + p3.reciteAlphabetBackwards());
        p4.countToTenWeirdly();
        System.out.println("Creating a whimsical poem: " + p5.createWhimsicalPoem("Dreams"));
        p6.winStateLottery();
    } // method main
}


