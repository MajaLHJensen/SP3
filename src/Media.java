import java.util.ArrayList;

abstract public class Media{
    private  final ArrayList<String> category;
    private final String name;
    private final String year;
    private final double rating;

    public String getName(){
        return this.name;
    }

    public Media(String name, String year, ArrayList<String> category, double rating){
        this.category = category;
        this.name = name;
        this.year = year;
        this.rating = rating;
    }

    @Override
    public String toString(){
        return "Media{" +
                "category=" + category +
                ", name='" + name + '\'' +
                ", year='" + year + '\'' +
                ", rating=" + rating +
                '}';
    }
}