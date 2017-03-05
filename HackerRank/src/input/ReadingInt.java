package input;

import java.util.Scanner;

public class ReadingInt {
    public static void main(String[] args) {
        try(Scanner scanner = new Scanner(System.in)) {
            int numElements = scanner.nextInt();
            int[] arr = new int[numElements];
            for(int i=0; i < numElements; i++) {
                arr[i] = scanner.nextInt();
            }

            for(int i : arr) {
                System.out.println(i);
            }
        }
    }
}
