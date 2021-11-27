import java.util.ArrayList;

public class Library {
    private ArrayList<Movie> movies = new ArrayList<>();
    private ArrayList<Watchlist> watchlists = new ArrayList<>();

    public void addMovie(Movie mov) {
        movies.add(mov);
    }

    public void removeMovie(Movie mov) {
        movies.remove(mov);
    }

    public void addWatchlist(Watchlist wlist) {
        watchlists.add(wlist);
    }

    public void removeWatchlist(Watchlist wlist) {
        watchlists.remove(wlist);
    }

}
