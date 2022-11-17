import java.io.*;
import java.util.ArrayList;
import java.util.Scanner;

public class FileIO{

    private Media media;
    protected final Scanner scanner = new Scanner(System.in);
    ArrayList<User> users = new ArrayList<>();
    ArrayList<Media> movies = new ArrayList<>();

    // Arraylist of Media and choose Movie
    public ArrayList<Media> readMovieData(){

        // Load the Movie csv.file and go through the file.
        try{
            Scanner scan = new Scanner(new File("data/movieData.csv"));
            while (scan.hasNextLine()){
                String line = scan.nextLine();
                String[] lineData = line.split(";");

                //  Movie title. Trim to remove space.
                String movieName = lineData[0].trim();

                // Movie year. Trim to remove space.
                String movieYear = lineData[1].trim();

                // Movie categories. Remove space and separate by comma.
                ArrayList<String> categories = new ArrayList<>();
                lineData[2].trim();
                String[] categoryArray = lineData[2].split(", ");
                for (int i = 0; i < categoryArray.length - 1; i++){
                    categories.add(categoryArray[i]);
                }

                // Movie rating. Remove space, change the comma to a dot and change the string to a double.
                String number = lineData[3].trim();
                number = number.replace(',', '.');
                double rating = Double.parseDouble(number);

                Movies movie = new Movies(movieName, movieYear, categories, rating);
                movies.add(movie);
            }
        } catch (FileNotFoundException e)
        {
            System.out.println(e + "Option do not exist.Try again");
        }
        return movies;
    }

    public void register(String userName, int userPassword){

        //Transfer new login to the file(UserLogin.csv) when the user signs up.
        try{
            File file = new File("data/UserLogin.csv");
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
            userName = scanner.nextLine();
            e.printStackTrace();
        }
        return true;
    }
}

//   FOR SERIES BUT DOES NOT WORK!!
//    public ArrayList<Media> readSeriesData(){
//
//        // Create an Arraylist of Media and choose Series
//        ArrayList<Media> series = new ArrayList<>();
//
//        // Load the Series csv.file and go through the file.
//        try {
//            Scanner scan = new Scanner(new File("data/seriesData.csv"));
//            while (scan.hasNextLine()) {
//                String line = scan.nextLine();
//                System.out.println(line);
//                String[] lineData = line.split(";");
//
//                //  Series title. Trim to remove space.
//                String seriesName = lineData[0].trim();
//
//                // ToDO:Series year. Trim to remove space. but something
//                //String seriesYear = lineData[1].trim();
//
//                // Series categories. Remove space and separate by comma.
//                ArrayList<String> categories = new ArrayList<>();
//                lineData[2].trim();
//                String[] categoryArray = lineData[2].split(", ");
//                for (int i = 0; i < categoryArray.length - 1; i++) {
//                    categories.add(categoryArray[i]);
//                }
//                // Series rating. Remove space, change the comma to a dot and change the string to a double.
//                String number = lineData[3].trim();
//                number = number.replace(',', '.');
//                double rating = Double.parseDouble(number);
//
//                //ToDO: Add episodes and seasons
//                Series serie = new Series(seriesName,year categories, rating);
//                series.add(serie);
//            }
//        } catch (FileNotFoundException e) {
//            System.out.println(e + "Option do not exist.Try again");
//        }
//        return series;
//    }








