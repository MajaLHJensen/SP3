import java.io.*;
import java.util.ArrayList;
import java.util.Scanner;

public class FileIO{

    private Media media;

    protected final Scanner scanner = new Scanner(System.in);
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

    public int chooseMovie()
    {
        Scanner c = new Scanner(System.in);
        System.out.println("\n\n");
        System.out.println("Please press the number of the movie you want to watch");
        int movieIWantToWatch = c.nextInt();
        media = choseResults(movieIWantToWatch);
        System.out.println("you have chosen " + media.getName());
        return movieIWantToWatch;
    }

    public Media choseResults(int movieIWantToWatch)
    {
        ArrayList<Media> wannaWatch = Collection.movies;
        return wannaWatch.get(movieIWantToWatch);
    }

    public void youHaveChosenMovie()
    {
        System.out.println("\n\n");
        System.out.println("You have following choices: ");
        System.out.println("Press 1 if you want to watch the movie ");
        System.out.println("Press 2 if you want to save the movie to your list");
        Scanner scan1 = new Scanner(System.in);
        int input = scan1.nextInt();
        movieOption(input);
    }

    public void movieOption(int input)
    {
        if (input == 1)
        {
            System.out.println("The movie is now playing ");
        } else if (input == 2)
        {
            System.out.println("The movie has been added to your list ");
            UsersSavedMovies(media.getName());
            //save movie to csv
        } else
        {
            System.out.println("Option does not exist, please pick the available options");
        }
    }
    public void UsersSavedMovies(String movie)
    {
        try{
            File file = new File("data/UserLogin.csv");
            if(!file.exists()){
                file.createNewFile();
            }

            FileWriter fw = new FileWriter(file, true);
            fw.write(movie);
            fw.close();

        }catch(IOException e){
            System.out.println("not work"+ e.getMessage());
        }
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








