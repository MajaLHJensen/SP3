import java.util.ArrayList;
import java.util.Scanner;
public class User extends StartMenu
{
    public String userName;
    public int userPass;


    public User(String userName, int userPass) {

        this.userName = userName;
        this.userPass = userPass;

    }
// getting the username login
    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }
// getting the user password login
    public int getUserPass() {
        return userPass;
    }

    public void setUserPass(int userPass) {
        this.userPass = userPass;
    }

    @Override
    public String toString() {
        return "You are now logged in as: " + userName;



    }


    public static void pickMedia(ArrayList<Media> medias){

        // type of media
        System.out.println("choose type of media: ");

        //our options
        Scanner scan = new Scanner(System.in);
        System.out.println("1-Movies");
        System.out.println("2-Series");
        System.out.println("3-Search");
        System.out.println("4-Watched");
        System.out.println("5-Saved");
        int input = scan.nextInt();

        //used options from user
        if(input == 1){
            System.out.println("You choose movies, here's some options");
        }

        else if(input == 2){
            System.out.println("You choose series, here's some options");
        }

        else if(input == 3){
            System.out.println("you choose searchbar, search any movies or series");
            SearchBar searchBar = new SearchBar();
            ArrayList<Media> searchResults = searchBar.Search();
            for(Media m : searchResults)
            {
                System.out.println(m);
            }
        }

        else if(input == 4){
            System.out.println("You choose your watched list: ");
        }

        else if(input == 5){
            System.out.println("You choose your saved list: ");
        }
        else {
            System.out.println("Option does not exist, please pick the available options");
            pickMedia(medias);
        }


        /*categories - movies - series
        System.out.println("choose category: ");

        for(int i = 0; i < medias.size(); i++){

            medias.get(i);

        }*/





    }
}
