import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;

public class Main {

    public static void main(String[] args) throws Exception {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());

        Person[] arr = new Person[N];

        for (int i = 0; i < N; i++) {

            String[] input = br.readLine().split(" ");

            int age = Integer.parseInt(input[0]);

            arr[i] = new Person(age, input[1]);
        }

        Arrays.sort(arr, new Comparator<Person>() {
            @Override
            public int compare(Person o1, Person o2) {
                return o1.age - o2.age;
            }
        });

        StringBuilder sb = new StringBuilder();
        for (Person p : arr) {

            sb.append(p.age)
                    .append(" ")
                    .append(p.name)
                    .append("\n");
        }

        System.out.println(sb);
    }
}

class Person {

    int age;
    String name;

    public Person(int age, String name) {
        this.age = age;
        this.name = name;
    }
}