import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class FileIO{

    ArrayList<Media> movies = new ArrayList<>();

    public ArrayList<Media> readMovieData(){
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
                double movieRating = Double.parseDouble(number);

                Movies movie = new Movies(movieName, movieYear, MovieCategory, movieRating);
                movies.add(movie);
            }
        } catch (FileNotFoundException e) {
            System.out.println(e + "Option do not exist.Try again");
        }
        return movies;
    }
}