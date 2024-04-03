import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        List<Integer> list = new ArrayList<>();

        String numberString = br.readLine();

        int number = Integer.valueOf(numberString);

        String line;

        for (int i = 0; i < number; i++) {
            line = br.readLine();

            switch (line) {
                case "pop":
                    if (list.isEmpty()) {
                        System.out.println("-1");
                    } else {
                        System.out.println(list.remove(list.size() - 1));
                    }
                    break;
                case "size":
                    System.out.println(list.size());
                    break;
                case "empty":
                    if (list.isEmpty()) {
                        System.out.println("1");
                    } else {
                        System.out.println("0");
                    }
                    break;
                case "top":
                    if(list.isEmpty()) {
                        System.out.println("-1");
                    } else {
                        System.out.println(list.get(list.size() - 1));
                    }
                    break;

                default:
                    int emptyIndex = line.indexOf(" ");
                    String intWord = line.substring(emptyIndex + 1);

                    list.add(Integer.valueOf(intWord));

            }
        }
    }
}
