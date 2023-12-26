import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;


class Solution {
    public List<Integer> solution(String[] genres, int[] plays) {
        List<Integer> answer = new ArrayList<>();

        Map<String, Integer> map = new HashMap<>();

        add(map, genres, plays);

        List<Map.Entry<String, Integer>> entries = map.entrySet()
                .stream().sorted(Map.Entry.comparingByValue()).collect(Collectors.toList());

        Collections.reverse(entries);

        for (Map.Entry<String, Integer> entry : entries) {
            select(entry.getKey(), genres, plays, answer);
        }

        return answer;
    }

    private void select(String key, String[] genres, int[] plays, List<Integer> answer) {
        int firstIndex = -1;
        int secondIndex = -1;

        for (int i = 0; i < genres.length; i++) {
            if (genres[i].equals(key)) {
                if (check(firstIndex)) {
                    firstIndex = i;
                } else {
                    if (compare(plays[firstIndex], plays[i])) {
                        if (check(secondIndex)) {
                            secondIndex = i;
                        } else {
                            if (!compare(plays[secondIndex], plays[i])) {
                                secondIndex = i;
                            }
                        }

                    } else {
                        secondIndex = firstIndex;
                        firstIndex = i;
                    }
                }
            }
        }

        if (!check(firstIndex)) {
            answer.add(firstIndex);
        }

        if (!check(secondIndex)) {
            answer.add(secondIndex);
        }
    }

    private boolean compare(int max, int play) {
        return max >= play;
    }

    private boolean check(int index) {
        return index == -1;
    }

    private void add(Map<String, Integer> map, String[] genres, int[] plays) {
        for (int i = 0; i < genres.length; i++) {
            int play = map.getOrDefault(genres[i], 0);

            map.put(genres[i], play + plays[i]);
        }
    }

}