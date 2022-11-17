public class Main{

    static int count = 0;

    public static void main(String[] args){

        StartMenu startMenu = new StartMenu();
        startMenu.startStreaming();


        FileIO fileIO = new FileIO();
        Collection.movies = fileIO.readMovieData();
        User.pickMedia(Collection.movies);

        Options options = new Options();
        options.chooseMovie();
        options.youHaveChosenMovie();
    }


    // The method that calls the main() method, is used to restart in method startStreaming()
    static void mainCaller()
    {
        count++;

        // Calling the main() only 3 times
        if (count < 3) {

            // Calling the main() method
            main(null);
        }
    }

}


//        FOR SERIES BUT DOES NOT WORK!!
//        Collection.series = fileIO.readSeriesData();
//        FileIO fileIO = new FileIO();
//        ArrayList<Media> series =
//        for (Media serie : series) {
//        System.out.println(serie);
//        }