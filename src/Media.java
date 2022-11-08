import java.util.ArrayList;

abstract public class Media
{
    private ArrayList<String> category;
    private String name;
    private String year;
    private double rating;


    public Media(String name, String year, ArrayList<String> category, double rating)
    {
        this.category = category;
        this.name = name;
        this.year = year;
        this.rating = rating;

    }


    public abstract void categories();
    //ENUM??

    // TODO: 03-11-2022 Lav constructor i Media, så Media kan returneres i metoden savedList
    //public static Media savedList()
    public static void savedList()
    {
        ArrayList<Media> savedList = new ArrayList<Media>();
      //  savedList.add(saveMedia());
        //TODO:^
    }


    //public static Media watchedList()
    public static void watchedList()
    {
        ArrayList<Media> watchedList = new ArrayList<Media>();
       // watchedList.add(playMedia());
        //TODO:^
    }


    // hvad vil du med det medie du har valgt; vil du save, play
    // delete saved media

    // når du har play, tilføj til watchdlist


    @Override
    public String toString() {
        return "Media{" +
                "category=" + category +
                ", name='" + name + '\'' +
                ", year='" + year + '\'' +
                ", rating=" + rating +
                '}';
    }
}
