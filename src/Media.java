import java.util.ArrayList;

abstract public class Media{
    private ArrayList<String> category;
    private String name;
    private String year;
    private double rating;

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