import java.util.Scanner;

public class Assignment13{
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter number of rows: ");
        int r = sc.nextInt();
        System.out.print("Enter number of columns: ");
        int c = sc.nextInt();

        int[][] A = new int[r][c];
        int[][] B = new int[r][c];

        System.out.println("Enter elements of Matrix A:");
        for (int i = 0; i < r; i++)
            for (int j = 0; j < c; j++)
                A[i][j] = sc.nextInt();

        System.out.println("Enter elements of Matrix B:");
        for (int i = 0; i < r; i++)
            for (int j = 0; j < c; j++)
                B[i][j] = sc.nextInt();

        System.out.println("\nAddition:");
        for (int i = 0; i < r; i++) {
            for (int j = 0; j < c; j++)
                System.out.print((A[i][j] + B[i][j]) + " ");
            System.out.println();
        }

        System.out.println("\nSubtraction:");
        for (int i = 0; i < r; i++) {
            for (int j = 0; j < c; j++)
                System.out.print((A[i][j] - B[i][j]) + " ");
            System.out.println();
        }

        if (r == c) {
            int[][] mul = new int[r][c];
            for (int i = 0; i < r; i++)
                for (int j = 0; j < c; j++)
                    for (int k = 0; k < c; k++)
                        mul[i][j] += A[i][k] * B[k][j];

            System.out.println("\nMultiplication:");
            for (int i = 0; i < r; i++) {
                for (int j = 0; j < c; j++)
                    System.out.print(mul[i][j] + " ");
                System.out.println();
            }
        }

        System.out.println("\nTranspose of Matrix A:");
        for (int i = 0; i < c; i++) {
            for (int j = 0; j < r; j++)
                System.out.print(A[j][i] + " ");
            System.out.println();
        }

        if (r == c)
            System.out.println("\nMatrix is a Square Matrix");
        else
            System.out.println("\nMatrix is NOT a Square Matrix");

        boolean diagonal = true, identity = true;

        if (r == c) {
            for (int i = 0; i < r; i++) {
                for (int j = 0; j < c; j++) {
                    if (i != j && A[i][j] != 0)
                        diagonal = false;
                    if ((i == j && A[i][j] != 1) || (i != j && A[i][j] != 0))
                        identity = false;
                }
            }
            System.out.println("Diagonal Matrix: " + diagonal);
            System.out.println("Identity Matrix: " + identity);
        }

        sc.close();
    }
}
