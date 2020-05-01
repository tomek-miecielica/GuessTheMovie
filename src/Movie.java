public class Movie {
    private String title;
    private int index;
    private char[] movieName;

    //constructor

    public Movie(String title, int index, char[] movieName) {
        this.title = title;
        this.index = index;
        this.movieName = movieName;
    }

    //setters
    public void setTitle(String movieTitle) {
        title = movieTitle;
    }

    public void setIndex(int ind) {
        index = ind;
    }

    //getters
    public String getTitle() {
        return title;
    }

    public int getIndex() {
        return index;
    }

    public int getNumOfLetters() {
        return title.length();
    }

    public char[] getMovieName() {
        return movieName;
    }

    //dodaj error handling by nie byo out of range
    public char getMovieLetter(int i) {
        return movieName[i];
    }
}

