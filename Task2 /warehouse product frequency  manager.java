import java.util.*;

class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        HashMap<Integer, Integer> map = new HashMap<>();

        for (int i = 0; i < n; i++) {
            int x = sc.nextInt();
            map.put(x, map.getOrDefault(x, 0) + 1);
        }

        int bestId = Integer.MAX_VALUE;
        int maxFreq = 0;

        for (Map.Entry<Integer, Integer> e : map.entrySet()) {
            int id = e.getKey();
            int freq = e.getValue();

            if (freq > maxFreq || (freq == maxFreq && id < bestId)) {
                maxFreq = freq;
                bestId = id;
            }
        }

        System.out.println(bestId + " " + maxFreq);
    }
}

input
  10
  12 5 12 7 5 12 8 5 7 5
output
  5 4


input
