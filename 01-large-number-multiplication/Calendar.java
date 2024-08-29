public class Calendar {

    public static void main(String[] args) {

        printCalendar(31, 6);
    }

    public static String padded(int n, int width) {
        
        String s = Integer.toString(n);
        String result = s;
        while (result.length() < width) {
            result = " " + result;
        }
        return result;
    }

    public static void printCalendar(int numberOfDays, int firstSunday) {
        
        System.out.println("Month");
        System.out.println(" Sun  Mon  Tue  Wed  Thu  Fri  Sat ");
        System.out.println("+----+----+----+----+----+----+----+");

        int leadingSpaces = firstSunday - 1;

        for (int i = 0; i < leadingSpaces; i++) {
            System.out.print("|" + padded(0, 4));
        }

        for (int day = 1; day <= numberOfDays; day++) {
            System.out.print("|" + padded(day, 4));

            int position = (leadingSpaces + day) % 7;
            System.out.print((position == 6 && day != numberOfDays) ? "|\n" : "");
        }
        
        int totalSquaresPrinted = leadingSpaces + numberOfDays;
        int fillInSpaces = (7 - (totalSquaresPrinted % 7)) % 7;
        for (int i = 0; i < fillInSpaces; i++) {
            System.out.print("|" + padded(0, 4));
        }

        System.out.println("|");
        System.out.println("+----+----+----+----+----+----+----+");
    }
}