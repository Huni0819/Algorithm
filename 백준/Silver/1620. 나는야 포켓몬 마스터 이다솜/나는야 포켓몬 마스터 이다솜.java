import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.HashMap;

public class Main {

    public static void main(String[] args) throws Exception {

        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        String[] input = reader.readLine().split(" ");

        HashMap<Integer, String> intMap = new HashMap<>();
        HashMap<String, Integer> strMap = new HashMap<>();

        int N = Integer.parseInt(input[0]);
        int M = Integer.parseInt(input[1]);

        for (int i = 0; i < N; i++) {
            String pokemon = reader.readLine();

            intMap.put(i + 1, pokemon);
            strMap.put(pokemon, i + 1);
        }

        StringBuilder builder = new StringBuilder();
        for (int i = 0; i < M; i++) {
            String line = reader.readLine();

            builder.append(Character.isDigit(line.charAt(0)) ?
                            intMap.get(Integer.parseInt(line)) :
                            strMap.get(line))
                    .append("\n");
        }

        System.out.println(builder);
    }
}