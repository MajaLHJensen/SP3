import java.io.*;
import java.util.ArrayList;
import java.util.Scanner;

public class FileIO{

    private Media media;

    protected final Scanner scanner = new Scanner(System.in);
    ArrayList<Media> movies = new ArrayList<>();


    // Arraylist of Media and choose Movie
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








