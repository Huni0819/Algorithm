import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {

    public static void main(String[] args) throws Exception {

        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        int[] arr1 = sum(reader.readLine());
        int[] arr2 = sum(reader.readLine());

        System.out.println(check(arr1, arr2));
    }

    private static int[] sum(String word) {
        int[] arr = new int['z' - 'a' + 1];

        for (char c : word.toCharArray()) {
            arr[c - 'a']++;
        }

        return arr;
    }

    private static int check(int[] arr1, int[] arr2) {

        int count = 0;

        for (int i = 0; i < arr1.length; i++) {
            if (arr1[i] != arr2[i]) {
                count += Math.abs(arr1[i] - arr2[i]);
            }
        }

        return count;
    }
}