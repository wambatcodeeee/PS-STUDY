import java.util.*;

class Genre implements Comparable<Genre>{
    String name;
    int total;
    
    public Genre(String name, int total){
        this.name = name;
        this.total = total;
    }
    
    public int compareTo(Genre o){
        return o.total - this.total;
    }
}

class Song implements Comparable<Song>{
    int idx;
    int total;
    
    public Song(int idx, int total){
        this.idx = idx;
        this.total = total;
    }
    
    public int compareTo(Song o){
        return o.total - this.total;
    }
}

class Solution {
    public int[] solution(String[] genres, int[] plays) {
        HashMap<String, HashMap<Integer, Integer>> genreMap = new HashMap<>();
        PriorityQueue<Genre> pq = new PriorityQueue<>();
        ArrayList<Integer> al = new ArrayList<>();
        
        for(int i = 0;i < genres.length;i++){
            genreMap.putIfAbsent(genres[i], new HashMap<>());
            genreMap.get(genres[i]).put(i, plays[i]);
        }
        
        for(String genre : genreMap.keySet()){
            int total = 0;
            for(int song : genreMap.get(genre).keySet()){
                total += genreMap.get(genre).get(song);
            }
            pq.add(new Genre(genre, total));
        }
        
        while(!pq.isEmpty()){
            PriorityQueue<Song> pq1 = new PriorityQueue<>();
            Genre current = pq.poll();
            String genreName = current.name;
            
            for(int song : genreMap.get(genreName).keySet()){
                pq1.add(new Song(song, genreMap.get(genreName).get(song)));
            }
            
            for(int i = 0;i < 2 && !pq1.isEmpty();i++){
                Song current1 = pq1.poll();
                al.add(current1.idx);
            }
            
            
        }
        
        int[] arr = al.stream().mapToInt(Integer::intValue).toArray();
        return arr;
    }
}