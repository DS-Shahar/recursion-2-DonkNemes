import java.util.*;

public class Recursion2 {
  public static void main(String[] args) {
    Scanner reader = new Scanner(System.in);

    // Array creation and input phase
    System.out.println("How long do you wish the array to be?");
    int length = reader.nextInt();
    int[] arr = new int[length];

    System.out.println("Please enter numbers for the array:");
    for (int i = 0; i < arr.length; i++) {
      System.out.print("Enter value for position " + i + ": ");
      arr[i] = reader.nextInt();
    }

    // השתמשתי בצ'אט גי פי טי כדי ליצור תפריט כזה שיעזור לבחור איזה פונקציה להפעיל בקלות, כל השאר נכתב על ידיי באהבה
    boolean continueProgram = true;
    while (continueProgram) {
      System.out.println("\nChoose a function to activate:");
      System.out.println("1 - Sum up to an index (inception1)");
      System.out.println("2 - Count positive numbers up to an index (inception2)");
      System.out.println("3 - Find element by value inputted(inception3)");
      System.out.println("4 - Check if array is sorted (inception4)");
      System.out.println("5 - Check if array contains any prime numbers (inception5)");
      System.out.println("0 - Exit");
      
      int choice = reader.nextInt();

      switch (choice) {
        case 1:
          System.out.println("Enter the index for the first recursion");
          System.out.println("The sum is " + inception1(arr, reader.nextInt()));
          break;

        case 2:
          System.out.println("Enter the index for the second recursion");
          int index = reader.nextInt();
          System.out.println("The count of positive numbers is " + inception2(arr, index));
          break;

        case 3:
          System.out.println("Enter the element to find in the array");
          int element = reader.nextInt();
          int answer = inception3(arr, element, arr.length - 1);
          if (answer != -1)
            System.out.println("The element is found at index " + answer);
          else
            System.out.println("The element is not present in the array");
          break;

        case 4:
          System.out.println("Checking if the array is sorted...");
          boolean isSorted = inception4(arr, arr.length - 1, arr[arr.length - 1]);
          if (isSorted)
            System.out.println("The array is sorted.");
          else
            System.out.println("The array is not sorted.");
          break;

        case 5:
          System.out.println("Checking if the array contains any prime numbers...");
          boolean noPrime = inception5(arr, arr.length - 1);
          if (noPrime)
            System.out.println("The array doesn't contain any prime numbers");
          else
            System.out.println("The array contains a prime number.");
          break;

        case 0:
          continueProgram = false;
          System.out.println("Exiting the program.");
          break;

        default:
          System.out.println("Invalid choice. Please try again.");
      }
    }
    reader.close();
  }

  static int inception1(int[] arr, int i) {
    if (i == 0) {
      return arr[0];
    }
    return arr[i] + inception1(arr, i - 1);
  }

  static int inception2(int[] arr, int i) {
    if (i < 0)
      return 0; 

    if (arr[i] > 0) 
      return 1 + inception2(arr, i - 1);
    else 
      return inception2(arr, i - 1);
  }

  static int inception3(int[] arr, int n, int i) {
    if (i < 0)
      return -1;

    if (arr[i] == n)
      return i;

    return inception3(arr, n, i - 1);
  }

  static boolean inception4(int[] arr, int i, int smallest) {
    if (i < 0)
      return true;

    if (arr[i] > smallest)
      return false;

    return inception4(arr, i - 1, arr[i]);
  }

  static boolean prime(int x) {
    if (x <= 1)
      return false;
    for (int divisor = 2; divisor * divisor <= x; divisor++) {
      if (x % divisor == 0)
        return false;
    }
    return true;
  }

  static boolean inception5(int[] arr, int i) {
    if (i < 0)
      return true;
    if (prime(arr[i]))
      return false;
    return inception5(arr, i - 1);
  }
}
