import java.util.ArrayList;

public class Series extends Media
{
    int releaseYear;
    int starRating;
    public int seasons;
    public int episode;
    public String Series;
    //Todo: håndter epusode og season

    public Series(String name, String year, ArrayList<String> category, double rating, int seasons, int episode) {
        super(name, year, category, rating);
    }


    @Override
    public void categories() {

    }
}
