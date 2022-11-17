public class Main{
    public static void main(String[] args){

        // Here we call the method to welcome the user and log in.
        StartMenu startMenu = new StartMenu();
        startMenu.startStreaming();

        //Here we call the method to read the movie data so the user can pick the specific media they want.
        FileIO fileIO = new FileIO();
        Collection.movies = fileIO.readMovieData();
        User.pickMedia(Collection.movies);

        // Here we call the methods for the user to chose what to do with the chosen media
        Options options = new Options();
        options.chooseMovie();
        options.youHaveChosenMovie();
    }
}
