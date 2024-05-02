import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.*;

public class Main {

    public static void main(String[] args) throws Exception {

        Solution solution = new Solution();
        solution.input();

        BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(System.out));

        writer.write(solution.output());
        writer.flush();
        writer.close();
    }
}

class Solution {

    private int n;
    private int q;
    private List<Node>[] lists;
    private boolean[] visited;
    private StringBuilder builder = new StringBuilder();

    public void input() throws Exception {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(reader.readLine());

        n = Integer.parseInt(st.nextToken());
        q = Integer.parseInt(st.nextToken());

        lists = new ArrayList[n+1];

        for (int i = 1; i <= n; i++) {
            lists[i] = new ArrayList<>();
        }

        for (int i = 0; i < n-1; i++) {
            st = new StringTokenizer(reader.readLine());

            int p = Integer.parseInt(st.nextToken());
            int q = Integer.parseInt(st.nextToken());
            int r = Integer.parseInt(st.nextToken());

            lists[p].add(new Node(q, r));
            lists[q].add(new Node(p, r));
        }

        for (int i = 0; i < q; i++) {
            st = new StringTokenizer(reader.readLine());

            int k = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());

            solution(k, v);
        }

        reader.close();
    }

    public String output() {
        return builder.toString();
    }

    public void solution(int k, int v) {
        visited = new boolean[n+1];
        Queue<Integer> queue = new LinkedList<>();
        visited[v] = true;
        queue.offer(v);

        int count = 0;

        while (!queue.isEmpty()) {
            int now = queue.poll();

            for (int i = 0; i < lists[now].size() ; i++) {
                if (!visited[lists[now].get(i).getIndex()] && lists[now].get(i).getWeight() >= k) {
                    visited[lists[now].get(i).getIndex()] = true;
                    queue.offer(lists[now].get(i).getIndex());
                    count++;
                }
            }
        }

        builder.append(count).append("\n");
    }
}

class Node {
    private int index;
    private int weight;

    public Node(int index, int weight) {
        this.index = index;
        this.weight = weight;
    }

    public int getIndex() {
        return index;
    }

    public int getWeight() {
        return weight;
    }
}