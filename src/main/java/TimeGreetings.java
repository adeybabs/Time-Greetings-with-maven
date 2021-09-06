import org.joda.time.LocalTime;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class TimeGreetings {

    private static final int[] MORNING = new int[]{0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11};
    private static final int[] AFTERNOON = new int[]{12, 13, 14, 15};
    private static final int[] EVENING = new int[]{16, 17, 18, 19, 20};
    private static final int[] NIGHT = new int[]{21, 22, 23};

    private static final Map<String, int[]> TIME_MAP = new HashMap<>() {{
        put("MORNING", new int[]{0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11});
        put("AFTERNOON", new int[]{12, 13, 14, 15});
        put("EVENING", new int[]{16, 17, 18, 19, 20});
        put("NIGHT", new int[]{21, 22, 23});
    }};

    public static void main(String[] args) {

        Scanner scan = new Scanner(System.in);
        String usersName;      // The user's name, as entered by the user.
        String upperCaseName;  // The user's name, converted to upper case letters.

        System.out.print("Please enter your name ");
        usersName = scan.nextLine();

        upperCaseName = usersName.toUpperCase();

        System.out.println("Hello, " + printTimeOfDay() + " " + upperCaseName);
        System.out.println("Hello for the second time, " + printTimeOfDay2() + " " + upperCaseName);

    }

    public static String printTimeOfDay() {

        final int hourOfDay = LocalTime.now().getHourOfDay();
        if (Arrays.stream(MORNING).anyMatch(value -> value == hourOfDay)) {
            return "Good Morning";
        } else if (Arrays.stream(AFTERNOON).anyMatch(value -> value == hourOfDay)) {
            return "Good Afternoon";
        } else if (Arrays.stream(EVENING).anyMatch(value -> value == hourOfDay)) {
            return "Good Evening";
        } else if (Arrays.stream(NIGHT).anyMatch(value -> value == hourOfDay)) {
            return "Good Night";
        } else return "Don't know what to greet you";
    }

    public static String printTimeOfDay2() {

        return TIME_MAP.entrySet().stream()
                .filter(timeMap -> Arrays.stream(timeMap.getValue()).anyMatch(value -> value == LocalTime.now().getHourOfDay()))
                .map(timeMap -> "Good " + timeMap.getKey().toLowerCase())
                .findAny().orElse("Don't know what to greet you");
    }

}