import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws Exception {

        Solution solution = new Solution();
        solution.solution();
    }
}

class Solution {

    public void solution() throws Exception {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(System.out));

        int n = Integer.parseInt(reader.readLine());

        Array arr = new Array();
        StringBuilder builder = new StringBuilder();

        for (int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(reader.readLine());

            switch (st.nextToken()) {
                case "add":
                    arr.add(Integer.parseInt(st.nextToken()));
                    break;
                case "remove":
                    arr.remove(Integer.parseInt(st.nextToken()));
                    break;
                case "check":
                    builder.append(arr.check(Integer.parseInt(st.nextToken()))).append("\n");
                    break;
                case "toggle":
                    arr.toggle(Integer.parseInt(st.nextToken()));
                    break;
                case "all":
                    arr.all();
                    break;
                case "empty":
                    arr.empty();
                    break;
                default:
            }
        }

        writer.write(builder.toString());
        writer.flush();

        writer.close();
        reader.close();
    }
}

class Array {

    private boolean[] array = new boolean[21];

    public void add(int x) {
        array[x] = true;
    }

    public void remove(int x) {
        array[x] = false;
    }

    public int check(int x) {
        return array[x] ? 1 : 0;
    }

    public void toggle(int x) {
        array[x] = !array[x];
    }

    public void all() {
        Arrays.fill(array, true);
    }

    public void empty() {
        Arrays.fill(array, false);
    }
}