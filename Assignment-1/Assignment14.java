public class Assignment14{
    public static void main(String[] args){

        String s = "  Hello Java World  ";

        System.out.println("Length: " + s.length());
        System.out.println("Is Empty: " + s.isEmpty());
        System.out.println("CharAt(1): " + s.charAt(1));
        System.out.println("ToString: " + s.toString());
        System.out.println("Equals: " + s.equals("Hello Java World"));
        System.out.println("CompareTo: " + s.compareTo("Hello"));
        System.out.println("Contains: " + s.contains("Java"));
        System.out.println("IndexOf: " + s.indexOf("Java"));
        System.out.println("LastIndexOf: " + s.lastIndexOf("o"));
        System.out.println("StartsWith: " + s.startsWith("  He"));
        System.out.println("EndsWith: " + s.endsWith("  "));
        System.out.println("Matches: " + s.matches(".*Java.*"));
        System.out.println("Substring: " + s.substring(2, 7));
        System.out.println("ToLowerCase: " + s.toLowerCase());
        System.out.println("Trim: " + s.trim());
        System.out.println("Replace: " + s.replace("Java", "Python"));

        String[] parts = s.trim().split(" ");
        System.out.println("Split:");
        for (String p : parts)
            System.out.println(p);

        String joined = String.join("-", parts);
        System.out.println("Join: " + joined);

        int num = 100;
        System.out.println("ValueOf: " + String.valueOf(num));
    }
}
