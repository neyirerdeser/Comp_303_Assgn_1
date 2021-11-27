import java.io.*;
import java.util.HashMap;
import java.util.Map;

public class Movie {

    final private String filePath;
    private String title;
    final public String language;
    final public String studio;
    private Map<String, String> customInfo = new HashMap<>();
    final private Format format;
    protected boolean valid;  // EVERYTIME a movie is accessed check to see if file is still there and change validity accordingly

    public Movie(String filePath, String language, String studio) {
        assert filePath.length() >= 5; // a.ext is 5 chars
        this.filePath = filePath;
        // set-up the format
        String extension = filePath.substring(filePath.length() - 3);
        switch (extension) {
            case "mp4" -> this.format = Format.MP4;
            case "mov" -> this.format = Format.MOV;
            case "wmv" -> this.format = Format.WMV;
            case "avi" -> this.format = Format.AVI;
            case "flv" -> this.format = Format.FLV;
            case "mkv" -> this.format = Format.MKV;
            default -> throw new AssertionError(this);
        }
        // set-up the title  ::  separate method to rename
        int index = filePath.lastIndexOf('/');
        this.title = filePath.substring(index+1, filePath.length() - 4);
        // assign lang, studio and check if the file is valid
        this.language = language;
        this.studio = studio;
        this.checkValidity();
    }

    public void rename(String title) {
        this.checkValidity();
        this.title = title;
    }

    public String getTitle() {
        return this.title;
    }

    public Map<String, String> getCustomInfo() {
        return new HashMap<>(this.customInfo);
    }

    /////// ASSERTION DO NOT MAKE A DIFFERENCE : cant be bc of object comparison since they fail both ways
    // I am keeping updateInfo in place but addInfo works as both.
    public void addInfo(String key, String value) {
        this.checkValidity();
        assert !this.customInfo.containsKey(key);
        this.customInfo.put(key,value);
    }

    public void updateInfo(String key, String value) {
        this.checkValidity();
        assert this.customInfo.containsKey(key);
        this.customInfo.put(key,value);
    }

    public void removeInfo(String key) {
        this.checkValidity();
        assert this.customInfo.containsKey(key);
        this.customInfo.remove(key);
    }
    /////////

    public boolean checkValidity() {
        this.valid = false;
        try {
            File movie = new File(this.filePath);
            if(movie.isFile()) valid = true;
        } catch(Exception FileNotFoundException) {}
        return valid;
    }

    public Format getFormat() {
        this.checkValidity();
        return this.format;
    }

}
