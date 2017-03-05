package input;

import java.util.Scanner;

public class ReadInput2 {
    public static void main(String[] args) {
        try(Scanner scanner = new Scanner(System.in)) {
            int row = scanner.nextInt();
            int i = scanner.nextInt();
            double d = scanner.nextDouble();
            scanner.nextLine();
            String s = scanner.nextLine();
            System.out.println(i);
            System.out.println(d);
            System.out.println(s.trim());
        }
    }
}