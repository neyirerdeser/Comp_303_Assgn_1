import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;

public class Watchlist {
    private ArrayList<Movie> movies = new ArrayList<>();
    private String name;

    public Watchlist(String name) {
        this.name = name;
    }

    public void addMovie(Movie mov) {
        movies.add(mov);
    }

    public void removeMovie(Movie mov) {
        movies.remove(mov);
    }

    public void pop(){
        this.movies.remove(0);
    }

    public void rename(String name) {
        this.name = name;
    }

    public String getName() {
        return this.name;
    }

    // It should also be possible for a client to access all the movies in the watch list
    // hence the shallow copy
    public ArrayList<Movie> getMovies() {
        return new ArrayList<>(this.movies);
    }
    public int countValidMovies() {
        int valCount = 0;
        for(Movie mov : movies) if(mov.valid) valCount ++;
        return valCount;
    }

    public Set<String> getStudios() {
        Set<String> studios = new HashSet<>();
        for(Movie mov : movies) studios.add(mov.studio);
        return studios;
    }

    public Set<String> getLanguages() {
        Set<String> langs = new HashSet<>();
        for(Movie mov : movies) langs.add(mov.language);
        return langs;
    }
}
