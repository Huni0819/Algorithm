import java.util.Arrays;
import java.util.Scanner;

public class Main {

    private static Scanner scanner = new Scanner(System.in);
    private static int[] array;

    public static void main(String[] args) {

        int n = scanner.nextInt();
        array = new int[n];

        for(int i = 0; i < n; i++) {
            array[i] = scanner.nextInt();
        }

        Arrays.sort(array);

        Arrays.stream(array)
                .forEach(System.out::println);
    }
}