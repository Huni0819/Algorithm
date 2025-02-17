import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.stream.Stream;

public class Main {

    public static void main(String[] args) throws Exception {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int[] now = Stream.of(br.readLine().split(":"))
                .mapToInt(Integer::parseInt)
                .toArray();
        int[] start = Stream.of(br.readLine().split(":"))
                .mapToInt(Integer::parseInt)
                .toArray();

        int nowTime = now[0] * 3600 + now[1] * 60 + now[2];
        int startTime = start[0] * 3600 + start[1] * 60 + start[2];

        int time = startTime > nowTime ? startTime - nowTime :
                (24 * 3600) - (nowTime - startTime);

        System.out.format("%02d:%02d:%02d",
                time / 3600,
                (time / 60) % 60,
                time % 60);
    }
}