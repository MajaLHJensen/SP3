import java.util.ArrayList;
import java.util.Scanner;

public class Options {

    public void chooseMovie(){
        Scanner c = new Scanner(System.in);
        System.out.println("\n\n");
        System.out.println("Please press the number of the movie you want to watch");
        int movieNumberToWatch = c.nextInt();
        System.out.println("You have chosen " + choseMovieResults(movieNumberToWatch));
    }

    public String choseMovieResults(int movieNumberToWatch) {
        ArrayList<Media> wannaWatch = Collection.movies;
        return wannaWatch.get(movieNumberToWatch).getName();
    }

    public void youHaveChosenMovie() {
        System.out.println("\n\n");
        System.out.println("You  now have following choices: ");
        System.out.println("Press 1 if you want to watch the movie ");
        System.out.println("Press 2 if you want to save the movie to your list");
        Scanner scan1 = new Scanner(System.in);
        int input = scan1.nextInt();
        movieOption(input);
    }

    public void movieOption(int input) {
        if (input == 1) {
            System.out.println("The movie is now playing "); // add the specific name of the movie
        } else if (input == 2) {
            System.out.println("The movie has been added to your list ");
        }else{
            System.out.println("Option does not exist, please pick the available options");
        }
    }
}