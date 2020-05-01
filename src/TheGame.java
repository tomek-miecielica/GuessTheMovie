import java.io.File;
import java.util.ArrayList;
import java.util.Scanner;

public class TheGame {
    private boolean isEnd;
    private int numberOfAttempts;

    //constructor
    public TheGame(boolean isEnd, int numberOfAttempts) {
        this.isEnd = isEnd;
        this.numberOfAttempts = numberOfAttempts;
    }


    public static void main(String[] args) throws Exception{

        TheGame game = new TheGame(false, 10);

        File file = new File("Lista.txt");
        //create the list of movies for the game
        ArrayList<Movie> movieArray  = game.createMovieList(file);

        //pick one of the movies randomly
        int movieCount = movieArray.size();
        int guess = randomMovie(movieCount-1);
        Movie chosenMovie = movieArray.get(guess); //selected movie object
        int numOfLetters = chosenMovie.getNumOfLetters(); //number of letters in the movie

        //hide movie title
        char[] hiddenMovieTitle = game.hideMovieTitle(chosenMovie);

        //start the game
        int wrongLettersGuessed = 0; //number of wrongly guessed letters
        while (wrongLettersGuessed < game.numberOfAttempts && game.isEnd == false) {

            game.displayTheRiddle(numOfLetters,hiddenMovieTitle); //show hidden movie title
            char letter = game.catchUserInput(); // catch user's input'
            boolean letterFound = game.isLetterFound(numOfLetters,letter,chosenMovie,hiddenMovieTitle); //check if correct guess
            wrongLettersGuessed = game.tellIfLetterGuessed(letterFound,wrongLettersGuessed); //tell if correct guess
            game.isEnd = game.gameEnd(hiddenMovieTitle, numOfLetters, '_'); // check if end of the game

        }
        game.displayFinalMessage(game.isEnd); // display end message
    }

   // create a list of movie titles for the game
    public  ArrayList<Movie> createMovieList(File file) throws Exception{
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
            movieCount++;
        }
        return movieArray;
    }


    //generate random movie number
    public static int randomMovie(int num) {
        int movieNumber = (int) (Math.random() * num) + 1;
        return movieNumber;
    }
    //checks if all the letters were guessed in the movie title
    public boolean gameEnd (char[] array, int num, char a){
        boolean isEnd = true;
        for (int i = 0; i < num; i++) {
            if (array[i] == a) {
                isEnd = false;
                break;
            }
        }
        return isEnd;
    }
    //displays final message to the user
    public void displayFinalMessage (boolean gameEnd){
        if (gameEnd) {
            System.out.println("Congrats! You've won!!");
        }
        else {
            System.out.println("I am sorry, you have just lost.");
        }
    }

    //check if user input (letter) is found in the movie title
    public boolean isLetterFound (int numOfLetters, char letter, Movie movie, char[] hiddenMovieTitle){
        boolean correctGuess = false;
        for (int i = 0; i < numOfLetters; i++) { //checks if letter is a part of the title, if so write the letter into the title array
            if (letter == movie.getMovieLetter(i)) {
                hiddenMovieTitle[i] = letter;
                correctGuess = true;
            }
        }
        return correctGuess;
    }
    //display the movie title riddle
    public void displayTheRiddle(int numOfLetters, char[] hiddenMovieTitle ){
        System.out.println("You are guessing: ");
        for (int i = 0; i < numOfLetters; i++) {
            System.out.print(hiddenMovieTitle[i]);
        }
        System.out.println("");
        System.out.println("Guess a letter: ");
    }

    //catch user's input
    public char catchUserInput(){
        Scanner sc = new Scanner(System.in);
        char letter = sc.next().charAt(0); //caught first letter provided by the user
        return letter; // missing validation if user provided more than one letter
    }
    //inform if correct guess & return mistakes
    public int tellIfLetterGuessed(boolean letterFound, int wrongLettersGuessed){
        if (letterFound) {
            System.out.println("Nice! You have guessed correct letter.");
            letterFound = false; //restarting the variable for another round
        } else {
            wrongLettersGuessed++;
        }
        System.out.println("You have guessed (" + wrongLettersGuessed + ") wrong letters.");
        return wrongLettersGuessed;
    }
    // hide movie title in a char array
    public char[] hideMovieTitle(Movie chosenMovie){
        int numOfLetters = chosenMovie.getNumOfLetters(); //number of letters in the movie
        char[] hiddenMovieTitle = new char[numOfLetters];//initializing a char array with hidden movie title
        for (int i = 0; i < numOfLetters; i++){
            hiddenMovieTitle[i] = '_';
        }
        return hiddenMovieTitle;
    }

}

//Duze vs male litery...
//obiektowosc
    // walidacja ze jedna litera
    //usuniecie zbednego kodu
    //Duze litery
    //definicje metod zawieraja nazwy parametrow ktore malo mowia


