import java.util.ArrayList;

public class Movies extends Media {

    public Movies(String name, String year, ArrayList<String> category, double rating){
        super(name, year, category, rating);
    }

    @Override
    public String toString() {
        return super.toString();
    }
}