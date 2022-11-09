import java.util.ArrayList;
import java.util.Scanner;

public class SearchBar extends FileIO
{

    public ArrayList<Media> Search()
    {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the name of the movie, you wanna watch");

        String searchString = sc.nextLine();
        sc.close();
        return FetchSearchResults(searchString);
    }
    public ArrayList<Media> FetchSearchResults(String searchString)
    {

        ArrayList<Media> searchResults = new ArrayList<>();

        for(Media m : Collection.movies)
        {
            searchString.equalsIgnoreCase(m.getName());
            if ((m.getName().contains(searchString)));  // FIGURE OUT CASING!
            {
                searchResults.add(m);
            }
        }
        return searchResults;
    }
}