

import java.util.ArrayList;
import java.util.Arrays;

public class Movies extends Media {
    String movieID;
    String name;
    String year;
    String categoryDB;
    String rating;

    public Movies(String movieID, String name, String year, String categoryDB, String rating) {
        super (name, year, categoryDB, rating);
        this.movieID = movieID;
        this.name = name;
        this.year = year;
        this.categoryDB = categoryDB;
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