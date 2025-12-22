import java.util.Scanner;
public class Assignment11 {
	
	public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        System.out.print("Enter first number: ");
        int num1 = input.nextInt();

        System.out.print("Enter second number: ");
        int num2 = input.nextInt();

        System.out.println("Addition: " + add(num1, num2));
        System.out.println("Subtraction: " + subtract(num1, num2));
        System.out.println("Multiplication: " + multiply(num1, num2));
        System.out.println("Division: " + divide(num1, num2));
        System.out.println("Remainder: " + remainder(num1, num2));
        System.out.println("Square of first number: " + square(num1));
        System.out.println("Cube of first number: " + cube(num1));
        System.out.println("Absolute value of first number: " + absolute(num1));

        input.close();
    }

    static int add(int a, int b){
        return a + b;
    }

    static int subtract(int a, int b){
        return a - b;
    }

    static int multiply(int a, int b){
        return a * b;
    }

    static int divide(int a, int b){
        return a / b;
    }

    static int remainder(int a, int b){
        return a % b;
    }

    static int square(int a){
        return a * a;
    }

    static int cube(int a){
        return a * a * a;
    }

    static int absolute(int a){
        if (a < 0)
            return -a;
        else
            return a;
    }

}

