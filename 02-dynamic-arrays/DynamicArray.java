/**
 * A simple class to demonstrate dynamic behavior with arrays. Objects of this
 * class store strings in an array that grows to match the demand for storage.
 * 
 * The class is based on an underlying string array. Objects can be initialized
 * to any size; otherwise they'll be initialized to the default size. For
 * example,
 * 
 * DynamicArray da1 = new DynamicArray(10);
 * 
 * will have initially room for 10 strings, while
 * 
 * DynamicArray da2 = new DynamicArray();
 * 
 * will have initially room for 4 strings.
 */
public class DynamicArray {

    /** Default size for underlying array */
    private static final int DEFAULT_SIZE = 4;

    private static final int GROWTH = 2;

    /** The underlying array for this class */
    private String[] foundation;



    /**
     * Full constructor. Initializes the underlying array to the specified size. The
     * size must be a positive, non zero value. Otherwise the constructor uses the
     * default size value.
     */
    public DynamicArray(int size) {
        // If size <= 0 use default -- this is a good time to demo ternary operator
        size = (size > 0) ? size : DEFAULT_SIZE;
        this.foundation = new String[size];
    } // full constructor

    /** Array-based constructor -- used for testing */
    public DynamicArray(String[] data) {
        this.foundation = data;
    } // array-based constructor

    /** Default constructor */
    public DynamicArray() {
        this(DEFAULT_SIZE);
    } // default constructor



    public boolean contains(String target) {

        if (target == null || foundation == null) {
            return false;
        }

        for (String s : foundation) {
            if (target.equals(s)) {
                return true;
            }
        }

        return false;

    } // method contains


    public String get(int index) {
        if (index < 0 || index >= foundation.length) {
            return null;
        }
        return foundation[index];

    } // method get


    public String remove(int index) {

        if (index < 0 || index >= foundation.length) {
            return null;
        }

        String removed = foundation[index];
        
        int i = index;
        while (i < foundation.length -1) {
            foundation[i] = foundation[i + 1];
            i++;
        }

        foundation[foundation.length - 1] = null;

        int newSize = foundation.length;
        while (newSize > 0 && foundation[newSize - 1] == null) {
            newSize--;
        }

        if (newSize < foundation.length) {
            String[] newFoundation = new String[newSize];
            for (int j = 0; j < newSize; j++) {
                newFoundation[j] = foundation[j];
            }
            foundation = newFoundation;
        }

        return removed;

    } // method remove


    public void delete(int index) {

        if (index < 0 || index >= foundation.length) {
            return;
        }

        for (int i = index; i < foundation.length - 1; i++) {
            foundation[i] = foundation[i + 1];
        }

        foundation[foundation.length - 1] = null;

    } // method delete


    public void insert(String string) {
        
        boolean inserted = false;
        int i = 0;
        
        while (i < foundation.length && !inserted) {
            if (foundation[i] == null) {
                foundation[i] = string;
                inserted = true;
            }
            i++;        
        }

        if (!inserted) {
            resize();
            insert(string);
        }

    } // method insert


    private void resize() {
        
        String[] newFoundation = new String[foundation.length * GROWTH];
        for (int i = 0; i< foundation.length; i++) {
            newFoundation[i] = foundation[i];
        }

        foundation = newFoundation;

    } // method resize


    /** Driver/test code */
    public static void main(String[] args) {
        final String PASS = "Pass";
        final String FAIL = "Fail";
        final String NON_EXISTING = "COBOL";
        // Test data
        String[] testData = { "Java", "Python", "C", "C++", "Fortran" };
        DynamicArray test = new DynamicArray(testData);
        DynamicArray tset = new DynamicArray(null);
        // Naive testing - I am ashamed to do this but I need
        // to keep things simple for now.
        String testContainsNullTarget = (!test.contains(null)) ? PASS : FAIL;
        String testContainsEmptyData = (!tset.contains("Java")) ? PASS : FAIL;
        String testContainsExisting = (test.contains(testData[1])) ? PASS : FAIL;
        String testContainsNonExisting = (!test.contains(NON_EXISTING)) ? PASS : FAIL;
        String testGetNegative = (test.get(-1) == null) ? PASS : FAIL;
        String testGet = (test.get(0).equals(testData[0])) ? PASS : FAIL;
        String testGetOutOfBounds = (test.get(testData.length + 1) == null) ? PASS : FAIL;
        String testRemove = (testData[1].equals(test.remove(1))) ? PASS : FAIL;
        String testRemoveNull = (test.remove(1) == null) ? PASS : FAIL;
        String testRemoveOutOfBounds = (test.remove(testData.length + 1) == null) ? PASS : FAIL;
        System.out.printf("\nTest for contains(null): ............... %s", testContainsNullTarget);
        System.out.printf("\nTest for contains on null foundation: .. %s", testContainsEmptyData);
        System.out.printf("\nTest for contains (existing): .......... %s", testContainsExisting);
        System.out.printf("\nTest for contains (non existing): ...... %s", testContainsNonExisting);
        System.out.printf("\nTest for get(-1): ...................... %s", testGetNegative);
        System.out.printf("\nTest for get(0): ....................... %s", testGet);
        System.out.printf("\nTest for get(out of bounds): ........... %s\n", testGetOutOfBounds);
        System.out.printf("\nTest for remove(1): .................... %s", testRemove);
        System.out.printf("\nTest for remove(null): ................. %s", testRemoveNull);
        System.out.printf("\nTest for remove(out of bounds): ........ %s\n\n", testRemoveOutOfBounds);
        // If all is good, these two statemets will not crash the program
        test.insert("Pascal");
        test.insert("Basic");
    } // method main

} // class DynamicArray
