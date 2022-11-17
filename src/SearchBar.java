import java.util.ArrayList;
import java.util.Scanner;


// searchbar for movies only. måske opdøb?
public class SearchBar{

    public ArrayList<Media> Search(){
        Scanner sc = new Scanner(System.in);
        System.out.println("Please enter the exact name of the movie, you wanna watch");

        String searchString = sc.nextLine();
        return FetchSearchResults(searchString);
    }


    public ArrayList<Media> FetchSearchResults(String searchString){
        ArrayList<Media> searchResults = new ArrayList<>();
        for(Media m : Collection.movies){
           if(m.getName().toLowerCase().contains(searchString.toLowerCase()))
            {
                searchResults.add(m);
            }
        }
        return searchResults;
    }
}