import java.util.ArrayList;
import java.util.Scanner;
public class User extends FileIO {

    public String userName;
    public int userPass;

    public User(String userName, int userPass){
        this.userName = userName;
        this.userPass = userPass;
    }

    public String getUserName(){
        return userName;
    }

    public void setUserName(String userName){
        this.userName = userName;
    }

    public int getUserPass(){
        return userPass;
    }

    public void setUserPass(int userPass){
        this.userPass = userPass;
    }

    @Override
    public String toString(){
        return "You are now logged in as: " + userName;
    }

    public static void pickMedia(ArrayList<Media> medias){

        System.out.println("choose type of media: ");

        Scanner scan = new Scanner(System.in);
        System.out.println("1-Movies");
        System.out.println("2-Series");
        System.out.println("3-Search");
        System.out.println("4-Watched");
        System.out.println("5-Saved");
        int input = scan.nextInt();

        if(input == 1){
            System.out.println("You choose movies, here's some options");
            for(int i = 0; i < medias.size(); i++){
                String movieS = i+" - "+medias.get(i).getName();
                System.out.println(movieS);
            }
            FileIO fileIO = new FileIO();
            fileIO.chooseMovie();
            fileIO.youHaveChosenMovie();
        }

        else if(input == 2){
            System.out.println("You choose series, here's some options");
        }

        else if(input == 3){
            SearchBar searchBar = new SearchBar();
            ArrayList<Media> searchResults = searchBar.Search();
            for (Media m : searchResults){
                System.out.println(m);
            }

            Scanner src = new Scanner(System.in);
            System.out.println("Please enter the movies full name");
            String nameOfMovie = src.nextLine();
            System.out.println(checkMovieSearch(nameOfMovie, searchResults));
        }

        else if(input == 4){
            System.out.println("You choose your watched list: ");
        }

        else if(input == 5){
            System.out.println("You choose your saved list: ");
        }
        else{
            System.out.println("Option does not exist, please pick the available options");
            pickMedia(medias);
        }
    }

    public static String checkMovieSearch(String nameOfMovie, ArrayList<Media> searchResults){
        for (Media md : searchResults){
            if (nameOfMovie.equalsIgnoreCase(md.getName())){
                return "Now playing " + nameOfMovie;
            }
        }
        return "Please enter the correct name of the movie";
    }
}
