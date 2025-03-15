import java.util.regex.*;

public class RegexTester {
    public static void main(String[] args) {
        System.out.println("Regular Expression Testing Program");
        System.out.println("==================================");

        // Test 1: Email Validation
        testPattern("Email Validation",
                "^[A-Za-z0-9+_.-]+@[A-Za-z0-9.-]+\\.[A-Za-z]{2,}$",
                "test.email123@example.com",        // Positive case
                "invalid.email@.com");              // Negative case

        // Test 2: US Phone Number (XXX-XXX-XXXX)
        testPattern("US Phone Number",
                "^\\d{3}-\\d{3}-\\d{4}$",
                "123-456-7890",                     // Positive case
                "12-345-6789");                    // Negative case

        // Test 3: Date (YYYY-MM-DD)
        testPattern("Date YYYY-MM-DD",
                "^\\d{4}-(?:0[1-9]|1[0-2])-(?:0[1-9]|[12]\\d|3[01])$",
                "2025-03-14",                      // Positive case
                "2025-13-01");                    // Negative case

        // Test 4: URL
        testPattern("URL",
                "^https?://[A-Za-z0-9.-]+\\.[A-Za-z]{2,}(?:/\\S*)?$",
                "https://www.example.com/path",     // Positive case
                "htp://invalid");                  // Negative case

        // Test 5: Strong Password (8+ chars, 1 upper, 1 lower, 1 number, 1 special)
        testPattern("Strong Password",
                "^(?=.*[A-Z])(?=.*[a-z])(?=.*\\d)(?=.*[!@#$%^&*])[A-Za-z\\d!@#$%^&*]{8,}$",
                "Passw0rd!",                       // Positive case
                "password123");                    // Negative case
    }

    private static void testPattern(String testName, String pattern,
                                    String positiveTest, String negativeTest) {
        System.out.println("\nTest: " + testName);
        System.out.println("Pattern: " + pattern);

        Pattern regex = Pattern.compile(pattern);

        // Positive Test
        Matcher positiveMatcher = regex.matcher(positiveTest);
        System.out.println("Positive Test: '" + positiveTest + "'");
        System.out.println("Result: " + (positiveMatcher.matches() ? "MATCH" : "NO MATCH"));

        // Negative Test
        Matcher negativeMatcher = regex.matcher(negativeTest);
        System.out.println("Negative Test: '" + negativeTest + "'");
        System.out.println("Result: " + (negativeMatcher.matches() ? "MATCH" : "NO MATCH"));
    }
}
