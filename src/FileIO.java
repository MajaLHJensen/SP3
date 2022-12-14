import java.io.*;
import java.util.ArrayList;
import java.util.Scanner;

public class FileIO implements IConnect{
    protected final Scanner scanner = new Scanner(System.in);
    ArrayList<User> users = new ArrayList<>();
    ArrayList<Media> movies = new ArrayList<>();
    File file = new File("data/UserLogin.csv");

    public void register(String userName, int userPassword){
        //Transfer new login to the file(UserLogin.csv) when the user signs up.
        try{
            if (!file.exists()){
                file.createNewFile();
            }
            FileWriter fw = new FileWriter(file, true);
            BufferedWriter bw = new BufferedWriter(fw);
            bw.newLine();
            String userLogin = userName + ", " + userPassword;
            bw.write(userLogin);
            bw.close();
            User newUser = new User(userName, userPassword);
            users.add(newUser);
        } catch (Exception e){
            System.out.println(e);
        }
    }

    public boolean checkUser(String name, int password){
        try{
            File file = new File("data/UserLogin.csv");
            Scanner scanner = new Scanner(file);

            while (scanner.hasNextLine()){
                String line = scanner.nextLine();
                String[] user = line.split(", ");
                String userNameFromFile = user[0];
                int passwordFromFile = Integer.parseInt(user[1]);

                if (name.equals(userNameFromFile))
                    if (password == passwordFromFile)
                        return true;
                System.out.println(name);
                System.out.println("Username does exist");
            }
        }catch (FileNotFoundException e){
            System.out.println("UserLogin.csv does not exist");
            System.out.println("No users found, please register:");
            String userName = scanner.nextLine();
            int userPassword = scanner.nextInt();
            register(userName, userPassword);
            e.printStackTrace();
        }
        scanner.close();
        return false;
    }

    // check user is already registered on UserLogin.csv when they are trying to create a new account
    public boolean checkUserSignUp(String userName){
        try{
            File file = new File("data/UserLogin.csv");
            Scanner scanner = new Scanner(file);
            while (scanner.hasNextLine()){
                String line = scanner.nextLine();
                String[] user = line.split(", ");
                String userNameFromFile = user[0];

                if (userName.equals(userNameFromFile))
                    return false;
            }
        }catch (FileNotFoundException e){
            System.out.println("UserLogin.csv does not exist");
            e.printStackTrace();
        }
        return true;
    }

    public ArrayList<Media> getAllMovies(){
        try{
            //Imports the CSV file(movieData) and creates a scanner to go through it.
            Scanner scan = new Scanner(new File("data/movieData.csv"));
            while (scan.hasNextLine()){
                String line = scan.nextLine();
                String[] lineData = line.split(";");
                String movieName = lineData[0].trim();
                String movieYear = lineData[1].trim();
                // This method splits the String "categories" by its comma separation and goes through the array.
                ArrayList<String> MovieCategory = new ArrayList<>();
                String[] categoryArray = lineData[2].split(", ");
                for (int i = 0; i < categoryArray.length - 1; i++){
                    MovieCategory.add(categoryArray[i]);
                }
                // This method takes the String "rating" replaces the comma with a dot and changes it to a Double.
                String number = lineData[3].trim();
                number = number.replace(',', '.');
                String movieRating = number;
                Movies movie = new Movies(movieName, movieYear, MovieCategory, movieRating);
                movies.add(movie);
            }
        } catch (FileNotFoundException e) {
            System.out.println(e + "Option do not exist.Try again");
        }
        return movies;
    }

    public void printAllMovies(ArrayList<Media> movies)
    {
        for(int i = 0; i < movies.size(); i++)
        {
            System.out.println(movies.get(i));

        }
    }
}