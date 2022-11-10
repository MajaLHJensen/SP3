import java.util.ArrayList;

public class Series extends Media
{
    int releaseYear;
    int starRating;
    public int seasons;
    public int episode;
    public String Series;
    //Todo: håndter epusode og season

    public Series(String name, String year, ArrayList<String> category, double rating) {
        super(name, year, category, rating); // add episodes and seasons
    }


    @Override
    public void categories() {

    }
}
