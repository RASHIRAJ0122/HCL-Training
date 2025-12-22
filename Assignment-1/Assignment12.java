
import java.util.Scanner;

public class Assignment12{

    static int[] insert(int arr[], int n, int pos, int value){
        for (int i = n; i > pos; i--){
            arr[i] = arr[i-1];
        }
        arr[pos] = value;
        return arr;
    }

    static int delete(int arr[], int n, int pos){
        for (int i = pos; i < n-1; i++){
            arr[i] = arr[i+1];
        }
        return n-1;
    }

    static void linearSearch(int arr[], int n, int key){
        for (int i = 0; i < n; i++){
            if (arr[i] == key){
                System.out.println("Element found at position: " + i);
                return;
            }
        }
        System.out.println("Element not found");
    }

    static void binarySearch(int arr[], int n, int key){
        int start = 0, end = n-1, mid;
        while (start <= end) {
            mid = (start + end) / 2;
            if (arr[mid] == key){
                System.out.println("Element found at position: " + mid);
                return;
            } else if (arr[mid] < key){
                start = mid+1;
            } else {
                end = mid-1;
            }
        }
        System.out.println("Element not found");
    }

    static void findMax(int arr[], int n){
        int max = arr[0];
        for (int i = 1; i < n; i++){
            if (arr[i] > max)
                max = arr[i];
        }
        System.out.println("Maximum value: " + max);
    }

    static void countEvenOdd(int arr[], int n){
        int even = 0, odd = 0;
        for (int i = 0; i < n; i++){
            if (arr[i] % 2 == 0)
                even++;
            else
                odd++;
        }
        System.out.println("Even count: " + even);
        System.out.println("Odd count: " + odd);
    }

    static void insertionSort(int arr[], int n){
        for (int i = 1; i < n; i++){
            int key = arr[i];
            int j = i - 1;

            while (j >= 0 && arr[j] > key){
                arr[j+1] = arr[j];
                j--;
            }
            arr[j+1] = key;
        }
        System.out.println("Array sorted using Insertion Sort");
    }

    static void display(int arr[], int n){
        System.out.print("Array elements: ");
        for (int i = 0; i < n; i++){
            System.out.print(arr[i] + " ");
        }
        System.out.println();
    }

    public static void main(String[] args){

        Scanner input = new Scanner(System.in);

        System.out.print("Enter size of array: ");
        int n = input.nextInt();

        int arr[] = new int[50];

        System.out.println("Enter array elements:");
        for (int i = 0; i < n; i++) {
            arr[i] = input.nextInt();
        }

        int choice;

        do{
            System.out.println("\n--- MENU ---");
            System.out.println("1. Insert");
            System.out.println("2. Delete");
            System.out.println("3. Linear Search");
            System.out.println("4. Binary Search");
            System.out.println("5. Find Maximum");
            System.out.println("6. Count Even & Odd");
            System.out.println("7. Insertion Sort");
            System.out.println("8. Display");
            System.out.println("9. Exit");

            System.out.print("Enter your choice: ");
            choice = input.nextInt();

            switch(choice){

                case 1:
                    System.out.print("Enter position: ");
                    int pos = input.nextInt();
                    System.out.print("Enter value: ");
                    int value = input.nextInt();
                    arr = insert(arr, n, pos, value);
                    n++;
                    break;

                case 2:
                    System.out.print("Enter position to delete: ");
                    pos = input.nextInt();
                    n = delete(arr, n, pos);
                    break;

                case 3:
                    System.out.print("Enter element to search: ");
                    int key = input.nextInt();
                    linearSearch(arr, n, key);
                    break;

                case 4:
                    System.out.print("Enter element to search: ");
                    key = input.nextInt();
                    binarySearch(arr, n, key);
                    break;

                case 5:
                    findMax(arr, n);
                    break;

                case 6:
                    countEvenOdd(arr, n);
                    break;

                case 7:
                    insertionSort(arr, n);
                    break;

                case 8:
                    display(arr, n);
                    break;

                case 9:
                    System.out.println("Exiting program...");
                    break;

                default:
                    System.out.println("Invalid choice");
            }

        } while(choice != 9);

        input.close();
    }
}
