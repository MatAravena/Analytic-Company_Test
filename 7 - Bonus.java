public class Bonus {

    public String GetString(Boolean bool) {
        if (bool != null)
            return Boolean.TRUE.equals(bool) ? "a" : "b";
        return "c";
    }

    public static void main(String[] args) {
        System.out.println(new Bonus().GetString(true));  // Outputs: "a"
        System.out.println(new Bonus().GetString(false)); // Outputs: "b"
        System.out.println(new Bonus().GetString(null));  // Outputs: "c"
    }
}