import com.mysql.jdbc.JDBC4Connection;

import java.util.ArrayList;

public class Main{


    static int count = 0;

    public static void main(String[] args){


        // Here we call the method to welcome the user and log in.
       // TextUI textUI = new TextUI();
       // textUI.startStreaming();

        ArrayList<String> category = new ArrayList<>();

        StringBuffer sb = new StringBuffer();
        for(int i = 0; i < category.size(); i ++)
        {
            sb.append(category.get(i));
        }
        String str = sb.toString();

        MediaDB mediaDB = new MediaDB();
        mediaDB.printMovies();

        //Here we call the method to read the movie data so the user can pick the specific media they want.
        //FileIO fileIO = new FileIO();
        //Collection.movies = fileIO.readMovieData();
        TextUI text = new TextUI();
        text.pickMedia(Collection.movies);
    }

    // The method that calls the main() method, is used to restart in method startStreaming()
    static void mainCaller()
    {
        count++;
        // Calling the main() only 3 times
        if (count < 3) {
            // Calling the main() method
            main(null);
        }
    }

}
