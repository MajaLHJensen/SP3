public class Main{
    public static void main(String[] args){

       // StartMenu startMenu = new StartMenu();
       // startMenu.startStreaming();


        FileIO fileIO = new FileIO();
        Collection.movies = fileIO.readMovieData();
        User.pickMedia(Collection.movies);

        Options options = new Options();
        options.chooseMovie();
        options.youHaveChosenMovie();
    }
}

//        FOR SERIES BUT DOES NOT WORK!!
//        Collection.series = fileIO.readSeriesData();
//        FileIO fileIO = new FileIO();
//        ArrayList<Media> series =
//        for (Media serie : series) {
//        System.out.println(serie);
//        }