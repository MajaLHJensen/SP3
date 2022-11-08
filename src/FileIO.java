import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class FileIO {

    public ArrayList<Media> readMovieData() {
        ArrayList<Media> movies = new ArrayList<>();

        try {
            Scanner scan = new Scanner(new File("SP3/data/movieData.csv"));

            while(scan.hasNextLine())
            {
                String line = scan.nextLine();
                System.out.println(line);
                String[] lineData = line.split("; ");

                String movieName = lineData[0];
                String movieYear = lineData[1];
                ArrayList<String> categories = new ArrayList<>();
                String[] categoryArray = lineData[2].split(", ");

                for(int i = 0; i < categoryArray.length-1; i++)
                {
                    categories.add(categoryArray[i]);
                }

                double rating = 0 //(lineData[3]);

                //double rating = //((lineData[3]));
                //toString().length()-1;


                Movies movie = new Movies(movieName, movieYear, categories, rating);
                movies.add(movie);
            }



            //header = scan.nextLine();
            //String stringInput = readMovieData()[0];
            //for (int i = 0; i < movies.length; i++) {
             //   String s = scan.nextLine();
              //  movies[i] = s;
               // if (stringInput.contains(movies[1])) {
               //     System.out.println(movies[0]);
              //  }
            //}
        } catch (FileNotFoundException e) {
            System.out.println(e + "Try again");

        }
        return movies;
    }

//    public String[] readSeriesData() {
//        String[] series = new String[0];
//        String header;
//        try {
//            Scanner scan = new Scanner(new File("data/seriesData.csv"));
//            header = scan.nextLine();
//            String stringInput = readSeriesData()[0];
//            for (int i = 0; i < series.length; i++) {
//                String s = scan.nextLine();
//                series[i] = s;
//                if (stringInput.contains(series[1])) {
//                    System.out.println(series[0]);
//                }
//            }catch(FileNotFoundException e;
//            e){
//                System.out.println(e + "Try again");
//
//            }
//            return series;
//        }

    }




