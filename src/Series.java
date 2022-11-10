import java.util.ArrayList;

//For series. Do not work!
public class Series extends Media{
    int releaseYear;
    int starRating;
    public int seasons;
    public int episode;
    public String Series;

    public Series(String name, String year, ArrayList<String> category, double rating){
        super(name, year, category, rating); // add episodes and seasons
    }
}