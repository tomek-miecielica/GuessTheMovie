import java.io.File;
import java.util.ArrayList;
import java.util.Scanner;

public class TheGame {
    public static void main(String[] args) throws Exception{
        File file = new File("Lista.txt");
        Scanner scanner = new Scanner(file);

        //counts # of movies in the file & initiates movie titles as an array
        int movieCount = 0;
        ArrayList<Movie> movieArray = new ArrayList<Movie>();

        while (scanner.hasNextLine()) {
            String line = scanner.nextLine();
            char[] movieName = new char[line.length()];
            for (int i = 0; i < line.length(); i++) { //movie title being written into an array of chars
                movieName[i] = line.charAt(i);
            }
            movieArray.add(new Movie(line, movieCount, movieName)); //movie objects put into one array
            //System.out.println(line);
            movieCount++;
        }
        int guess = randomMovie(movieCount);
        Movie chosenMovie = movieArray.get(guess-1); //selected movie object
        System.out.println(chosenMovie.getTitle());
        int numOfLetters = chosenMovie.getNumOfLetters(); //number of letters in the movie
        char[] hiddenMovieTitle = new char[numOfLetters];//initializing a char array with hidden movie title
        for (int i = 0; i < numOfLetters; i++){
            hiddenMovieTitle[i] = '_';
            //System.out.print(hiddenMovieTitle[i]);
        }

        int wrongLettersGuessed = 0; //number of wrongly guessed letters
        //chosenMovie.hideMovieName(chosenMovie.getMovieName(),numOfLetters);// hide each letter with "_"
        //chosenMovie.printHiddenName(chosenMovie.getMovieName(),numOfLetters); //prints the hidden name

        while (wrongLettersGuessed < 10) {
            System.out.println("You are guessing: ");
            for (int i = 0; i < numOfLetters; i++) {
                System.out.print(hiddenMovieTitle[i]);
            }
            System.out.println("");
            System.out.println("Guess a letter: ");
            Scanner sc = new Scanner(System.in);
            char letter = sc.next().charAt(0); //caught letter provided by the user
            System.out.println(letter);
            boolean correctGuess = false;
            for (int i = 0; i < numOfLetters; i++) { //checks if letter is a part of the title, if so write the letter into the title array
                if (letter == chosenMovie.getMovieLetter(i)) {
                    hiddenMovieTitle[i] = letter;
                    correctGuess = true;
                }
            }
            if (correctGuess) {
                System.out.println("Nice! You have guessed correct letter.");
                correctGuess = false; //restarting the variable for another round
            } else {
                wrongLettersGuessed++;
            }
            System.out.println("You have guessed (" + wrongLettersGuessed + ") wrong letters.");

        }
    }

    //generate random movie number
    public static int randomMovie(int num) {
        int movieNumber = (int) (Math.random() * num) + 1;
        return movieNumber;
    }

    //write an array with "_" marks to hide title
    public char[] hiddenMovieName(char[] array, int num){ //wyrzuc do GameHelper
        for (int i = 0; i < num; i++){
            array[i] = '_';
        }
        return array;
    }

//Duze vs male litery...
//kiedy koniec
}