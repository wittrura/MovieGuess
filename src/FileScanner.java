import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.Scanner;
import java.io.File;
import java.io.BufferedReader;

public class FileScanner {
    public String[] getArrayOfMovies() {
        int lines = 0;
        try {
            File file = new File("/Users/ryanwittrup/Development/BUILD_AND_BURN/MovieGuesser/src/movies.txt");
            BufferedReader reader = new BufferedReader(new FileReader(file));

            while (reader.readLine() != null) lines++;
            reader.close();
        } catch (Exception e) {
            System.out.println("File missing");
        }

        try {
            File file = new File("/Users/ryanwittrup/Development/BUILD_AND_BURN/MovieGuesser/src/movies.txt");
            Scanner scanner = new Scanner(file);

            String[] movies = new String[lines];
            int i = 0;
            while (scanner.hasNextLine()) {
                String line = scanner.nextLine();
                movies[i] = line;
                i++;
            }
            return movies;
        } catch (Exception  e) {
            System.out.println("File missing");
        }
        String [] errArray = new String[0];
        return errArray;
    }

    public static void main(String[] args) {
    }
}
