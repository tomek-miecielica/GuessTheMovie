import java.io.File;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class TheGame {
    public static void main(String[] args) throws Exception{
        File file = new File("Lista.txt");
        Scanner scanner = new Scanner(file);

        //counts # of movies in the file & initiates movies as an array
        int movieCount = 0;
        ArrayList<Movie> movieArray = new ArrayList<Movie>();

        while (scanner.hasNextLine()) {
            String line = scanner.nextLine();
            movieArray.add(new Movie(line, movieCount));
            System.out.println(line);
            movieCount++;
        }
        int guess = randomMovie(movieCount);
        int numOfLetters = movieArray.get(guess-1).getNumOfLetters();
        System.out.println ("The movie has: " + numOfLetters + " letters");
        System.out.println("the movie number is: " + guess);
        movieArray.get(guess-1).printHiddenTitle(numOfLetters);

        System.out.println("count is: " + movieCount);

// array z literami nazwy filmu
// wyszukiwanie, ktre zwraca numer gdzie jest dana litera (a co jak duplikaty??
// odgadniete litery wstawiamy do array zamiasst "_" i wyswietlamy

    }

    //generate random movie number
    public static int randomMovie(int num) {
        int movieNumber = (int) (Math.random() * num) + 1;
        return movieNumber;
    }




}