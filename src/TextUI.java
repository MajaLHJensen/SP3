
import java.util.ArrayList;
import java.util.Objects;
import java.util.Scanner;

public class TextUI {
    protected final Scanner scanner = new Scanner(System.in);

    final FileIO fileIO = new FileIO();
    //Use this class to communicate with the user in the future!
    public void startStreaming(){

        System.out.println("Welcome to J.E.M.S Play");
        System.out.println("Press ENTER to login or sign up");

        scanner.nextLine();
        clearTheConsole();

        System.out.println("Do you want to create a new account or login into an existing account? ");
        System.out.println("Press 1 to login ");
        System.out.println("Press 2 to create a new account ");
        String name = "";
        String userName = "";

        while (true){
            String answer = scanner.nextLine();
            if ("1".equals(answer)){
                clearTheConsole();
                System.out.println("Username: ");
                name = scanner.nextLine();
                System.out.println("Password: ");
                int password = scanner.nextInt();

                if (fileIO.checkUser(name, password)){

                    System.out.println("Great!You have officially logged in as ");
                    System.out.println("Welcome Back" + name);
                    System.out.println("please pres ENTER to continue");
                    scanner.nextLine();
                    clearTheConsole();

                    break;
                }else{
                    System.out.println("Incorrect username or password");

                }
            }

            if ("2".equals(answer)){
                clearTheConsole();
                System.out.println("Create username with only letters: ");
                userName = scanner.nextLine();
                System.out.println("Create password with only numbers: ");
                int userPassword = scanner.nextInt();


                if (fileIO.checkUserSignUp(userName))
                {
                    fileIO.register(userName, userPassword);
                    scanner.nextLine();
                    clearTheConsole();
                    System.out.println("Welcome " + userName);
                    System.out.println("please pres ENTER to continue");
                    scanner.nextLine();
                    clearTheConsole();
                    break;
                } else{
                    System.out.println("");
                    System.out.println("Username does already exist, please login or change username");
                    System.out.println(" ");
                    scanner.nextLine();
                    Main.mainCaller();
                }

                fileIO.register(userName, userPassword);
                scanner.nextLine();
                clearTheConsole();
                System.out.println("Welcome to J.E.M.S- Play " + userName);
                System.out.println("Please press ENTER to continue to see your options");
                scanner.nextLine();
                clearTheConsole();
                break;
            }
        }
    }

    public void pickMedia(ArrayList<Media> medias){
        TextUI textUI = new TextUI();
        System.out.println("Menu: Choose type of media: ");
        Scanner scan = new Scanner(System.in);
        System.out.println("1-Movies");
        System.out.println("2-Series");
        System.out.println("3-Search");
        System.out.println("4-Watched");
        System.out.println("5-Saved");
        int input = scan.nextInt();

        if(input == 1){
            System.out.println("You choose movies, here's some options");
            for(int i = 1; i < medias.size(); i++){
                String movieS = i+" - "+medias.get(i).getName();
                System.out.println(movieS);
            }
            textUI.chooseMovie();
            textUI.youHaveChosenMovie();
        }

        else if(input == 2){
            System.out.println("You choose series, here's some options");
        }

        else if(input == 3){
            ArrayList<Media> searchResults = textUI.search();
            for (Media m : searchResults){
                System.out.println(m);
            }

            Scanner src = new Scanner(System.in);
            System.out.println("Please enter the movies full name");
            String nameOfMovie = src.nextLine();
            System.out.println(checkMovieSearch(nameOfMovie, searchResults));
        }

        else if(input == 4){
            System.out.println("You choose your watched list: "); //hvis ikke der er nogle watched
        }

        else if(input == 5){
            System.out.println("You choose your saved list: "); //hvis ikke der er nogle gemte film
        }
        else{
            System.out.println("Option does not exist, please pick the available options");
            pickMedia(medias);
        }
    }

    public void chooseMovie() {
        Scanner c = new Scanner(System.in);
        System.out.println("\n\n");
        System.out.println("Please press the number of the movie you want to watch");
        int movieNumberToWatch = c.nextInt();
        System.out.println("you have chosen " + choseResults(movieNumberToWatch));
    }

    public String choseResults(int movieNumberToWatch) {
        ArrayList<Media> wannaWatch = Collection.movies;
        return wannaWatch.get(movieNumberToWatch).getName();
    }

    public void youHaveChosenMovie() {
        System.out.println("\n\n");
        System.out.println("You now have following choices: ");
        System.out.println("Press 1 if you want to watch the movie ");
        System.out.println("Press 2 if you want to save the movie to your list");
        Scanner scan1 = new Scanner(System.in);
        int input = scan1.nextInt();
        movieOption(input);
    }

    public void movieOption(int input) {
        if (input == 1) {
            System.out.println("The Movie is now playing "); // add the specific name of the movie
        } else if (input == 2)
        {
            System.out.println("The movie has been added to your list ");
        } else {
            System.out.println("Option does not exist, please pick the available options");
        }
    }

    public ArrayList<Media> search(){
        Scanner sc = new Scanner(System.in);
        System.out.println("Please enter the exact name of the movie, you wanna watch");

        String searchString = sc.nextLine();
        return fetchSearchResults(searchString);
    }

    public ArrayList<Media> fetchSearchResults(String searchString){
        ArrayList<Media> searchResults = new ArrayList<>();
        for(Media m : Collection.movies){
            if(m.getName().toLowerCase().contains(searchString.toLowerCase()))
            {
                searchResults.add(m);
            }
        }
        return searchResults;
    }

    public static String checkMovieSearch(String nameOfMovie, ArrayList<Media> searchResults){
        for (Media md : searchResults){
            if (nameOfMovie.equalsIgnoreCase(md.getName())){
                return "Now playing " + nameOfMovie;
            }
        }
        return "Please enter the correct name of the movie";
    }

    public void clearTheConsole(){
        for (int i = 0; i < 100; i++){
            System.out.println();
        }
    }
}