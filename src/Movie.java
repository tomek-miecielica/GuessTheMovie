public class Movie {
    private String title;
    private int index;
    private char[] movieName;

    //constructor

    public Movie (String title, int index, char[] movieName){
        this.title = title;
        this.index = index;
        this.movieName = movieName;
    }

    //setters
    public void setTitle(String movieTitle){
        title = movieTitle;
    }
    public void setIndex (int ind){
        index = ind;
    }
//    public void setMovieName (int size){
//        movieName = new char[size - 1]; // because it starts from 0, not from 1
//    }
    //getters
    public String getTitle(){
        return title;
    }
    public int getIndex(){
        return index;
    }
    public int getNumOfLetters(){
        return title.length();
    }
    public char[] getMovieName(){
        return movieName;
    }
    //dodaj error handling by nie byo out of range
    public char getMovieLetter(int i){
        return movieName[i];
    }


    public static char[] hideMovieName(char[] array, int size){
        for (int i = 0; i < size; i++){
            array[i] = '_';
        }
        return array;
    }
    public static void printHiddenName (char[] array, int size){
        System.out.println("Ypu are guessing: ");
        for (int i = 0; i < size; i++){
            System.out.print(array[i]);
        }
    }



}

