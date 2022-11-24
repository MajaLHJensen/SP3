import java.util.ArrayList;
import java.util.Scanner;

public class TextUI extends Status{
    protected final Scanner scanner = new Scanner(System.in);
    final FileIO fileIO = new FileIO();

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
                System.out.println('\n' + "Username: ");
                name = scanner.nextLine();
                System.out.println('\n' + "Password: ");
                int password = scanner.nextInt();

                if (fileIO.checkUser(name, password)){
                    System.out.println('\n' + "Welcome Back " + name);
                    scanner.nextLine();
                    break;
                }else{
                    System.out.println("Incorrect username or password");
                }
            }
            if ("2".equals(answer)){
                System.out.println("Create username with only letters: ");
                userName = scanner.nextLine();
                System.out.println("Create password with only numbers: ");
                int userPassword = scanner.nextInt();

                if (fileIO.checkUserSignUp(userName)){
                    fileIO.register(userName, userPassword);
                    scanner.nextLine();
                    System.out.println("Welcome " + userName);
                    System.out.println("please pres ENTER to continue");
                    scanner.nextLine();
                    break;
                }else{
                    System.out.println("");
                    System.out.println("Username does already exist, please login or change username");
                    System.out.println(" ");
                    scanner.nextLine();
                    Main.mainCaller();
                }
                fileIO.register(userName, userPassword);
                scanner.nextLine();
                System.out.println("Welcome to J.E.M.S- Play " + userName);
                System.out.println("Please press ENTER to continue to see your options");
                scanner.nextLine();
                break;
            }
        }
    }

    public void pickMedia(Status status){
        TextUI textUI = new TextUI();
        System.out.println('\n' + "Menu: Choose type of media: ");
        Scanner scan = new Scanner(System.in);
        System.out.println("1-Movies");
        System.out.println("2-Series");
        System.out.println("3-Search");
        System.out.println("4-Watched");
        System.out.println("5-Saved");
        int input = scan.nextInt();


        if(input == 1){
            System.out.println("You choose movies, here's some options");

            if(status.isOnline){

                MediaDB mediaDB = new MediaDB();
                ArrayList<Media> movies = mediaDB.getAllMovies();
                printAllMovies(movies);

            } else if(!status.isOnline){

                FileIO fileIO1 = new FileIO();
                ArrayList<Media> movies = fileIO1.getAllMovies();
                printAllMovies(movies);
            }


        } else if(input == 2){
            System.out.println("You choose series, here's some options");

        } else if(input == 3){
            ArrayList<Media> searchResults = textUI.search();
            for (Media m : searchResults){
                System.out.println(m);
            }
            Scanner src = new Scanner(System.in);
            System.out.println("Please enter the movies full name");
            String nameOfMovie = src.nextLine();
            System.out.println(checkMovieSearch(nameOfMovie, searchResults));

            //In the future, we want to make it start from the top if there is no movies saved or watched.
        } else if(input == 4){
            System.out.println("You choose your watched list: ");

        } else if(input == 5){
            System.out.println("You choose your saved list: ");

        } else{
            System.out.println("Option does not exist, please pick the available options");
            pickMedia(status);
        }
    }

    public void chooseMovie(){
        Scanner c = new Scanner(System.in);
        System.out.println("Please press the number of the movie you want to watch");
        int movieNumberToWatch = c.nextInt();
        System.out.println("you have chosen " + choseResults(movieNumberToWatch));
        //It only work for the csv file and not the sql file.
    }

    public String choseResults(int movieNumberToWatch) {
        FileIO fileIO = new FileIO();
        ArrayList<Media> wannaWatch = fileIO.getAllMovies();
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

    public void movieOption(int input){
        if (input == 1){
            System.out.println("The movie is now playing ");
        } else if (input == 2){
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
        for(Media m : fileIO.getAllMovies()){
            if(m.getName().toLowerCase().contains(searchString.toLowerCase())){
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

    public void printAllMovies(ArrayList<Media> medias)
    {
        for(int i = 0; i < medias.size(); i++)
        {
            System.out.println((i+1) + " - " + medias.get(i));
        }
    }
}