import java.util.ArrayList;

public class Movies extends Media {
    String movieID;
    String name;
    String year;
    String str;
    String rating;

    public Movies(String movieID, String name, String year, String str, String rating) {
        super (name, year, str, rating);
        this.movieID = movieID;
        this.name = name;
        this.year = year;
        this.str = str;
        this.rating = rating;

    }

    public Movies(String name, String year, ArrayList<String> category, String rating) {
        super(name, year, String.valueOf(category), rating);
    }


    @Override
    public String toString() {
        return super.toString();
    }
}