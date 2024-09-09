import java.util.regex.*;

public class RegexMatcher {
    public static boolean matchPhrase(String input) {
        // String regex = "(damage|damages)$";
        String regex = "^(?!.*\\b(?:not|no)\\b).*(\\bdamage\\b|\\bdamages\\b).*";
        Pattern pattern = Pattern.compile(regex , Pattern.CASE_INSENSITIVE);
        Matcher matcher = pattern.matcher(input);
        return matcher.matches();
    }

    public static void main(String[] args) {
        System.out.println(matchPhrase("damage")); // true
        System.out.println(matchPhrase("minor damages")); // true
        System.out.println(matchPhrase("heavy damage")); // true
        System.out.println(matchPhrase("not damages")); // false
        System.out.println(matchPhrase("no damages")); // false
        System.out.println(matchPhrase(" damages no")); // false
    }
}