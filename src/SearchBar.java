import java.util.ArrayList;
import java.util.Scanner;

public class SearchBar extends FileIO
{

    public ArrayList<Media> Search()
    {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the name of the movie, you wanna watch");

        String searchString = sc.nextLine();

        //sc.close();
        return FetchSearchResults(searchString);

    }
    public ArrayList<Media> FetchSearchResults(String searchString)
    {

        ArrayList<Media> searchResults = new ArrayList<>();
        boolean match = false;

        for(Media m : Collection.movies)
        {
           if(m.getName().toLowerCase().contains(searchString.toLowerCase()))
            {
                match = true;
                searchResults.add(m);

            }
        }
        return searchResults;

    }
}

