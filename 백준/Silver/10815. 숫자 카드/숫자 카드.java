import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

    private static BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
    private static BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(System.out));

    private static StringBuilder builder = new StringBuilder();
    private static int[] cardArray;
    private static int[] numArray;

    public static void main(String[] args) throws Exception {

        cardArray = input();
        numArray = input();

        Arrays.sort(cardArray);

        for (int num : numArray) {
            builder.append(solution(num, 0, cardArray.length - 1) ? "1 " : "0 ");
        }

        writer.write(builder.toString().trim());
        writer.flush();

        reader.close();
        writer.close();
    }

    private static int[] input() throws Exception {
        int n = Integer.valueOf(reader.readLine());

        int[] array = new int[n];

        StringTokenizer st = new StringTokenizer(reader.readLine());

        for(int i = 0; i < n; i++) {
            array[i] = Integer.valueOf(st.nextToken());
        }

        return array;
    }

    private static boolean solution(int num, int low, int high) {


        while (low <= high) {
            int middle = (low + high) / 2;

            if (cardArray[middle] == num) {
                return true;
            }

            low = cardArray[middle] < num ? middle + 1 : low;
            high = cardArray[middle] > num ? middle - 1 : high;
        }

        return false;
    }
}