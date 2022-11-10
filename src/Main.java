import java.util.ArrayList;

public class Main
{
    public static void main(String[] args)
    {
        /*ArrayList<Media>medias = new ArrayList<>();
        medias.add(new Movies());
        Media movie1 = new Movies();
*/
        //StartMenu startMenu = new StartMenu();
        // startMenu.startStreaming();

        StartMenu startMenu = new StartMenu();
        startMenu.startStreaming();

        FileIO fileIO = new FileIO();
        Collection.movies = fileIO.readMovieData();
        // Collection.series = fileIO.readSeriesData();
        //User.pickMedia(null);

        User.pickMedia(Collection.movies);
        //Collections.movies.sort();

        fileIO.chooseMovie();

        fileIO.youHaveChosenMovie();


        // FileIO fileIO3 = new FileIO();
        // fileIO3.youHaveChosenMovie();

//        FOR SERIES BUT DOES NOT WORK!!
//        FileIO fileIO = new FileIO();
//        ArrayList<Media> series =
//        for (Media serie : series) {
//            System.out.println(serie);
//        }
    }

    public static void savedList()
    {
        //StartMenu.startStreaming();
    }

    //public static Media watchedList()
    public static void watchedList()
    {
    }

    static void categories()
    {
        System.out.println();
    }

    static void searchBar()
    {
        System.out.println();
    }

}