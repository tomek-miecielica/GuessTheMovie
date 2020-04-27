public class Movie {
    private String title;
    private int index;

    //constructor

    public Movie (String title, int index){
        this.title = title;
        this.index = index;
    }
    public void setTitle(String movieTitle){
        title = movieTitle;
    }
    public void setIndex (int ind){
        index = ind;
    }

    public String getTitle(){
        return title;
    }
    public int getIndex(){
        return index;
    }
    public int getNumOfLetters(){
        return title.length();
    }
    public void printHiddenTitle(int num){
        System.out.println ("");
        for (int i = 1; i<= num; i++){
            System.out.print("_");
        }
    }



}

