package problem42579;

import java.util.*;

public class BestAlbum {
    public static void main(String[] args) {
        var sol = new BestAlbum();
        var genres1 = new String[]{"classic", "pop", "classic", "classic", "pop"};
        var plays1 = new int[]{500, 600, 150, 800, 2500};
        var expected1 = new int[]{4, 1, 3, 0};
        var result1 = sol.solution(genres1, plays1);
        System.out.println("test1: expected: " + Arrays.toString(expected1) + ", result: " + Arrays.toString(result1));
    }

    public int[] solution(String[] genres, int[] plays) {
        var genrePlays = new HashMap<String, Integer>();
        var genreMusic = new HashMap<String, List<HashMap<Integer, Integer>>>();
        for (int i = 0; i < genres.length; i++) {
            var genre = genres[i];
            var play = plays[i];
            genrePlays.put(genre, genrePlays.getOrDefault(genre, 0) + play);

            var music = new HashMap<Integer, Integer>();
            music.put(i, play);
            var list = genreMusic.getOrDefault(genre, new ArrayList<>());
            list.add(music);
            genreMusic.put(genre, list);
        }

        var genreList = new ArrayList<>(List.of(genrePlays.keySet().toArray(String[]::new)));
        genreList.sort((a, b) -> genrePlays.get(b) - genrePlays.get(a));

        var answer = new ArrayList<Integer>();
        for (var genre : genreList) {
            var musicList = genreMusic.get(genre);
            musicList.sort((a, b) -> b.values().iterator().next() - a.values().iterator().next());
            var count = 0;
            for (var music : musicList) {
                answer.add(music.keySet().iterator().next());
                count++;
                if (count == 2) {
                    break;
                }
            }
        }
        return answer.stream().mapToInt(i -> i).toArray();
    }
}
