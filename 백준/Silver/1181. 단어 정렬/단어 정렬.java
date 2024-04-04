import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Comparator;
import java.util.Set;
import java.util.TreeSet;

public class Main {

    private static BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

    public static void main(String[] args) throws Exception {
        Set<String> set = new TreeSet<>();

        int n = Integer.valueOf(reader.readLine());

        for (int i = 0; i < n; i++) {
            set.add(reader.readLine());
        }

        set.stream().sorted(Comparator.comparingInt(String::length)).forEach(System.out::println);
    }
}