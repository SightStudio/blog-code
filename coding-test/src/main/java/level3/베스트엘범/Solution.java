package level3.베스트엘범;

import java.util.*;

public class Solution {
    public static void main(String[] args) {

        Solution solution = new Solution();

        String[] genres = { "classic", "pop", "classic", "classic", "pop"};
        int[] plays = { 500, 600, 150, 800, 2500 };

        System.out.println(
                Arrays.toString(solution.solution(genres, plays))
        );
    }

    public int[] solution(String[] genres, int[] plays) {
        Map<String, Genre> table = new HashMap<>();
        List<Genre> list;
        List<Integer> result;

        int size = genres.length;
        for (int i = 0; i < size; i++) {
            table.putIfAbsent(genres[i], new Genre(genres[i]));

            table.get(genres[i])
                 .addPlay(new Play(i, plays[i]));
        }

        list = new ArrayList<>(table.keySet().size());
        table.forEach( (key, value) -> list.add(value));
        Collections.sort(list);

        result = new ArrayList<>(list.size() * 2);

        for (Genre g : list) {
            for (int i = 0; i < 2; i++) {
                Play play = g.playQueue.poll();
                if(play != null) {
                    result.add(play.index);
                }
            }
        }
        return result
                .stream()
                .mapToInt(Integer::intValue)
                .toArray();
    }
}

class Genre implements Comparable<Genre>{
    String genre;
    Queue<Play> playQueue;
    int sum;

    public Genre(String genre) {
        this.genre = genre;
        this.playQueue = new PriorityQueue<>();
        this.sum = 0;
    }

    public void addPlay(Play play) {
        this.playQueue.offer(play);
        this.sum += play.playCount;
    }

    @Override
    public int compareTo(Genre o) {
        return  o.sum - this.sum;
    }
}

class Play implements Comparable<Play>{
    int index;
    int playCount;

    public Play(int index, int playCount) {
        this.index = index;
        this.playCount = playCount;
    }

    @Override
    public int compareTo(Play o) {
        return o.playCount -this.playCount;
    }
}