import java.io.File;

public class Test {

    private enum Format {
        ASD, ABC
    }

    public static void main(String[]args) {

        String filePath = "a.mov";
        String extension = filePath.substring(filePath.length()-3).toUpperCase();
        System.out.println(extension);

        int index = filePath.lastIndexOf('/');
        String title = filePath.substring(index+1, filePath.length() - 4);
        System.out.println(title);

        Boolean valid = false;
        try {
            File movie = new File(filePath);
            if(movie.isFile()) valid = true;
        } catch(Exception FileNotFoundException) {}
        System.out.println(valid);

        String pFile = "asd\\movie.mov";
        pFile = pFile.replace(":\\","\\");
        System.out.println(pFile);


    }
}
