import java.util.Scanner;
import java.util.regex.Pattern;

public class RegexValidation{
    static Scanner sc = new Scanner(System.in);

    static boolean validate(String regex, String input){
        return Pattern.matches(regex, input);
    }

    public static void main(String[] args){
        while (true){
            System.out.println("\n1. Mobile\n2. Email\n3. Username\n4. Password\n5. Exit");
            System.out.print("Choice: ");
            int ch = sc.nextInt();
            sc.nextLine();

            try {
                switch(ch){
                    case 1:
                        System.out.print("Enter Mobile: ");
                        System.out.println(validate("[6-9][0-9]{9}", sc.nextLine()) ? "Welcome!" : "Invalid Mobile");
                        break;

                    case 2:
                        System.out.print("Enter Email: ");
                        System.out.println(validate("^[A-Za-z0-9+_.-]+@(.+)$", sc.nextLine()) ? "Welcome!" : "Invalid Email");
                        break;

                    case 3:
                        System.out.print("Enter Username: ");
                        System.out.println(validate("[A-Za-z0-9_]{5,15}", sc.nextLine()) ? "Welcome!" : "Invalid Username");
                        break;

                    case 4:
                        System.out.print("Enter Password: ");
                        System.out.println(validate("(?=.*\\d)(?=.*[A-Z]).{6,}", sc.nextLine()) ? "Welcome!" : "Invalid Password");
                        break;

                    case 5:
                        System.exit(0);
                    default:
                        System.out.println("Invalid Choice");
                }
            } catch (Exception e) {
                System.out.println("Error: " + e.getMessage());
            }
        }
    }
}
