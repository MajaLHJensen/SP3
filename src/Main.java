import java.util.ArrayList;

public class Main
{
    public static void main(String[] args)
    {

        /*ArrayList<Media>medias = new ArrayList<>();
        medias.add(new Movies());
        Media movie1 = new Movies();
*/

        StartMenu startMenu = new StartMenu();
        startMenu.startStreaming();
        User.pickMedia(null);


        FileIO fileIO = new FileIO();
        ArrayList<Media> movies = fileIO.readMovieData();
        for (Media movie : movies) {
            System.out.println(movie);
        }

        FileIO fileIO2 = new FileIO();
        fileIO2.chooseMovie();

       // FileIO fileIO3 = new FileIO();
       // fileIO3.youHaveChosenMovie();


//        FOR SERIES BUT DOES NOT WORK!!
//        FileIO fileIO = new FileIO();
//        ArrayList<Media> series = fileIO.readSeriesData();
//        for (Media serie : series) {
//            System.out.println(serie);
//        }
    }






    // TODO: 03-11-2022 Lav constructor i Media, så Media kan returneres i metoden savedList
    //public static Media savedList()
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

    static void  searchBar()
    {
        System.out.println();
    }


//oprat alle film / serieer

}