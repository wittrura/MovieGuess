import java.util.Scanner;
import java.io.File;

public class MovieGuesser {

    public static void main (String[] args) {
        boolean hasWon = false;

        FileScanner fileScanner = new FileScanner();
        String[] movies = fileScanner.getArrayOfMovies();

        String movie = movies[(int)(Math.random()*movies.length)];
        String movieHidden = movie.replaceAll("[a-zA-z]", "_");

        System.out.println(movieHidden);

        Scanner scanner = new Scanner(System.in);

        int i = 0;
        while (i <= 10) {
            System.out.print("Guess a letter: ");
            String guess = scanner.next();

            if (movie.toLowerCase().indexOf(guess.charAt(0)) != -1) {
                System.out.println("Correct! You have " + (10 - i) + " guesses left");
                for (int j = 0; j < movie.length(); j++) {
                    if (Character.toLowerCase(movie.charAt(j)) == Character.toLowerCase(guess.charAt(0))) {
                        movieHidden = movieHidden.substring(0, j) + movie.charAt(j) + movieHidden.substring(j + 1);
                    }
                }
            } else {
                i++;
            }

            if (movie.equals(movieHidden)) {
                hasWon = true;
                break;
            }
            System.out.println("You are guessing: " + movieHidden);
        }

        if (hasWon) {
            System.out.println("Congrats - you guess that the movie was " + movie + "!!!");
        } else {
            System.out.println("You lose!!! The correct answer is " + movie);
        }
    }
}
