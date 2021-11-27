import java.util.Set;

public class Client {

    public static void main(String[]args) {

        Movie movie1 = new Movie("parent/directory/HappyMovie.mov", "english", "ABCD Studios");
        Movie movie2 = new Movie("parent/directory/sad/CryingMovie.wmv", "english", "Wannabe Sisters");
        Movie movie3 = new Movie("parent/directory/DrMA.mp4", "french", "ABCD Studios");

        Watchlist w1 = new Watchlist("cheerful");
        Watchlist w2 = new Watchlist("serious");
        Watchlist w3 = new Watchlist("all");

        w1.addMovie(movie1);
        w2.addMovie(movie2);
        w2.addMovie(movie3);
        w3.addMovie(movie1);
        w3.addMovie(movie2);
        w3.addMovie(movie3);

        w3.pop();
        movie3.rename("Drama");
        movie1.addInfo("Released", "1987");
        movie1.addInfo("Director", "unknown");
        movie1.addInfo("Released", "1986");
        movie1.removeInfo("Director");

        Format f1 = movie1.getFormat();
        f1 = Format.AVI;
        System.out.println(movie1.getFormat());

        w3.rename("collection");

        int valMov = w3.countValidMovies();
        Set<String> studios = w3.getStudios();
        Set<String> languages = w3.getLanguages();

        Library lib = new Library();
        lib.addMovie(movie1);
        lib.addMovie(movie2);
        lib.addMovie(movie3);
        lib.addWatchlist(w1);
        lib.addWatchlist(w2);
        lib.addWatchlist(w3);
        lib.removeWatchlist(w3);
    }

}
